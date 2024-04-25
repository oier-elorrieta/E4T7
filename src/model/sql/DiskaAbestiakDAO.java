package model.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Abestia;
import model.Album;


public class DiskaAbestiakDAO {
	public static ArrayList<Abestia> albumAbestiakKargatu(Album album) throws SQLException {
        ArrayList<Abestia> abestiList = new ArrayList<Abestia>();
        String SQLquery = "SELECT Izena, Irudia, Iraupena FROM audio a JOIN abestia USING (IdAudio) JOIN album USING (IdAlbum) WHERE album.Izenburua = '" + album.getIzenburua() + "';";
        ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
        Abestia abestiak = null;
        
        while (emaitza.next()) {
        	abestiak = new Abestia(emaitza.getString("Izena"), emaitza.getBlob("Irudia"), emaitza.getString("Iraupena"));
           
        	abestiList.add(abestiak);
        }
        
        return abestiList;
    }
}
