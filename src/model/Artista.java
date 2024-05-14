package model;

import java.sql.Blob;

/**
 * Artista klasea abstraktoa da, eta erabilera bereziak dituena definitzen du.
 * Klase honek artistaren informazioa gordetzeko eta kudeatzeko metodoak
 * eskaintzen ditu.
 */
public abstract class Artista {
	protected String izena;
	protected int erreprodukzioak;
	protected Blob irudia;
	protected String deskribapena;

	/**
	 * Artista klasearen eraikitzailea izena eta erreprodukzio kopuruarekin.
	 *
	 * @param izena           artista izena
	 * @param erreprodukzioak artista erreprodukzio kopurua
	 */
	public Artista(String izena, int erreprodukzioak) {
		this.izena = izena;
		this.erreprodukzioak = erreprodukzioak;
	}

	/**
	 * Artista klasearen eraikitzailea irudia eta deskribapenarekin.
	 *
	 * @param irudia       artista irudia
	 * @param deskribapena artista deskribapena
	 */
	public Artista(Blob irudia, String deskribapena) {
		this.irudia = irudia;
		this.deskribapena = deskribapena;
	}

	/**
	 * Artista klasearen eraikitzailea izenarekin.
	 *
	 * @param izena artista izena
	 */
	public Artista(String izena) {
		this.izena = izena;
	}

	/**
	 * Artista izena itzultzen du.
	 *
	 * @return artista izena
	 */
	public String getIzena() {
		return izena;
	}

	/**
	 * Artista izena ezarri du.
	 *
	 * @param izena artista izena
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}

	/**
	 * Artista irudia itzultzen du.
	 *
	 * @return artista irudia
	 */
	public Blob getIrudia() {
		return irudia;
	}

	/**
	 * Artista irudia ezarri du.
	 *
	 * @param irudia artista irudia
	 */
	public void setIrudia(Blob irudia) {
		this.irudia = irudia;
	}

	/**
	 * Artista erreprodukzio kopurua itzultzen du.
	 *
	 * @return artista erreprodukzio kopurua
	 */
	public int getErreprodukzioak() {
		return erreprodukzioak;
	}

	/**
	 * Artista erreprodukzio kopurua ezarri du.
	 *
	 * @param erreprodukzioak artista erreprodukzio kopurua
	 */
	public void setErreprodukzioak(int erreprodukzioak) {
		this.erreprodukzioak = erreprodukzioak;
	}

	/**
	 * Artista deskribapena itzultzen du.
	 *
	 * @return artista deskribapena
	 */
	public String getDeskribapena() {
		return deskribapena;
	}

	/**
	 * Artista deskribapena ezarri du.
	 *
	 * @param deskribapena artista deskribapena
	 */
	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}

	/**
	 * Artista objektua testu errepresentazioan itzultzen du.
	 *
	 * @return artista objektua testu errepresentazioa
	 */
	@Override
	public String toString() {
		return izena + " - " + erreprodukzioak + " erreprodukzio";
	}
}