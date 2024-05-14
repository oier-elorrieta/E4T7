package model;

import java.sql.Blob;

/**
 * Podcaster klasea Artista klasetik sortutako azterketa klasea da. Podcaster-ek
 * izena eta erreprodukzio kopurua dituzten konstruktoreak dituzte.
 */
public class Podcaster extends Artista {

	/**
	 * Podcaster klasearen lehenengo konstruktorea.
	 * 
	 * @param izena           Podcaster-aren izena
	 * @param erreprodukzioak Podcaster-aren erreprodukzio kopurua
	 */
	public Podcaster(String izena, int erreprodukzioak) {
		super(izena, erreprodukzioak);
	}

	/**
	 * Podcaster klasearen bigarren konstruktorea.
	 * 
	 * @param deskribapena Podcaster-aren deskribapena
	 * @param irudia       Podcaster-aren irudia
	 */
	public Podcaster(String deskribapena, Blob irudia) {
		super(irudia, deskribapena);
	}

}
