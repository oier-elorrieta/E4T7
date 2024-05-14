package salbuespenak;

import javax.swing.JOptionPane;

public class PlaylistEzinSortuException extends Exception {
	public PlaylistEzinSortuException() {
		JOptionPane.showMessageDialog(null, "Ezin duzu PlayList gehiago sortu!", "Catastrophic error [Free]", JOptionPane.ERROR_MESSAGE);
	}
}
