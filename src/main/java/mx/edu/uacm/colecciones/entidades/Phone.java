package mx.edu.uacm.colecciones.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Phone {

	
	@Id
	@GeneratedValue
	private Long id;
	
	

	private String type;
	private String number;
	
	public Phone() {
		// TODO Auto-generated constructor stub
	}
	
	public Phone(String type, String number) {
		this.type = type;
		this.number = number;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	
}
