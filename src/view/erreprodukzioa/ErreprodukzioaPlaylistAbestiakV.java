package view.erreprodukzioa;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Abestia;
import model.Album;
import model.Artista;
import model.Playlist;
import model.interfazeak.IAtzeraProfilaBotoiak;
import model.metodoak.JFrameSortu;
import model.metodoak.SesioAldagaiak;
import model.metodoak.View_metodoak;
import model.sql.MenuaPlaylistSartuAbestiakDAO;
import model.sql.PlaylistAbestiakDAO;
import view.LoginV;

public class ErreprodukzioaPlaylistAbestiakV extends JFrame implements IAtzeraProfilaBotoiak {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Clip clipLehena;
	private boolean listaAmaiera = false;
	private boolean like;
	private Abestia abestiErreproduzitzen;
	private Album albumAbestiErreproduzitzen;
	private Artista artistakAbestiErreproduzitzen;
	int index;
	private Playlist playlist;

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public ErreprodukzioaPlaylistAbestiakV(ArrayList<Abestia> abestiLista, Playlist playlist, Artista artista,
			Album album, int indexAbesti) throws SQLException {
		index = indexAbesti;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for (int i = 0; i < abestiLista.size(); i++) {
			if (index == -1) {
				index = 0;
			}
			if (index == abestiLista.size()) {
				index = 0;
				listaAmaiera = true;
			}
			abestiErreproduzitzen = abestiLista.get(index);
		}

		final String fileAudio = "\\\\10.5.6.223\\audios\\" + abestiErreproduzitzen.getTitulua() + ".wav";
		// ------------------------------
		if (playlist.getTitulua().equals("Gustokoen zerrenda")) {
			artistakAbestiErreproduzitzen = PlaylistAbestiakDAO
					.ArtistakGustokoaPlaylistKargatu(abestiErreproduzitzen.getIdAudio());
			albumAbestiErreproduzitzen = PlaylistAbestiakDAO
					.albumaGustokoaPlaylistKargatu(abestiErreproduzitzen.getIdAudio());
			for (int i = 0; i < abestiLista.size(); i++) {
				if (SesioAldagaiak.e_premium) {
					setTitle(abestiLista.get(index).getTitulua() + " - " + artistakAbestiErreproduzitzen.getIzena()
							+ " | Erreprodukzioa · JPAM Music PREMIUM");
				} else {
					setTitle(abestiLista.get(index).getTitulua() + " - " + artistakAbestiErreproduzitzen.getIzena()
							+ " | Erreprodukzioa · JPAM Music FREE");
				}
			}
		} else {
			artistakAbestiErreproduzitzen = PlaylistAbestiakDAO
					.ArtistakPlaylistKargatu(abestiErreproduzitzen.getIdAudio());
			albumAbestiErreproduzitzen = PlaylistAbestiakDAO.albumaPlaylistKargatu(abestiErreproduzitzen.getIdAudio());
			for (int i = 0; i < abestiLista.size(); i++) {
				if (SesioAldagaiak.e_premium) {
					setTitle(abestiLista.get(index).getTitulua() + " - " + artistakAbestiErreproduzitzen.getIzena()
							+ " | Erreprodukzioa · JPAM Music PREMIUM");
				} else {
					setTitle(abestiLista.get(index).getTitulua() + " - " + artistakAbestiErreproduzitzen.getIzena()
							+ " | Erreprodukzioa · JPAM Music FREE");
				}
			}
		}
		setBounds(400, 250, 906, 594);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));

		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);

		JButton btnNireProfila = View_metodoak.btn_NireProfila();
		contentPane.add(btnNireProfila);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblKaixo = new JLabel("Kaixo, " + SesioAldagaiak.bezeroa_logeatuta.getIzena() + "!");
		lblKaixo.setHorizontalAlignment(SwingConstants.CENTER);
		lblKaixo.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblKaixo.setBounds(693, 11, 187, 34);
		contentPane.add(lblKaixo);

		JLabel lblErreproduzitzen = new JLabel("ERREPRODUZITZEN ORAIN...");
		lblErreproduzitzen.setHorizontalAlignment(SwingConstants.CENTER);
		lblErreproduzitzen.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblErreproduzitzen.setBounds(0, 28, 890, 27);
		contentPane.add(lblErreproduzitzen);

		JLabel lblAlbumIzena = new JLabel("Albuma: " + albumAbestiErreproduzitzen.getIzenburua());
		lblAlbumIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbumIzena.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
		lblAlbumIzena.setBounds(0, 52, 890, 23);
		contentPane.add(lblAlbumIzena);

		JLabel lblAbestiIzena = new JLabel(abestiErreproduzitzen.getTitulua());
		lblAbestiIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbestiIzena.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		lblAbestiIzena.setBounds(0, 367, 890, 23);
		contentPane.add(lblAbestiIzena);

		JLabel lblArtistaIzena = new JLabel(artistakAbestiErreproduzitzen.getIzena());
		lblArtistaIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtistaIzena.setFont(new Font("Segoe UI Semilight", Font.ITALIC, 16));
		lblArtistaIzena.setBounds(0, 391, 890, 23);
		contentPane.add(lblArtistaIzena);

		JLabel lblIraupena = new JLabel(abestiErreproduzitzen.getIraupena());
		lblIraupena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIraupena.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblIraupena.setBounds(0, 415, 890, 23);
		contentPane.add(lblIraupena);

		JButton btnHurrengoa = new JButton("⏭");
		btnHurrengoa.setVerticalAlignment(SwingConstants.BOTTOM);
		btnHurrengoa.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		btnHurrengoa.setFocusPainted(false);
		btnHurrengoa.setBounds(509, 463, 89, 34);
		contentPane.add(btnHurrengoa);

		JButton btnPlayPause = new JButton("▶");
		btnPlayPause.setVerticalAlignment(SwingConstants.BOTTOM);
		btnPlayPause.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
		btnPlayPause.setFocusPainted(false);
		btnPlayPause.setBounds(401, 463, 89, 34);
		contentPane.add(btnPlayPause);

		JButton btnAurrekoa = new JButton("⏮");
		btnAurrekoa.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAurrekoa.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		btnAurrekoa.setFocusPainted(false);
		btnAurrekoa.setBounds(291, 463, 89, 34);
		contentPane.add(btnAurrekoa);

		JButton btnMenua = new JButton("⚙️ Menua");
		btnMenua.setVerticalAlignment(SwingConstants.BOTTOM);
		btnMenua.setHorizontalAlignment(SwingConstants.RIGHT);
		btnMenua.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 17));
		btnMenua.setFocusPainted(false);
		btnMenua.setBounds(126, 463, 143, 34);
		contentPane.add(btnMenua);

		JButton btnGustukoa;
		like = MenuaPlaylistSartuAbestiakDAO.gustokoaKargatu(abestiErreproduzitzen);
		if (like) {
			btnGustukoa = new JButton("🖤");
		} else {
			btnGustukoa = new JButton("💔");
		}
		btnGustukoa.setSelectedIcon(null);
		btnGustukoa.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
		btnGustukoa.setBounds(620, 458, 121, 34);
		btnGustukoa.setFocusPainted(false);
		contentPane.add(btnGustukoa);

		JLabel lblInfoLista = new JLabel("");
		lblInfoLista.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoLista.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblInfoLista.setBounds(0, 508, 890, 23);
		contentPane.add(lblInfoLista);

		JLabel lblArgazkiaAlbum = new JLabel();
		ImageIcon argazkiaAlbum = new ImageIcon(
				abestiErreproduzitzen.getIrudia().getBytes(1, (int) abestiErreproduzitzen.getIrudia().length()));
		Image img = argazkiaAlbum.getImage();
		ImageIcon argazkia = new ImageIcon(img);
		lblArgazkiaAlbum.setIcon(argazkia);
		lblArgazkiaAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		lblArgazkiaAlbum.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblArgazkiaAlbum.setBounds(270, 86, 356, 278);
		contentPane.add(lblArgazkiaAlbum);

		AudioInputStream aui;

		try {
			File f = new File(fileAudio);
			aui = AudioSystem.getAudioInputStream(f.getAbsoluteFile());
			clipLehena = AudioSystem.getClip();
			clipLehena.open(aui);
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}

		// ATZERA BOTOIA
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				btnAtzera();
			}
		});

		// NIRE PROFILA BOTOIA
		btnNireProfila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNireProfila();

			}
		});

		// PLAY-PAUSE BOTOIA
		btnPlayPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (clipLehena.isRunning()) {
					if (clipLehena.isActive()) {
						Long clipPos = clipLehena.getMicrosecondPosition();
						int iMin = 0;
						int secondsInt = (int) (clipPos / 1000000);
						boolean b = false;
						do {
							b = false;
							if (secondsInt >= 60) {
								iMin++;
								secondsInt -= 60;
								b = true;
							}
						} while (b);

						lblIraupena
								.setText("0" + iMin + ":" + secondsInt + " / " + abestiErreproduzitzen.getIraupena());

					}
					clipLehena.stop();
					btnPlayPause.setText("▶");
				} else {
					clipLehena.start();
					btnPlayPause.setText("⏸");
				}
			}
		});

		// AURREKO ABESTIRA JOATEKO BOTOIA
		btnAurrekoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (index == -1) {
					lblInfoLista.setText("Aurreko abestirik ez dago.");
				} else {
					dispose();
					try {
						JFrameSortu.erreprodukzioaPlaylistAbestiak(abestiLista, playlist, artista, index - 1, album);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Errore bat gertatu da. Saiatu berriro.", "Errorea",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		// HURRENGO ABESTIRA JOATEKO BOTOIA
		btnHurrengoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SesioAldagaiak.skip_abestia && !listaAmaiera) {
					SesioAldagaiak.skip_abestia = false;
					View_metodoak.skipBaimendu();
					if (!SesioAldagaiak.e_premium && SesioAldagaiak.iragarkiaIpini) {
						dispose();
						try {
							JFrameSortu.iragarkiLehioaPlaylist(abestiLista, playlist, artista, album, indexAbesti);
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "Errore bat gertatu da. Saiatu berriro.", "Errorea",
									JOptionPane.ERROR_MESSAGE);
						}
						if (clipLehena.isRunning()) {
							clipLehena.stop();
						}
						SesioAldagaiak.iragarkiaIpini = false;
					} else {
						if (index == abestiLista.size()) {
							lblInfoLista.setText("Listaren amaierara iritsi zara.");
							listaAmaiera = true;
						} else {
							dispose();
							try {
								JFrameSortu.erreprodukzioaPlaylistAbestiak(abestiLista, playlist, artista, index + 1,
										album);
							} catch (SQLException e1) {
								JOptionPane.showMessageDialog(null, "Errore bat gertatu da. Saiatu berriro.", "Errorea",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				} else if (!SesioAldagaiak.e_premium) {
					JOptionPane.showMessageDialog(null, "Ezin duzu hurrengora pasatu!", "Free Erabiltzailea",
							JOptionPane.ERROR_MESSAGE);
				} else {
					dispose();
					try {
						JFrameSortu.erreprodukzioaPlaylistAbestiak(abestiLista, playlist, artista, index + 1, album);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Errore bat gertatu da. Saiatu berriro.", "Errorea",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		// MENURA JOATEKO BOTOIA
		btnMenua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrameSortu.menuErreprodukzioaAbestiakBezeroa(album, artista, abestiErreproduzitzen);
			}
		});

		// GUSTUKORA GEHITZEKO BOTOIA
		btnGustukoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					like = MenuaPlaylistSartuAbestiakDAO.gustokoaKargatu(abestiErreproduzitzen);
					if (like) {
						btnGustukoa.setText("💔");
						MenuaPlaylistSartuAbestiakDAO.gustokoaEzabatu(abestiErreproduzitzen);
					} else {
						btnGustukoa.setText("🖤");
						MenuaPlaylistSartuAbestiakDAO.gustokoanGorde(abestiErreproduzitzen);

					}

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Errorea egon da.", "Errorea", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	@Override
	public void btnAtzera() {
		try {
			if (clipLehena.isRunning()) {
				clipLehena.stop();
			}
			if (SesioAldagaiak.playlist_erreprodukzioa) {
				SesioAldagaiak.playlist_erreprodukzioa = false;
			}
			JFrameSortu.playListAbestiak(playlist);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Errore bat gertatu da. Saiatu berriro.", "Errorea",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	@Override
	public void btnNireProfila() {
		try {
			if (clipLehena.isRunning()) {
				clipLehena.stop();
			}
			setVisible(false);
			JFrameSortu.erregistroMenua(ErreprodukzioaPlaylistAbestiakV.this);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Errore bat gertatu da. Saiatu berriro.", "Errorea",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
