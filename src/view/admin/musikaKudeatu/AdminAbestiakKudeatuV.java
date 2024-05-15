package view.admin.musikaKudeatu;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Abestia;
import model.Album;
import model.Artista;
import model.Musikaria;
import model.interfazeak.IadminBotoiak;
import model.metodoak.JFrameSortu;
import model.metodoak.View_metodoak;
import model.sql.Konexioa;
import model.sql.admin.AbestiCRUD;
import model.sql.admin.AlbumaCRUD;
import model.sql.admin.ArtistaCRUD;
import view.LoginV;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class AdminAbestiakKudeatuV extends JFrame implements IadminBotoiak {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JList AbestiList;
	private ArrayList<Abestia> AbestiJList;
	private ArrayList<Album> albumList;

	private JLabel titulo_lbl;
	private JLabel iraupena_lbl;
	private JLabel album_lbl;

	private JSpinner spinner;
	private JTextField tf;
	private JSpinner.DateEditor editor;
	
	private JTextPane tituloTxtpane;
	private JComboBox albumComboBox;

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public AdminAbestiakKudeatuV() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Albumak kudeatu - ADMIN - JPAM Music");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 99, 444, 404);
		contentPane.add(scrollPane);

		AbestiList = new JList();
		AbestiList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		AbestiList.setFont(new Font("Verdana", Font.BOLD, 16));
		AbestiList.setBorder(new LineBorder(new Color(0, 0, 0)));

		AbestiJList = AbestiCRUD.abestiIzenakKargatu();
		DefaultListModel<String> modelAlbum = new DefaultListModel<String>();

		for (int i = 0; i < AbestiJList.size(); i++) {
			modelAlbum.addElement(AbestiJList.get(i).getTitulua());
		}

		AbestiList.setModel(modelAlbum);
		AbestiList.setBounds(56, 99, 444, 404);
		scrollPane.setViewportView(AbestiList);

		panel = new JPanel(new GridLayout(0, 1));
		panel.setPreferredSize(new Dimension(450, 300));

		tituloTxtpane = new JTextPane();

		titulo_lbl = new JLabel("Titulua: ");
		titulo_lbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));

		iraupena_lbl = new JLabel("Iraupena: ");
		iraupena_lbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));

		panel.add(titulo_lbl);
		panel.add(tituloTxtpane);

		panel.add(iraupena_lbl);

		album_lbl = new JLabel("Album aukera: ");
		album_lbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));

		albumComboBox = new JComboBox<String>();
		albumList = AlbumaCRUD.albumIzenakKargatu();

		for (int i = 0; i < albumList.size(); i++) {
			albumComboBox.addItem(albumList.get(i).getIzenburua());
		}

		JLabel lblArtistakKudeatu = new JLabel("ABESTIAK KUDEATU");
		lblArtistakKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtistakKudeatu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblArtistakKudeatu.setBounds(0, 21, 890, 27);
		contentPane.add(lblArtistakKudeatu);

		JLabel lblHemenArtistakKudeatu = new JLabel("Hemen abestiak kudeatu dezakezu.");
		lblHemenArtistakKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblHemenArtistakKudeatu.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblHemenArtistakKudeatu.setBounds(0, 48, 890, 34);
		contentPane.add(lblHemenArtistakKudeatu);

		JButton btnBerriaSartu = new JButton("Berria sartu");
		btnBerriaSartu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnBerriaSartu.setFocusPainted(false);
		btnBerriaSartu.setBounds(619, 201, 164, 51);
		contentPane.add(btnBerriaSartu);

		JButton btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnEzabatu.setFocusPainted(false);
		btnEzabatu.setBounds(619, 276, 164, 51);
		contentPane.add(btnEzabatu);

		JLabel lblAukerak = new JLabel("Aukerak");
		lblAukerak.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukerak.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 21));
		lblAukerak.setBounds(619, 147, 164, 23);
		contentPane.add(lblAukerak);

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

		SpinnerDateModel model = null;

		try {
			model = new SpinnerDateModel(View_metodoak.spinnerFormatuaOrdua("00:00:00"), null, null, Calendar.SECOND);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JSpinner spinner = new JSpinner(model);

		JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "HH:mm:ss");
		spinner.setEditor(editor);

		JTextField tf = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
		tf.setEditable(false);

		panel.add(spinner);
		panel.add(album_lbl);
		panel.add(albumComboBox);

		boolean errorea = false;

		do {
			int opcion = JOptionPane.showConfirmDialog(null, panel, "Album berria sartu", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE);
			java.util.Date iraupenErrorea = null;

			try {
				iraupenErrorea = View_metodoak.spinnerFormatuaOrdua("00:00:00");
			} catch (ParseException e) {
				e.printStackTrace();
			}

			if (opcion == JOptionPane.OK_OPTION) {
				String tituluaBerria = tituloTxtpane.getText();
				String iraupenaBerria = View_metodoak.spinnerFormatuaString(spinner.getValue());

				for (int i = 0; i < AbestiJList.size(); i++) {
					if (tituluaBerria.equals(AbestiJList.get(i).getTitulua())) {
						JOptionPane.showMessageDialog(null, "Abesti hori badago sartuta", "Errorea",
								JOptionPane.ERROR_MESSAGE);
						errorea = false;
						break;
					}
				}

				int idAlbum = -1;

				try {
					Konexioa.konexioaIreki();
					idAlbum = AlbumaCRUD.albumIDLortu(albumComboBox.getSelectedItem().toString());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (tituluaBerria.equals("") || iraupenaBerria == null) {
					JOptionPane.showMessageDialog(null, "Eremu guztiak bete behar dira!", "Errorea",
							JOptionPane.ERROR_MESSAGE);
					errorea = false;
				} else if (spinner.getValue().equals(iraupenErrorea)) {
					JOptionPane.showMessageDialog(null, "Iraupena ezin da izan 0!", "Errorea",
							JOptionPane.ERROR_MESSAGE);
					errorea = false;
				} else {
					try {
						AbestiCRUD.audioInsert(tituluaBerria, iraupenaBerria, idAlbum);
						JOptionPane.showMessageDialog(null, "Albuma ondo sartu da", "Egina",
								JOptionPane.INFORMATION_MESSAGE);
						errorea = true;
						dispose();
						JFrameSortu.adminAbestiakKudeatu();
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
		if (AbestiList.getSelectedValue() == null) {
			JOptionPane.showMessageDialog(null, "Ez duzu abestirik aukeratu!", "Errorea", JOptionPane.ERROR_MESSAGE);
		} else {
			for (Abestia abesti : AbestiJList) {
				if (abesti.getTitulua().equals(AbestiList.getSelectedValue())) {
					Abestia abestiSelect = abesti;

					int opcion = JOptionPane.showConfirmDialog(null, "Ziur zaude album hau ezabatu nahi duzula?",
							"Album ezabatu", JOptionPane.YES_NO_OPTION);

					if (opcion == JOptionPane.YES_OPTION) {
						try {
							AbestiCRUD.abestiDelete(abestiSelect);
							JOptionPane.showMessageDialog(null, "Abestia ondo ezabatu da", "Informazioa",
									JOptionPane.INFORMATION_MESSAGE);
							dispose();
							JFrameSortu.adminAbestiakKudeatu();
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Errorea gertatu da abestian ezabatzean", "Errorea",
									JOptionPane.ERROR_MESSAGE);
							e.printStackTrace();
						}
					}

				}
			}
		}

	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void btnUpdate() {
		if (AbestiList.getSelectedValue() == null) {
			JOptionPane.showMessageDialog(null, "Ez duzu abestirik aukeratu!", "Errorea", JOptionPane.ERROR_MESSAGE);
		} else {
			outerLoop:
			for (Abestia abesti : AbestiJList) {
				if (abesti.getTitulua().equals(AbestiList.getSelectedValue())) {
					Abestia abestiSelect = abesti;

					tituloTxtpane.setText(abestiSelect.getTitulua());
					java.util.Date iraupenaZaharra = null;

					SpinnerDateModel model = null;
					try {
						model = new SpinnerDateModel(View_metodoak.spinnerFormatuaOrdua(abestiSelect.getIraupena()),
								null, null, Calendar.SECOND);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					spinner = new JSpinner(model);

					editor = new JSpinner.DateEditor(spinner, "HH:mm:ss");
					spinner.setEditor(editor);

					tf = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
					tf.setEditable(false);

					panel.add(spinner);

					boolean errorea = false;

					do {
						int aukera = JOptionPane.showConfirmDialog(null, panel, "Aldatu Datuak",
								JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

						try {
							iraupenaZaharra = View_metodoak.spinnerFormatuaOrdua(abestiSelect.getIraupena());
						} catch (ParseException e) {

						}

						if (aukera == JOptionPane.OK_OPTION) {
							String titulua = tituloTxtpane.getText();
							String iraupena = View_metodoak.spinnerFormatuaString(spinner.getValue());
							
							for (int i = 0; i < AbestiJList.size(); i++) {
								if (titulua.equals(AbestiJList.get(i).getTitulua())) {
									JOptionPane.showMessageDialog(null, "Abesti hori badago sartuta", "Errorea",
											JOptionPane.ERROR_MESSAGE);
									errorea = true;
									dispose();
									try {
										JFrameSortu.adminAbestiakKudeatu();
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break outerLoop;
								}
							}


							if (titulua.equals("") || iraupena == null) {
								JOptionPane.showMessageDialog(null, "Eremu guztiak bete behar dira!", "Errorea",
										JOptionPane.ERROR_MESSAGE);
								errorea = false;

							} else if (titulua.equals(abestiSelect.getTitulua())
									&& spinner.getValue().equals(iraupenaZaharra)) {
								JOptionPane.showMessageDialog(null, "Ez duzu aldaketarik egin", "Informazioa",
										JOptionPane.INFORMATION_MESSAGE);
								errorea = true;
							} else {
								try {
									AbestiCRUD.abestiUpdate(abestiSelect, titulua, iraupena);
									JOptionPane.showMessageDialog(null, "Abestia eguneratu da", "Egina",
											JOptionPane.INFORMATION_MESSAGE);
									errorea = true;
									dispose();
									JFrameSortu.adminAbestiakKudeatu();
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
