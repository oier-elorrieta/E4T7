package model;

import java.util.Date;

/**
 * E_Free klasea Erabiltzailea klasearen luzapena da. Erabiltzaile mota honetan,
 * erabiltzaileak doako kontua izango du.
 */
public class E_Free extends Erabiltzailea {

	/**
	 * Doako kontuaren eraikitzailea.
	 * 
	 * @param erabiltzailea Erabiltzailearen erabiltzaile izena
	 * @param pasahitza     Erabiltzailearen pasahitza
	 * @param izena         Erabiltzailearen izena
	 * @param abizena       Erabiltzailearen abizena
	 * @param hizkuntza     Erabiltzailearen hizkuntza
	 * @param jaiotze_data  Erabiltzailearen jaiotze data
	 */
	public E_Free(String erabiltzailea, String pasahitza, String izena, String abizena, String hizkuntza,
			Date jaiotze_data) {
		super(erabiltzailea, pasahitza, izena, abizena, hizkuntza, jaiotze_data);
	}

	public E_Free(String idBezeroa, String erabiltzailea, String pasahitza, String izena, String abizena,
			String hizkuntza, Date jaiotze_data) {
		super(idBezeroa, erabiltzailea, pasahitza, izena, abizena, hizkuntza, jaiotze_data);
	}
	

}
