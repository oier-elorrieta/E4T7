package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.metodoak.JFrameSortu;
import model.metodoak.SesioAldagaiak;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMenuaV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AdminMenuaV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Admin menua - JPAM Music");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminMenua = new JLabel("ADMIN MENUA");
		lblAdminMenua.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminMenua.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblAdminMenua.setBounds(0, 21, 890, 27);
		contentPane.add(lblAdminMenua);
		
		JLabel lblHauAdministrazioarakoAtala = new JLabel("Hau aplikazioaren administrazioarako atala da.");
		lblHauAdministrazioarakoAtala.setHorizontalAlignment(SwingConstants.CENTER);
		lblHauAdministrazioarakoAtala.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblHauAdministrazioarakoAtala.setBounds(0, 59, 890, 34);
		contentPane.add(lblHauAdministrazioarakoAtala);
		
		JButton btnMusikaKudeatu = new JButton("Musika kudeatu");
		btnMusikaKudeatu.setFont(new Font("Verdana", Font.BOLD, 28));
		btnMusikaKudeatu.setFocusPainted(false);
		btnMusikaKudeatu.setBounds(227, 131, 436, 65);
		contentPane.add(btnMusikaKudeatu);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		btnLogout.setForeground(Color.RED);
		btnLogout.setFocusPainted(false);
		btnLogout.setBounds(732, 14, 133, 43);
		contentPane.add(btnLogout);
		
		JButton btnPodcastakKudeatu = new JButton("Podcast-ak kudeatu");
		btnPodcastakKudeatu.setFont(new Font("Verdana", Font.BOLD, 28));
		btnPodcastakKudeatu.setFocusPainted(false);
		btnPodcastakKudeatu.setBounds(227, 207, 436, 67);
		contentPane.add(btnPodcastakKudeatu);
		
		JButton btnEstatistikak = new JButton("Estatistikak");
		btnEstatistikak.setFont(new Font("Verdana", Font.BOLD, 28));
		btnEstatistikak.setFocusPainted(false);
		btnEstatistikak.setBounds(227, 285, 436, 65);
		contentPane.add(btnEstatistikak);
		
		// LOGOUT BOTOIA
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.loginMenua();
			}
		});
		
		// MUSIKA KUDEATU BOTOIA
		btnMusikaKudeatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		// PODCASTAK KUDEATU BOTOIA
		btnPodcastakKudeatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		// ESTATISTIKAK BOTOIA
		btnEstatistikak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.estatistikakAdminMenua();
			}
		});
	}
}
