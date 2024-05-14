package model.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Abestia;


public class IragarkiLehioaDAO {
	
	/**
	 * Iragarkiak lortzeko metodoa.
	 * 
	 * @return Iragarkiak zerrenda moduan itzultzen du, Abestia objektu moduan.
	 * @throws SQLException SQL exekuzioan errorea gertatzen bada.
	 **/
	public static ArrayList<Abestia> getIragarkiak() throws SQLException {
		Konexioa.konexioaIreki();
		ArrayList<Abestia> iragarkiList = new ArrayList<Abestia>(); 
        String SQLquery = "SELECT IDAudio, Izena, Iraupena FROM audio WHERE Izena LIKE 'iragarkia%'";
        ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
        Abestia iragarkiak = null;
        
        while (emaitza.next()) {
        	iragarkiak = new Abestia(emaitza.getString("IDAudio"), emaitza.getString("Izena"), emaitza.getString("Iraupena"));
        	
        	iragarkiList.add(iragarkiak);
        }
        Konexioa.konexioaItxi();
        return iragarkiList;
	}
	
}
