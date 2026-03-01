package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import Excepciones.ContraseniaIncorrecta;
import Excepciones.FalloInicioSesion;
import Excepciones.ListaPartidasVacia;
import Excepciones.ListaUsuariosVacia;
import Excepciones.NoExistePartida;
import Excepciones.UsuarioNoExiste;
import Excepciones.UsuarioRepetido;
import Excepciones.YaExistePartida;
/**
 * @author Danilo José Mendez Mendez / Artem Zimin Litvak
 * @version 27/02/26
 * 
 * GestionPartida: permite crear o eliminar Usuarios, iniciar sesion y crear partidas, eliminar o visualizarlas.
 */
public class GestionPartidas {
	/**
	 * partidasGuardadas:
	 */
	private Map<Usuario, ArrayList<Partida>> partidasGuardadas = new HashMap<Usuario, ArrayList<Partida>>();

	/**
	 * @param partidasGuardadas
	 */
	public GestionPartidas() {
		super();
	}

	/**
	 * @return the partidasGuardadas
	 */
	public Map<Usuario, ArrayList<Partida>> getPartidasGuardadas() {
		return partidasGuardadas;
	}

	/**
	 * @param partidasGuardadas the partidasGuardadas to set
	 */
	public void setPartidasGuardadas(Map<Usuario, ArrayList<Partida>> partidasGuardadas) {
		this.partidasGuardadas = partidasGuardadas;
	}

