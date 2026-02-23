package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
	 * @param nombre
	 * @param contraseña
	 */
	public void crearUsuario(String nombre, String contraseña) {
		Usuario nuevoUsuario = new Usuario(nombre, contraseña);
		partidasGuardadas.put(nuevoUsuario, new ArrayList<>());
		
	}
	public boolean eliminarUsuario(String nombre, String contrasenia) {
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();
		boolean eliminadoCorrectamente = false;
		while(it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if(entrada.getKey().getNombre().equals(nombre)&&entrada.getKey().getNombre().equals(contrasenia)) {
				it.remove();
				return eliminadoCorrectamente;
			}
		}
		return eliminadoCorrectamente;
		
	}
	public boolean iniciarSesion(String nombre, String contrasenia) {
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();
		boolean sesionIniciada=false;
		while(it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if(entrada.getKey().getNombre().equals(nombre)&&entrada.getKey().getContrasenia().equals(contrasenia)) {
				sesionIniciada=true;
			}
		}
		return sesionIniciada;
		
	}
	public void crearPartida(String nombre, String contrasenia,String nombrePartida) {
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if(entrada.getKey().getNombre().equals(nombre)&&entrada.getKey().getContrasenia().equals(contrasenia)) {
				entrada.getValue().add(new Partida(nombre));
			}
		}
		
	}
	public void eliminarPartida(String nombre) {
		
	}
	

}
