package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.metodoak.JFrameSortu;
import model.metodoak.View_metodoak;

public class ArtistaV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public ArtistaV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		JButton btnAtzera = View_metodoak.btn_Atzera();
		contentPane.add(btnAtzera);
		
		JButton btnNireProfila = View_metodoak.btn_NireProfila();
		contentPane.add(btnNireProfila);
		
		
		
		
		
		
		
		
		
	
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
