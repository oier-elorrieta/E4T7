package model.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Abestia;
import model.Album;
import model.Artista;
import model.Musikaria;
import model.metodoak.SesioAldagaiak;

/**
 * DiskaAbestiakDAO klasea, diskoaren abestiak kargatzeko.
 */
public class DiskaAbestiakDAO {
    /**
     * albumAbestiakKargatu metodoak albumaren abestiak kargatzen ditu.
     * 
     * @param album
     * @return abestiList
     * @throws SQLException
     */
    public static ArrayList<Abestia> albumAbestiakKargatu(Album album) throws SQLException {
        Konexioa.konexioaIreki();
        ArrayList<Abestia> abestiList = new ArrayList<Abestia>();
        String SQLquery = "SELECT * FROM musikari_abestiak WHERE Izenburua = '" + album.getIzenburua() + "';";
        ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
        Abestia abestiak = null;
         
        while (emaitza.next()) {
            abestiak = new Abestia(emaitza.getString("IdAudio"), emaitza.getString("Izena"), emaitza.getString("Iraupena"), emaitza.getInt("count(IdAudio)"));
           
            abestiList.add(abestiak);
        }
        Konexioa.konexioaItxi();
        return abestiList;
    }
    
    /**
     * irudiaKargatu metodoak albumaren irudia kargatzen du.
     * @param album
     * @return albumInfo
     * @throws SQLException
     */
    public static Abestia irudiaKargatu(Album album) throws SQLException {
        Konexioa.konexioaIreki();
        String SQLquery = "SELECT a.Irudia FROM audio a JOIN abestia USING (IdAudio) JOIN album USING (IdAlbum) WHERE Izenburua = '" + album.getIzenburua() + "' LIMIT 1;";
        ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
        Abestia albumInfo = null;
        
        while (emaitza.next()) {
            albumInfo = new Abestia(emaitza.getBlob("a.Irudia"));
        }
        Konexioa.konexioaItxi(); 
        return albumInfo;
    }
    
    /**
     * abestiaErreprodukzioaGehitu metodoak erreprodukzioa gehitzen du.
     * 
     * @param abesti
     * @throws SQLException
     */
    public static void abestiaErreprodukzioaGehitu(Abestia abesti) throws SQLException {
        Konexioa.konexioaIreki();
        String SQLquery = "INSERT INTO erreprodukzioak(IDBezeroa, IdAudio, erreprodukzio_data) VALUES ('" + SesioAldagaiak.bezeroa_logeatuta.getIdBezeroa() + "', '" + abesti.getIdAudio() + "', CURRENT_DATE);";
        Konexioa.query.executeUpdate(SQLquery);
        Konexioa.konexioaItxi();
    }
}