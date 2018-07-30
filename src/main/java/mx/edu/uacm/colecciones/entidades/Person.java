package mx.edu.uacm.colecciones.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;



/**
 * Entidad 
 * author Ernesto Maya**/


@Entity
public class Person {

	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	//orderBY number tiene que ver con phone
	
	@OneToMany(cascade=CascadeType.ALL)
	@OrderBy("number")
	private List<Phone> phones = new ArrayList<Phone>();
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	
	
	
}
