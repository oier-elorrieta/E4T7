package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.Album;
import model.Artista;
import model.metodoak.JFrameSortu;
import model.metodoak.SesioAldagaiak;
import model.metodoak.View_metodoak;
import model.sql.ArtistaDiskaDAO;
import model.sql.ArtistaListDAO;
import model.sql.Konexioa;

public class ArtistaV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ArtistaV(Artista artista) throws SQLException {
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
		
		JLabel lblArtista = new JLabel("ARTISTA");
		lblArtista.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtista.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblArtista.setBounds(-1, 25, 890, 27);
		contentPane.add(lblArtista);
		
		JLabel lblUserizena = new JLabel("");
		lblUserizena.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserizena.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblUserizena.setBounds(693, 11, 187, 34);
		lblUserizena.setText("Kaixo, " + SesioAldagaiak.bezero_Ondo.getIzena() + "!");
		contentPane.add(lblUserizena);
		
		JLabel lblAukeratuAlbumBat = new JLabel("Aukeratu album bat:");
		lblAukeratuAlbumBat.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblAukeratuAlbumBat.setBounds(115, 67, 187, 23);
		contentPane.add(lblAukeratuAlbumBat);
		
		JList<Album> AlbumList = new JList();
		
		AlbumList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		AlbumList.setFont(new Font("Verdana", Font.BOLD, 16));
		AlbumList.setBorder(new LineBorder(new Color(0, 0, 0)));
		AlbumList.setBounds(18, 101, 405, 416);
		
		Konexioa.konexioaIreki();
		ArrayList<Album> AlbumakJList = ArtistaDiskaDAO.artistakKargatu(artista);
		
		DefaultListModel<Album> modelAlbum = new DefaultListModel<Album>();
		
		for (int i = 0; i < AlbumakJList.size(); i++) {
			modelAlbum.addElement(AlbumakJList.get(i));
		}
		AlbumList.setModel(modelAlbum);
		contentPane.add(AlbumList);
		
		JLabel lblArtistarenInformazioa = new JLabel("Artistaren informazioa:");
		lblArtistarenInformazioa.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblArtistarenInformazioa.setBounds(488, 67, 208, 23);
		contentPane.add(lblArtistarenInformazioa);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textPane.setBounds(472, 302, 386, 215);
		contentPane.add(textPane);
		
		JLabel lblArgazkia = new JLabel("ARGAZKIA");
		lblArgazkia.setHorizontalAlignment(SwingConstants.CENTER);
		lblArgazkia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblArgazkia.setBounds(554, 101, 229, 188);
		contentPane.add(lblArgazkia);
	
	// ATZERA BOTOIA
	btnAtzera.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
			try {
				JFrameSortu.musikaDeskubrituBezeroa();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	});
	
	// NIRE PROFILA BOTOIA
	btnNireProfila.addActionListener(new ActionListener() {
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
