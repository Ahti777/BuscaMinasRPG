package clases;

import java.util.ArrayList;

/**
 * @Autor Danilo José Mendez Mendez
 *@version 10/02/2026
 */
public class Jarron extends Entidad{
	
	public Jarron(int cantidadVida, int cantidadAtaque) {
		super(cantidadVida, cantidadAtaque);
	}
	/**
	 * darVida(): permite aumentar la vida que posee el heroe
	 */
	public void darVida(Heroe usoHeroe) {
		usoHeroe.setCantidadVidaRestante((int) (usoHeroe.getCantidadVidaRestante()*0.15));
	}
	/**
	 * darExperiencia(): le da al heroe una cantidad de experiencia
	 * @param usoHeroe
	 */
	public void darExperiencia(Heroe usoHeroe) {
		usoHeroe.setCantidadVidaRestante(4);
	}
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
	 * generarAleatoriedadAcciones(): elige de forma aleatoria si ejeutar el método darVida(), darEquipamiento(),darExperiencia() o nada
	 * @param usoHeroe
	 * @param listaEquipamientoDisponible
	 */
	public void generarAleatoriedadAcciones(Heroe usoHeroe, ArrayList<Equipamiento> listaEquipamientoDisponible) {
		int numeroAleatorio = (int) ((Math.random()*125)+1);
		
		if(numeroAleatorio>=0 && numeroAleatorio<25) {
			darVida(usoHeroe);
			System.out.println("vida");
		}else if(numeroAleatorio>=25 && numeroAleatorio<50) {
			darEquipamiento(usoHeroe, listaEquipamientoDisponible);
			System.out.println("Equipamiento");
		}else if(numeroAleatorio>=50 && numeroAleatorio<75) {
			darExperiencia(usoHeroe);
			System.out.println("experiencia");
		}else if(numeroAleatorio>=75 && numeroAleatorio<125) {
			System.out.println("La nada"
					+ "");
		}
	}
	
}
