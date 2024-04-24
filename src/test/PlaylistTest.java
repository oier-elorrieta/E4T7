package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.Audio;
import model.Erabiltzailea;
import model.Playlist;

public class PlaylistTest {

    private Playlist playlist;

    @Before
    public void setUp() {
        playlist = new Playlist(10, "Mi Playlist");
    }

    @Test
    public void testConstructor() {
        assertEquals(10, playlist.getKapazitatea());
        assertEquals("Mi Playlist", playlist.getTitulua());
    }

    @Test
    public void testSetterKapazitatea() {
        playlist.setKapazitatea(20);
        assertEquals(20, playlist.getKapazitatea());
    }

    @Test
    public void testSetterTitulua() {
        playlist.setTitulua("Nueva Playlist");
        assertEquals("Nueva Playlist", playlist.getTitulua());
    }

    @Test
    public void testToString() {
        assertEquals("Playlist [kapazitatea=10, titulua=Mi Playlist]", playlist.toString());
    }

    @Test
    public void testEqualsSameObject() {
        assertTrue(playlist.equals(playlist));
    }

    @Test
    public void testEqualsDifferentObject() {
        Playlist other = new Playlist(10, "Mi Playlist");
        assertTrue(playlist.equals(other));
    }
    @Test
    public void testEqualsNull() {
        String other = null;
        assertFalse(playlist.equals(other));
    }
    @Test
    public void testToEqualsDiff() {
        Audio aud  = new Audio(null, 0);
        assertFalse(playlist.equals(aud));
    }
    @Test
    public void testNotEquals() {
        Playlist other = new Playlist(20, "aña Playlist");
        assertFalse(playlist.equals(other));
    }

  
}