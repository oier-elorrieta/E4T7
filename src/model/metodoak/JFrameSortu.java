package model.metodoak;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.WindowConstants;
import view.*;

public class JFrameSortu {
	
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

