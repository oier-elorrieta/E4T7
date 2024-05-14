package model;

import java.util.Date;

/**
 * E_Free klasea Erabiltzailea klasearen luzapena da. Erabiltzaile mota honetako
 * erabiltzaileak doako kontua dute.
 */
public class E_Free extends Erabiltzailea {

	/**
	 * E_Free klasearen eraikitzailea.
	 * 
	 * @param erabiltzailea erabiltzailearen erabiltzaile izena
	 * @param pasahitza     erabiltzailearen pasahitza
	 * @param izena         erabiltzailearen izena
	 * @param abizena       erabiltzailearen abizena
	 * @param hizkuntza     erabiltzailearen hizkuntza
	 * @param jaiotze_data  erabiltzailearen jaiotze data
	 */
	public E_Free(String erabiltzailea, String pasahitza, String izena, String abizena, String hizkuntza,
			Date jaiotze_data) {
		super(erabiltzailea, pasahitza, izena, abizena, hizkuntza, jaiotze_data);
	}

	/**
	 * E_Free klasearen eraikitzailea.
	 * 
	 * @param idBezeroa     erabiltzailearen bezeroaren identifikadorea
	 * @param erabiltzailea erabiltzailearen erabiltzaile izena
	 * @param pasahitza     erabiltzailearen pasahitza
	 * @param izena         erabiltzailearen izena
	 * @param abizena       erabiltzailearen abizena
	 * @param hizkuntza     erabiltzailearen hizkuntza
	 * @param jaiotze_data  erabiltzailearen jaiotze data
	 */
	public E_Free(String idBezeroa, String erabiltzailea, String pasahitza, String izena, String abizena,
			String hizkuntza, Date jaiotze_data) {
		super(idBezeroa, erabiltzailea, pasahitza, izena, abizena, hizkuntza, jaiotze_data);
	}
}
