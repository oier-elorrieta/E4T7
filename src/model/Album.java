package model;

import java.util.Date;
import java.util.Objects;

public class Album {
	
	
	private String izenburua;
	private Date urtea;
	private String generoa;

	public Album(String izenburua, Date urtea, String generoa) {
		super();
		this.izenburua = izenburua;
		this.urtea = urtea;
		this.generoa = generoa;
	}

	public String getIzenburua() {
		return izenburua;
	}

	public void setIzenburua(String izenburua) {
		this.izenburua = izenburua;
	}

	public Date getUrtea() {
		return urtea;
	}

	public void setUrtea(Date urtea) {
		this.urtea = urtea;
	}

	public String getGeneroa() {
		return generoa;
	}

	public void setGeneroa(String generoa) {
		this.generoa = generoa;
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
				&& Objects.equals(urtea, other.urtea);
	}

	@Override
	public String toString() {
		return "Album [izenburua=" + izenburua + ", urtea=" + urtea + ", generoa=" + generoa + "]";
	}



	
	
	
}
