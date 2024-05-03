package model.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Abestia;

public class IragarkiLehioaDAO {
	public static ArrayList<Abestia> getIragarkiak() throws SQLException {
		ArrayList<Abestia> iragarkiList = new ArrayList<Abestia>();
        String SQLquery = "SELECT IDAudio, Izena, Iraupena FROM audio WHERE Izena LIKE 'iragarkia%'";
        ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
        Abestia iragarkiak = null;
        
        while (emaitza.next()) {
        	iragarkiak = new Abestia(emaitza.getString("IDAudio"), emaitza.getString("Izena"), emaitza.getString("Iraupena"));
        	
        	iragarkiList.add(iragarkiak);
        }
        
        return iragarkiList;
	}
	
	/*public static Abestia getIragarkiakIrudia(Abestia abesti) throws SQLException {
        String SQLquery = "SELECT Irudia FROM audio WHERE Izena LIKE 'iragarkia%'";
        ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
        Abestia iragarkiakIrudiak = null;
        
        while (emaitza.next()) {
        	iragarkiakIrudiak = new Abestia(emaitza.getBlob("Irudia"));
        }
        
        return iragarkiakIrudiak;
	}*/
	
}
