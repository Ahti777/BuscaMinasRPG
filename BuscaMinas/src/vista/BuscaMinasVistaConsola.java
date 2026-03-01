package vista;

import java.util.Scanner;

import clases.Heroe;
import clases.Tabla;
/**
 * @author Danilo José Mendez Mendez / Artem Zimin Litvak
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
		System.out.println("Qué cantidad de filas quiere que tenga la tabla?(mínimo 8)");
		return teclado.nextInt();
	}

	@SuppressWarnings("resource")
	@Override
	public int pedirColumna() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Qué cantidad de columnas va a tener la tabla?(mínimo 8)");
		return teclado.nextInt();
	}
	/**
	 * mostrarTabla(Tabla usoTabla): muestra la tabla completa
	 */
	@Override
	public void mostrarTabla(Tabla usoTabla) {
		System.out.println("===============================");
		for(int i = 0; usoTabla.getMapaCeldas().length > i; i++) {
			if(i==0) {
				System.out.print("   "+i);
			}else if(i==(usoTabla.getMapaCeldas().length -1)) {
				System.out.print("  "+i+"\n");
			}
			else {
				System.out.print("  "+i);
			}
		}
		for (int i = 0; usoTabla.getMapaCeldas().length > i; i++) {
			System.out.print(i+" ");
			for (int t = 0; usoTabla.getMapaCeldas()[i].length > t; t++) {
				if (usoTabla.getMapaCeldas()[i][t].isVisible()) {
					if (usoTabla.getMapaCeldas()[i][t].isTieneMina()) {
						System.out.print(" X ");
					}else if(usoTabla.getMapaCeldas()[i][t].isTieneJarron()) {
						System.out.print(" U ");
					}else if(usoTabla.getMapaCeldas()[i][t].isTieneMonstruo()) {
						System.out.print(" M ");
					}else {
						if(usoTabla.getMapaCeldas()[i][t].getNumero()>9) {
							System.out.print(usoTabla.getMapaCeldas()[i][t].getNumero() + " ");
						}else {
							System.out.print("0"+usoTabla.getMapaCeldas()[i][t].getNumero()+" ");
						}
					}
				} else {
					System.out.print(" - ");
				}
			}
			System.out.println("");
		}
		System.out.println("===============================");

	}
	/**
	 * mostrarTablaVisible(Tabla usoTabla): muestra la tabla completa visible
	 * @param usoTabla
	 */
	public void mostrarTablaVisible(Tabla usoTabla) {
		System.out.println("****************************");
		for(int i = 0; usoTabla.getMapaCeldas().length > i; i++) {
			if(i==0) {
				System.out.print("   "+i);
			}else if(i==(usoTabla.getMapaCeldas().length -1)) {
				System.out.print("  "+i+"\n");
			}
			else {
				System.out.print("  "+i);
			}
		}
		for (int i = 0; usoTabla.getMapaCeldas().length > i; i++) {
			System.out.print(i+" ");
			for (int t = 0; usoTabla.getMapaCeldas()[i].length > t; t++) {
				usoTabla.getMapaCeldas()[i][t].setVisible(true);
				if (usoTabla.getMapaCeldas()[i][t].isVisible()) {
					if (usoTabla.getMapaCeldas()[i][t].isTieneMina()) {
						System.out.print(" X ");
					}else if(usoTabla.getMapaCeldas()[i][t].isTieneJarron()) {
						System.out.print(" U ");
					}else if(usoTabla.getMapaCeldas()[i][t].isTieneMonstruo()) {
						System.out.print(" M ");
					}else {
						if(usoTabla.getMapaCeldas()[i][t].getNumero()>9) {
							System.out.print(usoTabla.getMapaCeldas()[i][t].getNumero() + " ");
						}else {
							System.out.print("0"+usoTabla.getMapaCeldas()[i][t].getNumero()+" ");
						}
					}
				} else {
					System.out.print(" - ");
				}
			}
			System.out.println("");
		}
		System.out.println("****************************");

	}

	/**
	 * mostrarEstadisticasHeroe(Heroe usoHeroe): muestra las estadísticas del Heroe
	 * @param usoHeroe
	 */
	public void mostrarEstadisticasHeroe(Heroe usoHeroe) {
		System.out.println("==============================");
		System.out.println("Estadísticas Heroe: ");
		System.out.println("Vida: "+usoHeroe.getCantidadVidaRestante()+" Experiencia: "+usoHeroe.getCantidadExperiencia());
		System.out.println("==============================");
	}
	/**
	 * mostrarTutorial(): muestra una breve historia con un tutorial de como funciona el juego.
	 */
	public void mostrarTutorial() {
		System.out.println("\n"
				+ "Gracias por jugar a ?"
				+ "\n-------------------------------------------Historia:-------------------------------------------------------"
				+ "\nTu historia empieza en una sala de tarot, Gabriel Dominguez un multimillonario de baja reputación"
				+ "\nle pide a una tarotista que le prediga el futuro. Aunque esa tarotista no era una persona normal,"
				+ "\nes una mujer que por culpa de Gabriel perdió a su hijo debido a un accidente de coche provocado por el susodicho."
				+ "\nAhora ella lo maldijo y su mente fue transportada a una dimesión extrasensorial donde su vida depende de ti"
				+ "\nhabilidad para esquivar minas y batir a Gabriel en duelo contra los monstruos que quieren purgarlo."
				+ "\nAhora es tu turno, elige bien, intenta que no se muera y ten fe jugador. Que Dios te acompañe."
				+ "\nFirmado por La †arotista "
				+ "\n------------------------------------------------------------------------------------------------------------"
				+ "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Jugabilidad:>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
				+ "\nPaso 1: seleccionar que fila y que columa elegir"
				+ "Paso 2: si no contiene ningun peligro mostrara un número en base a la siguiente tabla:"
				+ "\n        Mostrara un número dependendio de que tienes alrededor (si tienes varias entidades se sumaran sus número): "
				+ "\n            * Mina -> 10"
				+ "\n            * Monstruo -> 1"
				+ "\n            * Jarrón -> 2"
				+ "\nPaso 3: intenta ganar"
				+ "\n"
				+ "\n");
	}
	/**
	 * mostrarFinalHistoriaGananar(): muestra el final de la historia si has ganado.
	 */
	public void mostrarFinalHistoriaGananar() {
		System.out.println("\n"
				+ "\n-------------------------------------------Historia:-------------------------------------------------------"
				+ "\nTodo parece correcto, ya no hay más peligro; pero, hay un ambiente vacio. Tu puedes ver confusión en sus ojos,"
				+ "\nal igual que tu. Derrepente se escucha una voz en el fondo, es la †arotista que hace presencia ante ellos:"
				+ "\n\"muy bien hecho aunque, demasiado bien de hecho. Gabriel Dominguez no merece vivir "
				+ "\ny su alma vagará en está dimesión para siempre. Gracias por jugar, con él.\" "
				+ "\n"
				+ "\n");
	}
	/**
	 * mostrarFinalHistoriaPerder(): muestra el final de la hisotria si has perdido.
	 */
	public void mostrarFinalHistoriaPerder() {
		System.out.println("\n"
				+ "\n-------------------------------------------Historia:-------------------------------------------------------"
				+ "\nTu ves como Grabriel agoniza mientras sientes la presencia de la †arotista detrás tuya, y sientes satisfacción"
				+ "\nen ella. Al final eela revela que su tortura acababa nada más de empezar. Grabriel ha perdido."
				+ "\n"
				+ "\n");
	}

}
