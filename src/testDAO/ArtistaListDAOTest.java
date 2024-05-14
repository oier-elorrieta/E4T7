package testDAO;

import static org.junit.Assert.*;
import org.junit.Test;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Artista;
import model.Musikaria;
import model.sql.ArtistaListDAO;

public class ArtistaListDAOTest {

    @Test
    public void testArtistakKargatu() throws SQLException {
    	
    	Artista artista1 = new Musikaria("Rosalía");
        ArrayList<Artista> artistakList = ArtistaListDAO.artistakKargatu();
        
        assertEquals(artistakList.get(0).getIzena(), artista1.getIzena());
    }
}