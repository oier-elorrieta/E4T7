package view;

import java.awt.EventQueue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Abestia;
import model.Album;
import model.Artista;
import model.metodoak.JFrameSortu;
import model.metodoak.SesioAldagaiak;
import model.metodoak.View_metodoak;
import model.sql.ArtistaDiskaDAO;
import model.sql.DiskaAbestiakDAO;
import model.sql.MenuaPlaylistSartuAbestiakDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ErreprodukzioaV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Clip clipLehena;
	private Clip clipHurrengoa;
	private Clip clipAurrekoa;
	private boolean listaAmaiera = false;
	private ArrayList<Abestia> abestiList;
	private boolean aurrekoListaamaitu = false;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws LineUnavailableException 
	 */
	public ErreprodukzioaV(Album album, Artista artista, Abestia abesti) throws SQLException, LineUnavailableException {
		final String fileAudio = "\\\\10.5.6.223\\audios\\" + abesti.getTitulua() + ".wav";
		// ------------------------------
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(abesti.getTitulua() + " - " + artista.getIzena() + " | Erreprodukzioa · JPAM Music");
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
		
		JLabel lblKaixo = new JLabel("");
		lblKaixo.setHorizontalAlignment(SwingConstants.CENTER);
		lblKaixo.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblKaixo.setBounds(693, 11, 187, 34);
		lblKaixo.setText("Kaixo, " + SesioAldagaiak.bezero_Ondo.getIzena() + "!");
		contentPane.add(lblKaixo);
		
		JLabel lblErreproduzitzen = new JLabel("ERREPRODUZITZEN ORAIN...");
		lblErreproduzitzen.setHorizontalAlignment(SwingConstants.CENTER);
		lblErreproduzitzen.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblErreproduzitzen.setBounds(0, 23, 890, 27);
		contentPane.add(lblErreproduzitzen);
		
		JLabel lblArgazkiaAlbum = new JLabel("");
		lblArgazkiaAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		lblArgazkiaAlbum.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblArgazkiaAlbum.setBounds(272, 81, 354, 276);
		
		Abestia abestiIrudia = DiskaAbestiakDAO.irudiaKargatu(album);
		ImageIcon argazkiaAlbum = new ImageIcon(abestiIrudia.getIrudia().getBytes(1, (int) abestiIrudia.getIrudia().length()));
		Image img = argazkiaAlbum.getImage();
        Image imgScale = img.getScaledInstance(lblArgazkiaAlbum.getWidth(), lblArgazkiaAlbum.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon argazkia = new ImageIcon(imgScale);
        lblArgazkiaAlbum.setIcon(argazkia);
		contentPane.add(lblArgazkiaAlbum);
		
		JLabel lblAbestiIzena = new JLabel("");
		lblAbestiIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbestiIzena.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		lblAbestiIzena.setBounds(0, 362, 890, 23);
		lblAbestiIzena.setText(abesti.getTitulua());
		contentPane.add(lblAbestiIzena);
		
		JLabel lblArtistaIzena = new JLabel("");
		lblArtistaIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtistaIzena.setFont(new Font("Segoe UI Semilight", Font.ITALIC, 16));
		lblArtistaIzena.setBounds(0, 386, 890, 23);
		lblArtistaIzena.setText(artista.getIzena());
		contentPane.add(lblArtistaIzena);
		
		JLabel lblAlbumIzena = new JLabel("");
		lblAlbumIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbumIzena.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
		lblAlbumIzena.setBounds(0, 47, 890, 23);
		lblAlbumIzena.setText("Albuma: " + album.getIzenburua());
		contentPane.add(lblAlbumIzena);
		
		JLabel lblIraupena = new JLabel("");
		lblIraupena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIraupena.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblIraupena.setText(abesti.getIraupena());
		lblIraupena.setBounds(0, 410, 890, 23);
		contentPane.add(lblIraupena);
		
		JButton btnPlayPause = new JButton("Play");
		btnPlayPause.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		btnPlayPause.setFocusPainted(false);
		btnPlayPause.setBounds(401, 458, 89, 34);
		contentPane.add(btnPlayPause);
		
		JButton btnAurrekoa = new JButton("<--");
		btnAurrekoa.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btnAurrekoa.setBounds(291, 458, 89, 34);
		btnAurrekoa.setFocusPainted(false);
		contentPane.add(btnAurrekoa);
		
		JButton btnHurrengoa = new JButton("-->");
		btnHurrengoa.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btnHurrengoa.setBounds(509, 458, 89, 34);
		btnHurrengoa.setFocusPainted(false);
		contentPane.add(btnHurrengoa);
		
		JButton btnGustukoa = new JButton("Gustukoa");
		btnGustukoa.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnGustukoa.setBounds(620, 458, 121, 34);
		contentPane.add(btnGustukoa);
		
		JButton btnMenua = new JButton("Menua");
		btnMenua.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnMenua.setBounds(144, 458, 121, 34);
		btnMenua.setFocusPainted(false);
		contentPane.add(btnMenua);
		
		JLabel lblInfoLista = new JLabel("");
		lblInfoLista.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoLista.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblInfoLista.setBounds(0, 503, 890, 23);
		contentPane.add(lblInfoLista);

		File f = new File(fileAudio);
		AudioInputStream aui;
		
		try {
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
				try {
					if (clipLehena.isRunning()) {
						clipLehena.stop();
					}
					JFrameSortu.albumKantakBezeroa(album, artista);
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
		
		// PLAY-PAUSE BOTOIA
		btnPlayPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (clipLehena.isRunning()) {
					clipLehena.stop();
					btnPlayPause.setText("Play");
				} else {
					clipLehena.start();
					btnPlayPause.setText("Pause");
				}
			}
		});
		
		// AURREKO ABESTIRA JOATEKO BOTOIA
		btnAurrekoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					abestiList = DiskaAbestiakDAO.albumAbestiakKargatu(album);
					if (aurrekoListaamaitu) {
						lblInfoLista.setText("Ezin zara atzerago joan!");
					}
					for (int i = 0; i < abestiList.size(); i++) {
						if (i-1 == -1) {
							aurrekoListaamaitu = true;
						} else {
							if (abesti.getTitulua().equals(abestiList.get(i).getTitulua())) {
								File f = new File(fileAudio);
								AudioInputStream aui;
									
								try {
									aui = AudioSystem.getAudioInputStream(f.getAbsoluteFile());
									clipAurrekoa = AudioSystem.getClip();
									clipAurrekoa.open(aui);
								} catch (UnsupportedAudioFileException | IOException ew) {
									ew.printStackTrace();
								} catch (LineUnavailableException e1) {
									e1.printStackTrace();
								}
								
								Abestia abestiaAurrekoa = new Abestia(abestiList.get(i-1).getTitulua(), abestiList.get(i-1).getIrudia(), abestiList.get(i-1).getIraupena());
								
								if (clipLehena.isRunning()) {
									clipLehena.stop();
								}
								/*if (clipHurrengoa.isRunning()) {
									clipHurrengoa.stop();
								}*/
								if (clipAurrekoa.isRunning()) {
									clipAurrekoa.stop();
								}
								
								dispose();
								JFrameSortu.erreprodukzioLehioa(album, artista, abestiaAurrekoa);
							}
						}
						
					}
				} catch (SQLException | LineUnavailableException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		// HURRENGO ABESTIRA JOATEKO BOTOIA
		btnHurrengoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = 0;
				try {
					abestiList = DiskaAbestiakDAO.albumAbestiakKargatu(album);
					if (listaAmaiera) {
						lblInfoLista.setText("Listaren amaierara iritsi zara!");
						return;
					}
					for (; i < abestiList.size(); i++) {
						if (i == abestiList.size()-1) {	
							listaAmaiera = true;
		                    break;
						} else {
							if (abesti.getTitulua().equals(abestiList.get(i).getTitulua())) {
								File f = new File(fileAudio);
								AudioInputStream aui;
									
								try {
									aui = AudioSystem.getAudioInputStream(f.getAbsoluteFile());
									clipHurrengoa = AudioSystem.getClip();
									clipHurrengoa.open(aui);
								} catch (UnsupportedAudioFileException | IOException ew) {
									ew.printStackTrace();
								} catch (LineUnavailableException e1) {
									e1.printStackTrace();
								}
								
								Abestia abestiaHurrengoa = new Abestia(abestiList.get(i+1).getTitulua(), abestiList.get(i+1).getIrudia(), abestiList.get(i+1).getIraupena());
								
								if (clipLehena.isRunning()) {
									clipLehena.stop();
								}
								if (clipHurrengoa.isRunning()) {
									clipHurrengoa.stop();
								}
								
								dispose();
								JFrameSortu.erreprodukzioLehioa(album, artista, abestiaHurrengoa);
							}	
						}
						
					}
				} catch (SQLException | LineUnavailableException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		// MENURA JOATEKO BOTOIA
		btnMenua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrameSortu.menuErreprodukzioaAbestiakBezeroa(album, artista, abesti);
			}
		});
		
		// GUSTUKORA GEHITZEKO BOTOIA
		btnGustukoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					MenuaPlaylistSartuAbestiakDAO.gustokoanGorde(abesti);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
