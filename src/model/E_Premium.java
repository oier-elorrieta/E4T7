package model;

import java.util.Date;
import java.util.Objects;

public class E_Premium extends Erabiltzailea {
	protected Date iraungintze_data;

	public E_Premium(String erabiltzailea, String pasahitza, String izena, String abizena, Date jaiotze_data,
			Date iraungintze_data) {
		super(erabiltzailea, pasahitza, izena, abizena, jaiotze_data);
		this.iraungintze_data = iraungintze_data;
	}

	public Date getIraungintze_data() {
		return iraungintze_data;
	}

	public void setIraungintze_data(Date iraungintze_data) {
		this.iraungintze_data = iraungintze_data;
	}

	@Override
	public String toString() {
		return super.toString() + "E_Premium [iraungintze_data=" + iraungintze_data + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		E_Premium other = (E_Premium) obj;
		return Objects.equals(iraungintze_data, other.iraungintze_data);
	}
	

}