	/**
	 * crearUsuario(String nombre, String constraseña):
	 * 
	 * @param nombreUsuario
	 * @param contraseña
	 */
	public void crearUsuario(String nombreUsuario, String contraseña) {
		Usuario nuevoUsuario = new Usuario(nombreUsuario, contraseña);
		partidasGuardadas.put(nuevoUsuario, new ArrayList<>());

	}
	/**
	 * eliminarUsuario(String nombreUsuario, String contrasenia): permite eliminar un usuario mediante su nombre y la constraseña.
	 * @param nombreUsuario
	 * @param contrasenia
	 */
	public void eliminarUsuario(String nombreUsuario, String contrasenia) {
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (entrada.getKey().getNombre().equals(nombreUsuario) && entrada.getKey().getContrasenia().equals(contrasenia)) {
				it.remove();

			}
		}

	}
	/**
	 * iniciarSesion(String nombreUsuario, String contrasenia): permite iniciar sesión a un usuario, mediante un nombre y una contraseña.
	 * @param nombreUsuario
	 * @param contrasenia
	 * @return boolean
	 */
	public boolean iniciarSesion(String nombreUsuario, String contrasenia) {
		boolean inicioSesion=false;
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (entrada.getKey().getNombre().equals(nombreUsuario) && entrada.getKey().getContrasenia().equals(contrasenia)) {
				inicioSesion = true;
				return inicioSesion;
			}
		}
		return inicioSesion;
		

	}
	/**
	 * crearPartida(String nombreUsuario, String contrasenia, String nombrePartida): permite crear un partida y asignarle un nombre.
	 * @param nombreUsuario
	 * @param contrasenia
	 * @param nombrePartida
	 */
	public void crearPartida(String nombreUsuario, String contrasenia, String nombrePartida) {
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (entrada.getKey().getNombre().equals(nombreUsuario) && entrada.getKey().getContrasenia().equals(contrasenia)) {
				entrada.getValue().add(new Partida(nombrePartida));
			}
		}

	}
	/**
	 * eliminarPartida(String nombreUsuario, String contrasenia, String nombrePartida): permite eliminar una partida medianete su nombre.
	 * @param nombreUsuario
	 * @param contrasenia
	 * @param nombrePartida
	 */
	public void eliminarPartida(String nombreUsuario, String contrasenia, String nombrePartida) {
		ArrayList<Partida> listaActualizada = new ArrayList<>();
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (entrada.getKey().getNombre().equals(nombreUsuario) && entrada.getKey().getContrasenia().equals(contrasenia)) {
				listaActualizada= entrada.getValue();
				Iterator<Partida> itPartida = listaActualizada.iterator();
				while(itPartida.hasNext()) {
					Partida entradaPartida = itPartida.next();
					if(entradaPartida.getNombre().equals(nombrePartida)) {
						itPartida.remove();
					}
				}
				entrada.setValue(listaActualizada);
			}
			
		}
	}
	/**
	 * mostrarPartidas(String nombreUsuario, String contrasenia): muestra las partidas creadas por un usuario.
	 * @param nombreUsuario
	 * @param contrasenia
	 * @return String
	 */
	public String mostrarPartidas(String nombreUsuario, String contrasenia) {
		String texto="";
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (entrada.getKey().getNombre().equals(nombreUsuario) && entrada.getKey().getContrasenia().equals(contrasenia)) {
				texto = entrada.getValue().toString();
			}
			
		}
		return texto;
		
	}
	/**
	 * validarUsusarioNoExistente(String nombreUsuario): compruba si el usuario ingresado no existe, para lanzar un excepcion UsuarioNoExiste. 
	 * @param nombreUsuario
	 * @throws UsuarioNoExiste
	 */
	public void validarUsusarioNoExistente(String nombreUsuario) throws UsuarioNoExiste{
		int contadorAparicionesNombre=0;
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (entrada.getKey().getNombre().equals(nombreUsuario)) {
				contadorAparicionesNombre++;
			}
		}
		if(contadorAparicionesNombre!=1) {
			throw new UsuarioNoExiste();
		}
	}
	/**
	 * validarContraseñaIntroducida(String nombreUsuario,String contrasenia): comprueba si la contraseña no es la misma a la que se puso al crear el usuario, para lanzar la excepcion ContraseniaIncorrecta.
	 * @param nombreUsuario
	 * @param contrasenia
	 * @throws ContraseniaIncorrecta
	 */
	public void validarContraseñaIntroducida(String nombreUsuario,String contrasenia) throws ContraseniaIncorrecta{
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (entrada.getKey().getNombre().equals(nombreUsuario) && !entrada.getKey().getContrasenia().equals(contrasenia)) {
				throw new ContraseniaIncorrecta();
			}
		}
	}
	/**
	 * validarInicioSesion(String nombre, String contrasenia): lanza la excepción FalloInicioSesion si inicio sesion devuelve false.
	 * @param nombre
	 * @param contrasenia
	 * @throws FalloInicioSesion
	 */
	public void validarInicioSesion(String nombre, String contrasenia) throws FalloInicioSesion{
		if(!iniciarSesion(nombre, contrasenia)) {
			throw new FalloInicioSesion();
		}
		
	}
	/**
	 * validarNombrePartida(String nombreUsuario,String nombrePartida): lanza la excepción YaExistePartida, cuando ya existe una Partida con el mismo nombre.
	 * @param nombreUsuario
	 * @param nombrePartida
	 * @throws YaExistePartida
	 */
	public void validarNombrePartida(String nombreUsuario,String nombrePartida) throws YaExistePartida{
		int contadorAparicionesNombrePartida=0;
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if(entrada.getKey().getNombre().equals(nombreUsuario)) {
				for(Partida p : entrada.getValue()) {
					if(p.getNombre().equals(nombrePartida)) {
						contadorAparicionesNombrePartida++;
					}
				}
			}
		}
		if(contadorAparicionesNombrePartida!=0) {
			throw new YaExistePartida();
		}
	}
	/**
	 * validarExistenciaPartida(String nombrePartida): lanza la excepción NoExistePartida, cuando no existe Partida con el nombre nombrePartida.
	 * @param nombrePartida
	 * @throws NoExistePartida
	 */
	@SuppressWarnings("unlikely-arg-type")
	public void validarExistenciaPartida(String nombrePartida) throws NoExistePartida{
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (!entrada.getValue().contains(nombrePartida)) {
				throw new NoExistePartida();
			}
		}
	}
	/**
	 * validarListaUsuariosVacia(): lanza la excepción ListaUsuariosVacia, si no existen Usuario.
	 * @throws ListaUsuariosVacia
	 */
	public void validarListaUsuariosVacia() throws ListaUsuariosVacia{
		if(partidasGuardadas.size()==0) {
			throw new ListaUsuariosVacia();
		}
	}
	/**
	 * validarListaPartidasVacia(String nombreUsuario): lanza la excepcion ListaPartidasVacia, si no existen Partida en el Usuario nombreUsuario.
	 * @param nombreUsuario
	 * @throws ListaPartidasVacia
	 */
	public void validarListaPartidasVacia(String nombreUsuario) throws ListaPartidasVacia{
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (entrada.getKey().getNombre().equals(nombreUsuario) && entrada.getValue().size()==0) {
				throw new ListaPartidasVacia();
			}
		}
	}
	/**
	 * validarUsuarioRepetido(String nombreUsuario): lanza la excepción UsuarioRepetido, cuando se intenta crear un usuario con un nombre idéntico a uno que ya existe.
	 * @param nombreUsuario
	 * @throws UsuarioRepetido
	 */
	public void validarUsuarioRepetido(String nombreUsuario) throws UsuarioRepetido{
		int contadorAparicionesNombre=0;
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (entrada.getKey().getNombre().equals(nombreUsuario)) {
				contadorAparicionesNombre++;
			}
		}
		if(contadorAparicionesNombre!=0) {
			throw new UsuarioRepetido();
		}
	}

}
