package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Artista;
import model.Musikaria;
import model.Podcaster;

import org.junit.*;

public class ArtistaTest {

	 @Test
	    public void testGetNombre() {
	        Artista artista = new Musikaria("izena", 0);
       
	        assertEquals("izena", artista.getIzena());
	    }

	    @Test
	    public void testSetNombre() {
	        Artista artista = new Podcaster("izena", 0);
	        artista.setIzena("name");

	        assertEquals("name", artista.getIzena());
	    }

	    @Test
	    public void testToString() {
	        Artista artista = new Musikaria("izena", 0);
	        assertEquals("Artista [Izena=" + artista.getIzena() + "]", artista.toString());
	    }

}
