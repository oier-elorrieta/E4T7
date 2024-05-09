package model;

import java.sql.Blob;
import java.util.Objects;

/**
 * Audio klasea musika fitxategiak kudeatzeko erabil daiteke. 
 * Klase honek musika fitxategien atributuak eta metodoak gordetzen ditu.
 */
/**
 * Audio klasea errepresentatzen duen klasea.
 */
public class Audio {
	protected String idAudio;
	protected String titulua;
	protected Blob irudia;
	protected String iraupena;
	protected int erreprodukzioak;

	/**
	 * Audio objektu berri bat sortzeko eraikitzailea.
	 * 
	 * @param titulua  Audioaren titulua
	 * @param irudia   Audioaren irudia
	 * @param iraupena Audioaren iraupena
	 */
	public Audio(String titulua, Blob irudia, String iraupena) { 
		this.titulua = titulua;
		this.irudia = irudia;
		this.iraupena = iraupena;
	}

	/**
	 * Audio objektu berri bat sortzeko eraikitzailea.
	 * 
	 * @param idAudio         Audioaren identifikazioa
	 * @param titulua         Audioaren titulua
	 * @param iraupena        Audioaren iraupena
	 * @param erreprodukzioak Audioaren erreprodukzio kopurua
	 */
	public Audio(String idAudio, String titulua, String iraupena, int erreprodukzioak) {
		this.idAudio = idAudio;
		this.titulua = titulua;
		this.iraupena = iraupena;
		this.erreprodukzioak = erreprodukzioak;
	}

	/**
	 * Audio objektu berri bat sortzeko eraikitzailea.
	 * 
	 * @param idAudio  Audioaren identifikazioa
	 * @param titulua  Audioaren titulua
	 * @param iraupena Audioaren iraupena
	 */
	public Audio(String idAudio, String titulua, String iraupena) {
		this.idAudio = idAudio;
		this.titulua = titulua;
		this.iraupena = iraupena;
	}

	/**
	 * Audio objektu berri bat sortzeko eraikitzailea.
	 * 
	 * @param irudia Audioaren irudia
	 */
	public Audio(Blob irudia) {
		this.irudia = irudia;
	}

	/**
	 * Audio objektu berri bat sortzeko eraikitzailea.
	 * 
	 * @param titulua Audioaren titulua
	 * @param irudia  Audioaren irudia
	 */
	public Audio(String titulua, Blob irudia) {
		this.titulua = titulua;
		this.irudia = irudia;
	}

	/************************************************/
	
	/**
	 * Audioaren titulua itzultzen du.
	 * 
	 * @return Audioaren titulua
	 */
	public String getTitulua() {
		return titulua;
	}

	/**
	 * Audioaren titulua ezarri du.
	 * 
	 * @param titulua Audioaren titulua
	 */
	public void setTitulua(String titulua) {
		this.titulua = titulua;
	}

	/**
	 * Audioaren identifikazioa itzultzen du.
	 * 
	 * @return Audioaren identifikazioa
	 */
	public String getIdAudio() {
		return idAudio;
	}

	/**
	 * Audioaren identifikazioa ezarri du.
	 * 
	 * @param idAudio Audioaren identifikazioa
	 */
	public void setIdAudio(String idAudio) {
		this.idAudio = idAudio;
	}

	/**
	 * Audioaren irudia itzultzen du.
	 * 
	 * @return Audioaren irudia
	 */
	public Blob getIrudia() {
		return irudia;
	}

	/**
	 * Audioaren iraupena itzultzen du.
	 * 
	 * @return Audioaren iraupena
	 */
	public String getIraupena() {
		return iraupena;
	}

	/**
	 * Audioaren iraupena ezarri du.
	 * 
	 * @param iraupena Audioaren iraupena
	 */
	public void setIraupena(String iraupena) {
		this.iraupena = iraupena;
	}

	/**
	 * Audioaren irudia ezarri du.
	 * 
	 * @param irudia Audioaren irudia
	 */
	public void setIrudia(Blob irudia) {
		this.irudia = irudia;
	}

	/**
	 * Audioaren erreprodukzio kopurua itzultzen du.
	 * 
	 * @return Audioaren erreprodukzio kopurua
	 */
	public int getErreprodukzioak() {
		return erreprodukzioak;
	}

	/**
	 * Audioaren erreprodukzio kopurua ezarri du.
	 * 
	 * @param erreprodukzioak Audioaren erreprodukzio kopurua
	 */
	public void setErreprodukzioak(int erreprodukzioak) {
		this.erreprodukzioak = erreprodukzioak;
	}

	/**
	 * Objektu hau beste objektu batekin alderatzen du.
	 * 
	 * @param obj Beste objektua
	 * @return True, objektuak berdinak diren. False, bestela.
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

	/**
	 * Objektuaren testu errepresentazioa itzultzen du.
	 * 
	 * @return Objektuaren testu errepresentazioa
	 */
	@Override
	public String toString() {
		return titulua + " - " + iraupena + " - " + erreprodukzioak + " erreprodukzio";
	}
}
