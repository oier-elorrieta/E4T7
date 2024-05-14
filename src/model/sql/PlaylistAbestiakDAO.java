package model.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Abestia;
import model.Album;
import model.Artista;
import model.Musikaria;
import model.Playlist;
import model.metodoak.SesioAldagaiak;

public class PlaylistAbestiakDAO {
	public static ArrayList<Abestia> abestiakPlaylistKargatu(Playlist playlist) throws SQLException {
		ArrayList<Abestia> abestiakListPlaylist = new ArrayList<Abestia>();
        Konexioa.konexioaIreki();
        String SQLquery = "SELECT IdAudio, abestiIzena, iraupena, Irudia FROM playlistAbestiakInfo WHERE IDList = '" + playlist.getIdPlaylist() + "';";
        try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
            	abestiakListPlaylist.add(new Abestia(resultSet.getString("IDAudio"), resultSet.getString("abestiIzena"), resultSet.getBlob("Irudia"), resultSet.getString("iraupena")));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Konexioa.konexioaItxi();
		}
        return abestiakListPlaylist;
	}
	
	/*public static Abestia abestiaIrudiaKargatu(Playlist playlist, String idAudio) throws SQLException {
		Abestia irudiakAbestiakPlaylist = null;
        Konexioa.konexioaIreki();
        String SQLquery = "SELECT Irudia FROM playlistAbestiakInfo WHERE IDList = '" + playlist.getIdPlaylist() + "' and IdAudio = '";
        try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
            	irudiakAbestiakPlaylist = new Abestia(resultSet.getBlob("Irudia"));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Konexioa.konexioaItxi();
		}
        return irudiakAbestiakPlaylist;
	}*/
	
	public static Artista ArtistakPlaylistKargatu(String idAudio) throws SQLException {
		Artista artistakPlaylist = null;
        Konexioa.konexioaIreki();
        String SQLquery = "SELECT artistaIzena FROM playlistAbestiakInfo WHERE IdAudio = '" + idAudio + "';";
        try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
            	artistakPlaylist = new Musikaria(resultSet.getString("artistaIzena"));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Konexioa.konexioaItxi();
		}
        return artistakPlaylist;
	}
	
	public static Album albumaPlaylistKargatu(String idAudio) throws SQLException {
		Album albumPlaylist = null;
        Konexioa.konexioaIreki();
        String SQLquery = "SELECT albumIzena FROM playlistAbestiakInfo WHERE IdAudio = '" + idAudio + "';";
        try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
            	albumPlaylist = new Album(resultSet.getString("albumIzena"));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Konexioa.konexioaItxi();
		}
        return albumPlaylist;
	}
	
	public static Album albumaGustokoaPlaylistKargatu(String idAudio) throws SQLException {
		Album albumPlaylist = null;
        Konexioa.konexioaIreki();
        String SQLquery = "SELECT Izenburua FROM gustukoak join AbestiInformazioa using (IdAudio) join audio using(IdAudio) WHERE IDBezeroa = '" + SesioAldagaiak.bezeroa_logeatuta.getIdBezeroa() + "' AND IdAudio = '" + idAudio + "';";
        try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
            	albumPlaylist = new Album(resultSet.getString("Izenburua"));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Konexioa.konexioaItxi();
		}
        return albumPlaylist;
	}
	
	public static Artista ArtistakGustokoaPlaylistKargatu(String idAudio) throws SQLException {
		Artista artistakPlaylist = null;
        Konexioa.konexioaIreki();
        String SQLquery = "SELECT `Artista izena` FROM gustukoak join AbestiInformazioa using (IdAudio) join audio using(IdAudio) WHERE IDBezeroa = '" + SesioAldagaiak.bezeroa_logeatuta.getIdBezeroa() + "' AND IdAudio = '" + idAudio + "';";
        try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
            	artistakPlaylist = new Musikaria(resultSet.getString("Artista izena"));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Konexioa.konexioaItxi();
		}
        return artistakPlaylist;
	}
	
	public static ArrayList<Artista> abestiakArtistakPlaylistKargatu(Playlist playlist) throws SQLException {
		ArrayList<Artista> artistakListPlaylist = new ArrayList<Artista>();
        Konexioa.konexioaIreki();
        String SQLquery = "SELECT artistaIzena FROM playlistAbestiakInfo WHERE IDList = '" + playlist.getIdPlaylist() + "';";
        try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
            	artistakListPlaylist.add(new Musikaria(resultSet.getString("artistaIzena")));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Konexioa.konexioaItxi();
		}
        return artistakListPlaylist;
	}
	
	
	public static ArrayList<Album> albumAbestiakPlaylistKargatu(Playlist playlist) throws SQLException {
		ArrayList<Album> albumAbestiakListPlaylist = new ArrayList<Album>();
        Konexioa.konexioaIreki();
        String SQLquery = "SELECT albumIzena, albumGeneroa, albumUrtea FROM playlistAbestiakInfo WHERE IDList = '" + playlist.getIdPlaylist() + "';";
        try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
            	albumAbestiakListPlaylist.add(new Album(resultSet.getString("albumIzena"), resultSet.getString("albumUrtea"), resultSet.getString("albumGeneroa")));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Konexioa.konexioaItxi();
		}
        return albumAbestiakListPlaylist;
	}
	
	public static ArrayList<Abestia> gustukoAbestiakKargatu(Playlist playlist) throws SQLException {
		ArrayList<Abestia> abestiakListGustukoakPlaylist = new ArrayList<Abestia>();
		Konexioa.konexioaIreki();
		String SQLquery = "SELECT * FROM gustukoak join AbestiInformazioa using (IdAudio) join audio using(IdAudio) WHERE IDBezeroa = '" + SesioAldagaiak.bezeroa_logeatuta.getIdBezeroa() + "';";
		try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				abestiakListGustukoakPlaylist.add(new Abestia(resultSet.getString("IdAudio"), resultSet.getString("Abesti izena"), resultSet.getBlob("Irudia"),
						resultSet.getString("Iraupena")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Konexioa.konexioaItxi();
		}
		return abestiakListGustukoakPlaylist;
	}
	
	public static ArrayList<Album> gustukoAlbumAbestiakKargatu(Playlist playlist) throws SQLException {
		ArrayList<Album> abestiakAlbumListGustukoakPlaylist = new ArrayList<Album>();
		Konexioa.konexioaIreki();
		String SQLquery = "SELECT * FROM gustukoak join AbestiInformazioa using (IdAudio) join audio using(IdAudio) WHERE IDBezeroa = '" + SesioAldagaiak.bezeroa_logeatuta.getIdBezeroa() + "';";
		try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				abestiakAlbumListGustukoakPlaylist.add(new Album(resultSet.getString("Izenburua")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Konexioa.konexioaItxi();
		}
		return abestiakAlbumListGustukoakPlaylist;
	}
	
	public static ArrayList<Artista> gustukoArtistaAbestiakKargatu(Playlist playlist) throws SQLException {
		ArrayList<Artista> abestiakArtistaListGustukoakPlaylist = new ArrayList<Artista>();
		Konexioa.konexioaIreki();
		String SQLquery = "SELECT * FROM gustukoak join AbestiInformazioa using (IdAudio) join audio using(IdAudio) WHERE IDBezeroa = '" + SesioAldagaiak.bezeroa_logeatuta.getIdBezeroa() + "';";
		try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				abestiakArtistaListGustukoakPlaylist.add(new Musikaria(resultSet.getString("Artista izena")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Konexioa.konexioaItxi();
		}
		return abestiakArtistaListGustukoakPlaylist;
	}
	
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
