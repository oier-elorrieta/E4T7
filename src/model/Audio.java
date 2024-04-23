package model;

import java.util.Objects;

/**
 * Audio klasea musika fitxategiak errepresentatzeko erabiliko da. Klase honek
 * titulua eta iraupena gordetzen ditu, baita titulua eta iraupena aldatzeko
 * metodoak ere ditu.
 */
public class Audio {
	protected String titulua;
	protected int iraupena;

	/**
	 * Audio klasearen eraikitzailea.
	 * 
	 * @param titulua  audioaren titulua
	 * @param iraupena audioaren iraupena
	 */
	public Audio(String titulua, int iraupena) {
		this.titulua = titulua;
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

	/**
	 * Audioaren iraupena itzultzen du.
	 * 
	 * @return audioaren iraupena
	 */
	public int getIraupena() {
		return iraupena;
	}

	/**
	 * Audioaren iraupena aldatzen du.
	 * 
	 * @param iraupena audioaren berriro ezarriko den iraupena
	 */
	public void setIraupena(int iraupena) {
		this.iraupena = iraupena;
	}

	/**
	 * Objektu hau eta beste objektu bat berdinak diren ala ez adierazten du.
	 * 
	 * @param obj beste objektu bat
	 * @return objektuak berdinak diren ala ez adierazten duen boolean balioa
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
		return iraupena == other.iraupena && Objects.equals(titulua, other.titulua);
	}

	/**
	 * Objektuaren informazioa testu moduan itzultzen du.
	 * 
	 * @return objektuaren informazioa testu moduan
	 */
	@Override
	public String toString() {
		return "Audio [titulua=" + titulua + ", iraupena=" + iraupena + "]";
	}

}
