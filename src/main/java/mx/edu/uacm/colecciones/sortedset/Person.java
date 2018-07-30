package mx.edu.uacm.colecciones.sortedset;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.SortNatural;

/**
 * Entidad para el manejo de orden con un Set
 * @author ChristianFV
 *
 */

@Entity(name="PersonSortedSet")
@Table(name="PersonSortedSet")
public class Person {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ElementCollection
	@CollectionTable(name="PhoneSortedSet", joinColumns=@JoinColumn(name="person_id"))
	@SortNatural		//es de Hibernate, orden natural en memoria no en BD
	private SortedSet<String> phones = new TreeSet<String>();
	
	
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
	public SortedSet<String> getPhones() {
		return phones;
	}

	/**
	 * @param phones the phones to set
	 */
	public void setPhones(SortedSet<String> phones) {
		this.phones = phones;
	}	
	
}
