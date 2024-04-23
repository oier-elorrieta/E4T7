package model.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JOptionPane;

import model.*;

/**
 * SQLKonexioa klasea datu basearekin konexioa ezartzeko eta datuak kudeatzeko
 * klasea da. Klase honek MySQL datu basearekin konexioa irekitzen du,
 * kontsultaak exekutatzen ditu, erabiltzaileak sartutako datuak bilatzen ditu
 * eta erregistratzen ditu.
 */
public class SQLInterakzioa {
	private static final String URL = "jdbc:mysql://localhost:3307/db_jpamt7";
	private static final String USER = "root";
	private static final String PASS = "";
	private static Connection konexioa;
	private static Statement query;

	/**
	 * Metodo honek konexioa irekitzen du datu-basearekin. Konexioa irekitzean,
	 * MySQL JDBC Driver erabiltzen da. Konexioa irekitzen da URL, erabiltzailea eta
	 * pasahitzarekin. Konexioa irekitzerakoan, datu-basearekin kontsulta egiteko
	 * aukera ematen duen objektua sortzen da.
	 * 
	 * @throws ClassNotFoundException JDBC Driver-a ez bada aurkitzen
	 * @throws SQLException           Konexioa irekitzean errore bat gertatzen bada
	 */
	public static void konexioaIreki() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			konexioa = DriverManager.getConnection(URL, USER, PASS);
			query = konexioa.createStatement();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Itxi konexioa eta kontsulta funtzioa.
	 */
	public static void konexioaItxi() {
		try {
			konexioa.close();
			query.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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

		Erabiltzailea e1 = null;
		String SQLquery = "SELECT Erabiltzailea, Pasahitza, Mota, Izena, Abizena, Hizkuntza, Jaiotza_data FROM bezeroa WHERE Erabiltzailea LIKE '"
				+ user + "' AND Pasahitza = '" + passwd + "'";

		try (PreparedStatement preparedStatement = konexioa.prepareStatement(SQLquery);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				String erabiltzailea = resultSet.getString("Erabiltzailea");
				String pasahitza = resultSet.getString("Pasahitza");
				String mota = resultSet.getString("Mota");

				String izena = resultSet.getString("Izena");
				String abizena = resultSet.getString("Abizena");
				String hizkuntza = resultSet.getString("Hizkuntza");
				Date jaioData = resultSet.getDate("Jaiotza_data");

				if (mota.equals("Free")) {
					E_Free f1 = new E_Free(erabiltzailea, pasahitza, izena, abizena, hizkuntza, jaioData);
					e1 = f1;
				} else {
					E_Premium p1 = new E_Premium(erabiltzailea, pasahitza, izena, abizena, hizkuntza, jaioData,
							iraungitzeDataLortu(erabiltzailea));
					e1 = p1;
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			konexioaItxi();
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

		Date IraungitzeData = null;

		String SQLquery = "SELECT Iraungitze_data FROM premium WHERE IDBezeroa = (SELECT IDBezeroa FROM bezeroa WHERE Erabiltzailea = '"
				+ erabiltzailea + "')";

		try (PreparedStatement preparedStatement = konexioa.prepareStatement(SQLquery);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			if (resultSet.next()) {
				IraungitzeData = resultSet.getDate("Iraungitze_data");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return IraungitzeData;

	}

	/**
	 * Metodo honek hizkuntza taulatik Deskribapena eremua itzultzen du.
	 *
	 * @return ResultSet objektua, hizkuntza taularen Deskribapena eremua dituen
	 *         emaitza
	 * @throws SQLException SQL exekuzioan errore bat gertatzen bada
	 */
	public static ResultSet hizkuntza() throws SQLException {
		String SQLquery = "SELECT Deskribapena FROM hizkuntza";
		ResultSet emaitza = query.executeQuery(SQLquery);

		return emaitza;
	}

	/**
	 * Erregistroa egiten du erabiltzailea Free motako erabiltzailea izanik.
	 * 
	 * @param e_free Erabiltzailearen datuak gordetzeko E_Free objektua.
	 * @throws SQLException           SQL errorea gertatzen bada.
	 * @throws ClassNotFoundException Klasea ezin bada aurkitu.
	 */
	public static void erregistroaFree(Erabiltzailea e_free) throws SQLException, ClassNotFoundException {
		konexioaIreki();
		String iderab = e_free.getErabiltzailea() + "&";
		LocalDate currentdate = LocalDate.now();
		String datenow = currentdate.getYear() + "-" + currentdate.getMonthValue() + "-" + currentdate.getDayOfMonth();
		
		java.sql.Date sqlJaioDate = new java.sql.Date(e_free.getJaiotze_data().getTime());

		// INSERT-A EGIN
		try {
			String SQLquery = "INSERT INTO bezeroa (IdBezeroa, Izena, Abizena, Hizkuntza, Erabiltzailea, Pasahitza, Jaiotza_data, Erregistro_data) VALUES ('"
					+ iderab + "'," + "'" + e_free.getIzena() + "'," + "'" + e_free.getAbizena() + "'," + "'"
					+ e_free.getHizkuntza() + "'," + "'" + e_free.getErabiltzailea() + "'," + "'"
					+ e_free.getPasahitza() + "'," + "'" + sqlJaioDate + "'," + "'" + datenow + "')";
			query.executeUpdate(SQLquery);
			JOptionPane.showMessageDialog(null, "Ondo erregistratu egin zara!", "Erregistroa [Free]",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			if (e_free.getIzena().isEmpty() && e_free.getErabiltzailea().isEmpty() && e_free.getPasahitza().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Formularioa bete behar duzu erregistratzeko.", "Errorea",
						JOptionPane.ERROR_MESSAGE);
			} else {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Errorea egon da datu basean erregistratzean.", "Errorea",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		konexioaItxi();
	}

	/**
	 * ErregistroaPremium metodoa erabiltzailea Premium motako bezeroa
	 * erregistratzeko erabiltzen da.
	 * 
	 * @param e_premium E_Premium objektua, erabiltzailearen datuak gordetzeko
	 *                  erabiltzen da.
	 * @throws SQLException           SQL errorea gertatzen bada.
	 * @throws ClassNotFoundException Klasea ez bada aurkitzen.
	 */
	public static void erregistroaPremium(Erabiltzailea e_premium) throws SQLException, ClassNotFoundException {
		konexioaIreki();
		String iderab = e_premium.getErabiltzailea() + "&";

		LocalDate currentdate = LocalDate.now();
		String datenow = currentdate.getYear() + "-" + currentdate.getMonthValue() + "-" + currentdate.getDayOfMonth();
		// DATE-RA PASATU
		java.sql.Date sqlDate = new java.sql.Date(e_premium.getJaiotze_data().getTime());
		// INSERT-A EGIN BEZEROA
		try {
			String SQLquery = "INSERT INTO bezeroa (IdBezeroa, Izena, Abizena, Hizkuntza, Erabiltzailea, Pasahitza, Jaiotza_data, Erregistro_data, Mota) VALUES ('"
					+ iderab + "'," + "'" + e_premium.getIzena() + "'," + "'" + e_premium.getAbizena() + "'," + "'"
					+ e_premium.getHizkuntza() + "'," + "'" + e_premium.getErabiltzailea() + "'," + "'"
					+ e_premium.getPasahitza() + "'," + "'" + sqlDate + "'," + "'" + datenow + "','Premium')";
			query.executeUpdate(SQLquery);
			JOptionPane.showMessageDialog(null, "Ondo erregistratu egin zara Premium bezeroa bezala.", "Erregistroa [Premium]",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			if (e_premium.getIzena().isEmpty() && e_premium.getErabiltzailea().isEmpty()
					&& e_premium.getPasahitza().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Formularioa bete behar duzu erregistratzeko.", "Errorea",
						JOptionPane.ERROR_MESSAGE);
			} else {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Errorea egon da datu basean erregistratzean.", "Errorea",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		konexioaItxi();
	}
}
