package clases;

/**
 * @Autor Danilo José Mendez Mendez / Artem Zimin Litvak
 * @version 10/02/2026
 * 
 * Partida: permite asignar y gestionar mediante un id y nombre los distintos inicios de juego.
 */
public class Partida {
	static private int contadorPartidas;
	private int id;
	private String nombre;

	/**
	 * @param nombre
	 * RECORDATORIO: GENERAR ID ÚNICO PARA CADA PARTIDA
	 */
	public Partida(String nombre) {
		super();
		id=contadorPartidas;
		contadorPartidas++;
		this.nombre = nombre;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * 
	 * @return 
	 */
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Partida{" + "id= " + id + ", nombre='" + nombre + '\'' + '}';
	}

}
