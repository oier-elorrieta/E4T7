package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Abestia;
import model.Album;
import model.Artista;
import model.metodoak.JFrameSortu;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuAukeraErreprodukzioV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MenuAukeraErreprodukzioV(Album album, Artista artista, Abestia abesti) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(408, 643, 288, 189);
		setTitle("Erreprodukzio menua");
		setResizable(false);
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPlaylistSartu = new JButton("PlayListean sartu");
		btnPlaylistSartu.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnPlaylistSartu.setBounds(71, 75, 146, 31);
		btnPlaylistSartu.setFocusPainted(false);
		contentPane.add(btnPlaylistSartu);
		
		JButton btnKonpartitu = new JButton("Konpartitu");
		btnKonpartitu.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnKonpartitu.setBounds(87, 118, 114, 31);
		btnKonpartitu.setFocusPainted(false);
		contentPane.add(btnKonpartitu);
		
		JLabel lblNewLabel = new JLabel("MENUA");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 38, 268, 24);
		contentPane.add(lblNewLabel);
		
		JButton btnX_Itxi = new JButton("X");
		btnX_Itxi.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnX_Itxi.setFocusPainted(false);
		btnX_Itxi.setBounds(236, 3, 48, 31);
		contentPane.add(btnX_Itxi);
		
		// ITXI BOTOIA
		btnX_Itxi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		// PLAYLIST SARTU BOTOIA
		btnPlaylistSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					JFrameSortu.PlaylisteanSartuBezeroa(album, artista, abesti);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

}