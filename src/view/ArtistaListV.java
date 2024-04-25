package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.border.EtchedBorder;

import model.metodoak.JFrameSortu;
import model.metodoak.SesioAldagaiak;
import model.metodoak.View_metodoak;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class ArtistaListV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ArtistaListV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
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
		lblUserizena.setText("Kaixo, " + SesioAldagaiak.bezero_Ondo.getIzena() + "!");
		contentPane.add(lblUserizena);
		
		JLabel lblAukeratu = new JLabel("Aukeratu artista bat:");
		lblAukeratu.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblAukeratu.setBounds(244, 69, 187, 23);
		contentPane.add(lblAukeratu);
		
		JList ArtistaList = new JList();
		ArtistaList.setBorder(new LineBorder(new Color(0, 0, 0)));
		ArtistaList.setFont(new Font("Verdana", Font.BOLD, 16));
		ArtistaList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Hola", "Beunas", "Tardes", "que tal", "a tdos"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		ArtistaList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ArtistaList.setBounds(244, 103, 430, 357);
		contentPane.add(ArtistaList);
	
		JLabel lblMusikaDeskubritu = new JLabel("MUSIKA DESKUBRITU");
		lblMusikaDeskubritu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMusikaDeskubritu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMusikaDeskubritu.setBounds(0, 23, 890, 27);
		contentPane.add(lblMusikaDeskubritu);
		
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