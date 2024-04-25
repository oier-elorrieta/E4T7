package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.E_Free;
import model.E_Premium;
import model.Hizkuntza;
import model.metodoak.JFrameSortu;
import model.metodoak.SesioAldagaiak;
import model.metodoak.View_metodoak;
import model.sql.ErregistroDAO;
import model.sql.HizkuntzaDAO;
import model.sql.Konexioa;
import salbuespenak.DataBalidazioaException;

public class ErregistroaV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIzena;
	private JTextField txtErabiltzaile;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirm;
	private JTextField txtJaiotzeData;
	private JTextField txtAbizenak;
	private ArrayList<Hizkuntza> hizkuntzakList;
	private DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
	private String hizkuntzaSt = "";
	private Date dateJaioData;
	private int hiz = 0;
	boolean premiumKonprobatu = false;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ErregistroaV() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblErregistroa = new JLabel("ERREGISTROA");
		lblErregistroa.setHorizontalAlignment(SwingConstants.CENTER);
		lblErregistroa.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblErregistroa.setBounds(0, 33, 890, 34);
		contentPane.add(lblErregistroa);
		
		JLabel lblNireProfila = new JLabel("NIRE PROFILA");
		lblNireProfila.setHorizontalAlignment(SwingConstants.CENTER);
		lblNireProfila.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNireProfila.setBounds(0, 33, 890, 34);
		
		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIzena.setBounds(141, 104, 74, 26);
		contentPane.add(lblIzena);
		
		JLabel lblErabiltzailea = new JLabel("Erabiltzailea:");
		lblErabiltzailea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblErabiltzailea.setBounds(141, 160, 105, 26);
		contentPane.add(lblErabiltzailea);
		
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPasahitza.setBounds(141, 219, 91, 26);
		contentPane.add(lblPasahitza);
		
		JLabel lblKonfirmatuPasahitza = new JLabel("Konfirmatu pasahitza:");
		lblKonfirmatuPasahitza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKonfirmatuPasahitza.setBounds(473, 219, 163, 26);
		contentPane.add(lblKonfirmatuPasahitza);
		
		JLabel lblJaiotzeData = new JLabel("Jaiotze-data:");
		lblJaiotzeData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJaiotzeData.setBounds(141, 281, 105, 26);
		contentPane.add(lblJaiotzeData);
		
		txtIzena = new JTextField();
		txtIzena.setBounds(250, 104, 231, 25);
		contentPane.add(txtIzena);
		txtIzena.setColumns(10);
		
		txtErabiltzaile = new JTextField();
		txtErabiltzaile.setColumns(10);
		txtErabiltzaile.setBounds(250, 160, 298, 25);
		contentPane.add(txtErabiltzaile);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(250, 219, 202, 25);
		contentPane.add(passwordField);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setBounds(646, 219, 202, 25);
		contentPane.add(passwordFieldConfirm);
		
		txtJaiotzeData = new JTextField();
		txtJaiotzeData.setColumns(10);
		txtJaiotzeData.setBounds(250, 281, 277, 25);
		contentPane.add(txtJaiotzeData);
		
		JLabel lblHizkuntza = new JLabel("Hizkuntza:");
		lblHizkuntza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHizkuntza.setBounds(141, 341, 91, 26);
		contentPane.add(lblHizkuntza);
		
		Konexioa.konexioaIreki();
		JComboBox comboBoxHizkuntza = new JComboBox();
		
		hizkuntzakList = HizkuntzaDAO.hizkuntza();
		
		for (int i = 0; i < hizkuntzakList.size(); i++) {
			comboBoxModel.addElement(hizkuntzakList.get(i).getDeskribapena());
		}
		
		comboBoxHizkuntza.setModel(comboBoxModel);
		comboBoxHizkuntza.setSelectedIndex(0);
		
		Konexioa.konexioaItxi();
		comboBoxHizkuntza.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxHizkuntza.setBounds(250, 344, 126, 22);
		contentPane.add(comboBoxHizkuntza);
		
		JLabel lblAbizena = new JLabel("Abizenak:");
		lblAbizena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAbizena.setBounds(511, 104, 80, 26);
		contentPane.add(lblAbizena);
		
		txtAbizenak = new JTextField();
		txtAbizenak.setColumns(10);
		txtAbizenak.setBounds(601, 104, 256, 25);
		contentPane.add(txtAbizenak);
		
		JButton btnErregistratu = new JButton("Erregistratu (Free)");
		btnErregistratu.setForeground(Color.RED);
		btnErregistratu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnErregistratu.setBounds(623, 484, 194, 46);
		btnErregistratu.setFocusPainted(false);
		contentPane.add(btnErregistratu);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAtzera.setBounds(123, 485, 147, 46);
		btnAtzera.setFocusPainted(false);
		contentPane.add(btnAtzera);
		
		JLabel lblDataformatuaYyyymmdd = new JLabel("* Data-formatua -> YYYY-MM-DD");
		lblDataformatuaYyyymmdd.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		lblDataformatuaYyyymmdd.setBounds(537, 282, 239, 26);
		contentPane.add(lblDataformatuaYyyymmdd);
		
		JButton btnPremiumErosi = new JButton("Premium erosi");
		btnPremiumErosi.setForeground(Color.BLUE);
		btnPremiumErosi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPremiumErosi.setBounds(368, 484, 185, 46);
		btnPremiumErosi.setFocusPainted(false);
		contentPane.add(btnPremiumErosi);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		btnLogout.setForeground(Color.RED);
		btnLogout.setFocusPainted(false);
		btnLogout.setBounds(725, 13, 133, 43);
		
		JButton btnEditatu = new JButton("Editatu profila");
		btnEditatu.setForeground(Color.RED);
		btnEditatu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditatu.setFocusPainted(false);
		btnEditatu.setBounds(362, 409, 194, 46);
		
		
		
		// LOGEATUTA BADAGO, ATERA PROFILA EDITATZEKO AUKERA GUZTIAK
		if (SesioAldagaiak.logeatuta) {
			contentPane.add(btnEditatu);
			contentPane.add(lblNireProfila);
			contentPane.add(btnLogout);
			btnErregistratu.setEnabled(false);
			lblErregistroa.setText("");
			lblErregistroa.setBounds(0, 2, 100, 2);
		}
		
		if (premiumKonprobatu) {
			btnPremiumErosi.setEnabled(false);
		}
		
		// LOGOUT BOTOIA
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SesioAldagaiak.bezero_Ondo = null;
				SesioAldagaiak.logeatuta = false;
				SesioAldagaiak.e_premium = false;
				dispose();
				JFrameSortu.loginMenua();
			}
		});
		
		// ATZERA BOTOIA
		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SesioAldagaiak.logeatuta) {
					dispose();
					JFrameSortu.menuaBezeroa();
				} else {
					dispose();
					JFrameSortu.loginMenua();
				}
			}
		});
		
		// PREMIUM EROSTEKO BOTOIA
		btnPremiumErosi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// HIZKUNTZA KONPROBATZEKO METODOA
				hiz = comboBoxHizkuntza.getSelectedIndex();
				hizkuntzaSt = hizkuntzakList.get(hiz).getId();
				// PREMIUM BADA, EZ UTZI EROSTEN BERRIZ
				if (SesioAldagaiak.e_premium) {
					JOptionPane.showMessageDialog(null, "Premium erabiltzailea zara jada!", "Errorea", JOptionPane.ERROR_MESSAGE);
				} else {
					// PASAHITZA HARTU FORMULARIOTIK
					char[] charPass = passwordField.getPassword();
			        String passwdErabil = new String(charPass);
					// KONPROBATU FORMULARIOA BETETA DAGOEN
					if (passwdErabil.isEmpty() || txtIzena.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Formularioa bete behar duzu!", "Errorea", JOptionPane.ERROR_MESSAGE);
					} else {
						// PREMIUM DEN KONPROBATU
						try {
							premiumKonprobatu = ErregistroDAO.konprabatuPremium();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						// JAIOTZE DATA HARTU ETA PARSEATU + BALIDAZIOA
						try {
							String dateInString = txtJaiotzeData.getText();
							View_metodoak.dataBalidatu(dateInString);
							String DateSplit[] = dateInString.split("-");
							dateJaioData = new Date((Integer.parseInt(DateSplit[0])-1900),(Integer.parseInt(DateSplit[1])-1),Integer.parseInt(DateSplit[2]));
						} catch (DataBalidazioaException e2) {
							new DataBalidazioaException();
						}
						
						// GEHITU URTE BAT GAURKO EGUNARI - PREMIUM
						LocalDate UrteGehituPremium = LocalDate.now().plusYears(1);
						Date iraunData = java.sql.Date.valueOf(UrteGehituPremium);
						// OBJEKTUAN SARTU BEZEROA
						SesioAldagaiak.bezero_Ondo = new E_Premium(txtErabiltzaile.getText(), passwdErabil, txtIzena.getText(), txtAbizenak.getText(), hizkuntzaSt, dateJaioData, iraunData);
						
						// PASAHITZAK KOINTZIDITZEN BADIRA, ERREGISTROA EGIN
						if (passwdErabil.equals(passwordFieldConfirm.getText())) {
							try {
								ErregistroDAO.erregistroaPremium(SesioAldagaiak.bezero_Ondo);
								SesioAldagaiak.e_premium = true;
				                SesioAldagaiak.logeatuta = true;
								dispose();
								JFrameSortu.menuaBezeroa();
							} catch (ClassNotFoundException e1) {
								JOptionPane.showMessageDialog(null, "Errorea egon da erregistratzean!", "Errorea", JOptionPane.ERROR_MESSAGE);
								e1.printStackTrace();
							} catch (SQLException e1) {
								JOptionPane.showMessageDialog(null, "Errorea egon da datu basearen konexioarekin!", "Errorea", JOptionPane.ERROR_MESSAGE);
								e1.printStackTrace();
							}
						} else {
							JOptionPane.showMessageDialog(null, "Pasahitzak ez dira berdinak!", "Errorea", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				
			}
		});
		
		// FREE ERREGISTROAREN BOTOIA
		btnErregistratu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// HARTU FORMULARIOTIK HIZKUNTZA AUKERA
				hiz = comboBoxHizkuntza.getSelectedIndex();
				hizkuntzaSt = hizkuntzakList.get(hiz).getId();
				if (SesioAldagaiak.logeatuta) {
					JOptionPane.showMessageDialog(null, "Erregistratuta zaude jada!", "Errorea", JOptionPane.ERROR_MESSAGE);
				} else {
					// PASAHITZA HARTU FORMULARIOTIK
					char[] charPass = passwordField.getPassword();
			        String passwdErabil = new String(charPass);
					if (passwdErabil.isEmpty() || txtIzena.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Formularioa bete behar duzu!", "Errorea", JOptionPane.ERROR_MESSAGE);
					} else {
						// JAIOTZE DATA HARTU ETA PARSEATU + BALIDAZIOA
						try {
							String dateInString = txtJaiotzeData.getText();
							View_metodoak.dataBalidatu(dateInString);
							String DateSplit[] = dateInString.split("-");
							dateJaioData = new Date((Integer.parseInt(DateSplit[0])-1900),(Integer.parseInt(DateSplit[1])-1),Integer.parseInt(DateSplit[2]));
						} catch (DataBalidazioaException e2) {
							new DataBalidazioaException();
						}
						
						SesioAldagaiak.bezero_Ondo = new E_Free(txtErabiltzaile.getText(), passwdErabil, txtIzena.getText(), txtAbizenak.getText(), hizkuntzaSt, dateJaioData);

						if (passwdErabil.equals(passwordFieldConfirm.getText())) {
							try {
								ErregistroDAO.erregistroaFree(SesioAldagaiak.bezero_Ondo);
								dispose();
								SesioAldagaiak.e_premium = false;
				                SesioAldagaiak.logeatuta = true;
								JFrameSortu.menuaBezeroa();
							} catch (ClassNotFoundException e1) {
								JOptionPane.showMessageDialog(null, "Errorea egon da erregistratzean!", "Errorea", JOptionPane.ERROR_MESSAGE);
								e1.printStackTrace();
							} catch (SQLException e1) {
								JOptionPane.showMessageDialog(null, "Errorea egon da datu basearen konexioarekin!", "Errorea", JOptionPane.ERROR_MESSAGE);
								e1.printStackTrace();
							}
						} else {
							JOptionPane.showMessageDialog(null, "Pasahitzak ez dira berdinak!", "Errorea", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				
			}
		});
	}
}