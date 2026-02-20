package clases;

/**
 * @author Artem Zimin Litvak
 * @version 17/02/2026
 */
public class Tabla {
	/**
	 * 
	 */
	private int filas;
	private int columnas;
	private Celda[][] mapaCeldas;

	/**
	 * filas: cantidad de filas que tiene la tabla columnas: cantidad de columnas
	 * que tiene la tabla mapaCeldas[]: array de celdas que representa el tablero de
	 * buscaminas
	 */
	/**
	 * @param filas
	 * @param columnas
	 */
	public Tabla(int filas, int columnas) {
		super();
		this.filas = filas;
		this.columnas = columnas;
		this.mapaCeldas = new Celda[filas][columnas];
		this.mapaCeldas = generarTablero();
		establecerNumeroMinas();

	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public Celda[][] getMapaCeldas() {
		return mapaCeldas;
	}

	public void setMapaCeldas(Celda[][] mapaCeldas) {
		this.mapaCeldas = mapaCeldas;
	}

	/**
	 * generarTablero:
	 * 
	 * @return Celda[][]
	 */
	@SuppressWarnings("unused")
	private Celda[][] generarTablero() {
		Celda[][] copiaMapaCeldas = getMapaCeldas();
		boolean tieneMina;
		boolean tieneJarron;
		boolean tieneMonstruo;
		for (int i = 0; mapaCeldas.length > i; i++) {
			for (int t = 0; mapaCeldas[i].length > t; t++) {

				tieneMina = false;
				tieneJarron = false;
				tieneMonstruo = false;
				/**
				 * Elige si la celda es una mina un jarron un monstruo o está vacía (es un apaño
				 * que no es muy clean)
				 */
				if (tieneMina = generarMinas()) {
					copiaMapaCeldas[i][t] = new Celda(generarMinas(), false, false, false);
				} else {
					if (tieneJarron = generarJarron()) {
						copiaMapaCeldas[i][t] = new Celda(false, false, generarJarron(), false);
					} else if (tieneMonstruo = generarMonstruo()) {
						copiaMapaCeldas[i][t] = new Celda(false, generarMonstruo(), false, false);
					} else {
						copiaMapaCeldas[i][t] = new Celda(false, false, false, false);
					}
				}
			}
		}
		return copiaMapaCeldas;
	}

	/**
	 * generarMinas: calcula el 15 porciento de aparición de minas
	 * 
	 * @return boolean
	 */

	private boolean generarMinas() {
		/**
		 * RATIO_APARICION_MINAS: es el porcentaje de aoparicion de las minas
		 */
		final int RATIO_APARICION_MINAS = 40;
		/**
		 * Calcula el porcentaje de aparicioó y devuelve un boolean
		 */
		if ((Math.random() * 100) + 1 <= RATIO_APARICION_MINAS) {
			return true;
		} else {
			return false;
		}

	}

	private boolean generarMonstruo() {
		/**
		 * 
		 */
		final int RATIO_APARICION_MONSTRUO = 40;
		/**
		 * Calcula el porcentaje de aparición de un mosntruo y esto solo puede suceder
		 * si no existe jarrón
		 */
		if ((Math.random() * 100) + 1 <= RATIO_APARICION_MONSTRUO) {
			return true;
		} else {
			return false;
		}
	}

	private boolean generarJarron() {
		/**
		 * 
		 */
		final int RATIO_APARICION_JARRON = 40;
		/**
		 * Calcula el porcentaje de aparición de un mosntruo y esto solo puede suceder
		 * si no existe jarrón
		 */
		if ((Math.random() * 100) + 1 <= RATIO_APARICION_JARRON) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 
	 * @param fila
	 * @param columna
	 */
	private void calcularNumeroMinas(int fila, int columna) {
		Celda[][] copiaMapaCeldas = getMapaCeldas();
		for (int i = fila - 1; i < fila + 2; i++) {
			for (int t = columna - 1; t < columna + 2; t++) {
				if (i >= 0 && i < 8 && t >= 0 && t < 8) {
					if (getMapaCeldas()[i][t].isTieneMina()) {
						copiaMapaCeldas[fila][columna].setNumero(copiaMapaCeldas[fila][columna].getNumero() + 10);
					}else if(getMapaCeldas()[i][t].isTieneMonstruo()) {
						copiaMapaCeldas[fila][columna].setNumero(copiaMapaCeldas[fila][columna].getNumero() + 1);
					}else if(getMapaCeldas()[i][t].isTieneJarron()) {
						copiaMapaCeldas[fila][columna].setNumero(copiaMapaCeldas[fila][columna].getNumero() + 2);
					}
				}
			}
		}
		setMapaCeldas(copiaMapaCeldas);

	}

	public void establecerNumeroMinas() {
		for (int i = 0; getMapaCeldas().length > i; i++) {
			for (int t = 0; getMapaCeldas()[i].length > t; t++) {
				if (!getMapaCeldas()[i][t].isTieneMina() && !getMapaCeldas()[i][t].isTieneJarron()
						&& !getMapaCeldas()[i][t].isTieneMonstruo()) {
					calcularNumeroMinas(i, t);

				}

			}

		}
	}
}
