package model.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Album;
import model.Artista;
import model.Musikaria;
import model.Podcaster;
import model.metodoak.SesioAldagaiak;

public class PodcasterListDAO {
    public static Podcaster irudiaDeskribapenaKargatu(Podcaster podcaster) throws SQLException {
        String SQLquery = "SELECT Irudia, Deskribapena, IzenArtistikoa FROM musikaria WHERE IzenArtistikoa = '" + podcaster.getIzena() + "';";
        ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
        Podcaster pdcasterInfo = null;
        
        while (emaitza.next()) {
        	pdcasterInfo = new Podcaster(emaitza.getString("Deskribapena"), emaitza.getBlob("Irudia"));
           
        }
        
        return pdcasterInfo;
    }
    
    
	public static ArrayList<Artista> podcasterKargatu() throws SQLException {

		ArrayList<Artista> podcasterlist = new ArrayList<Artista>();
		String SQLquery = "SELECT * FROM podcaster_erreprodukzioak";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		Artista artistAux = null;
		
		while (emaitza.next()) {
			artistAux = new Podcaster(emaitza.getString("IzenArtistikoa"), emaitza.getInt("Totala"));
			podcasterlist.add(artistAux);
		}
		
		return podcasterlist;
	}
	
    public static ArrayList<Album> albumPodcasterKargatu(Artista artista) throws SQLException {
        ArrayList<Album> albumList = new ArrayList<Album>();
        String SQLquery = 	"SELECT Izena, Kolaboratzaileak from podcast join audio using(IdAudio) join podcaster using (IDPodcaster) where IzenArtistikoa = '" + artista.getIzena() + "' group by 1, 2;";
        ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
        Album albuma = null;
        
        while (emaitza.next()) {
           albuma = new Album(emaitza.getString("izenburua"), emaitza.getString("year(urtea)"), emaitza.getInt("count(IDAudio)"));
           
           albumList.add(albuma);
        }
        
        return albumList;
    }
	
	
}
