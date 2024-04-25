package model.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.*;
import model.metodoak.SesioAldagaiak;

public class ArtistaDiskaDAO {
    public static ArrayList<Album> artistakKargatu(Artista artista) throws SQLException {
        String artistaizena = null;
        ArrayList<Album> albumList = new ArrayList<Album>();
        String SQLquery = "SELECT izenburua,  year(urtea), count(IdAudio) from album al join abestia ab using(IdAlbum) join musikaria m using (IDMusikaria) where IzenArtistikoa = '"+ artista.getIzena() +"' group by 1, 2;";
        ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
        Album albuma = null;
        
        while (emaitza.next()) {
           albuma = new Album(emaitza.getString("izenburua"), emaitza.getString("year(urtea)"), emaitza.getInt("count(IDAudio)"));
           
           albumList.add(albuma);
        }
        
        
        return albumList;
    }
}