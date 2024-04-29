package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MenuAukeraErreprodukzioV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MenuAukeraErreprodukzioV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 288, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("PlayListean sartu");
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnNewButton.setBounds(63, 46, 146, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Konpartitu");
		btnNewButton_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnNewButton_1.setBounds(80, 94, 114, 31);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("MENUA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 272, 14);
		contentPane.add(lblNewLabel);
	}

}
