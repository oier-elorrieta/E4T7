package model.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Abestia;
import model.Album;
import model.Playlist;
import model.metodoak.SesioAldagaiak;

public class PlaylistAbestiakDAO {
	public static ArrayList<Abestia> abestiakPlaylistKargatu(Playlist playlist) throws SQLException {
		ArrayList<Abestia> abestiakListPlaylist = new ArrayList<Abestia>();
        Konexioa.konexioaIreki();
        String SQLquery = "SELECT IdAudio, abestiIzena, iraupena FROM playlistAbestiakInfo WHERE IDList = '" + playlist.getIdPlaylist() + "';";
        try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
            	abestiakListPlaylist.add(new Abestia(resultSet.getString("IDAudio"), resultSet.getString("abestiIzena"), resultSet.getString("iraupena")));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Konexioa.konexioaItxi();
		}
        return abestiakListPlaylist;
	}
	
	public static ArrayList<Abestia> gustukoAbestiakKargatu(Playlist playlist) throws SQLException {
		ArrayList<Abestia> abestiakListGustukoakPlaylist = new ArrayList<Abestia>();
		Konexioa.konexioaIreki();
		String SQLquery = "SELECT * FROM gustukoak join audio using(IdAudio) WHERE IDBezeroa = '" + SesioAldagaiak.bezeroa_logeatuta.getIdBezeroa() + "';";
		try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				abestiakListGustukoakPlaylist.add(new Abestia(resultSet.getString("Izena"), resultSet.getBlob("Irudia"),
						resultSet.getString("Iraupena")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Konexioa.konexioaItxi();
		}
		return abestiakListGustukoakPlaylist;
	}
	/*
	public static ArrayList<Album> albumAbestiakPlaylistKargatu(Playlist playlist) throws SQLException {
		ArrayList<Album> albumAbestiakListPlaylist = new ArrayList<Album>();
        Konexioa.konexioaIreki();
        String SQLquery = "SELECT * FROM playlistAbestiakInfo WHERE IDList = '" + playlist.getIdPlaylist() + "';";
        try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
            	albumAbestiakListPlaylist.add(new Album());
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Konexioa.konexioaItxi();
		}
        return albumAbestiakListPlaylist;
	}*/
	
	public static Abestia irudiakAbestiakPlaylistKargatu(Playlist playlist) throws SQLException {
		Abestia abestiIrudia = null;
        Konexioa.konexioaIreki();
        String SQLquery = "SELECT irudia FROM playlistAbestiakInfo WHERE IDList = '" + playlist.getIdPlaylist() + "';";
        try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
            	abestiIrudia = new Abestia(resultSet.getBlob("irudia"));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Konexioa.konexioaItxi();
		}
        return abestiIrudia;
	}
}
