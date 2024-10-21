package juego.modelo;

/**
 * Representa el color de las piezas del juego "Tres en raya".
 * <p>
 * Dado que no tiene dependencias de otros módulos, se debería implementar en
 * las primeras etapas, tras implementar el paquete juego.util.
 * 
 * @author <a href="mailto:rmartico@ubu.es">Raúl Marticorena Sánchez</a>
 * @author <a href="mailto:aab1027@alu.ubu.es">Antonio Alonso Briones</a>
 * @version 1.1
 * @since 1.0
 */
public enum Color {

	/**
	 * Blanco con el carácter 'O' asignado.
	 */
	BLANCO('O'),

	/**
	 * Negro con el carácter 'X' asignado.
	 */
	NEGRO('X');

	/**
	 * Carácter correspondiente a cada color.
	 */
	private char carácter;

	/**
	 * Constructor que asigna el carácter correspondiente al color.
	 * 
	 * @param car carácter que representa el color
	 * @since 1.0
	 */
	private Color(char car) {
		this.carácter = car;
	}

	/**
	 * Obtiene el carácter asociado al color.
	 * 
	 * @return carácter identificativo del color
	 * @since 1.0
	 */
	public char toChar() {
		return carácter;
	}

	/**
	 * Devuelve la representación en cadena del color.
	 * 
	 * @return representación en cadena del color ('O' o 'X')
	 * @since 1.0
	 * @see #toChar()
	 */
	@Override
	public String toString() {
		return String.valueOf(carácter);
	}
}
