package model.sql.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Artista;
import model.Musikaria;
import model.Podcaster;
import model.metodoak.SesioAldagaiak;
import model.sql.Konexioa;

public class PodcasterCRUD {
	public static ArrayList<Artista> podcasterIzenakKargatu() throws SQLException {
		Konexioa.konexioaIreki();
		ArrayList<Artista> artistakList = new ArrayList<Artista>();
		String SQLquery = "SELECT IzenArtistikoa, Deskribapena FROM podcaster";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		Artista artistAux = null;

		while (emaitza.next()) {
			artistAux = new Podcaster(emaitza.getString("IzenArtistikoa"), emaitza.getString("Deskribapena"));
			artistakList.add(artistAux);
		}
		Konexioa.konexioaItxi();
		return artistakList;
	}
	
	public static void podcasterInsert(String izenArtistikoa, String deskripzioaBerria) throws SQLException {
		Konexioa.konexioaIreki();
		
		String SQLquery = "INSERT INTO podcaster (IzenArtistikoa, Irudia, Deskribapena) "
				+ "VALUES ('" + izenArtistikoa + "', FROM_BASE64('" + SesioAldagaiak.IrudiaBLOB + "') ,'" + deskripzioaBerria + "')";
		Konexioa.query.executeUpdate(SQLquery);

		Konexioa.konexioaItxi();
	}
	
	public static void podcasterDelete(String izenArtistikoa) throws SQLException {
		String IdPodcaster = IdPodcasterLortu(izenArtistikoa);
		Konexioa.konexioaIreki();
		
		String SQLquery = "DELETE FROM podcaster WHERE IDPodcaster = '" + IdPodcaster + "'";
		Konexioa.query.executeUpdate(SQLquery);

		Konexioa.konexioaItxi();
	}
	
	public static void podcasterUpdate(String izenArtistikoa, String izenBerria, String deskripzioaBerria) throws SQLException {
		String IdPodcaster = IdPodcasterLortu(izenArtistikoa);
		Konexioa.konexioaIreki();

		String SQLquery = "UPDATE podcaster SET IzenArtistikoa = '" + izenBerria + "', Deskribapena = '" + deskripzioaBerria + "' WHERE IDPodcaster = '"+ IdPodcaster + "'";
		Konexioa.query.executeUpdate(SQLquery);
		
		Konexioa.konexioaItxi();
	}
	
	public static String IdPodcasterLortu(String izenArtistikoa) throws SQLException {
		Konexioa.konexioaIreki();
		String iDPodcaster = null;

		String SQLquery = "SELECT IDPodcaster FROM podcaster WHERE IzenArtistikoa = '" + izenArtistikoa + "'";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);

		while (emaitza.next()) {
			iDPodcaster = emaitza.getString("IDPodcaster");
		}
		return iDPodcaster;
	}
}
