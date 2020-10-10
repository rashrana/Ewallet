package mainpage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import database.transactionRelated;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReceivedTransactions extends JFrame {

	private JPanel contentPane;
	private transactionRelated trans;
	private JLabel rpanel;

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceivedTransactions frame = new ReceivedTransactions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	 * Create the frame.
	 */
	public ReceivedTransactions(String username,int operation) {
		setVisible(true);
		setBounds(100, 100, 844, 588);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		trans= new transactionRelated();
		
		
		String[] todisp=trans.getIncomingTransaction(username,operation);
		
		if(operation==0) {
			rpanel = new JLabel("Received Transactions");
		}
		else {
			rpanel = new JLabel("Payment Transactions");
		}
		rpanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(25, 25, 112), null));
		rpanel.setForeground(new Color(25, 25, 112));
		rpanel.setFont(new Font("Calibri", Font.BOLD, 35));
		rpanel.setHorizontalAlignment(SwingConstants.CENTER);
		rpanel.setBounds(10, 10, 829, 81);
		contentPane.add(rpanel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 810, 397);
		contentPane.add(scrollPane);
		
		JTextArea rtransactions = new JTextArea();
		rtransactions.setEditable(false);
		rtransactions.setForeground(new Color(25, 25, 112));
		rtransactions.setFont(new Font("Calibri", Font.PLAIN, 20));
		scrollPane.setViewportView(rtransactions);
		rtransactions.setText("Details\t\tFrom\t\tMY Account\t\tAmount\n");
		for(int i=0;i<todisp.length;i++) {
			rtransactions.append(todisp[i]);
		}
		
		
		JButton kobtn = new JButton("OK");
		kobtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		kobtn.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(25, 25, 112), null));
		kobtn.setForeground(new Color(25, 25, 112));
		kobtn.setFont(new Font("Calibri", Font.PLAIN, 20));
		kobtn.setBounds(319, 510, 199, 31);
		contentPane.add(kobtn);
	}
}
