package model;

import java.sql.Blob;

/**
 * Abestiak klasea, Audio klasearen luzapena da. Abestiak klaseak titulua eta
 * iraupena gordetzen ditu.
 */
public class Abestia extends Audio {

	public Abestia(String titulua, Blob irudia, String iraupena) {
		super(titulua, irudia, iraupena);
	}

	public Abestia(String idAudio, String titulua, String iraupena, int erreprodukzioak) {
		super(idAudio, titulua, iraupena, erreprodukzioak);
	}

	
	
	public Abestia(Blob irudia) {
		super(irudia);
	}

	/**
	 * Abestiak klasearen eraikitzailea.
	 * 
	 * @param titulua  abestiaren titulua
	 * @param iraupena abestiaren iraupena
	 */
	
}
