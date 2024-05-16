package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.mysql.cj.jdbc.Blob;

import model.Audio;
import model.Erabiltzailea;

public class AudioTest {
    private Audio audio1;



      @Test
        public void testConstructor() {
            Audio audio1 = new Audio("idaudio", "tituloa", null, 121);
            assertNotNull(audio1);
        }
      @Test
      public void testConstructor1() {
    	  Blob Blob = new Blob(null, null);
          Audio audio = new Audio("Titulo", Blob, "Iraupena");
          assertNotNull(audio);
      }

      @Test
      public void testConstructor2() {
          Audio audio1 = new Audio("idaudio", "tituloa", null, 121);
          assertNotNull(audio1);
      }

      @Test
      public void testgetIdaudio() {
    	  Audio audio1 = new Audio("idaudio", "tituloa", "121");
    	  audio1.setIdAudio("aña");
          assertEquals("aña", audio1.getIdAudio());
      }

     
      
        @Test
        public void testgetTitulua() {
            Audio audio1 = new Audio("tituloa",null);
            assertEquals("tituloa", audio1.getTitulua());
        }

        @Test
        public void testgetErroprodukzioa() {
            Audio audio1 = new Audio("tituloa", null, null, 5);
            assertEquals(5, audio1.getErreprodukzioak());
        }

        @Test
        public void testsetErroprodukzioa() {
        	 Audio audio1 = new Audio("tituloa", null, null, 5);
        	 audio1.setErreprodukzioak(10);
        	 assertEquals(10, audio1.getErreprodukzioak());
        }
        
        @Test
        public void testgetIraupena() {
            Audio audio1 = new Audio("idaudio", "tituloa", "121");
            assertEquals("121", audio1.getIraupena());
        }
        
        @Test
        public void testgetBlobEquals() {
      	  Blob blob = new Blob(null, null);
          Audio audio = new Audio("Titulo", blob, "Iraupena");
          assertEquals(blob, audio.getIrudia());
          assertNotNull(blob);
        }
        
        @Test
        public void testgetBlobNull() {
      	  Blob blob = new Blob(null, null);
          Audio audio = new Audio("Titulo", blob, "Iraupena");
          assertNotNull(audio.getIrudia());
        }

        @Test
        public void testSetTitulua() {
            Audio audio1 = new Audio("idaudio", "tituloa", null, 121);
            audio1.setTitulua("aña");
            assertEquals("aña", audio1.getTitulua());
        }

        @Test
        public void testSetIraupena() {
            Audio audio1 = new Audio("idaudio", "tituloa", "121");
            audio1.setIraupena("111");
            assertEquals("111", audio1.getIraupena());
        }
        
        @Test
        public void testSetIdaudio() {
            Audio audio1 = new Audio("idaudio", "tituloa", "121");
            assertEquals("idaudio", audio1.getIdAudio());
        }
        
        @Test
        public void testToString() {
            Audio audio1 = new Audio("idaudio", "tituloa", null, 121);
            assertEquals(audio1.getTitulua() + " - " + audio1.getIraupena() + " - "+ audio1.getErreprodukzioak() + " erreprodukzio", audio1.toString());    
        }
      
    
        @Test
        public void testToEqualsBerdina() {
            Audio audio1 = new Audio("idaudio", "tituloa", null, 121);
            Audio audio2 = new Audio("idaudio", "tituloa", null, 121);
            assertTrue(audio1.equals(audio2)) ;
        }
       
        @Test
        public void testToEqualsNull() {
            Audio audio2 = new Audio("idaudio", "tituloa", null, 121);
            assertFalse(audio2.equals(null));
        }
        @Test
        public void testToEqualsDiff() {
            Erabiltzailea erabiltzailea1 = new Erabiltzailea("erabiltzailea","password", "izena", "abizena", "Español", null);
            Audio aud  = new Audio(null, null, null, 0);
            assertFalse(aud.equals(erabiltzailea1));
        }
        @Test
        public void testToEquals() {
              Audio audio0 = new Audio("aña", null, null, 121);         
            Audio audio2 = new Audio("aña", null, null, 121);
            assertTrue(audio0.equals(audio2)) ;
        }
        @Test
        public void testToEqualsDifferentIzena() {
              Audio audio0 = new Audio("hola", null, null, 121);         
            Audio audio2 = new Audio("aña", "titu", null, 12);
            assertFalse(audio0.equals(audio2));
        }
        @Test
        public void testToEqualsSame() {
            Audio audio = new Audio("idaudio", "tituloa", "121");          
            assertTrue(audio.equals(audio));
        }
   
        

}