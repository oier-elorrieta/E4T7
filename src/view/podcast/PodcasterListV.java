package view.podcast;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.border.EtchedBorder;

import model.Artista;
import model.Musikaria;
import model.Podcaster;
import model.metodoak.JFrameSortu;
import model.metodoak.SesioAldagaiak;
import model.metodoak.View_metodoak;
import model.sql.ArtistaListDAO;
import model.sql.Konexioa;
import model.sql.PodcasterListDAO;
import view.LoginV;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PodcasterListV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public PodcasterListV() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setResizable(false);
		if (SesioAldagaiak.e_premium) {
			setTitle("Podcastak deskubritu - JPAM Music PREMIUM");
		} else {
			setTitle("Podcastak deskubritu - JPAM Music FREE");
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);
		
		JButton btnNireProfila = View_metodoak.btn_NireProfila();
		contentPane.add(btnNireProfila);
		
		JLabel lblUserizena = new JLabel("");
		lblUserizena.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserizena.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblUserizena.setBounds(687, 11, 193, 34);
		lblUserizena.setText("Kaixo, " + SesioAldagaiak.bezeroa_logeatuta.getIzena() + "!");
		contentPane.add(lblUserizena);
		
		JLabel lblAukeratu = new JLabel("Aukeratu artista bat:");
		lblAukeratu.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblAukeratu.setBounds(244, 69, 187, 23);
		contentPane.add(lblAukeratu);
		
		JList<Artista> ArtistaList = new JList();
		ArtistaList.setBorder(new LineBorder(new Color(0, 0, 0)));
		ArtistaList.setFont(new Font("Verdana", Font.BOLD, 16));
		
		Konexioa.konexioaIreki();
		ArrayList<Artista> ArtistakJList = PodcasterListDAO.podcasterKargatu();
		
		DefaultListModel<Artista> modelPodkaster = new DefaultListModel<Artista>();
		
		for (int i = 0; i < ArtistakJList.size(); i++) {
			modelPodkaster.addElement(ArtistakJList.get(i));
		}
		
		Konexioa.konexioaItxi();
		ArtistaList.setModel(modelPodkaster);
		ArtistaList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ArtistaList.setBounds(244, 103, 430, 357);
		contentPane.add(ArtistaList);
	
		JLabel lblMusikaDeskubritu = new JLabel("PODCASTAK DESKUBRITU");
		lblMusikaDeskubritu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMusikaDeskubritu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMusikaDeskubritu.setBounds(0, 23, 890, 27);
		contentPane.add(lblMusikaDeskubritu);
		
		JButton btnJarraitu = new JButton("Jarraitu");
		btnJarraitu.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
		btnJarraitu.setFocusPainted(false);
		btnJarraitu.setBounds(685, 491, 143, 40);
		contentPane.add(btnJarraitu);
		
		// ATZERA BOTOIA
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.menuaBezeroa(PodcasterListV.this);
			}
		});

		// JARRAITU BOTOIA
		btnJarraitu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Artista artistaSelected = ArtistaList.getSelectedValue();
				
				if (artistaSelected == null) {
					JOptionPane.showMessageDialog(null, "Ez duzu podcaster bat aukeratu!", "Errorea", JOptionPane.ERROR_MESSAGE);
				} else {
					Artista podcasterAuxSelected = new Podcaster(artistaSelected.getIzena(), artistaSelected.getErreprodukzioak());
					dispose();
					try {
						JFrameSortu.podcastPodcasterBezeroa(podcasterAuxSelected);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		// NIRE PROFILA BOTOIA
		btnNireProfila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					setVisible(false);
					JFrameSortu.erregistroMenua(PodcasterListV.this);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
