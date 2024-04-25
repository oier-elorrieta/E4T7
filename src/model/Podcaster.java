package model;

import java.sql.Blob;

public class Podcaster extends  Artista {

	public Podcaster(String izena, int erreprodukzioak) {
		super(izena, erreprodukzioak);
	}
	
	public Podcaster(String deskribapena, Blob irudia) {
		super(irudia, deskribapena);
	}

}
