package view.playlist;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Abestia;
import model.Playlist;
import model.metodoak.JFrameSortu;
import model.metodoak.SesioAldagaiak;
import model.metodoak.View_metodoak;
import model.sql.PlaylistAbestiakDAO;
import view.LoginV;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class PlaylistAbestiakV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public PlaylistAbestiakV(Playlist playlist) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setResizable(false);
		if (SesioAldagaiak.e_premium) {
			setTitle(playlist.getTitulua() + " · PlayList-ak - JPAM Music PREMIUM");
		} else {
			setTitle(playlist.getTitulua() + " · PlayList-ak - JPAM Music FREE");
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(183, 95, 528, 393);
		contentPane.add(scrollPane);
		
		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);
		
		JButton btnNireProfila = View_metodoak.btn_NireProfila();
		contentPane.add(btnNireProfila);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserizena = new JLabel("");
		lblUserizena.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserizena.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblUserizena.setText("Kaixo, " + SesioAldagaiak.bezeroa_logeatuta.getIzena() + "!");
		lblUserizena.setBounds(687, 11, 193, 34);
		contentPane.add(lblUserizena);
		
		JLabel lblPlaylist = new JLabel("PLAYLIST-A: " + playlist.getTitulua());
		lblPlaylist.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaylist.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblPlaylist.setBounds(0, 23, 890, 27);
		contentPane.add(lblPlaylist);
		
		JLabel lblAbestiZerrenda = new JLabel("Abesti zerrenda. Abesti kantitatea: " + playlist.getKapazitatea());
		lblAbestiZerrenda.setHorizontalAlignment(SwingConstants.LEFT);
		lblAbestiZerrenda.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblAbestiZerrenda.setBounds(183, 61, 528, 23);
		contentPane.add(lblAbestiZerrenda);
		
		JList<Abestia> PlaylistAbestiakList = new JList<Abestia>();
		ArrayList<Abestia> AbestiPlaylistJList = PlaylistAbestiakDAO.abestiakPlaylistKargatu(playlist);
		DefaultListModel<Abestia> modelPlaylistAbestia = new DefaultListModel<Abestia>();
		
		for (int i = 0; i < AbestiPlaylistJList.size(); i++) {
			modelPlaylistAbestia.addElement(AbestiPlaylistJList.get(i));
		}
		
		PlaylistAbestiakList.setModel(modelPlaylistAbestia);
		PlaylistAbestiakList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		PlaylistAbestiakList.setFont(new Font("Verdana", Font.BOLD, 16));
		PlaylistAbestiakList.setBorder(new LineBorder(new Color(0, 0, 0)));
		PlaylistAbestiakList.setBounds(183, 93, 528, 395);
		scrollPane.setViewportView(PlaylistAbestiakList);
		
		
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
				try {
					setVisible(false);
					JFrameSortu.erregistroMenua(PlaylistAbestiakV.this);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
