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

/**
 * MenuaPlaylistSartuAbestiakDAO klaseak datu basearekin konexioa izango duen
 * klasea da. Klase honek datu basearekin eragiketak egingo ditu, hau da,
 * playlistak kudeatuko ditu.
 * 
 */
public class MenuaPlaylistSartuAbestiakDAO {
	
	/**
	 * Audio bat jasotzen du eta datu basean begiratzen du ea audio hori dagoeneko playlist batean sartuta dagoen.
	 *
	 * @param audio Audio objektua, non audioaren identifikadorea erabiliko den SQL kontsulta egiteko.
	 * @return boolean Balioa itzultzen du, true balioa itzuliko du audioa ez badago playlist batean sartuta, false bestela.
	 * @throws SQLException Salbuespena jaurtitzen du datu basearekin arazo bat egon ezkero.
	 */
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
	
	/**
	 * Playlist batean audio bat sartzen du datu basean.
	 *
	 * @param idList Playlistaren identifikadorea, non audioa sartuko den.
	 * @param audio Audio objektua, non audioaren identifikadorea erabiliko den SQL kontsulta egiteko.
	 * @throws SQLException Salbuespena jaurtitzen du datu basearekin arazo bat egon ezkero.
	 */
	public static void playlistGorde(int idList, Audio audio) throws SQLException {
		Konexioa.konexioaIreki();
		String SQLquery = "INSERT INTO playlist_abestiak VALUES ('" + idList + "', '" + audio.getIdAudio() + "');";
		Konexioa.query.executeUpdate(SQLquery);
		Konexioa.konexioaItxi();
	}
	
	/**
	 * Playlist batean audio bat ezabatzen du datu basean.
	 *
	 * @param idList Playlistaren identifikadorea, non audioa ezabatuko den.
	 * @param audio  Audio objektua, non audioaren identifikadorea erabiliko den SQL
	 *               kontsulta egiteko.
	 * @throws SQLException Salbuespena jaurtitzen du datu basearekin arazo bat egon
	 *                      ezkero.
	 */
	public static void gustokoaKargatu(Abestia abesti) throws SQLException {
		Konexioa.konexioaIreki();
		String SQLquery = "SELECT IdAudio FROM gustukoak WHERE IdAudio = '" + abesti.getIdAudio() + "' AND IDBezeroa = '" + SesioAldagaiak.bezeroa_logeatuta.getIdBezeroa() + "';";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		
		if (!emaitza.next()) {
			gustokoanGorde(abesti);
		} else {
			gustokoaEzabatu(abesti);
		}
		
		Konexioa.konexioaItxi();
	}
	
	/**
	 * Playlist batean audio bat sartzen du datu basean.
	 *
	 * @param idList Playlistaren identifikadorea, non audioa sartuko den.
	 * @param audio  Audio objektua, non audioaren identifikadorea erabiliko den SQL
	 *               kontsulta egiteko.
	 * @throws SQLException Salbuespena jaurtitzen du datu basearekin arazo bat egon
	 *                      ezkero.
	 */
	public static ArrayList<Playlist> playlistakKargatu() throws SQLException {
		Konexioa.konexioaIreki();
		String SQLquery = "SELECT IDList, Izenburua, Sorrera_data, IDBezeroa FROM playlist WHERE IDBezeroa = (SELECT IDBezeroa FROM bezeroa WHERE Erabiltzailea = '" + SesioAldagaiak.bezeroa_logeatuta.getErabiltzailea() + "');";
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
	
	/**
	 * Playlist batean audio bat sartzen du datu basean.
	 *
	 * @param idList Playlistaren identifikadorea, non audioa sartuko den.
	 * @param audio  Audio objektua, non audioaren identifikadorea erabiliko den SQL
	 *               kontsulta egiteko.
	 * @throws SQLException Salbuespena jaurtitzen du datu basearekin arazo bat egon
	 *                      ezkero.
	 */
	public static void gustokoaEzabatu(Abestia abesti) throws SQLException {
		Konexioa.konexioaIreki();
		try {
			String SQLquery = "DELETE FROM gustukoak WHERE IdAudio = '" + abesti.getIdAudio() + "' AND IDBezeroa = '"+ SesioAldagaiak.bezeroa_logeatuta.getIdBezeroa() + "';";
			Konexioa.query.executeUpdate(SQLquery);
			JOptionPane.showMessageDialog(null, "Gustokotik ezabatu da abestia!", "Gustokoa [Ezabatu]",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errorea egon da datu basearekin.", "Errorea",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		Konexioa.konexioaItxi();
	}
	
	/**
	 * Playlist batean audio bat sartzen du datu basean.
	 *
	 * @param idList Playlistaren identifikadorea, non audioa sartuko den.
	 * @param audio  Audio objektua, non audioaren identifikadorea erabiliko den SQL
	 *               kontsulta egiteko.
	 * @throws SQLException Salbuespena jaurtitzen du datu basearekin arazo bat egon
	 *                      ezkero.
	 */
	public static void gustokoanGorde(Abestia abesti) throws SQLException {
			try {
				Konexioa.konexioaIreki();
				String SQLquery = "INSERT INTO gustukoak VALUES ('" + SesioAldagaiak.bezeroa_logeatuta.getIdBezeroa() + "', '" + abesti.getIdAudio() + "')";
				Konexioa.query.executeUpdate(SQLquery);
				JOptionPane.showMessageDialog(null, "Gustokoan gorde da Playlist-a!", "Gustokoa [Gorde]",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Errorea egon da datu basearekin.", "Errorea",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		
		Konexioa.konexioaItxi();
	}
		
}
