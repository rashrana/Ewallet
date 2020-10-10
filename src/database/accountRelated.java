package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class accountRelated {
	private String url="jdbc:mysql://localhost:3325/ewallet";
	private String user="root";
	private String pass="";
	
	private String username;
	private String password;
	private int mtpn;
	private String name;
	private int age;
	private String address;
	private String phone;
	private String amount;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement s;
	private Connection con;
	
	public void checkDefaultCard(String cardnum,String u) {
		this.username=u;
		try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 Connection con=DriverManager.getConnection(url,user,pass);
			 PreparedStatement st=con.prepareStatement("update `account` set `defaultcard`=null where `Username`=? and defaultcard=?");
			 st.setString(1,username);
			 st.setString(2,cardnum);
			 st.executeUpdate();
			 st.close();
			 con.close();
			 
			  }
		 catch(Exception e){
			 e.getMessage(); 
		 }	
	} 
	
	public String updateDefaultCard(String cardnum,String u) {
		this.username=u;
		try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 Connection con=DriverManager.getConnection(url,user,pass);
			 PreparedStatement st=con.prepareStatement("update `account` set `defaultcard`=? where `Username`=?");
			 st.setString(1,cardnum);
			 st.setString(2,username);
			 int i=st.executeUpdate();
			 st.close();
			 con.close();
			 if (i==1) return "Default Card Selected as"+cardnum;
			 else return "Default Card not Set!";
			  }
		 catch(Exception e){
			return e.getMessage(); 
		 }	
	} 
	
	public String addAccount (String u,String p,int m,String n,int age,String add,String phn)  {
		 username=u;
		 password=p;
		 mtpn=m;
		 name=n;
		 this.age=age;
		 address=add;
		 phone=phn;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 Connection con=DriverManager.getConnection(url,user,pass);
			 PreparedStatement st=con.prepareStatement("insert into account(Username,Password,Mtpn,Name,Age,Address,Phone) values(?,?,?,?,?,?,?)");
			 st.setString(1,username);
			 st.setString(2, password);
			 st.setInt(3, mtpn);
			 st.setString(4, name);
			 st.setInt(5,this.age);
			 st.setString(6,address);
			 st.setString(7,phone);
			 int i=st.executeUpdate();
			 st.close();
			 con.close();
			  return "Account Added Successfully!";
			  }
		 catch(Exception e){
			return e.getMessage(); 
		 }	
	 } 
	public String addDetails (String u,String n,int age,String add,String phn)
	{
		 username=u;
		 name=n;
		 this.age=age;
		 address=add;
		 phone=phn;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 Connection con=DriverManager.getConnection(url,user,pass);
			 PreparedStatement st=con.prepareStatement("update `account` set `Name`=?, `Age`=?, `Address`=?, `Phone`=? where `Username`=?");
			 st.setString(1,name);
			 st.setInt(2,this.age);
			 st.setString(3,address);
			 st.setString(4,phone);
			 st.setString(5,username);
			 int i=st.executeUpdate();
			 st.close();
			 con.close();
			 if (i==1) return "Account Details Successfully Updated!";
			 else return "Account not Found!";
			  }
		 catch(Exception e){
			return e.getMessage(); 
		 }	
	 }
	public String updateDetails (String u,String n,int age,String add,String phn)  {
		 username=u;
		 name=n;
		 this.age=age;
		 address=add;
		 phone=phn;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 Connection con=DriverManager.getConnection(url,user,pass);
			 PreparedStatement st=con.prepareStatement("update `account` set `Name`=?, `Age`=?, `Address`=?, `Phone`=? where `Username`=?");
			 st.setString(1,name);
			 st.setInt(2,this.age);
			 st.setString(3,address);
			 st.setString(4,phone);
			 st.setString(5,username);
			 int i=st.executeUpdate();
			 st.close();
			 con.close();
			 if (i==1) return "Account Details Successfully Updated!";
			 else return "Account not Found!";
			  }
		 catch(Exception e){
			return e.getMessage(); 
		 }	
	 }
	public String updatePassword (String u,String p)  {
		 username=u;
		 password=p;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 Connection con=DriverManager.getConnection(url,user,pass);
			 PreparedStatement st=con.prepareStatement("update `account` set `Password`=? where `Username`=?");
			 st.setString(1,password);
			 st.setString(2,username);
			 int i=st.executeUpdate();
			 st.close();
			 con.close();
			 if (i==1) return "Password Successfully Changed!";
			 else return "Account not Found!";
			  }
		 catch(Exception e){
			return e.getMessage(); 
		 }	
	 }
	public String updateMTPN (String u,String m)  {
		 username=u;
		 mtpn=Integer.parseInt(m);
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 Connection con=DriverManager.getConnection(url,user,pass);
			 PreparedStatement st=con.prepareStatement("update `account` set `MTPN`=? where `Username`=?");
			 st.setInt(1,mtpn);
			 st.setString(2,username);
			 int i=st.executeUpdate();
			 st.close();
			 con.close();
			 if (i==1) return "Password Successfully Changed!";
			 else return "Account not Found!";
			  }
		 catch(Exception e){
			return e.getMessage(); 
		 }	
	 }
	public String getPassword (String u)  {
		 username=u;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				System.out.println( e.getMessage());
			 }
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3325/ewallet","root","");
			 s=con.prepareStatement("Select password from account where `Username`=?");
			 s.setString(1, username);
			 rs=s.executeQuery();
			 rs.next();
			 return rs.getString(1);
			 
		 }
		 catch(Exception e){
			e.printStackTrace();
			return "Account not found!";
		 }
		 finally {
			 try {
				 s.close();
				 con.close();
			 }
			 catch(Exception e) {
				 
			 }
		 }
	 }
	public int getMtpn (String u)  {
		 username=u;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				System.out.println( e.getMessage());
			 }
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3325/ewallet","root","");
			 s=con.prepareStatement("Select mtpn from account where `Username`=?");
			 s.setString(1, username);
			 rs=s.executeQuery();
			 rs.next();
			 return rs.getInt(1); 
			 
			 
		 }
		 catch(Exception e){
			e.printStackTrace();
			return 0;
		 }
		 finally {
			 try {
				 s.close();
				 con.close();
			 }
			 catch(Exception e) {
				 
			 }
		 }
	 }
	public String getName (String u)  {
		 username=u;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				System.out.println( e.getMessage());
			 }
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3325/ewallet","root","");
			 s=con.prepareStatement("Select name from account where `Username`=?");
			 s.setString(1, username);
			 rs=s.executeQuery();
			 rs.next();
			 return rs.getString(1);
			 		 
			 
		 }
		 catch(Exception e){
			e.printStackTrace();
			return "Account not found!";
		 }
		 finally {
			 try {
				 s.close();
				 con.close();
			 }
			 catch(Exception e) {
				 
			 }
		 }
	 }
	public String getAge (String u)  {
		 username=u;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				System.out.println( e.getMessage());
			 }
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3325/ewallet","root","");
			 s=con.prepareStatement("Select age from account where `Username`=?");
			 s.setString(1, username);
			 rs=s.executeQuery();
			 rs.next();
			 return rs.getString(1);
			 	 
			 
		 }
		 catch(Exception e){
			e.printStackTrace();
			return "Account not found!";
		 }
		 finally {
			 try {
				 s.close();
				 con.close();
			 }
			 catch(Exception e) {
				 
			 }
		 }
	 }
	public String getAddress (String u)  {
		 username=u;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				System.out.println( e.getMessage());
			 }
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3325/ewallet","root","");
			 s=con.prepareStatement("Select address from account where `Username`=?");
			 s.setString(1, username);
			 rs=s.executeQuery();
			 rs.next();
			 return rs.getString(1);
			 
			 
			 
		 }
		 catch(Exception e){
			e.printStackTrace();
			return "Account not found!";
		 }
		 finally {
			 try {
				 s.close();
				 con.close();
			 }
			 catch(Exception e) {
				 
			 }
		 }
	 }
	public String getPhone (String u)  {
		 username=u;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				System.out.println( e.getMessage());
			 }
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3325/ewallet","root","");
			 s=con.prepareStatement("Select phone from account where `Username`=?");
			 s.setString(1, username);
			 rs=s.executeQuery();
			 rs.next();
			 return rs.getString(1);
		 }
		 catch(Exception e){
			e.printStackTrace();
			return "Account not found!";
		 }
		 finally {
			 try {
				 s.close();
				 con.close();
			 }
			 catch(Exception e) {
				 
			 }
		 }
	 }
	public String getDefaultCard (String u)  {
		 username=u;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				System.out.println( e.getMessage());
			 }
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3325/ewallet","root","");
			 s=con.prepareStatement("Select defaultcard from account where `Username`=?");
			 s.setString(1, username);
			 rs=s.executeQuery();
			 rs.next();
			 return rs.getString(1);	 
			 
		 }
		 catch(Exception e){
			e.printStackTrace();
			return "E-wallet!";
		 }
		 finally {
			 try {
				 s.close();
				 con.close();
			 }
			 catch(Exception e) {
				 
			 }
		 }
	 }
	public String getAmount (String u)  {
		 username=u;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				System.out.println( e.getMessage());
			 }
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3325/ewallet","root","");
			 s=con.prepareStatement("Select * from account where `Username`=?");
			 s.setString(1, username);
			 rs=s.executeQuery();
			 rs.next();
			 if(rs.getString(1).equals(username)) return rs.getString(8);
			 
			 
			 return "Account not found!";
		 }
		 catch(Exception e){
			e.printStackTrace();
			return e.getMessage(); 
		 }
		 finally {
			 try {
				 s.close();
				 con.close();
			 }
			 catch(Exception e) {
				 
			 }
		 }
	 }
	
	public boolean checkUsername (String u)  {
		 username=u;
		 boolean check=false;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 Connection con=DriverManager.getConnection(url,user,pass);
			 Statement st=con.createStatement();
			 rs=st.executeQuery("Select Username from account");
			 while(rs.next()) {
				 if(rs.getString(1).equals(username)) {
					 check=true;
					 break;
				 }
				 
			 }
			 st.close();
			 con.close();
		 }
		 catch(Exception e){
			 e.getMessage(); 
		 }	
		 finally {
			 return check;
		 }
	 }
	public boolean isUsernameEmpty (String u)  {
		 username=u;
		 boolean check=true;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 Connection con=DriverManager.getConnection(url,user,pass);
			 Statement st=con.createStatement();
			 rs=st.executeQuery("Select Username from account");
			 while(rs.next()) {
				 if(rs.getString(1).equals(username)) {
					 check=false;
					 break;
				 }
				 
			 }
			 st.close();
			 con.close();
		 }
		 catch(Exception e){
			 e.getMessage(); 
		 }	
		 finally {
			 return check;
		 }
	 }
	public boolean checkValidity (String u,String p)  {
		 username=u;
		 password=p;
		 boolean check=false;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 Connection con=DriverManager.getConnection(url,user,pass);
			 Statement st=con.createStatement();
			 rs=st.executeQuery("Select Username,Password from account");
			 while(rs.next()) {
				 if(rs.getString(1).equals(username) & rs.getString(2).equals(password)) {
					 check=true;
					 break;
				 }
				
			 }
			 st.close();
			 con.close();
		 }
		 catch(Exception e){
			 e.getMessage(); 
		 }	
		 finally {
			 return check;
		 }
	 }
	public void updateAmount (String u,double x,int operation)  {
		 username=u;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				System.out.println( e.getMessage());
			 }
			 
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3325/ewallet","root","");
			 if(operation==0) s=con.prepareStatement("update account set amount=amount+? where `Username`=?");
			 else s=con.prepareStatement("update account set amount=amount-? where `Username`=?");
			 s.setDouble(1,x);
			 s.setString(2, username);
			 s.executeUpdate();
			 
		 }
		 catch(Exception e){
			e.printStackTrace();
			
		 }
		 finally {
			 try {
				 s.close();
				 con.close();
			 }
			 catch(Exception e) {
				 
			 }
		 }
	 }
	
	
}
