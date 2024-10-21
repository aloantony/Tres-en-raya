package juego.util;

// TODO: Auto-generated Javadoc
/**
 * Dirección de movimiento en tablero.
 * 
 * Dado que no tiene dependencias de otros módulos, se debería
 * implementar en las primeras etapas.
 *
 * @author <a href="mailto:rmartico@ubu.es">Raúl Marticorena Sánchez</a>
 * @version 1.0
 */
public enum Direccion {

	/**
	 * Horizontal.
	 */
	HORIZONTAL(0, 1),

	/**
	 * Vertical.
	 */
	VERTICAL(1, 0),

	/**
	 * Dirección SO a NE.
	 */
	DIAGONAL_SO_NE(1, 1),

	/**
	 * Dirección NO a SE.
	 */
	DIAGONAL_NO_SE(-1, 1);

	/** The incremento fila. */
	private int incrementoFila;
	
	/** The incremento columna. */
	private int incrementoColumna;

    /**
     * Instantiates a new direccion.
     *
     * @param incrementoFila the incremento fila
     * @param incrementoColumna the incremento columna
     */
    Direccion(int incrementoFila, int incrementoColumna) {
		this.incrementoFila = incrementoFila;
		this.incrementoColumna = incrementoColumna;
	}

	/**
	 * Incremento fila.
	 *
	 * @return the int
	 */
	// Método para obtener el incremento de fila de la dirección
	public int incrementoFila() {
        return incrementoFila;
    }

    /**
     * Incremento columna.
     *
     * @return the int
     */
    // Método para obtener el incremento de columna de la dirección
    public int incrementoColumna() {
        return incrementoColumna;
    }
}
