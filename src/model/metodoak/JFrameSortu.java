package model.metodoak;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import model.Abestia;
import model.Album;
import model.Artista;
import model.Playlist;
import model.Podcast;
import salbuespenak.AudioaNotFoundExcepcion;
import view.ErregistroaNireProfilaV;
import view.LoginV;
import view.MenuaV;
import view.abestiak.ArtistaListV;
import view.abestiak.AlbumListV;
import view.abestiak.KantaListV;
import view.admin.AdminMenuaV;
import view.admin.estatistikak.AdminEstatistikakMenuaV;
import view.admin.estatistikak.TopEntzundakoakStatsV;
import view.admin.estatistikak.TopGustukoAbestiakStatsV;
import view.admin.estatistikak.TopGustukoPodcastStatsV;
import view.admin.estatistikak.TopPlayListStatsV;
import view.admin.musikaKudeatu.AdminAbestiakKudeatuV;
import view.admin.musikaKudeatu.AdminAlbumakKudeatuV;
import view.admin.musikaKudeatu.AdminArtistakKudeatuV;
import view.admin.musikaKudeatu.AdminMusikaKudeatuV;
import view.admin.podcastKudeatu.AdminMenuaPodcastKudeatuV;
import view.admin.podcastKudeatu.AdminPodcastKudeatuV;
import view.admin.podcastKudeatu.AdminPodcasterKudeatuV;
import view.erreprodukzioa.ErreprodukzioaPlaylistAbestiakV;
import view.erreprodukzioa.ErreprodukzioaPodcastV;
import view.erreprodukzioa.ErreprodukzioaV;
import view.erreprodukzioa.IragarkiLehioaPlaylistV;
import view.erreprodukzioa.IragarkiLehioaV;
import view.erreprodukzioa.MenuAukeraErreprodukzioV;
import view.erreprodukzioa.MenuaPlaylistSartuAbestiakV;
import view.playlist.MenuaPlaylistAbestiakV;
import view.playlist.PlayListBerriaSortuV;
import view.playlist.PlaylistAbestiakV;
import view.playlist.PlaylistListV;
import view.podcast.PodcasterListV;
import view.podcast.PodcasterV;


/**
 * JFrameSortu klasea, JFrame-ak sortzeko metodoak dituen klasea.
 */
public class JFrameSortu {
	/**
	 * Login menua sortzeko metodoa.
	 */
	public static void loginMenua() {
		LoginV loginMenu = new LoginV();
		loginMenu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		loginMenu.setVisible(true);
	}

	/**
	 * Erregistro menua sortzeko metodoa.
	 * 
	 * @throws SQLException
	 */
	public static void erregistroMenua(JFrame jframe) throws SQLException {
		ErregistroaNireProfilaV erregistroMenu = new ErregistroaNireProfilaV(jframe);
		erregistroMenu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		erregistroMenu.setVisible(true);
	}

	/**
	 * Bezeroaren menua sortzeko metodoa.
	 * @param jframe 
	 */
	public static void menuaBezeroa(JFrame jframe) {
		MenuaV menuaAtera = new MenuaV(jframe);
		menuaAtera.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		menuaAtera.setVisible(true);
	}

	/**
	 * Bezeroaren musika deskubritzeko metodoa.
	 * 
	 * @throws SQLException
	 */
	public static void musikaDeskubrituBezeroa() throws SQLException {
		ArtistaListV musikaDesk = new ArtistaListV();
		musikaDesk.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		musikaDesk.setVisible(true);
	}

	/**
	 * Bezeroaren podcast deskubritzeko metodoa.
	 * 
	 * @throws SQLException
	 */
	public static void podcastDeskubrituBezeroa() throws SQLException {
		PodcasterListV podcasterList = new PodcasterListV();
		podcasterList.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		podcasterList.setVisible(true);
	}

	/**
	 * Bezeroaren albumak eta artistak ikusteko metodoa.
	 * 
	 * @param album
	 * @param artista
	 * @throws SQLException
	 */
	public static void albumakArtistakBezeroa(Album album, Artista artista) throws SQLException {
		AlbumListV artistaAlbumV = new AlbumListV(artista);
		artistaAlbumV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		artistaAlbumV.setVisible(true);
	}

	/**
	 * Bezeroaren podcast-ak ikusteko metodoa.
	 * 
	 * @param podcaster
	 * @throws SQLException
	 */
	public static void podcastPodcasterBezeroa(Artista podcaster) throws SQLException {
		PodcasterV podcasterPodcastV = new PodcasterV(podcaster);
		podcasterPodcastV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		podcasterPodcastV.setVisible(true);
	}

