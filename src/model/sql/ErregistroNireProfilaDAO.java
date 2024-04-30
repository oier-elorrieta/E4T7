package model.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import model.Erabiltzailea;
import model.metodoak.SesioAldagaiak;

public class ErregistroNireProfilaDAO {
	public static boolean konprabatuPremium() throws SQLException {
		Konexioa.konexioaIreki();
		String SQLquery = "SELECT Mota FROM bezeroa WHERE Erabiltzailea LIKE '"
				+ SesioAldagaiak.bezero_Ondo.getErabiltzailea() + "'";

		try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			
			while (resultSet.next()) {
				String mota = resultSet.getString("Mota");
				if (mota.equals("Free")) {
					return false;
				} 
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Konexioa.konexioaItxi();
		}

		return true;	
	}
	
	public static String premiumIraungintzeData() throws SQLException {
		Konexioa.konexioaIreki();
		String SQLquery = "SELECT Mota FROM bezeroa WHERE Erabiltzailea LIKE '"
				+ SesioAldagaiak.bezero_Ondo.getErabiltzailea() + "'";

		try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			
			while (resultSet.next()) {
				String mota = resultSet.getString("Mota");
				if (mota.equals("Free")) {
					return false;
				} 
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Konexioa.konexioaItxi();
		}

		return true;	
	}

	/**
	 * Erregistroa egiten du erabiltzailea Free motako erabiltzailea izanik.
	 * 
	 * @param e_free Erabiltzailearen datuak gordetzeko E_Free objektua.
	 * @throws SQLException           SQL errorea gertatzen bada.
	 * @throws ClassNotFoundException Klasea ezin bada aurkitu.
	 */
	public static void erregistroaFree(Erabiltzailea e_free) throws SQLException, ClassNotFoundException {
		Konexioa.konexioaIreki();
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
			Konexioa.query.executeUpdate(SQLquery);
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
		Konexioa.konexioaItxi();
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
		Konexioa.konexioaIreki();
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
			Konexioa.query.executeUpdate(SQLquery);
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
		Konexioa.konexioaItxi();
	}
	
	public static void updateNireProfilaDatuak () {
		Konexioa.konexioaIreki();
		
		
		
		Konexioa.konexioaItxi();
	}
}
