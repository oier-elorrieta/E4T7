package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Podcast;

public class PodcastTest {

	private static Podcast podcastProba;



    @Test
    public void testGetKolaboratzailea() {
    	Podcast podcastProba = new Podcast(null, null, null, 0, "kolab");
        assertEquals("kolab", podcastProba.getKolaboratzaile());
    }
    
    @Test
    public void testSetKolaboratzailea() {
    	Podcast podcastProba = new Podcast(null, null, null, null);
    	podcastProba.setKolaboratzaile("kolab");
        assertEquals("kolab", podcastProba.getKolaboratzaile());
    }




}
