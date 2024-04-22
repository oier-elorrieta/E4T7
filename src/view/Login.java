package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.E_Free;
import model.E_Premium;
import model.Erabiltzailea;
import model.metodoak.JFrameSortu;
import model.metodoak.SesioAldagaiak;
import model.sql.SQLKonexioa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFErabiltzaile;
	private JPasswordField passwordField;
	private String ondoLogin = "";
	private Erabiltzailea BezeroOndo = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(0, 33, 890, 27);
		contentPane.add(lblNewLabel);
		
		txtFErabiltzaile = new JTextField();
		txtFErabiltzaile.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFErabiltzaile.setToolTipText("Sartu erabiltzailea...");
		txtFErabiltzaile.setBounds(329, 162, 275, 27);
		contentPane.add(txtFErabiltzaile);
		txtFErabiltzaile.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Sartu pasahitza...");
		passwordField.setBounds(329, 228, 275, 27);
		contentPane.add(passwordField);
		
		JLabel lblErabiltzaile = new JLabel("Erabiltzailea:");
		lblErabiltzaile.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblErabiltzaile.setBounds(195, 162, 142, 27);
		contentPane.add(lblErabiltzaile);
		
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblPasahitza.setBounds(195, 235, 124, 17);
		contentPane.add(lblPasahitza);
		
		JButton btnLogin = new JButton("Login egin");
		btnLogin.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		btnLogin.setBounds(572, 471, 132, 38);
		btnLogin.setFocusPainted(false);
		contentPane.add(btnLogin);
		
		JButton btnErregistroa = new JButton("Erregistratu");
		btnErregistroa.setForeground(Color.RED);
		btnErregistroa.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 19));
		btnErregistroa.setBounds(148, 470, 132, 38);
		btnErregistroa.setFocusPainted(false);
		contentPane.add(btnErregistroa);
		
		JLabel lblErabiltzaileMota = new JLabel("Erabiltzaile mota:");
		lblErabiltzaileMota.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblErabiltzaileMota.setBounds(195, 297, 142, 17);
		contentPane.add(lblErabiltzaileMota);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bezeroa", "Admin"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(394, 295, 132, 22);
		contentPane.add(comboBox);
		
		// LOGIN EGITEKO BOTOIA
		btnLogin.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String txtErabil = txtFErabiltzaile.getText();
		        char[] charPass = passwordField.getPassword();
		        String passwdErabil = new String(charPass);
		        if (comboBox.getSelectedIndex() == 0) {
		            SQLKonexioa.konexioaIreki();
		            try {
		                BezeroOndo = SQLKonexioa.loginKonexioa(txtErabil, passwdErabil);
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }

		            if (BezeroOndo != null) {
		                dispose();
		                System.out.println(BezeroOndo.toString());
		                SesioAldagaiak.bezero_Ondo = BezeroOndo;
		                JFrameSortu.menuaBezeroa();
		            } else {
		                JOptionPane.showMessageDialog(null, "Erabiltzailea edo pasahitza txarto dago.", "Errorea", JOptionPane.ERROR_MESSAGE);
		                txtFErabiltzaile.setText("");
		                passwordField.setText("");
		            }
		        }
		    }
		});

		
		btnErregistroa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFrameSortu.erregistroMenua();
			}
		});
	}
}
