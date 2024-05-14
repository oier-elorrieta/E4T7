package testDAO;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.sql.Konexioa;

public class KonexioaTest {

	@Before
	public void setUp() {
		Konexioa.konexioaIreki();
	}

	@After
	public void tearDown() {
		Konexioa.konexioaItxi();
	}

	@Test
	public void testKonexioaIrekita() {
		assertNotNull(Konexioa.konexioa);

		assertNotNull(Konexioa.query);
	}

	@Test
	public void testKonexioaItxia() {
		Konexioa.konexioaItxi();
		assertNotNull(Konexioa.konexioa);
	}

	@Test
	public void testKonexioaIreki() {
		Konexioa.konexioaIreki();
		assertNotNull("La conexión no debería ser nula después de abrirse", Konexioa.konexioa);
		assertNotNull("El objeto de consulta no debería ser nulo después de abrirse", Konexioa.query);
	}
	


}