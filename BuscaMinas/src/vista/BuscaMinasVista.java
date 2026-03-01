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
	 * mostrarMensaje(): muestra un String.
	 * @return void
	 */
	void mostrarMensaje(String texto);
	/**
	 * pedirFila(): pide la cantidad de filas máximas de la tabla.
	 * @return int
	 */
	int pedirFila(); 
	/**
	 * pedirColumna(): pide la cantidad de columas máximas de la tabla.
	 * @return int
	 */
	int pedirColumna();
	/**
	 * mostrarTable(): mustra la tabla
	 * @return void
	 */
	void mostrarTabla(Tabla usoTabla);

}
