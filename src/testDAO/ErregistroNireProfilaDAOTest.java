package testDAO;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;

import model.Erabiltzailea;
import model.metodoak.SesioAldagaiak;
import model.sql.ErregistroNireProfilaDAO;
import salbuespenak.ErabiltzaileBalidazioaException;

public class ErregistroNireProfilaDAOTest {

	@Test
	public void testKonprabatuPremium_FreeUser() {
		SesioAldagaiak.bezeroa_logeatuta = new Erabiltzailea("admin", "admin", "EU", "EU", "EU", new Date());

		try {
			boolean erabil = ErregistroNireProfilaDAO.konprabatuPremium();
			assertFalse("Erabiltzailea Free izan behar da, baina Premium gisa kontsideratu da", erabil);
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Prueba zeharkatzean SQL salbuespena sortu da");
		}
	}

	@Test
	public void testKonprabatuPremium_PremiumUser() {
		SesioAldagaiak.bezeroa_logeatuta = new Erabiltzailea("analopez", "analopez", "EU", "EU", "EU", new Date());

		try {
			boolean erabil = ErregistroNireProfilaDAO.konprabatuPremium();
			System.out.println(erabil);
			assertTrue("Erabiltzailea Free izan behar da, baina Premium gisa kontsideratu da", erabil);
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Prueba zeharkatzean SQL salbuespena sortu da");
		}
	}

	@Test
	public void testUpdatePremiumBezeroFree_Success() {
		Erabiltzailea erabi = new Erabiltzailea("davidmartinez", "davidmartinez", "EU", "EU", "EU", new Date());
		try {
			ErregistroNireProfilaDAO.updatePremiumBezeroFree(erabi);
			assertEquals("premium", "premium");
		} catch (SQLException e) {

			fail("SQL salbuespena gertatu da: " + e.getMessage());
		}
	}

	@Test
	public void testUpdatePremiumBezeroFree_Failure() {
		Erabiltzailea erabi = new Erabiltzailea("erabiltzaile_berria", "erabiltzaile_berria", "EU", "EU", "EU",
				new Date());
		erabi.setErabiltzailea("erabiltzaile_berria");
		try {
			ErregistroNireProfilaDAO.updatePremiumBezeroFree(erabi);
			throw new SQLException("SQL salbuespena espero zen, baina ez da jaurtia");
		} catch (SQLException e) {
			assertEquals("SQL salbuespena espero zen, baina ez da jaurtia", e.getMessage());
		}
	}

	@Test
	public void testErregistroaFree_Success() throws ErabiltzaileBalidazioaException {
		Erabiltzailea e_free = new Erabiltzailea("izena&", "izena", "abizena", "EU", "EU", "EU", new Date());

		try {
			ErregistroNireProfilaDAO.erregistroaFree(e_free);
		} catch (SQLException | ClassNotFoundException e) {
			fail("Espero gabeko salbuespena gertatu da: " + e.getMessage());
		}
	}

	@Test
	public void testErregistroaPremium_Success() throws ErabiltzaileBalidazioaException {
		Erabiltzailea e_premium = new Erabiltzailea("izena&", "izena", "abizena", "EU", "EU", "EU", new Date());

		try {
			ErregistroNireProfilaDAO.erregistroaPremium(e_premium);
		} catch (SQLException | ClassNotFoundException e) {
			fail("Espero gabeko salbuespena gertatu da: " + e.getMessage());
		}
	}

	@Test
	public void testUpdateNireProfilaDatuak_Success() {
		Erabiltzailea erab = new Erabiltzailea("", "", "", "EU", "EU", new Date());

		try {
			ErregistroNireProfilaDAO.updateNireProfilaDatuak(erab);
			throw new SQLException("Eguneraketa huts egin da");
		} catch (SQLException e) {
			assertEquals("Eguneraketa huts egin da", e.getMessage());
		}
	}

}
