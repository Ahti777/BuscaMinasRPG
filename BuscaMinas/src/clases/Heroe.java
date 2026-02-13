package clases;
/**
 * @Autor Danilo José Mendez Mendez
 *@version 10/02/2026
 */
import java.util.ArrayList;

public class Heroe extends Entidad{
	/**
	 * experiencia es un numero que permite subir de nivel
	 */
	private int cantidadExperiencia;
	private ArrayList<Equipamiento>miEquipamiento;
	private ArrayList<Ataque>listaAtaques;
	/**
	 * @param cantidadVida
	 * @param cantidadAtaque
	 * @param cantidadExperiencia
	 * @param miEquipamiento
	 * @param listaAtaques
	 */
	public Heroe(int cantidadVida, int cantidadAtaque, int cantidadExperiencia, ArrayList<Equipamiento> miEquipamiento,
			ArrayList<Ataque> listaAtaques) {
		super(cantidadVida, cantidadAtaque);
		this.cantidadExperiencia = cantidadExperiencia;
		this.miEquipamiento = miEquipamiento;
		this.listaAtaques = listaAtaques;
	}
	/**
	 * @return the cantidadExperiencia
	 */
	public int getCantidadExperiencia() {
		return cantidadExperiencia;
	}
	/**
	 * @param cantidadExperiencia the cantidadExperiencia to set
	 */
	public void setCantidadExperiencia(int cantidadExperiencia) {
		this.cantidadExperiencia = cantidadExperiencia;
	}
	/**
	 * @return the miEquipamiento
	 */
	public ArrayList<Equipamiento> getMiEquipamiento() {
		return miEquipamiento;
	}
	/**
	 * @param miEquipamiento the miEquipamiento to set
	 */
	public void setMiEquipamiento(ArrayList<Equipamiento> miEquipamiento) {
		this.miEquipamiento = miEquipamiento;
	}
	/**
	 * @return the listaAtaques
	 */
	public ArrayList<Ataque> getListaAtaques() {
		return listaAtaques;
	}
	/**
	 * @param listaAtaques the listaAtaques to set
	 */
	public void setListaAtaques(ArrayList<Ataque> listaAtaques) {
		this.listaAtaques = listaAtaques;
	}

}
