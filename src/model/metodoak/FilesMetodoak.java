package model.metodoak;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Abestia;
import model.Album;
import model.Artista;
import model.Erabiltzailea;
import model.Musikaria;
import model.Playlist;
import model.Podcast;
import model.sql.PlayListDAO;
import model.sql.PlaylistAbestiakDAO;

public class FilesMetodoak {
	/**
	 * Metodo honek Abestia, Album eta Artista objektuak hartuz, testu fitxategi bat
	 * sortzen du. Fitxategian abestia, albuma eta artistaaren informazioa idatzi
	 * egiten da. Fitxategiaren izena "SharedSong_" eta uneko dataren timestamp-a
	 * erabiliz sortzen da.
	 * 
	 * @param abesti  Abestia objektua
	 * @param album   Album objektua
	 * @param artista Artista objektua
	 * @throws IOException Sarrera/irteera erroreak gertatzen badira
	 */
	public static void konpartituFilesAbestiak(Abestia abesti, Album album, Artista artista) throws IOException {
		Date dataOrain = new Date();
		String rutaArchivo = "SharedSong_" + dataOrain.getTime() + ".txt";
		File archivo = new File(rutaArchivo);
		FileWriter write = new FileWriter(archivo);
		BufferedWriter bufferedWriter = new BufferedWriter(write);

		bufferedWriter.write("ABESTIAREN INFORMAZIOA");
		bufferedWriter.newLine();
		bufferedWriter.write("----------------------------------");
		bufferedWriter.newLine();
		bufferedWriter.write("Abestia: " + abesti.getTitulua());
		bufferedWriter.newLine();
		bufferedWriter.write("Artista: " + artista.getIzena());
		bufferedWriter.newLine();
		bufferedWriter.write("Albuma: " + album.getIzenburua());
		bufferedWriter.newLine();
		bufferedWriter.write("Iraupena: " + abesti.getIraupena());
		bufferedWriter.newLine();
		bufferedWriter.write("Album urtea: " + album.getUrtea());
		bufferedWriter.newLine();
		bufferedWriter.write("------------------------------------------------------------------------------");
		bufferedWriter.newLine();
		bufferedWriter.write("BEZEROAREN INFORMAZIOA");
		bufferedWriter.newLine();
		bufferedWriter.write("----------------------------------");
		bufferedWriter.newLine();
		bufferedWriter.write("Bezeroa izen-abizenak: " + SesioAldagaiak.bezeroa_logeatuta.getIzena() + " "
				+ SesioAldagaiak.bezeroa_logeatuta.getAbizena());
		bufferedWriter.newLine();
		bufferedWriter.write("Erabiltzailea: " + SesioAldagaiak.bezeroa_logeatuta.getErabiltzailea());
		bufferedWriter.newLine();
		bufferedWriter.write("----------------------------------");
		bufferedWriter.close();
	}

	/**
	 * Metodo honek podcastaren eta podcaster-en informazioa fitxategi batean
	 * konpartitzen du. Fitxategi berri bat sortzen du, eta bertan podcastaren eta
	 * podcaster-en datuak idatziak dira. Fitxategiaren izena "SharedPodcast_" eta
	 * uneko dataren timestamp-a da.
	 * 
	 * @param podcast   Podcast objektua, podcastaren datuak gordetzeko erabiltzen
	 *                  dena.
	 * @param podcaster Artista objektua, podcaster-en datuak gordetzeko erabiltzen
	 *                  dena.
	 * @throws IOException Fitxategiaren idazketa errore bat gertatzen bada.
	 */
	public static void konpartituFilesPodcast(Podcast podcast, Artista podcaster) throws IOException {
		Date dataOrain = new Date();
		String rutaArchivo = "SharedPodcast_" + dataOrain.getTime() + ".txt";
		File archivo = new File(rutaArchivo);
		FileWriter write = new FileWriter(archivo);
		BufferedWriter bufferedWriter = new BufferedWriter(write);

		bufferedWriter.write("PODCASTAREN INFORMAZIOA");
		bufferedWriter.newLine();
		bufferedWriter.write("----------------------------------");
		bufferedWriter.newLine();
		bufferedWriter.write("Podcast: " + podcast.getTitulua());
		bufferedWriter.newLine();
		bufferedWriter.write("Artista(k): " + podcaster.getIzena() + " / " + podcast.getKolaboratzaile());
		bufferedWriter.newLine();
		bufferedWriter.write("Iraupena: " + podcast.getIraupena());
		bufferedWriter.newLine();
		bufferedWriter.write("------------------------------------------------------------------------------");
		bufferedWriter.newLine();
		bufferedWriter.write("BEZEROAREN INFORMAZIOA");
		bufferedWriter.newLine();
		bufferedWriter.write("----------------------------------");
		bufferedWriter.newLine();
		bufferedWriter.write("Bezeroa izen-abizenak: " + SesioAldagaiak.bezeroa_logeatuta.getIzena() + " "
				+ SesioAldagaiak.bezeroa_logeatuta.getAbizena());
		bufferedWriter.newLine();
		bufferedWriter.write("Erabiltzailea: " + SesioAldagaiak.bezeroa_logeatuta.getErabiltzailea());
		bufferedWriter.newLine();
		bufferedWriter.write("----------------------------------");
		bufferedWriter.close();
	}
	
