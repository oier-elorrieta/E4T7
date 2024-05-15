package view.admin.musikaKudeatu;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Abestia;
import model.Album;
import model.interfazeak.IadminBotoiak;
import model.metodoak.JFrameSortu;
import model.metodoak.View_metodoak;
import model.sql.admin.AbestiCRUD;
import view.LoginV;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class AdminAbestiakKudeatuV extends JFrame implements IadminBotoiak {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JList AbestiList;
	private ArrayList<Abestia> AbestiJList;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AdminAbestiakKudeatuV() throws SQLException {
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 99, 444, 404);
		contentPane.add(scrollPane);
		
		AbestiList = new JList();
		AbestiList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		AbestiList.setFont(new Font("Verdana", Font.BOLD, 16));
		AbestiList.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		AbestiJList = AbestiCRUD.abestiIzenakKargatu();
		DefaultListModel<String> modelAlbum = new DefaultListModel<String>();
		
		for (int i = 0; i < AbestiJList.size(); i++) {
			modelAlbum.addElement(AbestiJList.get(i).getTitulua());
		}
		
		AbestiList.setModel(modelAlbum);
		AbestiList.setBounds(56, 99, 444, 404);
		scrollPane.setViewportView(AbestiList);
		
		JLabel lblArtistakKudeatu = new JLabel("ABESTIAK KUDEATU");
		lblArtistakKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtistakKudeatu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblArtistakKudeatu.setBounds(0, 21, 890, 27);
		contentPane.add(lblArtistakKudeatu);
		
		JLabel lblHemenArtistakKudeatu = new JLabel("Hemen abestiak kudeatu dezakezu.");
		lblHemenArtistakKudeatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblHemenArtistakKudeatu.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblHemenArtistakKudeatu.setBounds(0, 48, 890, 34);
		contentPane.add(lblHemenArtistakKudeatu);
		
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
		
		JLabel lblAukerak = new JLabel("Aukerak");
		lblAukerak.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukerak.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 21));
		lblAukerak.setBounds(619, 147, 164, 23);
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
				
			}
		});
		
		// EDITATZEKO BOTOIA
		btnEditatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
	}

	@Override
	public void btnInsert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void btnDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void btnUpdate() {
		// TODO Auto-generated method stub
		
	}
}
