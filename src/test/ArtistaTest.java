package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mysql.cj.jdbc.Blob;

import model.Artista;
import model.Musikaria;
import model.Podcaster;

import org.junit.*;

public class ArtistaTest {

	@Test
	public void testGetIzena() {
		Artista artista = new Musikaria("izena", 0);
		assertEquals("izena", artista.getIzena());
	}

	@Test
	public void testSetIzena() {
		Artista artista = new Musikaria("izena");
		artista.setIzena("name");
		assertEquals("name", artista.getIzena());
	}

	@Test
	public void testGetIrudia() {
		Blob irudia = new Blob(null, null);
		Artista artista = new Podcaster("describapena", irudia);
        assertEquals(irudia, artista.getIrudia());
	}

	@Test
	public void testSetIrudia() {
		Artista artista = new Musikaria( "describapena", "describapena");
		Blob irudia = new Blob(null, null);
		artista.setIrudia(irudia);
		assertEquals(irudia, artista.getIrudia());
	}

	@Test
	public void testgetErreprodukzioak() {
		Artista artista = new Musikaria("izena", 0);
		assertEquals(0, artista.getErreprodukzioak());
	}

	@Test
	public void testSetErreprodukzioak() {
		Artista artista = new Podcaster("izena", 0);
		artista.setErreprodukzioak(10);
		assertEquals(10, artista.getErreprodukzioak());
	}

	@Test
	public void testgetDescribapena() {
		Artista artista = new Musikaria( "describapena", "describapena");
		assertEquals("describapena", artista.getDeskribapena());
	}

	@Test
	public void testSetDescribapena() {
		Artista artista = new Musikaria( "describapena", "describapena");
		artista.setDeskribapena("aña");
		assertEquals("aña", artista.getDeskribapena());
	}

	@Test
	public void testToString() {
		Artista artista = new Musikaria("izena", 0);
		assertEquals(artista.getIzena() + " - " + artista.getErreprodukzioak() + " erreprodukzio", artista.toString());
	}

}
