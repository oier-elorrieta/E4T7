package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mysql.cj.jdbc.Blob;

import model.Abestia;
import model.Hizkuntza;

public class HizkuntzaTest {

	@Test
    public void testConstructor() {
        Hizkuntza hizkuntza = new Hizkuntza("id", "describapena");
        assertEquals("id", hizkuntza.getId());
    }
  @Test
  public void testConstructor1() {
      Hizkuntza hizkuntza = new Hizkuntza("id", "describapena");
	  assertEquals("describapena", hizkuntza.getDeskribapena());
  }
}
