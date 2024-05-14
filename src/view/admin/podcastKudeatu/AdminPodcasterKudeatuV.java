package view.admin.podcastKudeatu;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.metodoak.View_metodoak;
import view.LoginV;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AdminPodcasterKudeatuV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AdminPodcasterKudeatuV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Podcasterak kudeatu - ADMIN - JPAM Music");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);
		contentPane.setLayout(null);
		
		JList PodcasterList = new JList();
		PodcasterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		PodcasterList.setFont(new Font("Verdana", Font.BOLD, 16));
		PodcasterList.setBorder(new LineBorder(new Color(0, 0, 0)));
		PodcasterList.setBounds(56, 99, 444, 404);
		contentPane.add(PodcasterList);
		
		JLabel lblHemenPodcasterakKudeatu = new JLabel("Hemen Podcasterak kudeatu dezakezu.");
		lblHemenPodcasterakKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblHemenPodcasterakKudeatu.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblHemenPodcasterakKudeatu.setBounds(0, 48, 890, 34);
		contentPane.add(lblHemenPodcasterakKudeatu);
		
		JLabel lblPodcasterakKudeatu = new JLabel("PODCASTERAK KUDEATU");
		lblPodcasterakKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblPodcasterakKudeatu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPodcasterakKudeatu.setBounds(0, 21, 890, 27);
		contentPane.add(lblPodcasterakKudeatu);
		
		JLabel lblAukerak = new JLabel("Aukerak");
		lblAukerak.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukerak.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 21));
		lblAukerak.setBounds(619, 147, 164, 23);
		contentPane.add(lblAukerak);
		
		JButton btnBerriaSartu = new JButton("Berria sartu");
		btnBerriaSartu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnBerriaSartu.setFocusPainted(false);
		btnBerriaSartu.setBounds(619, 201, 164, 51);
		contentPane.add(btnBerriaSartu);
		
		JButton btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnEzabatu.setFocusPainted(false);
		btnEzabatu.setBounds(619, 276, 164, 51);
		contentPane.add(btnEzabatu);
		
		JButton btnEditatu = new JButton("Editatu");
		btnEditatu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnEditatu.setFocusPainted(false);
		btnEditatu.setBounds(619, 355, 164, 51);
		contentPane.add(btnEditatu);
		
		// ATZERA BOTOIA
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
