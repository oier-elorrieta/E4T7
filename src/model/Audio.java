package model;

public class Audio {
	protected String titulua;
	protected int iraupena;
	
	public Audio(String titulua, int iraupena) {
		this.titulua = titulua;
		this.iraupena = iraupena;
	}

	String getTitulua() {
		return titulua;
	}

	void setTitulua(String titulua) {
		this.titulua = titulua;
	}

	int getIraupena() {
		return iraupena;
	}

	void setIraupena(int iraupena) {
		this.iraupena = iraupena;
	}
	
}
