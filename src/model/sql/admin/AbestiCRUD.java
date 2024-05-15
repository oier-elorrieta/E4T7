package model.sql.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Abestia;
import model.sql.Konexioa;

public class AbestiCRUD {
	
	public static ArrayList<Abestia> abestiIzenakKargatu() throws SQLException {
		Konexioa.konexioaIreki();
		ArrayList<Abestia> abestiList = new ArrayList<Abestia>();
		String SQLquery = "SELECT IdAudio, Izena, Iraupena FROM audio JOIN abestia using (IdAudio)";
		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
		Abestia abestiAux = null;

		while (emaitza.next()) {
			abestiAux = new Abestia(emaitza.getString("IdAudio"), emaitza.getString("Izena"), emaitza.getString("Iraupena"));
			abestiList.add(abestiAux);
		}
		Konexioa.konexioaItxi();
		return abestiList;
	}
//
//	public static void abestiInsert(Abestia abestiBerria, String idMusikari) throws SQLException {
//		Konexioa.konexioaIreki();
//
//		String SQLquery = "INSERT INTO abesti (Izenburua, Urtea, Generoa, IDMusikaria) " + "VALUES ('" + abestiBerria.getIzenburua() + "', '"
//                + abestiBerria.getUrtea() + "', '" + abestiBerria.getGeneroa() + "', '" + idMusikari + "')";
//		Konexioa.query.executeUpdate(SQLquery);
//
//		Konexioa.konexioaItxi();
//	}
//
//	public static void abestiDelete(Abestia abesti) throws SQLException {
//		Konexioa.konexioaIreki();
//
//		int idAbesti = abestiIDLortu(abesti);
//
//		String SQLquery = "DELETE FROM abesti WHERE IdAbesti = '" + idAbesti + "'";
//		Konexioa.query.executeUpdate(SQLquery);
//
//		Konexioa.konexioaItxi();
//
//	}
//
//	public static void abestiUpdate(Abestia abesti, Abestia abestiBerria) throws SQLException {
//        Konexioa.konexioaIreki();
//
//        int idAbesti = abestiIDLortu(abesti);
//        
//        String SQLquery = "UPDATE abesti SET Izenburua = '" + abestiBerria.getIzenburua() + "',"
//        		+ ""
//	}
//	
//	public static int abestiIDLortu(Abestia abesti) throws SQLException {
//		Konexioa.konexioaIreki();
//		String SQLquery = "SELECT IdAbesti FROM abesti WHERE Izenburua = '" + abesti.getIzenburua() + "'";
//		ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
//		emaitza.next();
//		int idAbesti = emaitza.getInt("IdAbesti");
//		Konexioa.konexioaItxi();
//		return idAbesti;
//	}

}
