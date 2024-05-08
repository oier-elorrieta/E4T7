package model.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Album;
import model.Artista;
import model.Musikaria;
import model.Podcast;
import model.Podcaster;
import model.metodoak.SesioAldagaiak;

public class PodcasterListDAO {
	
	/**
	 * Podcaster baten informazioa kargatzen du datu-basean dagoen informazioarekin.
	 *
	 * @param podcaster Artista motako objektua, non podcaster baten informazioa gordetzen den.
	 * @return Podcaster motako objektu bat, non podcaster baten informazioa gordetzen den.
	 * @throws SQLException Salbuespena jaurtitzen du datu-basearekin komunikazioan errorea egon bada.
	 */
    public static Podcaster podcasterInfoKargatu(Artista podcaster) throws SQLException {
    	Konexioa.konexioaIreki();
        String SQLquery = "SELECT Deskribapena, Irudia FROM podcaster WHERE IzenArtistikoa = '" + podcaster.getIzena() + "';";
        ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
        Podcaster pdcasterInfo = null;
        
        while (emaitza.next()) {
        	pdcasterInfo = new Podcaster(emaitza.getString("Deskribapena"), emaitza.getBlob("Irudia"));
           
        }
        Konexioa.konexioaItxi();
        return pdcasterInfo;
    }

	/** 
	 * Podcaster guztien zerrenda kargatzen du datu-basean dagoen informazioarekin.
	 *
	 * @return Artista motako objektuen ArrayList bat, non podcaster bakoitzaren informazioa gordetzen den.
	 * @throws SQLException Salbuespena jaurtitzen du datu-basearekin komunikazioan errorea egon bada.
	 */
	public static ArrayList<Artista> podcasterKargatu() throws SQLException {
		Konexioa.konexioaIreki();
		ArrayList<Artista> podcasterlist = new ArrayList<Artista>();
		String SQLquery = "SELECT * FROM podcaster_erreprodukzioak";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		Artista artistAux = null;
		
		while (emaitza.next()) {
			artistAux = new Podcaster(emaitza.getString("Podcaster"), emaitza.getInt("Totala"));
			podcasterlist.add(artistAux);
		}
		Konexioa.konexioaItxi();
		return podcasterlist;
	}
	
	/**
	 * Podcaster baten podcast-ak kargatzen ditu datu-basean dagoen informazioarekin.
	 * @param artista Podcaster motako objektua, non podcast-ak kargatzen diren.
	 * @return Podcast motako objektuen ArrayList bat, non podcast-ak gordetzen diren.
	 * @throws SQLException Salbuespena jaurtitzen du datu-basearekin komunikazioan errorea egon bada.
	 */
    public static ArrayList<Podcast> podcastKargatu(Artista artista) throws SQLException {
    	Konexioa.konexioaIreki();
        ArrayList<Podcast> PodcastList = new ArrayList<Podcast>();
        String SQLquery = 	"SELECT Izena, Kolaboratzaileak, Iraupena, a.Irudia from podcast join audio a using(IdAudio) join podcaster p "
        					+ "using (IDPodcaster) where IzenArtistikoa = '" + artista.getIzena() + "' group by 1, 2, 3, 4;";
        		 
        ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
        Podcast podcast = null;
        
        while (emaitza.next()) {
           podcast = new Podcast (emaitza.getString("Izena"), emaitza.getBlob("a.Irudia"), emaitza.getString("Iraupena"), emaitza.getString("Kolaboratzaileak"));
           
           PodcastList.add(podcast);
        }
        Konexioa.konexioaItxi();
        return PodcastList;
    }
	
	
}
