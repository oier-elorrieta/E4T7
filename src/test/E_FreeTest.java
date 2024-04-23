package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import model.E_Free;

public class E_FreeTest {

    private static E_Free E_FreeProba;
    private static Date dateIraun;
    private static Date data;

      @SuppressWarnings("deprecation")
      @BeforeClass
      public static void setUpBeforeClass() throws Exception {
          data = new Date(2024, 1, 20);
          E_FreeProba = new E_Free("erabiltzailea", "pasahitza", "izena", "abizena", "English", data);
      }
      
      @Test
      public void testToString() {
          String expected = "Erabiltzailea [erabiltzailea=" + E_FreeProba.getErabiltzailea() +", pasahitza="+ E_FreeProba.getPasahitza() + ", izena=" + E_FreeProba.getIzena() + ", abizena=" + E_FreeProba.getAbizena()
          + ", hizkuntza=" + E_FreeProba.getHizkuntza() + ", jaiotze_data=" + E_FreeProba.getJaiotze_data() + "]";
          assertEquals(expected, E_FreeProba.toString());    
          }
      
      @Test
      public void testEquals_SameObject() {
    	  E_Free proba1 = new E_Free("erabiltzailea", "pasahitza", "izena", "abizena", "English", data);
          assertTrue(E_FreeProba.equals(proba1));
      }
      
      @Test
      public void testEquals_NullObject() {
          E_Free proba1 = null;
         
          assertFalse(E_FreeProba.equals(proba1));
      }

      @Test
      public void testEquals_DifferentClass() {
	        String probaE_Free = "";
          assertFalse(E_FreeProba.equals(probaE_Free));
      }

      @Test
      public void testEqualsPunteroTest() {
          assertTrue(E_FreeProba.equals(E_FreeProba));
      }


}
