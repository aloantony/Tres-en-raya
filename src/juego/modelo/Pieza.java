package juego.modelo;

/**
 * Representa una pieza del juego "Tres en raya".
 * <p>
 * Dado que no tiene dependencias de otros módulos salvo de {@link Color}, se
 * debería
 * implementar en las segundas etapas tras implementar el paquete juego.util y
 * el tipo enumerado {@link Color}.
 * 
 * @author <a href="mailto:rmartico@ubu.es">Raúl Marticorena Sánchez</a>
 * @author <a href="mailto:aab1027@alu.ubu.es">Antonio Alonso Briones</a>
 * @version 1.1
 * @since 1.0
 * @see Color
 */
public class Pieza {

	/**
	 * Color de la pieza.
	 */
	private Color color;

	/**
	 * Constructor que crea una pieza con el color especificado.
	 * 
	 * @param color color de la pieza
	 * @since 1.0
	 */
	public Pieza(Color color) {
		this.color = color;
	}

	/**
	 * Obtiene el color de la pieza.
	 * 
	 * @return color de la pieza
	 * @since 1.0
	 */
	public Color obtenerColor() {
		return this.color;
	}

	/**
	 * Devuelve una representación textual de la pieza.
	 * 
	 * @return 'X' si la pieza es negra, 'O' si la pieza es blanca
	 * @since 1.0
	 * @see Color
	 */
	public String aTexto() {
		return Character.toString(this.color == Color.NEGRO ? 'X' : 'O');
	}

	// Añadir otros métodos si lo requiere el enunciado o los tests
}
