package model;

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
	public Podcast(String titulua, int iraupena, String kolaboratzaile) {
		super(titulua, iraupena);
		this.kolaboratzaile = kolaboratzaile;
	}

	public String getKolaboratzaile() {
		return kolaboratzaile;
	}

	public void setKolaboratzaile(String kolaboratzaile) {
		this.kolaboratzaile = kolaboratzaile;
	}
	
	

}