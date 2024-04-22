package model.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	public static Erabiltzailea loginKonexioa(String user, String passwd) throws SQLException {
		
		Erabiltzailea e1 = null;
		String SQLquery = "SELECT Erabiltzailea, Pasahitza, Mota, Izena, Abizena, Hizkuntza, Jaiotza_data FROM bezeroa WHERE Erabiltzailea LIKE '"+ user + "' AND Pasahitza = '" + passwd + "'";

		try (PreparedStatement preparedStatement = konexioa.prepareStatement(SQLquery);
		        ResultSet resultSet = preparedStatement.executeQuery()) {
		
		       while (resultSet.next()) {
			   		String erabiltzailea = resultSet.getString("Erabiltzailea");
			        String pasahitza = resultSet.getString("Pasahitza");
			        String mota = resultSet.getString("Mota");
			        
			        String izena = resultSet.getString("Izena");
			        String abizena = resultSet.getString("Abizena");
			        String hizkuntza = resultSet.getString("Hizkuntza");
			        Date jaioData = resultSet.getDate("Jaiotza_data");

			        					
					if (mota.equals("Free")) {
						E_Free f1 = new E_Free(erabiltzailea, pasahitza, izena, abizena, hizkuntza, jaioData);
						e1 = f1;
					}else {
						E_Premium p1 = new E_Premium(erabiltzailea, pasahitza, izena, abizena, hizkuntza, jaioData, IraungitzeDataLortu(erabiltzailea));
						e1 = p1;
					}

		       }
		
		   } catch (SQLException e) {
		       e.printStackTrace();
		   } finally {
			   konexioaItxi();
		   }		
		
		return e1;
	}
	
	public static Date IraungitzeDataLortu (String erabiltzailea) {
		
		Date IraungitzeData = null;
		
		String SQLquery = "SELECT Iraungitze_data FROM premium WHERE Erabiltzailea LIKE '"+ erabiltzailea + "'";
		
		try (PreparedStatement preparedStatement = konexioa.prepareStatement(SQLquery);
		        ResultSet resultSet = preparedStatement.executeQuery()) {
		      	
			   	IraungitzeData = resultSet.getDate("Iraungitze_data");
			   	
			   	
		   } catch (SQLException e) {
		       e.printStackTrace();
		   } 	
		
		return IraungitzeData;

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
}
