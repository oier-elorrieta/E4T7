package view.admin.estatistikak;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.metodoak.JFrameSortu;
import model.metodoak.View_metodoak;
import view.LoginV;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class AdminEstatistikakMenuaV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AdminEstatistikakMenuaV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Estatistikak menua - ADMIN - JPAM Music");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);
		
		JLabel lblEstatistikakMenua = new JLabel("ESTATISTIKAK MENUA");
		lblEstatistikakMenua.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstatistikakMenua.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblEstatistikakMenua.setBounds(0, 23, 890, 27);
		contentPane.add(lblEstatistikakMenua);
		
		JLabel lblHemenAplikazioarenEstatistikak = new JLabel("Hemen aplikazioaren estatistikak ikus dezakezu.");
		lblHemenAplikazioarenEstatistikak.setHorizontalAlignment(SwingConstants.CENTER);
		lblHemenAplikazioarenEstatistikak.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblHemenAplikazioarenEstatistikak.setBounds(0, 61, 890, 34);
		contentPane.add(lblHemenAplikazioarenEstatistikak);
		
		JButton btnTopGustukoAbestiak = new JButton("Top gustuko abestiak");
		btnTopGustukoAbestiak.setFont(new Font("Verdana", Font.BOLD, 28));
		btnTopGustukoAbestiak.setFocusPainted(false);
		btnTopGustukoAbestiak.setBounds(228, 126, 436, 65);
		contentPane.add(btnTopGustukoAbestiak);
		
		JButton btnTopGustukoPodcast = new JButton("Top gustuko Podcast");
		btnTopGustukoPodcast.setFont(new Font("Verdana", Font.BOLD, 28));
		btnTopGustukoPodcast.setFocusPainted(false);
		btnTopGustukoPodcast.setBounds(228, 202, 436, 67);
		contentPane.add(btnTopGustukoPodcast);
		
		JButton btnTopEntzundakoak = new JButton("Top entzundakoak");
		btnTopEntzundakoak.setFont(new Font("Verdana", Font.BOLD, 28));
		btnTopEntzundakoak.setFocusPainted(false);
		btnTopEntzundakoak.setBounds(228, 280, 436, 65);
		contentPane.add(btnTopEntzundakoak);
		
		JButton btnTopPlaylist = new JButton("Top PlayList");
		btnTopPlaylist.setFont(new Font("Verdana", Font.BOLD, 28));
		btnTopPlaylist.setFocusPainted(false);
		btnTopPlaylist.setBounds(228, 356, 436, 65);
		contentPane.add(btnTopPlaylist);
		
		// ATZERA BOTOIA
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.adminMenua();
			}
		});

		// TOP GUSTUKO ABESTIAK BOTOIA
		btnTopGustukoAbestiak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.statsTopGustukoAbestiak();
			}
		});
		
		// TOP GUSTUKO PODCAST BOTOIA
		btnTopGustukoPodcast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.statsTopGustukoPodcast();
			}
		});
		
		// TOP ENTZUNDAKOAK BOTOIA
		btnTopEntzundakoak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.statsTopEntzundakoak();
			}
		});
		
		// TOP PLAYLIST BOTOIA
		btnTopPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.statsTopPlayList();
			}
		});
	}
}
