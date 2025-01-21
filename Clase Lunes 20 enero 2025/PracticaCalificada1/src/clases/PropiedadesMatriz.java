package clases;

/**
 * Clase para verificar propiedades de una matriz bidimensional: triangularidad
 * superior, triangularidad inferior y simetría.
 */
public class PropiedadesMatriz {

    /**
     * Verifica si la matriz es triangular superior.
     *
     * Matriz a evaluar.
     * @return true si todos los elementos debajo de la diagonal principal son
     * cero.
     */
    public static boolean esTriangularSuperior(int[][] matriz) {
        for (int i = 1; i < matriz.length; i++) {
            for (int j = 0; j < i; j++) {
                if (matriz[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Verifica si la matriz es triangular inferior.
     *
     * Matriz a evaluar.
     * @return true si todos los elementos por encima de la diagonal principal
     * son cero.
     */
    public static boolean esTriangularInferior(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = i + 1; j < matriz[i].length; j++) {
                if (matriz[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Verifica si la matriz es simétrica.
     *
     * Matriz a evaluar.
     * @return true si la matriz es igual a su transpuesta.
     */
    public static boolean esSimetrica(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != matriz[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
