package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Abestia;

public class AbestiaTest {

	private static Abestia abestiakProba;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        abestiakProba = new Abestia("1", null, null, 180);
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
        Abestia sameAbestiak = new Abestia("abesti1", null, null, 180);
        assertTrue(abestiakProba.equals(sameAbestiak));
    }

    @Test
    public void testEquals_DifferentObjects() {
        Abestia differentAbestiak = new Abestia("abesti2", null, null, 240);
        assertFalse(abestiakProba.equals(differentAbestiak));
    }

}
