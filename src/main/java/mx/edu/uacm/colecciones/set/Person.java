package mx.edu.uacm.colecciones.set;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * Entidad para el uso de Set
 * @author ChristianFV
 *
 */

@Entity
@Table(name="PersonSet")
public class Person {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ElementCollection
	@CollectionTable(name="PhoneSet", joinColumns=@JoinColumn(name="person_id"))
	private Set<String> phones = new HashSet<String>();
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name) {
		this.name = name;
	}

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
	public Set<String> getPhones() {
		return phones;
	}

	/**
	 * @param phones the phones to set
	 */
	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	
}
