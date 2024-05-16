package testDAO.adminTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Album;
import model.sql.admin.AlbumaCRUD;

public class AlbumaCRUDTest {
	static Album album;
	static Album albumBerria;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		album = new Album("El Mal Querer", "2018-11-02", "Flamenco");
		albumBerria = new Album("Test", "2021-01-01", "Test");
		
	}
	
	@Test
	public void testAlbumIzenakKargatuTestIzenburua() throws SQLException {
		ArrayList<Album> albumList = AlbumaCRUD.albumIzenakKargatu();
		assertEquals(album.getIzenburua(), albumList.get(0).getIzenburua());
	}
	
	@Test
	public void testAlbumIzenakKargatuTestUrtea() throws SQLException {
		ArrayList<Album> albumList = AlbumaCRUD.albumIzenakKargatu();
		assertEquals(album.getUrtea(), albumList.get(0).getUrtea());
	}
	
	@Test
	public void testAlbumIzenakKargatuTestGeneroa() throws SQLException {
		ArrayList<Album> albumList = AlbumaCRUD.albumIzenakKargatu();
		assertEquals(album.getGeneroa(), albumList.get(0).getGeneroa());
	}
	
	@Test
	public void testAlbumInsertTest() throws SQLException {
		AlbumaCRUD.albumInsert(albumBerria, "1");
		ArrayList<Album> albumList = AlbumaCRUD.albumIzenakKargatu();
		assertEquals("Test", albumList.get(albumList.size() - 1).getIzenburua());

		AlbumaCRUD.albumDelete(albumBerria);
	}
	
	@Test
	public void testAlbumDeleteTest() throws SQLException {
		AlbumaCRUD.albumInsert(albumBerria, "1");
		AlbumaCRUD.albumDelete(albumBerria);
		ArrayList<Album> albumList = AlbumaCRUD.albumIzenakKargatu();
		assertNotEquals("Test", albumList.get(albumList.size() - 1).getIzenburua());
	}
	
	@Test
	public void testAlbumUpdateTest() throws SQLException {
		AlbumaCRUD.albumInsert(albumBerria, "1");
		AlbumaCRUD.albumUpdate(albumBerria, album);
		ArrayList<Album> albumList = AlbumaCRUD.albumIzenakKargatu();
		assertEquals("El Mal Querer", albumList.get(albumList.size() - 1).getIzenburua());

		AlbumaCRUD.albumDelete(album);
	}
}
