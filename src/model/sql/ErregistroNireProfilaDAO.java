package model.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import model.Erabiltzailea;
import model.metodoak.JFrameSortu;
import model.metodoak.SesioAldagaiak;
import model.metodoak.View_metodoak;
import salbuespenak.ErabiltzaileBalidazioaException;

/**
 * ErregistroNireProfilaDAO klaseak datu basearekin eragiketak egiten ditu
 * erabiltzailearen profila erregistratzeko.
 * 
 */
public class ErregistroNireProfilaDAO {
	
	/**
	 * Erabiltzailea datu basean dagoen ala ez konprobatzeko metodoa.
	 * 
	 * @param erab Erabiltzailea objektua.
	 * @return True, erabiltzailea datu basean badago.
	 * @throws SQLException SQL errorea gertatzen bada.
	 */
	public static boolean konprobatuErabiltzailea(String erab) throws SQLException {
		Konexioa.konexioaIreki();
		String SQLquery = "SELECT Erabiltzailea FROM bezeroa WHERE Erabiltzailea LIKE '" + erab + "'";
		try (PreparedStatement preparedStatement = Konexioa.konexioa.prepareStatement(SQLquery);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Konexioa.konexioaItxi();
		}
		return false;
	}
	
	/**
	 * Konprobatu erabiltzailea Free motako erabiltzailea den ala ez.
	 * 
	 * @return True, Free motako erabiltzailea bada.
	 * @throws SQLException SQL errorea gertatzen bada.
	 */
	public static boolean konprabatuPremium() throws SQLException {
		Konexioa.konexioaIreki();
		String SQLquery = "SELECT Mota FROM bezeroa WHERE Erabiltzailea LIKE '"
				+ SesioAldagaiak.bezeroa_logeatuta.getErabiltzailea() + "'";

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
	 * Bezero bat Free motakoa bada, Premium motakoa bihurtu.
	 * 
	 * @return True, Free motako erabiltzailea bada.
	 * @throws SQLException SQL errorea gertatzen bada.
	 */
	public static void updatePremiumBezeroFree(Erabiltzailea erab) throws SQLException {
		Konexioa.konexioaIreki();
		String SQLquery = "UPDATE bezeroa SET mota = 'Premium' WHERE Erabiltzailea = '" + erab.getErabiltzailea() + "';";
		Konexioa.query.executeUpdate(SQLquery);
		if (Konexioa.query.executeUpdate(SQLquery) == 1) {
			JOptionPane.showMessageDialog(null, "Orain Premium bezeroa zara! Ongi etorri!", "Premium erosketa",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Ezin izan da zure profila aldatu!", "Errorea",
					JOptionPane.ERROR_MESSAGE);
		}
		Konexioa.konexioaItxi(); 
	}
	
	/**
	 * Erregistroa egiten du erabiltzailea Free motako erabiltzailea izanik.
	 * 
	 * @param e_free Erabiltzailearen datuak gordetzeko E_Free objektua.
	 * @throws SQLException           SQL errorea gertatzen bada.
	 * @throws ClassNotFoundException Klasea ezin bada aurkitu.
	 * @throws ErabiltzaileBalidazioaException 
	 */
	public static void erregistroaFree(Erabiltzailea e_free) throws SQLException, ClassNotFoundException, ErabiltzaileBalidazioaException {
		Konexioa.konexioaIreki();
		String iderab = e_free.getErabiltzailea() + "&";
		System.out.println(iderab);
		e_free.setIdBezeroa(iderab);
		LocalDate currentdate = LocalDate.now();
		String datenow = currentdate.getYear() + "-" + currentdate.getMonthValue() + "-" + currentdate.getDayOfMonth();
		
		java.sql.Date sqlJaioDate = new java.sql.Date(e_free.getJaiotze_data().getTime());

		// INSERT-A EGIN
		try {
			String SQLquery = "INSERT INTO bezeroa (IDBezeroa, Izena, Abizena, Hizkuntza, Erabiltzailea, Pasahitza, Jaiotza_data, Erregistro_data, Mota) VALUES ('"
					+ iderab + "'," + "'" + e_free.getIzena() + "'," + "'" + e_free.getAbizena() + "'," + "'"
					+ e_free.getHizkuntza() + "'," + "'" + e_free.getErabiltzailea() + "'," + "'"
					+ e_free.getPasahitza() + "'," + "'" + sqlJaioDate + "'," + "'" + datenow + "','Free')";
			Konexioa.query.executeUpdate(SQLquery);
			JOptionPane.showMessageDialog(null, "Ondo erregistratu egin zara!", "Erregistroa [Free]",
					JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException e) {
	        if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062) {
	            throw new ErabiltzaileBalidazioaException();
	        } else if (e_free.getIzena().isEmpty() && e_free.getErabiltzailea().isEmpty() && e_free.getPasahitza().isEmpty()) {
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
	 * @throws ErabiltzaileBalidazioaException 
	 */
	public static void erregistroaPremium(Erabiltzailea e_premium) throws SQLException, ClassNotFoundException, ErabiltzaileBalidazioaException {
	    Konexioa.konexioaIreki();
	    String iderab = e_premium.getErabiltzailea() + "&";

	    LocalDate currentdate = LocalDate.now();
	    String datenow = currentdate.getYear() + "-" + currentdate.getMonthValue() + "-" + currentdate.getDayOfMonth();
	    // DATE-RA PASATU
	    java.sql.Date sqlDate = new java.sql.Date(e_premium.getJaiotze_data().getTime());
	    // INSERT-A EGIN BEZEROA
	    try {
	        String SQLquery = "INSERT INTO bezeroa (IDBezeroa, Izena, Abizena, Hizkuntza, Erabiltzailea, Pasahitza, Jaiotza_data, Erregistro_data, Mota) VALUES ('"
	                + iderab + "'," + "'" + e_premium.getIzena() + "'," + "'" + e_premium.getAbizena() + "'," + "'"
	                + e_premium.getHizkuntza() + "'," + "'" + e_premium.getErabiltzailea() + "'," + "'"
	                + e_premium.getPasahitza() + "'," + "'" + sqlDate + "'," + "'" + datenow + "','Premium')";
	        Konexioa.query.executeUpdate(SQLquery);
	        JOptionPane.showMessageDialog(null, "Ondo erregistratu egin zara Premium bezeroa bezala.", "Erregistroa [Premium]",
	                JOptionPane.INFORMATION_MESSAGE);
	    } catch (SQLException e) {
	    	//
	        if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062) {
	            throw new ErabiltzaileBalidazioaException();
	            
	        } else if (e_premium.getIzena().isEmpty() && e_premium.getErabiltzailea().isEmpty() && e_premium.getPasahitza().isEmpty()) {
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
	 * Erabiltzailearen datuak eguneratzeko metodoa.
	 * 
	 * @param erab Erabiltzailearen datuak gordetzeko Erabiltzailea objektua.
	 * @throws SQLException SQL errorea gertatzen bada.
	 */
	public static void updateNireProfilaDatuak (Erabiltzailea erab) throws SQLException {
		Konexioa.konexioaIreki();
		String SQLquery = "UPDATE bezeroa SET Izena = '" + erab.getIzena() + "', Abizena = '" + erab.getAbizena() + "', Hizkuntza = '" + erab.getHizkuntza() + "', Erabiltzailea = '" + erab.getErabiltzailea() 
		+ "', Pasahitza = '" + erab.getPasahitza() + "', Jaiotza_data = '" + View_metodoak.dateToString(erab.getJaiotze_data())
		+ "' WHERE Erabiltzailea = '" + erab.getErabiltzailea() + "';";
		Konexioa.query.executeUpdate(SQLquery);
		if (Konexioa.query.executeUpdate(SQLquery) == 1) {
			JOptionPane.showMessageDialog(null, "Profilaren edizioak gorde dira!", "Profilaren edizioa",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Ezin izan da zure profila aldatu!", "Errorea",
					JOptionPane.ERROR_MESSAGE);
		}
		
		Konexioa.konexioaItxi();
	}
}
