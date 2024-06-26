package model.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Konexioa klaseak datu-basearekin konexioa irekitzen du eta itxten du.
 * Datu-basearekin konexioa irekitzean, MySQL JDBC Driver erabiltzen da.
 * Konexioa irekitzen da URL, erabiltzailea eta pasahitzarekin. Konexioa
 * irekitzerakoan, datu-basearekin kontsulta egiteko aukera ematen duen objektua
 * sortzen da.
 * 
 */
public class Konexioa {
	
	private static final String URL = "jdbc:mysql://10.5.6.223:3306/db_JPamt7";
	private static final String USER = "administrador";
	private static final String PASS = "admin123";

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

}
