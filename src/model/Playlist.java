package model;

import java.util.Date;
import java.util.Objects;

import model.metodoak.SesioAldagaiak;

/**
 * Playlist klasea errepresentatzen duen klasea.
 */
public class Playlist {

	private int idPlaylist;
	private String titulua;
	private int kapazitatea;
	private Date Sorrera_data;
	private String idBezeroa;
	private String idAudio;

	/**
	 * Beste playlist
	 * 
	 * @param kapazitatea Playlistaren kapazitatea
	 * @param titulua     Playlistaren titulua
	 */
	public Playlist(String titulua, int kapazitatea, Date Sorrera_data) {
		this.titulua = titulua;
		if (!SesioAldagaiak.e_premium) {
			this.kapazitatea = 2;
		}
		this.Sorrera_data = Sorrera_data;
	}
	
	/**
	 * Playlist klasearen eraikitzailea.
	 * 
	 * @param idPlaylist
	 * @param titulua
	 * @param kapazitatea
	 */
	public Playlist(int idPlaylist, String titulua, int kapazitatea) {
		this.idPlaylist = idPlaylist;
		this.titulua = titulua;
		this.kapazitatea = kapazitatea;
	}

	/**
	 * Playlist klasearen eraikitzailea.
	 * 
	 * @param idPlaylist
	 * @param titulua
	 * @param kapazitatea
	 * @param idBezeroa
	 * @param sorrera_data
	 */
	public Playlist(int idPlaylist, String titulua, int kapazitatea, String idBezeroa, Date sorrera_data) {
		this.idPlaylist = idPlaylist;
		this.titulua = titulua;
		this.kapazitatea = kapazitatea;
		this.idBezeroa = idBezeroa;
		Sorrera_data = sorrera_data;
	}

	/**
	 * Gustokoen zerrenda sortzeko konstruktorea.
	 *
	 * @param titulua   the title of the playlist
	 * @param idBezeroa the user ID associated with the playlist
	 * @param idAudio   the audio ID associated with the playlist
	 */
	public Playlist(String titulua, String idBezeroa, String idAudio) {
		this.titulua = "Gustokoen zerrenda";
		this.idBezeroa = idBezeroa;
		this.idAudio = idAudio;
	}

	/**
	 * Playlist klasearen eraikitzailea.
	 * 
	 * @param idPlaylist
	 * @param titulua
	 * @param kapazitatea
	 * @param sorrera_data
	 */
	public Playlist(int idPlaylist, String titulua, int kapazitatea, Date sorrera_data) {
		this.idPlaylist = idPlaylist;
		this.titulua = titulua;
		this.kapazitatea = kapazitatea;
		Sorrera_data = sorrera_data;
	}
	
	
	/**
	 * Playlist klasearen hutsa.
	 */
	public Playlist() {
		
	}

	/**
	 * Zerrenda bat sortzen du titulu eta erabiltzaile ID-arekin.
	 *
	 * @param titulua   zerrendaren titulua
	 * @param idBezeroa zerrendarekin erlazionatutako erabiltzailearen ID-a
	 */
	public Playlist(String titulua, String idBezeroa) {
		this.titulua = "Gustokoen zerrenda";
		this.idAudio = idBezeroa;
	}

	/**
	 * Playlist gustokoaren klasearen eraikitzailea.
	 * 
	 * @param titulua Playlist objektuaren titulua
	 */
	public Playlist(String titulua) {
		this.titulua = "Gustokoen zerrenda";
	}

	/**
	 * Playlist klasearen eraikitzailea.
	 * 
	 * @param titulua Playlist objektuaren titulua
	 */
	public Playlist(String titulua, int kapazitatea) {
		this.titulua = "Gustokoen zerrenda";
		this.kapazitatea = kapazitatea;
	}

	/**
	 * Gets the creation date of the playlist.
	 *
	 * @return The creation date of the playlist.
	 */
	public Date getSorrera_data() {
		return Sorrera_data;
	}

	/**
	 * Metodo honek 'Sorrera_data' atributuari balioa esleitzen dio.
	 *
	 * @param sorrera_data 'Sorrera_data' atributuaren balioa
	 */
	public void setSorrera_data(Date sorrera_data) {
		Sorrera_data = sorrera_data;
	}

	/**
	 * Metodo honek zerrendaren identifikadorea itzultzen du.
	 *
	 * @return Zerrendaren identifikadorea.
	 */
	public int getIdPlaylist() {
		return idPlaylist;
	}

	/**
	 * Zerrendaren ID-a ezartzen du.
	 *
	 * @param idPlaylist Zerrendaren ID-a.
	 */
	public void setIdPlaylist(int idPlaylist) {
		this.idPlaylist = idPlaylist;
	}

	/**
	 * Zerrendaren kapazitatea itzultzen du.
	 *
	 * @return Zerrendaren kapazitatea
	 */
	public int getKapazitatea() {
		return kapazitatea;
	}

	/**
	 * Metodo honek kapazitatea atributuaren balioa ezartzen du.
	 * 
	 * @param kapazitatea Kapazitatearen balioa
	 */
	public void setKapazitatea(int kapazitatea) {
		this.kapazitatea = kapazitatea;
	}

	/**
	 * Zerrendaren titulua itzultzen du.
	 *
	 * @return Zerrendaren titulua
	 */
	public String getTitulua() {
		return titulua;
	}

	/**
	 * Zerrendaren titulua ezartzen du.
	 *
	 * @param titulua Zerrendaren titulua.
	 */
	public void setTitulua(String titulua) {
		this.titulua = titulua;
	}

	/**
	 * Bezeroaren identifikazioa itzultzen du.
	 *
	 * @return Bezeroaren identifikazioa
	 */
	public String getIdBezeroa() {
		return idBezeroa;
	}

	/**
	 * Metodo honek bezeroaren identifikazioa ezartzen du.
	 *
	 * @param idBezeroa Bezeroaren identifikazioa
	 */
	public void setIdBezeroa(String idBezeroa) {
		this.idBezeroa = idBezeroa;
	}

	/**
	 * Metodo honek zerrendako audioaren identifikadorea itzultzen du.
	 *
	 * @return Audioaren identifikadorea.
	 */
	public String getIdAudio() {
		return idAudio;
	}

	/**
	 * Establece el identificador del audio en la lista de reproducción.
	 * 
	 * @param idAudio el identificador del audio a establecer
	 */
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
		return titulua + " - " + kapazitatea + " abesti";
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
		return Objects.equals(Sorrera_data, other.Sorrera_data) && Objects.equals(idAudio, other.idAudio)
				&& Objects.equals(idBezeroa, other.idBezeroa) && Objects.equals(idPlaylist, other.idPlaylist)
				&& kapazitatea == other.kapazitatea && Objects.equals(titulua, other.titulua);
	}

}