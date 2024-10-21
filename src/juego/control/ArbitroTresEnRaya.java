package juego.control;

import juego.modelo.*;
import juego.util.Coordenada;
import juego.util.Direccion;

/**
 * Clase que implementa el árbitro del juego "Tres en raya".
 * <p>
 * La clase gestiona el estado del juego, registra jugadores y maneja el
 * tablero.
 * 
 * @author <a href="mailto:aab1027@alu.ubu.es">Antonio Alonso Briones</a>
 * @version 1.0
 */
public class ArbitroTresEnRaya {

    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private int turnoActual;
    private Jugador ganador;

    /**
     * Constructor que inicializa el árbitro con el tablero del juego.
     * 
     * @param tablero el tablero del juego
     */
    public ArbitroTresEnRaya(Tablero tablero) {
        this.tablero = tablero;
        this.jugador1 = null;
        this.jugador2 = null;
        this.turnoActual = 0;
        this.ganador = null;
    }

    /**
     * Registra un jugador con el nombre dado.
     * <p>
     * El primer jugador registrado será de color blanco y el segundo de color
     * negro.
     * 
     * @param nombre el nombre del jugador a registrar
     */
    public void registrarJugador(String nombre) {
        if (jugador1 == null) {
            jugador1 = new Jugador(nombre, Color.BLANCO);
            turnoActual = 0; // El primer jugador registrado comienza
        } else if (jugador2 == null) {
            jugador2 = new Jugador(nombre, Color.NEGRO);
        }
        // Si ya hay dos jugadores, no se hace nada
    }

    /**
     * Verifica si un movimiento es legal.
     * <p>
     * Un movimiento es legal si la celda está vacía, la coordenada está dentro del
     * tablero y la partida no ha acabado.
     * 
     * @param coordenada la coordenada del movimiento
     * @return true si el movimiento es legal, false en caso contrario
     */
    public boolean esMovimientoLegal(Coordenada coordenada) {
        return !estaAcabado() && tablero.estaEnTablero(coordenada) && tablero.obtenerCelda(coordenada).estaVacia();
    }

    /**
     * Realiza un movimiento colocando la pieza del jugador actual en la coordenada
     * dada.
     * 
     * @param coordenada la coordenada donde se colocará la pieza
     */
    public void jugar(Coordenada coordenada) {
        Jugador jugadorActual = obtenerTurno();
        tablero.colocar(jugadorActual.generarPieza(), coordenada);
        if (verificarVictoria(coordenada)) {
            ganador = jugadorActual;
        } else {
            turnoActual = (turnoActual + 1) % 2; // Cambia el turno al siguiente jugador
        }
    }

    /**
     * Verifica si hay un ganador tras colocar una pieza en una coordenada
     * específica.
     * 
     * @param coordenada la coordenada donde se acaba de colocar la pieza
     * @return true si hay un ganador, false en caso contrario
     */
    private boolean verificarVictoria(Coordenada coordenada) {
        int cantidadParaGanar = 3; // Tres en raya

        for (Direccion direccion : Direccion.values()) {
            int contador = tablero.contarPiezasConsecutivas(coordenada, direccion);
            if (contador >= cantidadParaGanar) {
                return true; // El jugador ha ganado
            }
        }
        return false; // No hay victoria en ninguna dirección
    }

    /**
     * Verifica si el juego ha terminado.
     * <p>
     * El juego ha terminado si hay un ganador o si el tablero está completo.
     * 
     * @return true si el juego ha terminado, false en caso contrario
     */
    public boolean estaAcabado() {
        return ganador != null || tablero.estaCompleto();
    }

    /**
     * Devuelve el ganador del juego si lo hay.
     * 
     * @return el jugador ganador, o null si no hay ganador
     */
    public Jugador obtenerGanador() {
        return ganador;
    }

    /**
     * Devuelve el tablero actual del juego.
     * 
     * @return el tablero del juego
     */
    public Tablero obtenerTablero() {
        return tablero;
    }

    /**
     * Devuelve el jugador que tiene el turno actual.
     * 
     * @return el jugador que tiene el turno actual
     */
    public Jugador obtenerTurno() {
        return (turnoActual == 0) ? jugador1 : jugador2;
    }
}
