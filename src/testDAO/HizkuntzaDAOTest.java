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
	            
	            assertNotNull(hizkuntzak);
	            
	            assert(hizkuntzak.size() > 0);
	            
	            for (Hizkuntza hizkuntza : hizkuntzak) {
	                assertNotNull(hizkuntza);
	            }
	            
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
}
	    }