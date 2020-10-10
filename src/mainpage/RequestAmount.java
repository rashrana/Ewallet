package mainpage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import database.accountRelated;
import database.cardRelated;
import database.transactionRelated;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class RequestAmount extends JFrame {

	private JPanel contentPane;
	private JTextField sendername;
	private JTextField reqamount;
	private accountRelated data;
	private cardRelated card;
	private transactionRelated trans;
	private Random r;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//RequestAmount frame = new RequestAmount("nived_kumar");
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RequestAmount(String username,StartIUp parent) {
		setVisible(true);
		setBounds(100, 100, 828, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		data= new accountRelated();
		card=new cardRelated();
		trans=new transactionRelated();
		r=new Random();
		
		JLabel requesthead = new JLabel("Request Amount");
		requesthead.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(25, 25, 112), null));
		requesthead.setForeground(new Color(25, 25, 112));
		requesthead.setHorizontalAlignment(SwingConstants.CENTER);
		requesthead.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 35));
		requesthead.setBounds(10, 10, 794, 106);
		contentPane.add(requesthead);
		
		sendername = new JTextField();
		sendername.setForeground(new Color(25, 25, 112));
		sendername.setFont(new Font("Calibri", Font.PLAIN, 20));
		sendername.setHorizontalAlignment(SwingConstants.CENTER);
		sendername.setText("Enter Senders' Username");
		sendername.setBounds(156, 249, 511, 46);
		contentPane.add(sendername);
		sendername.setColumns(10);
		
		reqamount = new JTextField();
		reqamount.setHorizontalAlignment(SwingConstants.CENTER);
		reqamount.setForeground(new Color(25, 25, 112));
		reqamount.setFont(new Font("Calibri", Font.PLAIN, 20));
		reqamount.setText("Amount");
		reqamount.setBounds(156, 338, 511, 46);
		contentPane.add(reqamount);
		reqamount.setColumns(10);
		
		JButton Request = new JButton("Request");
		Request.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Sender=sendername.getText();
				int amount=Integer.parseInt(reqamount.getText());
				boolean check = data.checkUsername(Sender);
				if(check) {
					int accept=r.nextInt(4);
					if(accept!=1) {
						String use=card.checkSendingCard(Sender,amount);
						boolean c=true;
						for(int l=0;l<16;l++) {
							if(!Character.isDigit(use.charAt(l))) {
								c=false;
								break;
							}
						}
						if(c) {
							String def=data.getDefaultCard(username);
							
							
							card.updateCardAmount(Sender, use, amount, 1);
							data.updateAmount(Sender,amount,1);
							trans.addTransaction("Requested Amount Transfer",def, "Payment", amount, use, Sender);
							
							
							
							boolean d=true;
							for(int l=0;l<16;l++) {
								if(!Character.isDigit(def.charAt(l))) {
									d=false;
									break;
								}
							}
							if(d) {
								card.updateCardAmount(username,def,amount,0);
								trans.addTransaction("Requested Amount Received",use, "Received", amount, def, username);
							}
							else {
								trans.addTransaction("Requested Amount Received",use ,"Received", amount, def, username);
							}
							data.updateAmount(username, amount, 0);
							JOptionPane.showMessageDialog(RequestAmount.this, "Amount Received Successfully!");
							parent.transactionLoad(username);
							setVisible(false);
						}
						else {
							JOptionPane.showMessageDialog(RequestAmount.this, "Insufficient Balance in Senders' account!");
							setVisible(false);
						}
					}
					else {
						JOptionPane.showMessageDialog(RequestAmount.this, "Sender Denied Request!");
						setVisible(false);
					}
					
					
				}
				else{
					JOptionPane.showMessageDialog(RequestAmount.this, "Username not found!");
					setVisible(false);
					}
			}
		});
		Request.setForeground(new Color(25, 25, 112));
		Request.setFont(new Font("Calibri", Font.PLAIN, 20));
		Request.setBounds(289, 465, 235, 46);
		contentPane.add(Request);
	}
}
