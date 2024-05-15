package model.sql.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Album;
import model.sql.Konexioa;

public class AlbumaCRUD {
	public static ArrayList<Album> albumIzenakKargatu() throws SQLException {
		Konexioa.konexioaIreki();
		ArrayList<Album> albumList = new ArrayList<Album>();
		String SQLquery = "SELECT Izenburua, Urtea, Generoa FROM album";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		Album albumAux = null;

		while (emaitza.next()) {
			albumAux = new Album(emaitza.getString("Izenburua"), emaitza.getString("Urtea"),
					emaitza.getString("Generoa"));
			albumList.add(albumAux);
		}
		Konexioa.konexioaItxi();
		return albumList;
	}
	
	public static void albumInsert(Album albumBerria, String idMusikari) throws SQLException {
		Konexioa.konexioaIreki();

		String SQLquery = "INSERT INTO album (Izenburua, Urtea, Generoa, IDMusikaria) " + "VALUES ('" + albumBerria.getIzenburua() + "', '"
				+ albumBerria.getUrtea() + "', '" + albumBerria.getGeneroa() + "', '" + idMusikari + "')";
		Konexioa.query.executeUpdate(SQLquery);

		Konexioa.konexioaItxi();
	}

	public static void albumDelete(Album album) throws SQLException {
		Konexioa.konexioaIreki();

		int idAlbum = albumIDLortu(album);
		
		String SQLquery = "DELETE FROM album WHERE IdAlbum = '" + idAlbum + "'";
		Konexioa.query.executeUpdate(SQLquery);

		Konexioa.konexioaItxi();

	}

	public static void albumUpdate(Album album, Album albumBerria) throws SQLException {
		Konexioa.konexioaIreki();

		int idAlbum = albumIDLortu(album);
		
		String SQLquery = "UPDATE album SET Izenburua = '" + albumBerria.getIzenburua() + "', Urtea = '" + albumBerria.getUrtea()
				+ "', Generoa = '" + albumBerria.getGeneroa() + "' where IdAlbum = '" + idAlbum + "'";
		Konexioa.query.executeUpdate(SQLquery);

		Konexioa.konexioaItxi();

	}

	public static int albumIDLortu(Album album) throws SQLException {
		int IdAlbum	= 0;
				
		String SQLquery = "SELECT IdAlbum FROM album WHERE Izenburua = '"+album.getIzenburua()+"'";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);

		while (emaitza.next()) {
			IdAlbum = emaitza.getInt("IDAlbum");
		}
		
		return IdAlbum;

	}
}
