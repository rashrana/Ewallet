package mainpage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import database.accountRelated;
import database.cardRelated;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaveCard extends JFrame {
	private cardRelated data;
	private accountRelated ddata;
	private JPanel contentPane;
	private JTextField Atmnumber;
	private JTextField accHolder;
	private JTextField cardvalidity;
	private JTextField cvnum;
	private String username;
	

	public SaveCard(String user,StartIUp parent) {
		username=user;
		data=new cardRelated();
		ddata=new accountRelated();
		setBounds(100, 100, 774, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		Atmnumber = new JTextField();
		Atmnumber.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(Atmnumber.getText().equals("Card Number")) Atmnumber.setText("");
			}
			public void mouseExited(MouseEvent e) {
				if(Atmnumber.getText().equals("")) Atmnumber.setText("Card Number");
			}
		});
		Atmnumber.setHorizontalAlignment(SwingConstants.CENTER);
		Atmnumber.setForeground(new Color(25, 25, 112));
		Atmnumber.setFont(new Font("Calibri", Font.PLAIN, 20));
		Atmnumber.setText("Card Number");
		Atmnumber.setBounds(175, 172, 390, 36);
		contentPane.add(Atmnumber);
		Atmnumber.setColumns(10);
		
		accHolder = new JTextField();
		accHolder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(accHolder.getText().equals("Account Holders' Name")) accHolder.setText("");
			}
			public void mouseExited(MouseEvent e) {
				if(accHolder.getText().equals("")) accHolder.setText("Account Holders' Name");
			}
		});
		accHolder.setHorizontalAlignment(SwingConstants.CENTER);
		accHolder.setForeground(new Color(25, 25, 112));
		accHolder.setFont(new Font("Calibri", Font.PLAIN, 20));
		accHolder.setText("Account Holders' Name");
		accHolder.setBounds(175, 243, 390, 36);
		contentPane.add(accHolder);
		accHolder.setColumns(10);
		
		cardvalidity = new JTextField();
		cardvalidity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(cardvalidity.getText().equals("Card Validity Date(YYYY/MM)")) cardvalidity.setText("");
			}
			public void mouseExited(MouseEvent e) {
				if(cardvalidity.getText().equals("")) cardvalidity.setText("Card Validity Date(YYYY/MM)");
			}
		});
		cardvalidity.setHorizontalAlignment(SwingConstants.CENTER);
		cardvalidity.setForeground(new Color(25, 25, 112));
		cardvalidity.setFont(new Font("Calibri", Font.PLAIN, 20));
		cardvalidity.setText("Card Validity Date(YYYY/MM)");
		cardvalidity.setBounds(175, 319, 390, 36);
		contentPane.add(cardvalidity);
		cardvalidity.setColumns(10);
		
		cvnum = new JTextField();
		cvnum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(cvnum.getText().equals("CV Number")) cvnum.setText("");
			}
			public void mouseExited(MouseEvent e) {
				if(cvnum.getText().equals("")) cvnum.setText("CV Number");
			}
		});
		cvnum.setHorizontalAlignment(SwingConstants.CENTER);
		cvnum.setForeground(new Color(25, 25, 112));
		cvnum.setFont(new Font("Calibri", Font.PLAIN, 20));
		cvnum.setText("CV Number");
		cvnum.setBounds(175, 396, 390, 36);
		contentPane.add(cvnum);
		cvnum.setColumns(10);
		
		JButton SaveBtn = new JButton("Save");
		SaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random r=new Random();
				int am=r.nextInt(10000);
				String acc=Atmnumber.getText();
				String na=accHolder.getText();
				String da=cardvalidity.getText();
				String cv=cvnum.getText();
				
				if(acc.equals("") || na.equals("") || da.equals("") || cv.equals(""))
					JOptionPane.showMessageDialog(SaveCard.this, "Please fill all the fields!");
				else if(acc.length()!=16 || cv.length()!=3 || da.length()!=7){
					
					JOptionPane.showMessageDialog(SaveCard.this, "CVV should be 3 digits!\nCard number should be 16 digit long!\n Validity Date format is YYYY/MM!");
				}
				else {
					int i=0,j=0;
					for(int l=0;l<16;l++) {
						if(!Character.isDigit(acc.charAt(l))) {
							i=1;
							break;
						}
					}
					for(int l=0;l<3;l++) {
						
						if(!Character.isDigit(cv.charAt(l))) {
							j=1;
							break;
						}
					}
					
					//Add Card exits for the given user //boolean check=data.checkUsername(usern);
					if(i==1 || j==1 ) {
						JOptionPane.showMessageDialog(SaveCard.this, "Please enter valid Card Number and CVV!");
					}
					else {
						String msg=data.addCard(acc,na,da,Integer.parseInt(cv),am,username);
						ddata.updateAmount(username,am,0);
						JOptionPane.showMessageDialog(SaveCard.this, msg);
						parent.addition();
						parent.detailrefresh();
						setVisible(false);
					}
				
				}
			
			}	
		});
		SaveBtn.setForeground(new Color(25, 25, 112));
		SaveBtn.setFont(new Font("Calibri", Font.PLAIN, 20));
		SaveBtn.setBounds(250, 475, 216, 36);
		contentPane.add(SaveBtn);
		
		JLabel cardheader = new JLabel("Save Card");
		cardheader.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(176, 196, 222), null));
		cardheader.setHorizontalAlignment(SwingConstants.CENTER);
		cardheader.setForeground(new Color(25, 25, 112));
		cardheader.setFont(new Font("Calibri", Font.BOLD, 35));
		cardheader.setBounds(10, 10, 740, 85);
		contentPane.add(cardheader);
	}
	
}
