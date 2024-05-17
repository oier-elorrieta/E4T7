package model.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Playlist;
import model.metodoak.SesioAldagaiak;

public class PlaylistBerriaSortuDAO {

	public static int konprobatuPlaylistKopurua() throws SQLException {
		Konexioa.konexioaIreki();
		String SQLquery = "SELECT COUNT(*) FROM playlist WHERE IDBezeroa = '"
				+ SesioAldagaiak.bezeroa_logeatuta.getIdBezeroa() + "';";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		while (emaitza.next()) {
			return emaitza.getInt("COUNT(*)");
		}
		Konexioa.konexioaItxi();
		return 0;
	}

	/**
	 * Metodo honek datu basean playlist berri bat sortzen du.
	 * 
	 * @param playlist
	 * @throws SQLException
	 */
	public static void playlistBerriaSortu(Playlist playlist) throws SQLException {
		Konexioa.konexioaIreki();
		System.out.println(playlist.getTitulua());
		String SQLquery = "INSERT INTO playlist (Izenburua, Sorrera_data, IDBezeroa) VALUES ('" + playlist.getTitulua()
				+ "', CURRENT_DATE, '" + SesioAldagaiak.bezeroa_logeatuta.getIdBezeroa() + "');";
		Konexioa.query.executeUpdate(SQLquery);
		Konexioa.konexioaItxi();
	}
}
