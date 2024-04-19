package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.*;
import model.metodoak.JFrameSortu;
import model.metodoak.Metodoak;
import model.sql.SQLKonexioa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class Erregistroa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIzena;
	private JTextField txtErabiltzaile;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirm;
	private JTextField txtJaiotzeData;
	private JTextField txtAbizenak;
	private ResultSet hizkuntza;
	private DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
	private String hiz = "";
	private String hizkuntzaSt = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Erregistroa frame = new Erregistroa();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Erregistroa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ERREGISTROA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(0, 33, 890, 34);
		contentPane.add(lblNewLabel);
		
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
		
		SQLKonexioa.konexioaIreki();
		JComboBox comboBoxHizkuntza = new JComboBox();
		try {
		    hizkuntza = SQLKonexioa.hizkuntza();
		    while (hizkuntza.next()) {
		        comboBoxModel.addElement(hizkuntza.getString("Deskribapena"));
		    }
		    comboBoxHizkuntza.setModel(comboBoxModel);
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		SQLKonexioa.konexioaItxi();
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
		btnErregistratu.setBounds(620, 485, 194, 46);
		contentPane.add(btnErregistratu);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAtzera.setBounds(123, 485, 147, 46);
		contentPane.add(btnAtzera);
		
		JLabel lblDataformatuaYyyymmdd = new JLabel("* Data-formatua -> YYYY-MM-DD");
		lblDataformatuaYyyymmdd.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		lblDataformatuaYyyymmdd.setBounds(537, 282, 239, 26);
		contentPane.add(lblDataformatuaYyyymmdd);
		
		JButton btnPremiumErosi = new JButton("Premium erosi");
		btnPremiumErosi.setForeground(Color.BLUE);
		btnPremiumErosi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPremiumErosi.setBounds(374, 485, 185, 46);
		contentPane.add(btnPremiumErosi);
		
		// ATZERA BOTOIA
		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFrameSortu.loginMenua();
			}
		});
		
		// PREMIUM EROSTEKO BOTOIA
		btnPremiumErosi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hizkuntzaSt = Metodoak.hezkuntzaKonprobatu(hiz);
				
				LocalDate currentdate = LocalDate.now();
				String date = currentdate.getYear() + "-" + currentdate.getMonthValue() + "-" + currentdate.getDayOfMonth();
				if (passwordField.getText().equals(passwordFieldConfirm.getText())) {
					try {
						SQLKonexioa.erregistroaPremium(txtIzena.getText(), txtAbizenak.getText(), hizkuntzaSt, txtErabiltzaile.getText(), passwordField.getText(), txtJaiotzeData.getText(), date);
						dispose();
						JFrameSortu.loginMenua();
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
		});
		
		// FREE ERREGISTROAREN BOTOIA
		btnErregistratu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hiz = (String) comboBoxHizkuntza.getSelectedItem();
				hizkuntzaSt = Metodoak.hezkuntzaKonprobatu(hiz);
				
				LocalDate currentdate = LocalDate.now();
				String date = currentdate.getYear() + "-" + currentdate.getMonthValue() + "-" + currentdate.getDayOfMonth();
				if (passwordField.getText().equals(passwordFieldConfirm.getText())) {
					try {
						SQLKonexioa.erregistroaFree(txtIzena.getText(), txtAbizenak.getText(), hizkuntzaSt, txtErabiltzaile.getText(), passwordField.getText(), txtJaiotzeData.getText(), date);
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
		});
	}
}
