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
	 * 
	 */
	public void darVida(Heroe usoHeroe) {
		usoHeroe.setCantidadVida((int) (usoHeroe.getCantidadVida()*0.15));
	}
	public void darExperiencia(Heroe usoHeroe) {
		usoHeroe.setCantidadVida(4);
	}
	public void darEquipamiento(Heroe usoHeroe, ArrayList<Equipamiento> listaEquipamientoDisponible) {
		
		
	}
	public void generarAleatoriedadAcciones(Heroe usoHeroe, ArrayList<Equipamiento> listaEquipamientoDisponible) {
		int numeroAleatorio = (int) ((Math.random()*125)+1);
		if(numeroAleatorio>=0 && numeroAleatorio<25) {
			darVida(usoHeroe);
		}else if(numeroAleatorio>=25 && numeroAleatorio<50) {
			darEquipamiento(usoHeroe, listaEquipamientoDisponible);
		}else if(numeroAleatorio>=50 && numeroAleatorio<75) {
			darExperiencia(usoHeroe);
		}else if(numeroAleatorio>=75 && numeroAleatorio<125) {
			
		}
	}
	
}
