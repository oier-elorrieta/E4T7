package model.metodoak;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.WindowConstants;

import model.Album;
import model.Artista;
import view.*;

public class JFrameSortu {
	
	// JFRAME-AK
	public static void loginMenua() {
		LoginV loginMenu = new LoginV();
		loginMenu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		loginMenu.setVisible(true);
    }
	public static void erregistroMenua() throws SQLException {
		ErregistroaV erregistroMenu = new ErregistroaV();
		erregistroMenu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		erregistroMenu.setVisible(true);
    }
	
	public static void menuaBezeroa() {
		MenuaV menuaAtera = new MenuaV();
		menuaAtera.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		menuaAtera.setVisible(true);
    }
	
	public static void musikaDeskubrituBezeroa() throws SQLException {
		ArtistaListV musikaDesk = new ArtistaListV();
		musikaDesk.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		musikaDesk.setVisible(true);
    }
	
	public static void podcastDeskubrituBezeroa() throws SQLException {
		PodcasterListV podcasterList = new PodcasterListV();
		podcasterList.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		podcasterList.setVisible(true);
    }
	
	public static void albumakArtistakBezeroa(Album album, Artista artista) throws SQLException {
		ArtistaV artistaAlbumV = new ArtistaV(artista);
		artistaAlbumV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		artistaAlbumV.setVisible(true);
    }
	
	public static void albumKantakBezeroa(Album album, Artista artista) throws SQLException {
		KantaListV kantaArtistaV = new KantaListV(album, artista);
		kantaArtistaV.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		kantaArtistaV.setVisible(true);
    }
}

