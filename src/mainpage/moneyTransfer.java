package mainpage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import database.accountRelated;
import database.cardRelated;
import database.transactionRelated;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class moneyTransfer extends JFrame {

	private JPanel contentPane;
	private JTextField receipient;
	private JTextField amntfield;
	private accountRelated data;
	private cardRelated card;
	private transactionRelated trans;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
		//			moneyTransfer frame = new moneyTransfer("rashrana");
		//			frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public moneyTransfer(String username,StartIUp parent) {
		setVisible(true);
		setBounds(100, 100, 978, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		data=new accountRelated();
		card=new cardRelated();
		trans=new transactionRelated();
		
		JLabel transferhead = new JLabel("Money Transfer");
		transferhead.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(25, 25, 112), null));
		transferhead.setForeground(new Color(25, 25, 112));
		transferhead.setHorizontalAlignment(SwingConstants.CENTER);
		transferhead.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 35));
		transferhead.setBounds(10, 10, 954, 104);
		contentPane.add(transferhead);
		
		receipient = new JTextField();
		receipient.setForeground(new Color(25, 25, 112));
		receipient.setHorizontalAlignment(SwingConstants.CENTER);
		receipient.setFont(new Font("Calibri", Font.PLAIN, 20));
		receipient.setText("Enter Receipients'  Username");
		receipient.setBounds(252, 153, 455, 47);
		contentPane.add(receipient);
		receipient.setColumns(10);
		
		amntfield = new JTextField();
		amntfield.setHorizontalAlignment(SwingConstants.CENTER);
		amntfield.setForeground(new Color(25, 25, 112));
		amntfield.setFont(new Font("Calibri", Font.PLAIN, 20));
		amntfield.setText("Enter Amount");
		amntfield.setBounds(252, 230, 455, 47);
		contentPane.add(amntfield);
		amntfield.setColumns(10);
		
		JComboBox selectCard = new JComboBox();
		selectCard.setForeground(new Color(25, 25, 112));
		selectCard.setFont(new Font("Calibri", Font.PLAIN, 20));
		selectCard.setBounds(304, 298, 403, 47);
		contentPane.add(selectCard);
		
		int n=card.getCardsNumber(username);
		String[] cards=card.getCard(username,n);
		for(int i=0;i<n;i++) {
			selectCard.addItem(cards[i]);
		}
		
		JButton transferbtn = new JButton("Transfer");
		transferbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Receipient=receipient.getText();
				int amount=Integer.parseInt(amntfield.getText());
				boolean check = data.checkUsername(Receipient);
				if(check) {
						int amnt=Integer.parseInt(amntfield.getText());
						String use= (String)selectCard.getSelectedItem();
						double balance=card.getCardAmount(username, use);
						if(balance>=amnt) {
							int input=Integer.parseInt(JOptionPane.showInputDialog(moneyTransfer.this, "Enter your MTPIN"));
							int mtpn=data.getMtpn(username);
							if(mtpn==input) {
									String def=data.getDefaultCard(Receipient);
									boolean c=true;
									for(int l=0;l<16;l++) {
										if(!Character.isDigit(def.charAt(l))) {
											c=false;
											break;
										}
									}
									
									card.updateCardAmount(username, use, amount, 1);
									data.updateAmount(username,amount,1);
									data.updateAmount(Receipient, amount, 0);
									if(c) {
										trans.addTransaction("Money Transfer",def, "Payment", amount, use, username);
										trans.addTransaction("Requested Amount Received",use, "Received", amount, def, Receipient);
										card.updateCardAmount(username,def,amount,0);
									}
									else {
										trans.addTransaction("Money Transfer",Receipient, "Payment", amount, use, username);
										trans.addTransaction("Requested Amount Received",use, "Received", amount, "E-wallet", Receipient);
									}
									parent.transactionLoad(username);
							}
							else {
								JOptionPane.showMessageDialog(moneyTransfer.this,"Error!", "Wrong MTPIN",JOptionPane.YES_OPTION);
							}	
						}
						else {
							JOptionPane.showMessageDialog(moneyTransfer.this, "Insufficient Balance in this account!");
						}
							
							setVisible(false);
						}
					
					
					
					
					
				
				else{
					JOptionPane.showMessageDialog(moneyTransfer.this, "Username not found!");
					setVisible(false);
					}
				
			}
		});
		transferbtn.setForeground(new Color(25, 25, 112));
		transferbtn.setFont(new Font("Calibri", Font.PLAIN, 20));
		transferbtn.setBounds(382, 517, 220, 47);
		contentPane.add(transferbtn);
		
		
		
		ImageIcon img=new ImageIcon("C:\\Users\\Prashant\\Desktop\\6th sem\\Ewallet\\selectcard.png");
		Image i=img.getImage();
		Image t=i.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		img=new ImageIcon(t);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new LineBorder(new Color(192, 192, 192)));
		lblNewLabel.setIcon(img);
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel.setBounds(252, 298, 50, 47);
		contentPane.add(lblNewLabel);
	}
}
