package view.abestiak;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

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
import model.metodoak.JFrameSortu;
import model.metodoak.SesioAldagaiak;
import model.metodoak.View_metodoak;
import model.sql.ArtistaDiskaDAO;
import model.sql.ArtistaListDAO;
import model.sql.Konexioa;
import view.LoginV;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ArtistaV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public ArtistaV(Artista artista) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setResizable(false);
		if (SesioAldagaiak.e_premium) {
			setTitle(artista.getIzena() + " - JPAM Music PREMIUM");
		} else {
			setTitle(artista.getIzena() + " - JPAM Music FREE");
		}

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

		JLabel lblAukeratuAlbumBat = new JLabel("Aukeratu album bat:");
		lblAukeratuAlbumBat.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblAukeratuAlbumBat.setBounds(115, 67, 187, 23);
		contentPane.add(lblAukeratuAlbumBat);

		JList<Album> AlbumList = new JList();

		AlbumList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		AlbumList.setFont(new Font("Verdana", Font.BOLD, 16));
		AlbumList.setBorder(new LineBorder(new Color(0, 0, 0)));
		AlbumList.setBounds(18, 101, 405, 416);

		Konexioa.konexioaIreki();
		ArrayList<Album> AlbumakJList = ArtistaDiskaDAO.albumAbestiakKargatu(artista);

		DefaultListModel<Album> modelAlbum = new DefaultListModel<Album>();

		for (int i = 0; i < AlbumakJList.size(); i++) {
			modelAlbum.addElement(AlbumakJList.get(i));
		}
		AlbumList.setModel(modelAlbum);
		contentPane.add(AlbumList);

		Musikaria artistInformazioa = ArtistaDiskaDAO.irudiaDeskribapenaKargatu(artista);

		JLabel lblArtista = new JLabel("ARTISTA - " + artista.getIzena());
		lblArtista.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtista.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblArtista.setBounds(-1, 25, 890, 27);
		contentPane.add(lblArtista);

		JLabel lblArtistarenInformazioa = new JLabel("Artistaren informazioa:");
		lblArtistarenInformazioa.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblArtistarenInformazioa.setBounds(488, 67, 208, 23);
		contentPane.add(lblArtistarenInformazioa);

		JLabel lblArgazkia = new JLabel("");
		lblArgazkia.setHorizontalAlignment(SwingConstants.CENTER);
		lblArgazkia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblArgazkia.setBounds(517, 99, 298, 214);
		ImageIcon argazkiaArtist = new ImageIcon(
				artistInformazioa.getIrudia().getBytes(1, (int) artistInformazioa.getIrudia().length()));
		Image img = argazkiaArtist.getImage();
		Image imgScale = img.getScaledInstance(lblArgazkia.getWidth(), lblArgazkia.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon argazkia = new ImageIcon(imgScale);
		lblArgazkia.setIcon(argazkia);
		contentPane.add(lblArgazkia);

		JButton btnJarraitu = new JButton("Jarraitu");
		btnJarraitu.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
		btnJarraitu.setBounds(678, 501, 143, 40);
		btnJarraitu.setFocusPainted(false);
		contentPane.add(btnJarraitu);

		JTextPane txtInformazioa = new JTextPane();
		txtInformazioa.setEditable(false);
		txtInformazioa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtInformazioa.setBounds(466, 282, 392, 215);
		txtInformazioa.setText("Deskribapena: \n" + artistInformazioa.getDeskribapena());
		scrollPane.setViewportView(txtInformazioa);

		// JARRAITU BOTOIA
		btnJarraitu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Album albumSelected = AlbumList.getSelectedValue();

				if (albumSelected == null) {
					JOptionPane.showMessageDialog(null, "Ez duzu album bat aukeratu!", "Errorea",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Album albumAuxSelected = new Album(albumSelected.getIzenburua(), albumSelected.getUrtea(),
							albumSelected.getKantaTotala(), albumSelected.getGeneroa());
					try {

						if (albumSelected.getKantaTotala() == 0) {
							JOptionPane.showMessageDialog(null, "Album honek ez du kantarik!", "Errorea",
									JOptionPane.ERROR_MESSAGE);
						} else {
							dispose();
							JFrameSortu.albumKantakBezeroa(albumAuxSelected, artista);
						}

					} catch (SQLException e1) {
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
					JFrameSortu.musikaDeskubrituBezeroa();
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
					setVisible(false);
					JFrameSortu.erregistroMenua(ArtistaV.this);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