	public static void exportatuPlaylistFiles(Playlist playlist) throws IOException, SQLException {
		Date dataOrain = new Date();
		String rutaArchivo = "SharedPlaylist_" + playlist.getTitulua() + "_" + dataOrain.getTime() + ".txt";
		File archivo = new File(rutaArchivo);
		FileWriter write = new FileWriter(archivo);
		
		ArrayList<Abestia> abestiakPlaylist = PlaylistAbestiakDAO.abestiakPlaylistKargatu(playlist);
		ArrayList<Album> albumakPlaylist = PlaylistAbestiakDAO.albumAbestiakPlaylistKargatu(playlist);
		ArrayList<Artista> artistakPlaylist = PlaylistAbestiakDAO.abestiakArtistakPlaylistKargatu(playlist);
		
		BufferedWriter bufferedWriter = new BufferedWriter(write);

		bufferedWriter.write("PLAYLIST-AREN INFORMAZIOA");
		bufferedWriter.newLine();
		bufferedWriter.write("----------------------------------");
		bufferedWriter.newLine();
		bufferedWriter.write("Playlist izena: " + playlist.getTitulua());
		bufferedWriter.newLine();
		bufferedWriter.write("Playlist sorrera data: " + playlist.getSorrera_data());
		bufferedWriter.newLine();
		bufferedWriter.write("Kapazitatea: " + playlist.getKapazitatea() + " abesti.");
		bufferedWriter.newLine();
		bufferedWriter.write("------------------------------------------------------------------------------");
		bufferedWriter.newLine();
		bufferedWriter.write("BEZEROAREN INFORMAZIOA");
		bufferedWriter.newLine();
		bufferedWriter.write("----------------------------------");
		bufferedWriter.newLine();
		bufferedWriter.write("Bezeroa izen-abizenak: " + SesioAldagaiak.bezeroa_logeatuta.getIzena() + " "
				+ SesioAldagaiak.bezeroa_logeatuta.getAbizena());
		bufferedWriter.newLine();
		bufferedWriter.write("Erabiltzailea: " + SesioAldagaiak.bezeroa_logeatuta.getErabiltzailea());
		bufferedWriter.newLine();
		bufferedWriter.write("----------------------------------");
		bufferedWriter.newLine();
		bufferedWriter.write("ABESTIAK PLAYLIST-AN");
		bufferedWriter.newLine();
		bufferedWriter.close();
		
		for (int i = 0; i < abestiakPlaylist.size(); i++) {
			Abestia abestia = abestiakPlaylist.get(i);
			Album album = albumakPlaylist.get(i);
			Artista artista = artistakPlaylist.get(i);
			write = new FileWriter(archivo, true);
			bufferedWriter = new BufferedWriter(write);
			bufferedWriter.newLine();
			bufferedWriter.write("Abestia: " + abestia.getTitulua());
			bufferedWriter.newLine();
			bufferedWriter.write("Artista: " + artista.getIzena());
			bufferedWriter.newLine();
			bufferedWriter.write("Albuma: " + album.getIzenburua());
			bufferedWriter.newLine();
			bufferedWriter.write("Iraupena: " + abestia.getIraupena());
			bufferedWriter.newLine();
			bufferedWriter.write("------------------------------------------------------------------------------");
			bufferedWriter.newLine();
			bufferedWriter.close();
		}
	}
	
