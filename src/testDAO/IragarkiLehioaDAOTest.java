package testDAO;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import model.Abestia;
import model.sql.IragarkiLehioaDAO;

public class IragarkiLehioaDAOTest {

	@Test
	public void IragarkiTest() throws SQLException {
		ArrayList<Abestia> iragarkiList = IragarkiLehioaDAO.getIragarkiak();
		Abestia iragarkia = new Abestia("57", "iragarkia1", "00:00:20"); 
		
		assertEquals(iragarkiList.get(0).getIdAudio(), iragarkia.getIdAudio());
		assertEquals(iragarkiList.get(0).getTitulua(), iragarkia.getTitulua());
		assertEquals(iragarkiList.get(0).getIraupena(), iragarkia.getIraupena());
		
	}

}
