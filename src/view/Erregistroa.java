package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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

public class Erregistroa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIzena;
	private JTextField txtErabiltzaile;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirm;
	private JTextField txtJaiotzeData;
	private JTextField txtErregistroData;
	private JTextField txtPremiumAzkenEguna;
	private JTextField txtAbizenak;

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
		lblIzena.setBounds(144, 87, 74, 26);
		contentPane.add(lblIzena);
		
		JLabel lblErabiltzailea = new JLabel("Erabiltzailea:");
		lblErabiltzailea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblErabiltzailea.setBounds(144, 143, 105, 26);
		contentPane.add(lblErabiltzailea);
		
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPasahitza.setBounds(144, 202, 91, 26);
		contentPane.add(lblPasahitza);
		
		JLabel lblKonfirmatuPasahitza = new JLabel("Konfirmatu pasahitza:");
		lblKonfirmatuPasahitza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKonfirmatuPasahitza.setBounds(476, 202, 163, 26);
		contentPane.add(lblKonfirmatuPasahitza);
		
		JLabel lblJaiotzeData = new JLabel("Jaiotze-data:");
		lblJaiotzeData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJaiotzeData.setBounds(144, 264, 105, 26);
		contentPane.add(lblJaiotzeData);
		
		JLabel lblErregistroData = new JLabel("Erregistro data:");
		lblErregistroData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblErregistroData.setBounds(144, 323, 126, 26);
		contentPane.add(lblErregistroData);
		
		JLabel lblPremiumAzkenEguna = new JLabel("Premium azken eguna:");
		lblPremiumAzkenEguna.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPremiumAzkenEguna.setBounds(144, 383, 190, 26);
		contentPane.add(lblPremiumAzkenEguna);
		
		txtIzena = new JTextField();
		txtIzena.setBounds(253, 87, 231, 25);
		contentPane.add(txtIzena);
		txtIzena.setColumns(10);
		
		txtErabiltzaile = new JTextField();
		txtErabiltzaile.setColumns(10);
		txtErabiltzaile.setBounds(253, 143, 298, 25);
		contentPane.add(txtErabiltzaile);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(253, 202, 202, 25);
		contentPane.add(passwordField);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setBounds(649, 202, 202, 25);
		contentPane.add(passwordFieldConfirm);
		
		txtJaiotzeData = new JTextField();
		txtJaiotzeData.setColumns(10);
		txtJaiotzeData.setBounds(253, 264, 277, 25);
		contentPane.add(txtJaiotzeData);
		
		txtErregistroData = new JTextField();
		txtErregistroData.setColumns(10);
		txtErregistroData.setBounds(270, 323, 287, 25);
		contentPane.add(txtErregistroData);
		
		txtPremiumAzkenEguna = new JTextField();
		txtPremiumAzkenEguna.setColumns(10);
		txtPremiumAzkenEguna.setBounds(330, 383, 237, 25);
		contentPane.add(txtPremiumAzkenEguna);
		
		JLabel lblHizkuntza = new JLabel("Hizkuntza:");
		lblHizkuntza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHizkuntza.setBounds(144, 433, 91, 26);
		contentPane.add(lblHizkuntza);
		
		JComboBox comboBoxHizkuntza = new JComboBox();
		comboBoxHizkuntza.setModel(new DefaultComboBoxModel(new String[] {"Euskara", "Gaztelania"}));
		comboBoxHizkuntza.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxHizkuntza.setBounds(253, 437, 126, 22);
		contentPane.add(comboBoxHizkuntza);
		
		JLabel lblAbizena = new JLabel("Abizenak:");
		lblAbizena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAbizena.setBounds(514, 87, 80, 26);
		contentPane.add(lblAbizena);
		
		txtAbizenak = new JTextField();
		txtAbizenak.setColumns(10);
		txtAbizenak.setBounds(604, 87, 256, 25);
		contentPane.add(txtAbizenak);
		
		JButton btnEditatu = new JButton("Editatu profila");
		btnEditatu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnEditatu.setBounds(380, 485, 147, 46);
		contentPane.add(btnEditatu);
		
		JButton btnPremiumErosi = new JButton("Premium erosi");
		btnPremiumErosi.setForeground(Color.RED);
		btnPremiumErosi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPremiumErosi.setBounds(620, 485, 185, 46);
		contentPane.add(btnPremiumErosi);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAtzera.setBounds(123, 485, 147, 46);
		contentPane.add(btnAtzera);
		
		// ATZERA BOTOIA
		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		// EDITATU BOTOIA
		btnEditatu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		// PREMIUM EROSTEKO BOTOIA
		btnPremiumErosi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}
}
