package model;

import java.sql.Blob;

/**
 * Artista klasea abstraktoa da. Klase honek artista baten izena gordetzen du.
 */
public abstract class Artista {
	protected String izena;
	protected int erreprodukzioak;
	protected Blob irudia;
	protected String deskribapena;

	/**
	 * Artista klasearen eraikitzailea.
	 * 
	 * @param izena artistaaren izena
	 */
	public Artista(String izena, int erreprodukzioak, String deskribapena, Blob irudia) {
		this.izena = izena;
		this.irudia = irudia;
		this.erreprodukzioak = erreprodukzioak;
		this.deskribapena = deskribapena;
	}

	public Artista(String izena, int erreprodukzioak) {
		this.izena = izena;
		this.erreprodukzioak = erreprodukzioak;
	}

	public Artista(Blob irudia, String deskribapena) {
		this.irudia = irudia;
		this.deskribapena = deskribapena;
	}

	/**
	 * Artista izena itzultzen du.
	 * 
	 * @return artistaren izena
	 */
	public String getIzena() {
		return izena;
	}
	


	/**
	 * Artista izena ezartzen du.
	 * 
	 * @param artistaren izena
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}
	

	public Blob getIrudia() {
		return irudia;
	}

	public void setIrudia(Blob irudia) {
		this.irudia = irudia;
	}

	public int getErreprodukzioak() {
		return erreprodukzioak;
	}

	public void setErreprodukzioak(int erreprodukzioak) {
		this.erreprodukzioak = erreprodukzioak;
	}


	public String getDeskribapena() {
		return deskribapena;
	}

	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}

	@Override
	public String toString() {
		return izena + " - " + erreprodukzioak + " erreprodukzio";
	}


	/**
	 * Artista informazioa itzultzen du.
	 * 
	 * @return artistaren informazioa
	 */
	
	
	
	
	
	
	
	
}