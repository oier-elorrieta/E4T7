package salbuespenak;

import javax.swing.JOptionPane;

public class AudioaNotFoundExcepcion extends Exception{
	public AudioaNotFoundExcepcion() {
		JOptionPane.showMessageDialog(null, "Audioa ez da aurkitu", "Errorea", JOptionPane.ERROR_MESSAGE);
		final String fileAudioDefault = "\\\\10.5.6.223\\audios\\default.wav";
	}
}
