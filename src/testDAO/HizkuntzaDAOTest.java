package testDAO;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Hizkuntza;
import model.sql.HizkuntzaDAO;

	public class HizkuntzaDAOTest {

	    @Test
	    public void testHizkuntza() {
	        try {
	            ArrayList<Hizkuntza> hizkuntzak = HizkuntzaDAO.hizkuntza();
	            
	            // Verifica que la lista no sea nula
	            assertNotNull(hizkuntzak);
	            
	            // Verifica que la lista tenga al menos un elemento
	            assert(hizkuntzak.size() > 0);
	            
	            // Verifica que los objetos Hizkuntza en la lista no sean nulos
	            for (Hizkuntza hizkuntza : hizkuntzak) {
	                assertNotNull(hizkuntza);
	            }
	            
	            // Puedes realizar más aserciones según la estructura y los datos esperados de tu base de datos
	            // Por ejemplo, puedes verificar que ciertos campos no sean nulos o que los valores sean los esperados.
	            
	        } catch (SQLException e) {
	            // Maneja la excepción según sea necesario, por ejemplo, imprimiendo el rastreo de la pila
	            e.printStackTrace();
	        }
}
	    }