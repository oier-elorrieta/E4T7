package model.sql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Abestia;
import model.Playlist;
import model.metodoak.SesioAldagaiak;

/**
 * PlayListDAO klaseak datu basearekin eragiketak egiten ditu bezeroaren
 * playlist-ak kargatzeko.
 */
public class PlayListDAO {
	private static Playlist playList;
	
	/**
	 * Bezeroaren playlist-ak kargatzeko metodoa.
	 * 
	 * @return Bezeroaren playlista.
	 * @throws SQLException SQL errorea gertatzen bada.
	 */
	public static ArrayList<Playlist> playListakKargatuBezeroa() throws SQLException {
		ArrayList<Playlist> playListList = new ArrayList<Playlist>();
        Konexioa.konexioaIreki();
        String SQLquery = "SELECT * FROM playlist WHERE IDBezeroa LIKE '"
                + SesioAldagaiak.bezeroa_logeatuta.getIdBezeroa() + "';";
        try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int idList = resultSet.getInt("IDList");
                String titulua = resultSet.getString("Izenburua");
                Date sorrera = resultSet.getDate("Sorrera_data");
                Date sorrera_data = new Date(sorrera.getTime());
                try {
					playList = new Playlist(idList, titulua, 0, sorrera_data);
					playListList.add(playList);
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Konexioa.konexioaItxi();
        }
        return playListList;
	}
	
	
	/**
	 * PlayListean dauden abesti kopurua lortzeko metodoa.
	 * 
	 * @return PlayListean dauden abesti kopurua.
	 * @throws SQLException SQL errorea gertatzen bada.
	 */
	public static void playListAbestiKantitatea() throws SQLException {
		Konexioa.konexioaIreki();
        String SQLquery = "SELECT count(IDAudio) FROM playlist_abestiak WHERE IDList LIKE '"
                + playList.getIdPlaylist() + "';";
        try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int kantitatea = resultSet.getInt("count(IDAudio)");
                playList.setKapazitatea(kantitatea);
            }
        } catch (SQLException e) {
            e.printStackTrace();
		} finally {
			Konexioa.konexioaItxi();
		}
	}
}
