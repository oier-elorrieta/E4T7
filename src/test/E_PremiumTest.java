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
        public void testGetGetIraungintze_data() {
        	 E_Premium E_PremiumProba = new E_Premium("erabiltzailea", "pasahitza", "izena", "abizena", "English", data, dateIraun);
	        assertEquals(dateIraun, E_PremiumProba.getIraungintze_data());
        }
       
        
        @Test
        public void testSetGetIraungintze_data() {
       	 E_Premium E_PremiumProba = new E_Premium(null, null, null, null, null, null, null, data);

	        E_PremiumProba.setIraungintze_data(data);    
	        assertEquals(data, E_PremiumProba.getIraungintze_data());
        }
  
   
        
        @Test
        public void testEquals_NullObject() {
            E_Premium proba1 = null;
            assertFalse(E_PremiumProba.equals(proba1));
        }

        @Test
        public void testEquals_DifferentClass() {
        	Object obj = null;
            assertFalse(E_PremiumProba.equals(obj));
        }
        @Test
        public void testEquals_ClassMismatch() {
            // Crear un objeto E_Premium
            Date jaiotze_data = new Date();
            Date iraungintze_data = new Date();
            E_Premium ePremium = new E_Premium("123", "usuario123", "contraseña", "Nombre", "Apellido", "eu", jaiotze_data, iraungintze_data);
            Object obj = new Object();
            
            assertFalse(ePremium.equals(obj));
        }
        @Test
        public void testEquals_DifferentC() {
        	Object obj = null;
            assertFalse(E_PremiumProba.equals(obj));
        }
        @Test
        public void testEqualsPunteroTest() {
            assertTrue(E_PremiumProba.equals(E_PremiumProba));
        }
        
        @Test
        public void testToString() {
            Date jaiotze_data = new Date();
            Date iraungintze_data = new Date();
            E_Premium ePremium = new E_Premium("123", "usuario123", "contraseña", "Nombre", "Apellido", "eu", jaiotze_data, iraungintze_data);
            String expectedToString = "Erabiltzailea [idBezeroa=123, erabiltzailea=usuario123, pasahitza=contraseña, izena=Nombre, abizena=Apellido, hizkuntza=eu, jaiotze_data=" + jaiotze_data + "]E_Premium [iraungintze_data=" + iraungintze_data + "]";
            
            assertEquals(expectedToString, ePremium.toString());
        }
        
        @Test
        public void testEquals() {
            Date jaiotze_data1 = new Date();
            Date iraungintze_data1 = new Date();
            E_Premium ePremium1 = new E_Premium("123", "usuario123", "contraseña", "Nombre", "Apellido", "eu", jaiotze_data1, iraungintze_data1);
            Date jaiotze_data2 = new Date();
            Date iraungintze_data2 = new Date();
            E_Premium ePremium2 = new E_Premium("123", "usuario123", "contraseña", "Nombre", "Apellido", "eu", jaiotze_data2, iraungintze_data2);
            
            
            ePremium2.setIraungintze_data(null);
            assertFalse(ePremium1.equals(ePremium2));
        }
        
        
        

        
 

        
}