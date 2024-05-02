package model;

import java.sql.Blob;

/**
 * Podcast klasea, Audio klasearen luzapena da. Podcast-ak titulua eta iraupena
 * ditu.
 */
public class Podcast extends Audio {

	private String kolaboratzaile;
	
	/**
	 * Podcast klasearen eraikitzailea.
	 * 
	 * @param titulua  podcast-aren titulua
	 * @param iraupena podcast-aren iraupena
	 */
	

	public Podcast(String titulua, Blob irudia, String iraupena, int erreprodukzioak, String kolaboratzaile) {
		super(titulua, irudia, iraupena);
		this.kolaboratzaile = kolaboratzaile;
	}
	
	
	public Podcast(String titulua, Blob irudia, String iraupena, String kolaboratzaile) {
		super(titulua, irudia, iraupena);
		this.kolaboratzaile = kolaboratzaile;
	}

	/*public Podcast(String titulua, String iraupena, int erreprodukzioak) {
		super(titulua, iraupena, erreprodukzioak);
	}
*/


	public String getKolaboratzaile() {
		return kolaboratzaile;
	}

	public void setKolaboratzaile(String kolaboratzaile) {
		this.kolaboratzaile = kolaboratzaile;
	}
	
	

}