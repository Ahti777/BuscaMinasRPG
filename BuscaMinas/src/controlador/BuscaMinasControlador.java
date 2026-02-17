package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import clases.Ataque;
import clases.Entidad;
import clases.Equipamiento;
import clases.Heroe;
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
		Heroe usoHeroe = new Heroe(10,4,0,listaEquipamientos,listaAtaques);
		/**
		 * PREUBA
		 */
		Monstruo usoEnemigo = new Monstruo(10, 4);
		int opcionMenu;

		do {
			vistaConsola.mostrarMensaje("Quieres empezar a jugar? " + "\n0. Empezar partida" + "\n1. Salir");
			opcionMenu = teclado.nextInt();
			switch (opcionMenu) {
			case 0:
				do {
					
					vistaConsola.mostrarTablaVisible(usoTabla);
					vistaConsola.mostrarMensaje("");
					
					
					filaElegida = 0;
					columnaElegida = 0;
					usoHeroe.subirNivel();
					
					vistaConsola.mostrarTabla(usoTabla);
					vistaConsola.mostrarMensaje("Elige una fila: ");
					filaElegida = teclado.nextInt();
					vistaConsola.mostrarMensaje("Elige una columna: ");
					columnaElegida = teclado.nextInt();
					usoTabla.getMapaCeldas()[filaElegida][columnaElegida].setVisible(true);
					/**
					 * 
					 */
					if (usoTabla.getMapaCeldas()[filaElegida][columnaElegida].isTieneMina() || usoHeroe.getCantidadVida()==0) {
						perder = true;
						vistaConsola.mostrarMensaje("Has perdido");
						vistaConsola.mostrarTablaVisible(usoTabla);
					}else if(usoTabla.getMapaCeldas()[filaElegida][columnaElegida].isTieneJarron() || usoTabla.getMapaCeldas()[filaElegida][columnaElegida].isTieneMonstruo()) {
						combateEnemigo(usoHeroe, usoEnemigo);
					}

				} while (!perder);
				break;
			case 1:
				condicion = false;
				break;
			}
		} while (condicion);
		teclado.close();
	}
	
	private void combateEnemigo(Heroe usoHeroe, Entidad usoMonstruoJarron) {
		/**
		 * 
		 */
		Scanner teclado = new Scanner(System.in);
		BuscaMinasVistaConsola vistaConsola = new BuscaMinasVistaConsola();
		int ataqueElegido;
		do {
			ataqueElegido=0;
			vistaConsola.mostrarMensaje("");
			vistaConsola.mostrarMensaje("El turno del heroe ha comenzado.");
			vistaConsola.mostrarMensaje("Vida: "+usoMonstruoJarron.getCantidadVida());
			
			vistaConsola.mostrarEstadisticasHeroe(usoHeroe);
			System.out.println("");
			vistaConsola.mostrarMensaje("Lista de ataques: ");
			vistaConsola.mostrarMensaje(usoHeroe.toStringListaAtaques());
			ataqueElegido = teclado.nextInt();
			usoMonstruoJarron.setCantidadVida(usoMonstruoJarron.getCantidadVida()-usoHeroe.calcularDañoAtaque(usoHeroe, ataqueElegido));
			if(usoMonstruoJarron instanceof Monstruo) {
				System.out.println("Es el turno del monstruo");
				vistaConsola.mostrarMensaje("El monstruo va a atacar");
				usoHeroe.setCantidadVida(usoHeroe.getCantidadVida()-usoMonstruoJarron.getCantidadAtaque());
			}else {
				System.out.println("El jarrón está tieso");
			}
			
		}while(usoHeroe.getCantidadVida()>0 || usoMonstruoJarron.getCantidadVida()>0);
		teclado.close();
	}
	

}
