package model.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLKonexioa {
	// ALDAGAI ESTATIKOAK ETA FINALAK DEKLARATU KONEXIORAKO
	private static final String URL = "jdbc:mysql://localhost:3307/db_jpamt7";
	private static final String USER = "root";
	private static final String PASS = "";
	private static Connection konexioa;
	private static Statement query;
	
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
	
	public static void konexioaItxi() {
		try {
			konexioa.close();
			query.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean prueba(String user, String passwd) throws SQLException {
		String SQLquery = "SELECT Erabiltzailea, Pasahitza FROM bezeroa WHERE Erabiltzailea LIKE '"+ user + "'";
		ResultSet emaitza = query.executeQuery(SQLquery);
		
		while (emaitza.next()) {
			if (emaitza.getString("Erabiltzailea").equals(user) && emaitza.getString("Pasahitza").equals(passwd)) {
				return true;
			}
		}
		return false;
	}
}
