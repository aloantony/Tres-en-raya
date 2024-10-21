package juego.modelo;

import juego.util.Coordenada;

/**
 * Representa una celda en el juego "Tres en raya".
 * <p>
 * Esta clase gestiona la coordenada y la pieza que ocupa la celda.
 * Dado que depende de la clase {@link Coordenada}, se debería implementar
 * después de dicha clase.
 * 
 * @author <a href="mailto:aab1027@alu.ubu.es">Antonio Alonso Briones</a>
 * @version 1.1
 * @since 1.0
 * @see Coordenada
 * @see Pieza
 */
public class Celda {

    /**
     * Coordenada de la celda.
     */
    private Coordenada coordenada;

    /**
     * Pieza colocada en la celda.
     */
    private Pieza pieza;

    /**
     * Constructor que inicializa la celda con una coordenada específica.
     * Inicialmente, la celda está vacía.
     * 
     * @param coordenada la coordenada de la celda
     * @since 1.0
     */
    public Celda(Coordenada coordenada) {
        this.coordenada = coordenada;
        this.pieza = null;
    }

    /**
     * Consulta la coordenada de la celda.
     * 
     * @return la coordenada de la celda
     * @since 1.0
     */
    public Coordenada consultarCoordenada() {
        return coordenada;
    }

    /**
     * Verifica si la celda está vacía.
     * 
     * @return {@code true} si la celda no contiene ninguna pieza, {@code false} en
     *         caso contrario
     * @since 1.0
     */
    public boolean estaVacia() {
        return pieza == null;
    }

    /**
     * Establece una pieza en la celda.
     * 
     * @param pieza la pieza a colocar en la celda
     * @since 1.0
     */
    public void establecerPieza(Pieza pieza) {
        this.pieza = pieza;
    }

    /**
     * Obtiene la pieza que ocupa la celda.
     * 
     * @return la pieza que ocupa la celda, o {@code null} si la celda está vacía
     * @since 1.0
     */
    public Pieza obtenerPieza() {
        return pieza;
    }
}
