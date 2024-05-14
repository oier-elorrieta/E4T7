package testDAO;

	import static org.junit.Assert.*;
	import org.junit.Test;
	import java.sql.SQLException;
	import java.util.Date;
	import model.E_Free;
	import model.E_Premium;
	import model.Erabiltzailea;
import model.metodoak.View_metodoak;
import model.sql.LoginDAO;

	public class LoginDAOTest {

	    @Test
	    public void testLoginKonexioaFreeUser() throws SQLException {
	        String idBezeroa = "admin&";
	        String username = "admin";
	        String password = "12345";
	        Erabiltzailea user = LoginDAO.loginKonexioa(username, password);

	        // Erabiltzailea mota Free da beraz E_Free objektua itzuli behar du.
	        assertTrue(user instanceof E_Free);
	        
	        assertEquals(idBezeroa, user.getIdBezeroa());
	        assertEquals("admin", user.getErabiltzailea());
	        assertEquals("12345", user.getPasahitza());

	    }

	    @Test
	    public void testLoginKonexioaPremiumUser() throws SQLException {
	        String idBezeroa = "analopez&";
	        String username = "analopez";
	        String password = "123456"; 

	        Erabiltzailea user = LoginDAO.loginKonexioa(username, password);

	        // Erabiltzailea mota Premium da beraz E_Premium objektua itzuli behar du.
	        assertTrue(user instanceof E_Premium);
	        
	        assertEquals(idBezeroa, user.getIdBezeroa());
	        assertEquals("analopez", user.getErabiltzailea());
	        assertEquals("123456", user.getPasahitza());

	    }

	    @Test
	    public void testIraungitzeDataLortu() throws SQLException {
	    	@SuppressWarnings("deprecation")
			E_Premium user = new E_Premium("analopez&", "analopez", "123456", "Ana", "Lopez", "es", new Date(), new Date(125,4,13)); 
	    	String iraungitzeDataStringTest = View_metodoak.dateToString(user.getIraungintze_data());
	        Date iraungitzeData = LoginDAO.iraungitzeDataLortu(user.getErabiltzailea());
	    	String iraungitzeDataString = View_metodoak.dateToString(iraungitzeData);
	        assertEquals(iraungitzeDataStringTest, iraungitzeDataString);   
	        
	    }
	}


