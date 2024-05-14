package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.cj.jdbc.Blob;

import model.Abestia;
import model.Audio;

public class AbestiaTest {

	private static Abestia abestiakProba;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        abestiakProba = new Abestia("1", null, null, 180);
    }

    @Test
    public void testConstructor() {
        Abestia abestia1 = new Abestia("idaudio", "tituloa", null, 121);
        assertNotNull(abestia1);
    }
  @Test
  public void testConstructor1() {
	  Blob Blob = new Blob(null, null);
	  Abestia abestia = new Abestia("Titulo", Blob, "Iraupena");
      assertNotNull(abestia);
  }

  @Test
  public void testConstructor2() {
	  Abestia abestia = new Abestia("idaudio", "tituloa", null, 121);
      assertNotNull(abestia);
  }
  
  @Test
  public void testConstructor3() {
	  Abestia abestia = new Abestia("idaudio","tituloa","iraupena");
      assertNotNull(abestia);
  }
 
  @Test
  public void testConstructor5() {
	  Blob blob = new Blob(null, null);
	  Abestia abestia = new Abestia(blob);
      assertNotNull(abestia.getIrudia());
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

}
