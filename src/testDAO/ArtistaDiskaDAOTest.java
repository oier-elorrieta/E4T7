package testDAO;
import static org.junit.Assert.*;
import org.junit.Test;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Album;
import model.Artista;
import model.Musikaria;
import model.sql.ArtistaDiskaDAO;

public class ArtistaDiskaDAOTest {

    @Test
    public void testAlbumAbestiakKargatu() throws SQLException {
    	
        Artista artista = new Musikaria("Rosalia");  
        Album album1 = new Album("El Mal Querer", "2018", 3, "Flamenco");
        Album  album2 = new Album("Motomami", "2022", 3, "Flamenco");
        ArrayList<Album> albumList = ArtistaDiskaDAO.albumAbestiakKargatu(artista);
        
			assertEquals(albumList.get(0).getIzenburua(), album1.getIzenburua());
			assertEquals(albumList.get(1).getIzenburua(), album2.getIzenburua());

			assertEquals(albumList.get(0).getUrtea(), album1.getUrtea());
			assertEquals(albumList.get(1).getUrtea(), album2.getUrtea());
			
			System.out.println(albumList.get(0).getGeneroa());
			
			assertEquals(albumList.get(0).getGeneroa(), album1.getGeneroa());
			assertEquals(albumList.get(1).getGeneroa(), album2.getGeneroa());

    }
}