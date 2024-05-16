package model.sql.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Artista;
import model.Podcast;
import model.Podcaster;
import model.metodoak.SesioAldagaiak;
import model.sql.Konexioa;

public class PodcastCRUD {
	public static ArrayList<Podcast> podcastIzenakKargatu() throws SQLException {
		Konexioa.konexioaIreki();
		ArrayList<Podcast> podcastList = new ArrayList<Podcast>();
		String SQLquery = "SELECT Izena, Kolaboratzaileak, Iraupena FROM audio JOIN podcast USING (IdAudio);";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		Podcast podcastAux = null; 

		while (emaitza.next()) {
			podcastAux = new Podcast(emaitza.getString("Izena"), null, emaitza.getString("Iraupena"), emaitza.getString("Kolaboratzaileak"));
			podcastList.add(podcastAux);
		}
		Konexioa.konexioaItxi();
		return podcastList;
	}
	
	public static void podcastAudio(Podcast podcastBerria, String idPodcaster) throws SQLException {
		Konexioa.konexioaIreki();
		
		String SQLquery = "INSERT INTO audio (Izena, Irudia, Iraupena, Mota) "
				+ "VALUES ('" + podcastBerria.getTitulua() + "', FROM_BASE64('" + SesioAldagaiak.IrudiaBLOB + "') ,'" + podcastBerria.getIraupena() 
				+ "' , 'Podcasta')";
		int idAudioBerria = -1;
	    Konexioa.query.executeUpdate(SQLquery, Statement.RETURN_GENERATED_KEYS);
	    ResultSet rs = Konexioa.query.getGeneratedKeys();
	    if (rs.next()) {
	    	idAudioBerria = rs.getInt(1);
	    }

	    podcastInsert(idAudioBerria, idPodcaster, podcastBerria.getKolaboratzaile());
		Konexioa.konexioaItxi();
	}
	
	public static void podcastInsert(int idAudioBerria, String idPodcaster, String kolaboratzaile) throws SQLException {
		
		System.out.println(idAudioBerria);
		System.out.println(idPodcaster);
		
		String SQLquery = "INSERT INTO podcast (IdAudio, Kolaboratzaileak, IDPodcaster) VALUES ('" + idAudioBerria 
                + "' ,'" + kolaboratzaile + "' ,'" + idPodcaster + "')";
		
		Konexioa.query.executeUpdate(SQLquery);

	}
	
	public static void podcastDelete(Podcast podcast) throws SQLException {
		Konexioa.konexioaIreki();

		int podcastId  = podcastIdLortu(podcast);
		
		String SQLquery = "DELETE FROM audio WHERE IdAudio = '" + podcastId + "'";
		Konexioa.query.executeUpdate(SQLquery);

		Konexioa.konexioaItxi();
	}
	
	public static void podcastUpdate(Podcast podcastOLD, Podcast podcastBerria) throws SQLException {
		Konexioa.konexioaIreki();

		int podcastId  = podcastIdLortu(podcastOLD);
		
		String SQLquery = "UPDATE audio SET Izena = '" + podcastBerria.getTitulua() + "', "
        		+ "Iraupena = '" + podcastBerria.getIraupena() + "' WHERE IdAudio = '" + podcastId + "'";
		Konexioa.query.executeUpdate(SQLquery);
		
		Konexioa.konexioaItxi();
	}
    
	public static int podcastIdLortu(Podcast podcast) throws SQLException {

		int id = -1;
				
		String SQLquery = "SELECT IdAudio FROM audio WHERE Izena = '" + podcast.getTitulua() + "' AND Mota = 'Podcasta'";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		if (emaitza.next()) {
			id = emaitza.getInt("IdAudio");
		}
		return id;
	}
    
    
}
