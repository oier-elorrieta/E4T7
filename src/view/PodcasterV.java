package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.Album;
import model.Artista;
import model.Musikaria;
import model.Podcast;
import model.Podcaster;
import model.metodoak.JFrameSortu;
import model.metodoak.SesioAldagaiak;
import model.metodoak.View_metodoak;
import model.sql.ArtistaDiskaDAO;
import model.sql.ArtistaListDAO;
import model.sql.Konexioa;
import model.sql.PodcasterListDAO;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PodcasterV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public PodcasterV(Artista artista) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		if (SesioAldagaiak.e_premium) {
			setTitle(artista.getIzena() + " - JPAM Music PREMIUM");
		} else {
			setTitle(artista.getIzena() + " - JPAM Music FREE");
		}
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(495, 318, 336, 179);
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
		lblUserizena.setBounds(693, 11, 187, 34);
		lblUserizena.setText("Kaixo, " + SesioAldagaiak.bezeroa_logeatuta.getIzena() + "!");
		contentPane.add(lblUserizena);
		
		JLabel lblAukeratuAlbumBat = new JLabel("Aukeratu episodio bat:");
		lblAukeratuAlbumBat.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblAukeratuAlbumBat.setBounds(115, 67, 187, 23);
		contentPane.add(lblAukeratuAlbumBat);
		
		JList<Podcast> PodcastList = new JList();
		
		PodcastList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		PodcastList.setFont(new Font("Verdana", Font.BOLD, 16));
		PodcastList.setBorder(new LineBorder(new Color(0, 0, 0)));
		PodcastList.setBounds(18, 101, 405, 416);
		
		Konexioa.konexioaIreki();
		ArrayList<Podcast> PodcastJList = PodcasterListDAO.podcastKargatu(artista);
		
		DefaultListModel<Podcast> modelPodcast = new DefaultListModel<Podcast>();
		
		for (int i = 0; i < PodcastJList.size(); i++) {
			modelPodcast.addElement(PodcastJList.get(i));
		}
		PodcastList.setModel(modelPodcast);
		contentPane.add(PodcastList);
		
		Podcaster podcasterInformazioa = PodcasterListDAO.podcasterInfoKargatu(artista);
		
		JLabel lblArtista = new JLabel("PODCASTER - " + artista.getIzena());
		lblArtista.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtista.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblArtista.setBounds(-1, 25, 890, 27);
		contentPane.add(lblArtista);
		
		JLabel lblArtistarenInformazioa = new JLabel("Podcaster informazioa:");
		lblArtistarenInformazioa.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblArtistarenInformazioa.setBounds(488, 67, 208, 23);
		contentPane.add(lblArtistarenInformazioa);
		
		JLabel lblArgazkia = new JLabel(""); 
		lblArgazkia.setHorizontalAlignment(SwingConstants.CENTER);
		lblArgazkia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblArgazkia.setBounds(517, 99, 298, 214);
		contentPane.add(lblArgazkia);
		ImageIcon argazkiaPodcaster = new ImageIcon(podcasterInformazioa.getIrudia().getBytes(1, (int) podcasterInformazioa.getIrudia().length()));
		Image img = argazkiaPodcaster.getImage();
        Image imgScale = img.getScaledInstance(lblArgazkia.getWidth(), lblArgazkia.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon argazkia = new ImageIcon(imgScale);
		lblArgazkia.setIcon(argazkia);
		
		
		JButton btnJarraitu = new JButton("Jarraitu");
		btnJarraitu.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
		btnJarraitu.setFocusPainted(false);
		btnJarraitu.setBounds(678, 501, 143, 40);
		contentPane.add(btnJarraitu);
		
		JTextPane txtInformazioa = new JTextPane();
		txtInformazioa.setEditable(false);
		txtInformazioa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtInformazioa.setBounds(466, 282, 392, 215);
		txtInformazioa.setText("Deskribapena: \n" + podcasterInformazioa.getDeskribapena());
		scrollPane.setViewportView(txtInformazioa);
		
		// JARRAITU BOTOIA
		btnJarraitu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Podcast PodcastSelected = PodcastList.getSelectedValue();
				
				if (PodcastSelected == null) {
					JOptionPane.showMessageDialog(null, "Ez duzu podcast bat aukeratu!", "Errorea", JOptionPane.ERROR_MESSAGE);
				} else {
					Podcast podcastAuxSelected = new Podcast(PodcastSelected.getTitulua(), PodcastSelected.getIrudia(), PodcastSelected.getIraupena(), PodcastSelected.getKolaboratzaile());
					dispose();
					try {
						JFrameSortu.erreprodukzioLehioaPodcast(artista, podcastAuxSelected);
					} catch (SQLException | LineUnavailableException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
	
		// ATZERA BOTOIA
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					JFrameSortu.podcastDeskubrituBezeroa();
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
					JFrameSortu.erregistroMenua(PodcasterV.this);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
