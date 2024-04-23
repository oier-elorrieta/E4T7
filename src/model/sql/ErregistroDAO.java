package model.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import model.E_Free;
import model.E_Premium;
import model.Erabiltzailea;
import model.metodoak.SesioAldagaiak;

public class ErregistroDAO {
	public static boolean konprabatuPremium() throws SQLException {
		SQLInterakzioa.konexioaIreki();
		Erabiltzailea e1 = null;
		String SQLquery = "SELECT  Mota FROM bezeroa WHERE Erabiltzailea LIKE '"
				+ SesioAldagaiak.bezero_Ondo.getErabiltzailea() + "'";

		try (PreparedStatement preparedStatement = SQLInterakzioa.konexioa.prepareStatement(SQLquery);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				String mota = resultSet.getString("Mota");
				if (mota.equals("Free")) {
					return false;
				} 
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLInterakzioa.konexioaItxi();
		}

		return true;	
	}
}
