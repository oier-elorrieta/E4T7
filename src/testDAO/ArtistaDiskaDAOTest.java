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
        Artista artista = new Musikaria("ArtistaTest");

        ArrayList<Album> albumList = ArtistaDiskaDAO.albumAbestiakKargatu(artista);

        assertNotNull(albumList);
    }

    @Test
    public void testIrudiaDeskribapenaKargatu() throws SQLException {
        Artista artista = new Musikaria("ArtistaTest");
        Musikaria artistInfo = ArtistaDiskaDAO.irudiaDeskribapenaKargatu(artista);
        assertNotNull(artistInfo);
    }
}


