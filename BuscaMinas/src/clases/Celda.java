package clases;
/**
 * @author artem
 * @version 2.0 14/02/2026
 */
public class Celda {
	/**
	 * tieneMina: muestra si la celda es una mina o no.
	 * numero: es la cantidad de minas que tiene esa mina al rededor
	 * visible: identifica si esa mina ha sido elegida y se sabe su contenido, o si no ha sido elegida y es desconocida.
	 */
	private boolean tieneMina;
	private boolean tieneMonstruo;
	private boolean tieneJarron;
	private int numero;
	private boolean visible;
	
	
	/**
	 * @param tieneMina
	 * @param tieneMonstruo
	 * @param tieneJarron
	 * @param numero
	 * @param visible
	 */
	public Celda(boolean tieneMina, boolean tieneMonstruo, boolean tieneJarron, boolean visible) {
		super();
		this.tieneMina = tieneMina;
		this.tieneMonstruo = tieneMonstruo;
		this.tieneJarron = tieneJarron;
		this.visible = visible;
	}


	/**
	 * @return the tieneMina
	 */
	public boolean isTieneMina() {
		return tieneMina;
	}


	/**
	 * @param tieneMina the tieneMina to set
	 */
	public void setTieneMina(boolean tieneMina) {
		this.tieneMina = tieneMina;
	}


	/**
	 * @return the tieneMonstruo
	 */
	public boolean isTieneMonstruo() {
		return tieneMonstruo;
	}


	/**
	 * @param tieneMonstruo the tieneMonstruo to set
	 */
	public void setTieneMonstruo(boolean tieneMonstruo) {
		this.tieneMonstruo = tieneMonstruo;
	}


	/**
	 * @return the tieneJarron
	 */
	public boolean isTieneJarron() {
		return tieneJarron;
	}


	/**
	 * @param tieneJarron the tieneJarron to set
	 */
	public void setTieneJarron(boolean tieneJarron) {
		this.tieneJarron = tieneJarron;
	}


	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}


	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}


	/**
	 * @return the visible
	 */
	public boolean isVisible() {
		return visible;
	}


	/**
	 * @param visible the visible to set
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}


	

}
