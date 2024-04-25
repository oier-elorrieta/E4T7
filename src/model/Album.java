package model;

import java.util.Date;
import java.util.Objects;

public class Album {
    
    private String izenburua;
    private String urtea;
    private String generoa;
    private int kantaTotala;
    
    public Album(String izenburua, String urtea, String generoa) {
        this.izenburua = izenburua;
        this.urtea = urtea;
        this.generoa = generoa;
    }

	public Album(String izenburua, String urtea, int kantaTotala) {
		this.izenburua = izenburua;
		this.urtea = urtea;
		this.kantaTotala = kantaTotala;
	}

	public String getIzenburua() {
        return izenburua;
    }
    public void setIzenburua(String izenburua) {
        this.izenburua = izenburua;
    }
    public String getUrtea() {
        return urtea;
    }
    public void setUrtea(String urtea) {
        this.urtea = urtea;
    }
    public String getGeneroa() {
        return generoa;
    }
    public void setGeneroa(String generoa) {
        this.generoa = generoa;
    }
    
    public int getKantaTotala() {
		return kantaTotala;
	}

	public void setKantaTotala(int kantaTotala) {
		this.kantaTotala = kantaTotala;
	}
	
    @Override
    public String toString() {
        return izenburua + " - " + urtea + " - " + kantaTotala + " kanta";
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		return Objects.equals(generoa, other.generoa) && Objects.equals(izenburua, other.izenburua)
				&& kantaTotala == other.kantaTotala && Objects.equals(urtea, other.urtea);
	}
}