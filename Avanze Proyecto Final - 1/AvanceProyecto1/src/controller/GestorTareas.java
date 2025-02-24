package controller;

import java.io.IOException;
import model.Nodo;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
/* Importamos para exportar a PDF*/
import model.ListaEnlazada;
import model.Tarea;
import model.Nodo;
import clases.ValidadorTareas;
import clases.Prioridad;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import java.io.File;
import java.util.Scanner;
/* Importamos las clases adicionales para los CRUD */
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
/* Importamos para el logo */
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
/* Importamos para la fecha */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que gestiona las operaciones del sistema de tareas pendientes. Permite
 * agregar, listar, buscar y eliminar tareas, además de validar datos de
 * entrada.
 *
 * @author daniel
 */
public class GestorTareas {

    private ListaEnlazada lista; // Lista enlazada para almacenar las tareas
    private ListaEnlazada historialTareas; // Lista para almacenar las tareas completadas
    private Scanner scanner = new Scanner(System.in); // Scanner para la entrada de datos del usuario

    /**
     * Constructor que inicializa la lista enlazada para gestionar las tareas.
     */
    public GestorTareas() {
        lista = new ListaEnlazada();
        historialTareas = new ListaEnlazada(); // Inicializamos la lista de historial
    }

    /**
     * Método para agregar una nueva tarea con validación de datos.
     *
     * @param descripcion Descripción de la tarea.
     * @param prioridad Nivel de prioridad de la tarea (Alta, Media, Baja).
     */
    public void agregarTarea(String descripcion, String prioridad) {
        imprimirLineaDecorativa();
        if (!ValidadorTareas.validarDescripcion(descripcion)) {
            System.out.println("⚠️  La descripción de la tarea no puede estar vacía.");
            pausar();
            return;
        }
        if (!ValidadorTareas.validarPrioridad(prioridad)) {
            System.out.println("⚠️  Prioridad no válida. Debe ser Alta, Media o Baja.");
            pausar();
            return;
        }
        lista.agregar(new Tarea(descripcion, prioridad));
        System.out.println("✅ Tarea agregada exitosamente.");
        imprimirLineaDecorativa();

        exportarTareasATxt(); // 🔹 Se exporta automáticamente después de agregar una tarea
        pausar();
    }

    /**
     * Método para listar todas las tareas pendientes almacenadas en la lista
     * enlazada.
     */
    public void listarTareas() {
        imprimirLineaDecorativa();
        lista.listarTareas();
        imprimirLineaDecorativa();
        pausar();
    }

    /**
     * Método para completar (eliminar) una tarea de la lista. Si la tarea no se
     * encuentra, sugiere tareas similares.
     *
     * @param descripcion Descripción de la tarea a eliminar.
     */
    public void completarTarea(String descripcion) {
        Tarea tarea = lista.buscarTarea(descripcion);
        if (tarea != null && tarea.getEstado().equals("En Progreso")) {
            tarea.setEstado("Completada");
            lista.eliminarTarea(tarea.getDescripcion());
            historialTareas.agregar(tarea);
            System.out.println("✅ Tarea completada y movida al historial: " + tarea.getDescripcion());

            exportarTareasATxt(); // 🔹 Se exporta automáticamente después de completar una tarea
        } else {
            System.out.println("❌ Solo se pueden completar tareas que están en progreso.");
        }
    }

    private void agregarMarcaDeAgua(PDPageContentStream contentStream, PDPage page, PDType0Font font, String texto) throws IOException {
        contentStream.setFont(font, 14); // 🔹 Reducimos tamaño para que no sea invasivo

        // 🔹 Color gris claro para que se vea como una marca de agua discreta
        contentStream.setNonStrokingColor(0.6f, 0.6f, 0.6f); // 🔹 Un poco más oscuro para que sea visible

        // 🔹 Posicionar el footer en la parte inferior de la página
        float pageWidth = page.getMediaBox().getWidth();
        float posY = 30; // 🔹 Asegura que esté cerca del borde inferior

        contentStream.beginText();
        contentStream.newLineAtOffset(pageWidth / 3, posY); // 🔹 Centrar horizontalmente
        contentStream.showText(texto);
        contentStream.endText();

        // 🔹 Restaurar el color del texto a negro para evitar afectar el contenido
        contentStream.setNonStrokingColor(0, 0, 0);
    }

