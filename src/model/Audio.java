package model;

import java.util.Objects;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Audio other = (Audio) obj;
		return iraupena == other.iraupena && Objects.equals(titulua, other.titulua);
	}

	@Override
	public String toString() {
		return "Audio [titulua=" + titulua + ", iraupena=" + iraupena + "]";
	}	
	
}
