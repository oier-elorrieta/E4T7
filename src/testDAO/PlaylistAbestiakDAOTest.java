package testDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import model.metodoak.SesioAldagaiak;
import model.Album;
import model.Artista;
import model.E_Free;
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
		SesioAldagaiak.bezeroa_logeatuta = new E_Free("a&", "a&", "a&", null, null, null);
		SesioAldagaiak.bezeroa_logeatuta.setIdBezeroa("a&");
		Album album = new Album("Red");
		Album albumPlaylist = PlaylistAbestiakDAO.albumaGustokoaPlaylistKargatu("32");
		
		assertTrue(albumPlaylist.getIzenburua().equals(album.getIzenburua()));
	}
	
	@Test
	public void testArtistakGustokoaPlaylistKargatu() throws SQLException {
		SesioAldagaiak.bezeroa_logeatuta = new E_Free("a&", "a&", "a&", null, null, null);
		SesioAldagaiak.bezeroa_logeatuta.setIdBezeroa("a&");
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
	
	
	
	@Test
    public void testGustukoAbestiakKargatu() throws SQLException {
		SesioAldagaiak.bezeroa_logeatuta = new E_Free("a&", "a&", "a&", null, null, null);
		SesioAldagaiak.bezeroa_logeatuta.setIdBezeroa("a&");
        Abestia expectedAbestiak = new Abestia("11", "Vete", null, "00:03:12");
 
        Playlist playlist = new Playlist("1", "Gustukoak", "2");
        ArrayList<Abestia> actualAbestiak = PlaylistAbestiakDAO.gustukoAbestiakKargatu(playlist);
        System.out.println(actualAbestiak);
        assertEquals(expectedAbestiak.getIdAudio(), actualAbestiak.get(0).getIdAudio());
        assertEquals(expectedAbestiak.getTitulua(), actualAbestiak.get(0).getTitulua());
        assertEquals(expectedAbestiak.getIraupena(), actualAbestiak.get(0).getIraupena());
    }

    @Test
    public void testGustukoAlbumAbestiakKargatu() throws SQLException {

        ArrayList<Album> expectedAlbums = new ArrayList<>();
        expectedAlbums.add(new Album("YHLQMDLG"));
        expectedAlbums.add(new Album("Un verano sin ti"));
        Playlist playlist = new Playlist("1", "Playlist1", "2");
        ArrayList<Album> actualAlbums = PlaylistAbestiakDAO.gustukoAlbumAbestiakKargatu(playlist);
        assertEquals(expectedAlbums.get(0).getIzenburua(), actualAlbums.get(0).getIzenburua());
        assertEquals(expectedAlbums.get(1).getIzenburua(), actualAlbums.get(1).getIzenburua());
    }

    @Test
    public void testGustukoArtistaAbestiakKargatu() throws SQLException {

        ArrayList<Artista> expectedArtists = new ArrayList<>();
        expectedArtists.add(new Musikaria("Bad Bunny"));
        expectedArtists.add(new Musikaria("Bad Bunny"));
        expectedArtists.add(new Musikaria("Bad Bunny"));
        Playlist playlist = new Playlist("1", "Playlist1", "2");
        ArrayList<Artista> actualArtists = PlaylistAbestiakDAO.gustukoArtistaAbestiakKargatu(playlist);
        assertEquals(expectedArtists.get(0).getIzena(), actualArtists.get(0).getIzena());
        assertEquals(expectedArtists.get(1).getIzena(), actualArtists.get(1).getIzena());
    }
	
}
