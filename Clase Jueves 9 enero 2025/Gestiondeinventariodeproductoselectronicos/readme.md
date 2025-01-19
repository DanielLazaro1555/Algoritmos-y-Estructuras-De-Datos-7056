# Gestión de Inventario de Productos Electrónicos

## Introducción

Un negocio necesita un sistema para gestionar su inventario de productos electrónicos. Actualmente, el inventario se lleva de manera manual, lo que genera ineficiencias, errores en el control de stock y dificultades para actualizar la información de los productos.

El sistema debe permitir registrar productos, consultar datos, actualizar información y eliminar productos de manera sencilla, utilizando herramientas tecnológicas para que los empleados puedan operar desde una computadora básica.

---

## Objetivo

Desarrollar un sistema básico para gestionar el inventario utilizando **arreglos unidimensionales** en Java. Este sistema manejará los datos de los productos de manera estructurada y permitirá realizar operaciones básicas de gestión.

---

## Estructura del Sistema

Cada producto tendrá la siguiente información:
1. **Nombre**: Una cadena de texto que identifica el producto (por ejemplo: `"Laptop Dell"`).
2. **Precio**: Un valor numérico que indica el costo del producto (ejemplo: `599.99`).
3. **Cantidad en stock**: Un número entero que representa la cantidad disponible del producto (ejemplo: `10`).

El sistema gestionará un número limitado de productos (10 en esta versión) utilizando un **arreglo estático**.

---

## Operaciones Básicas

El sistema debe realizar las siguientes operaciones:

1. **Agregar un producto**:
   - Permitir insertar un nuevo producto al inventario.
   - Verificar que no se exceda la capacidad máxima del arreglo.
   - Validar que los datos ingresados sean correctos (precio > 0, cantidad >= 0).

2. **Actualizar un producto**:
   - Modificar los datos de un producto existente según el índice que el usuario indique.
   - Permitir actualizar cualquier propiedad del producto (nombre, precio o cantidad en stock).

3. **Eliminar un producto**:
   - Simular la eliminación de un producto del inventario.
   - Desplazar los elementos posteriores para evitar huecos en el arreglo.
   - Reducir el tamaño del inventario.

4. **Mostrar el inventario**:
   - Iterar sobre el arreglo para mostrar todos los productos registrados.

5. **Copiar el inventario**:
   - Crear una copia exacta del arreglo actual y mostrar el resultado.

---

## Restricciones y Supuestos

1. El sistema tendrá un límite de 10 productos en esta primera versión.
2. Los productos deben tener precios positivos (mayores a 0) y cantidades mayores o iguales a 0.
3. La operación de eliminación no debe dejar espacios vacíos en el arreglo; los elementos deben ser desplazados hacia la izquierda.

---

## Actividades Adicionales

1. **Validación de datos de entrada**:
   - Asegurarse de que los valores ingresados para precio y cantidad sean válidos.
   - Si el usuario ingresa datos incorrectos, mostrar un mensaje de error y solicitar nuevamente los datos.

2. **Buscar un producto**:
   - Implementar un método para buscar un producto por su nombre.
   - Mostrar la información del producto si existe.
   - Indicar un mensaje si el producto no se encuentra.

3. **Ordenar el inventario por precio**:
   - Implementar una funcionalidad para ordenar los productos en función de su precio (de menor a mayor).
   - Mostrar el inventario ordenado después de la operación.

4. **Ampliar la capacidad del inventario**:
   - Implementar un mecanismo para duplicar el tamaño del arreglo cuando esté lleno.
   - Copiar todos los elementos existentes al nuevo arreglo.

---

## Resolución Conceptual

Para resolver este problema, se seguirán los siguientes pasos:

1. **Definir las clases principales**:
   - Una clase `Producto` que contendrá los atributos `nombre`, `precio` y `cantidadStock`.
   - Una clase `Inventario` que administrará un arreglo de productos y contendrá los métodos necesarios para gestionar el inventario.

2. **Implementar las operaciones básicas**:
   - Métodos para agregar, actualizar, eliminar, mostrar y copiar productos.
   - Validar los datos ingresados por el usuario para garantizar que sean correctos.

3. **Agregar funcionalidades adicionales**:
   - Métodos para buscar productos por nombre.
   - Ordenar los productos por precio.
   - Ampliar dinámicamente el tamaño del arreglo cuando sea necesario.

4. **Diseñar un flujo principal (Main)**:
   - Crear un menú interactivo que permita al usuario seleccionar la operación a realizar.
   - Manejar las entradas del usuario y conectar las opciones del menú con los métodos de la clase `Inventario`.

---

## Ejemplo de Uso

Un ejemplo básico del flujo del sistema sería el siguiente:

1. El usuario inicia el programa y selecciona una opción del menú:
   ```plaintext
   **************** Gestión de Inventario ****************
   1. Agregar Producto
   2. Actualizar Producto
   3. Eliminar Producto
   4. Mostrar Inventario
   5. Copiar Inventario
   6. Buscar Producto
   7. Ordenar por Precio
   8. Salir
   Ingrese una opción: 
