package model.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.*;

public class SQLKonexioa {
	// ALDAGAI ESTATIKOAK ETA FINALAK DEKLARATU KONEXIORAKO
	private static final String URL = "jdbc:mysql://localhost:3307/db_jpamt7";
	private static final String USER = "root";
	private static final String PASS = "";
	private static Connection konexioa;
	private static Statement query;
	private static Date jaiodata;
	
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
	
	public static void erregistroaFree(String iz, String ab, String hiz, String erab, String pass, String jai, String errg) throws SQLException, ClassNotFoundException {
		konexioaIreki();
		String iderab = erab + "&";
		// DATE-RA PASATU
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            jaiodata = formatter.parse(jai);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // INSERT-A EGIN
		try {
			String SQLquery = "INSERT INTO bezeroa (IdBezeroa, Izena, Abizena, Hizkuntza, Erabiltzailea, Pasahitza, Jaiotza_data, Erregistro_data) VALUES ('"+iderab+"',"+"'"+iz+"',"+"'"+ab+"',"+"'"+hiz+"',"+"'"+erab+"',"+"'"+pass+"',"+"'"+jai+"',"+ "'"+errg+"')";
			query.executeUpdate(SQLquery);
			JOptionPane.showMessageDialog(null, "Ondo erregistratu egin zara!", "Erregistroa", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			if (iz.isEmpty() && erab.isEmpty() && pass.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Formularioa bete behar duzu erregistratzeko.", "Errorea", JOptionPane.ERROR_MESSAGE);
			} else {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Errorea egon da datu basean erregistratzean.", "Errorea", JOptionPane.ERROR_MESSAGE);
			}
		}
		konexioaItxi();
		
		Erabiltzailea erabiltzaile_erregistro_free = new E_Free(erab, pass, iz, ab, jaiodata);
		
		
		
	}
	
	public static void erregistroaPremium(String iz, String ab, String hiz, String erab, String pass, String jai, String errg) throws SQLException, ClassNotFoundException {
		konexioaIreki();
		String iderab = erab + "&";
		// DATE-RA PASATU
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            jaiodata = formatter.parse(jai);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // INSERT-A EGIN
		try {
			String SQLquery = "INSERT INTO bezeroa (IdBezeroa, Izena, Abizena, Hizkuntza, Erabiltzailea, Pasahitza, Jaiotza_data, Erregistro_data, Mota) VALUES ('"+iderab+"',"+"'"+iz+"',"+"'"+ab+"',"+"'"+hiz+"',"+"'"+erab+"',"+"'"+pass+"',"+"'"+jai+"',"+ "'"+errg+"','Premium')";
			query.executeUpdate(SQLquery);
			JOptionPane.showMessageDialog(null, "Ondo erregistratu egin zara!", "Erregistroa", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			if (iz.isEmpty() && erab.isEmpty() && pass.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Formularioa bete behar duzu erregistratzeko.", "Errorea", JOptionPane.ERROR_MESSAGE);
			} else {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Errorea egon da datu basean erregistratzean.", "Errorea", JOptionPane.ERROR_MESSAGE);
			}
		}
		konexioaItxi();
		
		Erabiltzailea erabiltzaile_erregistro_premium = new E_Premium(erab, pass, iz, ab, jaiodata);
		
		
		
	}
}
