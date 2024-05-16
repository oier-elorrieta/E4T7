package model.sql.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public static void podcastAudio(Podcast podcastBerria) throws SQLException {
		Konexioa.konexioaIreki();
		
		String SQLquery = "INSERT INTO audio (Izena, Irudia, Iraupena, Mota) "
				+ "VALUES ('" + podcastBerria.getTitulua() + "', FROM_BASE64('" + SesioAldagaiak.IrudiaBLOB + "') ,'" + podcastBerria.getIraupena() + "' ,'" 
				+ "Podcast" + "')";
		Konexioa.query.executeUpdate(SQLquery);

		Konexioa.konexioaItxi();
	}
	
	public static void podcastInsert(String izenArtistikoa, String deskripzioaBerria) throws SQLException {
		Konexioa.konexioaIreki();
		
		String SQLquery = "INSERT INTO audio (Izena, Irudia, Iraupena, Mota) "
				+ "VALUES ('" + izenArtistikoa + "', FROM_BASE64('" + SesioAldagaiak.IrudiaBLOB + "') ,'" + deskripzioaBerria + "')";
		Konexioa.query.executeUpdate(SQLquery);

		Konexioa.konexioaItxi();
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
