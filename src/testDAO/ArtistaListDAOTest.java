package testDAO;

import static org.junit.Assert.*;
import org.junit.Test;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Artista;
import model.sql.ArtistaListDAO;

public class ArtistaListDAOTest {

    @Test
    public void testArtistakKargatu() throws SQLException {
        ArrayList<Artista> artistakList = ArtistaListDAO.artistakKargatu();

        assertNotNull(artistakList);
        assertFalse(artistakList.isEmpty());
    }
}