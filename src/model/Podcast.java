package model;

import java.sql.Blob;

/**
 * Podcast klasea, Audio klasearen luzapena da. Podcast-ak titulua eta iraupena
 * ditu.
 */
/**
 * Podcast klasea, Audio klasea heredatzen duena. Podcast-ak titulua, irudia,
 * iraupena eta kolaboratzailea ditu.
 */
public class Podcast extends Audio {

	private String kolaboratzaile;

	/**
	 * Podcast klasearen eraikitzailea.
	 * 
	 * @param titulua         podcast-aren titulua
	 * @param irudia          podcast-aren irudia
	 * @param iraupena        podcast-aren iraupena
	 * @param erreprodukzioak podcast-aren erreprodukzio kopurua
	 * @param kolaboratzaile  podcast-aren kolaboratzailea
	 */
	public Podcast(String titulua, Blob irudia, String iraupena, int erreprodukzioak, String kolaboratzaile) {
		super(titulua, irudia, iraupena);
		this.kolaboratzaile = kolaboratzaile;
	}

	/**
	 * Podcast klasearen eraikitzailea.
	 * 
	 * @param titulua        podcast-aren titulua
	 * @param irudia         podcast-aren irudia
	 * @param iraupena       podcast-aren iraupena
	 * @param kolaboratzaile podcast-aren kolaboratzailea
	 */
	
	public Podcast(String titulua, Blob irudia, String iraupena, String kolaboratzaile) {
		super(titulua, irudia, iraupena);
		this.kolaboratzaile = kolaboratzaile;
	}
	
	public Podcast(String titulua, String kolaboratzaile) {
		super(titulua);
		this.kolaboratzaile = kolaboratzaile;
	}

	/**
	 * Kolaboratzailea itzultzen du.
	 * 
	 * @return podcast-aren kolaboratzailea
	 */
	public String getKolaboratzaile() {
		return kolaboratzaile;
	}

	/**
	 * Kolaboratzailea ezartzen du.
	 * 
	 * @param kolaboratzaile podcast-aren kolaboratzailea
	 */
	public void setKolaboratzaile(String kolaboratzaile) {
		this.kolaboratzaile = kolaboratzaile;
	}
}