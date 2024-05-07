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
	        String username = "testUser";
	        String password = "testPassword";
	        Erabiltzailea user = LoginDAO.loginKonexioa(username, password);

	        assertNotNull(user);
	        assertTrue(user instanceof E_Free);

	    }

	    @Test
	    public void testLoginKonexioaPremiumUser() throws SQLException {
	        String username = "premiumUser";
	        String password = "premiumPassword";

	        Erabiltzailea user = LoginDAO.loginKonexioa(username, password);

	        assertNotNull(user);
	        assertTrue(user instanceof E_Premium);

	    }

	    @Test
	    public void testIraungitzeDataLortu() throws SQLException {
	        String username = "premiumUser";
	        Date expirationDate = LoginDAO.iraungitzeDataLortu(username);

	        assertNotNull(expirationDate);
	    }
	}


