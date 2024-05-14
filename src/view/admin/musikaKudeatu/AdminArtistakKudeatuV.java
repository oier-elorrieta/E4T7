package view.admin.musikaKudeatu;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import model.Artista;
import model.Musikaria;
import model.metodoak.JFrameSortu;
import model.metodoak.View_metodoak;
import model.sql.ArtistaListDAO;
import model.sql.Konexioa;
import model.sql.admin.ArtistaCRUD;
import view.LoginV;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class AdminArtistakKudeatuV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AdminArtistakKudeatuV() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Artistak kudeatu - ADMIN - JPAM Music");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);
		
		JList ArtistaList = new JList();
		ArtistaList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ArtistaList.setFont(new Font("Verdana", Font.BOLD, 16));
		ArtistaList.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		ArrayList<Artista> ArtistakJList = ArtistaCRUD.artistaIzenakKargatu();
		DefaultListModel<String> modelMusikari = new DefaultListModel<String>();
		
		for (int i = 0; i < ArtistakJList.size(); i++) {
			modelMusikari.addElement(ArtistakJList.get(i).getIzena());
		}
		
		ArtistaList.setModel(modelMusikari);
		ArtistaList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ArtistaList.setBounds(56, 96, 444, 404);
		contentPane.add(ArtistaList);
	
		
		JLabel lblArtistakKudeatu = new JLabel("ARTISTAK KUDEATU");
		lblArtistakKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtistakKudeatu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblArtistakKudeatu.setBounds(0, 21, 890, 27);
		contentPane.add(lblArtistakKudeatu);
		
		JLabel lblHemenArtistakKudeatu = new JLabel("Hemen artistak kudeatu dezakezu.");
		lblHemenArtistakKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblHemenArtistakKudeatu.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblHemenArtistakKudeatu.setBounds(0, 48, 890, 34);
		contentPane.add(lblHemenArtistakKudeatu);
		
		JButton btnBerriaSartu = new JButton("Berria sartu");
		btnBerriaSartu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnBerriaSartu.setFocusPainted(false);
		btnBerriaSartu.setBounds(619, 207, 164, 51);
		contentPane.add(btnBerriaSartu);
		
		JButton btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnEzabatu.setFocusPainted(false);
		btnEzabatu.setBounds(619, 282, 164, 51);
		contentPane.add(btnEzabatu);
		
		JLabel lblAukerak = new JLabel("Aukerak");
		lblAukerak.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukerak.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 21));
		lblAukerak.setBounds(619, 153, 164, 23);
		contentPane.add(lblAukerak);
		
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
				Artista artistaSelected = (Artista) ArtistaList.getSelectedValue();
				
				if (artistaSelected == null) {
					JOptionPane.showMessageDialog(null, "Ez duzu artistarik aukeratu!", "Errorea", JOptionPane.ERROR_MESSAGE);
				} else {
					
				}
			}
		});
		
		// EDITATZEKO BOTOIA
		btnEditatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				if (ArtistaList.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(null, "Ez duzu artistarik aukeratu!", "Errorea", JOptionPane.ERROR_MESSAGE);
				} else {
//					String artistaSelected = ArtistaList.getSelectedValue().toString();
//					String artistaIzenaBerria = JOptionPane.showInputDialog("Sartu izen berria");
//					try {
//						ArtistaCRUD.artistaUpdate(artistaSelected, artistaIzenaBerria);
//					} catch (SQLException e1) {
//						e1.printStackTrace();
//					}
					
					
					
					
					
					
				}
			}
		});
		
	}
}
