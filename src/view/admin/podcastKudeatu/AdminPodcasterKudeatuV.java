package view.admin.podcastKudeatu;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import model.Artista;
import model.interfazeak.IadminBotoiak;
import model.metodoak.JFrameSortu;
import model.metodoak.View_metodoak;
import model.sql.admin.ArtistaCRUD;
import model.sql.admin.*;
import view.LoginV;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AdminPodcasterKudeatuV extends JFrame implements IadminBotoiak {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<Artista> PodcasterJList;
	private JPanel panel;
	private JList PodcasterList;
	private JLabel izena_lbl;
	private JLabel Deskripzio_lbl;
	private JTextPane izenatxtpane;
	private JTextPane deskripziotxtpane;

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public AdminPodcasterKudeatuV() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Podcasterak kudeatu - ADMIN - JPAM Music");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);
		contentPane.setLayout(null);

		panel = new JPanel(new GridLayout(0, 1));
		panel.setPreferredSize(new Dimension(450, 300));
		izenatxtpane = new JTextPane();
		deskripziotxtpane = new JTextPane();

		izena_lbl = new JLabel("Izena: ");
		izena_lbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));

		Deskripzio_lbl = new JLabel("Deskripzioa: ");
		Deskripzio_lbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));

		panel.add(izena_lbl);
		panel.add(izenatxtpane);
		panel.add(Deskripzio_lbl);
		panel.add(deskripziotxtpane);

		izenatxtpane.setPreferredSize(new Dimension(200, 30));
		deskripziotxtpane.setPreferredSize(new Dimension(200, 30));

		PodcasterList = new JList();
		PodcasterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		PodcasterList.setFont(new Font("Verdana", Font.BOLD, 16));
		PodcasterList.setBorder(new LineBorder(new Color(0, 0, 0)));
		PodcasterList.setBounds(56, 99, 444, 404);

		PodcasterJList = PodcasterCRUD.podcasterIzenakKargatu();
		DefaultListModel<String> modelMusikari = new DefaultListModel<String>();

		for (int i = 0; i < PodcasterJList.size(); i++) {
			modelMusikari.addElement(PodcasterJList.get(i).getIzena());
		}

		PodcasterList.setModel(modelMusikari);
		contentPane.add(PodcasterList);

		JLabel lblHemenPodcasterakKudeatu = new JLabel("Hemen Podcasterak kudeatu dezakezu.");
		lblHemenPodcasterakKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblHemenPodcasterakKudeatu.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblHemenPodcasterakKudeatu.setBounds(0, 48, 890, 34);
		contentPane.add(lblHemenPodcasterakKudeatu);

		JLabel lblPodcasterakKudeatu = new JLabel("PODCASTERAK KUDEATU");
		lblPodcasterakKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblPodcasterakKudeatu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPodcasterakKudeatu.setBounds(0, 21, 890, 27);
		contentPane.add(lblPodcasterakKudeatu);

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
		boolean errorea = false;

		izenatxtpane.setText("");
		deskripziotxtpane.setText("");

		do {
			int opcion = JOptionPane.showConfirmDialog(null, panel, "Berria sartu", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE);

			if (opcion == JOptionPane.OK_OPTION) {
				String izenatxt = izenatxtpane.getText();
				String deskripziotxt = deskripziotxtpane.getText();

				for (int i = 0; i < PodcasterJList.size(); i++) {
					if (PodcasterJList.get(i).getIzena().equals(PodcasterJList.get(i).getIzena())) {
						errorea = true;
					}
				}

				if (izenatxt.isEmpty() || deskripziotxt.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ezin duzu hutsik utzi!", "Errorea", JOptionPane.ERROR_MESSAGE);
				} else if (errorea) {
					JOptionPane.showMessageDialog(null, "Podcaster hori jada existitzen da!", "Errorea",
							JOptionPane.ERROR_MESSAGE);
					errorea = false;
				} else {
					try {
						PodcasterCRUD.podcasterInsert(izenatxt, deskripziotxt);
						JOptionPane.showMessageDialog(null, "Podcaster ondo gehitu da!", "Informazioa",
								JOptionPane.INFORMATION_MESSAGE);
						dispose();
						JFrameSortu.adminPodcasterKudeatu();
						errorea = true;
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Errorea egon da Podcaster-a gehitzerakoan!", "Errorea",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			} else {
				errorea = true;
			}
		} while (!errorea);
	}

	@Override
	public void btnDelete() {
		if (PodcasterList.getSelectedValue() == null) {
			JOptionPane.showMessageDialog(null, "Ez duzu artistarik aukeratu!", "Errorea", JOptionPane.ERROR_MESSAGE);
		} else {
			for (Artista a1 : PodcasterJList) {
				if (a1.getIzena().equals(PodcasterList.getSelectedValue().toString())) {
					Artista artistaSelected = a1;
					int opcion = JOptionPane.showConfirmDialog(null, "Ziur zaude Podcaster hau ezabatu nahi duzula?",
							"Podcaster ezabatu", JOptionPane.YES_NO_OPTION);
					if (opcion == JOptionPane.YES_OPTION) {
						try {
							PodcasterCRUD.podcasterDelete(artistaSelected.getIzena());
							JOptionPane.showMessageDialog(null, "Podcaster-a ondo ezabatu da", "Informazioa",
									JOptionPane.INFORMATION_MESSAGE);
							dispose();
							JFrameSortu.adminPodcasterKudeatu();
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "Errorea egon da Podcaster-a ezabatzerakoan!",
									"Errorea", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		}
	}

	@Override
	public void btnUpdate() {
		if (PodcasterList.getSelectedValue() == null) {
			JOptionPane.showMessageDialog(null, "Ez duzu artistarik aukeratu!", "Errorea", JOptionPane.ERROR_MESSAGE);
		} else {
			for (Artista a1 : PodcasterJList) {
				if (a1.getIzena().equals(PodcasterList.getSelectedValue().toString())) {
					Artista artistaSelected = a1;
					izenatxtpane.setText(artistaSelected.getIzena());
					deskripziotxtpane.setText(artistaSelected.getDeskribapena());

					boolean errorea = false;
					do {
						int opcion = JOptionPane.showConfirmDialog(null, panel, "Aldatu Datuak",
								JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

						for (int i = 0; i < PodcasterJList.size(); i++) {
							if (PodcasterJList.get(i).getIzena().equals(PodcasterJList.get(i).getIzena())) {
								errorea = true;
							}
						}

						if (opcion == JOptionPane.OK_OPTION) {
							String izenatxt = izenatxtpane.getText();
							String deskripziotxt = deskripziotxtpane.getText();

							if (izenatxt.isEmpty() || deskripziotxt.isEmpty()) {
								JOptionPane.showMessageDialog(null, "Ezin duzu hutsik utzi", "Error",
										JOptionPane.ERROR_MESSAGE);
							} else if (izenatxt.equals(artistaSelected.getIzena())
									&& deskripziotxt.equals(artistaSelected.getDeskribapena())) {
								JOptionPane.showMessageDialog(null, "Ez duzu aldaketarik egin", "Informazioa",
										JOptionPane.INFORMATION_MESSAGE);
								errorea = true;

							} else if (errorea) {
								JOptionPane.showMessageDialog(null, "Podcaster hori jada existitzen da!", "Errorea",
										JOptionPane.ERROR_MESSAGE);
								errorea = false;
							} else {
								try {
									PodcasterCRUD.podcasterUpdate(artistaSelected.getIzena(), izenatxt, deskripziotxt);
									JOptionPane.showMessageDialog(null, "Podcaster-a ondo aldatu da!", "Informazioa",
											JOptionPane.INFORMATION_MESSAGE);
									dispose();
									JFrameSortu.adminPodcasterKudeatu();
									errorea = true;
								} catch (SQLException e1) {
									JOptionPane.showMessageDialog(null, "Errorea egon da Podcaster-a aldatzerakoan!",
											"Errorea", JOptionPane.ERROR_MESSAGE);
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
