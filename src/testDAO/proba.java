package testDAO;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Artista;
import model.Podcaster;
import model.sql.admin.PodcasterCRUD;


public class proba {

    private static Podcaster podcaster;
    private static Podcaster podcasterBerria;
    
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        podcaster = new Podcaster("1", "Jordi Willd");
        podcasterBerria = new Podcaster("3", "TestPodcaster");
    }

    @Test
    public  void testPodcasterIzenakKargatuIzena() throws SQLException {
        ArrayList<Artista> artistakList = PodcasterCRUD.podcasterIzenakKargatu();
        assertEquals(podcaster.getIzena(), artistakList.get(0).getIzena());
    }
    
    @Test
    public  void testPodcasterIzenakKargatuDeskribapena() throws SQLException {
        ArrayList<Artista> artistakList = PodcasterCRUD.podcasterIzenakKargatu();
        assertEquals(podcaster.getDeskribapena(), artistakList.get(0).getDeskribapena());
    }
    
    @Test
    public  void testPodcasterInsert() throws SQLException {
        PodcasterCRUD.podcasterInsert(podcasterBerria.getIzena(), podcasterBerria.getDeskribapena());
        ArrayList<Artista> artistakList = PodcasterCRUD.podcasterIzenakKargatu();
        assertEquals(podcasterBerria.getIzena(), artistakList.get(artistakList.size() - 1).getIzena());
        
        PodcasterCRUD.podcasterDelete(podcasterBerria.getIzena());
    }
    
    @Test
    public  void testPodcasterDelete() throws SQLException {
        PodcasterCRUD.podcasterInsert(podcasterBerria.getIzena(), podcasterBerria.getDeskribapena());
        PodcasterCRUD.podcasterDelete(podcasterBerria.getIzena());
        ArrayList<Artista> artistakList = PodcasterCRUD.podcasterIzenakKargatu();
        assertEquals(podcasterBerria.getIzena(), artistakList.get(artistakList.size() - 1).getIzena());
    }
    
    @Test
    public  void testPodcasterUpdate() throws SQLException {
        PodcasterCRUD.podcasterInsert(podcasterBerria.getIzena(), podcasterBerria.getDeskribapena());
        PodcasterCRUD.podcasterUpdate(podcasterBerria.getIzena(), "TestPodcasterUpdate", "TestDeskribapenaUpdate");
        ArrayList<Artista> artistakList = PodcasterCRUD.podcasterIzenakKargatu();
        assertEquals("TestPodcasterUpdate", artistakList.get(artistakList.size() - 1).getIzena());
        assertEquals("TestDeskribapenaUpdate", artistakList.get(artistakList.size() - 1).getDeskribapena());

        PodcasterCRUD.podcasterDelete("TestPodcasterUpdate");
    }
}
