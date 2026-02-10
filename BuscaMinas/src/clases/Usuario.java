package clases;
/**
 * @Autor Danilo José Mendez Mendez
 *@version 10/02/2026
 */
import java.util.ArrayList;

public class Usuario {
	
	private String nombre;
	private ArrayList<Partida>misPartidas;
	
	
	/**
	 * @param nombre
	 * @param misPartidas
	 */
	public Usuario(String nombre, ArrayList<Partida> misPartidas) {
		this.nombre = nombre;
		this.misPartidas = misPartidas;
	}

	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the misPartidas
	 */
	public ArrayList<Partida> getMisPartidas() {
		return misPartidas;
	}


	/**
	 * @param misPartidas the misPartidas to set
	 */
	public void setMisPartidas(ArrayList<Partida> misPartidas) {
		this.misPartidas = misPartidas;
	}


	public void crearPartida() {
		this.misPartidas= misPartidas;
	}
	
	public void eliminarPartida() {
		this.misPartidas=misPartidas;
		
	}
}