	public static void exportatuGustokoaPlaylistFiles() throws IOException, SQLException {
		Date dataOrain = new Date();
		String rutaArchivo = "SharedPlaylist_GustokoenZerrenda_" + dataOrain.getTime() + ".txt";
		File archivo = new File(rutaArchivo);
		FileWriter write = new FileWriter(archivo);
		Playlist playlist = new Playlist("Gustokoen zerrenda");
		
		ArrayList<Abestia> abestiakPlaylist = PlaylistAbestiakDAO.gustukoAbestiakKargatu(playlist);
		ArrayList<Album> albumakPlaylist = PlaylistAbestiakDAO.gustukoAlbumAbestiakKargatu(playlist);
		ArrayList<Artista> artistakPlaylist = PlaylistAbestiakDAO.gustukoArtistaAbestiakKargatu(playlist);
		
		BufferedWriter bufferedWriter = new BufferedWriter(write);

		bufferedWriter.write("PLAYLIST-AREN INFORMAZIOA");
		bufferedWriter.newLine();
		bufferedWriter.write("----------------------------------");
		bufferedWriter.newLine();
		bufferedWriter.write("Playlist izena: Gustokoen zerrenda");
		bufferedWriter.newLine();
		bufferedWriter.write("Kapazitatea: " + PlayListDAO.gustokoAbestiKantitatea() + " abesti.");
		bufferedWriter.newLine();
		bufferedWriter.write("------------------------------------------------------------------------------");
		bufferedWriter.newLine();
		bufferedWriter.write("BEZEROAREN INFORMAZIOA");
		bufferedWriter.newLine();
		bufferedWriter.write("----------------------------------");
		bufferedWriter.newLine();
		bufferedWriter.write("Bezeroa izen-abizenak: " + SesioAldagaiak.bezeroa_logeatuta.getIzena() + " "
				+ SesioAldagaiak.bezeroa_logeatuta.getAbizena());
		bufferedWriter.newLine();
		bufferedWriter.write("Erabiltzailea: " + SesioAldagaiak.bezeroa_logeatuta.getErabiltzailea());
		bufferedWriter.newLine();
		bufferedWriter.write("----------------------------------");
		bufferedWriter.newLine();
		bufferedWriter.write("ABESTIAK PLAYLIST-AN");
		bufferedWriter.newLine();
		bufferedWriter.close();
		
		for (int i = 0; i < abestiakPlaylist.size(); i++) {
			Abestia abestia = abestiakPlaylist.get(i);
			Album album = albumakPlaylist.get(i);
			Artista artista = artistakPlaylist.get(i);
			write = new FileWriter(archivo, true);
			bufferedWriter = new BufferedWriter(write);
			bufferedWriter.newLine();
			bufferedWriter.write("Abestia: " + abestia.getTitulua());
			bufferedWriter.newLine();
			bufferedWriter.write("Artista: " + artista.getIzena());
			bufferedWriter.newLine();
			bufferedWriter.write("Albuma: " + album.getIzenburua());
			bufferedWriter.newLine();
			bufferedWriter.write("Iraupena: " + abestia.getIraupena());
			bufferedWriter.newLine();
			bufferedWriter.write("------------------------------------------------------------------------------");
			bufferedWriter.newLine();
			bufferedWriter.close();
		}
	}

