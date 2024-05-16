package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import model.Audio;
import model.Erabiltzailea;
import model.Playlist;

public class PlaylistTest {

    private Playlist playlist;
    private Date data;

    
    @SuppressWarnings("deprecation")
    @Test
	public void testGetSorreradata() {
        playlist = new Playlist( "Mi Playlist", 30, null);
    	 data = new Date(2024, 1, 20);
    	 playlist.setSorrera_data(data);
        assertEquals(data, playlist.getSorrera_data());
    }

    @Test
    public void testSetSorreradata() {
        playlist = new Playlist(10, "Mi Playlist", 30, null, null);
        playlist.setTitulua("Nueva Playlist");
        assertEquals("Nueva Playlist", playlist.getTitulua());
    }
    @Test
    public void testgetKapazitatea() {
    	Playlist playlist2 = new Playlist( "Mi Playlist", 2 );
        assertEquals(2, playlist2.getKapazitatea());
    }
    @Test
    public void testSetKapazitatea() {
        playlist = new Playlist(10, "Mi Playlist", 30 );
        playlist.setKapazitatea(20);
        assertEquals(20, playlist.getKapazitatea());
    }
    @Test
    public void testGetTitulua() {
    	Playlist playlist2 = new Playlist(null);
        assertEquals("Gustokoen zerrenda", playlist2.getTitulua());
    }
    @Test
    public void testSetTitulua() {
        playlist = new Playlist(10, "Mi Playlist", 30, null, null);
        playlist.setTitulua("Nueva Playlist");
        assertEquals("Nueva Playlist", playlist.getTitulua());
    }
    @Test
    public void testGetIdPlaylist() {
    	  playlist = new Playlist(1, "Mi Playlist", 0, null);
       assertEquals(1, playlist.getIdPlaylist());
   }

   @Test
   public void testSetIdPlaylist() {
       playlist = new Playlist(10, "Mi Playlist", 30, null, null);

       playlist.setIdPlaylist(1);
       assertEquals(1, playlist.getIdPlaylist());
   }

   @Test
   public void testGetIdbezero() {
	   Playlist playlist2 = new Playlist("Mi Playlist", "idbez");
	   playlist2.setIdBezeroa("idbez");
	   assertEquals("idbez", playlist2.getIdBezeroa());
   }
   
   @Test
   public void testSetIdbezero() {
	   playlist = new Playlist();
       playlist.setIdBezeroa("idbezeroa");
       assertEquals("idbezeroa", playlist.getIdBezeroa());
   }
   @Test
   public void testGetIdaudio() {
	   playlist = new Playlist("Mi Playlist", "idbez");
	   playlist.setIdAudio("idaudio");
       assertEquals("idaudio", playlist.getIdAudio());
   }
   
   @Test
   public void testSetIdaudio() {
	   playlist = new Playlist("Mi Playlist", "idbez");
       playlist.setIdAudio("idau");
       assertEquals("idau", playlist.getIdAudio());
   }
   
   @Test
   public void testToString() {
	   playlist = new Playlist(10, "Mi Playlist", 30, null, null);
       assertEquals(playlist.getTitulua() + " - " + playlist.getKapazitatea() + " abesti", playlist.toString());
   }
   
   
    @Test
    public void testEqualsSameObject() {
        playlist = new Playlist(10, "Mi Playlist", 30, null, null);
        assertTrue(playlist.equals(playlist));
    }

    @Test
    public void testEqualsDifferentObject() {
        playlist = new Playlist(10, "Mi Playlist", 30, null, null);
        Playlist other = new Playlist(10, "Mi Playlist", 0, null, null);
        assertFalse(playlist.equals(other));
    }
    
    @Test
    public void testEqualsNull() {
        playlist = new Playlist(10, "Mi Playlist", 30, null, null);

        String other = null;
        assertFalse(playlist.equals(other));
    }
    @Test
    public void testToEqualsDiff() {
        playlist = new Playlist(10, "Mi Playlist", 30, null, null);

        Audio aud  = new Audio(null, null, null, 0);
        assertFalse(playlist.equals(aud));
    }
    @Test
    public void testNotEquals() {
        playlist = new Playlist(10, "Mi Playlist", 30, null, null);
        Playlist other = new Playlist(20, "aña Playlist", 0, null, null);
        assertFalse(playlist.equals(other));
    }

  
}