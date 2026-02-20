package clases;
/**
 * @Autor Danilo José Mendez Mendez
 *@version 10/02/2026
 */
public abstract class Entidad{
	/**
	 * cantidadVidaMaxima: cantidad límite de vida
	 * cantidadVidaRestante: cantidad de vida que se modifica
	 */
	protected final int cantidadVidaMaxima;
	protected int cantidadVidaRestante;
	protected int cantidadAtaque;
	/**
	 * @param cantidadVida
	 * @param cantidadAtaque
	 */
	public Entidad(int cantidadVidaMaxima, int cantidadAtaque) {
		super();
		this.cantidadVidaMaxima = cantidadVidaMaxima;
		this.cantidadVidaRestante = cantidadVidaMaxima;
		this.cantidadAtaque = cantidadAtaque;
	}
	/**
	 * @return the cantidadVida
	 */
	public int getCantidadVida() {
		return cantidadVidaRestante;
	}
	/**
	 * @param cantidadVida the cantidadVida to set
	 */
	public void setCantidadVida(int cantidadVida) {
		this.cantidadVidaRestante = cantidadVida;
	}
	/**
	 * @return the cantidadAtaque
	 */
	public int getCantidadAtaque() {
		return cantidadAtaque;
	}
	/**
	 * @param cantidadAtaque the cantidadAtaque to set
	 */
	public void setCantidadAtaque(int cantidadAtaque) {
		this.cantidadAtaque = cantidadAtaque;
	}
	
	
}
