package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Abestiak;

public class AbestiakTest {

	private static Abestiak abestiakProba;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        abestiakProba = new Abestiak("abesti1", 180);
    }

    @Test
    public void testGetSet() {
        assertEquals(180, abestiakProba.getIraupena());
    }

    @Test
    public void testEquals_SameObject() {
        assertTrue(abestiakProba.equals(abestiakProba));
    }

    @Test
    public void testEquals_NullObject() {
        assertFalse(abestiakProba.equals(null));
    }

    @Test
    public void testEquals_DifferentClass() {
        String probaAbestiak = "";
        assertFalse(abestiakProba.equals(probaAbestiak));
    }

    @Test
    public void testEquals_EqualObjects() {
        Abestiak sameAbestiak = new Abestiak("abesti1", 180);
        assertTrue(abestiakProba.equals(sameAbestiak));
    }

    @Test
    public void testEquals_DifferentObjects() {
        Abestiak differentAbestiak = new Abestiak("abesti2", 240);
        assertFalse(abestiakProba.equals(differentAbestiak));
    }

}
