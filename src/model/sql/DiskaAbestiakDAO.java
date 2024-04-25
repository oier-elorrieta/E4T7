package model.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Abestia;


public class DiskaAbestiakDAO {
	public static ArrayList<Abestia> albumAbestiakKargatu() throws SQLException {
        ArrayList<Abestia> abestiList = new ArrayList<Abestia>();
        String SQLquery = "SELECT ;";
        ResultSet emaitza = Konexioa.query.executeQuery(SQLquery);
        Abestia abestiak = null;
        
        while (emaitza.next()) {
        	abestiak = new Abestia(emaitza.getString("izenburua"), emaitza.getString("year(urtea)"), emaitza.getInt("count(IDAudio)"));
           
        	abestiList.add(abestiak);
        }
        
        return abestiList;
    }
}
