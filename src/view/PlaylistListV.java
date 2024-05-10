package view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Abestia;
import model.Playlist;
import model.metodoak.FilesMetodoak;
import model.metodoak.JFrameSortu;
import model.metodoak.SesioAldagaiak;
import model.metodoak.View_metodoak;
import model.sql.DiskaAbestiakDAO;
import model.sql.Konexioa;
import model.sql.PlayListDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class PlaylistListV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Playlist playlistSelected;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public PlaylistListV() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setResizable(false);
		if (SesioAldagaiak.e_premium) {
			setTitle("Nire PlayList-ak - JPAM Music PREMIUM");
		} else {
			setTitle("Nire PlayList-ak - JPAM Music FREE");
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 109, 458, 390);
		contentPane.add(scrollPane);
		
		JLabel lblUserizena = new JLabel("");
		lblUserizena.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserizena.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblUserizena.setText("Kaixo, " + SesioAldagaiak.bezeroa_logeatuta.getIzena() + "!");
		lblUserizena.setBounds(687, 11, 193, 34);
		contentPane.add(lblUserizena);
		
		JLabel lblPlaylistakDeskubritu = new JLabel("NIRE PLAYLIST-AK");
		lblPlaylistakDeskubritu.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaylistakDeskubritu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPlaylistakDeskubritu.setBounds(0, 24, 890, 27);
		contentPane.add(lblPlaylistakDeskubritu);
		
		JLabel lblHemenZurePlaylistak = new JLabel("Hemen zure PlayList-ak kudeatu dezakezu!");
		lblHemenZurePlaylistak.setHorizontalAlignment(SwingConstants.CENTER);
		lblHemenZurePlaylistak.setFont(new Font("Segoe UI Semilight", Font.ITALIC, 16));
		lblHemenZurePlaylistak.setBounds(0, 54, 890, 23);
		contentPane.add(lblHemenZurePlaylistak);
		
		JList<Playlist> PlaylistList = new JList();
		ArrayList<Playlist> PlaylistJList = PlayListDAO.playListakKargatuBezeroa();
		DefaultListModel<Playlist> modelPlaylist = new DefaultListModel<Playlist>();
		Playlist playlistGustokoa = new Playlist("", PlayListDAO.gustokoAbestiKantitatea());
		
		modelPlaylist.addElement(playlistGustokoa);
		for (int i = 0; i < PlaylistJList.size(); i++) {
			modelPlaylist.addElement(PlaylistJList.get(i));
		}
		
		PlaylistList.setModel(modelPlaylist);
		PlaylistList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		PlaylistList.setFont(new Font("Verdana", Font.BOLD, 16));
		PlaylistList.setBorder(new LineBorder(new Color(0, 0, 0)));
		PlaylistList.setBounds(35, 109, 458, 390);
		scrollPane.setViewportView(PlaylistList);
		
		JButton btnBerriaSortu = new JButton("Berria sortu");
		btnBerriaSortu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnBerriaSortu.setBounds(620, 163, 164, 51);
		btnBerriaSortu.setFocusPainted(false);
		contentPane.add(btnBerriaSortu);
		
		JButton btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnEzabatu.setBounds(620, 237, 164, 51);
		btnEzabatu.setFocusPainted(false);
		contentPane.add(btnEzabatu);
		
		JButton btnInportatu = new JButton("Inportatu");
		btnInportatu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnInportatu.setBounds(620, 308, 164, 51);
		btnInportatu.setFocusPainted(false);
		contentPane.add(btnInportatu);
		
		JButton btnExportatu = new JButton("Exportatu");
		btnExportatu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnExportatu.setBounds(620, 384, 164, 51);
		btnExportatu.setFocusPainted(false);
		contentPane.add(btnExportatu);
		
		JLabel lblAukerak = new JLabel("Aukerak");
		lblAukerak.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukerak.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 21));
		lblAukerak.setBounds(602, 115, 200, 23);
		contentPane.add(lblAukerak);
		
		JLabel lblPlaylistzerrenda = new JLabel("PlayList-en zerrenda");
		lblPlaylistzerrenda.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlaylistzerrenda.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblPlaylistzerrenda.setBounds(35, 75, 200, 23);
		contentPane.add(lblPlaylistzerrenda);
		
		JButton btnZabalduPlaylista = new JButton("Zabaldu PlayList-a");
		btnZabalduPlaylista.setFont(new Font("Segoe UI Historic", Font.PLAIN, 18));
		btnZabalduPlaylista.setFocusPainted(false);
		btnZabalduPlaylista.setBounds(620, 496, 205, 42);
		contentPane.add(btnZabalduPlaylista);
		
		// ATZERA BOTOIA
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.menuaBezeroa();
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
		
		// ZABALDU PLAYLIST BOTOIA
		btnZabalduPlaylista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playlistSelected = PlaylistList.getSelectedValue();
				if (playlistSelected == null) {
					JOptionPane.showMessageDialog(null, "Ez duzu PlayList bat aukeratu!", "Catastrophic Error", JOptionPane.ERROR_MESSAGE);
				} else {
					Playlist playlistAuxSelected = new Playlist(playlistSelected.getIdPlaylist(), playlistSelected.getTitulua(), playlistSelected.getKapazitatea(), playlistSelected.getSorrera_data());
					dispose();
					try {
						JFrameSortu.playListAbestiak(playlistAuxSelected);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		// PLAYLIST BERRIA SORTU BOTOIA
		btnBerriaSortu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFrameSortu.playListBerriaSortu();
			}
		});
		
		// EZABATU BOTOIA
		btnEzabatu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playlistSelected = PlaylistList.getSelectedValue();
				if (playlistSelected == null) {
					JOptionPane.showMessageDialog(null, "Ez duzu PlayList bat aukeratu!", "Catastrophic Error", JOptionPane.ERROR_MESSAGE);
				} else {
					if (PlaylistList.getSelectedIndex() == 0) {
						JOptionPane.showMessageDialog(null, "Gustoko PlayList-a ezin da ezabatu!", "Catastrophic Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						PlayListDAO.playlistEzabatu(playlistSelected);
						JOptionPane.showMessageDialog(null, "PlayList-a ezabatu da!", "PlayList-a [Ezabatu]",
								JOptionPane.INFORMATION_MESSAGE);
						dispose();
						JFrameSortu.playlistListaBezeroa();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Errorea egon da datu basearekin.", "Catastrophic Error",
								JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
				}
			}
		});
		
		// INPORTATU BOTOIA
		btnInportatu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playlistSelected = PlaylistList.getSelectedValue();
				
			}
		});
		
		// EXPORTATU BOTOIA
		btnExportatu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playlistSelected = PlaylistList.getSelectedValue();
				if (playlistSelected == null) {
                    JOptionPane.showMessageDialog(null, "Ez duzu PlayList bat aukeratu!", "Catastrophic Error", JOptionPane.ERROR_MESSAGE);
                } else {
					Object[] aukerakMenu = { "Bai", "Ez" };
	                int menuAukera = JOptionPane.showOptionDialog(null, "Exportatu nahi duzu?\nPlaylist-a: " + playlistSelected.getTitulua(), "Exportatu",
	                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, aukerakMenu, aukerakMenu[0]);
	                if (menuAukera == JOptionPane.YES_OPTION) {
	                	try {
							FilesMetodoak.exportatuPlaylistFiles(playlistSelected);
							JOptionPane.showMessageDialog(null, "PlayList-a exportatu da!", "PlayList-a [Exportatu]",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (IOException e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "Errorea egon da.", "Catastrophic Error",
									JOptionPane.ERROR_MESSAGE);
						}
	                }
                }
			}
		});
	}
}
