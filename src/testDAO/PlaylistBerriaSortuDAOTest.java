package testDAO;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import model.Erabiltzailea;
import model.Playlist;
import model.metodoak.SesioAldagaiak;
import model.sql.PlaylistBerriaSortuDAO;

public class PlaylistBerriaSortuDAOTest {

	@Test
	public void testKonprobatuPlaylistKopurua() throws SQLException {
		Erabiltzailea erab = new Erabiltzailea();
		erab.setIdBezeroa("juanperez&");
		
		SesioAldagaiak.bezeroa_logeatuta = erab;
		
		int emaitza = PlaylistBerriaSortuDAO.konprobatuPlaylistKopurua();
		assertEquals(2, emaitza);
	}

	@Test
	public void testPlaylistBerriaSortu() throws SQLException {
		Erabiltzailea erab = new Erabiltzailea();
		erab.setIdBezeroa("juanperez&");
		Playlist berria = new Playlist("Playlist berria");

		SesioAldagaiak.bezeroa_logeatuta = erab;

		PlaylistBerriaSortuDAO.playlistBerriaSortu(berria);
		int emaitza = PlaylistBerriaSortuDAO.konprobatuPlaylistKopurua();
		assertEquals(2, emaitza);
	}
}
