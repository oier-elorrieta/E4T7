package model;

import java.sql.Blob;

/**
 * Abestia klasea Audio klasearen luzapena da. Abestia klaseak musika
 * fitxategiak kudeatzeko funtzionalitateak eskaintzen ditu.
 */
public class Abestia extends Audio {

	/**
	 * Abestia klasearen eraikitzailea.
	 * 
	 * @param titulua  abestiaren titulua
	 * @param irudia   abestiaren irudia
	 * @param iraupena abestiaren iraupena
	 */
	public Abestia(String titulua, Blob irudia, String iraupena) {
		super(titulua, irudia, iraupena);
		System.out.println("1");
	}

	/**
	 * Abestia klasearen eraikitzailea.
	 * 
	 * @param idAudio         abestiaren identifikadorea
	 * @param titulua         abestiaren titulua
	 * @param iraupena        abestiaren iraupena
	 * @param erreprodukzioak abestiaren erreprodukzio kopurua
	 */
	public Abestia(String idAudio, String titulua, String iraupena, int erreprodukzioak) {
		super(idAudio, titulua, iraupena, erreprodukzioak);
		System.out.println("2");
	}

	/**
	 * Abestia klasearen eraikitzailea.
	 * 
	 * @param idAudio  abestiaren identifikadorea
	 * @param titulua  abestiaren titulua
	 * @param iraupena abestiaren iraupena
	 */
	public Abestia(String idAudio, String titulua, String iraupena) {
		super(idAudio, titulua, iraupena);
		System.out.println("3");
	}


	/**
	 * Abestia klasearen eraikitzailea.
	 * 
	 * @param irudia abestiaren irudia
	 */
	public Abestia(Blob irudia) {
		super(irudia);
		System.out.println("4");
	}

}
