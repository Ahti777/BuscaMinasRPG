package clases;
/**
 * @author artem
 * @version 1.0 01-02-2026
 */
public class Celda {
	private boolean tieneMina;
	private int numero;
	private boolean visible;
	/**
	 * tieneCelda: muestra si la celda es una mina o no.
	 * numero: es la cantidad de minas que tiene esa mina al rededor
	 * visible: identifica si esa mina ha sido elegida y se sabe su contenido, o si no ha sido elegida y es desconocida.
	 */
	/**
	 * @param tieneMina
	 * @param numero
	 * @param visible
	 */
	public Celda(boolean tieneMina, boolean visible) {
		this.tieneMina = tieneMina;
		this.numero = 0;
		this.visible = visible;
	}
	public boolean isTieneMina() {
		return tieneMina;
	}
	public void setTieneMina(boolean tieneMina) {
		this.tieneMina = tieneMina;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	

}
