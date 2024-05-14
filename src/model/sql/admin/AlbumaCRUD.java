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
			albumAux = new Album(emaitza.getString("Izenburua"), emaitza.getString("Urtea"), emaitza.getString("Generoa"));
			albumList.add(albumAux);
		}
		Konexioa.konexioaItxi();
		return albumList;
	}
}
