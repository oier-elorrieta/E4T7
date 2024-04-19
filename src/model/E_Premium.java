package model;

import java.util.Date;

public class E_Premium extends Erabiltzailea {
	
	protected String iraungintze_data;

	public E_Premium(String erabiltzailea, String pasahitza, String izena, String abizena, String jaiotze_data,
			String iraungintze_data) {
		super(erabiltzailea, pasahitza, izena, abizena, jaiotze_data);
		this.iraungintze_data = iraungintze_data;
	}

}
