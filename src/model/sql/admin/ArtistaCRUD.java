package model.sql.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Artista;
import model.Musikaria;
import model.sql.Konexioa;

public class ArtistaCRUD {
	public static ArrayList<Artista> artistaIzenakKargatu() throws SQLException {
		Konexioa.konexioaIreki();
		ArrayList<Artista> artistakList = new ArrayList<Artista>();
		String SQLquery = "SELECT IzenArtistikoa, Deskribapena FROM musikaria";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		Artista artistAux = null;

		while (emaitza.next()) {
			artistAux = new Musikaria(emaitza.getString("IzenArtistikoa"), emaitza.getString("Deskribapena"));
			artistakList.add(artistAux);
		}
		Konexioa.konexioaItxi();
		return artistakList;
	}

//	public static void artistaInsert() throws SQLException {
//		Konexioa.konexioaIreki();
//		ArrayList<Artista> artistakList = new ArrayList<Artista>();
//		String SQLquery = "SELECT IzenArtistikoa FROM musikaria";
//		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
//		Artista artistAux = null;
//
//		while (emaitza.next()) {
//			artistAux = new Musikaria(emaitza.getString("IzenArtistikoa"));
//			artistakList.add(artistAux);
//		}
//		Konexioa.konexioaItxi();
//	}

	public static void artistaDelete(String izenArtistikoa) throws SQLException {
		Konexioa.konexioaIreki();
		String SQLquery = "DELETE FROM musikaria WHERE IzenArtistikoa = '" + izenArtistikoa + "'";

		Konexioa.query.executeQuery(SQLquery);

		Konexioa.konexioaItxi();
	}

	public static void artistaUpdate(String izenArtistikoa, String izenBerria, String deskripzioaBerria) throws SQLException {

		String IdArtista = IdArtistaLortu(izenArtistikoa);
		
		Konexioa.konexioaIreki();

		String SQLquery = "UPDATE musikaria SET IzenArtistikoa = '" + izenBerria + "', Deskribapena = '" + deskripzioaBerria + "' WHERE IDMusikaria = '"+ IdArtista + "'";
		Konexioa.query.executeUpdate(SQLquery);

		Konexioa.konexioaItxi();
	}

	public static String IdArtistaLortu(String izenArtistikoa) throws SQLException {
		Konexioa.konexioaIreki();
		String iDArtista = null;

		String SQLquery = "SELECT IDMusikaria FROM musikaria WHERE IzenArtistikoa = '" + izenArtistikoa + "'";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);

		while (emaitza.next()) {
			iDArtista = emaitza.getString("IDMusikaria");
		}

		return iDArtista;

	}

}
