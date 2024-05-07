package model;

import java.util.Date;
import java.util.Objects;

/**
 * Erabiltzailea klasea erabiltzailearen datuak gordetzeko eta kudeatzeko
 * erabiliko da.
 */
public class Erabiltzailea {
	private String idBezeroa;
	private String erabiltzailea;
	private String pasahitza;
	private String izena;
	private String abizena;
	private String hizkuntza;
	private Date jaiotze_data;

	/**
	 * Erabiltzailea klasearen eraikitzailea.
	 * 
	 * @param erabiltzailea erabiltzailearen izena
	 * @param pasahitza     erabiltzailearen pasahitza
	 * @param izena         erabiltzailearen izena
	 * @param abizena       erabiltzailearen abizena
	 * @param hizkuntza     erabiltzailearen hizkuntza
	 * @param jaiotze_data  erabiltzailearen jaiotze data
	 */
	public Erabiltzailea(String idBezeroa, String erabiltzailea, String pasahitza, String izena, String abizena, String hizkuntza, Date jaiotze_data) {
		this.idBezeroa = idBezeroa;
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
		this.izena = izena;
		this.abizena = abizena;
		this.hizkuntza = hizkuntza;
		this.jaiotze_data = jaiotze_data;
	}
	
	
	public Erabiltzailea(String erabiltzailea, String pasahitza, String izena, String abizena, String hizkuntza,
			Date jaiotze_data) {
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
		this.izena = izena;
		this.abizena = abizena;
		this.hizkuntza = hizkuntza;
		this.jaiotze_data = jaiotze_data;
	}



	public String getIdBezeroa() {
		return idBezeroa;
	}

	public void setIdBezeroa(String idBezeroa) {
		this.idBezeroa = idBezeroa;
	}

	/**
	 * Metodo honek erabiltzailearen izena itzultzen du.
	 *
	 * @return erabiltzailearen izena
	 */
	public String getErabiltzailea() {
		return erabiltzailea;
	}

	/**
	 * Metodo honek Erabiltzailea klaseko erabiltzailea atributua ezartzen du.
	 *
	 * @param erabiltzailea Erabiltzailearen izena
	 */
	public void setErabiltzailea(String erabiltzailea) {
		this.erabiltzailea = erabiltzailea;
	}

	/**
	 * Metodo honek Erabiltzailearen pasahitza itzultzen du.
	 *
	 * @return Erabiltzailearen pasahitza
	 */
	public String getPasahitza() {
		return pasahitza;
	}

	/**
	 * Metodo honek Erabiltzailearen pasahitza ezartzen du.
	 *
	 * @param pasahitza Erabiltzailearen pasahitza
	 */
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	/**
	 * Metodo honek Erabiltzailearen izena itzultzen du.
	 *
	 * @return Erabiltzailearen izena
	 */
	public String getIzena() {
		return izena;
	}

	/**
	 * Metodo honek Erabiltzailearen izena ezarriko du.
	 *
	 * @param izena Erabiltzailearen izena
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}

	/**
	 * Metodo honek abizena atributuaren balioa itzultzen du.
	 *
	 * @return abizena atributuaren balioa
	 */
	public String getAbizena() {
		return abizena;
	}

	/**
	 * Metodo honek abizena atributuari balioa esleitzen dio.
	 * 
	 * @param abizena Erabiltzailearen abizena
	 */
	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	/**
	 * Metodo honek Erabiltzailearen hizkuntza itzultzen du.
	 *
	 * @return Erabiltzailearen hizkuntza
	 */
	public String getHizkuntza() {
		return hizkuntza;
	}

	/**
	 * Metodo honek Erabiltzailearen hizkuntza ezarriko du.
	 *
	 * @param hizkuntza Erabiltzailearen hizkuntza
	 */
	public void setHizkuntza(String hizkuntza) {
		this.hizkuntza = hizkuntza;
	}

	/**
	 * Metodo honek jaiotze_data atributuaren balioa itzultzen du.
	 *
	 * @return jaiotze_data atributuaren balioa
	 */
	public Date getJaiotze_data() {
		return jaiotze_data;
	}

	/**
	 * Metodo honek jaiotze_data atributuaren balioa ezartzen du.
	 *
	 * @param jaiotze_data jaiotze data berria
	 */
	public void setJaiotze_data(Date jaiotze_data) {
		this.jaiotze_data = jaiotze_data;
	}

	/**
	 * Metodo honek objektu hau eta beste objektu bat alderatzen ditu.
	 * 
	 * @param obj Beste objektua alderatzeko.
	 * @return True, objektuak berdinak diren adierazten badu. False, bestela.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Erabiltzailea other = (Erabiltzailea) obj;
		return Objects.equals(abizena, other.abizena) && Objects.equals(erabiltzailea, other.erabiltzailea)
				&& Objects.equals(hizkuntza, other.hizkuntza) && Objects.equals(idBezeroa, other.idBezeroa)
				&& Objects.equals(izena, other.izena) && Objects.equals(jaiotze_data, other.jaiotze_data)
				&& Objects.equals(pasahitza, other.pasahitza);
	}
	
	/**
	 * Objektuaren String irudikapen bat itzultzen du.
	 *
	 * @return objektuaren String-irudikapen bat.
	 */
	@Override
	public String toString() {
		return "Erabiltzailea [idBezeroa=" + idBezeroa + ", erabiltzailea=" + erabiltzailea + ", pasahitza=" + pasahitza
				+ ", izena=" + izena + ", abizena=" + abizena + ", hizkuntza=" + hizkuntza + ", jaiotze_data="
				+ jaiotze_data + "]";
	}


	

}
