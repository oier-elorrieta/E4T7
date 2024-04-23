package model.metodoak;

import java.awt.Font;

import javax.swing.JButton;

import salbuespenak.DataBalidazioaException;

public class View_metodoak {
	
	// BOTOIAK 
	public static JButton btn_Atzera() {
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("SansSerifs", Font.PLAIN, 16));
		btnAtzera.setBounds(24, 15, 110, 37);
		btnAtzera.setFocusPainted(false);
		
		return btnAtzera;
	}
	
	public static JButton btn_NireProfila() {
		JButton btnNireProfila = new JButton("Nire profila");
		btnNireProfila.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnNireProfila.setBounds(730, 49, 115, 27);
		btnNireProfila.setFocusPainted(false);
		
		return btnNireProfila;
	}
		
	// Hezkuntza Konprobaketa Erregistroan
	public static String hezkuntzaKonprobatu(String hiz) {
		String hizkuntza = "";
		switch (hiz) {
		case "Euskera":
			hizkuntza = "EU";
			break;
		case "Español":
			hizkuntza = "ES";
			break;
		case "English":
			hizkuntza = "EN";
			break;
		case "Français":
			hizkuntza = "FR";
			break;
		case "Deutsch":
			hizkuntza = "DE";
			break;
		case "Catalá":
			hizkuntza = "CA";
			break;
		case "Gaeilg":
			hizkuntza = "GA";
			break;
		case "Arabic":
			hizkuntza = "AR";
			break;
		}
		return hizkuntza;
	}
	
	public static void dataBalidatu(String date) throws DataBalidazioaException {
        if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new DataBalidazioaException();
        }
    }
}
