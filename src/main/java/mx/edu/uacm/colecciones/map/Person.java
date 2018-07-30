package mx.edu.uacm.colecciones.map;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * Entidad con el uso de mapas
 * @author ChristianFV
 *
 */

@Entity
@Table(name="PersonaMap")
public class Person {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ElementCollection
	@CollectionTable(name="PhonesMap", joinColumns = @JoinColumn(name="person_id"))
	private Map<String, String> phones = new HashMap<String, String>();

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
	public Map<String, String> getPhones() {
		return phones;
	}

	/**
	 * @param phones the phones to set
	 */
	public void setPhones(Map<String, String> phones) {
		this.phones = phones;
	}
	
	
}
