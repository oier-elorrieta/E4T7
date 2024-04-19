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
	
	public static String loginKonexioa(String user, String passwd) throws SQLException {
		String SQLquery = "SELECT Erabiltzailea, Pasahitza FROM bezeroa WHERE Erabiltzailea LIKE '"+ user + "'";
		ResultSet emaitza = query.executeQuery(SQLquery);
		
		while (emaitza.next()) {
			if (emaitza.getString("Erabiltzailea").equals("admin")) {
				return "Admin";
			}
			if (emaitza.getString("Erabiltzailea").equals(user) && emaitza.getString("Pasahitza").equals(passwd)) {
				return "Bezeroa";
			}
		}
		return "Txarto";
	}
	
	public static ResultSet hizkuntza() throws SQLException {
		String SQLquery = "SELECT Deskribapena FROM hizkuntza";
		ResultSet emaitza = query.executeQuery(SQLquery);
		
		return emaitza;
	}
	
	public static void erregistroa(String iz, String ab, String hiz, String erab, String pass, String jai, String errg) throws SQLException, ClassNotFoundException {
		konexioaIreki();
		String iderab = erab + "&";
		try {
			String SQLquery = "INSERT INTO bezeroa (IdBezeroa, Izena, Abizena, Hizkuntza, Erabiltzailea, Pasahitza, Jaiotza_data, Erregistro_data) VALUES ('"+iderab+"',"+"'"+iz+"',"+"'"+ab+"',"+"'"+hiz+"',"+"'"+erab+"',"+"'"+pass+"',"+"'"+jai+"',"+ "'"+errg+"')";
			query.executeUpdate(SQLquery);
			System.out.println("ERREGSITRATUTA");
		} catch (SQLException e) {	
			e.printStackTrace();
			System.out.println("ERROREA");
		}
		
		konexioaItxi();
	}
}
