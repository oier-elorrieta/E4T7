package view.admin.podcastKudeatu;

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
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AdminPodcastKudeatuV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AdminPodcastKudeatuV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Podcastak kudeatu - ADMIN - JPAM Music");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);
		
		JList PodcastList = new JList();
		PodcastList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		PodcastList.setFont(new Font("Verdana", Font.BOLD, 16));
		PodcastList.setBorder(new LineBorder(new Color(0, 0, 0)));
		PodcastList.setBounds(56, 99, 444, 404);
		contentPane.add(PodcastList);
		
		JLabel lblHemenPodcastakKudeatu = new JLabel("Hemen Podcastak kudeatu dezakezu.");
		lblHemenPodcastakKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblHemenPodcastakKudeatu.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblHemenPodcastakKudeatu.setBounds(0, 48, 890, 34);
		contentPane.add(lblHemenPodcastakKudeatu);
		
		JLabel lblPodcastakKudeatu = new JLabel("PODCASTAK KUDEATU");
		lblPodcastakKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblPodcastakKudeatu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPodcastakKudeatu.setBounds(0, 21, 890, 27);
		contentPane.add(lblPodcastakKudeatu);
		
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
