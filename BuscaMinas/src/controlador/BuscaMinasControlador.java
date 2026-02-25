package controlador;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Excepciones.ContraseniaIncorrecta;
import Excepciones.UsuarioNoExiste;
import clases.Ataque;
import clases.Entidad;
import clases.Equipamiento;
import clases.GestionPartidas;
import clases.Heroe;
import clases.Jarron;
import clases.Monstruo;
import clases.Tabla;
import vista.BuscaMinasVistaConsola;

/**
 * @author Artem Zimin Litvak
 * @version 17/02/2026
 * 
 * BuscaMinasControlador: clase que me permite intanciarla y ejecutar el método que contiene el juego
 */
public class BuscaMinasControlador {

	/**
	 * 
	 */
	public BuscaMinasControlador() {
		super();
	}
	/**
	 * iniciarJuego(): ejecuta toda una serie de codigo para hacer funcionar la aplicación junto con el juego
	 */
	public void iniciarJuego() {
		// primer bucle while
		Scanner teclado = new Scanner(System.in);
		BuscaMinasVistaConsola vistaConsola = new BuscaMinasVistaConsola();
		GestionPartidas usoGestionPartidas = new GestionPartidas();
		String nombreUsuario;
		String contrasenia;
		String nombrePartida;
		int opcionElegidaGestionUsuarios;
		boolean salirInicioSesion = true;
		// secundo bucle while
		int opcionElegidaSesionIniciada;
		// tercer bucle while
		int filas;
		int columnas;
		int filaElegida;
		int columnaElegida;
		Tabla usoTabla;
		boolean condicion = true;
		boolean perder = false;
		ArrayList<Ataque> listaAtaques = new ArrayList<>();
		ArrayList<Equipamiento> listaEquipamientos = new ArrayList<>();
		ArrayList<Equipamiento> listaEquipamientoDisponible = new ArrayList<>();
		añadirEquipamientoLista(listaEquipamientoDisponible);
		Heroe usoHeroe = new Heroe(10, 4, 0, listaEquipamientos, listaAtaques);
		/**
		 * PREUBA
		 */
		Monstruo usoEnemigo = new Monstruo(10, 4);
		Jarron usoJarron = new Jarron(10, 0);
		int opcionMenu;
		// primer bucle while
		do {
			vistaConsola.mostrarMensaje("Menú inicio sesion: " + "\n1. Crear usuario" + "\n2. Eliminar usuario"
					+ "\n3. Iniciar sesión" + "\n4. Salir del menú de inicio de sesion");
			opcionElegidaGestionUsuarios = teclado.nextInt();
			teclado.nextLine();
			switch (opcionElegidaGestionUsuarios) {
			case 1:
				//CREA UN USUARIO
				try {
					nombreUsuario = pedirNombreUsuario();
					contrasenia = pedirContrasenia();
					usoGestionPartidas.crearUsuario(nombreUsuario, contrasenia);
				}catch (InputMismatchException e) {
					vistaConsola.mostrarMensaje("Algo ha salido mal");
				}
				break;
			case 2:
				//ELIMINA EL USUARIO INDICADO
				nombreUsuario = pedirNombreUsuario();
				contrasenia = pedirContrasenia();
				try {
					usoGestionPartidas.validarUsusarioNoExistente(nombreUsuario);
					usoGestionPartidas.validarContraseñaIntroducida(contrasenia);
					usoGestionPartidas.eliminarUsuario(nombreUsuario, contrasenia);
				} catch (UsuarioNoExiste e) {
					vistaConsola.mostrarMensaje("El usuario no existe");
				} catch (ContraseniaIncorrecta e) {
					vistaConsola.mostrarMensaje("Contraseña incorrecta");
				}

				break;
			case 3:
				//INICIO LA SESION DE UN USUARIO MEDIANTE LA CONTRASEÑA
				nombreUsuario = pedirNombreUsuario();
				contrasenia = pedirContrasenia();

				try {
					usoGestionPartidas.validarUsusarioNoExistente(nombreUsuario);
					usoGestionPartidas.validarContraseñaIntroducida(contrasenia);
					usoGestionPartidas.iniciarSesion(nombreUsuario, contrasenia);
					
					//MUESTRA LAS OPCIONES DE CREAR Y ELIMINAR PARTIDA
					vistaConsola.mostrarMensaje(
							"Qué quieres hacer:" + "\n1. Crear partida e iniciar partida" + "\n2. Eliminar partida");
					opcionElegidaSesionIniciada = teclado.nextInt();
					switch (opcionElegidaSesionIniciada) {
					case 1: {
						nombrePartida = pedirNombrePartida();
						usoGestionPartidas.crearPartida(nombreUsuario, contrasenia, nombrePartida);
						vistaConsola.mostrarMensaje("");
						
						
						vistaConsola.mostrarMensaje("El juego se ha iniciado correctamente");
						filas = vistaConsola.pedirFila();
						columnas = vistaConsola.pedirColumna();
						usoTabla = new Tabla(filas, columnas);
						
						//CÓDIGO QUE INICIA EL JUEGO
						do {
							condicion = true;
							perder = false;
								do {
									filaElegida = 0;
									columnaElegida = 0;
									vistaConsola.mostrarMensaje("===============================");
									vistaConsola.mostrarTabla(usoTabla);
									vistaConsola.mostrarMensaje("===============================");
									try {
										vistaConsola.mostrarMensaje("Elige una fila: ");
										filaElegida = teclado.nextInt();
										vistaConsola.mostrarMensaje("Elige una columna: ");
										columnaElegida = teclado.nextInt();
										usoTabla.getMapaCeldas()[filaElegida][columnaElegida].setVisible(true);
										//VERIFICA QUE CONTIENE LA CASILLA Y SI HAS PERIDO POR UNA CELDA MINA O POR TENER VIDA = 0
										if (usoTabla.getMapaCeldas()[filaElegida][columnaElegida].isTieneMina()
												|| usoHeroe.getCantidadVidaRestante() == 0) {
											perder = true;
											vistaConsola.mostrarMensaje("****************************");
											vistaConsola.mostrarMensaje("Has perdido");
											vistaConsola.mostrarTablaVisible(usoTabla);
											vistaConsola.mostrarMensaje("****************************");
										} else if (usoTabla.getMapaCeldas()[filaElegida][columnaElegida].isTieneJarron()) {
											combateEnemigo(usoHeroe, usoJarron, listaEquipamientoDisponible);
										} else if (usoTabla.getMapaCeldas()[filaElegida][columnaElegida]
												.isTieneMonstruo()) {
											combateEnemigo(usoHeroe, usoEnemigo, listaEquipamientoDisponible);
										}
									}catch (ArrayIndexOutOfBoundsException e) {
										vistaConsola.mostrarMensaje("Solo puedes introducir números del 0 al 7");
									}catch (InputMismatchException e) {
										vistaConsola.mostrarMensaje("Has introducido algo que no es un número, porfa guy hazlo bien que no es muy dificil");
										teclado.nextLine(); 
									}
									

								} while (!perder);
								condicion = false;
						} while (condicion || !perder);
						vistaConsola.mostrarMensaje("Has perdido :("
								+ "\n Saliendo de la sesión");
						break;
					}
					case 2: {
						//ELIMINAR PARTIDA
						nombrePartida = pedirNombrePartida();
						usoGestionPartidas.eliminarPartida(nombreUsuario, contrasenia, nombrePartida);
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + opcionElegidaSesionIniciada);
					}

				} catch (UsuarioNoExiste e) {
					vistaConsola.mostrarMensaje("El usuario no existe");
				} catch (ContraseniaIncorrecta e) {
					vistaConsola.mostrarMensaje("La contraseña es incorrecta");
				}

				break;
			case 4:
				salirInicioSesion = false;
				break;
			default:
				System.out.println("No existe esa opcion");
			}
		} while (salirInicioSesion);
		teclado.close();
	}

