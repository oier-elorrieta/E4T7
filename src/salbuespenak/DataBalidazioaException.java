package salbuespenak;

import javax.swing.JOptionPane;

public class DataBalidazioaException extends Exception {
	public DataBalidazioaException() {
		JOptionPane.showMessageDialog(null, "Data txarto sartu duzu!", "Errorea", JOptionPane.ERROR_MESSAGE);
		
	}	
}

