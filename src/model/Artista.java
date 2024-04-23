package model;

/**
 * Artista klasea abstraktoa da. Klase honek artista baten izena gordetzen du.
 */
public abstract class Artista {
	private String izena;

	/**
	 * Artista klasearen eraikitzailea.
	 * 
	 * @param nombre artistaaren izena
	 */
	public Artista(String nombre) {
		this.izena = nombre;
	}

	/**
	 * Artista izena itzultzen du.
	 * 
	 * @return artistaren izena
	 */
	public String getNombre() {
		return izena;
	}

	/**
	 * Artista izena ezartzen du.
	 * 
	 * @param artistaren izena
	 */
	public void setNombre(String nombre) {
		this.izena = nombre;
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