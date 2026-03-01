package clases;

import java.util.ArrayList;

/**
 * @Autor Danilo José Mendez Mendez / Artem Zimin Litvak
 * @version 10/02/2026
 * 
 * Jarron: Entidad que permite porporcionar varias mejoras a Heroe o nada.
 */
public class Jarron extends Entidad{
	
	public Jarron(int cantidadVida, int cantidadAtaque) {
		super(cantidadVida, cantidadAtaque);
	}
	/**
	 * darVida(): permite aumentar la vida que posee el heroe.
	 */
	public void darVida(Heroe usoHeroe) {
		if(usoHeroe.getCantidadVidaRestante()+(usoHeroe.getCantidadVidaRestante()*0.15)>usoHeroe.getCantidadVidaMaxima()) {
			usoHeroe.setCantidadVidaRestante(usoHeroe.getCantidadVidaMaxima());
		}else {
			usoHeroe.setCantidadVidaRestante((int) (1+usoHeroe.getCantidadVidaRestante()+(usoHeroe.getCantidadVidaRestante()*0.15)));
		}
	}
	/**
	 * darExperiencia(): le da al heroe una cantidad de experiencia.
	 * @param usoHeroe
	 */
	public void darExperiencia(Heroe usoHeroe) {
		usoHeroe.setCantidadVidaRestante(3);
	}
	/**
	 * 
	 * @param usoHeroe
	 * @param listaEquipamientoDisponible
	 */
	public void darEquipamiento(Heroe usoHeroe, ArrayList<Equipamiento> listaEquipamientoDisponible) {
		int indiceAleatorioEquipamiento;
		ArrayList<Equipamiento> nuevaListaObjetos = usoHeroe.getMiEquipamiento();
		boolean condicion=true;
		do{
			indiceAleatorioEquipamiento = (int) (Math.random()*listaEquipamientoDisponible.size());
			if(!usoHeroe.getMiEquipamiento().contains(listaEquipamientoDisponible.get(indiceAleatorioEquipamiento))) {
				nuevaListaObjetos.add(listaEquipamientoDisponible.get(indiceAleatorioEquipamiento));
				condicion = false;
			}
		}while(condicion);
		
	}
	/**
	 * generarAleatoriedadAcciones(): elige de forma aleatoria si ejeutar el método darVida(), darEquipamiento(),darExperiencia() o nada.
	 * @param usoHeroe
	 * @param listaEquipamientoDisponible
	 */
	public void generarAleatoriedadAcciones(Heroe usoHeroe, ArrayList<Equipamiento> listaEquipamientoDisponible) {
		int numeroAleatorio = (int) ((Math.random()*125)+1);
		
		if(numeroAleatorio>=0 && numeroAleatorio<25) {
			darVida(usoHeroe);
			System.out.println("El jarrón se romprió, y ahora te sientes más vivo.");
		}else if(numeroAleatorio>=25 && numeroAleatorio<50) {
			darEquipamiento(usoHeroe, listaEquipamientoDisponible);
			System.out.println("El jarron proporcionó equipamiento al heroe.");
		}else if(numeroAleatorio>=50 && numeroAleatorio<75) {
			darExperiencia(usoHeroe);
			usoHeroe.subirNivel();
			System.out.println("El jarrón dio experiencia sobre el combate.");
		}else if(numeroAleatorio>=75 && numeroAleatorio<125) {
			System.out.println("El jarron sólo tenía polvo dentro");
		}
	}
	
}
