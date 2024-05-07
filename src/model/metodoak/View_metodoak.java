package model.metodoak;

import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;

import model.Abestia;
import model.Album;
import model.Artista;
import model.Podcast;
import model.Podcaster;
import salbuespenak.DataBalidazioaException;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

public class View_metodoak {

	// BOTOIAK
	/**
	 * "Atzera" testua duen JButton bat sortu eta itzuli. Botoiak "SansSerifs"
	 * letra-tipoa du, estilo arrunta du eta tamaina 16 du. Botoia (24, 15)
	 * posizioan kokatuta dago, 110 pixel zabalera eta 37 pixel altuera du. Botoiak
	 * ez du fokua erakusten hautatzerakoan.
	 *
	 * @return sortutako JButton-a
	 */
	public static JButton btn_Atzera() {
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("SansSerifs", Font.PLAIN, 16));
		btnAtzera.setBounds(24, 15, 110, 37);
		btnAtzera.setFocusPainted(false);

		return btnAtzera;
	}

	/**
	 * Metodo honek "Nire profila" botoia sortzen du.
	 *
	 * @return "Nire profila" botoia
	 */
	public static JButton btn_NireProfila() {
		JButton btnNireProfila = new JButton("Nire profila");
		btnNireProfila.setBackground(Color.WHITE);
		btnNireProfila.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnNireProfila.setBounds(730, 49, 115, 27);
		btnNireProfila.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNireProfila.setFocusPainted(false);

		return btnNireProfila;
	}

	/**
	 * Hurrengo abestia erreproduzitzen du, uneko abestia geldiarazita eta hurrengoa
	 * erreproduzitzen.
	 * 
	 * @param clipHurrengoa Hurrengo abestiaren Clip objektua.
	 * @param clipLehena    Uneko abestiaren Clip objektua.
	 * @param fileAudio     Hurrengo abestiaren audio fitxategiaren bide-izena.
	 */
	public static void playHurrengoaAbestia(Clip clipHurrengoa, Clip clipLehena, String fileAudio) {
		File f = new File(fileAudio);
		AudioInputStream aui2;

		try {
			aui2 = AudioSystem.getAudioInputStream(f.getAbsoluteFile());
			clipHurrengoa = AudioSystem.getClip();
			clipHurrengoa.open(aui2);
		} catch (UnsupportedAudioFileException | IOException ew) {
			ew.printStackTrace();
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}

		if (clipLehena.isRunning()) {
			clipLehena.stop();
		}
		if (clipHurrengoa.isRunning()) {
			clipHurrengoa.stop();
		}
	}

	/**
	 * Balidatzen du emandako data formatua zuzena dela.
	 * 
	 * @param date balidatu nahi den data
	 * @throws DataBalidazioaException data formatua ez bada zuzena
	 */
	public static void dataBalidatu(String date) throws DataBalidazioaException {
		if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
			throw new DataBalidazioaException();
		}
	}

	/**
	 * Metodo honek baimendu bat salto egiteko erabiltzen da. Timer erabiliz, 10
	 * segundo pasatuta, skip_abestia aldagaia true-ra aldatzen du eta "skip" mezua
	 * inprimatzen du.
	 */
	public static void skipBaimendu() {

		Timer timer = new Timer();

		TimerTask task = new TimerTask() {
			public void run() {
				SesioAldagaiak.skip_abestia = true;
				System.out.println("skip");
			}
		};

		timer.schedule(task, 10000);
	}

	/**
	 * Bihurtzen du emandako data String formatuan.
	 *
	 * @param dataAldatzeko bihurtu nahi den data.
	 * @return Data String formatuan.
	 */
	@SuppressWarnings("deprecation")
	public static String dateToString(Date dataAldatzeko) {

		if (dataAldatzeko.getMonth() >= 0 && dataAldatzeko.getMonth() <= 9) {
			int intdataMonth = dataAldatzeko.getMonth();
			String StrdataMonth = "0" + intdataMonth;
			int dataMonthondo = Integer.parseInt(StrdataMonth);
			Date data = new Date(dataAldatzeko.getYear(), dataMonthondo, dataAldatzeko.getDay());
			DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
			String strDate = dateFormat.format(data);
			return strDate;
		} else {
			Date data = new Date(dataAldatzeko.getYear(), dataAldatzeko.getMonth(), dataAldatzeko.getDay());
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
			String strDate = dateFormat.format(data);
			return strDate;
		}
	}

	/**
	 * String errepresentazio bat duen data Date objektu bihurtzen du.
	 *
	 * @param data dataren string errepresentazioa
	 * @return emandako dataren Date objektua
	 * @throws ParseException string-a ezin bada datu zuzen gisa parseatu
	 */
	public static Date stringToDate(String data) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

		Date date = formatter.parse(data);
		return date;
	}

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
}
