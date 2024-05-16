package model.sql.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Abestia;
import model.Artista;
import model.Musikaria;
import model.Playlist;
import model.Podcast;
import model.sql.Konexioa;

public class EstatistikakDAO {
	public static ArrayList<Abestia> getTopGustukoAbestiakStats(String estatistikaMota) throws SQLException {
		Konexioa.konexioaIreki();
		ArrayList<Abestia> abestiList = new ArrayList<Abestia>();
		String SQLquery = "SELECT a.IdAudio, Izena, Iraupena, et.GustokoAbestiak FROM audio a, estatistikak" + estatistikaMota + " et WHERE a.IdAudio = et.IdAudio AND Mota = \"Abestia\" ORDER BY GustokoAbestiak desc;";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		Abestia abestiAux = null;

		while (emaitza.next()) {
			abestiAux = new Abestia(emaitza.getString("a.IdAudio"), emaitza.getString("Izena"), emaitza.getString("Iraupena"), emaitza.getInt("et.GustokoAbestiak"));
			abestiList.add(abestiAux);
		}
		Konexioa.konexioaItxi();
		return abestiList;
	}
	
	public static ArrayList<Abestia> getTopGustukoPodcastStats(String estatistikaMota) throws SQLException {
		Konexioa.konexioaIreki();
		ArrayList<Abestia> podcastList = new ArrayList<Abestia>();
		String SQLquery = "SELECT a.IdAudio, Izena, Iraupena, et.GustokoPodcast FROM audio a, estatistikak" + estatistikaMota + " et WHERE a.IdAudio = et.IdAudio AND Mota = \"Podcasta\" ORDER BY GustokoPodcast desc;";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		Abestia podcastAux = null;

		while (emaitza.next()) {
			podcastAux = new Abestia(emaitza.getString("a.IdAudio"), emaitza.getString("Izena"), emaitza.getString("Iraupena"), emaitza.getInt("et.GustokoPodcast"));
			podcastList.add(podcastAux);
		}
		Konexioa.konexioaItxi();
		return podcastList;
	}
	
	public static ArrayList<Abestia> getTopEntzunaldiakStats(String estatistikaMota) throws SQLException {
		Konexioa.konexioaIreki();
		ArrayList<Abestia> audioList = new ArrayList<Abestia>();
		String SQLquery = "SELECT a.IdAudio, Izena, Iraupena, et.TopEntzundakoak FROM audio a, estatistikak" + estatistikaMota + " et WHERE a.IdAudio = et.IdAudio ORDER BY TopEntzundakoak desc;";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		Abestia audioAux = null;

		while (emaitza.next()) {
			audioAux = new Abestia(emaitza.getString("a.IdAudio"), emaitza.getString("Izena"), emaitza.getString("Iraupena"), emaitza.getInt("et.TopEntzundakoak"));
			audioList.add(audioAux);
		}
		Konexioa.konexioaItxi();
		return audioList;
	}
	
	public static ArrayList<Playlist> getTotalaTopPlaylistStats() throws SQLException {
		Konexioa.konexioaIreki();
		ArrayList<Playlist> playlist = new ArrayList<Playlist>();
		String SQLquery = "SELECT * FROM playlistAbestiKop ORDER BY Kopurua desc;";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		Playlist playlistAux = null;

		while (emaitza.next()) {
			playlistAux = new Playlist(emaitza.getInt("IDList"), emaitza.getString("Izenburua"), emaitza.getInt("Kopurua"));
			playlist.add(playlistAux);
		}
		Konexioa.konexioaItxi();
		return playlist;
	}
}
