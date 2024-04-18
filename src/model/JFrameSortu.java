package model;

import javax.swing.WindowConstants;
import view.*;

public class JFrameSortu {
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
	
	public static void menua() {
		Menua menuaAtera = new Menua();
		menuaAtera.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		menuaAtera.setVisible(true);
    }
}

