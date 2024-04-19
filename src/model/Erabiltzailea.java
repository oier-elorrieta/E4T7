package model;

import java.util.Date;
import java.util.Objects;

public class Erabiltzailea {
	protected String erabiltzailea;
	protected String pasahitza;
	protected String izena;
	protected String abizena;
	protected Date jaiotze_data;

	public Erabiltzailea(String erabiltzailea, String pasahitza, String izena, String abizena, Date jaiotze_data) {
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
		this.izena = izena;
		this.abizena = abizena;
		this.jaiotze_data = jaiotze_data;
	}

	public String getErabiltzailea() {
		return erabiltzailea;
	}

	public void setErabiltzailea(String erabiltzailea) {
		this.erabiltzailea = erabiltzailea;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getAbizena() {
		return abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	Date getJaiotze_data() {
		return jaiotze_data;
	}

	void setJaiotze_data(Date jaiotze_data) {
		this.jaiotze_data = jaiotze_data;
	}

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
				&& Objects.equals(izena, other.izena) && Objects.equals(jaiotze_data, other.jaiotze_data)
				&& Objects.equals(pasahitza, other.pasahitza);
	}

	@Override
	public String toString() {
		return "Erabiltzailea [erabiltzailea=" + erabiltzailea + ", pasahitza=" + pasahitza + ", izena=" + izena
				+ ", abizena=" + abizena + ", jaiotze_data=" + jaiotze_data + "]";
	}
		
}
