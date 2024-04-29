package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.metodoak.JFrameSortu;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAukeraErreprodukzioV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MenuAukeraErreprodukzioV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 650, 288, 189);
		setTitle("Erreprodukzio menua");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPlaylistSartu = new JButton("PlayListean sartu");
		btnPlaylistSartu.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnPlaylistSartu.setBounds(64, 46, 146, 31);
		contentPane.add(btnPlaylistSartu);
		
		JButton btnKonpartitu = new JButton("Konpartitu");
		btnKonpartitu.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnKonpartitu.setBounds(80, 94, 114, 31);
		contentPane.add(btnKonpartitu);
		
		JLabel lblNewLabel = new JLabel("MENUA");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 272, 24);
		contentPane.add(lblNewLabel);
		
		// PLAYLIST SARTU BOTOIA
		btnPlaylistSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.PlaylisteanSartuBezeroa();
			}
		});
	}

}
