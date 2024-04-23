package model;

public class Hizkuntza {
	private String id;
	private String deskribapena;
	
	public Hizkuntza(String id, String deskribapena) {
		this.id = id;
		this.deskribapena = deskribapena;
	}

	public String getId() {
		return id;
	}
	
	public String getDeskribapena() {
		return deskribapena;
	}
	
}
