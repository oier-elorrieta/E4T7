package view.erreprodukzioa;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Abestia;
import model.Album;
import model.Artista;
import model.metodoak.JFrameSortu;
import model.metodoak.SesioAldagaiak;
import model.sql.DiskaAbestiakDAO;
import model.sql.IragarkiLehioaDAO;
import salbuespenak.AudioaNotFoundExcepcion;
import view.LoginV;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

public class IragarkiLehioaV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<Abestia> iragarkiList;
	private Clip clipLehena;
	private Clip clipHurrengoa;
	private ArrayList<Abestia> abestiList;
	private Abestia abestiaHurrengoa;
	private boolean listaAmaiera = false;

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public IragarkiLehioaV(Album album, Artista artista, Abestia abesti) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Iragarkiak | Erreprodukzioa · JPAM Music FREE");
		setBounds(400, 250, 906, 594);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		iragarkiList = IragarkiLehioaDAO.getIragarkiak();

		JLabel lblErreproduzitzen = new JLabel("IRAGARKIAK ERREPRODUZITZEN");
		lblErreproduzitzen.setHorizontalAlignment(SwingConstants.CENTER);
		lblErreproduzitzen.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblErreproduzitzen.setBounds(0, 28, 890, 27);
		contentPane.add(lblErreproduzitzen);

		JLabel lblKaixo = new JLabel("");
		lblKaixo.setHorizontalAlignment(SwingConstants.CENTER);
		lblKaixo.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblKaixo.setText("Kaixo, " + SesioAldagaiak.bezeroa_logeatuta.getIzena() + "!");
		lblKaixo.setBounds(693, 11, 187, 34);
		contentPane.add(lblKaixo);

		JLabel lblIragarkia = new JLabel("Iragarkia");
		lblIragarkia.setHorizontalAlignment(SwingConstants.CENTER);
		lblIragarkia.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		lblIragarkia.setBounds(0, 425, 890, 23);
		contentPane.add(lblIragarkia);

		JLabel lblArtistaIzena = new JLabel(
				"Free bezeroa zarenez, iragarkiak dituzu. Erosi Premium \"Nire profila\" atalean hau ekiditzeko!");
		lblArtistaIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtistaIzena.setFont(new Font("Segoe UI Semilight", Font.ITALIC, 17));
		lblArtistaIzena.setBounds(0, 459, 890, 23);
		contentPane.add(lblArtistaIzena);

		JLabel lblArgazkia = new JLabel("");

		lblArgazkia.setHorizontalAlignment(SwingConstants.CENTER);
		lblArgazkia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblArgazkia.setBounds(243, 66, 408, 348);

		ImageIcon imgIcon = new ImageIcon(IragarkiLehioaV.class.getResource("/images/IRAGARKIAK.jpg"));
		Image img = imgIcon.getImage();
		Image newImg = img.getScaledInstance(lblArgazkia.getWidth(), lblArgazkia.getHeight(),
				java.awt.Image.SCALE_SMOOTH);
		ImageIcon newImgIcon = new ImageIcon(newImg);
		lblArgazkia.setIcon(newImgIcon);
		contentPane.add(lblArgazkia);

		int iIragarki = (int) ((Math.random() * 4) + 1);

		String fileAudio = "\\\\10.5.6.223\\audios\\Iragarkia" + iIragarki + ".wav";
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

		clipLehena.start();

		abestiList = DiskaAbestiakDAO.albumAbestiakKargatu(album);

		Timer timer = new Timer();

		TimerTask task = new TimerTask() {
			public void run() {
				try {
					if (listaAmaiera) {
					} else {
						for (int i = 0; i < abestiList.size(); i++) {
							if (i == abestiList.size() - 1) {
								listaAmaiera = true;
								break;
							}
							if (abesti.getTitulua().equals(abestiList.get(i).getTitulua())) {
								File f = new File(fileAudio);
								AudioInputStream aui2;

								try {
									aui2 = AudioSystem.getAudioInputStream(f.getAbsoluteFile());
									clipHurrengoa = AudioSystem.getClip();
									clipHurrengoa.open(aui2);
								} catch (UnsupportedAudioFileException | IOException ew) {
									ew.printStackTrace();
								} catch (LineUnavailableException e1) {
									e1.printStackTrace();
								}

								if (i + 1 != abestiList.size()) {

								} else {
									abestiaHurrengoa = new Abestia(abestiList.get(i + 1).getTitulua(),
											abestiList.get(i + 1).getIrudia(), abestiList.get(i + 1).getIraupena());

									if (clipLehena.isRunning()) {
										clipLehena.stop();
									}
									if (clipHurrengoa.isRunning()) {
										clipHurrengoa.stop();
									}
								}

							}
						}
					}

					if (!listaAmaiera) {
						dispose();
						try {
							JFrameSortu.erreprodukzioLehioa(album, artista, abestiaHurrengoa);
						} catch (AudioaNotFoundExcepcion | IOException e) {

						}

					} else {
						dispose();
						try {
							JFrameSortu.erreprodukzioLehioa(album, artista, abesti);
						} catch (AudioaNotFoundExcepcion | IOException e) {

						}
					}

				} catch (SQLException | LineUnavailableException e) {
					e.printStackTrace();
				}

			}
		};

		timer.schedule(task, clipLehena.getMicrosecondLength() / 1000);

	}
}
