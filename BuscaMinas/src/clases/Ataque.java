package clases;
/**
 * @Autor Danilo José Mendez Mendez
 *@version 10/02/2026
 */
public class Ataque {
	private String nombre;
	private double cantidadAcierto;
	private double escaladoDaño;
	/**
	 * @param nombre
	 * @param cantidadAcierto
	 * @param escaladoDaño
	 */
	public Ataque(String nombre, double cantidadAcierto, double escaladoDaño) {
		this.nombre = nombre;
		this.cantidadAcierto = cantidadAcierto;
		this.escaladoDaño = escaladoDaño;
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
	 * @return the cantidadAcierto
	 */
	public double getCantidadAcierto() {
		return cantidadAcierto;
	}
	/**
	 * @param cantidadAcierto the cantidadAcierto to set
	 */
	public void setCantidadAcierto(int cantidadAcierto) {
		this.cantidadAcierto = cantidadAcierto;
	}
	/**
	 * @return the escaladoDaño
	 */
	public double getEscaladoDaño() {
		return escaladoDaño;
	}
	/**
	 * @param escaladoDaño the escaladoDaño to set
	 */
	public void setEscaladoDaño(double escaladoDaño) {
		this.escaladoDaño = escaladoDaño;
	}
	
	
}
