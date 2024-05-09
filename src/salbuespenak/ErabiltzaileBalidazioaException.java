package salbuespenak;

import javax.swing.JOptionPane;

public class ErabiltzaileBalidazioaException extends Exception {
	public ErabiltzaileBalidazioaException(String message) {
        super(message);
		JOptionPane.showMessageDialog(null, "Badago erabiltzaile hori sortuta", "Errorea", JOptionPane.ERROR_MESSAGE);
		
	}

	
}
