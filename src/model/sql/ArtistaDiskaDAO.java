package model.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.*;
import model.metodoak.SesioAldagaiak;

public class ArtistaDiskaDAO {
	public static ArrayList<Album> artistakKargatu() throws SQLException {

		ArrayList<Album> albumList = new ArrayList<Album>();
		String SQLquery = "SELECT Izena,  FROM audio";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		Album albuma = null;
		
		while (emaitza.next()) {
			Audio audioAux = new Audio(emaitza.getString("IzenArtistikoa"), emaitza.getInt("count(*)"));
			
		}
		
		
		return albumList;
	}
}
