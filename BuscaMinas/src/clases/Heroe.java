package clases;

/**
 * @Autor Artem Zimin Litvak
 *@version 17/02/2026
 */
import java.util.ArrayList;
import java.util.Iterator;

public class Heroe extends Entidad {
	/**
	 * cantidadExperiencia: la cantidad de experiencia que posee Heroe
	 * miEquipamiento: lista de objetos que posee Heroe
	 * listaAtaques: lista de ataques que puede usar Heroe
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
	public Heroe(int cantidadVidaMaxima, int cantidadAtaque, int cantidadExperiencia, ArrayList<Equipamiento> miEquipamiento,
			ArrayList<Ataque> listaAtaques) {
		super(cantidadVidaMaxima, cantidadAtaque);
		this.cantidadExperiencia = cantidadExperiencia;
		this.miEquipamiento = miEquipamiento;
		this.listaAtaques = listaAtaques;
		Ataque ceroNivel = new Ataque("Tajo", 0.0, 1);
		listaAtaques.add(ceroNivel);
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
	 * @return int
	 */
	public int calcularDañoAtaque(Heroe usoHeroe, int num) {
		return (int) (usoHeroe.getCantidadAtaque() * usoHeroe.getListaAtaques().get(num).getEscaladoDaño()) + 1;
	}
	/**
	 * subirNivel(): añade a ataques a la listaAtaques al llegar a cierto punto de experiencia
	 */
	public void subirNivel() {
		/**
		 * RECORDAR: ESTO SON DATOS DE PRUEBA. NO APARECERAN EN LA VERSIÓN DE VERDAD
		 */
		ArrayList<Ataque> copiaListaAtaques = listaAtaques;
		Ataque primerNivel = new Ataque("Golpe ascendente con backflip", 0.20, 1.2);
		Ataque segundoNivel = new Ataque("Golpe ascendente con baile", 0.20, 1.2);
		Ataque terceroNivel = new Ataque("Golpe mediante una mona china frigorifico", 0.20, 1.2);
		if (cantidadExperiencia == 3) {
			copiaListaAtaques.add(primerNivel);
			cantidadVidaMaxima+=3;
			cantidadVidaRestante = cantidadVidaMaxima;
		} else if (cantidadExperiencia == 6) {
			copiaListaAtaques.add(segundoNivel);
			cantidadVidaMaxima+=3;
			cantidadVidaRestante = cantidadVidaMaxima;
		} else if (cantidadExperiencia == 10) {
			copiaListaAtaques.add(terceroNivel);
			cantidadVidaMaxima+=3;
			cantidadVidaRestante = cantidadVidaMaxima;
		} 
		setListaAtaques(copiaListaAtaques);
	}
	/**
	 * toStringHeroe(): muestra la cantidadVida, cantidadAtaque y cantidadExperiencia del Heroe
	 * @return String
	 */
	public String toStringHeroe() {
		return cantidadVidaRestante+" "+cantidadAtaque+" "+cantidadExperiencia;
	}
	
	/**
	 * toStringListaAtaques(): muestra los ataques que posee el heroe
	 * @return String
	 */
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
