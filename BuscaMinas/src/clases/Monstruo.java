package clases;

/**
 * @Autor Danilo José Mendez Mendez / Artem Zimin Litvak
 * @version 10/02/2026
 * 
 * Monstruo: Entidad que es la oposición al Heroe.
 */
public class Monstruo extends Entidad{
	
	/**
	 * @param cantidadVida
	 * @param cantidadAtaque
	 */
	public Monstruo(int cantidadVida, int cantidadAtaque) {
		super(cantidadVida, cantidadAtaque);
	}
	/**
	 * darExperiencia(Heroe usoHeroe): suministra experiencia a Heroe.
	 */
	public void darExperiencia(Heroe usoHeroe) {
		usoHeroe.setCantidadExperiencia(usoHeroe.getCantidadExperiencia()+3);

	}
	
	
	
}
