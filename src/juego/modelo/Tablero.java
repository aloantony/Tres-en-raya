package juego.modelo;

import juego.util.Coordenada;
import juego.util.Direccion;

/**
 * Implementación de un tablero para el juego "Tres en raya".
 * <p>
 * Este tablero puede ser reutilizado para diferentes tamaños y se encarga de
 * gestionar las celdas del juego.
 * Se utiliza junto con las clases {@link Coordenada} y {@link Celda} para
 * definir las posiciones y estados del tablero.
 * 
 * @author <a href="mailto:rmartico@ubu.es">Raúl Marticorena Sánchez</a>
 * @author <a href="mailto:aab1027@alu.ubu.es">Antonio Alonso Briones</a>
 * @version 1.1
 * @since 1.0
 * @see Coordenada
 * @see Direccion
 */
public class Tablero {
	private Celda[][] tablero;

	/**
	 * Constructor que inicializa el tablero con las celdas vacías.
	 * 
	 * @param filas    número de filas del tablero
	 * @param columnas número de columnas del tablero
	 * @throws IllegalArgumentException si el número de filas o columnas es menor o
	 *                                  igual a cero
	 * @since 1.0
	 */
	public Tablero(int filas, int columnas) {
		if (filas <= 0 || columnas <= 0) {
			throw new IllegalArgumentException("El número de filas y columnas debe ser mayor que cero.");
		}
		this.tablero = new Celda[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				tablero[i][j] = new Celda(new Coordenada(i, j));
			}
		}
	}

	/**
	 * Devuelve una representación en texto del estado actual del tablero.
	 * 
	 * @return representación del tablero en formato texto
	 * @since 1.0
	 */
	public String aTexto() {
		StringBuilder resultado = new StringBuilder();
		for (Celda[] filas : tablero) {
			for (Celda celda : filas) {
				resultado.append(celda.estaVacia() ? "-" : celda.obtenerPieza().aTexto());
			}
			resultado.append("\n");
		}
		return resultado.toString();
	}

	/**
	 * Verifica si el tablero está completo (todas las celdas ocupadas).
	 * 
	 * @return true si todas las celdas están ocupadas, false en caso contrario
	 * @since 1.0
	 */
	public boolean estaCompleto() {
		for (Celda[] fila : tablero) {
			for (Celda celda : fila) {
				if (celda.estaVacia()) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Verifica si una coordenada está dentro de los límites del tablero.
	 * 
	 * @param coordenada coordenada a verificar
	 * @return true si la coordenada está dentro del tablero, false en caso
	 *         contrario
	 * @since 1.0
	 * @see Coordenada
	 */
	public boolean estaEnTablero(Coordenada coordenada) {
		int fila = coordenada.fila();
		int columna = coordenada.columna();
		return fila >= 0 && fila < tablero.length && columna >= 0 && columna < tablero[0].length;
	}

	/**
	 * Coloca una pieza en una celda especificada si está vacía y dentro del
	 * tablero.
	 * 
	 * @param pieza      pieza a colocar
	 * @param coordenada coordenada donde colocar la pieza
	 * @throws IllegalArgumentException si la coordenada está fuera del tablero o la
	 *                                  celda no está vacía
	 * @since 1.0
	 * @see Pieza
	 */
	public void colocar(Pieza pieza, Coordenada coordenada) {
		if (!estaEnTablero(coordenada)) {
			throw new IllegalArgumentException("La coordenada está fuera de los límites del tablero.");
		}
		if (!tablero[coordenada.fila()][coordenada.columna()].estaVacia()) {
			throw new IllegalArgumentException("La celda ya está ocupada.");
		}
		tablero[coordenada.fila()][coordenada.columna()].establecerPieza(pieza);
	}

	/**
	 * Cuenta el número de piezas consecutivas desde una coordenada en una dirección
	 * especificada.
	 * 
	 * @param coordenada coordenada inicial
	 * @param direccion  dirección en la que contar las piezas
	 * @return número de piezas consecutivas
	 * @since 1.0
	 * @see Direccion
	 */
	public int contarPiezasConsecutivas(Coordenada coordenada, Direccion direccion) {
		int contador = 1;
		int fila, columna;

		Celda celdaInicial = tablero[coordenada.fila()][coordenada.columna()];
		if (celdaInicial.estaVacia()) {
			return 0;
		}
		Color colorJugador = celdaInicial.obtenerPieza().obtenerColor();

		// Contar en la dirección positiva
		fila = coordenada.fila() + direccion.incrementoFila();
		columna = coordenada.columna() + direccion.incrementoColumna();

		while (estaEnTablero(new Coordenada(fila, columna))) {
			Celda celda = tablero[fila][columna];
			if (!celda.estaVacia() && celda.obtenerPieza().obtenerColor().equals(colorJugador)) {
				contador++;
			} else {
				break;
			}
			fila += direccion.incrementoFila();
			columna += direccion.incrementoColumna();
		}

		// Contar en la dirección opuesta
		fila = coordenada.fila() - direccion.incrementoFila();
		columna = coordenada.columna() - direccion.incrementoColumna();

		while (estaEnTablero(new Coordenada(fila, columna))) {
			Celda celda = tablero[fila][columna];
			if (!celda.estaVacia() && celda.obtenerPieza().obtenerColor().equals(colorJugador)) {
				contador++;
			} else {
				break;
			}
			fila -= direccion.incrementoFila();
			columna -= direccion.incrementoColumna();
		}

		return contador;
	}

	/**
	 * Devuelve el número de columnas del tablero.
	 * 
	 * @return número de columnas del tablero
	 * @since 1.0
	 */
	public int consultarNumeroColumnas() {
		return tablero[0].length;
	}

	/**
	 * Devuelve el número de filas del tablero.
	 * 
	 * @return número de filas del tablero
	 * @since 1.0
	 */
	public int consultarNumeroFilas() {
		return tablero.length;
	}

	/**
	 * Cuenta cuántas piezas de un color determinado hay en el tablero.
	 * 
	 * @param color color de las piezas a contar
	 * @return número de piezas del color especificado
	 * @since 1.0
	 * @see Color
	 */
	public int consultarNumeroPiezas(Color color) {
		int contador = 0;
		for (Celda[] fila : tablero) {
			for (Celda celda : fila) {
				if (!celda.estaVacia() && celda.obtenerPieza().obtenerColor() == color) {
					contador++;
				}
			}
		}
		return contador;
	}

	/**
	 * Devuelve la celda en la coordenada especificada si está dentro del tablero.
	 * 
	 * @param coordenada coordenada de la celda a obtener
	 * @return la celda en la coordenada especificada, o null si la coordenada no
	 *         está en el tablero
	 * @since 1.0
	 * @see Coordenada
	 */
	public Celda obtenerCelda(Coordenada coordenada) {
		if (estaEnTablero(coordenada)) {
			return tablero[coordenada.fila()][coordenada.columna()];
		}
		return null;
	}

	/**
	 * Devuelve una representación en texto del tablero.
	 * 
	 * @return representación del tablero en formato texto
	 * @since 1.0
	 */
	@Override
	public String toString() {
		return aTexto();
	}

	/**
	 * Método principal para probar la clase Tablero.
	 * 
	 * @param args argumentos de la línea de comandos
	 * @since 1.0
	 */
	public static void main(String[] args) {
		Tablero tablero = new Tablero(3, 3);
		System.out.println("Estado inicial del tablero:");
		System.out.println(tablero.aTexto());

		tablero.colocar(new Pieza(Color.NEGRO), new Coordenada(0, 0));
		tablero.colocar(new Pieza(Color.BLANCO), new Coordenada(1, 1));
		tablero.colocar(new Pieza(Color.NEGRO), new Coordenada(0, 1));

		System.out.println("Estado del tablero tras colocar algunas piezas:");
		System.out.println(tablero.aTexto());
	}
}
