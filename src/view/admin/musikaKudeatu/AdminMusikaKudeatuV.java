package view.admin.musikaKudeatu;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.metodoak.JFrameSortu;
import model.metodoak.View_metodoak;
import view.LoginV;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AdminMusikaKudeatuV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AdminMusikaKudeatuV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Musika kudeatu - ADMIN - JPAM Music");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);
		
		JLabel lblZerEginNahi = new JLabel("Zer egin nahi duzu?");
		lblZerEginNahi.setHorizontalAlignment(SwingConstants.CENTER);
		lblZerEginNahi.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblZerEginNahi.setBounds(0, 59, 890, 34);
		contentPane.add(lblZerEginNahi);
		
		JLabel lblMusikaKudeatu = new JLabel("MUSIKA KUDEATU");
		lblMusikaKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMusikaKudeatu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMusikaKudeatu.setBounds(0, 21, 890, 27);
		contentPane.add(lblMusikaKudeatu);
		
		JButton btnArtistakKudeatu = new JButton("Artista/Artistak kudeatu");
		btnArtistakKudeatu.setFont(new Font("Verdana", Font.BOLD, 28));
		btnArtistakKudeatu.setFocusPainted(false);
		btnArtistakKudeatu.setBounds(227, 125, 436, 65);
		contentPane.add(btnArtistakKudeatu);
		
		JButton btnAlbumakKudeatu = new JButton("Albumak kudeatu");
		btnAlbumakKudeatu.setFont(new Font("Verdana", Font.BOLD, 28));
		btnAlbumakKudeatu.setFocusPainted(false);
		btnAlbumakKudeatu.setBounds(227, 201, 436, 67);
		contentPane.add(btnAlbumakKudeatu);
		
		JButton btnAbestiakKudeatu = new JButton("Abestiak kudeatu");
		btnAbestiakKudeatu.setFont(new Font("Verdana", Font.BOLD, 28));
		btnAbestiakKudeatu.setFocusPainted(false);
		btnAbestiakKudeatu.setBounds(227, 279, 436, 65);
		contentPane.add(btnAbestiakKudeatu);
		
		// ATZERA BOTOIA
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.adminMenua();
			}
		});
		
		// ARTISTAK KUDEATU BOTOIA
		btnArtistakKudeatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.adminArtistakKudeatu();
			}
		});
		
		// ALBUMAK KUDEATU BOTOIA
		btnAlbumakKudeatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.adminAlbumakKudeatu();
			}
		});
		
		// ABESTIAK KUDEATU BOTOIA
		btnAbestiakKudeatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.adminAbestiakKudeatu();
			}
		});
	}
}
