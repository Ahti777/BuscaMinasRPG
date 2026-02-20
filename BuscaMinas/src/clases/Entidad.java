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
	protected int cantidadVidaMaxima;
	protected int cantidadVidaRestante;
	protected int cantidadAtaque;
	/**
	 * @param cantidadVida
	 * @param cantidadAtaque
	 */
	public Entidad(int cantidadVidaMaxima, int cantidadAtaque) {
		this.cantidadVidaMaxima = cantidadVidaMaxima;
		this.cantidadVidaRestante = cantidadVidaMaxima;
		this.cantidadAtaque = cantidadAtaque;
	}
	/**
	 * @return the cantidadVidaMaxima
	 */
	public int getCantidadVidaMaxima() {
		return cantidadVidaMaxima;
	}
	/**
	 * @param cantidadVidaMaxima the cantidadVidaMaxima to set
	 */
	public void setCantidadVidaMaxima(int cantidadVidaMaxima) {
		this.cantidadVidaMaxima = cantidadVidaMaxima;
	}
	/**
	 * @return the cantidadVidaRestante
	 */
	public int getCantidadVidaRestante() {
		return cantidadVidaRestante;
	}
	/**
	 * @param cantidadVidaRestante the cantidadVidaRestante to set
	 */
	public void setCantidadVidaRestante(int cantidadVidaRestante) {
		this.cantidadVidaRestante = cantidadVidaRestante;
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
