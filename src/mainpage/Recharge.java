package mainpage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class Recharge extends JFrame {

	private JPanel contentPane;
	private JTextField phonenum;
	private JTextField rechargeamount;
	private cardRelated card;
	private accountRelated data;
	private ButtonGroup group;
	private JPanel second;
	private JPanel selection;
	private JPanel first;
	private transactionRelated trans;
	

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recharge frame = new Recharge("nived_kumar");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the frame.
	 */
	public Recharge(String username,StartIUp parent) {
		setVisible(true);
		setBounds(100, 100, 806, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		card=new cardRelated();
		data=new accountRelated();
		trans=new transactionRelated();
		
		first = new JPanel();
		contentPane.add(first, BorderLayout.CENTER);
		first.setLayout(null);
		first.setVisible(true);
		
		JLabel rechargehead = new JLabel("Recharge");
		rechargehead.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(25, 25, 112), null));
		rechargehead.setForeground(new Color(25, 25, 112));
		rechargehead.setHorizontalAlignment(SwingConstants.CENTER);
		rechargehead.setFont(new Font("Calibri", Font.BOLD, 35));
		rechargehead.setBounds(10, 10, 762, 86);
		first.add(rechargehead);
		
		phonenum = new JTextField();
		phonenum.setForeground(new Color(25, 25, 112));
		phonenum.setHorizontalAlignment(SwingConstants.CENTER);
		phonenum.setFont(new Font("Calibri", Font.PLAIN, 20));
		phonenum.setText("Enter Phone Number");
		phonenum.setBounds(161, 231, 447, 46);
		first.add(phonenum);
		phonenum.setColumns(10);
		
		JButton Nextbtn = new JButton("Next>>");
		Nextbtn.setForeground(new Color(25, 25, 112));
		Nextbtn.setFont(new Font("Calibri", Font.PLAIN, 20));
		Nextbtn.setBounds(269, 350, 223, 51);
		first.add(Nextbtn);
	
		
		
		second = new JPanel();
		second.setBounds(0, 0, 806, 722);
	
		second.setLayout(null);
		second.setVisible(false);
		
		
		JLabel samehead = new JLabel("Recharge");
		samehead.setHorizontalAlignment(SwingConstants.CENTER);
		samehead.setForeground(new Color(25, 25, 112));
		samehead.setFont(new Font("Calibri", Font.BOLD, 35));
		samehead.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(25, 25, 112), null));
		samehead.setBounds(10, 10, 762, 86);
		second.add(samehead);
		
		rechargeamount = new JTextField();
		rechargeamount.setText("Enter Amount");
		rechargeamount.setHorizontalAlignment(SwingConstants.CENTER);
		rechargeamount.setForeground(new Color(25, 25, 112));
		rechargeamount.setFont(new Font("Calibri", Font.PLAIN, 20));
		rechargeamount.setColumns(10);
		rechargeamount.setBounds(161, 254, 447, 46);
		second.add(rechargeamount);
		
		JButton recharge = new JButton("Recharge");
		recharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rechar=rechargeamount.getText();
				boolean check=true;
				int c=0;
				for(int i=0;i<rechar.length();i++) {
					if(!Character.isDigit(rechar.charAt(i)) & rechar.charAt(i)!='.') {
						check=false;
						break;
					}
					if(rechar.charAt(i)=='.') c++;
				}
				if((c==1 || c==0) & check==true) {
					second.setVisible(false);
					selection.setVisible(true);
					selection.setBounds(0, 0, 806, 722);
					contentPane.add(selection,BorderLayout.CENTER);
				}
				else {
					JOptionPane.showMessageDialog(Recharge.this, "Please enter valid amount!");
				}
				
				
				
				
			}
		});
		recharge.setForeground(new Color(25, 25, 112));
		recharge.setFont(new Font("Calibri", Font.PLAIN, 20));
		recharge.setBounds(272, 375, 223, 51);
		second.add(recharge);
		
		selection = new JPanel();
		selection.setVisible(false);
		selection.setLayout(new GridLayout(7,2));
		
		JLabel samehead2 = new JLabel("Recharge");
		samehead2.setHorizontalAlignment(SwingConstants.CENTER);
		samehead2.setForeground(new Color(25, 25, 112));
		samehead2.setFont(new Font("Calibri", Font.BOLD, 35));
		samehead2.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(25, 25, 112), null));
		selection.add(samehead2, "1, 1, fill, fill");
		
		Nextbtn.addActionListener(new ActionListener() {

			@Override
			
			public void actionPerformed(ActionEvent e) {
				boolean check=true;
				String Phone=phonenum.getText();
				
				for(int i=0;i<Phone.length();i++) {
					if(!Character.isDigit(Phone.charAt(i))) {
						check=false;
						break;
					}
				}
				if(Phone.length()==10) {
					if(check) {
						first.setVisible(false);
						second.setVisible(true);
						second.setBounds(0,0,806,722);
						selection.setVisible(false);
						contentPane.add(second,BorderLayout.CENTER);
						
					}
					else {
						JOptionPane.showMessageDialog(Recharge.this, "Phone number should be all digit.");
					}
				}
				else {
					JOptionPane.showMessageDialog(Recharge.this, "Please enter 10 digit valid Phone Number! ");
				}
				 
			}
			
		});
		
		int numberofcards=card.getCardsNumber(username);
		group=new ButtonGroup();
		
		class cardActionListener implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				String cardnum=group.getSelection().getActionCommand();
				Double am=card.getCardAmount(username,cardnum);
				System.out.println(cardnum+"  "+am);
				int rechargecost=Integer.parseInt(rechargeamount.getText());
				if(am >=rechargecost) {
					JOptionPane.showMessageDialog(Recharge.this, "Recharge Successful!");
					card.updateCardAmount(username,cardnum,rechargecost,1 );
					data.updateAmount(username, rechargecost,1);
					
					//implementing transaction
					String detail="Recharge on "+phonenum.getText();
					String type="Payment";
					String msg=trans.addTransaction(detail,"Airtel",type,rechargecost,cardnum,username);
					JOptionPane.showMessageDialog(Recharge.this, msg);
					parent.transactionLoad(username);
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(Recharge.this, "You do not have sufficient balance in this account!");
					setVisible(false);
				}
			}
			
		}
		cardActionListener cardlistener=new cardActionListener();
		String[] l1=card.getCard(username,numberofcards);
		String[] l2=card.getHoldername(username,numberofcards);
		JRadioButton[] n=new JRadioButton[numberofcards];
		Font fo= new Font("Calibri",Font.PLAIN,25);
		for(int i=0;i<numberofcards;i++) {
			try {
				
				String a="Card Number: "+l1[i];
				n[i]=new JRadioButton(a);
				group.add(n[i]);
				selection.add(n[i]);
				n[i].addActionListener(cardlistener);
				n[i].setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(176, 196, 222), null));
				n[i].setFont(fo);
				n[i].setBounds(22,30+((i+1)*110),600,140);
				n[i].setVisible(true);
				n[i].setForeground(Color.magenta);
				n[i].setActionCommand(l1[i]);
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
