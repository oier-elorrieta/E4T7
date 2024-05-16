package salbuespenak;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class AudioaNotFoundExcepcion extends Exception{
	public AudioaNotFoundExcepcion() {
		JOptionPane.showMessageDialog(null, "Audioa ez da aurkitu", "Errorea", JOptionPane.ERROR_MESSAGE);
	}
}
