package test;

import static org.junit.Assert.*;
import org.junit.Test;

import model.Album;
import model.Audio;

public class AlbumTest {

    @Test
    public void testConstructor() {
        Album album = new Album("Izenburua", "Urtea", 10, "Generoa");
        assertNotNull(album);
    }

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
    
	public void testGetUrtea() {
		Album album = new Album("Izenburua", "Urtea", 10, "Generoa");
        album.setIzenburua("urtea1");
		assertEquals("urtea1", album.getUrtea());
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