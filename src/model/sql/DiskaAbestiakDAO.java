package model.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Abestia;
import model.Album;
import model.Artista;
import model.Musikaria;


public class DiskaAbestiakDAO {
	public static ArrayList<Abestia> albumAbestiakKargatu(Album album) throws SQLException {
        ArrayList<Abestia> abestiList = new ArrayList<Abestia>();
        String SQLquery = "SELECT Izena, Iraupena, count(IdAudio) FROM audio a JOIN abestia USING (IdAudio) JOIN album USING (IdAlbum) JOIN erreprodukzioak USING (IdAudio) WHERE album.Izenburua = '" + album.getIzenburua() + "' group by Izena, Irudia, Iraupena;";
        ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
        Abestia abestiak = null;
        
        while (emaitza.next()) {
        	abestiak = new Abestia(emaitza.getString("Izena"), emaitza.getString("Iraupena"), emaitza.getInt("count(IdAudio)"));
           
        	abestiList.add(abestiak);
        }
        
        return abestiList;
    }
	
	public static Abestia irudiaKargatu(Album album) throws SQLException {
        String SQLquery = "SELECT a.Irudia FROM audio a JOIN abestia USING (IdAudio) JOIN album USING (IdAlbum) WHERE Izenburua = '" + album.getIzenburua() + "' LIMIT 1;";
        ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
        Abestia albumInfo = null;
        
        while (emaitza.next()) {
        	albumInfo = new Abestia(emaitza.getBlob("a.Irudia"));
        }
        
        return albumInfo;
	}
}
