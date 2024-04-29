package view;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MenuaPlaylistSartuV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MenuaPlaylistSartuV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(482, 315, 680, 422);
		setTitle("PlayList-ean sartu - JPAM Music");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList PlayListList = new JList();
		PlayListList.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 14));
		PlayListList.setBorder(new LineBorder(new Color(0, 0, 0)));
		PlayListList.setBounds(278, 48, 362, 278);
		contentPane.add(PlayListList);
		
		JButton btnSartuplaylist = new JButton("Sartu playlist-ean");
		btnSartuplaylist.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		btnSartuplaylist.setBounds(489, 336, 151, 36);
		contentPane.add(btnSartuplaylist);
		
		JButton btnUtzi = new JButton("Utzi");
		btnUtzi.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		btnUtzi.setBounds(17, 336, 151, 36);
		contentPane.add(btnUtzi);
		
		JLabel lblAukeratuPlaylist = new JLabel("Aukeratu zer playlist-ean sartu nahi duzun:");
		lblAukeratuPlaylist.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 15));
		lblAukeratuPlaylist.setBounds(278, 10, 321, 29);
		contentPane.add(lblAukeratuPlaylist);
		
		JLabel lblAukeratutakoa = new JLabel("Aukeratutako pista");
		lblAukeratutakoa.setFont(new Font("Source Sans Pro SemiBold", Font.BOLD, 17));
		lblAukeratutakoa.setBounds(57, 25, 166, 29);
		contentPane.add(lblAukeratutakoa);
		
		JLabel lblNewLabel_2 = new JLabel("Izena:");
		lblNewLabel_2.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(17, 65, 239, 29);
		contentPane.add(lblNewLabel_2);
	}
}
