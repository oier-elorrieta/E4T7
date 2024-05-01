package model.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Playlist;
import model.metodoak.SesioAldagaiak;

public class MenuaPlaylistSartuAbestiakDAO {
	
	public static Playlist gustokoaKargatu() throws SQLException {
		Konexioa.konexioaIreki();
		String SQLquery = "SELECT IdAudio, IdBezeroa FROM gustokoak WHERE IdBezeroa = (SELECT IdBezeroa FROM erabiltzailea WHERE Erabiltzailea = " + SesioAldagaiak.bezero_Ondo.getErabiltzailea() + ");";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		Playlist playlistGustoko = null;
		
		while (emaitza.next()) {
			Playlist playlist = new Playlist("Gustokoen zerrenda", emaitza.getString("IdBezeroa"), emaitza.getString("IdAudio"));
			playlistGustoko = playlist;
		}
		Konexioa.konexioaItxi();
		
		return playlistGustoko;
	}
		
}
