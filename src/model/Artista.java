package model;

/**
 * Artista klasea abstraktoa da. Klase honek artista baten izena gordetzen du.
 */
public abstract class Artista {
	private String izena;

	/**
	 * Artista klasearen eraikitzailea.
	 * 
	 * @param izena artistaaren izena
	 */
	public Artista(String izena) {
		this.izena = izena;
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

	/**
	 * Artista informazioa itzultzen du.
	 * 
	 * @return artistaren informazioa
	 */
	@Override
	public String toString() {
		return "Artista [Izena=" + izena + "]";
	}
}