	/**
	 * Bezeroaren kantak ikusteko metodoa.
	 * 
	 * @param podcaster
	 * @throws SQLException
	 */
	public static void podcastKantakBezeroa(Artista podcaster) throws SQLException {
		PodcasterV podcasterPodcastV = new PodcasterV(podcaster);
		podcasterPodcastV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		podcasterPodcastV.setVisible(true);
	}

	/**
	 * Bezeroaren albumaren kantak ikusteko metodoa.
	 * 
	 * @param album
	 * @param artista
	 * @throws SQLException
	 */
	public static void albumKantakBezeroa(Album album, Artista artista) throws SQLException {
		KantaListV kantaArtistaV = new KantaListV(album, artista);
		kantaArtistaV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		kantaArtistaV.setVisible(true);
	}

	/**
	 * Bezeroaren playlist-ak ikusteko metodoa.
	 * @throws SQLException 
	 */
	public static void playlistListaBezeroa() throws SQLException {
		PlaylistListV PlaylistListV = new PlaylistListV();
		PlaylistListV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		PlaylistListV.setVisible(true);
	}

	/**
	 * Bezeroaren erreprodukzio menua sortzeko metodoa.
	 * 
	 * @param album
	 * @param artista
	 * @param abesti
	 */
	public static void menuErreprodukzioaAbestiakBezeroa(Album album, Artista artista, Abestia abesti) {
		MenuAukeraErreprodukzioV ErreprodukzioaMenuaV = new MenuAukeraErreprodukzioV(album, artista, abesti);
		ErreprodukzioaMenuaV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		ErreprodukzioaMenuaV.setVisible(true);
	}

	/**
	 * Bezeroaren abestiak playlist-ean sartzeko metodoa.
	 * 
	 * @param album
	 * @param artista
	 * @param abesti
	 * @throws SQLException
	 */
	public static void PlaylisteanSartuBezeroa(Album album, Artista artista, Abestia abesti) throws SQLException {
		MenuaPlaylistSartuAbestiakV PlaylistSartuMenuaV = new MenuaPlaylistSartuAbestiakV(album, artista, abesti);
		PlaylistSartuMenuaV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		PlaylistSartuMenuaV.setVisible(true);
	}

	/**
	 * Bezeroaren erreprodukzio lehioa sortzeko metodoa.
	 * 
	 * @param album
	 * @param artista
	 * @param abesti
	 * @throws SQLException
	 * @throws LineUnavailableException
	 * @throws AudioaNotFoundExcepcion 
	 * @throws IOException 
	 */
	public static void erreprodukzioLehioa(Album album, Artista artista, Abestia abesti)
			throws SQLException, LineUnavailableException, AudioaNotFoundExcepcion, IOException {
		ErreprodukzioaV ErreprodukzioaV = new ErreprodukzioaV(album, artista, abesti);
		ErreprodukzioaV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		ErreprodukzioaV.setVisible(true);
	}

	/**
	 * Bezeroaren iragarki lehioa sortzeko metodoa.
	 * 
	 * @param album
	 * @param artista
	 * @param abesti
	 * @throws SQLException
	 */
	public static void iragarkiLehioa(Album album, Artista artista, Abestia abesti) throws SQLException {
		IragarkiLehioaV IragarkiLehioaV = new IragarkiLehioaV(album, artista, abesti);
		IragarkiLehioaV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		IragarkiLehioaV.setVisible(true);
	}

	public static void iragarkiLehioaPlaylist(ArrayList<Abestia> abestiLista, Playlist playlist, Artista artista, Album album, int index) throws SQLException {
		IragarkiLehioaPlaylistV IragarkiLehioaPlaylistV = new IragarkiLehioaPlaylistV(abestiLista, playlist, artista, album, index);
		IragarkiLehioaPlaylistV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		IragarkiLehioaPlaylistV.setVisible(true);
	}
	
	public static void statsTopGustukoAbestiak() {
		TopGustukoAbestiakStatsV TopGustukoAbestiakStatsV = new TopGustukoAbestiakStatsV();
		TopGustukoAbestiakStatsV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		TopGustukoAbestiakStatsV.setVisible(true);
	}
	
	public static void statsTopGustukoPodcast() {
		TopGustukoPodcastStatsV TopGustukoPodcastStatsV = new TopGustukoPodcastStatsV();
		TopGustukoPodcastStatsV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		TopGustukoPodcastStatsV.setVisible(true);
	}
	
	public static void statsTopEntzundakoak() {
		TopEntzundakoakStatsV TopEntzundakoakStatsV = new TopEntzundakoakStatsV();
		TopEntzundakoakStatsV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		TopEntzundakoakStatsV.setVisible(true);
	}
	
