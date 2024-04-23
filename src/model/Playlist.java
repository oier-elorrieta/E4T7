package model;

import java.util.Objects;

/**
 * Playlist klasea errepresentatzen duen klasea.
 */
public class Playlist {

	private int kapazitatea;
	private String titulua;

	/**
	 * Playlist klasearen eraikitzailea.
	 * 
	 * @param kapazitatea Playlistaren kapazitatea
	 * @param titulua     Playlistaren titulua
	 */
	public Playlist(int kapazitatea, String titulua) {
		super();
		this.kapazitatea = kapazitatea;
		this.titulua = titulua;
	}

	/**
	 * Playlistaren kapazitatea itzultzen du.
	 * 
	 * @return Playlistaren kapazitatea
	 */
	public int getKapazitatea() {
		return kapazitatea;
	}

	/**
	 * Playlistaren kapazitatea ezartzen du.
	 * 
	 * @param kapazitatea Playlistaren kapazitatea
	 */
	public void setKapazitatea(int kapazitatea) {
		this.kapazitatea = kapazitatea;
	}

	/**
	 * Playlistaren titulua itzultzen du.
	 * 
	 * @return Playlistaren titulua
	 */
	public String getTitulua() {
		return titulua;
	}

	/**
	 * Playlistaren titulua ezartzen du.
	 * 
	 * @param titulua Playlistaren titulua
	 */
	public void setTitulua(String titulua) {
		this.titulua = titulua;
	}

	/**
	 * Playlistaren String errepresentazioa itzultzen du.
	 * 
	 * @return Playlistaren String errepresentazioa
	 */
	@Override
	public String toString() {
		return "Playlist [kapazitatea=" + kapazitatea + ", titulua=" + titulua + "]";
	}

	/**
	 * Bi Playlist objektuak berdinak diren ala ez adierazten du.
	 * 
	 * @param obj Beste objektu bat
	 * @return Bi objektuak berdinak diren ala ez
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Playlist other = (Playlist) obj;
		return kapazitatea == other.kapazitatea && Objects.equals(titulua, other.titulua);
	}

}