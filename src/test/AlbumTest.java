package test;

import static org.junit.Assert.*;
import org.junit.Test;

import model.Album;
import model.Audio;

public class AlbumTest {

    @Test
    public void testGetIzenburua() {
        Album album = new Album("Izenburua", "Urtea", 10, "Generoa");
        assertEquals("Izenburua", album.getIzenburua());
    }

    @Test
    public void testSetIzenburua() {
        Album album = new Album("Izenburua", "Urtea", 10, "Generoa");
        album.setIzenburua("NewIzenburua");
        assertEquals("NewIzenburua", album.getIzenburua());
    }
    
    @Test
	public void testGetUrtea() {
		Album album = new Album("Izenburua", "Urtea", 10, "Generoa");
		assertEquals("Urtea", album.getUrtea());
	}
	
    @Test
	public void testSetUrtea() {
		Album album = new Album("Izenburua", "Urtea", 10, "Generoa");
        album.setUrtea("urtea1");
		assertEquals("urtea1", album.getUrtea());
	}
	
    @Test
	public void testGetKantTotala() {
		Album album = new Album("Izenburua", "Urtea", 10, "Generoa");
		assertEquals(10, album.getKantaTotala());
	}
    
    @Test
	public void testSetKantTotala() {
		Album album = new Album("Izenburua", "Urtea", 10, "Generoa");
        album.setKantaTotala(11);
		assertEquals(11, album.getKantaTotala());
	}
	
    @Test
	public void testGetGeneroa() {
		Album album = new Album("Izenburua", "Urtea", 10, "Generoa");
		assertEquals("Generoa", album.getGeneroa());
	}
	
    @Test
	public void testSetGeneroa() {
		Album album = new Album("Izenburua", "Urtea", 10, "Generoa");
        album.setGeneroa("generoa1");
		assertEquals("generoa1", album.getGeneroa());
	}
    
    @Test
	public void toStringTest() {
		Album album = new Album("Izenburua", "Urtea", 10, "Generoa");
		assertEquals( album.getIzenburua() + " - " + album.getUrtea() + " - " + album.getKantaTotala() + " kanta", album.toString());
	}
    

    @Test
    public void testEqualsSameObject() {
        Album album = new Album("Izenburua", "Urtea", 10, "Generoa");
        assertTrue(album.equals(album));
    }

    @Test
    public void testEqualsDifferentObject() {
        Album album1 = new Album("Izenburua", "Urtea", 10, "Generoa");
        Album album2 = new Album("Izenburua", "Urtea", 10, "Generoa");
        assertTrue(album1.equals(album2));
    }

    @Test
    public void testEqualsNull() {
        Album album = new Album("Izenburua", "Urtea", 10, "Generoa");
        assertFalse(album.equals(null));
    }

    @Test
    public void testToEqualsDiff() {
        Album album = new Album("Izenburua", "Urtea", 10, "Generoa");
        Audio audio = new Audio(null, null, null, 0);
        assertFalse(album.equals(audio));
    }

    @Test
    public void testNotEquals() {
        Album album1 = new Album("Izenburua1", "Urtea1", 10, "Generoa1");
        Album album2 = new Album("Izenburua2", "Urtea2", 10, "Generoa2");
        assertFalse(album1.equals(album2));
    }
}