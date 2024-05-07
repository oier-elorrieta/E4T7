package model.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Abestia;
import model.Album;
import model.Artista;
import model.Audio;
import model.Playlist;
import model.metodoak.SesioAldagaiak;

public class MenuaPlaylistSartuAbestiakDAO {
	
	/*public static Playlist gustokoaKargatu() throws SQLException {
		Konexioa.konexioaIreki();
		String SQLquery = "SELECT IdAudio, IdBezeroa FROM gustukoak WHERE IdBezeroa = (SELECT IdBezeroa FROM bezeroa WHERE Erabiltzailea = '" + SesioAldagaiak.bezero_Ondo.getErabiltzailea() + "');";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		Playlist playlistGustoko = null;
		
		while (emaitza.next()) {
			Playlist playlist = new Playlist("Gustokoen zerrenda", emaitza.getString("IdBezeroa"), emaitza.getString("IdAudio"));
			playlistGustoko = playlist;
		}
		Konexioa.konexioaItxi();
		
		return playlistGustoko;
	}*/
	
	public static boolean playlistakKonprobatuAbestia(Audio audio) throws SQLException {
		Konexioa.konexioaIreki();
		String SQLquery = "SELECT count(*) FROM playlist_abestiak WHERE IdAudio = " + audio.getIdAudio() + ";";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		
		emaitza.next();
		
		if (emaitza.getInt("count(*)") == 0) {
			return true;
		}
		Konexioa.konexioaIreki();
		return false;
	}
	
	public static void playlistGorde(int idList, Audio audio) throws SQLException {
		Konexioa.konexioaIreki();
		String SQLquery = "INSERT INTO playlist_abestiak VALUES ('" + idList + "', '" + audio.getIdAudio() + "');";
		Konexioa.query.executeUpdate(SQLquery);
		Konexioa.konexioaItxi();
	}
	
	public static void gustokoaKargatu(Abestia abesti) throws SQLException {
		Konexioa.konexioaIreki();
		String SQLquery = "SELECT IdAudio FROM gustukoak WHERE IdAudio = '" + abesti.getIdAudio() + "' AND IDBezeroa = '" + SesioAldagaiak.bezero_Ondo.getIdBezeroa() + "';";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		
		if (!emaitza.next()) {
			gustokoanGorde(abesti);
		} else {
			gustokoaEzabatu(abesti);
		}
		
		Konexioa.konexioaItxi();
	}
	
	public static ArrayList<Playlist> playlistakKargatu() throws SQLException {
		Konexioa.konexioaIreki();
		String SQLquery = "SELECT IDList, Izenburua, Sorrera_data, IDBezeroa FROM playlist WHERE IDBezeroa = (SELECT IDBezeroa FROM bezeroa WHERE Erabiltzailea = '" + SesioAldagaiak.bezero_Ondo.getErabiltzailea() + "');";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		ArrayList<Playlist> playlistFree = new ArrayList<Playlist>();
		ArrayList<Playlist> playlistPremium = new ArrayList<Playlist>();
		int kont = 0;
		while (emaitza.next()) {
            Playlist playlistGuztiak = new Playlist(emaitza.getInt("IDList"), emaitza.getString("Izenburua"), 0, emaitza.getString("IdBezeroa"), emaitza.getDate("Sorrera_data"));
            
            if(kont < 2) {
            	playlistFree.add(kont, playlistGuztiak);
            }
            playlistPremium.add(playlistGuztiak);
            kont++;
        }
		
		Konexioa.konexioaItxi();
		
        if (!SesioAldagaiak.e_premium) {
             if (playlistFree.size() > 2) {
            	 playlistFree.clear();
             }
             return playlistFree;
        } else {
            return playlistPremium;
        }
        
	}
	
	public static void gustokoaEzabatu(Abestia abesti) throws SQLException {
		Konexioa.konexioaIreki();
		try {
			String SQLquery = "DELETE FROM gustukoak WHERE IdAudio = '" + abesti.getIdAudio() + "' AND IDBezeroa = '"+ SesioAldagaiak.bezero_Ondo.getIdBezeroa() + "';";
			Konexioa.query.executeUpdate(SQLquery);
			JOptionPane.showMessageDialog(null, "Gustokotik ezabatu da abestia!", "Gustokoa",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errorea egon da datu basearekin.", "Errorea",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		Konexioa.konexioaItxi();
	}
	
	public static void gustokoanGorde(Abestia abesti) throws SQLException {
			try {
				Konexioa.konexioaIreki();
				String SQLquery = "INSERT INTO gustukoak VALUES ('" + SesioAldagaiak.bezero_Ondo.getIdBezeroa() + "', '" + abesti.getIdAudio() + "')";
				Konexioa.query.executeUpdate(SQLquery);
				JOptionPane.showMessageDialog(null, "Gustokoan gorde da Playlist-a!", "Gustokoa",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Errorea egon da datu basearekin.", "Errorea",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		
		Konexioa.konexioaItxi();
	}
		
}
