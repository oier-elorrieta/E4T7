package model.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.*;
import model.metodoak.SesioAldagaiak;

/**
 * ArtistaDiskaDAO klasea, artista baten diskoak eta informazioa kargatzeko.
 */
public class ArtistaDiskaDAO {
	 /**
     * Artista baten albumak eta abesti kopurua kargatzen dituen metodoa.
     *
     * @param artista Kargatu nahi den artista.
     * @return Albumen zerrenda, album bakoitzeko izenburua, urtea eta abesti kopurua dituena.
     * @throws SQLException SQL exekuzioan errorea gertatzen bada.
     */
    public static ArrayList<Album> albumAbestiakKargatu(Artista artista) throws SQLException {
    	Konexioa.konexioaIreki();
        ArrayList<Album> albumList = new ArrayList<Album>();
        String SQLquery = "SELECT izenburua,  year(urtea), count(IdAudio), Generoa from album al join abestia ab using(IdAlbum) join musikaria m using (IDMusikaria) where IzenArtistikoa = '"+ artista.getIzena() +"' group by 1, 2, 4;";
        ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
        Album albuma = null;
        
        while (emaitza.next()) {
           albuma = new Album(emaitza.getString("izenburua"), emaitza.getString("year(urtea)"), emaitza.getInt("count(IdAudio)"), emaitza.getString("Generoa"));
           
           albumList.add(albuma);
        }
        Konexioa.konexioaItxi();
        return albumList;
    }
    /**
     * Artista baten irudia eta deskribapena kargatzen dituen metodoa.
     *
     * @param artista Kargatu nahi den artista.
     * @return Musikaria objektua, artista baten irudia eta deskribapena dituena.
     * @throws SQLException SQL exekuzioan errorea gertatzen bada.
     */
    public static Musikaria irudiaDeskribapenaKargatu(Artista artista) throws SQLException {
    	Konexioa.konexioaIreki();
        String SQLquery = "SELECT Irudia, Deskribapena FROM musikaria WHERE IzenArtistikoa = '" + artista.getIzena() + "';";
        ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
        Musikaria artistInfo = null;
        
        while (emaitza.next()) {
        	artistInfo = new Musikaria(emaitza.getBlob("Irudia"), emaitza.getString("Deskribapena"));
           
        }
        Konexioa.konexioaItxi();
        return artistInfo;
    }
}
