package model;

import java.util.Date;

public class Erabiltzailea {
	protected String erabiltzailea;
	protected String izena;
	protected String abizena;
	protected Date jaiotze_data;
	
	public Erabiltzailea(String erabiltzailea, String izena, String abizena, Date jaiotze_data) {
		this.erabiltzailea = erabiltzailea;
		this.izena = izena;
		this.abizena = abizena;
		this.jaiotze_data = jaiotze_data;
	}

	String getErabiltzailea() {
		return erabiltzailea;
	}

	void setErabiltzailea(String erabiltzailea) {
		this.erabiltzailea = erabiltzailea;
	}

	String getIzena() {
		return izena;
	}

	void setIzena(String izena) {
		this.izena = izena;
	}

	String getAbizena() {
		return abizena;
	}

	void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	Date getJaiotze_data() {
		return jaiotze_data;
	}

	void setJaiotze_data(Date jaiotze_data) {
		this.jaiotze_data = jaiotze_data;
	}
	
}
