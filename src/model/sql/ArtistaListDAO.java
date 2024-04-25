package model.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Artista;
import model.Musikaria;
import model.metodoak.SesioAldagaiak;

public class ArtistaListDAO {
	public static ArrayList<Artista> artistakKargatu() throws SQLException {

		ArrayList<Artista> artistakList = new ArrayList<Artista>();
		String SQLquery = "SELECT * FROM musikaria_erreprodukzioak";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		Artista artistAux = null;
		
		while (emaitza.next()) {
			artistAux = new Musikaria(emaitza.getString("IzenArtistikoa"), emaitza.getInt("count(*)"));
			artistakList.add(artistAux);
		}
		
		
		return artistakList;
	}
}