    private void agregarFooter(PDPageContentStream contentStream, PDPage page, PDType0Font font) throws IOException {
        contentStream.setFont(font, 12); // 🔹 Tamaño del texto en el footer
        contentStream.setNonStrokingColor(0.6f, 0.6f, 0.6f); // 🔹 Color gris claro

        // 🔹 Obtener la fecha y hora actual
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaHora = ahora.format(formato);

        // 🔹 Texto del footer con fecha y hora
        String texto = "Proyecto hecho por Daniel Esteban Huaman Lazaro - " + fechaHora;

        // 🔹 Obtener el ancho de la página
        float pageWidth = page.getMediaBox().getWidth();
        float posY = 30; // 🔹 Posición cerca del borde inferior

        // 🔹 Medir el ancho del texto para centrarlo
        float textWidth = font.getStringWidth(texto) / 1000 * 12; // Escalar la fuente correctamente

        // 🔹 Calcular la posición X para que el texto quede centrado
        float posX = (pageWidth - textWidth) / 2;

        contentStream.beginText();
        contentStream.newLineAtOffset(posX, posY); // 🔹 Ahora estará completamente centrado
        contentStream.showText(texto);
        contentStream.endText();

        // 🔹 Restaurar el color del texto a negro para evitar afectar el contenido
        contentStream.setNonStrokingColor(0, 0, 0);
    }

