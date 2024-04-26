package model.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.*;
import model.metodoak.SesioAldagaiak;

public class ArtistaDiskaDAO {
    public static ArrayList<Album> albumAbestiakKargatu(Artista artista) throws SQLException {
        ArrayList<Album> albumList = new ArrayList<Album>();
        String SQLquery = "SELECT izenburua,  year(urtea), count(IdAudio) from album al join abestia ab using(IdAlbum) join musikaria m using (IDMusikaria) where IzenArtistikoa = '"+ artista.getIzena() +"' group by 1, 2;";
        ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
        Album albuma = null;
        
        while (emaitza.next()) {
           albuma = new Album(emaitza.getString("izenburua"), emaitza.getString("year(urtea)"), emaitza.getInt("count(IdAudio)"));
           
           albumList.add(albuma);
        }
        
        return albumList;
    }
    
    public static Musikaria irudiaDeskribapenaKargatu(Artista artista) throws SQLException {
        String SQLquery = "SELECT Irudia, Deskribapena FROM musikaria WHERE IzenArtistikoa = '" + artista.getIzena() + "';";
        ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
        Musikaria artistInfo = null;
        
        while (emaitza.next()) {
        	artistInfo = new Musikaria(emaitza.getBlob("Irudia"), emaitza.getString("Deskribapena"));
           
        }
        
        return artistInfo;
    }
}
