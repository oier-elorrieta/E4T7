package view.admin.musikaKudeatu;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import model.Artista;
import model.Musikaria;
import model.interfazeak.IadminBotoiak;
import model.metodoak.JFrameSortu;
import model.metodoak.View_metodoak;
import model.sql.ArtistaListDAO;
import model.sql.Konexioa;
import model.sql.admin.ArtistaCRUD;
import view.LoginV;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AdminArtistakKudeatuV extends JFrame implements IadminBotoiak {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JList ArtistaList;
	private ArrayList<Artista> ArtistakJList;
	private JLabel izena_lbl;
	private JLabel Deskripzio_lbl;
	private JLabel mota_lbl;
	private JTextPane izenatxtpane;
	private JTextPane deskripziotxtpane;
	private JComboBox motaField;

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public AdminArtistakKudeatuV() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Artistak kudeatu - ADMIN - JPAM Music");
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
		izenatxtpane = new JTextPane();
		deskripziotxtpane = new JTextPane();

		izena_lbl = new JLabel("Izena: ");
		izena_lbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));

		Deskripzio_lbl = new JLabel("Deskripzioa: ");
		Deskripzio_lbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));

		mota_lbl = new JLabel("Mota: ");
		mota_lbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));

		panel.add(izena_lbl);
		panel.add(izenatxtpane);
		panel.add(Deskripzio_lbl);
		panel.add(deskripziotxtpane);

		izenatxtpane.setPreferredSize(new Dimension(200, 30));
		deskripziotxtpane.setPreferredSize(new Dimension(200, 30));
		motaField = new JComboBox();
		motaField.addItem("Bakarlaria");
		motaField.addItem("Taldea");

		ArtistaList = new JList();
		ArtistaList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ArtistaList.setFont(new Font("Verdana", Font.BOLD, 16));
		ArtistaList.setBorder(new LineBorder(new Color(0, 0, 0)));

		ArtistakJList = ArtistaCRUD.artistaIzenakKargatu();
		DefaultListModel<String> modelMusikari = new DefaultListModel<String>();

		for (int i = 0; i < ArtistakJList.size(); i++) {
			modelMusikari.addElement(ArtistakJList.get(i).getIzena());
		}

		ArtistaList.setModel(modelMusikari);
		ArtistaList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ArtistaList.setBounds(56, 96, 444, 404);
		contentPane.add(ArtistaList);

		JLabel lblArtistakKudeatu = new JLabel("ARTISTAK KUDEATU");
		lblArtistakKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtistakKudeatu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblArtistakKudeatu.setBounds(0, 21, 890, 27);
		contentPane.add(lblArtistakKudeatu);

		JLabel lblHemenArtistakKudeatu = new JLabel("Hemen artistak kudeatu dezakezu.");
		lblHemenArtistakKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblHemenArtistakKudeatu.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblHemenArtistakKudeatu.setBounds(0, 48, 890, 34);
		contentPane.add(lblHemenArtistakKudeatu);

		JButton btnBerriaSartu = new JButton("Berria sartu");
		btnBerriaSartu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnBerriaSartu.setFocusPainted(false);
		btnBerriaSartu.setBounds(619, 207, 164, 51);
		contentPane.add(btnBerriaSartu);

		JButton btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnEzabatu.setFocusPainted(false);
		btnEzabatu.setBounds(619, 282, 164, 51);
		contentPane.add(btnEzabatu);

		JLabel lblAukerak = new JLabel("Aukerak");
		lblAukerak.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukerak.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 21));
		lblAukerak.setBounds(619, 153, 164, 23);
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
		boolean errorea = false;

		do {
			panel.add(mota_lbl);
			panel.add(motaField);

			int opcion = JOptionPane.showConfirmDialog(null, panel, "Aldatu Datuak", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE);

			if (opcion == JOptionPane.OK_OPTION) {
				String izenatxt = izenatxtpane.getText();
				String deskripziotxt = deskripziotxtpane.getText();
				String motatxt = motaField.getSelectedItem().toString();

				if (izenatxt.isEmpty() || deskripziotxt.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ezin duzu hutsik utzi", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						ArtistaCRUD.artistaInsert(izenatxt, motatxt, deskripziotxt);
						JOptionPane.showMessageDialog(null, "Artista ondo gehitu da", "Informazioa",
								JOptionPane.INFORMATION_MESSAGE);
						dispose();
						JFrameSortu.adminArtistakKudeatu();
						errorea = true;
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			} else {
				errorea = true;
			}
		} while (!errorea);
	}

	@Override
	public void btnDelete() {
		if (ArtistaList.getSelectedValue() == null) {
			JOptionPane.showMessageDialog(null, "Ez duzu artistarik aukeratu!", "Errorea", JOptionPane.ERROR_MESSAGE);
		} else {
			for (Artista a1 : ArtistakJList) {
				if (a1.getIzena().equals(ArtistaList.getSelectedValue().toString())) {
					Artista artistaSelected = a1;
					int opcion = JOptionPane.showConfirmDialog(null, "Ziur zaude artista hau ezabatu nahi duzula?",
							"Artista ezabatu", JOptionPane.YES_NO_OPTION);
					if (opcion == JOptionPane.YES_OPTION) {
						try {
							ArtistaCRUD.artistaDelete(artistaSelected.getIzena());
							JOptionPane.showMessageDialog(null, "Artista ondo ezabatu da", "Informazioa",
									JOptionPane.INFORMATION_MESSAGE);
							dispose();
							JFrameSortu.adminArtistakKudeatu();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		}

	}

	@Override
	public void btnUpdate() {
	    if (ArtistaList.getSelectedValue() == null) {
	        JOptionPane.showMessageDialog(null, "Ez duzu artistarik aukeratu!", "Errorea", JOptionPane.ERROR_MESSAGE);
	    } else {
	        for (Artista a1 : ArtistakJList) {
	            if (a1.getIzena().equals(ArtistaList.getSelectedValue().toString())) {
	                Artista artistaSelected = a1;
	                izenatxtpane.setText(artistaSelected.getIzena());
	                deskripziotxtpane.setText(artistaSelected.getDeskribapena());

	                boolean errorea = false;
	                do {
	                    int opcion = JOptionPane.showConfirmDialog(null, panel, "Aldatu Datuak",
	                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

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
	                        } else {
	                            try {
	                                ArtistaCRUD.artistaUpdate(artistaSelected.getIzena(), izenatxt, deskripziotxt);
	                                JOptionPane.showMessageDialog(null, "Artista ondo aldatu dira", "Informazioa",
	                                        JOptionPane.INFORMATION_MESSAGE);
	                                dispose();
	                                JFrameSortu.adminArtistakKudeatu();
	                                errorea = true; 
	                            } catch (SQLException e1) {
	                                e1.printStackTrace();
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
