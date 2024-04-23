package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Audio;
import model.E_Premium;
import model.Playlist;

public class E_PremiumTest {
	
      private static E_Premium E_PremiumProba;
      private static Date dateIraun;
      private static Date data;

        @SuppressWarnings("deprecation")
        @BeforeClass
    	public static void setUpBeforeClass() throws Exception {
            data = new Date(2024, 1, 20);
            dateIraun = new Date(2021, 1, 20);
            E_PremiumProba = new E_Premium("erabiltzailea", "pasahitza", "izena", "abizena", "English", data, dateIraun);
        }
        
        @Test
        public void testSetGetIraungintze_data() {
	        E_PremiumProba.setIraungintze_data(data);    
	        assertEquals(data, E_PremiumProba.getIraungintze_data());
        }
       
        
        @Test
        public void testToString() {
            String expected = "Erabiltzailea [erabiltzailea=" + E_PremiumProba.getErabiltzailea() +", pasahitza="+ E_PremiumProba.getPasahitza() + ", izena=" + E_PremiumProba.getIzena() + ", abizena=" + E_PremiumProba.getAbizena()
            + ", hizkuntza=" + E_PremiumProba.getHizkuntza() + ", jaiotze_data=" + E_PremiumProba.getJaiotze_data() + "]E_Premium [iraungintze_data="+E_PremiumProba.getIraungintze_data()+"]";
            assertEquals(expected, E_PremiumProba.toString());    
            }
        
        @Test
        public void testEquals_SameObject() {
            E_Premium proba1 = new E_Premium("erabiltzailea", "pasahitza", "izena", "abizena", "English", data, dateIraun);
            assertTrue(E_PremiumProba.equals(proba1));
        }
        
        @Test
        public void testEquals_NullObject() {
            E_Premium proba1 = null;
           
            assertFalse(E_PremiumProba.equals(proba1));
        }

        @Test
        public void testEquals_DifferentClass() {
	        String probaE_Premium = "";
            assertFalse(E_PremiumProba.equals(probaE_Premium));
        }

        @Test
        public void testEqualsPunteroTest() {
            assertTrue(E_PremiumProba.equals(E_PremiumProba));
        }

        
}