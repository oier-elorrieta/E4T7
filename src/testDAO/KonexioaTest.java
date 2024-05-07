package testDAO;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.Statement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.sql.Konexioa;

public class KonexioaTest {
    
    @Before
    public void setUp() {
        // Abre la conexión antes de cada prueba
        Konexioa.konexioaIreki();
    }
    
    @After
    public void tearDown() {
        // Cierra la conexión después de cada prueba
        Konexioa.konexioaItxi();
    }

    @Test
    public void testKonexioaIreki() {
        // Verifica que la conexión no sea nula después de abrir
        assertNotNull(Konexioa.konexioa);
        
        // Verifica que el objeto de consulta no sea nulo después de abrir
        assertNotNull(Konexioa.query);
    }

    @Test
    public void testKonexioaItxi() {
        // Verifica que la conexión sea nula después de cerrar
        Konexioa.konexioaItxi();
        assertNull(Konexioa.konexioa);
        
        // Verifica que el objeto de consulta sea nulo después de cerrar
        assertNull(Konexioa.query);
    }
}