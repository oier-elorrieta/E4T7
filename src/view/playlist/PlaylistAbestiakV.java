package view.playlist;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Abestia;
import model.Album;
import model.Artista;
import model.Musikaria;
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
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class PlaylistAbestiakV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<Abestia> AbestiPlaylistJList;
	private ArrayList<Album> albumPlaylistJList;
	private ArrayList<Artista> artistaList;
	private ArrayList<Abestia> gustukoAbestiakList;
	private ArrayList<Album> gustukoAlbumList;
	private ArrayList<Artista> gustukoArtistaList;
	
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
		
		JList PlaylistAbestiakList = new JList();
		if (playlist.getTitulua().equals("Gustokoen zerrenda")) {
			DefaultListModel modelPlaylistAbestiaGustokoak = new DefaultListModel();
			gustukoAbestiakList = PlaylistAbestiakDAO.gustukoAbestiakKargatu(playlist);
			gustukoAlbumList = PlaylistAbestiakDAO.gustukoAlbumAbestiakKargatu(playlist);
			gustukoArtistaList = PlaylistAbestiakDAO.gustukoArtistaAbestiakKargatu(playlist);
			for (int i = 0; i < gustukoAbestiakList.size(); i++) {
				modelPlaylistAbestiaGustokoak.addElement(gustukoAbestiakList.get(i).getTitulua() + " - " + gustukoArtistaList.get(i).getIzena() + " - " + gustukoAbestiakList.get(i).getIraupena() + " - " + gustukoAlbumList.get(i).getIzenburua());
			}
			PlaylistAbestiakList.setModel(modelPlaylistAbestiaGustokoak);
		} else {
			artistaList = PlaylistAbestiakDAO.abestiakArtistakPlaylistKargatu(playlist);
			AbestiPlaylistJList = PlaylistAbestiakDAO.abestiakPlaylistKargatu(playlist);
			albumPlaylistJList = PlaylistAbestiakDAO.albumAbestiakPlaylistKargatu(playlist);
			DefaultListModel modelPlaylistAbestia = new DefaultListModel();
			
			for (int i = 0; i < AbestiPlaylistJList.size(); i++) {
				modelPlaylistAbestia.addElement(AbestiPlaylistJList.get(i).getTitulua() + " - " + artistaList.get(i).getIzena() + " - " + AbestiPlaylistJList.get(i).getIraupena() + " - " + albumPlaylistJList.get(i).getIzenburua());
				
			}
			PlaylistAbestiakList.setModel(modelPlaylistAbestia);
		}
		
		PlaylistAbestiakList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		PlaylistAbestiakList.setFont(new Font("Verdana", Font.BOLD, 16));
		PlaylistAbestiakList.setBorder(new LineBorder(new Color(0, 0, 0)));
		PlaylistAbestiakList.setBounds(183, 93, 528, 395);
		scrollPane.setViewportView(PlaylistAbestiakList);
		
		JButton btnErreproduzitu = new JButton("Erreproduzitu");
		btnErreproduzitu.setForeground(Color.BLACK);
		btnErreproduzitu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnErreproduzitu.setFocusPainted(false);
		btnErreproduzitu.setBounds(661, 505, 172, 40);
		contentPane.add(btnErreproduzitu);
		
		JButton btnMenuAbestiak = new JButton("⚙️ Menua");
		btnMenuAbestiak.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
		btnMenuAbestiak.setBounds(726, 119, 134, 40);
		btnMenuAbestiak.setFocusPainted(false);
		contentPane.add(btnMenuAbestiak);
			
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
		
		// MENUA BOTOIA
		btnMenuAbestiak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (playlist.getTitulua().equals("Gustokoen zerrenda")) {
					String valueSelected =  (String) PlaylistAbestiakList.getSelectedValue();
					if (valueSelected == null) {
						JOptionPane.showMessageDialog(null, "Ez duzu abestirik hautatu!", "Errorea", JOptionPane.ERROR_MESSAGE);
						return;
					}
					valueSelected.split("-");
					String[] split = valueSelected.split("-");
					String abestia = split[0].trim();
					String artista = split[1].trim();
					String album = split[3].trim();
					String idAudio = "";
					String iraupena = "";
					
					for (int i = 0; i < gustukoAbestiakList.size(); i++) {
						idAudio = gustukoAbestiakList.get(i).getIdAudio();
						iraupena = gustukoAbestiakList.get(i).getIraupena();
					}
					
					Abestia abestiaSelected = new Abestia(idAudio, abestia, iraupena);
					Album albumSelected = new Album(album);
					Artista artistaSelected = new Musikaria(artista);
					JFrameSortu.menuaPlaylistAbestiak(playlist, abestiaSelected, albumSelected, artistaSelected, PlaylistAbestiakV.this);
				} else {
					String valueSelected =  (String) PlaylistAbestiakList.getSelectedValue();
					if (valueSelected == null) {
						JOptionPane.showMessageDialog(null, "Ez duzu abestirik hautatu!", "Errorea", JOptionPane.ERROR_MESSAGE);
						return;
					}
					valueSelected.split("-");
					String[] split = valueSelected.split("-");
					String abestia = split[0].trim();
					String artista = split[1].trim();
					String album = split[3].trim();
					String idAudio = "";
					String iraupena = "";
					
					for (int i = 0; i < AbestiPlaylistJList.size(); i++) {
						idAudio = AbestiPlaylistJList.get(i).getIdAudio();
						iraupena = AbestiPlaylistJList.get(i).getIraupena();
					}
					
					Abestia abestiaSelected = new Abestia(idAudio, abestia, iraupena);
					Album albumSelected = new Album(album);
					Artista artistaSelected = new Musikaria(artista);
					JFrameSortu.menuaPlaylistAbestiak(playlist, abestiaSelected, albumSelected, artistaSelected, PlaylistAbestiakV.this);
				}
			}
		});
		
		// ERREPRODUZITU BOTOIA
		btnErreproduzitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valueSelected =  (String) PlaylistAbestiakList.getSelectedValue();
				if (valueSelected == null) {
					JOptionPane.showMessageDialog(null, "Ez duzu abestirik hautatu erreproduzitzeko!", "Errorea", JOptionPane.ERROR_MESSAGE);
				} else {
					if (playlist.getTitulua().equals("Gustokoen zerrenda")) {
						valueSelected.split("-");
						String[] split = valueSelected.split("-");
						String abestia = split[0].trim();
						String artista = split[1].trim();
						String album = split[3].trim();
						String idAudio = "";
						Blob irudia = null;
						String iraupena = "";
						
						for (int i = 0; i < gustukoAbestiakList.size(); i++) {
							idAudio = gustukoAbestiakList.get(i).getIdAudio();
							irudia = gustukoAbestiakList.get(i).getIrudia();
							iraupena = gustukoAbestiakList.get(i).getIraupena();
						}
						
						Abestia abestiaSelected = new Abestia(idAudio, abestia, irudia, iraupena);
						Album albumSelected = new Album(album);
						Artista artistaSelected = new Musikaria(artista);
	
						try {
							dispose();
							JFrameSortu.erreprodukzioLehioa(albumSelected, artistaSelected, abestiaSelected);
							SesioAldagaiak.playlist_erreprodukzioa = true;
						} catch (SQLException | LineUnavailableException e1) {
							JOptionPane.showMessageDialog(null, "Errorea gertatu da erreproduzitzean.", "Errorea", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						valueSelected.split("-");
						String[] split = valueSelected.split("-");
						String abestia = split[0].trim();
						String artista = split[1].trim();
						String album = split[3].trim();
						String idAudio = "";
						Blob irudia = null;
						String iraupena = "";
						
						for (int i = 0; i < AbestiPlaylistJList.size(); i++) {
							idAudio = AbestiPlaylistJList.get(i).getIdAudio();
							irudia = AbestiPlaylistJList.get(i).getIrudia();
							iraupena = AbestiPlaylistJList.get(i).getIraupena();
						}
						
						Abestia abestiaSelected = new Abestia(idAudio, abestia, irudia, iraupena);
						Album albumSelected = new Album(album);
						Artista artistaSelected = new Musikaria(artista);
	
						try {
							dispose();
							JFrameSortu.erreprodukzioLehioa(albumSelected, artistaSelected, abestiaSelected);
							SesioAldagaiak.playlist_erreprodukzioa = true;
						} catch (SQLException | LineUnavailableException e1) {
							JOptionPane.showMessageDialog(null, "Errorea gertatu da erreproduzitzean.", "Errorea", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
	}
}
