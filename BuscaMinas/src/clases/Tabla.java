package clases;

import Excepciones.CeldaYaSeleccionada;

/**
 * @author Danilo José Mendez Mendez / Artem Zimin Litvak
 * @version 17/02/2026
 * 
 * 
 */
public class Tabla {
	/**
	 * filas: cantidad de filas de contiene la tabla.
	 * columnas: cantidad de columnas que tiene la tabla.
	 * mapaCeldas: mapeado de las celdas, creando una tabla.
	 * minimoFilasColumnas: es el minimo de filas y columnas que se pueden crear.
	 */
	private int filas;
	private int columnas;
	private Celda[][] mapaCeldas;
	private final int minimoFilasColumnas = 8;

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
		if (filas < minimoFilasColumnas || columnas < minimoFilasColumnas) {
			this.filas = minimoFilasColumnas;
			this.columnas = minimoFilasColumnas;
		} else {
			this.filas = filas;
			this.columnas = columnas;
		}
		this.mapaCeldas = new Celda[this.filas][this.columnas];
		this.mapaCeldas = generarTablero();
		establecerNumeroMinas();

	}

	/**
	 * @return the filas
	 */
	public int getFilas() {
		return filas;
	}

	/**
	 * @param filas the filas to set
	 */
	public void setFilas(int filas) {
		this.filas = filas;
	}

	/**
	 * @return the columnas
	 */
	public int getColumnas() {
		return columnas;
	}

	/**
	 * @param columnas the columnas to set
	 */
	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	/**
	 * @return the mapaCeldas
	 */
	public Celda[][] getMapaCeldas() {
		return mapaCeldas;
	}

	/**
	 * @param mapaCeldas the mapaCeldas to set
	 */
	public void setMapaCeldas(Celda[][] mapaCeldas) {
		this.mapaCeldas = mapaCeldas;
	}

	/**
	 * generarTablero(): establece el contenido de cada celda, si es mina, jarron, monstruo o nada.
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
	 * generarMinas: calcula el 40 porciento de aparición de minas.
	 * 
	 * @return boolean
	 */
	private boolean generarMinas() {
		/**
		 * RATIO_APARICION_MINAS: es el porcentaje de aparición de que una celda sea
		 * mina.
		 */
		final int RATIO_APARICION_MINAS = 40;
		/**
		 * Calcula el porcentaje de aparicioó y devuelve un boolean.
		 */
		if ((Math.random() * 100) + 1 <= RATIO_APARICION_MINAS) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * generarMonstruo(): calcula el 40 porciento de aparición de minas.
	 * 
	 * @return boolean
	 */
	private boolean generarMonstruo() {
		/**
		 * RATIO_APARICION_MONSTRUO: es el porcentaje de que una celda sea mosntruo.
		 */
		final int RATIO_APARICION_MONSTRUO = 40;
		/*
		 * Calcula el porcentaje de aparición de un mosntruo y esto solo puede suceder
		 * si no existe jarrón.
		 */
		if ((Math.random() * 100) + 1 <= RATIO_APARICION_MONSTRUO) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * generarJarron(): calcula el 40 porciento de aparición de el jarrón.
	 * 
	 * @return
	 */
	private boolean generarJarron() {
		/**
		 * RATIO_APARICION_JARRON: es el porcentake de que una celda sea jarrón.
		 */
		final int RATIO_APARICION_JARRON = 40;
		/**
		 * Calcula el porcentaje de aparición de un mosntruo y esto solo puede suceder.
		 * si no existe jarrón
		 */
		if ((Math.random() * 100) + 1 <= RATIO_APARICION_JARRON) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * calcularNumeroMinas(): calcula la cantidad de minas, monstruos y jarrones tiene alrededor la celda.
	 * 
	 * @param fila
	 * @param columna
	 */
	private void calcularNumeroMinas(int fila, int columna) {
		Celda[][] copiaMapaCeldas = getMapaCeldas();
		for (int i = fila - 1; i < fila + 2; i++) {
			for (int t = columna - 1; t < columna + 2; t++) {
				if (i >= 0 && i < filas && t >= 0 && t < columnas) {
					if (getMapaCeldas()[i][t].isTieneMina()) {
						copiaMapaCeldas[fila][columna].setNumero(copiaMapaCeldas[fila][columna].getNumero() + 10);
					} else if (getMapaCeldas()[i][t].isTieneMonstruo()) {
						copiaMapaCeldas[fila][columna].setNumero(copiaMapaCeldas[fila][columna].getNumero() + 1);
					} else if (getMapaCeldas()[i][t].isTieneJarron()) {
						copiaMapaCeldas[fila][columna].setNumero(copiaMapaCeldas[fila][columna].getNumero() + 2);
					}
				}
			}
		}
		setMapaCeldas(copiaMapaCeldas);

	}

	/**
	 * establecerNumeroMinas(): compruba que la celda no sea mina, jarrón ni mostruo
	 * para poder calcular su número.
	 */
	private void establecerNumeroMinas() {
		for (int i = 0; getMapaCeldas().length > i; i++) {
			for (int t = 0; getMapaCeldas()[i].length > t; t++) {
				if (!getMapaCeldas()[i][t].isTieneMina() && !getMapaCeldas()[i][t].isTieneJarron()
						&& !getMapaCeldas()[i][t].isTieneMonstruo()) {
					calcularNumeroMinas(i, t);

				}

			}

		}
	}

	/**
	 * verificarCeldaYaSeleccionada(int fila, int columna): verifica si la celda que elige el usuario ya ha sido seleccionada, comporbandolo mediante su
	 * visibilidad.
	 * 
	 * @param fila
	 * @param columna
	 * @throws CeldaYaSeleccionada
	 */
	public void verificarCeldaYaSeleccionada(int fila, int columna) throws CeldaYaSeleccionada {
		for (int i = 0; i < mapaCeldas.length; i++) {
			for (int t = 0; t < mapaCeldas.length; t++) {
				if (i == fila && t == columna) {
					if (mapaCeldas[i][t].isVisible()) {
						throw new CeldaYaSeleccionada();
					}
				}
			}
		}
	}
	/**
	 * contarCeldasVaciasJarron(): cuenta las celdas que son Jarron o están vacias
	 * @return int
	 */
	private int contarCeldasVaciasJarron() {
		int cantidadCeldasVaciasJarron = 0;
		for (int i = 0; mapaCeldas.length > i; i++) {
			for (int t = 0; mapaCeldas[i].length > t; t++) {
				if (mapaCeldas[i][t].isTieneJarron() || !mapaCeldas[i][t].isTieneMina()
						|| !mapaCeldas[i][t].isTieneMonstruo()) {
					cantidadCeldasVaciasJarron++;
				}
			}
		}
		return cantidadCeldasVaciasJarron;
	}
	/**
	 * ganarPartida(): cuenta cuantas celdas son Jarron o están vacias y que son visibles, para después compararlo con la cantidad total de celdas Jarron y vacias. Esto determina si ganas o no.
	 * @return boolean
	 */
	public boolean ganarPartida() {
		int cantidadCeldasVaciasJarron = contarCeldasVaciasJarron();
		int cantidadCeldasVisiblesVaciasJarron = 0;
		for (int i = 0; mapaCeldas.length > i; i++) {
			for (int t = 0; mapaCeldas[i].length > t; t++) {
				if (mapaCeldas[i][t].isVisible()) {
					if (mapaCeldas[i][t].isTieneJarron() || !mapaCeldas[i][t].isTieneMina()
							|| !mapaCeldas[i][t].isTieneMonstruo()) {
						cantidadCeldasVisiblesVaciasJarron++;
					}
				}
			}
		}
		if (cantidadCeldasVaciasJarron == cantidadCeldasVisiblesVaciasJarron) {
			return true;
		} else {
			return false;
		}

	}

}
