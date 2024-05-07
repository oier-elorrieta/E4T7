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
        Album album = new Album("motomami");
        ArrayList<Abestia> abestiList = DiskaAbestiakDAO.albumAbestiakKargatu(album);

        assertNotNull(abestiList);

        assertFalse(abestiList.isEmpty());

    }

    @Test
    public void testIrudiaKargatu() throws SQLException {
        Album album = new Album("motomami");

        Abestia albumInfo = DiskaAbestiakDAO.irudiaKargatu(album);

        assertNotNull(albumInfo);

    }
}
