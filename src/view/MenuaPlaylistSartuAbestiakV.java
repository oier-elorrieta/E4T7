package view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Abestia;
import model.Album;
import model.Artista;
import model.Playlist;
import model.metodoak.SesioAldagaiak;
import model.sql.DiskaAbestiakDAO;
import model.sql.MenuaPlaylistSartuAbestiakDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuaPlaylistSartuAbestiakV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MenuaPlaylistSartuAbestiakV(Album album, Artista artista, Abestia abesti) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(540, 300, 666, 442);
		setTitle("Playlist-ean sartu - JPAM Music");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAukera = new JLabel("Aukeratutako pista:");
		lblAukera.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblAukera.setBounds(87, 46, 158, 22);
		contentPane.add(lblAukera);
		
		JLabel lblAbestiIzena = new JLabel("");
		lblAbestiIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbestiIzena.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
		lblAbestiIzena.setBounds(10, 107, 298, 30);
		lblAbestiIzena.setText("Titulua: "+ abesti.getTitulua());
		contentPane.add(lblAbestiIzena);
		
		JLabel lblArtista = new JLabel("");
		lblArtista.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtista.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblArtista.setBounds(10, 167, 298, 30);
		lblArtista.setText("Artista: " + artista.getIzena());
		contentPane.add(lblArtista);
		
		JList<Playlist> Playlista = new JList();
		ArrayList<Playlist> PlaylistJList = MenuaPlaylistSartuAbestiakDAO.playlistakKargatu();
		DefaultListModel<Playlist> modelPlaylist = new DefaultListModel<Playlist>();
		Playlist playlistGustokoa = new Playlist("");

		modelPlaylist.addElement(playlistGustokoa);
		for (int i = 0; i < PlaylistJList.size(); i++) {
			modelPlaylist.addElement(PlaylistJList.get(i));
		}
		
		Playlista.setModel(modelPlaylist);
		Playlista.setBorder(new LineBorder(new Color(0, 0, 0)));
		Playlista.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		Playlista.setBounds(318, 48, 300, 298);
		contentPane.add(Playlista);
		
		JLabel lblAukeratuPlaylist = new JLabel("Aukeratu Playlist bat abestia sartzeko:");
		lblAukeratuPlaylist.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblAukeratuPlaylist.setBounds(320, 14, 256, 26);
		contentPane.add(lblAukeratuPlaylist);
		
		JButton btnSartuPlaylist = new JButton("Sartu PlayList-ean");
		btnSartuPlaylist.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		btnSartuPlaylist.setBounds(461, 356, 158, 33);
		btnSartuPlaylist.setFocusPainted(false);
		contentPane.add(btnSartuPlaylist);
		
		JButton btnUtzi = new JButton("Utzi");
		btnUtzi.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		btnUtzi.setBounds(22, 356, 113, 33);
		btnUtzi.setFocusPainted(false);
		contentPane.add(btnUtzi);
		
		
		// UTZI BOTOIA
		btnUtzi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		// SARTU PLAYLISTEAN BOTOIA
		btnSartuPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Playlista.getSelectedIndex() == 0) {
					try {
						MenuaPlaylistSartuAbestiakDAO.gustokoanGorde(abesti);
						dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					
				}
			}
		});
	}
}
