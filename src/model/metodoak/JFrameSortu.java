package model.metodoak;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.WindowConstants;
import view.*;

public class JFrameSortu {
	
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
	
	// JFRAME-AK
	public static void loginMenua() {
		Login loginMenu = new Login();
		loginMenu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		loginMenu.setVisible(true);
    }
	public static void erregistroMenua() {
		Erregistroa erregistroMenu = new Erregistroa();
		erregistroMenu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		erregistroMenu.setVisible(true);
    }
	
	public static void menuaBezeroa() {
		Menua menuaAtera = new Menua();
		menuaAtera.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		menuaAtera.setVisible(true);
    }
}

