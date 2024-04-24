package model.metodoak;

import java.awt.Font;
import java.sql.SQLException;

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
	public static void erregistroMenua() throws SQLException {
		Erregistroa erregistroMenu = new Erregistroa();
		erregistroMenu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		erregistroMenu.setVisible(true);
    }
	
	public static void menuaBezeroa() {
		Menua menuaAtera = new Menua();
		menuaAtera.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		menuaAtera.setVisible(true);
    }
	
	public static void musikaDeskubrituBezeroa() {
		Artistak musikaDesk = new Artistak();
		musikaDesk.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		musikaDesk.setVisible(true);
    }
}

