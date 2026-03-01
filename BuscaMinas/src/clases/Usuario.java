package clases;
/**
 * @Autor Danilo José Mendez Mendez / Artem Zimin Litvak
 * @version 10/02/2026
 * 
 * Usuario: es el persona que se identifica en la app, también permite crear varias Partida y jugar.
 */
public class Usuario {
	/**
	 * nombre: es el nombre que identifica al Usuario.
	 * constrasenia: es el texto que verifica que el Usuario te pertenece.
	 */
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
	 * @return the contrasenia
	 */
	public String getContrasenia() {
		return contrasenia;
	}


	/**
	 * @param contrasenia the contrasenia to set
	 */
	public void setContrasenia(String contrasenia) {
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
