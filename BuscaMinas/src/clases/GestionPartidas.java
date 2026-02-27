package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.management.ListenerNotFoundException;

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

	public void eliminarUsuario(String nombreUsuario, String contrasenia) {
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (entrada.getKey().getNombre().equals(nombreUsuario) && entrada.getKey().getContrasenia().equals(contrasenia)) {
				it.remove();

			}
		}

	}

	public boolean iniciarSesion(String nombreUsuario, String contrasenia) {
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();
		boolean sesionIniciada = false;
		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (entrada.getKey().getNombre().equals(nombreUsuario) && entrada.getKey().getContrasenia().equals(contrasenia)) {
				sesionIniciada = true;
			}
		}
		return sesionIniciada;

	}

	public void crearPartida(String nombreUsuario, String contrasenia, String nombrePartida) {
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (entrada.getKey().getNombre().equals(nombreUsuario) && entrada.getKey().getContrasenia().equals(contrasenia)) {
				entrada.getValue().add(new Partida(nombrePartida));
			}
		}

	}

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
	
	public void validarContraseñaIntroducida(String nombreUsuario,String contrasenia) throws ContraseniaIncorrecta{
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (entrada.getKey().getNombre().equals(nombreUsuario) && !entrada.getKey().getContrasenia().equals(contrasenia)) {
				throw new ContraseniaIncorrecta();
			}
		}
	}
	
	public void validarInicioSesion(String nombre, String contrasenia) throws FalloInicioSesion{
		if(!iniciarSesion(nombre, contrasenia)) {
			throw new FalloInicioSesion();
		}
		
	}
	
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
	
	public void validarExistenciaPartida(String nombrePartida) throws NoExistePartida{
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (!entrada.getValue().contains(nombrePartida)) {
				throw new NoExistePartida();
			}
		}
	}
	
	public void validarListaUsuariosVacia() throws ListaUsuariosVacia{
		if(partidasGuardadas.size()==0) {
			throw new ListaUsuariosVacia();
		}
	}
	
	public void validarListaPartidasVacia(String  nombreUsuario) throws ListaPartidasVacia{
		Iterator<Map.Entry<Usuario, ArrayList<Partida>>> it = partidasGuardadas.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Usuario, ArrayList<Partida>> entrada = it.next();
			if (entrada.getKey().getNombre().equals(nombreUsuario) && entrada.getValue().size()==0) {
				throw new ListaPartidasVacia();
			}
		}
	}
	
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