	public static void statsTopPlayList() {
		TopPlayListStatsV TopPlayListStatsV = new TopPlayListStatsV();
		TopPlayListStatsV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		TopPlayListStatsV.setVisible(true);
	}
	
	public static void erreprodukzioLehioaPodcast(Artista podcaster, Podcast podcast)
			throws SQLException, LineUnavailableException, AudioaNotFoundExcepcion {
		ErreprodukzioaPodcastV ErreprodukzioaPodcastV = new ErreprodukzioaPodcastV(podcaster, podcast);
		ErreprodukzioaPodcastV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		ErreprodukzioaPodcastV.setVisible(true);
	}

	public static void playListBerriaSortu() {
		PlayListBerriaSortuV playListBerriaSortuV = new PlayListBerriaSortuV();
        playListBerriaSortuV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        playListBerriaSortuV.setVisible(true);
	}
	
	public static void playListAbestiak(Playlist playlist) throws SQLException {
		PlaylistAbestiakV PlaylistAbestiakV = new PlaylistAbestiakV(playlist);
		PlaylistAbestiakV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		PlaylistAbestiakV.setVisible(true);
	}

	public static void adminMenua() {
		AdminMenuaV adminMenua = new AdminMenuaV();
        adminMenua.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        adminMenua.setVisible(true);
	}
	
	public static void adminEstatistikakMenua() {
		AdminEstatistikakMenuaV estatistikakAdminMenua = new AdminEstatistikakMenuaV();
		estatistikakAdminMenua.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		estatistikakAdminMenua.setVisible(true);
	}
	
	public static void adminMusikaKudeatu() {
		AdminMusikaKudeatuV adminMusikaKudeatu = new AdminMusikaKudeatuV();
		adminMusikaKudeatu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		adminMusikaKudeatu.setVisible(true);
	}
	
	public static void adminArtistakKudeatu() throws SQLException {
		AdminArtistakKudeatuV adminArtistakKudeatu = new AdminArtistakKudeatuV();
		adminArtistakKudeatu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		adminArtistakKudeatu.setVisible(true);
	}
	
	public static void adminAlbumakKudeatu() throws SQLException {
		AdminAlbumakKudeatuV adminAlbumakKudeatu = new AdminAlbumakKudeatuV();
		adminAlbumakKudeatu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		adminAlbumakKudeatu.setVisible(true);
	}
	
	public static void adminAbestiakKudeatu() throws SQLException {
		AdminAbestiakKudeatuV adminAbestiakKudeatu = new AdminAbestiakKudeatuV();
		adminAbestiakKudeatu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		adminAbestiakKudeatu.setVisible(true);
	}

	public static void menuaPlaylistAbestiak(Playlist playlist, Abestia abestia, Album album, Artista artista, JFrame PlaylistAbestiakV) {
		MenuaPlaylistAbestiakV menuaPlaylistAbestiakV = new MenuaPlaylistAbestiakV(playlist, abestia, album, artista, PlaylistAbestiakV);
		menuaPlaylistAbestiakV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		menuaPlaylistAbestiakV.setVisible(true);
	}
	
	public static void erreprodukzioaPlaylistAbestiak(ArrayList<Abestia> abestiLista, Playlist playlist, Artista artista, int indexAbesti, Album album) throws SQLException {
		ErreprodukzioaPlaylistAbestiakV erreprodukzioaPAbestiakV = new ErreprodukzioaPlaylistAbestiakV(abestiLista, playlist, artista, album, indexAbesti);
		erreprodukzioaPAbestiakV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		erreprodukzioaPAbestiakV.setVisible(true);
	}
	
	public static void adminMenuaPodcastKudeatu() {
		AdminMenuaPodcastKudeatuV AdminMenuaPodcastKudeatuV = new AdminMenuaPodcastKudeatuV();
		AdminMenuaPodcastKudeatuV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		AdminMenuaPodcastKudeatuV.setVisible(true);
	}
	
	public static void adminPodcasterKudeatu() throws SQLException {
		AdminPodcasterKudeatuV adminPodcasterKudeatuV = new AdminPodcasterKudeatuV();
		adminPodcasterKudeatuV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		adminPodcasterKudeatuV.setVisible(true);
	}
	
	public static void adminPodcastKudeatu() throws SQLException {
		AdminPodcastKudeatuV adminPodcastKudeatuV = new AdminPodcastKudeatuV();
		adminPodcastKudeatuV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		adminPodcastKudeatuV.setVisible(true);
	}
}
