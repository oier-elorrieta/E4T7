package model;

import java.sql.Blob;

public class Musikaria extends Artista {

	public Musikaria(String izena, int erreprodukzioak) {
		super(izena, erreprodukzioak);
	}

	public Musikaria(Blob irudia, String deskribapena) {
		super(irudia, deskribapena);
	}

}
