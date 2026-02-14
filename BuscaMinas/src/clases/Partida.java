package clases;

/**
 * @Autor Danilo José Mendez Mendez
 * @version 10/02/2026
 */
public class Partida {
	private String nombre;
	private int id;

	/**
	 * @param nombre
	 */
	public Partida(int id, String nombre) {
		super();
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Partida{" + "id= " + id + ", nombre='" + nombre + '\'' + '}';
	}

}
