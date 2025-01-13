# Gestión de Calificaciones

Este proyecto implementa un sistema para gestionar calificaciones, permitiendo agregar, actualizar, eliminar, buscar, ordenar y mostrar estadísticas de las calificaciones registradas.

## Estructura del Proyecto

El proyecto se compone de los siguientes archivos:

- **Calificaciones.java**: Clase que administra las calificaciones, proporcionando métodos para manejar el almacenamiento, búsqueda, eliminación, ordenación y generación de estadísticas.
- **GestorCalificaciones.java**: Clase que actúa como un controlador, manejando la interacción con el usuario mediante un menú interactivo.
- **Main.java**: Clase principal que inicia el programa.

## Funcionalidades

1. **Agregar Calificación**: Permite al usuario registrar nuevas calificaciones hasta alcanzar el límite establecido.
2. **Actualizar Calificación**: Permite modificar el valor de una calificación específica identificada por su índice.
3. **Eliminar Calificación**: Borra una calificación específica y reorganiza las restantes.
4. **Mostrar Calificaciones**: Muestra todas las calificaciones registradas junto con sus índices.
5. **Calcular Estadísticas**: Calcula y muestra el promedio, la calificación máxima y la mínima de las registradas.
6. **Buscar Calificación**: Busca una calificación específica y muestra su índice si se encuentra.
7. **Mostrar Calificaciones Ordenadas**: Ordena las calificaciones en orden ascendente y las muestra al usuario.
8. **Salir del Programa**: Finaliza la ejecución del programa.

## Detalles de Implementación

### 1. Clase `Calificaciones`
Esta clase gestiona el almacenamiento y manejo de las calificaciones.

**Métodos destacados:**
- `agregar(int calificacion)`: Agrega una nueva calificación.
- `actualizar(int indice, int nuevoValor)`: Actualiza el valor de una calificación en un índice específico.
- `eliminar(int indice)`: Elimina una calificación en el índice dado.
- `buscarCalificacion(int calificacion)`: Busca una calificación específica y devuelve su índice o `-1` si no se encuentra.
- `ordenarCalificaciones()`: Ordena las calificaciones en orden ascendente.
- `mostrar()`: Muestra todas las calificaciones registradas.
- `mostrarOrdenadas()`: Ordena y muestra las calificaciones.
- `mostrarEstadisticas()`: Calcula y muestra estadísticas básicas (promedio, máximo, mínimo).

### 2. Clase `GestorCalificaciones`
Controla la interacción con el usuario mediante un menú.

**Opciones del menú:**
- **1. Agregar Calificación**: Solicita al usuario una nueva calificación y la agrega.
- **2. Actualizar Calificación**: Permite cambiar el valor de una calificación existente.
- **3. Eliminar Calificación**: Borra una calificación identificada por su índice.
- **4. Mostrar Calificaciones**: Lista todas las calificaciones registradas.
- **5. Calcular Estadísticas**: Muestra estadísticas como promedio, máximo y mínimo.
- **6. Buscar Calificación**: Encuentra una calificación específica y muestra su índice.
- **7. Mostrar Calificaciones Ordenadas**: Ordena las calificaciones en orden ascendente y las muestra.
- **8. Salir**: Finaliza el programa.

### 3. Clase `Main`
Punto de entrada del programa. Solicita al usuario la capacidad máxima de calificaciones y crea una instancia de `GestorCalificaciones` para iniciar el flujo principal.

**Código destacado:**
```java
Scanner entrada = new Scanner(System.in);
System.out.println("Ingrese la cantidad máxima de calificaciones: ");
int capacidad = entrada.nextInt();
GestorCalificaciones gestor = new GestorCalificaciones(capacidad);
gestor.iniciar();
