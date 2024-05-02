package model.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Abestia;
import model.Album;
import model.Artista;
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
	
	public static Playlist gustokoaKargatu() throws SQLException {
		Konexioa.konexioaIreki();
		String SQLquery = "SELECT IdAudio FROM gustukoak WHERE IdBezeroa = (SELECT IdBezeroa FROM bezeroa WHERE Erabiltzailea = '" + SesioAldagaiak.bezero_Ondo.getErabiltzailea() + "');";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		Playlist playlistGustokoa = null;
		while (emaitza.next()) {
			playlistGustokoa = new Playlist("Gustokoen zerrenda", emaitza.getString("IdAudio"));
		}
		Konexioa.konexioaItxi();
		return playlistGustokoa;
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
	
	public static void gustokoanGorde(Abestia abesti) throws SQLException {
		Konexioa.konexioaIreki();
		try {
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
