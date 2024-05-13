package testDAO;

import static org.junit.Assert.*;
import org.junit.Test;
import java.sql.SQLException;
import java.util.ArrayList;

import model.*;
import model.sql.DiskaAbestiakDAO;

public class DiskaAbestiakDAOTest {

    @Test
    public void testAlbumAbestiakKargatu() throws SQLException {
        Album album = new Album("Motomami", "2021", 1, "Flamenco"); 
        
        Audio abestia = new Audio("6", "SAOKO", "00:02:17", 1);
        Audio abestia2 = new Audio("7", "CANDY", "00:03:13", 1);
        Audio abestia3 = new Audio("8", "HENTAI", "00:02:42", 1);
        
        ArrayList<Abestia> abestiList = DiskaAbestiakDAO.albumAbestiakKargatu(album);
        
        assertEquals(abestiList.get(0).getIdAudio(), abestia.getIdAudio());
        assertEquals(abestiList.get(1).getIdAudio(), abestia2.getIdAudio());
        assertEquals(abestiList.get(2).getIdAudio(), abestia3.getIdAudio());

        assertEquals(abestiList.get(0).getTitulua(), abestia.getTitulua());
        assertEquals(abestiList.get(1).getTitulua(), abestia2.getTitulua());
        assertEquals(abestiList.get(2).getTitulua(), abestia3.getTitulua());
        
        assertEquals(abestiList.get(0).getIraupena(), abestia.getIraupena());
        assertEquals(abestiList.get(1).getIraupena(), abestia2.getIraupena());
        assertEquals(abestiList.get(2).getIraupena(), abestia3.getIraupena());
               
    } 
}
