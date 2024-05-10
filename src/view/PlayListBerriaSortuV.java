package view;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Playlist;
import model.metodoak.JFrameSortu;
import model.metodoak.SesioAldagaiak;
import model.metodoak.View_metodoak;
import model.sql.PlaylistBerriaSortuDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;

public class PlayListBerriaSortuV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPlaylistIzena;

	/**
	 * Create the frame.
	 */
	public PlayListBerriaSortuV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 900, 343);
		setResizable(false);
		if (SesioAldagaiak.e_premium) {
			setTitle("PlayList sortu - JPAM Music PREMIUM");
		} else {
			setTitle("PlayList sortu - JPAM Music FREE");
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);
		
		JButton btnNireProfila = View_metodoak.btn_NireProfila();
		contentPane.add(btnNireProfila);
		
		JLabel lblUserizena = new JLabel("");
		lblUserizena.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserizena.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblUserizena.setText("Kaixo, " + SesioAldagaiak.bezeroa_logeatuta.getIzena() + "!");
		lblUserizena.setBounds(687, 11, 193, 34);
		contentPane.add(lblUserizena);
		
		JLabel lblPlaylistaSortu = new JLabel("PLAYLIST-A SORTU");
		lblPlaylistaSortu.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaylistaSortu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPlaylistaSortu.setBounds(0, 23, 890, 27);
		contentPane.add(lblPlaylistaSortu);
		
		JLabel lblHemenPlaylistBat = new JLabel("Hemen PlayList bat sortu dezakezu!");
		lblHemenPlaylistBat.setHorizontalAlignment(SwingConstants.CENTER);
		lblHemenPlaylistBat.setFont(new Font("Segoe UI Semilight", Font.ITALIC, 16));
		lblHemenPlaylistBat.setBounds(0, 52, 890, 23);
		contentPane.add(lblHemenPlaylistBat);
		
		JLabel lblBerria = new JLabel("PlayList-aren izena:");
		lblBerria.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblBerria.setBounds(89, 135, 199, 34);
		contentPane.add(lblBerria);
		
		txtPlaylistIzena = new JTextField();
		txtPlaylistIzena.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPlaylistIzena.setBounds(288, 139, 467, 27);
		contentPane.add(txtPlaylistIzena);
		txtPlaylistIzena.setColumns(10);
		
		JButton btnSortuPlaylista = new JButton("Sortu PlayList-a");
		btnSortuPlaylista.setForeground(Color.BLACK);
		btnSortuPlaylista.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSortuPlaylista.setFocusPainted(false);
		btnSortuPlaylista.setBounds(633, 245, 194, 46);
		contentPane.add(btnSortuPlaylista);
		
		// ATZERA BOTOIA
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					JFrameSortu.playlistListaBezeroa();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		// NIRE PROFILA BOTOIA
		btnNireProfila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					JFrameSortu.erregistroMenua();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		
		// SORTU PLAYLISTA BOTOIA
		btnSortuPlaylista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					Date sorrera_data = new Date();
					String playlistIzena = txtPlaylistIzena.getText();
					Playlist playlistAuxSortu = new Playlist(playlistIzena, 0, sorrera_data);
					PlaylistBerriaSortuDAO.playlistBerriaSortu(playlistAuxSortu);
					JFrameSortu.playlistListaBezeroa();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
