package mx.edu.uacm.colecciones.bag;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;

/**
 * 
 * @author ChristianFV
 *
 */
@Entity
public class Person {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ElementCollection
	@CollectionTable(name="PhoneBags", joinColumns = @JoinColumn(name="person_id"))
	@OrderColumn //Va a ser ignorado en la practica
	private Collection<String> phones = new ArrayList<String>();

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phones
	 */
	public Collection<String> getPhones() {
		return phones;
	}

	/**
	 * @param phones the phones to set
	 */
	public void setPhones(Collection<String> phones) {
		this.phones = phones;
	}
	
	
	
	
}
