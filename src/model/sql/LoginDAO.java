package model.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.E_Free;
import model.E_Premium;
import model.Erabiltzailea;

/**
 * SQLKonexioa klasea datu basearekin konexioa ezartzeko eta datuak kudeatzeko
 * klasea da. Klase honek MySQL datu basearekin konexioa irekitzen du,
 * kontsultaak exekutatzen ditu, erabiltzaileak sartutako datuak bilatzen ditu
 * eta erregistratzen ditu.
 */
public class LoginDAO {
	

	/**
	 * Erabiltzailea klasea erabiltzailearen informazioa gordetzeko erabiltzen da.
	 * Erabiltzailearen atributuak ditu, hauetako batzuk Free motako
	 * erabiltzaileentzat eta besteak Premium motako erabiltzaileentzat.
	 * Erabiltzailea klasea loginKonexioa() metodoan erabiltzen da, erabiltzailea
	 * eta pasahitza emanda, datu-basean bilatzen duen erabiltzailea aurkitzeko.
	 * Aurkitzen badu, motaren arabera E_Free edo E_Premium objektu bat sortzen du
	 * eta itzultzen du.
	 * 
	 * @param user   erabiltzailearen izena
	 * @param passwd erabiltzailearen pasahitza
	 * @return Erabiltzailea objektua aurkitzen badu, E_Free edo E_Premium objektua
	 *         itzultzen du. Aurkitzen ez badu, null itzultzen du.
	 * @throws SQLException SQL errore bat gertatzen bada
	 */
	public static Erabiltzailea loginKonexioa(String user, String passwd) throws SQLException {
		Konexioa.konexioaIreki();
		Erabiltzailea e1 = null;
		String SQLquery = "SELECT IDBezeroa, Erabiltzailea, Pasahitza, Mota, Izena, Abizena, Hizkuntza, Jaiotza_data FROM bezeroa WHERE Erabiltzailea LIKE '"
				+ user + "' AND Pasahitza = '" + passwd + "' AND Aktiboa = true;";

		try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				String idBezeroa = resultSet.getString("IDBezeroa");
				String erabiltzailea = resultSet.getString("Erabiltzailea");
				String pasahitza = resultSet.getString("Pasahitza");
				String mota = resultSet.getString("Mota");

				String izena = resultSet.getString("Izena");
				String abizena = resultSet.getString("Abizena");
				String hizkuntza = resultSet.getString("Hizkuntza");
				Date jaioData = resultSet.getDate("Jaiotza_data");

				if (mota.equals("Free")) {
					E_Free f1 = new E_Free(idBezeroa, erabiltzailea, pasahitza, izena, abizena, hizkuntza, jaioData);
					e1 = f1;
				} else {
					E_Premium p1 = new E_Premium(idBezeroa, erabiltzailea, pasahitza, izena, abizena, hizkuntza, jaioData,
							iraungitzeDataLortu(erabiltzailea));
					e1 = p1;
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Konexioa.konexioaItxi();
		}

		return e1;
	}

	/**
	 * Metodo honek erabiltzailearen iraungitze data lortzen du.
	 *
	 * @param erabiltzailea Erabiltzailearen izena
	 * @return Iraungitze data
	 */
	public static Date iraungitzeDataLortu(String erabiltzailea) {
		Konexioa.konexioaIreki();
		Date IraungitzeData = null;

		String SQLquery = "SELECT Iraungitze_data FROM premium WHERE IDBezeroa = (SELECT IDBezeroa FROM bezeroa WHERE Erabiltzailea = '"
				+ erabiltzailea + "')";

		try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			if (resultSet.next()) {
				IraungitzeData = resultSet.getDate("Iraungitze_data");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		Konexioa.konexioaItxi();

		return IraungitzeData;

	}


}
