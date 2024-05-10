package model.sql;

import java.sql.SQLException;

import model.Playlist;
import model.metodoak.SesioAldagaiak;

public class PlaylistBerriaSortuDAO {
	
	public static void playlistBerriaSortu(Playlist playlist) throws SQLException {
		Konexioa.konexioaIreki();
		String SQLquery = "INSERT INTO playlist (Izenburua, Sorrera_data, IDBezeroa) VALUES ('" + playlist.getTitulua() + "', CURRENT_DATE, '" + SesioAldagaiak.bezeroa_logeatuta.getIdBezeroa() + "');";
		Konexioa.query.executeUpdate(SQLquery);
		Konexioa.konexioaItxi();
    }
}
