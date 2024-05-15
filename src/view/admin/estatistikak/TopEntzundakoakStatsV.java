package view.admin.estatistikak;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Abestia;
import model.metodoak.JFrameSortu;
import model.metodoak.View_metodoak;
import model.sql.admin.EstatistikakDAO;
import view.LoginV;

public class TopEntzundakoakStatsV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
    private DefaultTableModel model;
    
	/**
	 * Create the frame.
	 */
	public TopEntzundakoakStatsV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Top entzunaldiak - ADMIN Estatistikak - JPAM Music");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 75, 787, 443);
		contentPane.add(scrollPane);
		
		JLabel lblTopGustukoAbestiak = new JLabel("TOP GUSTUKO PODCAST");
		lblTopGustukoAbestiak.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopGustukoAbestiak.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTopGustukoAbestiak.setBounds(0, 21, 890, 27);
		contentPane.add(lblTopGustukoAbestiak);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		model = new DefaultTableModel();
        model.addColumn("IdAudio");
        model.addColumn("Abesti/Podcast izena");
        model.addColumn("Iraupena");
        model.addColumn("Entzunaldi totalak");
        
        table = new JTable(model);

        try {
            ArrayList<Abestia> abestiak = EstatistikakDAO.getTotalaTopEntzunaldiakStats();
            for (Abestia abesti : abestiak) {
                model.addRow(new Object[]{abesti.getIdAudio(), abesti.getTitulua(), abesti.getIraupena(), abesti.getErreprodukzioak()});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Datu basearekin arazoak daude.");
        }

        
		scrollPane.setViewportView(table);
		
		
		// ATZERA BOTOIA
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.adminEstatistikakMenua();
			}
		});
	}

}
