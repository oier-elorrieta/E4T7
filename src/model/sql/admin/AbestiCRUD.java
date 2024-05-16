package model.sql.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Abestia;
import model.metodoak.SesioAldagaiak;
import model.sql.Konexioa;

public class AbestiCRUD {

	public static ArrayList<Abestia> abestiIzenakKargatu() throws SQLException {
		Konexioa.konexioaIreki();
		ArrayList<Abestia> abestiList = new ArrayList<Abestia>();
		String SQLquery = "SELECT IdAudio, Izena, Iraupena FROM audio JOIN abestia using (IdAudio)";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		Abestia abestiAux = null;

		while (emaitza.next()) {
			abestiAux = new Abestia(emaitza.getString("IdAudio"), emaitza.getString("Izena"),
					emaitza.getString("Iraupena"));
			abestiList.add(abestiAux);
		}
		Konexioa.konexioaItxi();
		return abestiList;
	}

	public static void audioInsert(String izenaBerria, String iraupenBerria, int idAlbum) throws SQLException {
		Konexioa.konexioaIreki();

		String SQLquery = "INSERT INTO audio (Izena, Irudia, iraupena, Mota) VALUES ('" + izenaBerria
				+ "', FROM_BASE64('" + SesioAldagaiak.IrudiaBLOB + "'), '" + iraupenBerria + "', 'Abestia')";

		int idAudioBerria = -1;
		Konexioa.query.executeUpdate(SQLquery, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = Konexioa.query.getGeneratedKeys();
		if (rs.next()) {
			idAudioBerria = rs.getInt(1);
		}

		abestiInsert(idAudioBerria, idAlbum);

		Konexioa.konexioaItxi();
	}

	public static void abestiInsert(int idAudio, int idAlbum) throws SQLException {
		
		System.out.println(idAudio + " " + idAlbum);
		
		String SQLquery = "INSERT INTO abestia (IdAudio, IdAlbum) VALUES ('" + idAudio + "', '" + idAlbum + "')";
		Konexioa.query.executeUpdate(SQLquery);

	}

	public static void abestiDelete(Abestia abesti) throws SQLException {
		Konexioa.konexioaIreki();

		String SQLquery = "DELETE FROM audio WHERE IdAudio = '" + abesti.getIdAudio() + "'";
		Konexioa.query.executeUpdate(SQLquery);

		Konexioa.konexioaItxi();

	}

	public static void abestiUpdate(Abestia abesti, String izenBerria, String iraupenBerria) throws SQLException {
		Konexioa.konexioaIreki();

		String SQLquery = "UPDATE audio SET Izena = '" + izenBerria + "', " + "Iraupena = '" + iraupenBerria
				+ "' WHERE IdAudio = '" + abesti.getIdAudio() + "'";
		Konexioa.query.executeUpdate(SQLquery);

		Konexioa.konexioaItxi();
	}

}
