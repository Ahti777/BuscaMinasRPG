package clases;

/**
 * @Autor Artem Zimin Litvak
 *@version 17/02/2026
 */
import java.util.ArrayList;
import java.util.Iterator;

public class Heroe extends Entidad {
	/**
	 * experiencia es un numero que permite subir de nivel
	 */
	private int cantidadExperiencia;
	private ArrayList<Equipamiento> miEquipamiento;
	private ArrayList<Ataque> listaAtaques;

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

	/**
	 * 
	 * @param usoHeroe
	 * @param num
	 * @return
	 */
	public int calcularDañoAtaque(Heroe usoHeroe, int num) {
		return (int) (usoHeroe.getCantidadAtaque() * usoHeroe.getListaAtaques().get(num).getEscaladoDaño()) + 1;
	}

	public void subirNivel() {
		/**
		 * RECORDAR: ESTO SON DATOS DE PRUEBA. NO APARECERAN EN LA VERSIÓN DE VERDAD
		 */
		ArrayList<Ataque> copiaListaAtaques = listaAtaques;
		Ataque ceroNivel = new Ataque("Tajo", 0.0, 1);
		Ataque primerNivel = new Ataque("Golpe ascendente con backflip", 0.20, 1.2);
		Ataque segundoNivel = new Ataque("Golpe ascendente con baile", 0.20, 1.2);
		Ataque terceroNivel = new Ataque("Golpe mediante una mona china frigorifico", 0.20, 1.2);
		if (cantidadExperiencia == 3) {
			copiaListaAtaques.add(primerNivel);
		} else if (cantidadExperiencia == 6) {
			copiaListaAtaques.add(segundoNivel);
		} else if (cantidadExperiencia == 10) {
			copiaListaAtaques.add(terceroNivel);
		} else if(cantidadExperiencia==0) {
			copiaListaAtaques.add(ceroNivel);
		}
		setListaAtaques(copiaListaAtaques);
	}
	
	public String toStringHeroe() {
		return cantidadVida+" "+cantidadAtaque+" "+cantidadExperiencia;
	}
	
	public String toStringListaAtaques() {
		String salida = "";
		int contador = 0;
		Iterator<Ataque> it = listaAtaques.iterator();
		while(it.hasNext()) {
			Ataque entrada = it.next();
			salida+=contador+". "+entrada.getNombre()+" Cantidad fallo: "+entrada.getCantidadAcierto()+" Aumento de daño: "+entrada.getEscaladoDaño()+"\n";
		}
		return salida;
	}

}
