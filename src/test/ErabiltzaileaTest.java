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
import model.E_Free;
import model.Erabiltzailea;

public class ErabiltzaileaTest {

      private Erabiltzailea erabiltzailea;
     
        @Test
        public void testConstructor() {
            erabiltzailea = new Erabiltzailea("erabiltzailea", "Pasahitza", "izena", "abizena", "Arabic", new Date());
            assertNotNull(erabiltzailea);
        }
        @Test
        public void testsetIdbezeroa() {
            erabiltzailea = new Erabiltzailea("idbez","erabiltzailea", "Pasahitza", "izena", "abizena", "Arabic", new Date());
            assertEquals("idbez", erabiltzailea.getIdBezeroa());
        }
        @Test
        public void testgetIdbezeroa() {
            erabiltzailea = new Erabiltzailea("idbezeroaaa","erabiltzailea", "Pasahitza", "izena", "abizena", "English", new Date());
            erabiltzailea.setIdBezeroa("idbez");
            assertEquals("idbez", erabiltzailea.getIdBezeroa());
        }
        @Test
        public void testGetErabiltzailea() {
            erabiltzailea = new Erabiltzailea("erabiltzailea", "Pasahitza", "izena", "abizena", "English", new Date());
            assertEquals("erabiltzailea", erabiltzailea.getErabiltzailea());
        }
        @Test
        public void testGetPasahitza() {
            erabiltzailea = new Erabiltzailea("erabiltzailea", "Pasahitza", "izena", "abizena", "English", new Date());
            assertEquals("Pasahitza", erabiltzailea.getPasahitza());
        }
        @Test
        public void testGetIzena() {
            erabiltzailea = new Erabiltzailea("erabiltzailea", "Pasahitza", "izena", "abizena", "English", new Date());

            assertEquals("izena", erabiltzailea.getIzena());
        }
        @Test
        public void testGetAbizena() {
            erabiltzailea = new Erabiltzailea("erabiltzailea", "Pasahitza", "izena", "abizena", "English", new Date());
            assertEquals("abizena", erabiltzailea.getAbizena());
        }
        @Test
        public void testGetJaiotzeData() {
            erabiltzailea = new Erabiltzailea("erabiltzailea", "Pasahitza", "izena", "abizena", "English", new Date());
            assertNotNull(erabiltzailea.getJaiotze_data());
        }
        @Test
        public void testGetHizkuntza() {
            erabiltzailea = new E_Free("id","erabiltzailea", "Pasahitza", "izena", "abizena", "English", new Date());
            assertEquals("English", erabiltzailea.getHizkuntza());
        }
        @Test
        public void testSetHizkuntza() {
            erabiltzailea = new E_Free("erabiltzailea", "Pasahitza", "izena", "abizena", "English",new Date());
            erabiltzailea.setHizkuntza("Euskera");
            assertEquals("Euskera", erabiltzailea.getHizkuntza());
        }
        @Test
        public void testSetErabiltzailea() {
            erabiltzailea = new Erabiltzailea("erabiltzailea", "Pasahitza", "izena", "abizena", "English", new Date());
            erabiltzailea.setErabiltzailea("erabiltzailea");
            assertEquals("erabiltzailea", erabiltzailea.getErabiltzailea());
        }
        @Test
        public void testSetPasahitza() {
            erabiltzailea = new Erabiltzailea("erabiltzailea", "Pasahitza", "izena", "abizena", "English", new Date());
            erabiltzailea.setPasahitza("Pasa");
            assertEquals("Pasa", erabiltzailea.getPasahitza());
        }
        @Test
        public void testSetIzena() {
            erabiltzailea = new Erabiltzailea("erabiltzailea", "Pasahitza", "izena", "abizena", "English", new Date());
            erabiltzailea.setIzena("izena");
            assertEquals("izena", erabiltzailea.getIzena());
        }
        @Test
        public void testSetAbizena() {
            erabiltzailea = new Erabiltzailea("erabiltzailea", "Pasahitza", "izena", "abizena", "English", new Date());
            erabiltzailea.setAbizena("abizena");
            assertEquals("abizena", erabiltzailea.getAbizena());
        }
        @Test
        public void testSetJaiotzeData() {
            erabiltzailea = new Erabiltzailea("erabiltzailea", "Pasahitza", "izena", "abizena", "English", new Date());
            erabiltzailea.setJaiotze_data(new Date());
            assertNotNull(erabiltzailea.getJaiotze_data());
        }
//        @Test
//        public void testSetJaiotzeData2() {
//            erabiltzailea = new E_Free("erabiltzailea", "Pasahitza", "izena", "abizena", null, new Date());
//            Date gaurkoeguna = new Date();
//            assertEquals(erabiltzailea.getJaiotze_data(), gaurkoeguna);
//        }
        
