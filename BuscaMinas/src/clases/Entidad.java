package clases;
/**
 * @Autor Danilo José Mendez Mendez
 *@version 10/02/2026
 */
public abstract class Entidad{
	
	protected int cantidadVida;
	protected int cantidadAtaque;
	/**
	 * @param cantidadVida
	 * @param cantidadAtaque
	 */
	public Entidad(int cantidadVida, int cantidadAtaque) {
		super();
		this.cantidadVida = cantidadVida;
		this.cantidadAtaque = cantidadAtaque;
	}
	/**
	 * @return the cantidadVida
	 */
	public int getCantidadVida() {
		return cantidadVida;
	}
	/**
	 * @param cantidadVida the cantidadVida to set
	 */
	public void setCantidadVida(int cantidadVida) {
		this.cantidadVida = cantidadVida;
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
