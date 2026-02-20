package clases;

/**
 * @Autor Artem Zimin Litvak
 * @version 10/02/2026
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
	 * darExperiencia(Heroe usoHeroe): suministra experiencia a Heroe
	 * RECORDATORIO: ESTO NO ES LA FUNCIÓN DEFINITIVA
	 */
	public void darExperiencia(Heroe usoHeroe) {
		usoHeroe.setCantidadExperiencia(usoHeroe.getCantidadExperiencia()+4);

	}
	/**
	 * 
	 * @param miAtaque
	 */
	public void ataqueMonstruo(Ataque miAtaque) {
		
	}
	
	
}
