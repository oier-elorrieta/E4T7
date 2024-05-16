package model.sql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Abestia;
import model.Album;
import model.Artista;
import model.Erabiltzailea;
import model.Playlist;
import model.metodoak.SesioAldagaiak;

/**
 * PlayListDAO klaseak datu basearekin eragiketak egiten ditu bezeroaren
 * playlist-ak kargatzeko.
 */
public class PlayListDAO {
	
	/**
	 * Bezeroaren playlist-ak kargatzeko metodoa.
	 * 
	 * @return Bezeroaren playlista.
	 * @throws SQLException SQL errorea gertatzen bada.
	 */
	public static ArrayList<Playlist> playListakKargatuBezeroa() throws SQLException {
		ArrayList<Playlist> playListList = new ArrayList<Playlist>();
        Konexioa.konexioaIreki();
        String SQLquery = "SELECT * FROM playlistInfoKop WHERE IDBezeroa = '" + SesioAldagaiak.bezeroa_logeatuta.getIdBezeroa() + "';";
        try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int idList = resultSet.getInt("IDList");
                String titulua = resultSet.getString("Izenburua");
                int kantitatea = resultSet.getInt("Kapazitatea");
                Date sorrera = resultSet.getDate("Sorrera_data");
                Date sorrera_data = new Date(sorrera.getTime());
                System.out.println(kantitatea);
                try {
					Playlist playList = new Playlist(idList, titulua, kantitatea, sorrera_data);
					playListList.add(playList);
				} catch (Exception e) {
				}
            }
        } catch (SQLException e) {
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
	public static int playListAbestiKantitatea(Playlist playList) throws SQLException {
		Konexioa.konexioaIreki();
        String SQLquery = "SELECT count(IDAudio) FROM playlist_abestiak WHERE IDList LIKE '"
                + playList.getIdPlaylist() + "';";
        try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int kantitatea = resultSet.getInt("count(IDAudio)");
                return kantitatea;
            }
        } catch (SQLException e) {
		} finally {
			Konexioa.konexioaItxi();
		}
        return 0;
	}
	
	public static int gustokoAbestiKantitatea() {
		Konexioa.konexioaIreki();
		String SQLquery = "SELECT count(IDAudio) FROM gustukoak WHERE IDBezeroa LIKE '"
				+ SesioAldagaiak.bezeroa_logeatuta.getIdBezeroa() + "';";
		try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				int kantitatea = resultSet.getInt("count(IDAudio)");
				return kantitatea;
			}
		} catch (SQLException e) {
		} finally {
			Konexioa.konexioaItxi();
		}
		return 0;
	}
	
	/**
	 * Playlist berria sortzeko metodoa.
	 * 
	 * @param playlist Playlist berria.
	 * @throws SQLException SQL errorea gertatzen bada.
	 */
	
	
	public static void playlistGordeInportatu(Playlist playlist, Erabiltzailea bezeroa) throws SQLException {
		Konexioa.konexioaIreki();
		String SQLquery = "INSERT INTO playlist (Izenburua, Sorrera_data, IDBezeroa) VALUES (?, ?, ?);";
		
		try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery)) {
			preparedStatement.setString(1, playlist.getTitulua());
			preparedStatement.setDate(2, (java.sql.Date) playlist.getSorrera_data());
			preparedStatement.setString(3, bezeroa.getIdBezeroa());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ezin izan da playlista gorde.", "Errorea", JOptionPane.ERROR_MESSAGE);
		} finally {
			Konexioa.konexioaItxi();
		}
	}

	/**
	 * Playlist berria sortzeko metodoa.
	 * 
	 * @param playlist Playlist berria.
	 * @throws SQLException SQL errorea gertatzen bada.
	 */
	public static void abestiakGordePlaylistInport(ArrayList<Abestia> abestiak, Artista artista, Album album, Playlist playlist) throws SQLException {
		Konexioa.konexioaIreki();
		String SQLquery = "INSERT INTO playlist_abestiak (IDList, IDAudio) VALUES (?, ?);";
		
		try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery)) {
			for (Abestia abestia : abestiak) {
				preparedStatement.setInt(1, playlist.getIdPlaylist());
				preparedStatement.setString(2, abestia.getIdAudio());
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ezin izan dira abestiak gehitu.", "Errorea",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			Konexioa.konexioaItxi();
		}
	}

	/**
	 * Playlist berria sortzeko metodoa.
	 * 
	 * @param playlist Playlist berria.
	 * @throws SQLException SQL errorea gertatzen bada.
	 */
	public static void playlistEzabatu(Playlist playlist) {
		Konexioa.konexioaIreki();
        String SQLquery = "DELETE FROM playlist WHERE IDList = " + playlist.getIdPlaylist() + ";";
        try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        } finally {
            Konexioa.konexioaItxi();
        }
	}

	/**
	 * Playlist berria sortzeko metodoa.
	 * 
	 * @param playlist Playlist berria.
	 * @throws SQLException SQL errorea gertatzen bada.
	 */
	public static void ezabatuAbestiaPlaylist(Playlist playlist, Abestia abestia) {
		Konexioa.konexioaIreki();
        String SQLquery = "DELETE FROM playlist_abestiak WHERE IDList = " + playlist.getIdPlaylist() + " AND IdAudio = " + abestia.getIdAudio() + ";";
        try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery)) {
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Abestia ezabatu da " + playlist.getTitulua() + " playlistik.", "Ezabatu abestia", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ezin izan da abestia ezabatu.", "Errorea", JOptionPane.ERROR_MESSAGE);
        } finally {
        	Konexioa.konexioaItxi();
        }
	}
}
