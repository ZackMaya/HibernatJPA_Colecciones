package mx.edu.uacm.colecciones.list;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

/**
 * Entidad para el uso de una lista con un orden
 * @author ChristianFV
 *
 */

@Entity
@Table(name="PersonList")
public class Person {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ElementCollection
	@CollectionTable(name="PhoneList", joinColumns=@JoinColumn(name="person_id"))
	@OrderColumn(name="order_id")
	private List<String> phones = new ArrayList<String>();
	
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
	public List<String> getPhones() {
		return phones;
	}

	/**
	 * @param phones the phones to set
	 */
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}
	
	
	
	
}
