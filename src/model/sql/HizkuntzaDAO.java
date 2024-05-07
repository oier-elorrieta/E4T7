package model.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Hizkuntza;

public class HizkuntzaDAO {
	/**
	 * Metodo honek hizkuntza taulatik Deskribapena eremua itzultzen du.
	 *
	 * @return ResultSet objektua, hizkuntza taularen Deskribapena eremua dituen
	 *         emaitza
	 * @throws SQLException SQL exekuzioan errore bat gertatzen bada
	 */
	public static ArrayList<Hizkuntza> hizkuntza() throws SQLException {
		Konexioa.konexioaIreki();
		ArrayList<Hizkuntza> hizkuntzak = new ArrayList<Hizkuntza>();
		String SQLquery = "SELECT * FROM hizkuntza";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		Hizkuntza hAux;
		
		while (emaitza.next()) {
			hAux = new Hizkuntza(emaitza.getString("IdHizkuntza"), emaitza.getString("Deskribapena"));
			hizkuntzak.add(hAux);
	    }
		Konexioa.konexioaItxi();
		return hizkuntzak;
	}

}
