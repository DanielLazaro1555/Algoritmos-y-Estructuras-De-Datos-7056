![Descripción de la imagen](./Imagenes/Logo/LogoUTPMax.png)

# ALGORITMOS Y ESTRUCTURAS DE DATOS (100000SI42)

## Avance del Proyecto

**Sistema de Gestión de Tareas Pendientes**

**Docente:** Luis Alberto Loo Parian  
**Estudiante:** Daniel Esteban Huamán Lázaro  
**Año:** 2025

---

## ÍNDICE

- [INTRODUCCIÓN](#1-introducción)
- [CAPÍTULO 1 – ASPECTOS GENERALES](#capítulo-1--aspectos-generales)
  - [1.1 Descripción de la Organización](#11-descripción-de-la-organización)
  - [1.2 Misión y Visión](#12-misión-y-visión)
  - [1.3 Arquitectura Tecnológica Actual](#13-arquitectura-tecnológica-actual)
- [CAPÍTULO 2 – MARCO TEÓRICO](#capítulo-2--marco-teórico)
  - [2.1 Tecnologías para Desarrollo de Software](#21-tecnologías-para-desarrollo-de-software)
  - [2.2 Arquitecturas de Software](#22-arquitecturas-de-software)
  - [2.3 Metodologías de Desarrollo de Software](#23-metodologías-de-desarrollo-de-software)
  - [2.4 Aplicaciones de Algoritmos con Estructuras de Datos](#24-aplicaciones-de-algoritmos-con-estructuras-de-datos)
- [CAPÍTULO 3 – GESTIÓN DEL PROYECTO](#capítulo-3--gestión-del-proyecto)
  - [3.1 Objetivos](#31-objetivos)
  - [3.2 Descripción del Problema](#32-descripción-del-problema)
  - [3.3 Alcance del Proyecto](#33-alcance-del-proyecto)
- [CAPÍTULO 4 – IMPLEMENTACIÓN DE ESTRATEGIA](#capítulo-4--implementación-de-estrategia)
  - [4.1 Lista de Requerimientos](#41-lista-de-requerimientos)
  - [4.2 Prototipo Preliminar](#42-prototipo-preliminar)
  - [4.3 Prototipo Funcional](#43-prototipo-funcional)
  - [4.4 Desarrollo de la Aplicación](#44-desarrollo-de-la-aplicación)
    - [4.4.1 Validación de Entradas y Manejo de Errores](#441-validación-de-entradas-y-manejo-de-errores)
    - [4.4.2 Gestión de Tareas por Estado](#442-gestión-de-tareas-por-estado)
    - [4.4.3 Historial de Tareas Completadas](#443-historial-de-tareas-completadas)
    - [4.4.4 Exportación de Tareas en PDF](#444-exportación-de-tareas-en-pdf)
    - [4.4.5 Personalización del Formato del PDF](#445-personalización-del-formato-del-pdf)
    - [4.4.6 Integración de Marca de Agua](#446-integración-de-marca-de-agua)

- [CAPÍTULO 5 – CIERRE Y DOCUMENTACIÓN](#capítulo-5--cierre-y-documentación)
  - [5.1 Versión Final del Producto](#51-versión-final-del-producto)
  - [5.2 Manuales de Usuario](#52-manuales-de-usuario)
- [CONCLUSIONES](#conclusiones)
- [RECOMENDACIONES](#recomendaciones)
- [BIBLIOGRAFÍA](#bibliografía)
- [ANEXOS](#anexos)

---

## 1. INTRODUCCIÓN

El presente documento describe el avance del proyecto titulado **"Sistema de Gestión de Tareas Pendientes"**. Este proyecto tiene como objetivo implementar un programa que permita al usuario gestionar tareas mediante estructuras de datos dinámicas. Este avance forma parte del curso **Algoritmos y Estructuras de Datos**, y busca aplicar conceptos teóricos de estructuras de datos en un caso práctico.

## CAPÍTULO 1 – ASPECTOS GENERALES

### 1.1 Descripción de la Organización

Este proyecto se desarrolla en el contexto del curso universitario **"Algoritmos y Estructuras de Datos"**, orientado a la aplicación de conceptos teóricos en soluciones prácticas mediante la programación en Java.

### 1.2 Misión y Visión

- **Misión:** Desarrollar soluciones de software eficientes que apliquen conceptos de estructuras de datos para la gestión de información dinámica.
- **Visión:** Convertirse en una referencia académica en la implementación de estructuras de datos aplicadas a problemas del mundo real.

### 1.3 Arquitectura Tecnológica Actual

- **Hardware:** Computadora personal con especificaciones estándar para desarrollo de software.
- **Software:**
  - Lenguaje de Programación: Java
  - Entorno de Desarrollo: Apache NetBeans IDE 24
  - Sistema Operativo: Zorin OS (Linux)

## CAPÍTULO 2 – MARCO TEÓRICO

### 2.1 Tecnologías para Desarrollo de Software

El sistema está desarrollado en **Java**, un lenguaje orientado a objetos que permite gestionar estructuras de datos de manera eficiente. Se utiliza **Apache NetBeans** como entorno de desarrollo integrado (IDE) debido a su compatibilidad con proyectos en Java y sus herramientas de depuración. **Zorin OS**, un sistema operativo basado en Linux, proporciona un entorno estable para el desarrollo.

### 2.2 Arquitecturas de Software

Se emplea una arquitectura basada en el patrón **MVC (Modelo-Vista-Controlador)**, que separa la lógica de negocio, la interfaz de usuario y el acceso a los datos.

### 2.3 Metodologías de Desarrollo de Software

Se utiliza una **metodología ágil** con iteraciones cortas para validar el avance del proyecto y ajustar funcionalidades según el feedback recibido.

### 2.4 Aplicaciones de Algoritmos con Estructuras de Datos

El sistema implementa **listas enlazadas** para gestionar tareas, permitiendo operaciones eficientes de inserción, eliminación, y recorrido.

## CAPÍTULO 3 – GESTIÓN DEL PROYECTO

### 3.1 Objetivos

- **Objetivo General:**
  Desarrollar un sistema en Java que permita gestionar tareas pendientes utilizando estructuras de datos dinámicas (colas con prioridad o listas enlazadas).

- **Objetivos Específicos:**
  - Implementar una estructura de datos dinámica adecuada para la gestión de tareas.
  - Permitir al usuario agregar, listar y completar tareas.
  - Ordenar las tareas según su prioridad (Alta, Media, Baja).
  - Validar la funcionalidad del sistema mediante pruebas simples.

### 3.2 Descripción del Problema

El proyecto surge de la necesidad de organizar tareas en un entorno dinámico donde las prioridades cambian constantemente. La falta de un sistema de gestión eficiente puede generar desorganización y pérdida de control sobre las tareas pendientes.

### 3.3 Alcance del Proyecto

El sistema permitirá:

- Registrar tareas con descripciones y prioridades.
- Visualizar la lista de tareas pendientes.
- Completar (eliminar) tareas según su prioridad.
- Ordenar y buscar tareas de forma eficiente.

## CAPÍTULO 4 – IMPLEMENTACIÓN DE ESTRATEGIA

### 4.1 Lista de Requerimientos

- **Requisitos Funcionales:**

  - Agregar tareas.
  - Listar tareas ordenadas por prioridad.
  - Completar y eliminar tareas.
  - Buscar tareas específicas.

- **Requisitos No Funcionales:**
  - Interfaz de usuario simple y clara.
  - Respuesta rápida para operaciones básicas.

### 4.2 Prototipo Preliminar

Se desarrolló un prototipo básico con funcionalidades de inserción y listado de tareas en la consola.

### 4.3 Prototipo Funcional

Se ha avanzado en la implementación de tareas de actualización, eliminación y ordenamiento por prioridad. El sistema ahora cuenta con un **menú interactivo mejorado**, con mensajes de confirmación, sugerencias automáticas para tareas similares y una interfaz de usuario más amigable.

### 4.4 Desarrollo de la Aplicación

La aplicación final integra todos los módulos siguiendo la arquitectura **MVC**, con una estructura de paquetes para `model`, `controller`, `view` y `clases`. Se asegura el correcto funcionamiento mediante pruebas de validación y manejo de errores. Se considera la posibilidad de implementar una **interfaz gráfica** en futuras versiones.

---

### 4.4.1 Validación de Entradas y Manejo de Errores

Para garantizar una interacción fluida con el usuario, se implementaron validaciones en todas las entradas de datos:

- **Manejo de errores en la selección del menú:** Se evita que el programa falle si el usuario ingresa letras en lugar de números.
- **Validación de prioridades:** Solo se permiten valores "Alta", "Media" o "Baja".
- **Sugerencias en caso de errores:** Si un usuario busca una tarea inexistente, el sistema sugiere tareas similares.

---

### 4.4.2 Gestión de Tareas por Estado

Se incorporó la capacidad de gestionar tareas por estado, lo que permite al usuario:

- **Mover una tarea a "En Progreso"** antes de marcarla como completada.
- **Listar tareas según su estado:**
  - 📌 **Tareas Pendientes**
  - ⏳ **Tareas en Progreso**
  - ✅ **Tareas Completadas**

Esto permite un mejor control del flujo de trabajo, alineándose con metodologías como **Kanban**.

---

### 4.4.3 Historial de Tareas Completadas

Se añadió la opción de **visualizar un historial de tareas completadas**, permitiendo a los usuarios revisar el progreso del trabajo realizado.

- **Las tareas completadas no se eliminan del sistema, sino que se trasladan al historial.**
- **El historial puede consultarse en cualquier momento.**

---

### 4.4.4 Exportación de Tareas en PDF

Para mejorar la gestión documental, se implementó la opción de exportar la lista de tareas a un archivo **PDF**, con una estructura organizada y profesional.

#### 📌 Características implementadas:

- **Encabezado con título y logo** en la parte superior.
- **Organización por estados:**
  - 📌 Tareas Pendientes
  - ⏳ Tareas en Progreso
  - ✅ Tareas Completadas
- **Pie de página (footer) con autoría y fecha/hora de generación.**

#### 🛠️ **Implementación Técnica**

Se utilizó la biblioteca **Apache PDFBox** para la generación del archivo PDF, con los siguientes métodos clave:

- `exportarTareasAPdf()` → Organiza y formatea el contenido en el PDF.
- `agregarEncabezado()` → Dibuja la franja superior con el logo y el título.
- `agregarFooter()` → Inserta el **nombre del autor y la fecha/hora** de generación.
- `escribirTareasEnPdf()` → Estructura las tareas en el documento.

![Descripción de la imagen](./Imagenes/Capturas%20de%20Pantalla/Captura%20desde%202025-02-24%2004-08-15.png)

---

### 4.4.5 Personalización del Formato del PDF

Para mejorar la presentación del documento generado, se añadieron:

- **Un encabezado con fondo de color azul claro.**
- **Un logo en la esquina superior derecha.**
- **Texto del título bien alineado y legible.**
- **Pie de página centrado con la autoría y fecha de generación.**

Estos cambios garantizan una presentación más profesional del archivo.

---

### 4.4.6 Integración de Marca de Agua

Para reforzar la autenticidad del documento generado, se incluyó una **marca de agua en el pie de página**, que indica la autoría del proyecto y la fecha/hora exacta en que se generó el PDF.

_(Aquí podrías insertar una captura del PDF con la marca de agua)._

---

## 🎯 **¿Qué logramos con estos cambios?**

✅ **Un sistema más robusto y validado.**  
✅ **Mejor organización de tareas en estados.**  
✅ **Exportación profesional en PDF.**  
✅ **Formato visual mejorado con encabezado, logo y footer.**

---

## CAPÍTULO 5 – CIERRE Y DOCUMENTACIÓN

### 5.1 Versión Final del Producto

El sistema está completamente operativo, permitiendo la gestión eficiente de tareas. Se destaca la implementación de una **búsqueda flexible**, gestión de prioridades y una experiencia de usuario mejorada.

### 5.2 Manuales de Usuario

Se incluye un manual básico para el usuario final con instrucciones sobre cómo usar el sistema, incluyendo cómo agregar, listar, buscar y completar tareas.

## CONCLUSIONES

El proyecto ha permitido aplicar conceptos teóricos de estructuras de datos en un entorno práctico, mejorando la comprensión de su funcionamiento y utilidad en la resolución de problemas reales. La implementación de listas enlazadas y la estructura MVC han facilitado la organización del código y la escalabilidad del sistema.

## RECOMENDACIONES

- Integrar funcionalidades adicionales como **fechas límite para tareas**.
- Mejorar la **interfaz gráfica** para mayor usabilidad en futuras versiones.
- Optimizar el sistema para manejar **grandes volúmenes de tareas**.

## BIBLIOGRAFÍA

- Cormen, T. H., Leiserson, C. E., Rivest, R. L., & Stein, C. (2009). _Introduction to Algorithms_.
- Oracle Java Documentation.

## ANEXOS

- Capturas de pantalla del sistema en funcionamiento en Apache NetBeans sobre Zorin OS.
  ![Descripción de la imagen](./Imagenes/Sistema%20Operativo/Captura%20desde%202025-02-02%2003-35-11-750x572-upscaled.png)
  ![Descripción de la imagen](./Imagenes/Capturas%20de%20Pantalla/Captura%20desde%202025-02-02%2003-38-33.png)
- Fragmentos de código relevantes que demuestran la implementación de la lógica principal del sistema.
  ![Descripción de la imagen](./Imagenes/Capturas%20de%20Pantalla/Captura%20desde%202025-02-02%2003-38-33_rescaled.png)
  ![Descripción de la imagen](./Imagenes/Capturas%20de%20Pantalla/Captura%20desde%202025-02-02%2003-38-53-1230x791-upscaled.png)
  ![Descripción de la imagen](./Imagenes/Capturas%20de%20Pantalla/Captura%20desde%202025-02-02%2003-39-10-1230x791-upscaled.png)
  ![Descripción de la imagen](./Imagenes/Capturas%20de%20Pantalla/Captura%20desde%202025-02-02%2003-39-42-1230x791-upscaled.png)

![Descripción de la imagen](./Imagenes/Capturas%20de%20Pantalla/Captura%20desde%202025-02-24%2004-08-15.png)
