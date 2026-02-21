package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import clases.Ataque;
import clases.Entidad;
import clases.Equipamiento;
import clases.Heroe;
import clases.Jarron;
import clases.Monstruo;
import clases.Tabla;
import vista.BuscaMinasVistaConsola;

/**
 * @author Artem Zimin Litvak
 * @version 17/02/2026
 */
public class BuscaMinasControlador {

	/**
	 * 
	 */
	public BuscaMinasControlador() {
		super();
	}
	public void iniciarJuego() {
		Scanner teclado = new Scanner(System.in);
		BuscaMinasVistaConsola vistaConsola = new BuscaMinasVistaConsola();
		int filas = vistaConsola.pedirFila();
		int columnas = vistaConsola.pedirColumna();
		int filaElegida;
		int columnaElegida;
		Tabla usoTabla = new Tabla(filas, columnas);
		boolean condicion = true;
		boolean perder = false;
		ArrayList<Ataque> listaAtaques = new ArrayList<>();
		ArrayList<Equipamiento> listaEquipamientos = new ArrayList<>();
		ArrayList<Equipamiento> listaEquipamientoDisponible = new ArrayList<>();
		añadirEquipamientoLista(listaEquipamientoDisponible);
		Heroe usoHeroe = new Heroe(10,4,0,listaEquipamientos,listaAtaques);
		/**
		 * PREUBA
		 */
		Monstruo usoEnemigo = new Monstruo(10, 4);
		Jarron usoJarron = new Jarron(10, 0);
		int opcionMenu;

		do {
			vistaConsola.mostrarMensaje("Quieres empezar a jugar? " + "\n0. Empezar partida" + "\n1. Salir");
			opcionMenu = teclado.nextInt();
			switch (opcionMenu) {
			case 0:
				do {
					vistaConsola.mostrarMensaje("");
					
					
					filaElegida = 0;
					columnaElegida = 0;
					vistaConsola.mostrarTabla(usoTabla);
					vistaConsola.mostrarMensaje("Elige una fila: ");
					filaElegida = teclado.nextInt();
					vistaConsola.mostrarMensaje("Elige una columna: ");
					columnaElegida = teclado.nextInt();
					usoTabla.getMapaCeldas()[filaElegida][columnaElegida].setVisible(true);
					/**
					 * 
					 */
					if (usoTabla.getMapaCeldas()[filaElegida][columnaElegida].isTieneMina() || usoHeroe.getCantidadVidaRestante()==0) {
						perder = true;
						vistaConsola.mostrarMensaje("Has perdido");
						vistaConsola.mostrarTablaVisible(usoTabla);
					}else if(usoTabla.getMapaCeldas()[filaElegida][columnaElegida].isTieneJarron()) {
						combateEnemigo(usoHeroe, usoJarron,listaEquipamientoDisponible);
					}else if(usoTabla.getMapaCeldas()[filaElegida][columnaElegida].isTieneMonstruo()) {
						combateEnemigo(usoHeroe, usoEnemigo, listaEquipamientoDisponible);
					}

				} while (!perder);
				break;
			case 1:
				condicion = false;
				break;
			}
		} while (condicion || !perder);
		teclado.close();
	}
	/**
	 * comvateEnemigo(Heroe usoHeroe, Entidad usoMonstruoJarroon): el heroe realiza un combate con el monstruo donde Heroe le quita vida, y viceversa hasta que uno de los dos tenga 0 cantidadVidaRestante
	 * @param usoHeroe
	 * @param usoMonstruoJarron
	 */
	private void combateEnemigo(Heroe usoHeroe, Entidad usoMonstruoJarron, ArrayList<Equipamiento> listaEquipamientoDisponible) {
		/**
		 * 
		 */
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		BuscaMinasVistaConsola vistaConsola = new BuscaMinasVistaConsola();
		int ataqueElegido;
		do {
			ataqueElegido=0;
			vistaConsola.mostrarMensaje("");
			vistaConsola.mostrarMensaje("El turno del heroe ha comenzado.");
			
			vistaConsola.mostrarEstadisticasHeroe(usoHeroe);
			System.out.println("");
			vistaConsola.mostrarMensaje("Lista de ataques: ");
			vistaConsola.mostrarMensaje(usoHeroe.toStringListaAtaques());
			ataqueElegido = teclado.nextInt();
			usoMonstruoJarron.setCantidadVidaRestante(usoMonstruoJarron.getCantidadVidaRestante()-usoHeroe.calcularDañoAtaque(usoHeroe, ataqueElegido));
			if(usoMonstruoJarron instanceof Monstruo) {
				System.out.println("Es el turno del monstruo");
				vistaConsola.mostrarMensaje("El monstruo va a atacar");
				usoHeroe.setCantidadVidaRestante(ataqueElegido);
			}else {
				System.out.println("El jarrón está tieso");
			}
			
		}while(usoHeroe.getCantidadVidaRestante()>0 && usoMonstruoJarron.getCantidadVidaRestante()>0);
		if(usoHeroe.getCantidadVidaRestante()==0) {
			vistaConsola.mostrarMensaje("El Heroe ha sido derrotado");
		}else {
			usoHeroe.subirNivel();
			if(usoMonstruoJarron instanceof Jarron) {
				((Jarron) usoMonstruoJarron).generarAleatoriedadAcciones(usoHeroe, listaEquipamientoDisponible);
				vistaConsola.mostrarMensaje("El jarrón dio su recompensa");
			}else {
				vistaConsola.mostrarMensaje("El monstruo ha sido derrotado");
			}
		}
		
	}
	/**
	 * añadirEquipamientoLista(ArrayList<Equipamiento>  listaEquipamientoDisponible): añade a listaEquipamientoDisponible el equipamiento previamente definido
	 * @param listaEquipamientoDisponible
	 * @return rrayList<Equipamiento>
	 */
	public static ArrayList<Equipamiento> añadirEquipamientoLista(ArrayList<Equipamiento>  listaEquipamientoDisponible) {
		Equipamiento casco = new Equipamiento("Casco del guerrero Mintrod", 4);
		Equipamiento armadura = new Equipamiento("Armadura refozada", 3);
		Equipamiento guanteletes = new Equipamiento("Guantes de duraluminio Iaónico", 6);
		listaEquipamientoDisponible.add(casco);
		listaEquipamientoDisponible.add(armadura);
		listaEquipamientoDisponible.add(guanteletes);
		return listaEquipamientoDisponible;
	}
	

}
