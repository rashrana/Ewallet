package mainpage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import database.accountRelated;
import database.cardRelated;
import database.transactionRelated;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import java.awt.GridLayout;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;


public class StartIUp extends JFrame {
	
	private JPanel CardsPanel;
	private editProfile profile;
	private accountRelated data;
	private JPanel contentPane;
	private GridBagConstraints g_1;
	private String username;
	private String password;
	private int mtpn;
	private String name;
	private int age;
	private String address;
	private String phone;
	private double amount;
	private cardRelated card;
	private transactionRelated trans;
	private JTextArea textArea;
	private JPanel panel_1;
	
	private ButtonGroup delsel;
	private ButtonGroup defsel;
	private JPanel deletecard;
	private JPanel cards;
	private JPanel selectdefault; 
	private JButton addcardnow;
	
	private JPanel AccountPane;
	private Font f;
	private JLabel user;
	private JLabel aname;
	private JLabel ages;
	private JLabel addres;
	private JLabel phoneno;
	private JLabel amounts;
	private JButton edit;
	private JLabel changepwd;
	private JLabel lblNewLabel;
	private Color c;
	
	
	public StartIUp(String userna) {
		
		card=new cardRelated();
		data=new accountRelated();
		trans=new transactionRelated();
		username=userna;
		password=data.getPassword(username);
		mtpn=data.getMtpn(username);
		name=data.getName(username);
		age=Integer.parseInt(data.getAge(username));
		address=data.getAddress(username);
		phone=data.getPhone(username);
		amount=Double.parseDouble(data.getAmount(username));
		
		c=new Color(25, 25, 112);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setBounds(100, 100, 1209, 666);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		
		
		JTabbedPane AccountPanel = new JTabbedPane(JTabbedPane.LEFT);
		AccountPanel.setSize(new Dimension(50, 30));
		AccountPanel.setMinimumSize(new Dimension(50, 30));
		AccountPanel.setBounds(new Rectangle(0, 0, 30, 20));
		AccountPanel.setPreferredSize(new Dimension(50, 50));
		contentPane.add(AccountPanel, BorderLayout.CENTER);
		
		JPanel paymentPanel = new JPanel();
		AccountPanel.addTab("Payment", null, paymentPanel, null);
		GridBagLayout gbl_paymentPanel = new GridBagLayout();
		gbl_paymentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_paymentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_paymentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_paymentPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		paymentPanel.setLayout(gbl_paymentPanel);
		
		JButton rechargebtn = new JButton("");
		rechargebtn.setIconTextGap(0);
		rechargebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						new Recharge(username,StartIUp.this);
					}
					
					
				});
				
			}
		});
		rechargebtn.setIcon(new ImageIcon("C:\\Users\\Prashant\\Desktop\\6th sem\\Ewallet\\recharge.png"));
		rechargebtn.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "Recharge", TitledBorder.CENTER ,TitledBorder.BELOW_BOTTOM, new Font("Calibri",Font.BOLD,15), Color.blue));
		GridBagConstraints gbc_rechargebtn = new GridBagConstraints();
		gbc_rechargebtn.fill = GridBagConstraints.BOTH;
		gbc_rechargebtn.insets = new Insets(0, 0, 5, 5);
		gbc_rechargebtn.gridx = 0;
		gbc_rechargebtn.gridy = 0;
		paymentPanel.add(rechargebtn, gbc_rechargebtn);
		
		JButton billbtn = new JButton("");
		billbtn.setIcon(new ImageIcon("C:\\Users\\Prashant\\Desktop\\6th sem\\Ewallet\\bills.png"));
		GridBagConstraints gbc_billbtn = new GridBagConstraints();
		gbc_billbtn.insets = new Insets(0, 0, 5, 5);
		gbc_billbtn.fill = GridBagConstraints.BOTH;
		gbc_billbtn.gridx = 1;
		gbc_billbtn.gridy = 0;
		paymentPanel.add(billbtn, gbc_billbtn);
		billbtn.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "Bills", TitledBorder.CENTER ,TitledBorder.BELOW_BOTTOM, new Font("Calibri",Font.BOLD,15), Color.blue));
		
		JButton Travelbtn = new JButton("");
		Travelbtn.setIcon(new ImageIcon("C:\\Users\\Prashant\\Desktop\\6th sem\\Ewallet\\travels.png"));
		Travelbtn.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "Travels", TitledBorder.CENTER ,TitledBorder.BELOW_BOTTOM, new Font("Calibri",Font.BOLD,15), Color.blue));
		GridBagConstraints gbc_Travelbtn = new GridBagConstraints();
		gbc_Travelbtn.insets = new Insets(0, 0, 5, 5);
		gbc_Travelbtn.fill = GridBagConstraints.BOTH;
		gbc_Travelbtn.gridx = 2;
		gbc_Travelbtn.gridy = 0;
		paymentPanel.add(Travelbtn, gbc_Travelbtn);
		
		JButton transferbtn = new JButton("");
		transferbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						new moneyTransfer(username,StartIUp.this);
					}
					
					
				});
			}
		});
		transferbtn.setIcon(new ImageIcon("C:\\Users\\Prashant\\Desktop\\6th sem\\Ewallet\\money transfer.png"));
		GridBagConstraints gbc_transferbtn = new GridBagConstraints();
		gbc_transferbtn.fill = GridBagConstraints.BOTH;
		gbc_transferbtn.insets = new Insets(0, 0, 5, 0);
		gbc_transferbtn.gridx = 3;
		gbc_transferbtn.gridy = 0;
		paymentPanel.add(transferbtn, gbc_transferbtn);
		
		JButton Entertainmentbtn = new JButton("");
		Entertainmentbtn.setIcon(new ImageIcon("C:\\Users\\Prashant\\Desktop\\6th sem\\Ewallet\\entertainment.jpg"));
		Entertainmentbtn.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "Entertainment", TitledBorder.CENTER ,TitledBorder.BELOW_BOTTOM, new Font("Calibri",Font.BOLD,15), Color.blue));
		GridBagConstraints gbc_Entertainmentbtn = new GridBagConstraints();
		gbc_Entertainmentbtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_Entertainmentbtn.insets = new Insets(0, 0, 0, 5);
		gbc_Entertainmentbtn.gridx = 0;
		gbc_Entertainmentbtn.gridy = 1;
		paymentPanel.add(Entertainmentbtn, gbc_Entertainmentbtn);
		
		JLabel paymentsIcon = new JLabel("");
		paymentsIcon.setIcon(new ImageIcon("C:\\Users\\Prashant\\Desktop\\6th sem\\Ewallet\\Ewallet.png"));
		GridBagConstraints gbc_paymentsIcon = new GridBagConstraints();
		gbc_paymentsIcon.insets = new Insets(0, 0, 0, 5);
		gbc_paymentsIcon.gridx = 1;
		gbc_paymentsIcon.gridy = 1;
		paymentPanel.add(paymentsIcon, gbc_paymentsIcon);
		
		JButton Foodbtn = new JButton("");
		Foodbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Foodbtn.setIcon(new ImageIcon("C:\\Users\\Prashant\\Desktop\\6th sem\\Ewallet\\food.png"));
		Foodbtn.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "Food", TitledBorder.CENTER ,TitledBorder.BELOW_BOTTOM, new Font("Calibri",Font.BOLD,15), Color.blue));
		GridBagConstraints gbc_Foodbtn = new GridBagConstraints();
		gbc_Foodbtn.fill = GridBagConstraints.BOTH;
		gbc_Foodbtn.insets = new Insets(0, 0, 0, 5);
		gbc_Foodbtn.gridx = 2;
		gbc_Foodbtn.gridy = 1;
		paymentPanel.add(Foodbtn, gbc_Foodbtn);
		
		JButton paymentsbtn = new JButton("");
		paymentsbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new ReceivedTransactions(username,1);
					}
				});
			}
		});
		paymentsbtn.setIcon(new ImageIcon("C:\\Users\\Prashant\\Desktop\\6th sem\\Ewallet\\payments.png"));
		GridBagConstraints gbc_paymentsbtn = new GridBagConstraints();
		gbc_paymentsbtn.fill = GridBagConstraints.BOTH;
		gbc_paymentsbtn.gridx = 3;
		gbc_paymentsbtn.gridy = 1;
		paymentPanel.add(paymentsbtn, gbc_paymentsbtn);
		
		JPanel ReveivePanel = new JPanel();
		AccountPanel.addTab("Receive", null, ReveivePanel, null);
		GridBagLayout gbl_ReveivePanel = new GridBagLayout();
		gbl_ReveivePanel.columnWidths = new int[]{0, 0, 0};
		gbl_ReveivePanel.rowHeights = new int[]{0, 0};
		gbl_ReveivePanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_ReveivePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		ReveivePanel.setLayout(gbl_ReveivePanel);
		
		JButton receivedbtn = new JButton("");
		receivedbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new ReceivedTransactions(username,0);
					}
				});
			}
		});
		receivedbtn.setIcon(new ImageIcon("C:\\Users\\Prashant\\Desktop\\6th sem\\Ewallet\\incoming.png"));
		
		receivedbtn.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "Received Amounts", TitledBorder.CENTER ,TitledBorder.BELOW_BOTTOM, new Font("Calibri",Font.BOLD,15), Color.blue));GridBagConstraints gbc_receivedbtn = new GridBagConstraints();
		gbc_receivedbtn.fill = GridBagConstraints.BOTH;
		gbc_receivedbtn.insets = new Insets(0, 0, 0, 5);
		gbc_receivedbtn.gridx = 0;
		gbc_receivedbtn.gridy = 0;
		ReveivePanel.add(receivedbtn, gbc_receivedbtn);
		
		JButton Requestbtn = new JButton("");
		Requestbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new RequestAmount(username,StartIUp.this);
					}
				});
				
			}
		});
		Requestbtn.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "Request Amount", TitledBorder.CENTER ,TitledBorder.BELOW_BOTTOM, new Font("Calibri",Font.BOLD,15), Color.blue));
		Requestbtn.setIcon(new ImageIcon("C:\\Users\\Prashant\\Desktop\\6th sem\\Ewallet\\request.png"));
		GridBagConstraints gbc_Requestbtn = new GridBagConstraints();
		gbc_Requestbtn.fill = GridBagConstraints.BOTH;
		gbc_Requestbtn.gridx = 1;
		gbc_Requestbtn.gridy = 0;
		ReveivePanel.add(Requestbtn, gbc_Requestbtn);
		
		JPanel TransacionPanel = new JPanel();
		AccountPanel.addTab("Transactions", null, TransacionPanel, null);
		TransacionPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		TransacionPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel controlPanel = new JPanel();
		panel.add(controlPanel, BorderLayout.SOUTH);
		GridBagConstraints g=new GridBagConstraints();
		g.ipadx = 80;
		g.weightx = 10.0;
		controlPanel.setLayout(new GridBagLayout());
		
		g.gridx=0;
		g.gridy=0;
		g.anchor=g.LINE_START;
		JButton prevbtn=new JButton("<-Prev");
		prevbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		prevbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		prevbtn.setPreferredSize(new Dimension(50, 50));
		controlPanel.add(prevbtn,g);
		
		g_1=new GridBagConstraints();
		g_1.ipadx = 80;
		g_1.weightx = 10.0;
		g_1.gridx=1;
		g_1.anchor=GridBagConstraints.EAST;
		JButton nextbtn=new JButton("Next->");
		nextbtn.setPreferredSize(new Dimension(50, 50));
		nextbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		controlPanel.add(nextbtn,g_1);
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setForeground(new Color(25, 25, 112));
		textArea.setFont(new Font("Calibri", Font.PLAIN, 20));
		textArea.setEditable(false);
		textArea.setBounds(10, 0, 989, 583);
		panel_1.add(textArea);
		
		///adding transactions
		transactionLoad(username);
		
		CardsPanel = new JPanel();
		AccountPanel.addTab("Saved Cards", null, CardsPanel, null);
		CardsPanel.setLayout(null);
		
		/*
		
		JButton AddCardbtn = new JButton("Add Card");
		AddCardbtn.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				CardsPanel.repaint();
			}
		});
		AddCardbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						new SaveCard(username);
						
					}
					
					
				});
				addition();
				CardsPanel.repaint();
				CardsPanel.revalidate();
				amount=Double.parseDouble(data.getAmount(username));
				
			}
		});
		AddCardbtn.setFont(new Font("Calibri", Font.PLAIN, 25));
		AddCardbtn.setBounds(75, 250, 191, 46);
		CardsPanel.add(AddCardbtn);
		*/
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1015, 604);
		CardsPanel.add(tabbedPane);
		
		cards = new JPanel();
		tabbedPane.addTab("Cards", null, cards, null);
		
		
		deletecard = new JPanel();
		tabbedPane.addTab("Delete Cards", null, deletecard, null);
		delsel=new ButtonGroup();
		
		//IMPLEMENTING SELECTDEFAULT
		selectdefault = new JPanel();
		tabbedPane.addTab("Choose Default Card", null, selectdefault, null);
		//selectdefault.setLayout(new GridLayout(4, 2, 5, 5));
		
		defsel=new ButtonGroup();
		
		//choosedef();
		
		addcardnow = new JButton("Add Card");
		addcardnow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						new SaveCard(username,StartIUp.this);
						
					}
					
					
				});
				addition();
				amount=Double.parseDouble(data.getAmount(username));
				
			}
		});
		cards.setLayout(new GridLayout(6, 2, 0, 0));
		addcardnow.setFont(new Font("Calibri", Font.PLAIN, 25));
		cards.add(addcardnow);
		addition();

		
		
		
		
		
		
		
				
		
		JPanel FAQPanel = new JPanel();
		AccountPanel.addTab("Help & FAQ's", null, FAQPanel, null);
		FAQPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel ques1 = new JLabel("Q.How to check my Account Balance?");
		ques1.setForeground(new Color(25, 25, 112));
		ques1.setFont(new Font("Calibri", Font.BOLD, 25));
		FAQPanel.add(ques1);
		
		JLabel ans1 = new JLabel("A->Go To YOUR ACCOUNT Tab & you'll be able to your account total Balance.");
		ans1.setForeground(new Color(25, 25, 112));
		ans1.setFont(new Font("Calibri", Font.PLAIN, 20));
		FAQPanel.add(ans1);
		
		
		JLabel ques2 = new JLabel("Q.How to change my Password?");
		ques2.setForeground(new Color(25, 25, 112));
		ques2.setFont(new Font("Calibri", Font.BOLD, 25));
		FAQPanel.add(ques2);
		
		JLabel ans2 = new JLabel("<HTML>A->Go To YOUR ACCOUNT Tab, Click on Change Password Label and you'll be taken to a new panel where<br> you'll need to give your old password.</HTML>");
		ans2.setForeground(new Color(25, 25, 112));
		ans2.setFont(new Font("Calibri", Font.PLAIN, 20));
		FAQPanel.add(ans2);
		
		JLabel ques3 = new JLabel("Q.How to choose my default class?");
		ques3.setForeground(new Color(25, 25, 112));
		ques3.setFont(new Font("Calibri", Font.BOLD, 25));
		FAQPanel.add(ques3);
		
		JLabel ans3 = new JLabel("A->Go To Saved Cards Tab , Select Default Card Tab then select your prefered card.");
		ans3.setForeground(new Color(25, 25, 112));
		ans3.setFont(new Font("Calibri", Font.PLAIN, 20));
		FAQPanel.add(ans3);
		
		JLabel ques4 = new JLabel("Q.Why do I need MTPN?");
		ques4.setForeground(new Color(25, 25, 112));
		ques4.setFont(new Font("Calibri", Font.BOLD, 25));
		FAQPanel.add(ques4);
		
		JLabel ans4 = new JLabel("A->When you transfer money you'll be asked to enter your MTPN.");
		ans4.setForeground(new Color(25, 25, 112));
		ans4.setFont(new Font("Calibri", Font.PLAIN, 20));
		FAQPanel.add(ans4);
		
		JLabel ques5 = new JLabel("Q.Where can I see my Payment and Recieved specific transactions.");
		ques5.setForeground(new Color(25, 25, 112));
		ques5.setFont(new Font("Calibri", Font.BOLD, 25));
		FAQPanel.add(ques5);
		
		JLabel ans5 = new JLabel("A->Payment transaction is in Payment Button in payment tab & Incoming transaction is in Received button of Received.");
		ans5.setForeground(new Color(25, 25, 112));
		ans5.setFont(new Font("Calibri", Font.PLAIN, 20));
		FAQPanel.add(ans5);
		
		JPanel AccountPanels = new JPanel();
		AccountPanel.addTab("Your Account", null, AccountPanels, null);
		AccountPanels.setLayout(null);
		
		AccountPane = new JPanel();
		AccountPane.setBounds(0, 5, 1005, 599);
		AccountPanels.add(AccountPane);
		AccountPane.setLayout(null);
		
		
		AccountPane.setBorder(null);
		
		f=new Font("Calibri", Font.PLAIN, 25);
		edit=new JButton("Edit");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						new editProfile(username,0,StartIUp.this);
					}
					
				});
			}
		});
		
		
						
		
		
		
		changepwd = new JLabel("<HTML><U>Change Password</U></HTML>");
		changepwd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						new editProfile(username,1,StartIUp.this);
					}
					
				});
			}
		});
		changepwd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		changepwd.setBorder(null);
		changepwd.setForeground(Color.BLUE);
		changepwd.setFont(new Font("Calibri", Font.BOLD, 25));
		
		
		
		lblNewLabel = new JLabel("<HTML><U>Change MTPN</U></HTML>");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						new editProfile(username,2,StartIUp.this);
					}
					
				});
			}
		});
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		
				
		detailrefresh();

	}
	
