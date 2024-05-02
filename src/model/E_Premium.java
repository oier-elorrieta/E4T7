package model;

import java.util.Date;
import java.util.Objects;

/**
 * E_Premium klasea Erabiltzailea klasearen luzapena da, eta iraungintze data
 * atributua gehitzen du.
 */
public class E_Premium extends Erabiltzailea {
	protected Date iraungintze_data;

	/**
	 * E_Premium klasearen eraikitzailea. Erabiltzailearen datuak eta iraungintze
	 * data jasoko ditu.
	 * 
	 * @param erabiltzailea    erabiltzailearen izena
	 * @param pasahitza        erabiltzailearen pasahitza
	 * @param izena            erabiltzailearen izena
	 * @param abizena          erabiltzailearen abizena
	 * @param hizkuntza        erabiltzailearen hizkuntza
	 * @param jaiotze_data     erabiltzailearen jaiotze data
	 * @param iraungintze_data erabiltzailearen iraungintze data
	 */
	public E_Premium(String idBezeroa, String erabiltzailea, String pasahitza, String izena, String abizena,
			String hizkuntza, Date jaiotze_data, Date iraungintze_data) {
		super(idBezeroa, erabiltzailea, pasahitza, izena, abizena, hizkuntza, jaiotze_data);
		this.iraungintze_data = iraungintze_data;
	}

	public E_Premium(String erabiltzailea, String pasahitza, String izena, String abizena, String hizkuntza,
			Date jaiotze_data, Date iraungintze_data) {
		super(erabiltzailea, pasahitza, izena, abizena, hizkuntza, jaiotze_data);
		this.iraungintze_data = iraungintze_data;
	}



	/**
	 * Iraungintze data atributuaren getter-a.
	 * 
	 * @return iraungintze data
	 */
	public Date getIraungintze_data() {
		return iraungintze_data;
	}

	

	/**
	 * Iraungintze data atributuaren setter-a.
	 * 
	 * @param iraungintze_data iraungintze data
	 */
	public void setIraungintze_data(Date iraungintze_data) {
		this.iraungintze_data = iraungintze_data;
	}

	/**
	 * E_Premium objektuaren String errepresentazioa bueltatzen du.
	 * 
	 * @return objektuaren String errepresentazioa
	 */
	@Override
	public String toString() {
		return super.toString() + "E_Premium [iraungintze_data=" + iraungintze_data + "]";
	}

	/**
	 * Objektu hau eta beste objektu bat berdinak diren ala ez jakiteko metodoa.
	 * 
	 * @param obj beste objektua
	 * @return objektuak berdinak diren ala ez
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		E_Premium other = (E_Premium) obj;
		return Objects.equals(iraungintze_data, other.iraungintze_data);
	}

}
