package model;

import java.util.Objects;

import model.metodoak.SesioAldagaiak;

/**
 * Playlist klasea errepresentatzen duen klasea.
 */
public class Playlist {

	private String idPlaylist;
	private String titulua;
	private int kapazitatea;
	private String idBezeroa;
	private String idAudio;

	/**
	 * Playlist klasearen eraikitzailea.
	 * 
	 * @param kapazitatea Playlistaren kapazitatea
	 * @param titulua     Playlistaren titulua
	 */
	
	// BESTE PLAYLIST-EN KONSTRUKTOREA
	public Playlist(String idPlaylist, String titulua, int kapazitatea, String idBezeroa) {
		this.idPlaylist = idPlaylist;
		this.titulua = titulua;
		if (!SesioAldagaiak.e_premium) {
			this.kapazitatea = 2;
		}
		this.idBezeroa = idBezeroa;
	}
	
	// GUSTOKOEN ZERRENDA KONSTRUKTOREA
	public Playlist(String titulua, String idBezeroa, String idAudio) {
		this.titulua = "Gustokoen zerrenda";
		this.idBezeroa = idBezeroa;
		this.idAudio = idAudio;
	}
	

	public String getIdPlaylist() {
		return idPlaylist;
	}


	public void setIdPlaylist(String idPlaylist) {
		this.idPlaylist = idPlaylist;
	}



	public int getKapazitatea() {
		return kapazitatea;
	}



	public void setKapazitatea(int kapazitatea) {
		this.kapazitatea = kapazitatea;
	}



	public String getTitulua() {
		return titulua;
	}



	public void setTitulua(String titulua) {
		this.titulua = titulua;
	}



	public String getIdBezeroa() {
		return idBezeroa;
	}


	public void setIdBezeroa(String idBezeroa) {
		this.idBezeroa = idBezeroa;
	}
	
	public String getIdAudio() {
		return idAudio;
	}

	public void setIdAudio(String idAudio) {
		this.idAudio = idAudio;
	}

	/**
	 * Playlistaren String errepresentazioa itzultzen du.
	 * 
	 * @return Playlistaren String errepresentazioa
	 */
	@Override
	public String toString() {
		return "Playlist [idPlaylist=" + idPlaylist + ", titulua=" + titulua + ", kapazitatea=" + kapazitatea
				+ ", idBezeroa=" + idBezeroa + ", idAudio=" + idAudio + "]";
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
		return Objects.equals(idAudio, other.idAudio) && Objects.equals(idBezeroa, other.idBezeroa)
				&& Objects.equals(idPlaylist, other.idPlaylist) && kapazitatea == other.kapazitatea
				&& Objects.equals(titulua, other.titulua);
	}

	

	

}