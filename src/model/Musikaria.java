package model;

import java.sql.Blob;

/**
 * Musikaria klasea, Artista klasearen luzapena da. Musikariak musika sortzen
 * duen artista da.
 */
public class Musikaria extends Artista {

	/**
	 * Musikaria klasearen eraikitzailea izena eta erreprodukzio kopuruarekin.
	 * 
	 * @param izena           Musikariaren izena
	 * @param erreprodukzioak Musikariak egin dituen erreprodukzio kopurua
	 */
	public Musikaria(String izena, int erreprodukzioak) {
		super(izena, erreprodukzioak);
	}

	/**
	 * Musikaria klasearen eraikitzailea irudia eta deskribapenarekin.
	 * 
	 * @param irudia       Musikariaren irudia
	 * @param deskribapena Musikariaren deskribapena
	 */
	public Musikaria(Blob irudia, String deskribapena) {
		super(irudia, deskribapena);
	}

	/**
	 * Musikaria klasearen eraikitzailea izena baino.
	 * 
	 * @param izena Musikariaren izena
	 */
	public Musikaria(String izena) {
		super(izena);
	}
}
