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
       
	        assertEquals("izena", artista.getizena());
	    }

	    @Test
	    public void testSetNombre() {
	        Artista artista = new Podcaster("izena", 0);
	        artista.setizena("name");

	        assertEquals("name", artista.getizena());
	    }

	    @Test
	    public void testToString() {
	        Artista artista = new Musikaria("izena", 0);
	        assertEquals("Artista [Izena=" + artista.getizena() + "]", artista.toString());
	    }

}
