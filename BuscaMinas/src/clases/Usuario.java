package clases;

/**
 * @Autor Danilo José Mendez Mendez
 *@version 10/02/2026
 */
import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nombre;
	private List<Partida> misPartidas;

	/**
	 * @param nombre
	 * @param misPartidas
	 */
	public Usuario(String nombre) {
		this.nombre = nombre;
		this.misPartidas = new ArrayList<>();
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
	public List<Partida> getMisPartidas() {
		return misPartidas;
	}

	/**
	 * @param misPartidas the misPartidas to set
	 */
	public void setMisPartidas(List<Partida> misPartidas) {
		this.misPartidas = misPartidas;
	}

	public void crearPartida(Partida partida) {
		if (partida != null) {
			this.misPartidas.add(partida);
		}
	}

//Para eliminar partidas
	public boolean eliminarPartida(int idPartida) {
		return this.misPartidas.removeIf(partida -> partida.getId() == idPartida);

	}
}
