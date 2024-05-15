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
		String SQLquery = "SELECT Izena, Kolaboratzaileak FROM audio JOIN podcast USING (IdAudio);";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		Podcast artistAux = null;

		while (emaitza.next()) {
			artistAux = new Podcast(emaitza.getString("Izena"), emaitza.getString("Kolaboratzaileak"));
			podcastList.add(artistAux);
		}
		Konexioa.konexioaItxi();
		return podcastList;
	}
	
	public static void podcastInsert(String izenArtistikoa, String deskripzioaBerria) throws SQLException {
		Konexioa.konexioaIreki();
		
		String SQLquery = "INSERT INTO audio (Izena, Irudia, Iraupena, Mota) "
				+ "VALUES ('" + izenArtistikoa + "', FROM_BASE64('" + SesioAldagaiak.IrudiaBLOB + "') ,'" + deskripzioaBerria + "')";
		Konexioa.query.executeUpdate(SQLquery);

		Konexioa.konexioaItxi();
	}
}
