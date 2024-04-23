package model;

/**
 * Podcast klasea, Audio klasearen luzapena da. Podcast-ak titulua eta iraupena
 * ditu.
 */
public class Podcast extends Audio {

	/**
	 * Podcast klasearen eraikitzailea.
	 * 
	 * @param titulua  podcast-aren titulua
	 * @param iraupena podcast-aren iraupena
	 */
	public Podcast(String titulua, int iraupena) {
		super(titulua, iraupena);
	}

}