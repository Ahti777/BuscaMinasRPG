package controlador;

import java.util.Scanner;

import clases.Entidad;
import clases.Heroe;
import clases.Monstruo;
import clases.Tabla;
import vista.BuscaMinasVistaConsola;

/**
 * 
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
		int opcionMenu;

		do {
			vistaConsola.mostrarMensaje("Quieres empezar a jugar? " + "\n0. Empezar partida" + "\n1. Salir");
			opcionMenu = teclado.nextInt();
			switch (opcionMenu) {
			case 0:
				do {
					/**
					vistaConsola.mostrarTablaVisible(usoTabla);
					vistaConsola.mostrarMensaje("");
					*/
					
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
					if (usoTabla.getMapaCeldas()[filaElegida][columnaElegida].isTieneMina()) {
						perder = true;
						vistaConsola.mostrarMensaje("Has perdido");
						vistaConsola.mostrarTablaVisible(usoTabla);
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
			vistaConsola.mostrarMensaje("El turno del heroe ha comenzado.");
			vistaConsola.mostrarMensaje("Lista de ataques: ");
			vistaConsola.mostrarMensaje(usoHeroe.getListaAtaques().toString());
			ataqueElegido = teclado.nextInt();
			usoMonstruoJarron.setCantidadVida(usoMonstruoJarron.getCantidadVida()-calcularDañoAtaque(usoHeroe, ataqueElegido));
			if(usoMonstruoJarron instanceof Monstruo) {
				System.out.println("Es el turno del monstruo");
			}else {
				System.out.println("El jarrón está tieso");
			}
			
		}while(usoHeroe.getCantidadVida()>0 || usoMonstruoJarron.getCantidadVida()>0);
	}
	/**
	 * 
	 * @param usoHeroe
	 * @param n
	 * @return
	 */
	private int calcularDañoAtaque(Heroe usoHeroe, int n) {
		return (int) (usoHeroe.getCantidadAtaque()*usoHeroe.getListaAtaques().get(n).getEscaladoDaño())+1;
	}

}
