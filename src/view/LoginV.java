package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

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

import model.Erabiltzailea;
import model.metodoak.JFrameSortu;
import model.metodoak.SesioAldagaiak;
import model.sql.ErregistroNireProfilaDAO;
import model.sql.Konexioa;
import model.sql.LoginDAO;
import javax.swing.ImageIcon;

public class LoginV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFErabiltzaile;
	private JPasswordField passwordField;
	private JComboBox comboBox = null;
	private JComboBox waBox;
	private Erabiltzailea BezeroOndo = null;

	/**
	 * Create the frame.
	 */
	public LoginV() {
		setFont(new Font("Dialog", Font.PLAIN, 18));
		setTitle("Login - JPAM Music");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblLogin.setBounds(0, 33, 890, 27);
		contentPane.add(lblLogin);
		
		txtFErabiltzaile = new JTextField();
		txtFErabiltzaile.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFErabiltzaile.setToolTipText("Sartu erabiltzailea...");
		txtFErabiltzaile.setBounds(357, 168, 275, 27);
		contentPane.add(txtFErabiltzaile);
		txtFErabiltzaile.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Sartu pasahitza...");
		passwordField.setBounds(357, 234, 275, 27);
		contentPane.add(passwordField);
		
		JLabel lblErabiltzaile = new JLabel("Erabiltzailea:");
		lblErabiltzaile.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblErabiltzaile.setBounds(223, 168, 142, 27);
		contentPane.add(lblErabiltzaile);
		
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblPasahitza.setBounds(223, 241, 124, 17);
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
		lblErabiltzaileMota.setBounds(223, 303, 142, 17);
		contentPane.add(lblErabiltzaileMota);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bezeroa", "Admin"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(422, 301, 132, 22);
		contentPane.add(comboBox);
		
		// LOGIN EGITEN DU, ENTER BOTOIA PULTSATZEAN
		passwordField.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            try {
						LoginEgin(comboBox);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
		    }
		});

		// LOGIN EGITEKO BOTOIA
		btnLogin.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
					LoginEgin(comboBox);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});

		// ERREGSITROA ZABALTZEKO BOTOIA
		btnErregistroa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				try {
					JFrameSortu.erregistroMenua();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Metodo honek erabiltzailea sartzen du sistema honetan.
	 * 
	 * @param comboBox Erabiltzaile mota aukeratzeko JComboBox objektua.
	 * @throws SQLException 
	 */
	private void LoginEgin(JComboBox comboBox) throws SQLException {
			
	    	// HARTU ERABILTZAILEA FORMULARIOTIK
	        String txtErabil = txtFErabiltzaile.getText();
	        // HARTU PASAHITZA FORMULARIOTIK
	        char[] charPass = passwordField.getPassword();
	        String passwdErabil = new String(charPass);
	        // KONPROBATU BEZEROA EDO ADMIN AUKERA
	        if (comboBox.getSelectedIndex() == 0) {
	            Konexioa.konexioaIreki();
	            try {
	                BezeroOndo = LoginDAO.loginKonexioa(txtErabil, passwdErabil);
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	            // BEZEROA ONDO BADAGO, OBJEKTUAN SARTU ETA LOGEATU
	            if (BezeroOndo != null) {
	                dispose();
	                SesioAldagaiak.bezero_Ondo = BezeroOndo;
	                SesioAldagaiak.logeatuta = true;
	                if (ErregistroNireProfilaDAO.konprabatuPremium()) {
	                	SesioAldagaiak.e_premium = true;
	                }
	                JFrameSortu.menuaBezeroa();
	            } else {
	                JOptionPane.showMessageDialog(null, "Erabiltzailea edo pasahitza txarto dago.", "Errorea", JOptionPane.ERROR_MESSAGE);
	                txtFErabiltzaile.setText("");
	                passwordField.setText("");
	            }
	        }
		}
}