    public void exportarTareasAPdf() {
        String nombreArchivo = "tareas_exportadas.pdf";
        File archivo = new File(nombreArchivo);

        // Elimina el archivo si ya existe
        if (archivo.exists()) {
            archivo.delete();
        }

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDType0Font font = PDType0Font.load(document, new File("fonts/NotoSans-Regular.ttf"));

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.OVERWRITE, true, true)) {

                // 🔹 Dibujar el encabezado de color en la parte superior
                float headerHeight = 50;
                contentStream.setNonStrokingColor(173 / 255f, 216 / 255f, 230 / 255f); // 🔹 Color azul claro
                contentStream.addRect(0, page.getMediaBox().getHeight() - headerHeight, page.getMediaBox().getWidth(), headerHeight);
                contentStream.fill();

                // 🔹 Restaurar color a negro
                contentStream.setNonStrokingColor(0, 0, 0);

                // 🔹 Cargar y colocar el logo dentro del encabezado
                PDImageXObject logo = PDImageXObject.createFromFile("src/resources/logo2.png", document);
                float logoWidth = 40;  // 🔹 Ajustar tamaño del logo
                float logoHeight = 40;
                float logoX = page.getMediaBox().getWidth() - logoWidth - 10; // 🔹 Posición en la esquina derecha
                float logoY = page.getMediaBox().getHeight() - logoHeight - 5;
                contentStream.drawImage(logo, logoX, logoY, logoWidth, logoHeight);

                // 🔹 Agregar el título "Gestión de Tareas" en el encabezado
                contentStream.setFont(font, 14);
                contentStream.beginText();
                contentStream.newLineAtOffset(20, page.getMediaBox().getHeight() - 30); // 🔹 Posición en la izquierda
                contentStream.showText("Sistema de Gestión de Tareas Pendientes");
                contentStream.endText();

                // 🔹 Agregar el contenido después del encabezado
                int y = 700;
                y = escribirTareasEnPdf(contentStream, "Tareas Pendientes:", "Pendiente", y, font);
                y = escribirTareasEnPdf(contentStream, "Tareas en Progreso:", "En Progreso", y, font);
                y = escribirTareasEnPdf(contentStream, "Tareas Completadas:", "Completada", y, font);

                // 🔹 Agregar el footer con "Proyecto hecho por Daniel Huaman"
                agregarFooter(contentStream, page, font);
            }

            document.save(nombreArchivo);
            System.out.println("✅ PDF exportado correctamente con encabezado, logo y footer: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("❌ Error al exportar a PDF: " + e.getMessage());
        }
    }

    public void mostrarHistorialTareas() {
        imprimirLineaDecorativa();
        System.out.println("📜 Historial de Tareas Completadas:");
        if (historialTareas.getCabeza() == null) {
            System.out.println("📌 No hay tareas completadas aún.");
        } else {
            Nodo actual = historialTareas.getCabeza();
            while (actual != null) {
                System.out.println("✔️ " + actual.tarea.getDescripcion() + " | ⏫ Prioridad: " + actual.tarea.getPrioridad());
                actual = actual.siguiente;
            }
        }
        imprimirLineaDecorativa();
        pausar();
    }

    public void exportarTareasATxt() {
        String nombreArchivo = "tareas_exportadas.txt";

        System.out.println("📂 Exportando tareas a: " + nombreArchivo);

        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            writer.println("=== Lista de Tareas ===\n");

            // Guardar tareas pendientes
            writer.println("📌 Tareas Pendientes:");
            guardarTareasPorEstado(writer, "Pendiente");

            // Guardar tareas en progreso
            writer.println("\n⏳ Tareas en Progreso:");
            guardarTareasPorEstado(writer, "En Progreso");

            // Guardar tareas completadas
            writer.println("\n✅ Tareas Completadas:");
            guardarTareasPorEstado(writer, "Completada");

            System.out.println("✅ Tareas exportadas correctamente.");
        } catch (IOException e) {
            System.out.println("❌ Error al exportar tareas: " + e.getMessage());
        }
    }

    /**
     * Método auxiliar para escribir tareas de un estado específico en el
     * archivo.
     */
    private void guardarTareasPorEstado(PrintWriter writer, String estado) {
        Nodo actual = lista.getCabeza();
        boolean hayTareas = false;

        while (actual != null) {
            if (actual.tarea.getEstado().equals(estado)) {
                String tareaTexto = "📋 " + actual.tarea.getDescripcion() + " | Prioridad: " + actual.tarea.getPrioridad();
                writer.println(tareaTexto);
                System.out.println("📝 Guardando tarea: " + tareaTexto); // Depuración
                hayTareas = true;
            }
            actual = actual.siguiente;
        }

        if (!hayTareas) {
            writer.println("📭 No hay tareas en este estado.");
        }
    }

    /**
     * Método auxiliar para escribir y mostrar tareas de un estado específico.
     */
    private void guardarTareasPorEstado(PrintWriter writer, String estado, boolean mostrarEnConsola) {
        Nodo actual = lista.getCabeza();
        boolean hayTareas = false;

        while (actual != null) {
            if (actual.tarea.getEstado().equals(estado)) {
                String tareaTexto = "📋 " + actual.tarea.getDescripcion() + " | Prioridad: " + actual.tarea.getPrioridad();
                writer.println(tareaTexto);
                if (mostrarEnConsola) {
                    System.out.println(tareaTexto);
                }
                hayTareas = true;
            }
            actual = actual.siguiente;
        }

        if (!hayTareas) {
            writer.println("📭 No hay tareas en este estado.");
            if (mostrarEnConsola) {
                System.out.println("📭 No hay tareas en este estado.");
            }
        }
    }

    private String eliminarEmojis(String texto) {
        return texto.replaceAll("[^\\p{ASCII}]", ""); // 🔹 Elimina cualquier carácter fuera del estándar ASCII
    }

    /**
     * Método auxiliar escribe las tareas dentro del PDF en la posición
     * correcta.
     */
    private int escribirTareasEnPdf(PDPageContentStream contentStream, String titulo, String estado, int startY, PDType0Font font) throws IOException {
        contentStream.setFont(font, 14); // Tamaño de fuente mayor
        int y = startY;

        // Escribir el título de la sección
        contentStream.beginText();
        contentStream.newLineAtOffset(100, y);
        contentStream.showText(eliminarEmojis(titulo));
        contentStream.endText();

        y -= 40; // Espacio después del título

        boolean hayTareas = false;
        Nodo actual = lista.getCabeza();
        while (actual != null) {
            if (actual.tarea.getEstado().equals(estado)) {
                hayTareas = true;
                String descripcionLimpia = eliminarEmojis(actual.tarea.getDescripcion());
                String prioridadLimpia = eliminarEmojis(actual.tarea.getPrioridad());

                contentStream.beginText();
                contentStream.newLineAtOffset(120, y);
                contentStream.showText(descripcionLimpia + " | Prioridad: " + prioridadLimpia);
                contentStream.endText();

                y -= 30; // Espaciado entre cada tarea
            }
            actual = actual.siguiente;
        }

        if (!hayTareas) {
            contentStream.beginText();
            contentStream.newLineAtOffset(120, y);
            contentStream.showText("No hay tareas en este estado.");
            contentStream.endText();
            y -= 30;
        }

        y -= 50; // Espacio extra antes de la siguiente sección
        return y;
    }

    public void cargarTareasDesdeTxt() {
        String nombreArchivo = "tareas_exportadas.txt";

        System.out.println("📂 Intentando cargar tareas desde: " + nombreArchivo);

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            String estadoActual = ""; // Almacena en qué sección del archivo estamos leyendo

            while ((linea = reader.readLine()) != null) {
                System.out.println("🔍 Leyendo línea: " + linea); // Depuración

                if (linea.startsWith("📌 Tareas Pendientes:")) {
                    estadoActual = "Pendiente";
                } else if (linea.startsWith("⏳ Tareas en Progreso:")) {
                    estadoActual = "En Progreso";
                } else if (linea.startsWith("✅ Tareas Completadas:")) {
                    estadoActual = "Completada";
                } else if (linea.startsWith("📋")) { // Detectar líneas con tareas
                    String[] partes = linea.split("\\|"); // Separar descripción y prioridad

                    if (partes.length == 2) {
                        String descripcion = partes[0].replace("📋", "").trim();
                        String prioridad = partes[1].replace("Prioridad:", "").trim();

                        Tarea tarea = new Tarea(descripcion, prioridad);
                        tarea.setEstado(estadoActual); // 🔹 Establecemos el estado correcto

                        // 🔹 Agregar la tarea a la lista correspondiente
                        if (estadoActual.equals("Pendiente") || estadoActual.equals("En Progreso")) {
                            lista.agregar(tarea);
                            System.out.println("✅ Tarea agregada: " + descripcion + " | " + prioridad);
                        } else if (estadoActual.equals("Completada")) {
                            historialTareas.agregar(tarea);
                            System.out.println("✅ Tarea completada agregada al historial: " + descripcion);
                        }
                    }
                }
            }
            System.out.println("✅ Tareas cargadas desde el archivo.");
        } catch (IOException e) {
            System.out.println("⚠️  No se encontró el archivo. Se iniciará con una lista vacía.");
        }
    }

    /**
     * Método privado para sugerir tareas similares si no se encuentra una
     * coincidencia exacta.
     *
     * @param descripcion Descripción de la tarea buscada.
     */
    private void sugerirTareasSimilares(String descripcion) {
        System.out.println("🔍 ¿Quizás quisiste decir?");
        Nodo actual = lista.getCabeza();
        boolean encontrado = false;
        while (actual != null) {
            if (actual.tarea.getDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
                System.out.println("- " + actual.tarea.getDescripcion() + " | Prioridad: " + actual.tarea.getPrioridad());
                encontrado = true;
            }
            actual = actual.siguiente;
        }
        if (!encontrado) {
            System.out.println("❗ No se encontraron tareas similares.");
        }
    }

    public void mostrarTareasPorEstado() {
        System.out.println("📌 Tareas Pendientes:");
        mostrarPorEstado("Pendiente");
        System.out.println("\n⏳ Tareas en Progreso:");
        mostrarPorEstado("En Progreso");
        System.out.println("\n✅ Tareas Completadas:");
        mostrarPorEstado("Completada");
    }

    private void mostrarPorEstado(String estado) {
        Nodo actual = lista.getCabeza();
        boolean hayTareas = false;
        while (actual != null) {
            if (actual.tarea.getEstado().equals(estado)) {
                System.out.println("📋 " + actual.tarea.getDescripcion() + " | Prioridad: " + actual.tarea.getPrioridad());
                hayTareas = true;
            }
            actual = actual.siguiente;
        }
        if (!hayTareas) {
            System.out.println("📭 No hay tareas en este estado.");
        }
    }

    /**
     * Método para buscar una tarea por su descripción. Si no se encuentra,
     * sugiere tareas similares.
     *
     * @param descripcion Descripción de la tarea a buscar.
     */
    public void buscarTarea(String descripcion) {
        imprimirLineaDecorativa();
        Tarea tarea = lista.buscarTarea(descripcion);
        if (tarea != null) {
            System.out.println("🔎 Tarea encontrada:");
            System.out.println("📋 " + tarea.getDescripcion() + " | ⏫ Prioridad: " + tarea.getPrioridad());
        } else {
            System.out.println("❌ Tarea no encontrada.");
            sugerirTareasSimilares(descripcion);
        }
        imprimirLineaDecorativa();
        pausar();
    }

    public void moverTareaAEnProgreso(String descripcion) {
        Tarea tarea = lista.buscarTarea(descripcion);
        if (tarea != null && tarea.getEstado().equals("Pendiente")) {
            tarea.setEstado("En Progreso");
            System.out.println("🔄 Tarea ahora está en progreso: " + tarea.getDescripcion());

            exportarTareasATxt(); // 🔹 Se exporta automáticamente después de mover una tarea
        } else {
            System.out.println("❌ No se encontró una tarea pendiente con esa descripción.");
        }
    }

    /**
     * Método para imprimir una línea decorativa que separa las secciones de la
     * interfaz.
     */
    private void imprimirLineaDecorativa() {
        System.out.println("=====================================");
    }

    /**
     * Método para pausar la ejecución y esperar que el usuario presione Enter
     * para continuar.
     */
    private void pausar() {
        System.out.println("Presiona Enter para continuar...");
        scanner.nextLine();
        limpiarPantalla();
    }

    /**
     * Método para simular la limpieza de pantalla mediante saltos de línea.
     */
    private void limpiarPantalla() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    /**
     * Método para mostrar únicamente las tareas pendientes sin pausas ni
     * decoraciones.
     */
    public void mostrarTareasPendientes() {
        Nodo actual = lista.getCabeza();
        if (actual == null) {
            System.out.println("📌 No hay tareas pendientes.");
            return;
        }
        while (actual != null) {
            System.out.println("📋 " + actual.tarea.getDescripcion() + " | ⏫ Prioridad: " + actual.tarea.getPrioridad());
            actual = actual.siguiente;
        }
    }

}
