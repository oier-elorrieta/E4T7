package testDAO.adminTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Abestia;
import model.sql.admin.AbestiCRUD;

public class AbestiCRUDTest {

	static Abestia abesti;
	static Abestia abestiBerria;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		abesti = new Abestia("3", "Malamente", "00:02:30");
		abestiBerria = new Abestia("1", "abestia", "00:03:30");
	}

	@Test
	public void abestiIzenakKargatuTestIdAudio() throws SQLException {
		ArrayList<Abestia> abestiList = AbestiCRUD.abestiIzenakKargatu();
		assertEquals(abesti.getIdAudio(), abestiList.get(0).getIdAudio());
	}

	@Test
	public void abestiIzenakKargatuTestIzena() throws SQLException {
		ArrayList<Abestia> abestiList = AbestiCRUD.abestiIzenakKargatu();
		assertEquals(abesti.getTitulua(), abestiList.get(0).getTitulua());
	}

	@Test
	public void abestiIzenakKargatuTestIraupena() throws SQLException {
		ArrayList<Abestia> abestiList = AbestiCRUD.abestiIzenakKargatu();
		assertEquals(abesti.getIraupena(), abestiList.get(0).getIraupena());
	}

	@Test
	public void abestiDeleteTest() throws SQLException {
		AbestiCRUD.audioInsert(abestiBerria.getTitulua(), abestiBerria.getIraupena(), 19);
		AbestiCRUD.abestiDelete(abestiBerria);
		ArrayList<Abestia> abestiList = AbestiCRUD.abestiIzenakKargatu();
		assertNotEquals("Test", abestiList.get(abestiList.size() - 1).getTitulua());
	}

	@Test
	public void abestiAudioInsertTest() throws SQLException {
		AbestiCRUD.audioInsert(abestiBerria.getTitulua(), abestiBerria.getIraupena(), 19);
		ArrayList<Abestia> abestiList = AbestiCRUD.abestiIzenakKargatu();

		assertEquals("abestia", abestiList.get(abestiList.size() - 1).getTitulua());

		AbestiCRUD.abestiDelete(abestiBerria);
	}

	@Test
	public void abestiUpdateTest() throws SQLException {
		AbestiCRUD.audioInsert(abestiBerria.getTitulua(), abestiBerria.getIraupena(), 19);
		AbestiCRUD.abestiUpdate(abestiBerria, "abestia", "00:03:30");
		ArrayList<Abestia> abestiList = AbestiCRUD.abestiIzenakKargatu();
		assertEquals("abestia", abestiList.get(abestiList.size() - 1).getTitulua());

		AbestiCRUD.abestiDelete(abestiBerria);
	}

}
