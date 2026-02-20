package clases;

/**
 * @Autor Danilo José Mendez Mendez
 *@version 10/02/2026
 */
import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nombre;
	private String contrasenia;
	
	

	/**
	 * @param nombre
	 * @param contrasenia
	 */
	public Usuario(String nombre, String contrasenia) {
		super();
		this.nombre = nombre;
		this.contrasenia = contrasenia;
	}
	
	public boolean verificarContraseñaIntroducida(String contraseniaIntroducida) {
		if(contraseniaIntroducida.equals(contrasenia)) {
			return true;
		}else {
			return true;
		}
	}
}
