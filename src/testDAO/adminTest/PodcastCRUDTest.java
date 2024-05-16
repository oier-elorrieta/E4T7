package testDAO.adminTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Podcast;
import model.sql.admin.PodcastCRUD;

public class PodcastCRUDTest {

	static Podcast podcast;
	static Podcast podcastBerria;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		podcast = new Podcast("Sin Miedo Al Exito#32", null, "03:09:00", "Alvaro845");
		podcastBerria = new Podcast("Test", null, "00:00:00", "Test");
	}

	@Test
	public void testPodcastIzenakKargatuIzena() throws SQLException {
		ArrayList<Podcast> podcastList = PodcastCRUD.podcastIzenakKargatu();
		assertEquals(podcast.getTitulua(), podcastList.get(0).getTitulua());
	}
	
	@Test
	public void testPodcastIzenakKargatuIraupena() throws SQLException {
		ArrayList<Podcast> podcastList = PodcastCRUD.podcastIzenakKargatu();
		assertEquals(podcast.getIraupena(), podcastList.get(0).getIraupena());
	}
	
	@Test
	public void testPodcastIzenakKargatuKolaboratzaileak() throws SQLException {
		ArrayList<Podcast> podcastList = PodcastCRUD.podcastIzenakKargatu();
		assertEquals(podcast.getKolaboratzaile(), podcastList.get(0).getKolaboratzaile());
	}
	
	@Test
	public void testPodcastAudio() throws SQLException {
		PodcastCRUD.podcastAudio(podcastBerria, "2");
		ArrayList<Podcast> podcastList = PodcastCRUD.podcastIzenakKargatu();
		assertEquals(podcastBerria.getTitulua(), podcastList.get(podcastList.size() - 1).getTitulua());
		PodcastCRUD.podcastDelete(podcastBerria);
	}
	
	@Test
	public void testPodcastDelete() throws SQLException {
		PodcastCRUD.podcastAudio(podcastBerria, "2");
		PodcastCRUD.podcastDelete(podcastBerria);
		ArrayList<Podcast> podcastList = PodcastCRUD.podcastIzenakKargatu();
		assertNotEquals(podcastBerria.getTitulua(), podcastList.get(podcastList.size() - 1).getTitulua());
	}
	
	
	@Test
	public void testpodcastUpdate() throws SQLException {
		PodcastCRUD.podcastAudio(podcastBerria, "2");
		PodcastCRUD.podcastUpdate(podcastBerria, new Podcast("TestPodcastUpdate", null, "02:00:00", "TestDeskribapenaUpdate"));
		ArrayList<Podcast> podcastList = PodcastCRUD.podcastIzenakKargatu();
		assertEquals("TestPodcastUpdate", podcastList.get(podcastList.size() - 1).getTitulua());
		assertEquals("02:00:00", podcastList.get(podcastList.size() - 1).getIraupena());
		PodcastCRUD.podcastDelete(podcastList.get(podcastList.size() - 1));
	}
	
	
}
