package model.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * Konexioa klaseak datu-basearekin konexioa irekitzen du eta itxten du.
 * Datu-basearekin konexioa irekitzean, MySQL JDBC Driver erabiltzen da.
 * Konexioa irekitzen da URL, erabiltzailea eta pasahitzarekin. Konexioa
 * irekitzerakoan, datu-basearekin kontsulta egiteko aukera ematen duen objektua
 * sortzen da.
 * 
 */
public class Konexioa {
<<<<<<< HEAD
    
    private static final String URL = "jdbc:mysql://192.168.0.7:3306/db_JPamt7";
    private static String user = "administrador";
    private static String pass = "admin123";
=======
	
	private static final String URL = "jdbc:mysql://192.168.0.7:3306/db_JPamt7";
	private static String user = "administrador";
	private static String pass = "admin123";
>>>>>>> c6c518ac3615bc675e10c7e223600bdc22ed873a

    public static Connection konexioa;
    public static Statement query;

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
            konexioa = DriverManager.getConnection(URL, user, pass);
            query = konexioa.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
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
    
    public static boolean konexioaIrekiAdmin(String usertxt, String passwdtxt) {
        boolean kon = true;
        try {
            usertxt = "administrador";
            passwdtxt = "admin";
            Class.forName("com.mysql.cj.jdbc.Driver");
            konexioa = DriverManager.getConnection(URL, usertxt, pass);
            query = konexioa.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erabiltzaile hori ez dauka baimenik.", "Errorea",
                    JOptionPane.ERROR_MESSAGE);
            kon = false;
        }
        return kon;
    }
=======
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
	
	public static boolean konexioaIrekiAdmin(String usertxt, String passwdtxt) {
		boolean kon = true;
		try {
			usertxt = "administrador";
			passwdtxt = "admin";
			Class.forName("com.mysql.cj.jdbc.Driver");
			konexioa = DriverManager.getConnection(URL, usertxt, pass);
			query = konexioa.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erabiltzaile hori ez dauka baimenik.", "Errorea",
					JOptionPane.ERROR_MESSAGE);
			kon = false;
		}
		return kon;
	}
>>>>>>> c6c518ac3615bc675e10c7e223600bdc22ed873a

}