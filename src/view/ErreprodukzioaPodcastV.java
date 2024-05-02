package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Abestia;
import model.Artista;
import model.Podcast;
import model.Podcaster;
import model.metodoak.JFrameSortu;
import model.metodoak.SesioAldagaiak;
import model.metodoak.View_metodoak;
import model.sql.DiskaAbestiakDAO;
import model.sql.PodcasterListDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

import javax.swing.SwingConstants;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ErreprodukzioaPodcastV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Clip clipLehena;
	private Clip clipHurrengoa;
	private Clip clipAurrekoa;
	private ArrayList<Podcast> podcastList;
	private boolean aurrekoListaamaitu = false;
	private boolean listaAmaiera = false;
	private FloatControl abiaduraKontrola;
	private float speed = 1.0f;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ErreprodukzioaPodcastV(Artista podcaster, Podcast podcast) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setResizable(false);
		setTitle(podcast.getTitulua() + " - " + podcaster.getIzena() + " | Podcast erreprodukzioa · JPAM Music");
		contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);
		
		JButton btnNireProfila = View_metodoak.btn_NireProfila();
		contentPane.add(btnNireProfila);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblErreproduzitzen = new JLabel("ERREPRODUZITZEN ORAIN...");
		lblErreproduzitzen.setHorizontalAlignment(SwingConstants.CENTER);
		lblErreproduzitzen.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblErreproduzitzen.setBounds(0, 23, 890, 27);
		contentPane.add(lblErreproduzitzen);
		
		JLabel lblKaixo = new JLabel("");
		lblKaixo.setHorizontalAlignment(SwingConstants.CENTER);
		lblKaixo.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblKaixo.setBounds(693, 11, 187, 34);
		lblKaixo.setText("Kaixo, " + SesioAldagaiak.bezero_Ondo.getIzena() + "!");
		contentPane.add(lblKaixo);
		
		JLabel lblAbestiIzena = new JLabel((String) null);
		lblAbestiIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbestiIzena.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		lblAbestiIzena.setBounds(0, 369, 890, 23);
		lblAbestiIzena.setText(podcast.getTitulua());
		contentPane.add(lblAbestiIzena);
		
		JLabel lblArtistaIzena = new JLabel((String) null);
		lblArtistaIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtistaIzena.setFont(new Font("Segoe UI Semilight", Font.ITALIC, 16));
		lblArtistaIzena.setBounds(0, 393, 890, 23);
		lblArtistaIzena.setText(podcaster.getIzena() + ", " + podcast.getKolaboratzaile());
		contentPane.add(lblArtistaIzena);
		
		JLabel lblIraupena = new JLabel((String) null);
		lblIraupena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIraupena.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblIraupena.setBounds(0, 417, 890, 23);
		lblIraupena.setText(podcast.getIraupena());
		contentPane.add(lblIraupena);
		
		JButton btnKonpartitu = new JButton("Konpartitu");
		btnKonpartitu.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnKonpartitu.setFocusPainted(false);
		btnKonpartitu.setBounds(31, 459, 136, 34);
		contentPane.add(btnKonpartitu);
		
		JButton btnAurrekoa = new JButton("<--");
		btnAurrekoa.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btnAurrekoa.setFocusPainted(false);
		btnAurrekoa.setBounds(291, 458, 89, 34);
		contentPane.add(btnAurrekoa);
		
		JButton btnPlayPause = new JButton("Play");
		btnPlayPause.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		btnPlayPause.setFocusPainted(false);
		btnPlayPause.setBounds(401, 458, 89, 34);
		contentPane.add(btnPlayPause);
		
		JButton btnHurrengoa = new JButton("-->");
		btnHurrengoa.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btnHurrengoa.setFocusPainted(false);
		btnHurrengoa.setBounds(509, 458, 89, 34);
		contentPane.add(btnHurrengoa);
		
		JLabel lblArgazkiaPodcast = new JLabel("");
		lblArgazkiaPodcast.setHorizontalAlignment(SwingConstants.CENTER);
		lblArgazkiaPodcast.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblArgazkiaPodcast.setBounds(252, 57, 388, 305);
	
		ImageIcon argazkiaPodcast = new ImageIcon(podcast.getIrudia().getBytes(1, (int) podcast.getIrudia().length()));
		Image img = argazkiaPodcast.getImage();
        Image imgScale = img.getScaledInstance(lblArgazkiaPodcast.getWidth(), lblArgazkiaPodcast.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon argazkia = new ImageIcon(imgScale);
        lblArgazkiaPodcast.setIcon(argazkia);
		contentPane.add(lblArgazkiaPodcast);
		
		JButton btnAbiadura = new JButton("1x");
		btnAbiadura.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnAbiadura.setBounds(731, 237, 121, 34);
		btnAbiadura.setFocusPainted(false);
		contentPane.add(btnAbiadura);
		
		JLabel lblAbiadura = new JLabel("Abiadura");
		lblAbiadura.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbiadura.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblAbiadura.setBounds(742, 208, 101, 23);
		contentPane.add(lblAbiadura);
		
		JLabel lblInfoLista = new JLabel("");
		lblInfoLista.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoLista.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblInfoLista.setBounds(0, 503, 890, 23);
		contentPane.add(lblInfoLista);
		
		String fileAudio = "\\\\10.5.6.223\\audios\\" + podcast.getTitulua() + ".wav";
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
					JFrameSortu.podcastKantakBezeroa(podcaster);;
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
		
		
	// AURREKO PODCASTERA JOATEKO BOTOIA
	btnAurrekoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					podcastList = PodcasterListDAO.podcastKargatu(podcaster);
					if (aurrekoListaamaitu) {
						lblInfoLista.setText("Ezin zara atzerago joan!");
					}
					for (int i = 0; i < podcastList.size(); i++) {
						if (i-1 == -1) {
							aurrekoListaamaitu = true;
						} else {
							if (podcast.getTitulua().equals(podcastList.get(i).getTitulua())) {
								String fileAudio = "\\\\10.5.6.223\\audios\\" + podcast.getTitulua() + ".wav";
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
								
								Podcast podcastAurrekoa = new Podcast(podcastList.get(i-1).getTitulua(), podcastList.get(i-1).getIrudia(), podcastList.get(i-1).getIraupena(), podcastList.get(i-1).getKolaboratzaile());
								
								if (clipLehena.isRunning()) {
									clipLehena.stop();
								}
								
								if (clipAurrekoa.isRunning()) {
									clipAurrekoa.stop();
								}
								
								dispose();
								JFrameSortu.erreprodukzioLehioaPodcast(podcaster, podcastAurrekoa);
							}
						}
						
					}
				} catch (SQLException | LineUnavailableException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		// HURRENGO PODCASTERA JOATEKO BOTOIA
		btnHurrengoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = 0;
				try {
					podcastList = PodcasterListDAO.podcastKargatu(podcaster);
					if (listaAmaiera) {
						lblInfoLista.setText("Listaren amaierara iritsi zara!");
						return;
					}
					for (; i < podcastList.size(); i++) {
						if (i == podcastList.size()-1) {	
							listaAmaiera = true;
		                    break;
						} else {
							if (podcast.getTitulua().equals(podcastList.get(i).getTitulua())) {
								String fileAudio = "\\\\10.5.6.223\\audios\\" + podcast.getTitulua() + ".wav";
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
								
								Podcast podcastHurrengoa = new Podcast(podcastList.get(i+1).getTitulua(), podcastList.get(i+1).getIrudia(), podcastList.get(i+1).getIraupena(), podcastList.get(i+1).getKolaboratzaile());
								
								if (clipLehena.isRunning()) {
									clipLehena.stop();
								}
								if (clipHurrengoa.isRunning()) {
									clipHurrengoa.stop();
								}
								
								dispose();
								JFrameSortu.erreprodukzioLehioaPodcast(podcaster, podcastHurrengoa);
							}	
						}
						
					}
				} catch (SQLException | LineUnavailableException e1) {
					e1.printStackTrace();
				}
				
			}
		});
	
	// ABIADURA ALDATZEKO BOTOIA
	btnAbiadura.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			// EZZ DOA
			if (clipLehena.isRunning()) {
				if (speed == 1.0f){
					  speed = 1.5f;
					  abiaduraKontrola.setValue(speed);
					  btnAbiadura.setText("1.5x");
				} else if (speed == 1.5f) {
					  speed = 0.5f;
					  abiaduraKontrola.setValue(speed);
					  btnAbiadura.setText("0.5x");
				} else {
					  speed = 1.0f;
					  abiaduraKontrola.setValue(speed);
					  btnAbiadura.setText("1x");
				}
		    }
		}
	});
		
		// KONPARTITZEKO BOTOIA
		btnKonpartitu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] aukerakMenu = { "Bai", "Ez" };
                int menuAukera = JOptionPane.showOptionDialog(null, "Konpartitu nahi duzu?", "Konpartitu",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, aukerakMenu, aukerakMenu[0]);
                if (menuAukera == JOptionPane.YES_OPTION) {
                	
                }
			}
		});
	}
}
