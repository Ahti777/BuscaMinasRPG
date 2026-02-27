package vista;

import clases.Tabla;

/**
 * @author Danilo José Mendez Mendez / Artem Zimin Litvak
 * @version 17/02/2026
 * 
 * BuscaMinasVista: 
 */
public interface BuscaMinasVista {
	/**
	 * mostrarMensaje():
	 * @return void
	 */
	void mostrarMensaje(String texto);
	/**
	 * pedirFila():
	 * @return int
	 */
	int pedirFila();
	/**
	 * pedirColumna():
	 * @return int
	 */
	int pedirColumna();
	/**
	 * mostrarTable():
	 * @return void
	 */
	void mostrarTabla(Tabla usoTabla);

}
