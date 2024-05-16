package testDAO.adminTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Artista;
import model.Musikaria;
import model.sql.admin.ArtistaCRUD;

public class ArtistaCRUDTest {

	static Artista artista;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		artista = new Musikaria("Bad Bunny",
				"Benito Antonio Martínez Ocasio, "
						+ "Bad Bunny bezala ezaguna, Puerto Rico-ko kantari eta raperoa da. 1994ko martxoaren 10ean "
						+ "jaio zen San Juan, Puerto Rico.");
	}

	@Test
	public void testArtistaIzenakKargatuTestIzena() throws SQLException {
		ArrayList<Artista> artistakList = ArtistaCRUD.artistaIzenakKargatu();
		assertEquals(artista.getIzena(), artistakList.get(1).getIzena());
	}

	@Test
	public void testArtistaIzenakKargatuTestDeskripzioa() throws SQLException {
		ArrayList<Artista> artistakList = ArtistaCRUD.artistaIzenakKargatu();
		assertEquals(artista.getDeskribapena(), artistakList.get(1).getDeskribapena());
	}

	@Test
	public void testArtistaInsertTest() throws SQLException {
		ArtistaCRUD.artistaInsert("Test", "Bakarlaria", "Test");
		ArrayList<Artista> artistakList = ArtistaCRUD.artistaIzenakKargatu();
		assertEquals("Test", artistakList.get(artistakList.size() - 1).getIzena());

		ArtistaCRUD.artistaDelete("Test");

	}

	@Test
	public void testArtistaDeleteTest() throws SQLException {
		ArtistaCRUD.artistaInsert("Test", "Bakarlaria", "Test");
		ArtistaCRUD.artistaDelete("Test");
		ArrayList<Artista> artistakList = ArtistaCRUD.artistaIzenakKargatu();
		assertNotEquals("Test", artistakList.get(artistakList.size() - 1).getIzena());
	}

	@Test
	public void testArtistaUpdateTest() throws SQLException {
		ArtistaCRUD.artistaInsert("Test", "Bakarlaria", "Test");
		ArtistaCRUD.artistaUpdate("Test", "TestUpdate", "TestUpdate");
		ArrayList<Artista> artistakList = ArtistaCRUD.artistaIzenakKargatu();
		assertEquals("TestUpdate", artistakList.get(artistakList.size() - 1).getIzena());

		ArtistaCRUD.artistaDelete("TestUpdate");
	} 

}
