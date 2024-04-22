package model.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import model.*;
import model.metodoak.SesioAldagaiak;

public class SQLKonexioa {
	// ALDAGAI ESTATIKOAK ETA FINALAK DEKLARATU KONEXIORAKO
	private static final String URL = "jdbc:mysql://localhost:3307/db_jpamt7";
	private static final String USER = "root";
	private static final String PASS = "";
	private static Connection konexioa;
	private static Statement query;
	private static Date jaiodata;
	public static Erabiltzailea erabiltzaile_erregistro_free;
	public static Erabiltzailea erabiltzaile_erregistro_premium;
	
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
	
	public static ResultSet loginKonexioa(String user, String passwd) throws SQLException {
		konexioaIreki();
		String SQLquery = "SELECT IDBezeroa, Erabiltzailea, Pasahitza, Mota FROM bezeroa WHERE Erabiltzailea LIKE '"+ user + "'";
		ResultSet emaitza = query.executeQuery(SQLquery);
		konexioaItxi();
		
		return emaitza;
	}
	
	public static ResultSet hizkuntza() throws SQLException {
		String SQLquery = "SELECT Deskribapena FROM hizkuntza";
		ResultSet emaitza = query.executeQuery(SQLquery);
		
		return emaitza;
	}

	public static void erregistroaFree(E_Free e_free) throws SQLException, ClassNotFoundException {
		konexioaIreki();
		String iderab = e_free.getErabiltzailea() + "&";
		LocalDate currentdate = LocalDate.now();
		String datenow = currentdate.getYear() + "-" + currentdate.getMonthValue() + "-" + currentdate.getDayOfMonth();

		java.sql.Date sqlJaioDate = new java.sql.Date(e_free.getJaiotze_data().getTime());
		
        // INSERT-A EGIN
		try {
			String SQLquery = "INSERT INTO bezeroa (IdBezeroa, Izena, Abizena, Hizkuntza, Erabiltzailea, Pasahitza, Jaiotza_data, Erregistro_data) VALUES ('"+iderab+"',"+"'"+e_free.getIzena()+"',"+"'"+e_free.getAbizena()+"',"+"'"+e_free.getHizkuntza()+"',"+"'"+e_free.getErabiltzailea()+"',"+"'"+e_free.getPasahitza()+"',"+"'"+sqlJaioDate+"',"+ "'"+datenow+"')";
			query.executeUpdate(SQLquery);
			JOptionPane.showMessageDialog(null, "[Free] Ondo erregistratu egin zara!", "Erregistroa", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			if (e_free.getIzena().isEmpty() && e_free.getErabiltzailea().isEmpty() && e_free.getPasahitza().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Formularioa bete behar duzu erregistratzeko.", "Errorea", JOptionPane.ERROR_MESSAGE);
			} else {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Errorea egon da datu basean erregistratzean.", "Errorea", JOptionPane.ERROR_MESSAGE);
			}
		}
		konexioaItxi();
	}
	
	public static void erregistroaPremium(E_Premium e_premium) throws SQLException, ClassNotFoundException {
		konexioaIreki();
		String iderab = e_premium.getErabiltzailea() + "&";
		
		LocalDate currentdate = LocalDate.now();
		String datenow = currentdate.getYear() + "-" + currentdate.getMonthValue() + "-" + currentdate.getDayOfMonth();
		// DATE-RA PASATU
		java.sql.Date sqlJaioDate = new java.sql.Date(e_premium.getJaiotze_data().getTime());
       
        // INSERT-A EGIN BEZEROA
		try {
			String SQLquery = "INSERT INTO bezeroa (IdBezeroa, Izena, Abizena, Hizkuntza, Erabiltzailea, Pasahitza, Jaiotza_data, Erregistro_data, Mota) VALUES ('"+iderab+"',"+"'"+e_premium.getIzena()+"',"+"'"+e_premium.getAbizena()+"',"+"'"+e_premium.getHizkuntza()+"',"+"'"+e_premium.getErabiltzailea()+"',"+"'"+e_premium.getPasahitza()+"',"+"'"+sqlJaioDate+"',"+ "'"+datenow+"','Premium')";
			query.executeUpdate(SQLquery);
			JOptionPane.showMessageDialog(null, "[Premium] Ondo erregistratu egin zara!", "Erregistroa", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			if (e_premium.getIzena().isEmpty() && e_premium.getErabiltzailea().isEmpty() && e_premium.getPasahitza().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Formularioa bete behar duzu erregistratzeko.", "Errorea", JOptionPane.ERROR_MESSAGE);
			} else {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Errorea egon da datu basean erregistratzean.", "Errorea", JOptionPane.ERROR_MESSAGE);
			}
		}
		konexioaItxi();
	}
	
	/*public static Erabiltzailea konprobatuUserMota(String user) throws SQLException {
			String IDb = "";
			konexioaIreki();
			String SQLquery = "SELECT IDBezeroa, Mota FROM bezeroa WHERE Erabiltzailea LIKE '"+ user + "'";
			ResultSet emaitza1 = query.executeQuery(SQLquery);
			
			while (emaitza1.next()) {
				if(emaitza1.getString("Mota").equals("Premium")) {
					IDb = emaitza1.getString("IDBezeroa");
					String SQLquery2 = "SELECT IDBezeroa FROM premium WHERE IDBezeroa LIKE '"+ IDb + "'";
					ResultSet emaitza2 = query.executeQuery(SQLquery);
				}
			}
			konexioaItxi();
			//SesioAldagaiak.erabiltzaile_free();
	}*/
}
