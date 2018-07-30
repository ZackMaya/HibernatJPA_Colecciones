package mx.edu.uacm.colecciones.test.list;

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
import mx.edu.uacm.colecciones.list.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=HibernateJpaColeccionesApplication.class)
public class PersonTest {

	public static final Logger log = LogManager.getLogger(PersonTest.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testGuardarPersonaList() {
		log.debug("Entrando a testGuardarPersonaList");
		
		Person person = new Person("Jose");
		
		em.persist(person);
		
		person.getPhones().add("2929");
		person.getPhones().add("2929");
		person.getPhones().add("2828");
		person.getPhones().add("2828");
		person.getPhones().add("2727");
		
		em.flush();
		
		person.getPhones().remove("2929");
		
		em.flush();
	}
}
