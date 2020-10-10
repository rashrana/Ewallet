package mainpage;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.EtchedBorder;

import database.accountRelated;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class login extends JFrame {

	private accountRelated data;
	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passwordField;
	private JButton createNewAccount;
	private JPanel panel_1;
	private JTextField newuser;
	private JPasswordField newpwd;
	private JTextField newmtpn;
	private JTextField newname;
	private JTextField newage;
	private JTextField newaddress;
	private JTextField newphone;

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new login();
			}
		});
	}

	
	public login() {
		data=new accountRelated();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 676);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0 , 777, 676);
		setContentPane(contentPane);
		setVisible(true);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0,0 , 700, 600);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0 , 777, 676);
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, SystemColor.desktop, null));
		panel.setFont(new Font("Calibri", Font.PLAIN, 20));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel loginLabel = new JLabel("LOGIN");
		loginLabel.setBorder(new EtchedBorder(EtchedBorder.RAISED, SystemColor.activeCaption, null));
		loginLabel.setForeground(new Color(128, 0, 128));
		loginLabel.setFont(new Font("Calibri", Font.BOLD, 40));
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setBounds(10, 10, 710, 87);
		panel.add(loginLabel);
		
		userField = new JTextField();
		userField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(userField.getText().equals("USERNAME")) userField.setText("");
				
			}
			public void mouseExited(MouseEvent e) {
				if(userField.getText().equals("")) userField.setText("USERNAME");
				
			}
		});
	
	
		userField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(userField.getText().equals("")) {
					userField.setText("USERNAME");
					userField.setForeground(Color.LIGHT_GRAY);
				}
			}
			
		});
		userField.setText("USERNAME");
		userField.setForeground(Color.blue);
		userField.setHorizontalAlignment(SwingConstants.CENTER);
		userField.setFont(new Font("Calibri", Font.PLAIN, 20));
		userField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, null));
		userField.setBounds(121, 189, 490, 36);
		panel.add(userField);
		userField.setColumns(10);
		
	
		
		passwordField = new JPasswordField();
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(passwordField.getText().equals("PASSWORD")) passwordField.setText("");
				
			}
			public void mouseExited(MouseEvent e) {
				if(passwordField.getText().equals("")) passwordField.setText("PASSWORD");
				
			}
		});
	

		passwordField.setEchoChar('*');
		passwordField.setText("PASSWORD");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setForeground(Color.blue);
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 20));
		passwordField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, null));
		passwordField.setBounds(121, 292, 490, 36);
		panel.add(passwordField);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setForeground(SystemColor.desktop);
		loginBtn.setFont(new Font("Calibri", Font.PLAIN, 20));
		loginBtn.setBorder(new EtchedBorder(EtchedBorder.RAISED, SystemColor.inactiveCaption, null));
		loginBtn.setBounds(248, 386, 240, 36);
		panel.add(loginBtn);
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String usern=userField.getText();
				String pass=passwordField.getText();
				if(data.checkValidity(usern, pass)) {
					SwingUtilities.invokeLater(new Runnable() {

						@Override
						public void run() {
							new StartIUp(usern);
						}
						
					});
					
					setVisible(false);
				}
				else JOptionPane.showMessageDialog(login.this, "Username & Password Mismatch!");
			}
			
		});
		
		createNewAccount = new JButton("<HTML><U>Create new Account</U></HTML>");
		createNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel_1.setVisible(true);
				panel.setVisible(false);
				contentPane.add(panel_1);
				System.out.println("lod");
			}

		});
		createNewAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		createNewAccount.setForeground(new Color(25, 25, 112));
		createNewAccount.setHorizontalAlignment(SwingConstants.CENTER);
		createNewAccount.setFont(new Font("Calibri", Font.BOLD, 20));
		createNewAccount.setBounds(248, 479, 240, 36);
		panel.add(createNewAccount);
		
		
		
		JLabel createNewAccount_1 = new JLabel("New Account");
		createNewAccount_1.setHorizontalAlignment(SwingConstants.CENTER);
		createNewAccount_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(176, 196, 222), null));
		createNewAccount_1.setForeground(new Color(25, 25, 112));
		createNewAccount_1.setFont(new Font("Calibri", Font.BOLD, 35));
		createNewAccount_1.setBounds(10, 10, 733, 78);
		panel_1.add(createNewAccount_1);
		
		
		newuser = new JTextField();
		newuser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(newuser.getText().equals("USERNAME")) newuser.setText("");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(newuser.getText().equals("")) newuser.setText("USERNAME");
			}
		});
		newuser.setHorizontalAlignment(SwingConstants.CENTER);
		newuser.setForeground(new Color(25, 25, 112));
		newuser.setFont(new Font("Calibri", Font.PLAIN, 20));
		newuser.setText("USERNAME");
		newuser.setBounds(151, 152, 434, 37);
		panel_1.add(newuser);
		newuser.setColumns(10);
		
		newpwd = new JPasswordField();
		newpwd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(newpwd.getText().equals("PASSWORD")) newpwd.setText("");
			}
			public void mouseExited(MouseEvent e) {
				if(newpwd.getText().equals("")) newpwd.setText("PASSWORD");
			}
		});
		newpwd.setEchoChar('*');
		newpwd.setForeground(new Color(25, 25, 112));
		newpwd.setHorizontalAlignment(SwingConstants.CENTER);
		newpwd.setFont(new Font("Calibri", Font.PLAIN, 20));
		newpwd.setText("PASSWORD");
		newpwd.setBounds(151, 199, 434, 37);
		panel_1.add(newpwd);
		
		newmtpn = new JTextField();
		newmtpn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(newmtpn.getText().equals("4 DIGIT MTPN")) newmtpn.setText("");
			}
			public void mouseExited(MouseEvent e) {
				if(newmtpn.getText().equals("")) newmtpn.setText("4 DIGIT MTPN");
			}
		});
		newmtpn.setHorizontalAlignment(SwingConstants.CENTER);
		newmtpn.setForeground(new Color(25, 25, 112));
		newmtpn.setFont(new Font("Calibri", Font.PLAIN, 20));
		newmtpn.setText("4 DIGIT MTPN");
		newmtpn.setBounds(151, 246, 434, 37);
		panel_1.add(newmtpn);
		newmtpn.setColumns(10);
		
		newname = new JTextField();
		newname.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(newname.getText().equals("NAME")) newname.setText("");
			}
			public void mouseExited(MouseEvent e) {
				if(newname.getText().equals("")) newname.setText("NAME");
			}
		});
		newname.setHorizontalAlignment(SwingConstants.CENTER);
		newname.setForeground(new Color(25, 25, 112));
		newname.setFont(new Font("Calibri", Font.PLAIN, 20));
		newname.setText("NAME");
		newname.setBounds(151, 293, 434, 37);
		panel_1.add(newname);
		newname.setColumns(10);
		
		newage = new JTextField();
		newage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(newage.getText().equals("AGE")) newage.setText("");
			}
			public void mouseExited(MouseEvent e) {
				if(newage.getText().equals("")) newage.setText("AGE");
			}
		});
		newage.setHorizontalAlignment(SwingConstants.CENTER);
		newage.setForeground(new Color(25, 25, 112));
		newage.setFont(new Font("Calibri", Font.PLAIN, 20));
		newage.setText("AGE");
		newage.setBounds(151, 340, 434, 37);
		panel_1.add(newage);
		newage.setColumns(10);
		
		newaddress = new JTextField();
		newaddress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(newaddress.getText().equals("ADDRESS")) newaddress.setText("");
			}
			public void mouseExited(MouseEvent e) {
				if(newaddress.getText().equals("")) newaddress.setText("ADDRESS");
			}
		});
		newaddress.setHorizontalAlignment(SwingConstants.CENTER);
		newaddress.setForeground(new Color(25, 25, 112));
		newaddress.setFont(new Font("Calibri", Font.PLAIN, 20));
		newaddress.setText("ADDRESS");
		newaddress.setBounds(151, 387, 434, 37);
		panel_1.add(newaddress);
		newaddress.setColumns(10);
		
		newphone = new JTextField();
		newphone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(newphone.getText().equals("PHONE NUMBER")) newphone.setText("");
			}
			public void mouseExited(MouseEvent e) {
				if(newphone.getText().equals("")) newphone.setText("PHONE NUMBER");
			}
		});
		newphone.setHorizontalAlignment(SwingConstants.CENTER);
		newphone.setForeground(new Color(25, 25, 112));
		newphone.setFont(new Font("Calibri", Font.PLAIN, 20));
		newphone.setText("PHONE NUMBER");
		newphone.setBounds(151, 434, 427, 37);
		panel_1.add(newphone);
		newphone.setColumns(10);
		
		JButton btnNewButton = new JButton("SIGN UP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usern=newuser.getText();
				String pass=newpwd.getText();
				String mtpn=newmtpn.getText();
				String name=newname.getText();
				String age=newage.getText();
				String add=newaddress.getText();
				String phone=newphone.getText();
				if(usern.equals("") || pass.equals("") || mtpn.equals("") || name.equals("") || age.equals("") || add.equals("") || phone.equals(""))
					JOptionPane.showMessageDialog(login.this, "Please fill all the fields!");
				else if(mtpn.length()!=4 || age.length()>3 || phone.length()!=10){
					
					JOptionPane.showMessageDialog(login.this, "MTPN should be 4 digit long! \n&\n Age should be valid!\n&\n Phone number should be 10 digits long!");
				}
				else {
					int i=0,j=0,k=0;
					for(int l=0;l<4;l++) {
						if(!Character.isDigit(mtpn.charAt(l))) {
							i=1;
							break;
						}
					}
					for(int l=0;l<age.length();l++) {
						
						if(!Character.isDigit(age.charAt(l))) {
							j=1;
							break;
						}
					}
					for(int l=0;l<phone.length();l++) {
						if(!Character.isDigit(phone.charAt(l))) {
							k=1;
							break;
						}
					}
					boolean check=data.isUsernameEmpty(usern);
					if(i==1 || j==1 || k==1 || Integer.parseInt(age)>120) {
						JOptionPane.showMessageDialog(login.this, "Please enter valid MTPN, AGE and PHONE NUMBER");
					}
					else if(check) {
						String c=data.addAccount(usern,pass,Integer.parseInt(mtpn),name,Integer.parseInt(age),add,phone);
						JOptionPane.showMessageDialog(login.this, c);
						panel_1.setVisible(false);
						panel.setVisible(true);
						//contentPane.add(panel);
					}
					else {
						JOptionPane.showMessageDialog(login.this, "This Username is already Occupied.\n Please Choose another Username!");
					}
				}
			}
		});
		btnNewButton.setForeground(new Color(25, 25, 112));
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnNewButton.setBounds(255, 500, 234, 37);
		panel_1.add(btnNewButton);
		//contentPane.add(panel_1);
		//panel_1.setVisible(true);
		
	
		
	}	
}
