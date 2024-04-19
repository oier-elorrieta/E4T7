package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.sql.SQLKonexioa;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menua extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menua frame = new Menua();
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
	public Menua() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenua = new JLabel("MENUA");
		lblMenua.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenua.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMenua.setBounds(0, 33, 890, 27);
		contentPane.add(lblMenua);
		
		JButton btnMusikaDeskubritu = new JButton("Musika deskubritu");
		btnMusikaDeskubritu.setFont(new Font("Verdana", Font.BOLD, 24));
		btnMusikaDeskubritu.setBounds(237, 138, 418, 50);
		contentPane.add(btnMusikaDeskubritu);
		
		JLabel lblKaixoMezua = new JLabel("Kaixo, entzule! Zer egin nahi duzu?");
		lblKaixoMezua.setHorizontalAlignment(SwingConstants.CENTER);
		lblKaixoMezua.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblKaixoMezua.setBounds(0, 71, 890, 34);
		contentPane.add(lblKaixoMezua);
		
		JButton btnPodcastakDeskubritu = new JButton("Podcast-ak deskubritu");
		btnPodcastakDeskubritu.setFont(new Font("Verdana", Font.BOLD, 24));
		btnPodcastakDeskubritu.setBounds(237, 214, 418, 50);
		contentPane.add(btnPodcastakDeskubritu);
		
		JButton btnNirePlaylistak = new JButton("Nire PlayList-ak");
		btnNirePlaylistak.setFont(new Font("Verdana", Font.BOLD, 24));
		btnNirePlaylistak.setBounds(237, 292, 418, 50);
		contentPane.add(btnNirePlaylistak);
		
		JLabel lblUserizena = new JLabel("");
		lblUserizena.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserizena.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblUserizena.setBounds(693, 11, 187, 34);
		
		if (SQLKonexioa.erabiltzaile_erregistro_free.getIzena().isEmpty()) {
			lblUserizena.setText("Kaixo, " + SQLKonexioa.erabiltzaile_erregistro_premium.getIzena() + "!");
		}
		lblUserizena.setText("Kaixo, " + SQLKonexioa.erabiltzaile_erregistro_free.getIzena() + "!");
		
		contentPane.add(lblUserizena);
		
		btnMusikaDeskubritu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		btnPodcastakDeskubritu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		btnNirePlaylistak.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}
}
