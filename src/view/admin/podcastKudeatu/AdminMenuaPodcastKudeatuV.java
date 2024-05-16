package view.admin.podcastKudeatu;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.metodoak.JFrameSortu;
import model.metodoak.View_metodoak;
import view.LoginV;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

public class AdminMenuaPodcastKudeatuV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AdminMenuaPodcastKudeatuV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Podcast kudeatu - ADMIN - JPAM Music");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPodcastakKudeatu = new JLabel("PODCASTAK KUDEATU");
		lblPodcastakKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblPodcastakKudeatu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPodcastakKudeatu.setBounds(0, 30, 890, 27);
		contentPane.add(lblPodcastakKudeatu);
		
		JLabel lblZerEginNahi = new JLabel("Zer egin nahi duzu?");
		lblZerEginNahi.setHorizontalAlignment(SwingConstants.CENTER);
		lblZerEginNahi.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblZerEginNahi.setBounds(0, 68, 890, 34);
		contentPane.add(lblZerEginNahi);
		
		JButton btnPodcasterakKudeatu = new JButton("Podcasterak kudeatu");
		btnPodcasterakKudeatu.setFont(new Font("Verdana", Font.BOLD, 28));
		btnPodcasterakKudeatu.setFocusPainted(false);
		btnPodcasterakKudeatu.setBounds(228, 154, 436, 65);
		contentPane.add(btnPodcasterakKudeatu);
		
		JButton btnPodcastakKudeatu = new JButton("Podcastak kudeatu");
		btnPodcastakKudeatu.setFont(new Font("Verdana", Font.BOLD, 28));
		btnPodcastakKudeatu.setFocusPainted(false);
		btnPodcastakKudeatu.setBounds(228, 241, 436, 67);
		contentPane.add(btnPodcastakKudeatu);
		
		// ATZERA BOTOIA
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.adminMenua();
			}
		});
		
		// PODCASTERAK KUDEATU BOTOIA
		btnPodcasterakKudeatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					JFrameSortu.adminPodcasterKudeatu();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Errore bat gertatu da Podcasterak kargatzean.", "Errorea",
                            JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// PODCASTAK KUDEATU BOTOIA
		btnPodcastakKudeatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 	dispose();
			    try {
					JFrameSortu.adminPodcastKudeatu();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
