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
        // Creamos un objeto Artista para usarlo en la prueba
        Artista artista = new Musikaria("rosalia");

        // Ejecutamos el método que queremos probar
        ArrayList<Album> albumList = ArtistaDiskaDAO.albumAbestiakKargatu(artista);

        // Verificamos que la lista no sea nula
        assertNotNull(albumList);

        // Verificamos que la lista no esté vacía
        assertFalse(albumList.isEmpty());

        // Podemos hacer más aserciones sobre el contenido de la lista si es necesario
    }

    @Test
    public void testIrudiaDeskribapenaKargatu() throws SQLException {
        Artista artista = new Musikaria("rosalia");

        Musikaria artistInfo = ArtistaDiskaDAO.irudiaDeskribapenaKargatu(artista);

        assertNotNull(artistInfo);

    }
}