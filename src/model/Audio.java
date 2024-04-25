package model;

import java.sql.Blob;
import java.util.Objects;

/**
 * Audio klasea musika fitxategiak errepresentatzeko erabiliko da. Klase honek
 * titulua eta iraupena gordetzen ditu, baita titulua eta iraupena aldatzeko
 * metodoak ere ditu.
 */
public class Audio {
	protected String titulua;
	protected Blob irudia;
	protected String iraupena;

	/**
	 * Audio klasearen eraikitzailea.
	 * 
	 * @param titulua  audioaren titulua
	 * @param iraupena audioaren iraupena
	 */
	public Audio(String titulua, Blob irudia, String iraupena) {
		this.titulua = titulua;
		this.irudia = irudia;
		this.iraupena = iraupena;
	}

	/**
	 * Audioaren titulua itzultzen du.
	 * 
	 * @return audioaren titulua
	 */
	public String getTitulua() {
		return titulua;
	}


	/**
	 * Audioaren titulua aldatzen du.
	 * 
	 * @param titulua audioaren berriro ezarriko den titulua
	 */
	public void setTitulua(String titulua) {
		this.titulua = titulua;
	}

	public Blob getIrudia() {
		return irudia;
	}

	public String getIraupena() {
		return iraupena;
	}

	public void setIraupena(String iraupena) {
		this.iraupena = iraupena;
	}

	public void setIrudia(Blob irudia) {
		this.irudia = irudia;
	}

	/**
	 * Objektu hau eta beste objektu bat berdinak diren ala ez adierazten du.
	 * 
	 * @param obj beste objektu bat
	 * @return objektuak berdinak diren ala ez adierazten duen boolean balioa
	 */
	

	/**
	 * Objektuaren informazioa testu moduan itzultzen du.
	 * 
	 * @return objektuaren informazioa testu moduan
	 */
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Audio other = (Audio) obj;
		return Objects.equals(iraupena, other.iraupena) && Objects.equals(irudia, other.irudia)
				&& Objects.equals(titulua, other.titulua);
	}

	@Override
	public String toString() {
		return titulua + " - " + iraupena;
	}

}
