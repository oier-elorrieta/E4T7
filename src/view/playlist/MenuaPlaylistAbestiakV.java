package view.playlist;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Abestia;
import model.Album;
import model.Artista;
import model.Playlist;
import model.metodoak.FilesMetodoak;
import model.metodoak.JFrameSortu;
import model.sql.MenuaPlaylistSartuAbestiakDAO;
import model.sql.PlayListDAO;
import view.LoginV;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MenuaPlaylistAbestiakV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MenuaPlaylistAbestiakV(Playlist playlist, Abestia abestia, Album album, Artista artista, JFrame PlaylistAbestiakV) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1000, 400, 288, 189);
		setResizable(false);
		setUndecorated(true);
		toFront();
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEzabatuAbestia = new JButton("❌ Ezabatu abestia");
		btnEzabatuAbestia.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEzabatuAbestia.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		btnEzabatuAbestia.setFocusPainted(false);
		btnEzabatuAbestia.setBounds(48, 92, 194, 31);
		contentPane.add(btnEzabatuAbestia);
		
		JLabel lblMenua = new JLabel("MENUA");
		lblMenua.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenua.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblMenua.setBounds(10, 14, 268, 24);
		contentPane.add(lblMenua);
		
		JButton btnX_Itxi = new JButton("X");
		btnX_Itxi.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnX_Itxi.setFocusPainted(false);
		btnX_Itxi.setBounds(228, 11, 48, 31);
		contentPane.add(btnX_Itxi);
		
		JButton btnKonpartitu = new JButton("↪️ Konpartitu");
		btnKonpartitu.setVerticalAlignment(SwingConstants.BOTTOM);
		btnKonpartitu.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		btnKonpartitu.setFocusPainted(false);
		btnKonpartitu.setBounds(68, 134, 161, 31);
		contentPane.add(btnKonpartitu);
		
		JLabel lblAbestiInfo = new JLabel("");
		lblAbestiInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbestiInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAbestiInfo.setBounds(5, 55, 277, 19);
		lblAbestiInfo.setText(abestia.getTitulua() + " · " + artista.getIzena());
		contentPane.add(lblAbestiInfo);
		
		// ITXI BOTOIA
		btnX_Itxi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
				
		// EZABATU ABESTIA BOTOIA
		btnEzabatuAbestia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if (playlist.getTitulua().equals("Gustokoen zerrenda")) {
					try {
						MenuaPlaylistSartuAbestiakDAO.gustokoaEzabatu(abestia);
						PlaylistAbestiakV.dispose();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Errore bat gertatu da abestia ezabatzean", "Errorea",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					PlayListDAO.ezabatuAbestiaPlaylist(playlist, abestia);
					PlaylistAbestiakV.dispose();
				}
				try {
					JFrameSortu.playListAbestiak(playlist);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Errore bat gertatu da abestia ezabatzean", "Errorea",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// KONPARTITU BOTOIA
		btnKonpartitu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] aukerakMenu = { "Bai", "Ez" };
                int menuAukera = JOptionPane.showOptionDialog(null, "Konpartitu nahi duzu?", "Konpartitu",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, aukerakMenu, aukerakMenu[0]);
                if (menuAukera == JOptionPane.YES_OPTION) {
                	try {
						FilesMetodoak.abestiaKonpartituPlaylist(playlist, abestia, album, artista);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Errore bat gertatu da abestia konpartitzean", "Errorea",
								JOptionPane.ERROR_MESSAGE);
					}
					JOptionPane.showMessageDialog(null, "Zure abestia konpartitu da Files batera!", "Konpartitu",
							JOptionPane.INFORMATION_MESSAGE);
					dispose();
                }
			}
		});
	}
}
