package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Abestia;
import model.Album;
import model.Artista;
import model.metodoak.SesioAldagaiak;
import model.metodoak.View_metodoak;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ErreprodukzioaV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ErreprodukzioaV(Album album, Artista artista, Abestia abesti) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);
		
		JButton btnNireProfila = View_metodoak.btn_NireProfila();
		contentPane.add(btnNireProfila);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKaixo = new JLabel("");
		lblKaixo.setHorizontalAlignment(SwingConstants.CENTER);
		lblKaixo.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblKaixo.setBounds(693, 11, 187, 34);
		lblKaixo.setText("Kaixo, " + SesioAldagaiak.bezero_Ondo.getIzena() + "!");
		contentPane.add(lblKaixo);
		
		JLabel lblErreproduzitzen = new JLabel("ERREPRODUZITZEN ORAIN...");
		lblErreproduzitzen.setHorizontalAlignment(SwingConstants.CENTER);
		lblErreproduzitzen.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblErreproduzitzen.setBounds(0, 23, 890, 27);
		contentPane.add(lblErreproduzitzen);
		
		JLabel lblArgazkiaAlbum = new JLabel("");
		lblArgazkiaAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		lblArgazkiaAlbum.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblArgazkiaAlbum.setBounds(272, 81, 354, 270);
		contentPane.add(lblArgazkiaAlbum);
		
		JLabel lblAbestiIzena = new JLabel("");
		lblAbestiIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbestiIzena.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		lblAbestiIzena.setBounds(0, 362, 890, 23);
		lblAbestiIzena.setText(abesti.getTitulua());
		contentPane.add(lblAbestiIzena);
		
		JLabel lblArtistaIzena = new JLabel("Artista");
		lblArtistaIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtistaIzena.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		lblArtistaIzena.setBounds(0, 386, 890, 23);
		contentPane.add(lblArtistaIzena);
		
		JLabel lblAlbumIzena = new JLabel("Albuma");
		lblAlbumIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbumIzena.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblAlbumIzena.setBounds(0, 47, 890, 23);
		contentPane.add(lblAlbumIzena);
		
		JLabel lblIraupena = new JLabel("Iraupena");
		lblIraupena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIraupena.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblIraupena.setBounds(0, 410, 890, 23);
		contentPane.add(lblIraupena);
		
		JButton btnPlayPause = new JButton("Play");
		btnPlayPause.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		btnPlayPause.setBounds(401, 458, 89, 34);
		contentPane.add(btnPlayPause);
		
		JButton btnAurrekoa = new JButton("<--");
		btnAurrekoa.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btnAurrekoa.setBounds(291, 458, 89, 34);
		contentPane.add(btnAurrekoa);
		
		JButton btnHurrengoa = new JButton("-->");
		btnHurrengoa.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btnHurrengoa.setBounds(509, 458, 89, 34);
		contentPane.add(btnHurrengoa);
		
		JButton btnGustukoa = new JButton("Gustukoa");
		btnGustukoa.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnGustukoa.setBounds(620, 458, 121, 34);
		contentPane.add(btnGustukoa);
		
		JButton btnMenua = new JButton("Menua");
		btnMenua.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnMenua.setBounds(144, 458, 121, 34);
		contentPane.add(btnMenua);
		
		// PLAY-PAUSE BOTOIA
		btnPlayPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		// AURREKO ABESTIRA JOATEKO BOTOIA
		btnAurrekoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		// HURRENGO ABESTIRA JOATEKO BOTOIA
		btnHurrengoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		// MENURA JOATEKO BOTOIA
		btnMenua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		// GUSTUKORA GEHITZEKO BOTOIA
		btnGustukoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}
}
