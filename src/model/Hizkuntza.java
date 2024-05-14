package model;

/**
 * Hizkuntza klasea hizkuntza objektuak gordetzeko erabiliko da.
 */
public class Hizkuntza {
	private String id;
	private String deskribapena;

	/**
	 * Hizkuntza klasearen eraikitzailea.
	 * 
	 * @param id           hizkuntzaren identifikadorea
	 * @param deskribapena hizkuntzaren deskribapena
	 */
	public Hizkuntza(String id, String deskribapena) {
		this.id = id;
		this.deskribapena = deskribapena;
	}

	/**
	 * Hizkuntzaren identifikadorea itzultzen du.
	 * 
	 * @return hizkuntzaren identifikadorea
	 */
	public String getId() {
		return id;
	}

	/**
	 * Hizkuntzaren deskribapena itzultzen du.
	 * 
	 * @return hizkuntzaren deskribapena
	 */
	public String getDeskribapena() {
		return deskribapena;
	}

}
