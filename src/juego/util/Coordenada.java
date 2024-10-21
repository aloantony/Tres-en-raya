package juego.util;

/**
 * Coordenadas de una celda con sus valores fila y columna.
 * 
 * Dado que no tiene dependencias de otros módulos, se debería
 * implementar en las primeras etapas.
 *
 * @author <a href="mailto:rmartico@ubu.es">Raúl Marticorena</a>
 * @version 1.0
 * @param fila    fila
 * @param columna columna
 * @since 1.0
 */
public record Coordenada(int fila, int columna) {
}
