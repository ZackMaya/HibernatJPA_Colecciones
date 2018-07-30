package mx.edu.uacm.colecciones.test.map;

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
import mx.edu.uacm.colecciones.map.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=HibernateJpaColeccionesApplication.class)
public class PersonTest {
	
	public static final Logger log = LogManager.getLogger(PersonTest.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testGuardarPersonaMap() {
		log.debug("Entrando a testGuardarPersonaMap");
		
		Person person = new Person("Christian");
		em.persist(person);
		
		person.getPhones().put("2727", "Trabajo");
		person.getPhones().put("2828", "Movil");
		person.getPhones().put("2929", "Casa");
		
		em.flush();
	}

}
