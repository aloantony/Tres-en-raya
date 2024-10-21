package juego.modelo;

/**
 * Representa un jugador en el juego "Tres en raya".
 * <p>
 * Esta clase gestiona el nombre y el color del jugador, y permite generar
 * piezas del color del jugador.
 * 
 * @author <a href="mailto:aab1027@alu.ubu.es">Antonio Alonso Briones</a>
 * @version 1.1
 * @since 1.0
 * @see Color
 * @see Pieza
 */
public class Jugador {

    /**
     * Nombre del jugador.
     */
    private String nombre;

    /**
     * Color del jugador.
     */
    private Color color;

    /**
     * Constructor que inicializa un jugador con un nombre y un color.
     * 
     * @param nombre nombre del jugador
     * @param color  color del jugador
     * @since 1.0
     */
    public Jugador(String nombre, Color color) {
        this.nombre = nombre;
        this.color = color;
    }

    /**
     * Consulta el color del jugador.
     * 
     * @return el color del jugador
     * @since 1.0
     */
    public Color consultarColor() {
        return color;
    }

    /**
     * Consulta el nombre del jugador.
     * 
     * @return el nombre del jugador
     * @since 1.0
     */
    public String consultarNombre() {
        return nombre;
    }

    /**
     * Genera una nueva pieza con el color del jugador.
     * 
     * @return una nueva pieza del color del jugador
     * @since 1.0
     */
    public Pieza generarPieza() {
        return new Pieza(color);
    }

    /**
     * Devuelve una representación textual del jugador.
     * 
     * @return representación textual del jugador, incluyendo su nombre y color
     * @since 1.0
     * @see Color
     */
    @Override
    public String toString() {
        return "Jugador: " + nombre + ", Color: " + color;
    }
}
