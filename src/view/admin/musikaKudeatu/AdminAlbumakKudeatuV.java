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
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;

public class AdminAlbumakKudeatuV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AdminAlbumakKudeatuV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Albumak kudeatu - ADMIN - JPAM Music");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);
		contentPane.setLayout(null);
		
		JLabel lblAlbumakKudeatu = new JLabel("ALBUMAK KUDEATU");
		lblAlbumakKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbumakKudeatu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblAlbumakKudeatu.setBounds(0, 17, 890, 27);
		contentPane.add(lblAlbumakKudeatu);
		
		JLabel lblHemenAlbumakKudeatu = new JLabel("Hemen albumak kudeatu dezakezu.");
		lblHemenAlbumakKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblHemenAlbumakKudeatu.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblHemenAlbumakKudeatu.setBounds(0, 44, 890, 34);
		contentPane.add(lblHemenAlbumakKudeatu);
		
		JList ArtistaList = new JList();
		ArtistaList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ArtistaList.setFont(new Font("Verdana", Font.BOLD, 16));
		ArtistaList.setBorder(new LineBorder(new Color(0, 0, 0)));
		ArtistaList.setBounds(56, 95, 444, 404);
		contentPane.add(ArtistaList);
		
		JButton btnBerriaSartu = new JButton("Berria sartu");
		btnBerriaSartu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnBerriaSartu.setFocusPainted(false);
		btnBerriaSartu.setBounds(619, 197, 164, 51);
		contentPane.add(btnBerriaSartu);
		
		JLabel lblAukerak = new JLabel("Aukerak");
		lblAukerak.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukerak.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 21));
		lblAukerak.setBounds(619, 143, 164, 23);
		contentPane.add(lblAukerak);
		
		JButton btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnEzabatu.setFocusPainted(false);
		btnEzabatu.setBounds(619, 272, 164, 51);
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
				JFrameSortu.adminMusikaKudeatu();
			}
		});
			
		// BERRIA SARTZEKO BOTOIA
		btnBerriaSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		// EZABATZEKO BOTOIA
		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		// EDITATZEKO BOTOIA
		btnEditatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	}

}
