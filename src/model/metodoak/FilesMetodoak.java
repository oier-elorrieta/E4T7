package model.metodoak;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import model.Abestia;
import model.Album;
import model.Artista;
import model.Playlist;
import model.Podcast;

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
	
	public static void exportatuPlaylistFiles(Playlist playlist) throws IOException {
		Date dataOrain = new Date();
		String rutaArchivo = "SharedPlaylist_" + playlist.getTitulua() + "_" + dataOrain.getTime() + ".txt";
		File archivo = new File(rutaArchivo);
		FileWriter write = new FileWriter(archivo);
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
		bufferedWriter.close();
	}

	public static void abestiaKonpartitu(Playlist playlist, Abestia abestia, Album album, Artista artista) {
		
		
	}
}
