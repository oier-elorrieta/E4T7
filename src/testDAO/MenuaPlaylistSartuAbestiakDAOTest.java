package testDAO;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import model.Abestia;
import model.Audio;
import model.Playlist;
import model.sql.MenuaPlaylistSartuAbestiakDAO;

public class MenuaPlaylistSartuAbestiakDAOTest {

    @Test
    public void testPlaylistakKonprobatuAbestia() throws SQLException {
        Audio audio = new Audio("3", "Malamente", "00:02:30");
        boolean result = MenuaPlaylistSartuAbestiakDAO.playlistakKonprobatuAbestia(audio);
        assertFalse(result);
    }

    @Test
    public void testPlaylistGorde() throws SQLException {
        int idList = 1;
        Audio audio = new Audio("45", "Lovesick", "00:03:05");
        MenuaPlaylistSartuAbestiakDAO.playlistGorde(idList, audio);
        assertTrue(MenuaPlaylistSartuAbestiakDAO.playlistakKonprobatuAbestia(audio));
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
        assertTrue(MenuaPlaylistSartuAbestiakDAO.playlistakKonprobatuAbestia(abesti));
    }
}