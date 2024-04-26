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

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
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
	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws LineUnavailableException 
	 */
	public ErreprodukzioaV(Album album, Artista artista, Abestia abesti) throws SQLException, LineUnavailableException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(abesti.getTitulua() + " - " + artista.getIzena() + " | Erreprodukzioa · JPAM Music");
		setBounds(400, 250, 906, 594);
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
		lblArgazkiaAlbum.setIcon(argazkiaAlbum);
		contentPane.add(lblArgazkiaAlbum);
		
		JLabel lblAbestiIzena = new JLabel("");
		lblAbestiIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbestiIzena.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		lblAbestiIzena.setBounds(0, 362, 890, 23);
		lblAbestiIzena.setText(abesti.getTitulua());
		contentPane.add(lblAbestiIzena);
		
		JLabel lblArtistaIzena = new JLabel("");
		lblArtistaIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtistaIzena.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
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
		
		String fileAudio = "C:\\Users\\in1dm3-d\\eclipse-workspace\\E4T7\\src\\audio\\" + abesti.getTitulua() + ".wav";
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
				
			}
		});
		
		// HURRENGO ABESTIRA JOATEKO BOTOIA
		btnHurrengoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ArrayList<Abestia> abestiList = DiskaAbestiakDAO.albumAbestiakKargatu(album);
					for (int i = 0; i < abestiList.size(); i++) {
						System.out.println(abestiList.get(i).getTitulua());
						if (i == abestiList.size()-1) {						
							JOptionPane.showMessageDialog(null, "Iritsi zara albumeko azken abestira.", "Errorea", JOptionPane.ERROR_MESSAGE);
							i = -1;
		                    break;
						} else {
							if (abesti.getTitulua().equals(abestiList.get(i).getTitulua())) {
								String fileAudio = "C:\\Users\\in1dm3-d\\eclipse-workspace\\E4T7\\src\\audio\\" + abestiList.get(i+1).getTitulua() + ".wav";
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
				dispose();
				JFrameSortu.menuaBezeroa();
			}
		});
		
		// GUSTUKORA GEHITZEKO BOTOIA
		btnGustukoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "DE MOMENTO NO FUNTZIONA!", "Errorea", JOptionPane.ERROR_MESSAGE);
			}
		});
	}
}
