package model;

/**
 * Artista klasea abstraktoa da. Klase honek artista baten izena gordetzen du.
 */
public abstract class Artista {
	private String izena;
	private int erreprodukzioak;

	/**
	 * Artista klasearen eraikitzailea.
	 * 
	 * @param izena artistaaren izena
	 */
	public Artista(String izena, int erreprodukzioak) {
		this.izena = izena;
		this.erreprodukzioak = erreprodukzioak;
	}
	
	/**
	 * Artista izena itzultzen du.
	 * 
	 * @return artistaren izena
	 */
	public String getizena() {
		return izena;
	}
	

	/**
	 * Artista izena ezartzen du.
	 * 
	 * @param artistaren izena
	 */
	public void setizena(String izena) {
		this.izena = izena;
	}
	
	

	public int getErreprodukzioak() {
		return erreprodukzioak;
	}

	public void setErreprodukzioak(int erreprodukzioak) {
		this.erreprodukzioak = erreprodukzioak;
	}


	/**
	 * Artista informazioa itzultzen du.
	 * 
	 * @return artistaren informazioa
	 */
	@Override
	public String toString() {
		return "Artista [izena=" + izena + ", erreprodukzioak=" + erreprodukzioak + "]";
	}
}