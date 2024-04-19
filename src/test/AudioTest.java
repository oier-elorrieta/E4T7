package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import model.Audio;
import model.Erabiltzailea;

public class AudioTest {
    private Audio audio1;



      @Test
        public void testConstructor() {
            Audio audio1 = new Audio("hola", 121);
            assertNotNull(audio1);
        }

        @Test
        public void testgetTitulua() {
            Audio audio1 = new Audio("hola", 121);
            assertEquals("hola", audio1.getTitulua());
        }

        @Test
        public void testgetIraupena() {
            Audio audio1 = new Audio("hola", 121);
            assertEquals(121, audio1.getIraupena());
        }


        @Test
        public void testSetTitulua() {
            Audio audio1 = new Audio("hola", 121);
            audio1.setTitulua("aña");
            assertEquals("aña", audio1.getTitulua());
        }

        @Test
        public void testSetIraupena() {
            Audio audio1 = new Audio("hola", 121);
            audio1.setIraupena(111);
            assertEquals(111, audio1.getIraupena());
        }
        
        @Test
        public void testToString() {
            Audio audio1 = new Audio("hola", 121);
            assertEquals("Audio [titulua=" + audio1.getTitulua() + ", iraupena=" + audio1.getIraupena() + "]", audio1.toString());    
        }
        @Test
        public void testToEqualsBerdina() {
            audio1 = new Audio("hola", 121);
            Audio audio2 = new Audio("aña", 121);
            assertTrue(audio1.equals(this.audio1)) ;
        }
       
        @Test
        public void testToEqualsNull() {
            Audio audio2 = new Audio("aña", 12);
            assertFalse(audio2.equals(null));
        }
        @Test
        public void testToEqualsDiff() {
            Erabiltzailea erabiltzailea1 = new Erabiltzailea("erabiltzailea","password", "izena", "abizena", null);
            Audio aud  = new Audio(null, 0);
            assertFalse(aud.equals(erabiltzailea1));
        }
        @Test
        public void testToEquals() {
              Audio audio0 = new Audio("aña", 121);         
            Audio audio2 = new Audio("aña", 121);
            assertTrue(audio0.equals(audio2)) ;
        }
        @Test
        public void testToEqualsDifferentIzena() {
              Audio audio0 = new Audio("hola", 121);         
            Audio audio2 = new Audio("aña", 12);
            assertFalse(audio0.equals(audio2));
        }

        @Test
        public void testToEqualsDifferentJaiotzeData() {
              Audio audio0 = new Audio("hola", 121);         
            Audio audio2 = new Audio("aña", 12);
            assertFalse(audio0.equals(audio2));
        }
        

}