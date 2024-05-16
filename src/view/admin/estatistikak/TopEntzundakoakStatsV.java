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
		
		JLabel lblTopGustukoAbestiak = new JLabel("TOP ENTZUNDAKOAK");
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
            ArrayList<Abestia> abestiak = EstatistikakDAO.getTopEntzunaldiakStats("Totalak");
            for (Abestia abesti : abestiak) {
                model.addRow(new Object[]{abesti.getIdAudio(), abesti.getTitulua(), abesti.getIraupena(), abesti.getErreprodukzioak()});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Datu basearekin arazoak daude.");
        }

        
		scrollPane.setViewportView(table);
		
		JButton btnAstean = new JButton("Astean");
		btnAstean.setFocusPainted(false);
		btnAstean.setBounds(302, 521, 89, 23);
		contentPane.add(btnAstean);
		
		JButton btnHilabetean = new JButton("Hilabetean");
		btnHilabetean.setFocusPainted(false);
		btnHilabetean.setBounds(401, 521, 100, 23);
		contentPane.add(btnHilabetean);
		
		JButton btnUrtean = new JButton("Urtean");
		btnUrtean.setFocusPainted(false);
		btnUrtean.setBounds(511, 521, 89, 23);
		contentPane.add(btnUrtean);
		
		
		// ATZERA BOTOIA
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.adminEstatistikakMenua();
			}
		});
		
		// ASTEAN BOTOIA
		btnAstean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel modelAstean = new DefaultTableModel();
					modelAstean.addColumn("IdAudio");
				    modelAstean.addColumn("Abesti/Podcast izena");
				    modelAstean.addColumn("Iraupena");
				    modelAstean.addColumn("Entzunaldi totalak");
		            ArrayList<Abestia> abestiak = EstatistikakDAO.getTopEntzunaldiakStats("Astean");
		            for (Abestia abesti : abestiak) {
		                modelAstean.addRow(new Object[]{abesti.getIdAudio(), abesti.getTitulua(), abesti.getIraupena(), abesti.getErreprodukzioak()});
		            }
		            table.setModel(modelAstean);
		            table.repaint();
		        } catch (SQLException e1) {
		            JOptionPane.showMessageDialog(null, "Datu basearekin arazoak daude.");
		        }
			}
		});
		
		// HILABETEAN BOTOIA
		btnHilabetean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel modelHila = new DefaultTableModel();
					modelHila.addColumn("IdAudio");
				    modelHila.addColumn("Abesti/Podcast izena");
				    modelHila.addColumn("Iraupena");
				    modelHila.addColumn("Entzunaldi totalak");
		            ArrayList<Abestia> abestiak = EstatistikakDAO.getTopEntzunaldiakStats("Hilabetean");
		            for (Abestia abesti : abestiak) {
		                modelHila.addRow(new Object[]{abesti.getIdAudio(), abesti.getTitulua(), abesti.getIraupena(), abesti.getErreprodukzioak()});
		            }
		            table.setModel(modelHila);
		            table.repaint();
		        } catch (SQLException e1) {
		            JOptionPane.showMessageDialog(null, "Datu basearekin arazoak daude.");
		        }
			}
		});
		
		// URTEAN BOTOIA
		btnUrtean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel modelUrtean = new DefaultTableModel();
					modelUrtean.addColumn("IdAudio");
				    modelUrtean.addColumn("Abesti/Podcast izena");
				    modelUrtean.addColumn("Iraupena");
				    modelUrtean.addColumn("Entzunaldi totalak");
		            ArrayList<Abestia> abestiak = EstatistikakDAO.getTopEntzunaldiakStats("Urtean");
		            for (Abestia abesti : abestiak) {
		                modelUrtean.addRow(new Object[]{abesti.getIdAudio(), abesti.getTitulua(), abesti.getIraupena(), abesti.getErreprodukzioak()});
		            }
		            table.setModel(modelUrtean);
		            table.repaint();
		        } catch (SQLException e1) {
		            JOptionPane.showMessageDialog(null, "Datu basearekin arazoak daude.");
		        }
			}
		});		
	}

}
