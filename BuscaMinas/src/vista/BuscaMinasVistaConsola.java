package vista;

import java.util.Scanner;

import clases.Heroe;
import clases.Tabla;
/**
 * @author Artem Zimin Litvak
 * @version 17/02/2026
 */
public class BuscaMinasVistaConsola implements BuscaMinasVista {

	public BuscaMinasVistaConsola() {
		super();
	}

	@Override
	public void mostrarMensaje(String texto) {
		System.out.println(texto);
	}

	@SuppressWarnings("resource")
	@Override
	public int pedirFila() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Qué cantidad de filas quiere que tenga la tabla?");
		return teclado.nextInt();
	}

	@SuppressWarnings("resource")
	@Override
	public int pedirColumna() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Qué cantidad de Kolumnas va a tener la tabla?");
		return teclado.nextInt();
	}

	@Override
	public void mostrarTabla(Tabla usoTabla) {
		for (int i = 0; usoTabla.getMapaCeldas().length > i; i++) {
			for (int t = 0; usoTabla.getMapaCeldas()[i].length > t; t++) {
				if (usoTabla.getMapaCeldas()[i][t].isVisible()) {
					if (usoTabla.getMapaCeldas()[i][t].isTieneMina()) {
						System.out.print("X ");
					}else if(usoTabla.getMapaCeldas()[i][t].isTieneJarron()) {
						System.out.print("U ");
					}else if(usoTabla.getMapaCeldas()[i][t].isTieneMonstruo()) {
						System.out.print("M ");
					}else {
						System.out.print(usoTabla.getMapaCeldas()[i][t].getNumero() + " ");
					}
				} else {
					System.out.print(" - ");
				}
			}
			System.out.println("");
		}

	}

	public void mostrarTablaVisible(Tabla usoTabla) {
		for (int i = 0; usoTabla.getMapaCeldas().length > i; i++) {
			for (int t = 0; usoTabla.getMapaCeldas()[i].length > t; t++) {
				usoTabla.getMapaCeldas()[i][t].setVisible(true);
				if (usoTabla.getMapaCeldas()[i][t].isVisible()) {
					if (usoTabla.getMapaCeldas()[i][t].isTieneMina()) {
						System.out.print("X ");
					} else {
						System.out.print(usoTabla.getMapaCeldas()[i][t].getNumero() + " ");
					}
				} else {
					System.out.print(" - ");
				}
			}
			System.out.println("");
		}

	}
	
	public void mostrarEstadisticasHeroe(Heroe usoHeroe) {
		System.out.println("Estadísticas Heroe: ");
		System.out.println("Vida: "+usoHeroe.getCantidadVida()+" Experiencia: "+usoHeroe.getCantidadExperiencia());
	}

}
