package view.admin.podcastKudeatu;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import model.Artista;
import model.Podcast;
import model.Podcaster;
import model.interfazeak.IadminBotoiak;
import model.metodoak.JFrameSortu;
import model.metodoak.View_metodoak;
import model.sql.Konexioa;
import model.sql.admin.AbestiCRUD;
import model.sql.admin.PodcastCRUD;
import model.sql.admin.PodcasterCRUD;
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

public class AdminPodcastKudeatuV extends JFrame implements IadminBotoiak {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private ArrayList<Podcast> PodcastJList;
	private JList PodcastList;

	private JSpinner spinner;
	private JTextField tf;
	private JSpinner.DateEditor editor;
	private SpinnerDateModel spinnerModel;

	private JLabel titulo_lbl;
	private JLabel iraupena_lbl;
	private JLabel kolaboratzaile_lbl;
	private JLabel podcaster_lbl;

	private JTextPane tituloTxtpane;
	private JTextPane kolaboratzaileTxtpane;
	
	private JComboBox podcasterComboBox;
	private ArrayList<Artista> PodcasterJList;
	
	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public AdminPodcastKudeatuV() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Podcastak kudeatu - ADMIN - JPAM Music");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);

		panel = new JPanel(new GridLayout(0, 1));
		panel.setPreferredSize(new Dimension(450, 300));

		PodcastList = new JList();
		PodcastList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		PodcastList.setFont(new Font("Verdana", Font.BOLD, 16));
		PodcastList.setBorder(new LineBorder(new Color(0, 0, 0)));
		PodcastList.setBounds(56, 99, 444, 404);
		contentPane.add(PodcastList);

		PodcastJList = PodcastCRUD.podcastIzenakKargatu();
		DefaultListModel<String> modelPodcast = new DefaultListModel<String>();

		for (Podcast podcast : PodcastJList) {
			modelPodcast.addElement(podcast.getTitulua());
		}

		PodcastList.setModel(modelPodcast);
		contentPane.add(panel);

		spinnerModel = new SpinnerDateModel();
		spinner = new JSpinner(spinnerModel);
		editor = new JSpinner.DateEditor(spinner, "HH:mm:ss");
		spinner.setEditor(editor);
		tf = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
		tf.setEditable(false);

