package mainpage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import database.accountRelated;

import javax.swing.JPasswordField;

public class editProfile extends JFrame {
	private JPanel mtpnPanel;
	private JPanel pwdPanel;
	private JPanel detailsPanel;
	private JPanel contentPane;
	private JTextField txtNewName;
	private JTextField txtNewAge;
	private JTextField txtNewAddress;
	private JTextField txtNewPhoneNumber;
	private JTextField txtNewPassword;
	private JTextField txtConfirmPassword;
	private JTextField txtOldPassword;
	private JTextField txtPassword;
	private JTextField txtNewMtpn;
	private int operation;
	private String username;
	private accountRelated data;
	
	public editProfile(String username,int operation,StartIUp parent) {
		this.username=username;
		this.operation=operation;
		this.setVisible(true);
		setBounds(100, 100, 681, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setVisible(true);
		data=new accountRelated();
		
		
		mtpnPanel = new JPanel();
		mtpnPanel.setLayout(null);
		
		txtPassword = new JTextField();
		txtPassword.setText("Password");
		txtPassword.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setForeground(Color.LIGHT_GRAY);
		txtPassword.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtPassword.setBounds(138, 190, 363, 40);
		mtpnPanel.add(txtPassword);
		txtPassword.setColumns(10);
		
		txtNewMtpn = new JTextField();
		txtNewMtpn.setForeground(Color.LIGHT_GRAY);
		txtNewMtpn.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewMtpn.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtNewMtpn.setText("New MTPN");
		txtNewMtpn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
		txtNewMtpn.setBounds(138, 264, 363, 40);
		mtpnPanel.add(txtNewMtpn);
		txtNewMtpn.setColumns(10);
		
		JButton btnNewButton = new JButton("Click Me");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GRAY, null));
		btnNewButton.setBounds(195, 373, 239, 40);
		mtpnPanel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String password=data.getPassword(username);
				String confirm=txtPassword.getText();
				String mtpn=txtNewMtpn.getText();
				if(!mtpn.equals("") || !mtpn.equals("New MTPN")) {
					if(password.equals(confirm)) {
						String msg= data.updateMTPN(username, mtpn);
						JOptionPane.showMessageDialog(btnNewButton, "MTPN Successfully changed!", "Successful!", JOptionPane.PLAIN_MESSAGE);
						setVisible(false);
					}
				}
				else JOptionPane.showMessageDialog(btnNewButton, "Enter new MTPN");
			}
			
		});
		
		JLabel lblNewLabel = new JLabel("Change MTPN");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		lblNewLabel.setBounds(10, 10, 637, 70);
		mtpnPanel.add(lblNewLabel);
		
		
		//IMPLEMENTING PASSWORD PANEL
		
		pwdPanel = new JPanel();
		pwdPanel.setLayout(null);
		
		txtNewPassword = new JTextField();
		txtNewPassword.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
		txtNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewPassword.setForeground(Color.LIGHT_GRAY);
		txtNewPassword.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtNewPassword.setText("New Password");
		txtNewPassword.setBounds(124, 210, 385, 40);
		pwdPanel.add(txtNewPassword);
		txtNewPassword.setColumns(10);
		
		JButton pwdbtn = new JButton("Click Me");
		pwdbtn.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GRAY, null));
		pwdbtn.setForeground(Color.BLACK);
		pwdbtn.setFont(new Font("Calibri", Font.PLAIN, 20));
		pwdbtn.setBounds(175, 357, 275, 40);
		pwdPanel.add(pwdbtn);
		
		pwdbtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String password= data.getPassword(username);
				String oldpwd= txtOldPassword.getText();
				String newpwd= txtNewPassword.getText();
				String confirm= txtConfirmPassword.getText();
				if(password.equals(oldpwd)) {
					if(newpwd.equals(confirm)){
						String msg=data.updatePassword(username, newpwd);
						JOptionPane.showMessageDialog(pwdbtn, msg, "Successful!", JOptionPane.PLAIN_MESSAGE);
						setVisible(false);
					}
					else JOptionPane.showMessageDialog(pwdbtn, "New Password Mismatch!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				else JOptionPane.showMessageDialog(pwdbtn, "Wrong Password!", "Error!", JOptionPane.ERROR_MESSAGE);
			}
			
		});
		
		JLabel pwdheader = new JLabel("Change Password");
		pwdheader.setForeground(Color.BLUE);
		pwdheader.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		pwdheader.setFont(new Font("Calibri", Font.BOLD, 30));
		pwdheader.setHorizontalAlignment(SwingConstants.CENTER);
		pwdheader.setBounds(10, 10, 637, 63);
		pwdPanel.add(pwdheader);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
		txtConfirmPassword.setForeground(Color.LIGHT_GRAY);
		txtConfirmPassword.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtConfirmPassword.setText("Confirm Password");
		txtConfirmPassword.setBounds(124, 272, 385, 40);
		pwdPanel.add(txtConfirmPassword);
		txtConfirmPassword.setColumns(10);
		
		txtOldPassword = new JTextField();
		txtOldPassword.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
		txtOldPassword.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtOldPassword.setForeground(Color.LIGHT_GRAY);
		txtOldPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtOldPassword.setText("Old Password");
		txtOldPassword.setBounds(124, 145, 385, 40);
		pwdPanel.add(txtOldPassword);
		txtOldPassword.setColumns(10);
		
		
		
		//IMPLEMENTING DETAILS LAYOUT
		detailsPanel = new JPanel();
		detailsPanel.setFont(new Font("Calibri", Font.PLAIN, 20));
		detailsPanel.setLayout(null);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(137, 136, 1, 1);
		detailsPanel.add(layeredPane);
		

		
		txtNewName = new JTextField();
		txtNewName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
		txtNewName.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewName.setForeground(Color.LIGHT_GRAY);
		txtNewName.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtNewName.setText("New Name");
		txtNewName.setBounds(133, 117, 386, 39);
		detailsPanel.add(txtNewName);
		txtNewName.setColumns(10);
		
		txtNewAge = new JTextField();
		txtNewAge.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
		txtNewAge.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewAge.setForeground(Color.LIGHT_GRAY);
		txtNewAge.setText("New Age");
		txtNewAge.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtNewAge.setBounds(133, 166, 386, 39);
		detailsPanel.add(txtNewAge);
		txtNewAge.setColumns(10);
		
		txtNewAddress = new JTextField();
		txtNewAddress.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		txtNewAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewAddress.setForeground(Color.LIGHT_GRAY);
		txtNewAddress.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtNewAddress.setText("New Address");
		txtNewAddress.setBounds(137, 221, 382, 39);
		detailsPanel.add(txtNewAddress);
		txtNewAddress.setColumns(10);
		
		txtNewPhoneNumber = new JTextField();
		txtNewPhoneNumber.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
		txtNewPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewPhoneNumber.setText("New Phone Number");
		txtNewPhoneNumber.setForeground(Color.LIGHT_GRAY);
		txtNewPhoneNumber.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtNewPhoneNumber.setBounds(137, 277, 382, 39);
		detailsPanel.add(txtNewPhoneNumber);
		txtNewPhoneNumber.setColumns(10);
		
		JButton detailclick = new JButton("Click Me");
		detailclick.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GRAY, null));
		detailclick.setForeground(Color.BLACK);
		detailclick.setFont(new Font("Calibri", Font.PLAIN, 25));
		detailclick.setBounds(223, 374, 225, 39);
		detailsPanel.add(detailclick);
		
		detailclick.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name=txtNewName.getText();
				String age=txtNewAge.getText();
				String address=txtNewAddress.getText();
				String phone=txtNewPhoneNumber.getText();
				int j=0;
				for(int i=0;i<phone.length();i++) {
					if(!Character.isDigit(phone.charAt(i))) {
						j=1;
						break;
					}
				}
				if(name.equals("") || age.equals("") || address.equals("") || phone.equals("")){
					JOptionPane.showMessageDialog(detailclick, "Please Complete all the details!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				else if(phone.length()!=10 || j==1){
					JOptionPane.showMessageDialog(detailclick, "Please enter a valid Phone number!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				else{
					String msg= data.updateDetails(username, name, Integer.parseInt(age), address, phone);
					JOptionPane.showMessageDialog(detailclick,msg, "Message!", JOptionPane.PLAIN_MESSAGE);
					setVisible(false);
					parent.detailrefresh();
				}
			}
			
		});
		
		JLabel detailheader = new JLabel("Edit Username Details");
		detailheader.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		detailheader.setForeground(Color.BLUE);
		detailheader.setFont(new Font("Calibri", Font.BOLD, 30));
		detailheader.setHorizontalAlignment(SwingConstants.CENTER);
		detailheader.setBounds(0, 10, 647, 55);
		detailsPanel.add(detailheader);
		
		addingPanel(operation);
	}
	void addingPanel(int i) {
		if(i==0) contentPane.add(detailsPanel, BorderLayout.CENTER);
		else if (i==1) contentPane.add(pwdPanel, BorderLayout.CENTER);
		else if (i==2) contentPane.add(mtpnPanel, BorderLayout.CENTER);
	}
}
