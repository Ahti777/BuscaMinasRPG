package clases;
/**
 * @Autor Danilo José Mendez Mendez
 *@version 10/02/2026
 */
public class Equipamiento {
	
	private String nombre;
	private int cantVidaAumenta;
	/**
	 * @param nombre
	 * @param cantVidaAumenta
	 */
	public Equipamiento(String nombre, int cantVidaAumenta) {
		super();
		this.nombre = nombre;
		this.cantVidaAumenta = cantVidaAumenta;
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
	 * @return the cantVidaAumenta
	 */
	public int getCantVidaAumenta() {
		return cantVidaAumenta;
	}
	/**
	 * @param cantVidaAumenta the cantVidaAumenta to set
	 */
	public void setCantVidaAumenta(int cantVidaAumenta) {
		this.cantVidaAumenta = cantVidaAumenta;
	}
	
}
