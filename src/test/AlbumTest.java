package test;

import static org.junit.Assert.*;
import org.junit.Test;

import model.Album;
import model.Audio;

public class AlbumTest {

    @Test
    public void testConstructor() {
        Album album = new Album("Izenburua", "Urtea", "Generoa");
        assertNotNull(album);
    }

    @Test
    public void testConstructorWithTotalSongs() {
        Album album = new Album("Izenburua", "Urtea", 10);
        assertNotNull(album);
    }

    @Test
    public void testConstructorWithOnlyTitle() {
        Album album = new Album("Izenburua");
        assertNotNull(album);
    }

    @Test
    public void testGetIzenburua() {
        Album album = new Album("Izenburua");
        assertEquals("Izenburua", album.getIzenburua());
    }

    @Test
    public void testGetUrtea() {
        Album album = new Album("Izenburua", "Urtea", "Generoa");
        assertEquals("Urtea", album.getUrtea());
    }

    @Test
    public void testGetGeneroa() {
        Album album = new Album("Izenburua", "Urtea", "Generoa");
        assertEquals("Generoa", album.getGeneroa());
    }

    @Test
    public void testGetKantaTotala() {
        Album album = new Album("Izenburua", "Urtea", 10);
        assertEquals(10, album.getKantaTotala());
    }

    @Test
    public void testSetIzenburua() {
        Album album = new Album("Izenburua");
        album.setIzenburua("NewIzenburua");
        assertEquals("NewIzenburua", album.getIzenburua());
    }

    @Test
    public void testSetUrtea() {
        Album album = new Album("Izenburua", "Urtea", "Generoa");
        album.setUrtea("NewUrtea");
        assertEquals("NewUrtea", album.getUrtea());
    }

    @Test
    public void testSetGeneroa() {
        Album album = new Album("Izenburua", "Urtea", "Generoa");
        album.setGeneroa("NewGeneroa");
        assertEquals("NewGeneroa", album.getGeneroa());
    }

    @Test
    public void testSetKantaTotala() {
        Album album = new Album("Izenburua", "Urtea", 10);
        album.setKantaTotala(20);
        assertEquals(20, album.getKantaTotala());
    }

    @Test
    public void testToString() {
        Album album = new Album("Izenburua", "Urtea", 10);
        assertEquals("Izenburua - Urtea - 10 kanta", album.toString());
    }

    @Test
    public void testEqualsSameObject() {
        Album album = new Album("Izenburua", "Urtea", "Generoa");
        assertTrue(album.equals(album));
    }

    @Test
    public void testEqualsDifferentObject() {
        Album album1 = new Album("Izenburua", "Urtea", "Generoa");
        Album album2 = new Album("Izenburua", "Urtea", "Generoa");
        assertTrue(album1.equals(album2));
    }

    @Test
    public void testEqualsNull() {
        Album album = new Album("Izenburua", "Urtea", "Generoa");
        assertFalse(album.equals(null));
    }

    @Test
    public void testToEqualsDiff() {
        Album album = new Album("Izenburua", "Urtea", "Generoa");
        Audio audio = new Audio(null, null, null, 0);
        assertFalse(album.equals(audio));
    }

    @Test
    public void testNotEquals() {
        Album album1 = new Album("Izenburua1", "Urtea1", "Generoa1");
        Album album2 = new Album("Izenburua2", "Urtea2", "Generoa2");
        assertFalse(album1.equals(album2));
    }
}
