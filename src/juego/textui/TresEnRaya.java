// COMPLETAR DECLARACIÓN DE PAQUETE...
package juego.textui;

import java.util.Scanner;
import juego.control.ArbitroTresEnRaya;
import juego.modelo.*;
import juego.util.Coordenada;

// COMPLETAR RESTO DE IMPORTACIONES....

/**
 * Juego del "Tres en raya".
 * <p>
 * Ejercicio práctico - Metodología de la Programación.
 * <p>
 * Curso 2024-2025.
 * 
 * @author <a href="mailto:aab1027@alu.ubu.es">Antonio Alonso Briones</a>
 * @version 1.1
 * @since 1.0
 */
public class TresEnRaya {

	/** Número de argumentos máximo para el juego. */
	private static final int NUM_ARGUMENTOS = 2;

	/**
	 * Árbitro del juego encargado de gestionar las reglas y el estado del juego.
	 */
	private static ArbitroTresEnRaya arbitro;

	/**
	 * Flujo de ejecución principal del juego.
	 * <p>
	 * Inicializa el tablero, registra a los jugadores y gestiona el desarrollo del
	 * juego, solicitando entradas del usuario a través del teclado.
	 * 
	 * @param args nombres de los jugadores
	 * @since 1.0
	 */
	public static void main(String[] args) {
		if (args.length != NUM_ARGUMENTOS) {
			mostrarAyuda();
		} else {
			// Inicialización del juego según los argumentos validados
			Tablero tablero = new Tablero(3, 3);
			arbitro = new ArbitroTresEnRaya(tablero);

			arbitro.registrarJugador(args[0]);
			arbitro.registrarJugador(args[1]);

			// Fase de juego: iteramos sobre las distintas jugadas
			Scanner teclado = new Scanner(System.in);

			boolean partidaTerminada = false;

			// Mientras la partida no esté acabada, leer de teclado fila y columna, y si la
			// jugada es válida, completarla
			while (!partidaTerminada) {
				mostrarTablero(tablero);
				Jugador jugadorActual = arbitro.obtenerTurno();
				System.out.println("El turno es de: " + jugadorActual.consultarNombre() + " con fichas "
						+ jugadorActual.consultarColor());

				// Leer coordenadas de movimiento
				System.out.print("Introduce fila: ");
				int fila = teclado.nextInt();
				System.out.print("Introduce columna: ");
				int columna = teclado.nextInt();
				Coordenada coordenada = new Coordenada(fila, columna);

				// Verificar si el movimiento es legal y realizarlo
				if (arbitro.esMovimientoLegal(coordenada)) {
					arbitro.jugar(coordenada);
					if (arbitro.estaAcabado()) {
						partidaTerminada = true;
						Jugador ganador = arbitro.obtenerGanador();
						mostrarTablero(tablero);
						if (ganador != null) {
							System.out.println("El ganador es: " + ganador.consultarNombre());
						} else {
							System.out.println("La partida ha terminado en tablas.");
						}
					}
				} else {
					System.out.println("Movimiento ilegal. Inténtalo de nuevo.");
				}
			}

			teclado.close();
		}
	}

	/**
	 * Muestra la ayuda en línea para la inicialización correcta del juego.
	 * <p>
	 * Proporciona información sobre cómo utilizar correctamente el programa.
	 * 
	 * @since 1.0
	 */
	private static void mostrarAyuda() {
		System.out.println("Uso: java TresEnRaya <NombreJugador1> <NombreJugador2>");
		System.out.println("Ejemplo: java TresEnRaya Abel Caín");
	}

	/**
	 * Muestra el estado actual del tablero.
	 * 
	 * @param tablero tablero a pintar en pantalla
	 * @since 1.0
	 */
	private static void mostrarTablero(Tablero tablero) {
		System.out.println(tablero.aTexto());
	}

	// AÑADIR MÁS MÉTODOS NECESARIOS PARA EL MODO TEXTO...
}
