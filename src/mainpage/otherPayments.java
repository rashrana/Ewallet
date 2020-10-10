package mainpage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class otherPayments extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					otherPayments frame = new otherPayments();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public otherPayments() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, "name_198352003463200");
		
		JLabel travelhead = new JLabel("New label");
		travelhead.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(25, 25, 112), null));
		travelhead.setForeground(new Color(25, 25, 112));
		travelhead.setHorizontalAlignment(SwingConstants.CENTER);
		travelhead.setFont(new Font("Calibri", Font.BOLD, 35));
		travelhead.setBounds(10, 10, 817, 99);
		layeredPane.add(travelhead);
	}

}
