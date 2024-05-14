package testDAO;

import static org.junit.Assert.*;
import org.junit.Test;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Artista;
import model.Podcaster;
import model.sql.PodcasterListDAO;
import model.Podcast;

public class PodcasterDAOTest {

	@Test
	public void testPodcasterInfoKargatu() throws SQLException {
		Artista podcaster = new Podcaster("Jordi Willd", 0);
		Podcaster result = PodcasterListDAO.podcasterInfoKargatu(podcaster);
		assertNotNull(result);
		assertEquals(
				"Jordi Wild espainiar sortzaile ospetsua da, YouTube bezalako plataformetan duen presentziagatik ezaguna."
						+ " Edukiak gai sorta zabala biltzen du, umoretik hasi eta bidaia eta esperientzia pertsonaletaraino.",
				result.getDeskribapena());
	}

	@Test
	public void testPodcasterKargatu() throws SQLException {
		ArrayList<Artista> result = PodcasterListDAO.podcasterKargatu();
		assertNotNull(result);
		assertEquals(2, result.size());
		assertEquals("Jordi Willd", result.get(0).getIzena());
		assertEquals("Deloxx", result.get(1).getIzena());
	}

	@Test
	public void testPodcastKargatu() throws SQLException {
		Artista podcaster = new Podcaster("Jordi Willd", 0);
		ArrayList<Podcast> result = PodcasterListDAO.podcastKargatu(podcaster);
		assertEquals(1, result.size());
		assertEquals("The Wild Project#277", result.get(0).getTitulua());
	}
}
