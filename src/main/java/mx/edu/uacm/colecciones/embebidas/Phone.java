package mx.edu.uacm.colecciones.embebidas;

import javax.persistence.Embeddable;

@Embeddable
public class Phone {

	private String type;
	
	private String number;
	
	public Phone() {
		// TODO Auto-generated constructor stub
	}
	
	public Phone(String type, String number) {
		this.type = type;
		this.number = number;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