public void choosedel() {
		
		
		class delActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				
					String cardnum=delsel.getSelection().getActionCommand();
				
					int op=JOptionPane.showConfirmDialog(StartIUp.this, "Do you really want to delete this card?");
					if(op==0) {
						int i=card.deleteCard(username,cardnum);
						if(i==1) {
							data.checkDefaultCard(username,cardnum);
							JOptionPane.showMessageDialog(StartIUp.this, "Card Deleted Successfully!");
						}
						else {
							JOptionPane.showMessageDialog(StartIUp.this,"Error", "Card not Deleted Successfully!",JOptionPane.ERROR_MESSAGE);
						}
					}
					addition();
					choosedef();
				
			}
		}
		
		deletecard.removeAll();
		deletecard.repaint();
		
		deletecard.setLayout(new GridLayout(4, 2, 5, 5));
		JLabel seldelhead = new JLabel("Select the card you want to delete!");
		seldelhead.setForeground(new Color(25, 25, 112));
		seldelhead.setHorizontalAlignment(SwingConstants.CENTER);
		seldelhead.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));
		deletecard.add(seldelhead);
		
		
		int numberofcards=card.getCardsNumber(username);
		String[] l1=card.getCard(username,numberofcards);
		JRadioButton[] n=new JRadioButton[numberofcards];
		ActionListener ac=new delActionListener();
		Font fo= new Font("Calibri",Font.PLAIN,25);
		for(int i=0;i<numberofcards;i++) {
				
				String a=l1[i];
				n[i]=new JRadioButton(a);
				n[i].setFont(fo);
				n[i].setVisible(true);
				n[i].setForeground(Color.blue);
				n[i].setActionCommand(a);
				n[i].addActionListener(ac);
				delsel.add(n[i]);
				deletecard.add(n[i]);
			
			
		}
		deletecard.repaint();
	}
	public void choosedef() {
		
		
		class defActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				String cardnum=defsel.getSelection().getActionCommand();
				
					String msg=data.updateDefaultCard(cardnum,username);
					JOptionPane.showMessageDialog(StartIUp.this, msg);				
				
			}
		}
		
		selectdefault.removeAll();
		selectdefault.repaint();
		
		selectdefault.setLayout(new GridLayout(4, 2, 5, 5));
		JLabel seldefhead = new JLabel("Select Default Card");
		seldefhead.setForeground(new Color(25, 25, 112));
		seldefhead.setHorizontalAlignment(SwingConstants.CENTER);
		seldefhead.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));
		selectdefault.add(seldefhead);
		
		
		int numberofcards=card.getCardsNumber(username);
		String[] l1=card.getCard(username,numberofcards);
		JRadioButton[] n=new JRadioButton[numberofcards];
		ActionListener ac=new defActionListener();
		Font fo= new Font("Calibri",Font.PLAIN,25);
		for(int i=0;i<numberofcards;i++) {
				
				String a=l1[i];
				n[i]=new JRadioButton(a);
				n[i].setFont(fo);
				n[i].setVisible(true);
				n[i].setForeground(Color.blue);
				n[i].setActionCommand(a);
				n[i].addActionListener(ac);
				defsel.add(n[i]);
				selectdefault.add(n[i]);
			
			
		}
		selectdefault.repaint();
	}
	
	public void addition() {
		int numberofcards=card.getCardsNumber(username);
		cards.removeAll();
		cards.repaint();
		
		cards.setLayout(new GridLayout(6, 2, 0, 0));
		cards.add(addcardnow);
		String[] l1=card.getCard(username,numberofcards);
		String[] l2=card.getHoldername(username,numberofcards);
		JLabel[] n=new JLabel[numberofcards];
		Font fo= new Font("Calibri",Font.PLAIN,25);
		for(int i=0;i<numberofcards;i++) {
		
				
				String a=l2[i]+" : "+l1[i];
				n[i]=new JLabel(a);
				n[i].setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(176, 196, 222), null));
				n[i].setFont(fo);
				n[i].setBounds(22,30+((i+1)*60),700,60);
				n[i].setVisible(true);
				n[i].setForeground(Color.magenta);
				cards.add(n[i]);
			
	
		}
		cards.repaint();
		choosedef();
		choosedel();
	}
	public void transactionLoad(String username) {
		String[] receive= trans.getTransaction(username);
		textArea.setText("Detail\t\t\tTo/From\tCardNumber\t\tType\tAmount\n");
		for(int i=0;i<receive.length;i++) {
			textArea.append(receive[i]);
		}
		panel_1.repaint();
		panel_1.revalidate();
	}
	public void detailrefresh() {
		card=new cardRelated();
		data=new accountRelated();
		trans=new transactionRelated();
		password=data.getPassword(username);
		mtpn=data.getMtpn(username);
		name=data.getName(username);
		age=Integer.parseInt(data.getAge(username));
		address=data.getAddress(username);
		phone=data.getPhone(username);
		amount=Double.parseDouble(data.getAmount(username));
		
		AccountPane.removeAll();
		AccountPane.repaint();
		
		user= new JLabel("Username: "+username);
		user.setFont(f);
		user.setForeground(c);
		user.setBounds(30, 0, 969, 42);
		aname=new JLabel("Name: "+name);
		aname.setFont(f);
		aname.setForeground(c);
		aname.setBounds(30, 52, 969, 42);
		ages= new JLabel("Age: "+age+"");
		ages.setBounds(30, 104, 969, 42);
		ages.setForeground(c);
		ages.setFont(f);
		addres=new JLabel("Address: "+address);
		addres.setFont(f);
		addres.setForeground(c);
		addres.setBounds(30, 156, 969, 42);
		phoneno=new JLabel("Phone: "+phone);
		phoneno.setFont(f);
		phoneno.setForeground(c);
		phoneno.setBounds(30, 221, 969, 42);
		amounts=new JLabel("Amount: Rs "+amount+"");
		amounts.setFont(f);
		amounts.setForeground(c);
		amounts.setBounds(30, 273, 969, 42);
		edit.setForeground(c);
		edit.setFont(f);
		edit.setBounds(30, 342, 307, 42);
		changepwd.setBounds(30, 413, 969, 42);
		lblNewLabel.setBounds(30, 465, 307, 42);
		
		AccountPane.setLayout(null);
		AccountPane.add(user);
		AccountPane.add(aname);
		AccountPane.add(ages);
		AccountPane.add(addres);
		AccountPane.add(phoneno);
		AccountPane.add(amounts);
		AccountPane.add(edit);
		AccountPane.add(changepwd);
		AccountPane.add(lblNewLabel);

		
		AccountPane.repaint();
	}
	
	public void refresh() {
		repaint();
		contentPane.repaint();
	}
}