		titulo_lbl = new JLabel("Titulua: ");
		titulo_lbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));

		iraupena_lbl = new JLabel("Iraupena: ");
		iraupena_lbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));

		kolaboratzaile_lbl = new JLabel("Kolaboratzaileak: ");
		kolaboratzaile_lbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));

		tituloTxtpane = new JTextPane();
		kolaboratzaileTxtpane = new JTextPane();

		panel.add(titulo_lbl);
		panel.add(tituloTxtpane);

		panel.add(iraupena_lbl);
		
		podcaster_lbl = new JLabel("Podcaster-a: ");
		podcaster_lbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		
		podcasterComboBox = new JComboBox<String>();
		PodcasterJList = PodcasterCRUD.podcasterIzenakKargatu();
		
		for (int i = 0; i < PodcasterJList.size(); i++) {
			podcasterComboBox.addItem(PodcasterJList.get(i).getIzena());
		}
		

		JLabel lblHemenPodcastakKudeatu = new JLabel("Hemen Podcastak kudeatu dezakezu.");
		lblHemenPodcastakKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblHemenPodcastakKudeatu.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblHemenPodcastakKudeatu.setBounds(0, 48, 890, 34);
		contentPane.add(lblHemenPodcastakKudeatu);

		JLabel lblPodcastakKudeatu = new JLabel("PODCASTAK KUDEATU");
		lblPodcastakKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblPodcastakKudeatu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPodcastakKudeatu.setBounds(0, 21, 890, 27);
		contentPane.add(lblPodcastakKudeatu);

		JLabel lblAukerak = new JLabel("Aukerak");
		lblAukerak.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukerak.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 21));
		lblAukerak.setBounds(619, 147, 164, 23);
		contentPane.add(lblAukerak);

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

		JButton btnEditatu = new JButton("Editatu");
		btnEditatu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnEditatu.setFocusPainted(false);
		btnEditatu.setBounds(619, 355, 164, 51);
		contentPane.add(btnEditatu);

		// ATZERA BOTOIA
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.adminMenuaPodcastKudeatu();
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

		panel.add(spinner);

		try {
			java.util.Date newDate = View_metodoak.spinnerFormatuaOrdua("00:00:00");
			spinnerModel.setValue(newDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		panel.add(kolaboratzaile_lbl);
		panel.add(kolaboratzaileTxtpane);
		
		panel.add(podcaster_lbl);
		panel.add(podcasterComboBox);

		boolean errorea = false;
		tituloTxtpane.setText("");
		kolaboratzaileTxtpane.setText("");

		do {
			int opcion = JOptionPane.showConfirmDialog(null, panel, "Podcast berria sartu", JOptionPane.OK_CANCEL_OPTION,
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
				String KolaboratzaileBerria = kolaboratzaileTxtpane.getText();
				
				Konexioa.konexioaIreki();
				String IdPodcaster = "-1";
				try {
					IdPodcaster = PodcasterCRUD.IdPodcasterLortu(podcasterComboBox.getSelectedItem().toString());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (KolaboratzaileBerria.equals("")) {
					KolaboratzaileBerria = "Inork";
				}
				
				Podcast podcastBerria = new Podcast(tituluaBerria, null, iraupenaBerria, KolaboratzaileBerria);

				for (int i = 0; i < PodcastJList.size(); i++) {
					if (tituluaBerria.equals(PodcastJList.get(i).getTitulua())) {
						errorea = true;
					}
				}
				
				if (tituluaBerria.equals("") || iraupenaBerria == null) {
					JOptionPane.showMessageDialog(null, "Eremu guztiak bete behar dira!", "Errorea",
							JOptionPane.ERROR_MESSAGE);
					errorea = false;
				} else if (spinner.getValue().equals(iraupenErrorea)) {
					JOptionPane.showMessageDialog(null, "Iraupena ezin da izan 0!", "Errorea",
							JOptionPane.ERROR_MESSAGE);
					errorea = false;
				}else if (errorea == true) {

					JOptionPane.showMessageDialog(null, "Podcast badago sartuta", "Errorea", JOptionPane.ERROR_MESSAGE);
					errorea = false;

				} else {
					try {
						PodcastCRUD.podcastAudio(podcastBerria, IdPodcaster);
						JOptionPane.showMessageDialog(null, "Podcast ondo sartu da", "Egina",
								JOptionPane.INFORMATION_MESSAGE);
						errorea = true;
						dispose();
						JFrameSortu.adminPodcastKudeatu();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Errorea gertatu da podcast sartzean", "Errorea",
								JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}

				}

			}else {
				errorea = true;
			}

		} while (!errorea);

	}

	@Override
	public void btnDelete() {
		if (PodcastList.getSelectedValue() == null) {
			JOptionPane.showMessageDialog(null, "Ez duzu podcast aukeratu!", "Errorea", JOptionPane.ERROR_MESSAGE);
		} else {
			for (Podcast podcast : PodcastJList) {
				if (podcast.getTitulua().equals(PodcastList.getSelectedValue())) {

					Podcast podcastSelect = podcast;

					int opcion = JOptionPane.showConfirmDialog(null, "Ziur zaude podcast hau ezabatu nahi duzula?",
							"Podcast ezabatu", JOptionPane.YES_NO_OPTION);

					if (opcion == JOptionPane.YES_OPTION) {
						try {
							PodcastCRUD.podcastDelete(podcast);
							JOptionPane.showMessageDialog(null, "Podcast ondo ezabatu da", "Informazioa",
									JOptionPane.INFORMATION_MESSAGE);
							dispose();
							JFrameSortu.adminPodcastKudeatu();
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

	@Override
	public void btnUpdate() {
		if (PodcastList.getSelectedValue() == null) {
			JOptionPane.showMessageDialog(null, "Ez duzu podcast aukeratu!", "Errorea", JOptionPane.ERROR_MESSAGE);
		} else {

			panel.remove(kolaboratzaile_lbl);
			panel.remove(kolaboratzaileTxtpane);
			panel.add(spinner);

			java.util.Date iraupenErrorea = null;

			try {
				iraupenErrorea = View_metodoak.spinnerFormatuaOrdua("00:00:00");
			} catch (ParseException e) {
				e.printStackTrace();
			}

			for (Podcast podcast : PodcastJList) {
				if (podcast.getTitulua().equals(PodcastList.getSelectedValue())) {

					Podcast podcastSelect = podcast;

					tituloTxtpane.setText(podcastSelect.getTitulua());
					java.util.Date iraupenaZaharra = null;

					try {
						java.util.Date newDate = View_metodoak.spinnerFormatuaOrdua(podcastSelect.getIraupena());
						spinnerModel.setValue(newDate);
					} catch (ParseException e) {
						e.printStackTrace();
					}

					boolean errorea = false;

					do {
						int aukera = JOptionPane.showConfirmDialog(null, panel, "Aldatu Datuak",
								JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

						try {
							iraupenaZaharra = View_metodoak.spinnerFormatuaOrdua(podcastSelect.getIraupena());
						} catch (ParseException e) {

						}

						if (aukera == JOptionPane.OK_OPTION) {
							String titulua = tituloTxtpane.getText();
							String iraupena = View_metodoak.spinnerFormatuaString(spinner.getValue());

							Podcast podcastBerria = new Podcast(titulua, null, iraupena, null);

							for (int i = 0; i < PodcastJList.size(); i++) {
								if (titulua.equals(PodcastJList.get(i).getTitulua())) {
									errorea = true;
								}
							}

							if (titulua.equals("") || iraupena == null) {
								JOptionPane.showMessageDialog(null, "Eremu guztiak bete behar dira!", "Errorea",
										JOptionPane.ERROR_MESSAGE);
								errorea = false;

							} else if (titulua.equals(podcastSelect.getTitulua())
									&& spinner.getValue().equals(iraupenaZaharra)) {
								JOptionPane.showMessageDialog(null, "Ez duzu aldaketarik egin", "Informazioa",
										JOptionPane.INFORMATION_MESSAGE);
								errorea = true;
							} else if (spinner.getValue().equals(iraupenErrorea)) {
								JOptionPane.showMessageDialog(null, "Iraupena ezin da izan 0!", "Errorea",
										JOptionPane.ERROR_MESSAGE);
								errorea = false;
							} else if (errorea == true) {
								JOptionPane.showMessageDialog(null, "Podcast hori badago sartuta", "Errorea",
										JOptionPane.ERROR_MESSAGE);
								errorea = false;

							} else {
								try {
									PodcastCRUD.podcastUpdate(podcastSelect, podcastBerria);
									JOptionPane.showMessageDialog(null, "Podcast eguneratu da", "Egina",
											JOptionPane.INFORMATION_MESSAGE);
									errorea = true;
									dispose();
									JFrameSortu.adminPodcastKudeatu();
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
