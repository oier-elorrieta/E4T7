package testDAO;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import model.metodoak.SesioAldagaiak;
import model.Album;
import model.Artista;
import model.Erabiltzailea;
import model.Musikaria;
import model.Abestia;
import model.Playlist;
import model.sql.PlaylistAbestiakDAO;

public class PlaylistAbestiakDAOTest {

	@Test
	public void testAbestiakPlaylistKargatu() throws SQLException {
		Playlist playlist = new Playlist("1", "Playlist1", "2");
		Abestia abestia = new Abestia("32", "red", "00:03:41");
		ArrayList<Abestia> abestiakListPlaylist = PlaylistAbestiakDAO.abestiakPlaylistKargatu(playlist);
		
		abestiakListPlaylist.add(abestia);
		
		assertTrue(abestiakListPlaylist.get(0).getIdAudio().equals(abestia.getIdAudio()));
		assertTrue(abestiakListPlaylist.get(0).getTitulua().equals(abestia.getTitulua()));
	}
	
	@Test
	public void testArtistakPlaylistKargatu() throws SQLException {
		Artista artista = new Musikaria("Taylor Swift");
		
		Artista atistaPlaylist = PlaylistAbestiakDAO.ArtistakPlaylistKargatu("32");
		
		assertTrue(atistaPlaylist.getIzena().equals(artista.getIzena()));
	}
	
	@Test
	public void testAlbumaPlaylistKargatu() throws SQLException {
		Album album = new Album("Red");
		
		Album albumPlaylist = PlaylistAbestiakDAO.albumaPlaylistKargatu("32");
		
		assertTrue(albumPlaylist.getIzenburua().equals(album.getIzenburua()));
	}
	
	@Test
	public void testAlbumaGustokoaPlaylistKargatu() throws SQLException {
		Erabiltzailea erab = new Erabiltzailea();
		erab.setIdBezeroa("juanperez&");
		SesioAldagaiak.bezeroa_logeatuta = erab;
		
		Album album = new Album("Red");
		
		Album albumPlaylist = PlaylistAbestiakDAO.albumaGustokoaPlaylistKargatu("32");
		
		assertTrue(albumPlaylist.getIzenburua().equals(album.getIzenburua()));
	}
	
	@Test
	public void testArtistakGustokoaPlaylistKargatu() throws SQLException {
		Erabiltzailea erab = new Erabiltzailea();
		erab.setIdBezeroa("juanperez&");
		SesioAldagaiak.bezeroa_logeatuta = erab;
		Artista artista = new Musikaria("Taylor Swift");
		
		Artista artistaPlaylist = PlaylistAbestiakDAO.ArtistakGustokoaPlaylistKargatu("32");
		
		assertTrue(artistaPlaylist.getIzena().equals(artista.getIzena()));
	}
	
	@Test
	public void testAbestiakArtistakPlaylistKargatu() throws SQLException {
		Playlist playlist = new Playlist("1", "Playlist1", "2");
		Artista artista = new Musikaria("Taylor Swift");
		
		ArrayList<Artista> artistaPlaylist = PlaylistAbestiakDAO.abestiakArtistakPlaylistKargatu(playlist);
		artistaPlaylist.add(artista);
		
		assertTrue(artistaPlaylist.get(0).getIzena().equals(artista.getIzena()));
	}
	
	@Test
	public void testAlbumAbestiakPlaylistKargatu() throws SQLException {
		Playlist playlist = new Playlist("1", "Playlist1", "2");
		Album album = new Album("Red");
		
		ArrayList<Album> albumPlaylist = PlaylistAbestiakDAO.albumAbestiakPlaylistKargatu(playlist);
		albumPlaylist.add(album);
		
		assertTrue(albumPlaylist.get(0).getIzenburua().equals(album.getIzenburua()));
	}
	
	
}
