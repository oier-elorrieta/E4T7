package view.abestiak;

import java.awt.EventQueue;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import model.Abestia;
import model.Album;
import model.Artista;
import model.Musikaria;
import model.interfazeak.IAtzeraProfilaBotoiak;
import model.metodoak.JFrameSortu;
import model.metodoak.SesioAldagaiak;
import model.metodoak.View_metodoak;
import model.sql.ArtistaDiskaDAO;
import model.sql.DiskaAbestiakDAO;
import model.sql.Konexioa;
import salbuespenak.AudioaNotFoundExcepcion;
import view.LoginV;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;

public class KantaListV extends JFrame implements IAtzeraProfilaBotoiak {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Album albumParam;
	private Artista artistaParam;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public KantaListV(Album album, Artista artista) throws SQLException {
		albumParam = album;
		artistaParam = artista;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setResizable(false);
		if (SesioAldagaiak.e_premium) {
			setTitle(album.getIzenburua() + " · " + artista.getIzena() + " - JPAM Music PREMIUM");
		} else {
			setTitle(album.getIzenburua() + " · " + artista.getIzena() + " - JPAM Music FREE");
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(495, 318, 336, 179);
		contentPane.add(scrollPane);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);
		
		JButton btnNireProfila = View_metodoak.btn_NireProfila();
		contentPane.add(btnNireProfila);
		
		JLabel lblAlbuma = new JLabel("ALBUMA - " + album.getIzenburua());
		lblAlbuma.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbuma.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAlbuma.setBounds(0, 26, 890, 27);
		contentPane.add(lblAlbuma);
		
		JLabel lblUserizena = new JLabel("");
		lblUserizena.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserizena.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblUserizena.setBounds(693, 11, 187, 34);
		lblUserizena.setText("Kaixo, " + SesioAldagaiak.bezeroa_logeatuta.getIzena() + "!");
		contentPane.add(lblUserizena);
		
		JLabel lblAukeratuAbestiBat = new JLabel("Aukeratu abesti bat:");
		lblAukeratuAbestiBat.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblAukeratuAbestiBat.setBounds(110, 64, 187, 23);
		contentPane.add(lblAukeratuAbestiBat);
		
		JList<Abestia> AbestiList = new JList();
		ArrayList<Abestia> AbestiJList = DiskaAbestiakDAO.albumAbestiakKargatu(album);
		
		DefaultListModel<Abestia> modelAbestia = new DefaultListModel<Abestia>();
		 
		for (int i = 0; i < AbestiJList.size(); i++) {
			modelAbestia.addElement(AbestiJList.get(i));
		}
		
		AbestiList.setModel(modelAbestia);
		AbestiList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		AbestiList.setFont(new Font("Verdana", Font.BOLD, 16));
		AbestiList.setBorder(new LineBorder(new Color(0, 0, 0)));
		AbestiList.setBounds(20, 98, 405, 416);
		contentPane.add(AbestiList);
		
		JLabel lblAlbumarenInformazioa = new JLabel("Albumaren informazioa:");
		lblAlbumarenInformazioa.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblAlbumarenInformazioa.setBounds(492, 64, 208, 23);
		contentPane.add(lblAlbumarenInformazioa);
		
		JTextPane txtInformazioa = new JTextPane();
		txtInformazioa.setEditable(false);
		txtInformazioa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtInformazioa.setBounds(466, 282, 392, 215);
		txtInformazioa.setText("Generoa: " + album.getGeneroa() + "\nArgitaratze-data: " + album.getUrtea() + " \n" + "Kanta kopurua: " + album.getKantaTotala());
		scrollPane.setViewportView(txtInformazioa);
		
		JLabel lblArgazkia = new JLabel("");
		lblArgazkia.setHorizontalAlignment(SwingConstants.CENTER);
		lblArgazkia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblArgazkia.setBounds(515, 98, 298, 214);
		contentPane.add(lblArgazkia);
		
		Abestia abestiIrudia = DiskaAbestiakDAO.irudiaKargatu(album);
		ImageIcon argazkiaAlbum = new ImageIcon(abestiIrudia.getIrudia().getBytes(1, (int) abestiIrudia.getIrudia().length()));
		Image img = argazkiaAlbum.getImage();
        Image imgScale = img.getScaledInstance(lblArgazkia.getWidth(), lblArgazkia.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon argazkia = new ImageIcon(imgScale);
        lblArgazkia.setIcon(argazkia);
		
		JButton btnErreproduzitu = new JButton("Erreproduzitu");
		btnErreproduzitu.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
		btnErreproduzitu.setBounds(666, 504, 165, 40);
		btnErreproduzitu.setFocusPainted(false);
		contentPane.add(btnErreproduzitu);
		
		// JARRAITU BOTOIA
		btnErreproduzitu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Abestia abestiSelected = AbestiList.getSelectedValue();
				
				if (abestiSelected == null) {
					JOptionPane.showMessageDialog(null, "Ez duzu abesti bat aukeratu!", "Errorea", JOptionPane.ERROR_MESSAGE);
				} else {
					Abestia abestiAuxSelected = new Abestia(abestiSelected.getIdAudio(), abestiSelected.getTitulua(), abestiSelected.getIraupena(), abestiSelected.getErreprodukzioak());
					dispose();
					try {
						try {
							JFrameSortu.erreprodukzioLehioa(album, artista, abestiAuxSelected);
						} catch (AudioaNotFoundExcepcion | IOException e1) {
							
						}
						DiskaAbestiakDAO.abestiaErreprodukzioaGehitu(abestiAuxSelected);
					} catch (SQLException | LineUnavailableException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		// ATZERA BOTOIA
			btnAtzera.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnAtzera();
				}
			});
			
			// NIRE PROFILA BOTOIA
			btnNireProfila.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNireProfila();
				}
			});
	}

	@Override
	public void btnAtzera() {
		dispose();
		try {
			JFrameSortu.albumakArtistakBezeroa(albumParam, artistaParam);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void btnNireProfila() {
		try {
			setVisible(false);
			JFrameSortu.erregistroMenua(KantaListV.this);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
