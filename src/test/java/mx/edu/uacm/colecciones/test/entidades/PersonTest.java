package mx.edu.uacm.colecciones.test.entidades;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.edu.uacm.colecciones.HibernateJpaColeccionesApplication;
import mx.edu.uacm.colecciones.entidades.Person;
import mx.edu.uacm.colecciones.entidades.Phone;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=HibernateJpaColeccionesApplication.class)
public class PersonTest {
	
	public static final Logger log = LogManager.getLogger(PersonTest.class);

	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testGuardarPersonaOrderBy() {
		log.debug("Entrando a testGuardarPersonaOrderBy");
		
		Person person = new Person("Zack");
		
		em.persist(person);
		
		person.getPhones().add(new Phone("Fijo", "2929"));
		person.getPhones().add(new Phone("Movil", "2828"));
		person.getPhones().add(new Phone("Movil", "3030"));
		
		em.flush();
		
		//Forzamos el volver a leer de la base de datos
		em.refresh(person);
		
		log.debug("Nombre: " + person.getName());
		
		for (Phone phone : person.getPhones()) {
			log.debug("Telefono: " + phone.getNumber() + ")" + phone.getType()+ ")");
		}
		
	}
}
