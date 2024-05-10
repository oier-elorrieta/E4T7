package salbuespenak;

import javax.swing.JOptionPane;

public class ErabiltzaileBalidazioaException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErabiltzaileBalidazioaException() {
		JOptionPane.showMessageDialog(null, "Badago erabiltzaile hori sortuta", "Errorea", JOptionPane.ERROR_MESSAGE);
	}

	
}
