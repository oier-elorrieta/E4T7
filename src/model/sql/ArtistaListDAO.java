package model.sql;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Artista;
import model.Musikaria;
import model.metodoak.SesioAldagaiak;

/**
 * ArtistaListDAO klasea, artisten zerrenda kargatzeko.
 */
public class ArtistaListDAO {
    /**
     * artistakKargatu metodoak datu basean dauden artisten zerrenda kargatzen du.
     * 
     * @return artistakList
     * @throws SQLException
     */
    public static ArrayList<Artista> artistakKargatu() throws SQLException {
        Konexioa.konexioaIreki();
        ArrayList<Artista> artistakList = new ArrayList<Artista>();
        String SQLquery = "SELECT * FROM musikaria_erreprodukzioak";
        ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
        Artista artistAux = null;
        
        while (emaitza.next()) {
            artistAux = new Musikaria(emaitza.getString("IzenArtistikoa"), emaitza.getInt("Totala"));
            artistakList.add(artistAux);
        }
        Konexioa.konexioaItxi();
        return artistakList;
    }
}