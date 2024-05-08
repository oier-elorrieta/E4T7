package testDAO;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Abestia;
import model.Audio;
import model.E_Premium;
import model.Playlist;
import model.metodoak.SesioAldagaiak;
import model.sql.MenuaPlaylistSartuAbestiakDAO;

public class MenuaPlaylistSartuAbestiakDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
    	SesioAldagaiak.bezeroa_logeatuta = new E_Premium("analopez", "Ana", "Lopez", "EU", "EU", new Date(), new Date());
	}
	
	
    @Test
    public void testPlaylistakKonprobatuAbestia() throws SQLException {
        Audio audio = new Audio("3", "Malamente", "00:02:30");
        boolean result = MenuaPlaylistSartuAbestiakDAO.playlistakKonprobatuAbestia(audio);
        assertFalse(result);
    }

    @Test
    public void testPlaylistGorde() throws SQLException {
        int idList = 1;
        Audio audio = new Audio("15", "Morado", "00:03:20");
        MenuaPlaylistSartuAbestiakDAO.playlistGorde(idList, audio);
        assertNotNull(MenuaPlaylistSartuAbestiakDAO.playlistakKonprobatuAbestia(audio));
    }

    @Test 
    public void testGustokoaKargatu() throws SQLException {
        Abestia abesti = new Abestia("45", "Lovesick", "00:03:05");
        MenuaPlaylistSartuAbestiakDAO.gustokoaKargatu(abesti);
        assertFalse(MenuaPlaylistSartuAbestiakDAO.playlistakKonprobatuAbestia(abesti));
    }

    @Test
    public void testPlaylistakKargatu() throws SQLException { 
        ArrayList<Playlist> playlists = MenuaPlaylistSartuAbestiakDAO.playlistakKargatu();
        assertNotNull(playlists);
        assertFalse(playlists.isEmpty());
    }

    @Test
    public void testGustokoaEzabatu() throws SQLException {
        Abestia abesti = new Abestia("3", "Malamente", "00:02:30");
        MenuaPlaylistSartuAbestiakDAO.gustokoaEzabatu(abesti);
        assertFalse(MenuaPlaylistSartuAbestiakDAO.playlistakKonprobatuAbestia(abesti));
    }

    @Test
    public void testGustokoanGorde() throws SQLException {
        Abestia abesti = new Abestia("3", "Malamente", "00:02:30");
        MenuaPlaylistSartuAbestiakDAO.gustokoanGorde(abesti);
        assertFalse(MenuaPlaylistSartuAbestiakDAO.playlistakKonprobatuAbestia(abesti));
    }
}