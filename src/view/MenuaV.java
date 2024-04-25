package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.metodoak.*;
import model.*;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class MenuaV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MenuaV() {
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
		
		JButton btnNireProfila = View_metodoak.btn_NireProfila();
		contentPane.add(btnNireProfila);
		
		JLabel lblKaixoMezua = new JLabel("Kaixo, entzule! Zer egin nahi duzu?");
		lblKaixoMezua.setHorizontalAlignment(SwingConstants.CENTER);
		lblKaixoMezua.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblKaixoMezua.setBounds(0, 71, 890, 34);
		contentPane.add(lblKaixoMezua);
		
		JButton btnMusikaDeskubritu = new JButton("Musika deskubritu");
		btnMusikaDeskubritu.setFont(new Font("Verdana", Font.BOLD, 28));
		btnMusikaDeskubritu.setBounds(226, 138, 436, 65);
		btnMusikaDeskubritu.setFocusPainted(false);
		contentPane.add(btnMusikaDeskubritu);
	
		JButton btnPodcastakDeskubritu = new JButton("Podcast-ak deskubritu");
		btnPodcastakDeskubritu.setFont(new Font("Verdana", Font.BOLD, 28));
		btnPodcastakDeskubritu.setBounds(226, 214, 436, 67);
		btnPodcastakDeskubritu.setFocusPainted(false);
		contentPane.add(btnPodcastakDeskubritu);
		
		JButton btnNirePlaylistak = new JButton("Nire PlayList-ak");
		btnNirePlaylistak.setFont(new Font("Verdana", Font.BOLD, 28));
		btnNirePlaylistak.setBounds(226, 292, 436, 65);
		btnNirePlaylistak.setFocusPainted(false);
		contentPane.add(btnNirePlaylistak);
		
		JLabel lblUserizena = new JLabel("");
		lblUserizena.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserizena.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblUserizena.setBounds(693, 11, 187, 34);
		// ATERA ERABILTZAILEAREN IZENA
		lblUserizena.setText("Kaixo, " + SesioAldagaiak.bezero_Ondo.getIzena() + "!");
		contentPane.add(lblUserizena);
		
		// MUSIKA DESKUBRITU BOTOIA
		btnMusikaDeskubritu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFrameSortu.musikaDeskubrituBezeroa();
			}
		});
		// POSCASTAK DESKUBRITU BOTOIA
		btnPodcastakDeskubritu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		// NIRE PLAYLISTAK BOTOIA
		btnNirePlaylistak.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		// NIRE PROFILA BOTOIA
		btnNireProfila.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					JFrameSortu.erregistroMenua();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}