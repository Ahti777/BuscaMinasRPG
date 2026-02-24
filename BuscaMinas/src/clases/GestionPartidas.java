package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import Excepciones.ContraseniaIncorrecta;
import Excepciones.UsuarioNoExiste;

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
		this.partidasGuardadas = partidasGuardadas;
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
	 * @param nombre
	 * @param contraseña
	 */
	public void crearUsuario(String nombre, String contraseña) {
		Usuario nuevoUsuario = new Usuario(nombre, contraseña);
		partidasGuardadas.put(nuevoUsuario, new ArrayList<>());

	}

	public void eliminarUsuario(String nombre, String contrasenia) {
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (entrada.getKey().getNombre().equals(nombre) && entrada.getKey().getContrasenia().equals(contrasenia)) {
				it.remove();

			}
		}

	}

	public boolean iniciarSesion(String nombre, String contrasenia) {
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();
		boolean sesionIniciada = false;
		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (entrada.getKey().getNombre().equals(nombre) && entrada.getKey().getContrasenia().equals(contrasenia)) {
				sesionIniciada = true;
			}
		}
		return sesionIniciada;

	}

	public void crearPartida(String nombre, String contrasenia, String nombrePartida) {
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (entrada.getKey().getNombre().equals(nombre) && entrada.getKey().getContrasenia().equals(contrasenia)) {
				entrada.getValue().add(new Partida(nombre));
			}
		}

	}

	public void eliminarPartida(String nombre, String contrasenia, String nombrePartida) {
		ArrayList<Partida> listaActualizada = new ArrayList<>();
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (entrada.getKey().getNombre().equals(nombre) && entrada.getKey().getContrasenia().equals(contrasenia)) {
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
	public void validarUsusarioNoExistente(String nombre) throws UsuarioNoExiste{
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (!entrada.getKey().getNombre().equals(nombre)) {
				throw new UsuarioNoExiste();
			}
		}
	}
	
	public void validarNumeroIntroducido() {
		
	}
	public void validarContraseñaIntroducida(String contrasenia) throws ContraseniaIncorrecta{
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (!entrada.getKey().getContrasenia().equals(contrasenia)) {
				throw new ContraseniaIncorrecta();
			}
		}
	}

}
