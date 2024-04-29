package view;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PlaylistListV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PlaylistListV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setResizable(false);
		setTitle("PlayListak deskubritu - JPAM Music");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlaylistakDeskubritu = new JLabel("PLAYLISTAK DESKUBRITU");
		lblPlaylistakDeskubritu.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaylistakDeskubritu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPlaylistakDeskubritu.setBounds(0, 24, 890, 27);
		contentPane.add(lblPlaylistakDeskubritu);
	}

}
