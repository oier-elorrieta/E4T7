package testDAO;

	import static org.junit.Assert.*;
	import org.junit.Test;
	import java.sql.SQLException;
	import java.util.Date;
	import model.E_Free;
	import model.E_Premium;
	import model.Erabiltzailea;
	import model.sql.LoginDAO;

	public class LoginDAOTest {

	    @Test
	    public void testLoginKonexioaFreeUser() throws SQLException {
	        String username = "admin";
	        String password = "12345";
	        Erabiltzailea user = LoginDAO.loginKonexioa(username, password);

	        assertNotNull(user);
	        assertTrue(user instanceof E_Free);

	    }

	    @Test
	    public void testLoginKonexioaPremiumUser() throws SQLException {
	        String username = "analopez";
	        String password = "123456";

	        Erabiltzailea user = LoginDAO.loginKonexioa(username, password);

	        assertNotNull(user);
	        assertTrue(user instanceof E_Premium);

	    }

	    @Test
	    public void testIraungitzeDataLortu() throws SQLException {
	        String username = "analopez";
	        Date expirationDate = LoginDAO.iraungitzeDataLortu(username);

	        assertNotNull(expirationDate);
	    }
	}


