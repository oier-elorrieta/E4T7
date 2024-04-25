package model;

/**
 * Artista klasea abstraktoa da. Klase honek artista baten izena gordetzen du.
 */
public abstract class Artista {
	protected String izena;
	protected int erreprodukzioak;
	protected String deskribapena;

	/**
	 * Artista klasearen eraikitzailea.
	 * 
	 * @param izena artistaaren izena
	 */
	public Artista(String izena, int erreprodukzioak, String deskribapena) {
		super();
		this.izena = izena;
		this.erreprodukzioak = erreprodukzioak;
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
		return "Artista [izena=" + izena + ", erreprodukzioak=" + erreprodukzioak + ", deskribapena=" + deskribapena
				+ "]";
	}


	/**
	 * Artista informazioa itzultzen du.
	 * 
	 * @return artistaren informazioa
	 */
	
	
	
	
	
	
	
	
}