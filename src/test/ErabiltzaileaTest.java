package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Object;
import model.Audio;
import model.Erabiltzailea;

public class ErabiltzaileaTest {

	  private Erabiltzailea erabiltzailea;
	 
	    @Test
	    public void testConstructor() {
	        erabiltzailea = new Erabiltzailea("erabiltzailea", "Pasahitza", "izena", "abizena", new Date());
	        assertNotNull(erabiltzailea);
	    }
	    @Test
	    public void testGetErabiltzailea() {
	        erabiltzailea = new Erabiltzailea("erabiltzailea", "Pasahitza", "izena", "abizena", new Date());
	        assertEquals("erabiltzailea", erabiltzailea.getErabiltzailea());
	    }
	    @Test
	    public void testGetIzena() {
	        erabiltzailea = new Erabiltzailea("erabiltzailea", "Pasahitza", "izena", "abizena", new Date());

	        assertEquals("izena", erabiltzailea.getIzena());
	    }
	    @Test
	    public void testGetAbizena() {
	        erabiltzailea = new Erabiltzailea("erabiltzailea", "Pasahitza", "izena", "abizena", new Date());
	        assertEquals("abizena", erabiltzailea.getAbizena());
	    }
	    @Test
	    public void testGetJaiotzeData() {
	        erabiltzailea = new Erabiltzailea("erabiltzailea", "izena", "abizena", new Date());
	        assertNotNull(erabiltzailea.getJaiotze_data());
	    }
	    @Test
	    public void testSetErabiltzailea() {
	        erabiltzailea = new Erabiltzailea("a", "izena", "abizena", new Date());
	        erabiltzailea.setErabiltzailea("erabiltzailea");
	        assertEquals("erabiltzailea", erabiltzailea.getErabiltzailea());
	    }
	    @Test
	    public void testSetIzena() {
	        erabiltzailea = new Erabiltzailea("erabiltzailea", "a", "abizena", new Date());
	        erabiltzailea.setIzena("izena");
	        assertEquals("izena", erabiltzailea.getIzena());
	    }
	    @Test
	    public void testSetAbizena() {
	        erabiltzailea = new Erabiltzailea("erabiltzailea", "izena", "a", new Date());
	        erabiltzailea.setAbizena("abizena");
	        assertEquals("abizena", erabiltzailea.getAbizena());
	    }
	    @Test
	    public void testSetJaiotzeData() {
	        erabiltzailea = new Erabiltzailea("erabiltzailea", "izena", "abizena", null);
	        erabiltzailea.setJaiotze_data(new Date());
	        assertNotNull(erabiltzailea.getJaiotze_data());
	    }
	    @Test
	    public void testSetJaiotzeData2() {
	        erabiltzailea = new Erabiltzailea("erabiltzailea", "izena", "abizena", new Date());
	        Date gaurkoeguna = new Date();
	        assertEquals(erabiltzailea.getJaiotze_data(), gaurkoeguna);
	    }
	    @Test
	    public void testToString() {
	        erabiltzailea = new Erabiltzailea("erabiltzailea", "izena", "abizena", null);
	        assertEquals("Erabiltzailea [erabiltzailea=" + "erabiltzailea" + ", izena=" + "izena" + ", abizena=" + "abizena"
	                + ", jaiotze_data=" + null + "]", erabiltzailea.toString());    
	    }
	    @Test
	    public void testToEqualsBerdina() {
	        Erabiltzailea erabiltzailea1 = new Erabiltzailea("erabiltzailea", "izena", "abizena", null);
	        Erabiltzailea erabiltzailea2 = new Erabiltzailea("erabiltzailea", "izena", "abizena", null);
	        assertTrue(erabiltzailea1.equals(erabiltzailea1)) ;
	    }
	    @Test
	    public void testToEqualsNull() {
	        Erabiltzailea erabiltzailea2 = new Erabiltzailea("erabiltzailea", "izena", "abizena", null);
	        assertFalse(erabiltzailea2.equals(null));
	    }
	    @Test
	    public void testToEqualsDiff() {
	        Erabiltzailea erabiltzailea1 = new Erabiltzailea("erabiltzailea", "izena", "abizena", null);
	        Audio aud  = new Audio(null, 0);
	        assertFalse(erabiltzailea1.equals(aud));
	    }
	@Test
	    public void testToEquals() {
	        Erabiltzailea erabiltzailea1 = new Erabiltzailea("erabiltzailea", "izena", "abizena", null);
	        Erabiltzailea erabiltzailea2 = new Erabiltzailea("erabiltzailea", "izena", "abizena", null);
	        assertTrue(erabiltzailea1.equals(erabiltzailea2)) ;
	    }
	    @Test
	    public void testToEqualsDifferentIzena() {
	        Erabiltzailea erabiltzailea1 = new Erabiltzailea("erabiltzailea", "izena1", "abizena", null);
	        Erabiltzailea erabiltzailea2 = new Erabiltzailea("erabiltzailea", "izena2", "abizena", null);
	        assertFalse(erabiltzailea1.equals(erabiltzailea2));
	    }
	    @Test
	    public void testToEqualsDifferentJaiotzeData() {
	        Erabiltzailea erabiltzailea1 = new Erabiltzailea("erabiltzailea", "izena", "abizena", null);
	        Erabiltzailea erabiltzailea2 = new Erabiltzailea("erabiltzailea", "izena", "abizen", null);
	        assertFalse(erabiltzailea1.equals(erabiltzailea2));
	    }

	}

}
