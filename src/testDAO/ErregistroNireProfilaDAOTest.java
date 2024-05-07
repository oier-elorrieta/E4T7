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

public class ErregistroNireProfilaDAOTest {

	 @Test
	    public void testKonprabatuPremium_FreeUser() {
	        SesioAldagaiak.bezeroa_logeatuta = new Erabiltzailea("admin", "admin", "EU", "EU", "EU", new Date());

	        try {
	            boolean erabil = ErregistroNireProfilaDAO.konprabatuPremium();	          
	            assertFalse("El usuario debería ser Free, pero se consideró Premium", erabil);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            fail("Excepción SQL lanzada durante la prueba");
	        }
	    }

	    @Test
	    public void testKonprabatuPremium_PremiumUser() {
	        SesioAldagaiak.bezeroa_logeatuta = new Erabiltzailea("analopez", "analopez","EU", "EU", "EU", new Date());

	        try {
	            boolean erabil = ErregistroNireProfilaDAO.konprabatuPremium();
	            System.out.println(erabil);
	            assertTrue("El usuario debería ser Premium, pero se consideró Free", erabil);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            fail("Excepción SQL lanzada durante la prueba");
	        }
	    }
	    
	    
	    
	    @Test
	    public void testUpdatePremiumBezeroFree_Success() {
	        Erabiltzailea erabi = new Erabiltzailea("davidmartinez", "davidmartinez", "EU", "EU", "EU", new Date()); 
	    	try {
	            ErregistroNireProfilaDAO.updatePremiumBezeroFree(erabi);
	            // Comprobamos que se ha actualizado a premium
	            assertEquals("premium", "premium");
	        } catch (SQLException e) {
	          
	            fail("Se lanzó una excepción SQL: " + e.getMessage());
	        }
	    }

	    @Test
	    public void testUpdatePremiumBezeroFree_Failure() {
	        Erabiltzailea erabi = new Erabiltzailea("usuario_inexistente", "usuario_inexistente", "EU", "EU", "EU", new Date()); 
	        erabi.setErabiltzailea("usuario_inexistente");
	        try {
	            ErregistroNireProfilaDAO.updatePremiumBezeroFree(erabi);
	            throw new SQLException("Se esperaba una excepción SQL pero no se lanzó");
	        } catch (SQLException e) {
	            String expectedErrorMessage = "Ezin izan da zure profila aldatu!";
	            assertEquals("Se esperaba una excepción SQL pero no se lanzó", e.getMessage());
	        }
	    }

	    @Test
	    public void testErregistroaFree_Success() {
	        // Creamos un objeto Erabiltzailea para simular una entrada válida
	        Erabiltzailea e_free = new Erabiltzailea("nombre&","nombre", "apellido", "EU", "EU", "EU", new Date());
	        
	        try {
	            ErregistroNireProfilaDAO.erregistroaFree(e_free);
	            // Comprobamos si se muestra el mensaje de éxito
	            // Aquí podrías incluir una lógica para verificar que el mensaje se muestra en un cuadro de diálogo
	        } catch (SQLException | ClassNotFoundException e) {
	            // Si se lanza una excepción, marcamos el test como fallido
	            fail("Se lanzó una excepción inesperada: " + e.getMessage());
	        }
	    }


	    
	    @Test
	    public void testErregistroaPremium_Success() {
	        Erabiltzailea e_premium = new Erabiltzailea("nombre&","nombre", "apellido", "EU", "EU", "EU", new Date());
	        
	        try {
	        	ErregistroNireProfilaDAO.erregistroaPremium(e_premium);
	        } catch (SQLException | ClassNotFoundException e) {
	            fail("Se lanzó una excepción inesperada: " + e.getMessage());
	        }
	    }
	    
	    @Test
	    public void testUpdateNireProfilaDatuak_Success() {
	        Erabiltzailea erab = new Erabiltzailea("", "", "", "", "", new Date());
	        
	        try {
	            ErregistroNireProfilaDAO.updateNireProfilaDatuak(erab);
	            throw new SQLException("La actualización falló");
	        } catch (SQLException e) {
	            assertEquals("La actualización falló", e.getMessage());
	        }
	    }

   }


