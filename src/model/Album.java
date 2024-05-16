package model;

import java.util.Date;
import java.util.Objects;

/**
 * Album klasea errepresentatzen duen klasea.
 */
public class Album {
	private String izenburua;
	private String urtea;
	private String generoa;
	private int kantaTotala;

	/**
	 * Album klasearen eraikitzailea izenburua, urtea eta kanta totala erabiliz.
	 * 
	 * @param izenburua   albumaren izenburua
	 * @param urtea       albumaren urtea
	 * @param kantaTotala albumaren kanta totala
	 */
	public Album(String izenburua, String urtea, int kantaTotala, String generoa) {
		this.izenburua = izenburua;
		this.urtea = urtea;
		this.kantaTotala = kantaTotala;
		this.generoa = generoa;
	}


	public Album(String izenburua, String urtea, String generoa) {
		this.izenburua = izenburua;
		this.urtea = urtea;
		this.generoa = generoa;
	}


	public Album() {
	}


	/**
	 * Album klasearen eraikitzailea izenburua erabiliz.
	 * 
	 * @param izenburua albumaren izenburua
	 */
	public Album(String izenburua) {
		this.izenburua = izenburua;
	}



	/**
	 * Albumaren izenburua itzultzen du.
	 * 
	 * @return albumaren izenburua
	 */
	public String getIzenburua() {
		return izenburua;
	}

	/**
	 * Albumaren izenburua ezartzen du.
	 * 
	 * @param izenburua albumaren izenburua
	 */
	public void setIzenburua(String izenburua) {
		this.izenburua = izenburua;
	}

	/**
	 * Albumaren urtea itzultzen du.
	 * 
	 * @return albumaren urtea
	 */
	public String getUrtea() {
		return urtea;
	}

	/**
	 * Albumaren urtea ezartzen du.
	 * 
	 * @param urtea albumaren urtea
	 */
	public void setUrtea(String urtea) {
		this.urtea = urtea;
	}

	/**
	 * Albumaren generoa itzultzen du.
	 * 
	 * @return albumaren generoa
	 */
	public String getGeneroa() {
		return generoa;
	}

	/**
	 * Albumaren generoa ezartzen du.
	 * 
	 * @param generoa albumaren generoa
	 */
	public void setGeneroa(String generoa) {
		this.generoa = generoa;
	}

	/**
	 * Albumaren kanta totala itzultzen du.
	 * 
	 * @return albumaren kanta totala
	 */
	public int getKantaTotala() {
		return kantaTotala;
	}

	/**
	 * Albumaren kanta totala ezartzen du.
	 * 
	 * @param kantaTotala albumaren kanta totala
	 */
	public void setKantaTotala(int kantaTotala) {
		this.kantaTotala = kantaTotala;
	}

	/**
	 * Albumaren testu errepresentazioa itzultzen du.
	 * 
	 * @return albumaren testu errepresentazioa
	 */
	@Override
	public String toString() {
		return izenburua + " - " + urtea + " - " + kantaTotala + " kanta";
	}

	/**
	 * Albuma beste objektu batekin alderatzen du.
	 * 
	 * @param obj alderatzeko objektua
	 * @return objektuak berdinak diren ala ez
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		return Objects.equals(generoa, other.generoa) && Objects.equals(izenburua, other.izenburua)
				&& kantaTotala == other.kantaTotala && Objects.equals(urtea, other.urtea);
	}
}