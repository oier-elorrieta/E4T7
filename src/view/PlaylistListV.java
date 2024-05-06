package view;

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
import model.metodoak.SesioAldagaiak;
import model.metodoak.View_metodoak;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;

public class PlaylistListV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PlaylistListV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setResizable(false);
		setTitle("Nire PlayList-ak - JPAM Music");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);
		
		JButton btnNireProfila = View_metodoak.btn_NireProfila();
		contentPane.add(btnNireProfila);
		
		JLabel lblPlaylistakDeskubritu = new JLabel("NIRE PLAYLIST-AK");
		lblPlaylistakDeskubritu.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaylistakDeskubritu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPlaylistakDeskubritu.setBounds(0, 24, 890, 27);
		contentPane.add(lblPlaylistakDeskubritu);
		
		JLabel lblHemenZurePlaylistak = new JLabel("Hemen zure PlayList-ak kudeatu dezakezu!");
		lblHemenZurePlaylistak.setHorizontalAlignment(SwingConstants.CENTER);
		lblHemenZurePlaylistak.setFont(new Font("Segoe UI Semilight", Font.ITALIC, 16));
		lblHemenZurePlaylistak.setBounds(0, 54, 890, 23);
		contentPane.add(lblHemenZurePlaylistak);
		
		JList PlaylistList = new JList();
		PlaylistList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		PlaylistList.setFont(new Font("Verdana", Font.BOLD, 16));
		PlaylistList.setBorder(new LineBorder(new Color(0, 0, 0)));
		PlaylistList.setBounds(35, 109, 458, 390);
		contentPane.add(PlaylistList);
		
		JButton btnBerriaSortu = new JButton("Berria sortu");
		btnBerriaSortu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnBerriaSortu.setBounds(620, 163, 164, 51);
		contentPane.add(btnBerriaSortu);
		
		JButton btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnEzabatu.setBounds(620, 237, 164, 51);
		contentPane.add(btnEzabatu);
		
		JButton btnInportatu = new JButton("Inportatu");
		btnInportatu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnInportatu.setBounds(620, 308, 164, 51);
		contentPane.add(btnInportatu);
		
		JButton btnExportatu = new JButton("Exportatu");
		btnExportatu.setFont(new Font("Segoe UI Historic", Font.BOLD, 19));
		btnExportatu.setBounds(620, 384, 164, 51);
		contentPane.add(btnExportatu);
		
		JLabel lblHemenZurePlaylistak_1 = new JLabel("Aukerak");
		lblHemenZurePlaylistak_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHemenZurePlaylistak_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 21));
		lblHemenZurePlaylistak_1.setBounds(602, 115, 200, 23);
		contentPane.add(lblHemenZurePlaylistak_1);
		
		JLabel lblPlaylistzerrenda = new JLabel("PlayList-en zerrenda");
		lblPlaylistzerrenda.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlaylistzerrenda.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 19));
		lblPlaylistzerrenda.setBounds(35, 75, 200, 23);
		contentPane.add(lblPlaylistzerrenda);
		
		JLabel lblUserizena = new JLabel("");
		lblUserizena.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserizena.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblUserizena.setText("Kaixo, " + SesioAldagaiak.bezero_Ondo.getIzena() + "!");
		lblUserizena.setBounds(687, 11, 193, 34);
		contentPane.add(lblUserizena);
		
		
		// ATZERA BOTOIA
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.menuaBezeroa();
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