     @Test
        public void testToString() {
            // Crear un objeto Erabiltzailea con valores específicos
            Erabiltzailea erabiltzailea = new Erabiltzailea("123", "usuario123", "contraseña", "Nombre", "Apellido", "eu", null);
            
            // Definir el resultado esperado del método toString()
            String expectedToStringResult = "Erabiltzailea [idBezeroa=123, erabiltzailea=usuario123, pasahitza=contraseña, izena=Nombre, abizena=Apellido, hizkuntza=eu, jaiotze_data=null]";
            
            // Verificar si el resultado del método toString() coincide con el resultado esperado
            assertEquals(expectedToStringResult, erabiltzailea.toString());
        }
        
        @Test
        public void testToEqualsBerdina() {
            Erabiltzailea erabiltzailea1 = new Erabiltzailea("erabiltzailea","Pasahitza", "izena", "abizena","English", null);
            Erabiltzailea erabiltzailea2 = new Erabiltzailea("erabiltzailea","Pasahitza", "izena", "abizena","English", null);
            assertTrue(erabiltzailea1.equals(erabiltzailea1)) ;
        }
        @Test
        public void testToEqualsNull() {
            Erabiltzailea erabiltzailea2 = new Erabiltzailea("erabiltzailea","Pasahitza", "izena", "abizena","English", null);
            assertFalse(erabiltzailea2.equals(null));
        }
        @Test
        public void testToEqualsDiff() {
            Erabiltzailea erabiltzailea1 = new Erabiltzailea("erabiltzailea","Pasahitza", "izena", "abizena","English", null);
            Audio aud  = new Audio(null, null, null, 0);
            assertFalse(erabiltzailea1.equals(aud));
        }
    @Test
        public void testToEquals() {
            Erabiltzailea erabiltzailea1 = new Erabiltzailea("erabiltzailea","Pasahitza", "izena", "abizena","English", null);
            Erabiltzailea erabiltzailea2 = new Erabiltzailea("erabiltzailea","Pasahitza", "izena", "abizena","English", null);
            assertTrue(erabiltzailea1.equals(erabiltzailea2)) ;
        }
        @Test
        public void testToEqualsDifferentIzena() {
            Erabiltzailea erabiltzailea1 = new Erabiltzailea("erabiltzailea","Pasahitza", "izena1", "abizena","English", null);
            Erabiltzailea erabiltzailea2 = new Erabiltzailea("erabiltzailea","Pasahitza", "izena2", "abizena","English",null);
            assertFalse(erabiltzailea1.equals(erabiltzailea2));
        }
        @Test
        public void testToEqualsDifferentJaiotzeData() {
            Erabiltzailea erabiltzailea1 = new Erabiltzailea("erabiltzailea","Pasahitza", "izena", "abizena","English", null);
            Erabiltzailea erabiltzailea2 = new Erabiltzailea("erabiltzailea","Pasahitza", "izena", "abizen","English", null);
            assertFalse(erabiltzailea1.equals(erabiltzailea2));
        }

    }