	public static void abestiaKonpartituPlaylist(Playlist playlist, Abestia abestia, Album album, Artista artista) throws IOException {
		Date dataOrain = new Date();
		String rutaArchivo = "SharedPlaylistSong_" + dataOrain.getTime() + ".txt";
		File archivo = new File(rutaArchivo);
		FileWriter write = new FileWriter(archivo);
		BufferedWriter bufferedWriter = new BufferedWriter(write);

		bufferedWriter.write("PLAYLIST-AREN INFORMAZIOA");
		bufferedWriter.newLine();
		bufferedWriter.write("----------------------------------");
		bufferedWriter.newLine();
		bufferedWriter.write("Playlist izena: " + playlist.getTitulua());
		bufferedWriter.newLine();
		bufferedWriter.write("----------------------------------");
		bufferedWriter.newLine();
		bufferedWriter.write("ABESTIAREN INFORMAZIOA");
		bufferedWriter.newLine();
		bufferedWriter.write("Abestia: " + abestia.getTitulua());
		bufferedWriter.newLine();
		bufferedWriter.write("Artista: " + artista.getIzena());
		bufferedWriter.newLine();
		bufferedWriter.write("Albuma: " + album.getIzenburua());
		bufferedWriter.newLine();
		bufferedWriter.write("Iraupena: " + abestia.getIraupena());
		bufferedWriter.newLine();
		bufferedWriter.write("------------------------------------------------------------------------------");
		bufferedWriter.newLine();
		bufferedWriter.write("BEZEROAREN INFORMAZIOA");
		bufferedWriter.newLine();
		bufferedWriter.write("----------------------------------");
		bufferedWriter.newLine();
		bufferedWriter.write("Bezeroa izen-abizenak: " + SesioAldagaiak.bezeroa_logeatuta.getIzena() + " "
				+ SesioAldagaiak.bezeroa_logeatuta.getAbizena());
		bufferedWriter.newLine();
		bufferedWriter.write("Erabiltzailea: " + SesioAldagaiak.bezeroa_logeatuta.getErabiltzailea());
		bufferedWriter.newLine();
		bufferedWriter.write("----------------------------------");
		bufferedWriter.newLine();
		bufferedWriter.close();
	}
	
	public static void inportatuPlaylist() throws SQLException, ParseException {
		String filePath = "playlistInport.txt";
		
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String listIzena = "";
            String sortze_data = "";
            String kapazitatea = "";
            String bezIzenAb = "";
            String erab = "";
            String abestia = "";
            String artista = "";
            String albuma = "";
            String iraupena = "";
            Artista artistaAux = null;
            Abestia abestiaAux;
            Album albumAux = null;
            ArrayList<Abestia> abestiak = null;
            
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Playlist izena:")) {
                    listIzena = "Playlist izena: " + line.substring(15).trim();
                } else if (line.startsWith("Playlist sorrera data:")) {
                    sortze_data = "Playlist sorrera data: " + line.substring(21).trim();
                } else if (line.startsWith("Kapazitatea:")) {
                    kapazitatea = "Kapazitatea: " + line.substring(12).trim();
                } else if (line.startsWith("Bezeroa izen-abizenak:")) {
                    bezIzenAb = "Bezeroa izen-abizenak: " + line.substring(21).trim();
                } else if (line.startsWith("Erabiltzailea:")) {
                    erab = "Erabiltzailea: " + line.substring(14).trim();
                } else if (line.startsWith("Abestia:")) {
                    abestia = "Abestia: " + line.substring(8).trim();
                } else if (line.startsWith("Artista:")) {
                    artista = "Artista: " + line.substring(9).trim();
                } else if (line.startsWith("Albuma:")) {
                    albuma = "Albuma: " + line.substring(8).trim();
                } else if (line.startsWith("Iraupena:")) {
                    iraupena =  "Iraupena: " + line.substring(10).trim();
                }
                abestiak = new ArrayList<>();
                abestiaAux = new Abestia();
                abestiaAux.setTitulua(abestia);
                abestiaAux.setIraupena(iraupena);
                abestiak.add(abestiaAux);
                artistaAux = new Musikaria();
                artistaAux.setIzena(artista);
                albumAux = new Album();
                albumAux.setIzenburua(albuma);
            }
            Playlist playlist = new Playlist();
            playlist.setTitulua(listIzena);
            playlist.setSorrera_data(View_metodoak.stringToDate(sortze_data));
            playlist.setKapazitatea(Integer.parseInt(kapazitatea));
            
            Erabiltzailea bezeroa = new Erabiltzailea();
            bezeroa.setIzena(bezIzenAb);
            bezeroa.setErabiltzailea(erab);
            
            PlayListDAO.playlistGordeInportatu(playlist, bezeroa);
            PlayListDAO.abestiakGordePlaylistInport(abestiak, artistaAux, albumAux);

        } catch (IOException e) {
        	JOptionPane.showMessageDialog(null, "Errorea fitxategia irakurtzean.");
            e.printStackTrace();
        }
	}
}
