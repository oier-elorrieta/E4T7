package view;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import model.Abestia;
import model.Album;
import model.Artista;
import model.sql.DiskaAbestiakDAO;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.SwingConstants;

public class MenuaPlaylistSartuAbestiakV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<Abestia> abestiList;
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MenuaPlaylistSartuAbestiakV(Album album, Artista artista, Abestia abesti) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(482, 315, 680, 422);
		setTitle("PlayList-ean sartu - JPAM Music");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			abestiList = DiskaAbestiakDAO.albumAbestiakKargatu(album);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		JList PlayListList = new JList();
		PlayListList.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 14));
		PlayListList.setBorder(new LineBorder(new Color(0, 0, 0)));
		PlayListList.setBounds(278, 48, 362, 278);
		contentPane.add(PlayListList);
		
		JButton btnSartuplaylist = new JButton("Sartu playlist-ean");
		btnSartuplaylist.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		btnSartuplaylist.setFocusPainted(false);
		btnSartuplaylist.setBounds(489, 336, 151, 36);
		contentPane.add(btnSartuplaylist);
		
		JButton btnUtzi = new JButton("Utzi");
		btnUtzi.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		btnUtzi.setFocusPainted(false);
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
		
		JLabel lblIzena = new JLabel("");
		lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzena.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 15));
		lblIzena.setBounds(17, 65, 239, 29);
		contentPane.add(lblIzena);
		
		JLabel lblArtista = new JLabel("");
		lblArtista.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtista.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblArtista.setBounds(17, 105, 239, 29);
		contentPane.add(lblArtista);	

		for (int i = 0; i < abestiList.size(); i++) {
			if (abesti.getTitulua().equals(abestiList.get(i).getTitulua())) {
				lblIzena.setText("Izena: " + abesti.getTitulua());
				lblArtista.setText("Artista: " + artista.getIzena());
			}
		}
		
		// SARTU PLAYLIST BOTOIA
		btnSartuplaylist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		// UTZI BOTOIA
		btnUtzi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
	}
}
