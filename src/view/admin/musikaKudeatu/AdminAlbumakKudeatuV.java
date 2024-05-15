package view.admin.musikaKudeatu;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Album;
import model.Artista;
import model.interfazeak.IadminBotoiak;
import model.metodoak.JFrameSortu;
import model.metodoak.View_metodoak;
import model.sql.admin.AlbumaCRUD;
import model.sql.admin.ArtistaCRUD;
import view.LoginV;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class AdminAlbumakKudeatuV extends JFrame implements IadminBotoiak {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JList AlbumList;
	private ArrayList<Album> AlbumakJList;

	private JLabel titulo_lbl;
	private JLabel urtea_lbl;
	private JLabel generoa_lbl;
	private JLabel musikari_lbl;

	private JTextPane titulotxtpane;
	private JDateChooser urteaDateChooser;
	private JComboBox generoaComboBox;
	private JComboBox musikariComboBox;

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public AdminAlbumakKudeatuV() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Albumak kudeatu - ADMIN - JPAM Music");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		panel = new JPanel(new GridLayout(0, 1));
		panel.setPreferredSize(new Dimension(450, 300));

		titulotxtpane = new JTextPane();

		Date maxdata = new Date();
		urteaDateChooser = new JDateChooser();
		urteaDateChooser.setLocale(new Locale("es"));
		urteaDateChooser.setDateFormatString("yyyy-MM-dd");
		urteaDateChooser.setMaxSelectableDate(maxdata);
		urteaDateChooser.getDateEditor().getUiComponent().setFocusable(false);

		generoaComboBox = new JComboBox();
		generoaComboBox.addItem("Rock");
		generoaComboBox.addItem("Flamenco");
		generoaComboBox.addItem("Jazz");
		generoaComboBox.addItem("Reggaeton");
		generoaComboBox.addItem("Pop");
		generoaComboBox.addItem("Country pop");
		generoaComboBox.addItem("Pop rock");
		generoaComboBox.addItem("Rock alternativo");

		titulo_lbl = new JLabel("Titulua: ");
		titulo_lbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));

		urtea_lbl = new JLabel("Urtea: ");
		urtea_lbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));

		generoa_lbl = new JLabel("Generoa: ");
		generoa_lbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));

		panel.add(titulo_lbl);
		panel.add(titulotxtpane);

		panel.add(urtea_lbl);
		panel.add(urteaDateChooser);

		panel.add(generoa_lbl);
		panel.add(generoaComboBox);

		musikariComboBox = new JComboBox<String>();
		for (Artista artista : ArtistaCRUD.artistaIzenakKargatu()) {
			musikariComboBox.addItem(artista.getIzena());
		}

		musikari_lbl = new JLabel("Musikaria: ");
		musikari_lbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));

		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);
		contentPane.setLayout(null);

		JLabel lblAlbumakKudeatu = new JLabel("ALBUMAK KUDEATU");
		lblAlbumakKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbumakKudeatu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblAlbumakKudeatu.setBounds(0, 17, 890, 27);
		contentPane.add(lblAlbumakKudeatu);

		JLabel lblHemenAlbumakKudeatu = new JLabel("Hemen albumak kudeatu dezakezu.");
		lblHemenAlbumakKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblHemenAlbumakKudeatu.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblHemenAlbumakKudeatu.setBounds(0, 44, 890, 34);
		contentPane.add(lblHemenAlbumakKudeatu);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 95, 444, 404);
		contentPane.add(scrollPane);

		AlbumList = new JList();
		AlbumList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		AlbumList.setFont(new Font("Verdana", Font.BOLD, 16));
		AlbumList.setBorder(new LineBorder(new Color(0, 0, 0)));

		AlbumakJList = AlbumaCRUD.albumIzenakKargatu();
		DefaultListModel<String> modelAlbum = new DefaultListModel<String>();

		for (int i = 0; i < AlbumakJList.size(); i++) {
			modelAlbum.addElement(AlbumakJList.get(i).getIzenburua());
		}

		AlbumList.setModel(modelAlbum);
		AlbumList.setBounds(56, 95, 444, 404);
		scrollPane.setViewportView(AlbumList);

		JButton btnBerriaSartu = new JButton("Berria sartu");
		btnBerriaSartu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnBerriaSartu.setFocusPainted(false);
		btnBerriaSartu.setBounds(619, 197, 164, 51);
		contentPane.add(btnBerriaSartu);

		JLabel lblAukerak = new JLabel("Aukerak");
		lblAukerak.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukerak.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 21));
		lblAukerak.setBounds(619, 143, 164, 23);
		contentPane.add(lblAukerak);

		JButton btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnEzabatu.setFocusPainted(false);
		btnEzabatu.setBounds(619, 272, 164, 51);
		contentPane.add(btnEzabatu);

		JButton btnEditatu = new JButton("Editatu");
		btnEditatu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnEditatu.setFocusPainted(false);
		btnEditatu.setBounds(619, 355, 164, 51);
		contentPane.add(btnEditatu);

		// ATZERA BOTOIA
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.adminMusikaKudeatu();
			}
		});

		// BERRIA SARTZEKO BOTOIA
		btnBerriaSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInsert();
			}
		});

		// EZABATZEKO BOTOIA
		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete();
			}
		});

		// EDITATZEKO BOTOIA
		btnEditatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdate();
			}
		});

	}

	@Override
	public void btnInsert() {
		boolean errorea = false;

		do {

			panel.add(musikari_lbl);
			panel.add(musikariComboBox);

			int opcion = JOptionPane.showConfirmDialog(null, panel, "Album berria sartu", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE);

			if (opcion == JOptionPane.OK_OPTION) {
				String titulua = titulotxtpane.getText();
				Date urtea = urteaDateChooser.getDate();
				String generoa = generoaComboBox.getSelectedItem().toString();
				String musikaria = musikariComboBox.getSelectedItem().toString();

				if (titulua.isEmpty() || urtea == null) {
					JOptionPane.showMessageDialog(null, "Datu guztiak bete behar dira!", "Errorea",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Album albumBerria = new Album(titulua, View_metodoak.dateToString(urtea), generoa);
					try {
						AlbumaCRUD.albumInsert(albumBerria, ArtistaCRUD.IdArtistaLortu(musikaria));
						JOptionPane.showMessageDialog(null, "Albuma ondo sartu da", "Egina",
								JOptionPane.INFORMATION_MESSAGE);
						errorea = true;
						dispose();
						JFrameSortu.adminAlbumakKudeatu();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Errorea gertatu da albuma sartzean", "Errorea",
								JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}
				}

			} else {
				errorea = true;
			}

		} while (!errorea);

	}

	@Override
	public void btnDelete() {
		if (AlbumList.getSelectedValue() == null) {
			JOptionPane.showMessageDialog(null, "Ez duzu artistarik aukeratu!", "Errorea", JOptionPane.ERROR_MESSAGE);
		} else {
			for (int i = 0; i < AlbumakJList.size(); i++) {
				if (AlbumakJList.get(i).getIzenburua().equals(AlbumList.getSelectedValue())) {
					Album albuma = AlbumakJList.get(i);
					int opcion = JOptionPane.showConfirmDialog(null, "Ziur zaude album hau ezabatu nahi duzula?",
							"Album ezabatu", JOptionPane.YES_NO_OPTION);

					if (opcion == JOptionPane.YES_OPTION) {
						try {
							AlbumaCRUD.albumDelete(albuma);
							JOptionPane.showMessageDialog(null, "Album ondo ezabatu da", "Informazioa",
									JOptionPane.INFORMATION_MESSAGE);
							dispose();
							JFrameSortu.adminAlbumakKudeatu();
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Errorea gertatu da albuma ezabatzean", "Errorea",
									JOptionPane.ERROR_MESSAGE);
							e.printStackTrace();
						}
					}
				}

			}
		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public void btnUpdate() {
		if (AlbumList.getSelectedValue() == null) {
			JOptionPane.showMessageDialog(null, "Ez duzu artistarik aukeratu!", "Errorea", JOptionPane.ERROR_MESSAGE);
		} else {
			for (int i = 0; i < AlbumakJList.size(); i++) {
				if (AlbumakJList.get(i).getIzenburua().equals(AlbumList.getSelectedValue())) {
					Album albuma = AlbumakJList.get(i);
					Date date = new Date(0);

					try {
						date = View_metodoak.stringToDate(albuma.getUrtea());
					} catch (ParseException e) {
						e.printStackTrace();
					}

					titulotxtpane.setText(albuma.getIzenburua());
					urteaDateChooser.setDate(date);
					generoaComboBox.setSelectedItem(albuma.getGeneroa());

					boolean errorea = false;
					do {
						int opcion = JOptionPane.showConfirmDialog(null, panel, "Aldatu Datuak",
								JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

						if (opcion == JOptionPane.OK_OPTION) {

							String titulua = titulotxtpane.getText();
							Date urtea = urteaDateChooser.getDate();
							String generoa = generoaComboBox.getSelectedItem().toString();

							if (titulua.isEmpty() || urtea == null) {
								JOptionPane.showMessageDialog(null, "Datu guztiak bete behar dira!", "Errorea",
										JOptionPane.ERROR_MESSAGE);
								
							}else if (titulua.equals(albuma.getIzenburua()) && urtea.equals(date) && generoa.equals(albuma.getGeneroa())) {
		                               
		                            JOptionPane.showMessageDialog(null, "Ez duzu aldaketarik egin", "Informazioa",
		                                    JOptionPane.INFORMATION_MESSAGE);
		                            errorea = true;
		                        	
							} else {
								Album albumBerria = new Album(titulua, View_metodoak.dateToString(urtea), generoa);
								try {
									AlbumaCRUD.albumUpdate(albuma, albumBerria);
									JOptionPane.showMessageDialog(null, "Albuma eguneratu da", "Egina",
											JOptionPane.INFORMATION_MESSAGE);
									errorea = true;
									dispose();
									JFrameSortu.adminAlbumakKudeatu();
								} catch (SQLException e) {
									JOptionPane.showMessageDialog(null, "Errorea gertatu da datuak eguneratzean",
											"Errorea", JOptionPane.ERROR_MESSAGE);
									e.printStackTrace();
								}
							}

						} else {
							errorea = true;
						}
					} while (!errorea);
				}
			}
		}
	}
}
