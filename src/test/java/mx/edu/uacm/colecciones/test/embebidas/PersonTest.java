package mx.edu.uacm.colecciones.test.embebidas;

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
import mx.edu.uacm.colecciones.embebidas.Person;
import mx.edu.uacm.colecciones.embebidas.Phone;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=HibernateJpaColeccionesApplication.class)
public class PersonTest {
	
	public static final Logger log = LogManager.getLogger(PersonTest.class);

	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testGuardarPersonaEmbebidas() {
		log.debug("Entrando a testGuardarPersonaEmbebidas");
		
		Person person = new Person("Sergio");
		
		em.persist(person);
		
		person.getPhones().add(new Phone("Fijo", "2727"));
		person.getPhones().add(new Phone("Movil", "2828"));
		
		em.flush();
	}
}
