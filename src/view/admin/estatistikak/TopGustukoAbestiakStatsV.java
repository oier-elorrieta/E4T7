package view.admin.estatistikak;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.LoginV;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Abestia;
import model.metodoak.JFrameSortu;
import model.metodoak.View_metodoak;
import model.sql.admin.EstatistikakDAO;

public class TopGustukoAbestiakStatsV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
    private DefaultTableModel model;

	/**
	 * Create the frame.
	 */
	public TopGustukoAbestiakStatsV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Top gustuko abestiak - ADMIN Estatistikak - JPAM Music");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginV.class.getResource("/images/jpam_logo.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);
		
		JLabel lblTopGustukoAbestiak = new JLabel("TOP GUSTUKO ABESTIAK");
		lblTopGustukoAbestiak.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopGustukoAbestiak.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTopGustukoAbestiak.setBounds(0, 21, 890, 27);
		contentPane.add(lblTopGustukoAbestiak);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 75, 787, 443);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
        model.addColumn("IdAudio");
        model.addColumn("Abesti izena");
        model.addColumn("Iraupena");
        model.addColumn("Gustoko totalak");

        table = new JTable(model);
        model.isCellEditable(0, 0);

        try {
            ArrayList<Abestia> abestiak = EstatistikakDAO.getTopGustukoAbestiakStats("Totalak");
            for (Abestia abesti : abestiak) {
                model.addRow(new Object[]{abesti.getIdAudio(), abesti.getTitulua(), abesti.getIraupena(), abesti.getErreprodukzioak()});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Datu basearekin arazoak daude.");
        }

		scrollPane.setViewportView(table);
		
		JButton btnAstean = new JButton("Astean");
		btnAstean.setBounds(314, 521, 89, 23);
		btnAstean.setFocusPainted(false);
		contentPane.add(btnAstean);
		
		JButton btnHilabetean = new JButton("Hilabetean");
		btnHilabetean.setBounds(413, 521, 100, 23);
		btnHilabetean.setFocusPainted(false);
		contentPane.add(btnHilabetean);
		
		JButton btnUrtean = new JButton("Urtean");
		btnUrtean.setBounds(523, 521, 89, 23);
		btnUrtean.setFocusPainted(false);
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
				    modelAstean.addColumn("Abesti izena");
				    modelAstean.addColumn("Iraupena");
				    modelAstean.addColumn("Gustoko totalak");
		            ArrayList<Abestia> abestiak = EstatistikakDAO.getTopGustukoAbestiakStats("Astean");
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
				    modelHila.addColumn("Abesti izena");
				    modelHila.addColumn("Iraupena");
				    modelHila.addColumn("Gustoko totalak");
		            ArrayList<Abestia> abestiak = EstatistikakDAO.getTopGustukoAbestiakStats("Hilabetean");
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
				    modelUrtean.addColumn("Abesti izena");
				    modelUrtean.addColumn("Iraupena");
				    modelUrtean.addColumn("Gustoko totalak");
		            ArrayList<Abestia> abestiak = EstatistikakDAO.getTopGustukoAbestiakStats("Urtean");
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