	/**
	 * combateEnemigo(Heroe usoHeroe, Entidad usoMonstruoJarroon): el heroe realiza
	 * un combate con el monstruo donde Heroe le quita vida, y viceversa hasta que
	 * uno de los dos tenga 0 cantidadVidaRestante
	 * 
	 * @param usoHeroe
	 * @param usoMonstruoJarron
	 */
	private void combateEnemigo(Heroe usoHeroe, Entidad usoMonstruoJarron,
			ArrayList<Equipamiento> listaEquipamientoDisponible) {
		/**
		 * 
		 */
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		BuscaMinasVistaConsola vistaConsola = new BuscaMinasVistaConsola();
		int ataqueElegido;
		do {
			ataqueElegido = 0;
			vistaConsola.mostrarMensaje("");
			vistaConsola.mostrarMensaje("El turno del heroe ha comenzado.");
			//MUESTRA LAS ESTADÍSTICAS DEL HEROE
			vistaConsola.mostrarMensaje("==============================");
			vistaConsola.mostrarEstadisticasHeroe(usoHeroe);
			vistaConsola.mostrarMensaje("" + usoHeroe.getCantidadExperiencia());
			vistaConsola.mostrarMensaje("==============================");
			vistaConsola.mostrarMensaje("Lista de ataques: ");
			vistaConsola.mostrarMensaje(usoHeroe.toStringListaAtaques());
			ataqueElegido = teclado.nextInt();
			//TURNO DONDE EL HEROE ATACA
			usoMonstruoJarron.setCantidadVidaRestante(
					usoMonstruoJarron.getCantidadVidaRestante() - usoHeroe.calcularDañoAtaque(usoHeroe, ataqueElegido));
			//TURNO DONDE EL MONSTRUO ATACA
			if (usoMonstruoJarron instanceof Monstruo) {
				vistaConsola.mostrarMensaje("Es el turno del monstruo");
				usoHeroe.setCantidadVidaRestante(usoHeroe.getCantidadVidaRestante()- usoMonstruoJarron.getCantidadAtaque());
				vistaConsola.mostrarMensaje("El monstruo ha atacado...");
			} else {
				vistaConsola.mostrarMensaje("Es el turno del jarrón");
				System.out.println("El jarrón está tieso");
			}
			vistaConsola.mostrarMensaje("");
			vistaConsola.mostrarMensaje("");

		} while (usoHeroe.getCantidadVidaRestante() > 0 && usoMonstruoJarron.getCantidadVidaRestante() > 0);
		//COMPRUEBA SI EL HEROE HA MUERTO O SUBE DE NIVEL
		if (usoHeroe.getCantidadVidaRestante() == 0) {
			vistaConsola.mostrarMensaje("El Heroe ha sido derrotado");
			//PRUEBA
			vistaConsola.mostrarMensaje(""+usoHeroe.getCantidadVidaRestante());
		} else {
			usoHeroe.subirNivel();
			if (usoMonstruoJarron instanceof Jarron) {
				((Jarron) usoMonstruoJarron).generarAleatoriedadAcciones(usoHeroe, listaEquipamientoDisponible);
				vistaConsola.mostrarMensaje("El jarrón dio su recompensa");
			} else {
				vistaConsola.mostrarMensaje("El monstruo ha sido derrotado");
			}
		}

	}

