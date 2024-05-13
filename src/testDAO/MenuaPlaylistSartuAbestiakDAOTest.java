package testDAO;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Abestia;
import model.Audio;
import model.E_Free;
import model.E_Premium;
import model.Playlist;
import model.metodoak.SesioAldagaiak;
import model.sql.MenuaPlaylistSartuAbestiakDAO;

public class MenuaPlaylistSartuAbestiakDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
    	SesioAldagaiak.bezeroa_logeatuta = new E_Free("a&", "a", "a", "EU", "EU", new Date());
	}
	
	
    @Test
    public void testPlaylistakKonprobatuAbestia() throws SQLException {
        Audio audio = new Audio("3", "Malamente", "00:02:30");
        boolean result = MenuaPlaylistSartuAbestiakDAO.playlistakKonprobatuAbestia(audio);
        assertTrue(result);
    } 

    @Test
    public void testPlaylistGorde() throws SQLException {
        int idList = 1;
        Audio audio = new Audio("15", "Morado", "00:03:20");
        MenuaPlaylistSartuAbestiakDAO.playlistGorde(idList, audio);
        assertNotNull(MenuaPlaylistSartuAbestiakDAO.playlistakKonprobatuAbestia(audio));
    }

    @Test 
    public void testGustokoaKargatuT() throws SQLException {
        Abestia abesti = new Abestia("45", "Lovesick", "00:03:05");
        MenuaPlaylistSartuAbestiakDAO.gustokoaKargatu(abesti);
        assertTrue(MenuaPlaylistSartuAbestiakDAO.playlistakKonprobatuAbestia(abesti));
    }

    @Test 
    public void testGustokoaKargatuF() throws SQLException {
        Abestia abesti = new Abestia("41", "Natural", "00:03:09");
        MenuaPlaylistSartuAbestiakDAO.gustokoaKargatu(abesti);
        assertTrue(MenuaPlaylistSartuAbestiakDAO.playlistakKonprobatuAbestia(abesti));
    }
    
    @Test
    public void testPlaylistakKargatuFree() throws SQLException { 
        SesioAldagaiak.bezeroa_logeatuta.setErabiltzailea("a");
        ArrayList<Playlist> playlists = MenuaPlaylistSartuAbestiakDAO.playlistakKargatu();
        Playlist playlist = new Playlist(18, "asas", 2, "a&", new Date());
        
        System.out.println(SesioAldagaiak.bezeroa_logeatuta.getErabiltzailea());
        
        assertEquals(playlists.get(0).getIdPlaylist(), playlist.getIdPlaylist());
        assertEquals(playlists.get(0).getTitulua(), playlist.getTitulua());
        assertEquals(playlists.get(0).getIdBezeroa(), playlist.getIdBezeroa());
    }
    
    @Test
    public void testPlaylistakKargatuPremium() throws SQLException { 
        SesioAldagaiak.bezeroa_logeatuta.setErabiltzailea("analopez");
        ArrayList<Playlist> playlists = MenuaPlaylistSartuAbestiakDAO.playlistakKargatu();
        Playlist playlist = new Playlist(13, "ANA LO", 2, "analopez&", new Date());
        
        System.out.println(SesioAldagaiak.bezeroa_logeatuta.getErabiltzailea());
        
        assertEquals(playlists.get(0).getIdPlaylist(), playlist.getIdPlaylist());
        assertEquals(playlists.get(0).getTitulua(), playlist.getTitulua());
        assertEquals(playlists.get(0).getIdBezeroa(), playlist.getIdBezeroa());
    }

    @Test
    public void testGustokoanGordeF() throws SQLException {
        Abestia abesti = new Abestia("3", "Malamente", "00:02:30");
        SesioAldagaiak.bezeroa_logeatuta.setIdBezeroa("a&");
        MenuaPlaylistSartuAbestiakDAO.gustokoanGorde(abesti);
        assertTrue(MenuaPlaylistSartuAbestiakDAO.gustokoaKargatu(abesti));
    }
    
    @Test
    public void testGustokoaEzabatu() throws SQLException {
        Abestia abesti = new Abestia("3", "Malamente", "00:02:30");
        MenuaPlaylistSartuAbestiakDAO.gustokoaEzabatu(abesti);
        assertFalse(MenuaPlaylistSartuAbestiakDAO.gustokoaKargatu(abesti));
    }
    
}