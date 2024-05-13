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
	    public void testHizkuntza() throws SQLException {
	    	
	    	ArrayList<Hizkuntza> hizkuntzak = HizkuntzaDAO.hizkuntza();
	    	Hizkuntza hAuxTest = new Hizkuntza("ES", "Español");
	    	
	    	assertEquals(hAuxTest.getId(), hizkuntzak.get(0).getId());
	    	assertEquals(hAuxTest.getDeskribapena(), hizkuntzak.get(0).getDeskribapena());    
	    }
	}