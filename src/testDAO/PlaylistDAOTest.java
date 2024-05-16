package testDAO;

import static org.junit.Assert.assertEquals;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import org.junit.Test;

import model.Abestia;
import model.Album;
import model.Artista;
import model.E_Free;
import model.Erabiltzailea;
import model.Musikaria;
import model.Playlist;
import model.metodoak.SesioAldagaiak;
import model.sql.Konexioa;
import model.sql.PlayListDAO;

public class PlaylistDAOTest {

	
    @Test
    public void testPlayListakKargatuBezeroa() throws SQLException {
		SesioAldagaiak.bezeroa_logeatuta = new E_Free("a&", "a&", "a&", null, null, null);
		SesioAldagaiak.bezeroa_logeatuta.setIdBezeroa("a&");
        ArrayList<Playlist> expectedPlaylists = new ArrayList<>();
        expectedPlaylists.add(new Playlist(18, "asas", 1, new Date()));
       
        
        ArrayList<Playlist> actualPlaylists = PlayListDAO.playListakKargatuBezeroa();
        
        assertEquals(expectedPlaylists.size(), actualPlaylists.size());
        
     
            Playlist expectedPlaylist = expectedPlaylists.get(0);
            Playlist actualPlaylist = actualPlaylists.get(0);
            
            assertEquals(expectedPlaylist.getIdPlaylist(), actualPlaylist.getIdPlaylist());
            assertEquals(expectedPlaylist.getTitulua(), actualPlaylist.getTitulua());
            assertEquals(expectedPlaylist.getKapazitatea(), actualPlaylist.getKapazitatea());
        }
    
    
    
    @Test
    public void testPlayListAbestiKantitatea() throws SQLException {
        Playlist playlist = new Playlist();
        playlist.setIdPlaylist(1);
        
        int actualCount = PlayListDAO.playListAbestiKantitatea(playlist);
        assertEquals(3, actualCount);
    }
    
    @Test
    public void testGustokoAbestiKantitatea() throws SQLException {
		SesioAldagaiak.bezeroa_logeatuta = new E_Free("analopez&", "analopez&", "a&", null, null, null);
		SesioAldagaiak.bezeroa_logeatuta.setIdBezeroa("analopez&");
    	
    	int actualCount = PlayListDAO.gustokoAbestiKantitatea();    
        assertEquals(2, actualCount);
    }
    @Test
	public  void testplaylistGordeInportatu() throws SQLException {
		Erabiltzailea bezeroa = new E_Free(null, null, null, null, null, null);
		bezeroa.setIdBezeroa("a&");
		Playlist playlist = new Playlist("Playlist berria");
		PlayListDAO.playlistGordeInportatu(playlist, bezeroa);
		int emaitza = PlayListDAO.playListAbestiKantitatea(playlist);
		
		assertEquals(0, emaitza);
		PlayListDAO.playlistEzabatu(playlist);
		}
	@Test
	public void testPlaylistEzabatu() throws SQLException {
		Playlist playlist = new Playlist("Playlist berria");
		PlayListDAO.playlistGordeInportatu(playlist, new E_Free("a&", "a&", "a&", null, null, null));
		PlayListDAO.playlistEzabatu(playlist);
		int emaitza = PlayListDAO.playListAbestiKantitatea(playlist);
		assertEquals(0, emaitza);
	}
	
	@Test
	public void testabestiakGordePlaylistInport() throws SQLException {
		Playlist playlist = new Playlist("Playlist berria");
		playlist.setIdPlaylist(99);
		ArrayList<Abestia> abestiak = new ArrayList<>();
		Abestia abestia = new Abestia("11", "Vete","00:03:12", 0);
		abestiak.add(abestia);
		Artista artista = new Musikaria("artista", "artista");
		Album album = new Album("23", "album", "album");
        PlayListDAO.abestiakGordePlaylistInport(abestiak, artista, album, playlist);
        int kop = PlayListDAO.playListAbestiKantitatea(playlist);
		assertEquals(0, kop);
		PlayListDAO.playlistEzabatu(playlist);
    }
	
	@Test
	public void ezabatuAbestiaPlaylist() throws SQLException {
		Playlist playlist = new Playlist("Playlist berria");
		playlist.setIdPlaylist(99);
		Abestia abestia = new Abestia("11", "Vete", "00:03:12", 0);
		PlayListDAO.ezabatuAbestiaPlaylist(playlist, abestia);
		assertEquals(0, PlayListDAO.playListAbestiKantitatea(playlist));
		PlayListDAO.playlistEzabatu(playlist);
		
	}
}