	/**
	 * añadirEquipamientoLista(ArrayList<Equipamiento> listaEquipamientoDisponible):
	 * se trata del equipamiento que puede soltar el jarrón al ser derrotado
	 * 
	 * @param listaEquipamientoDisponible
	 * @return rrayList<Equipamiento>
	 */
	private static ArrayList<Equipamiento> añadirEquipamientoLista(
			ArrayList<Equipamiento> listaEquipamientoDisponible) {
		Equipamiento casco = new Equipamiento("Casco del guerrero Mintrod", 4);
		Equipamiento armadura = new Equipamiento("Armadura refozada", 3);
		Equipamiento guanteletes = new Equipamiento("Guantes de duraluminio Iaónico", 6);
		listaEquipamientoDisponible.add(casco);
		listaEquipamientoDisponible.add(armadura);
		listaEquipamientoDisponible.add(guanteletes);
		return listaEquipamientoDisponible;
	}
	/**
	 * pedirNombreUsuario(): pide por teclado el nombre del usuario
	 * @return
	 */
	private String pedirNombreUsuario() {
		BuscaMinasVistaConsola vistaConsola = new BuscaMinasVistaConsola();
		Scanner teclado = new Scanner(System.in);
		String nombre;
		vistaConsola.mostrarMensaje("Cómo se llama el usuario? ");
		nombre = teclado.nextLine();
		return nombre;

	}
	/**
	 * pedirContrasenia(): pide por teclado la contrasenia del usuario
	 * @return
	 */
	private String pedirContrasenia() {
		BuscaMinasVistaConsola vistaConsola = new BuscaMinasVistaConsola();
		Scanner teclado = new Scanner(System.in);
		String constrasenia;
		vistaConsola.mostrarMensaje("¿Contraseña? ");
		constrasenia = teclado.nextLine();
		return constrasenia;

	}
	/**
	 * pedirNombrePartida(): pide por teclado el nombre que va a tener la nueva partida
	 * @return
	 */
	private String pedirNombrePartida() {
		BuscaMinasVistaConsola vistaConsola = new BuscaMinasVistaConsola();
		Scanner teclado = new Scanner(System.in);
		String nombrePartida;
		vistaConsola.mostrarMensaje("¿Cómo se llamará la partida? ");
		nombrePartida = teclado.nextLine();
		return nombrePartida;

	}

}
