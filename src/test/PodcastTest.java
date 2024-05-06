package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Podcast;

public class PodcastTest {

	private static Podcast podcastProba;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Test
    public void testGetSet() {
        assertEquals(180, podcastProba.getIraupena());
    }

    @Test
    public void testEquals_SameObject() {
        assertTrue(podcastProba.equals(podcastProba));
    }

    @Test
    public void testEquals_NullObject() {
        assertFalse(podcastProba.equals(null));
    }

    @Test
    public void testEquals_DifferentClass() {
        String probaPodcast = "";
        assertFalse(podcastProba.equals(probaPodcast));
    }

    @Test
    public void testEquals_EqualObjects() {
    	Podcast samePodcast = new Podcast("podcast1", null, null, 180, null);
        assertTrue(podcastProba.equals(samePodcast));
    }

    @Test
    public void testEquals_DifferentObjects() {
    	Podcast differentPodcast = new Podcast("podcast2", null, null, 240, null);
        assertFalse(podcastProba.equals(differentPodcast));
    }


}
