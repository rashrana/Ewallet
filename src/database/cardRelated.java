package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class cardRelated {
	private String url="jdbc:mysql://localhost:3325/ewallet";
	private String user="root";
	private String pass="";
	private ResultSet rs;
	private Connection con;
	private PreparedStatement st;
	
	private String cardnumber;
	private String holdername;
	private String validity;
	private int cvv;
	private double amount;
	private String username;
	
	public String addCard (String acc,String na,String v,int cv,double am,String u)  {
		 username=u;
		 cardnumber=acc;
		 holdername=na;
		 validity=v;
		 cvv=cv;
		 amount=am;
		 
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 Connection con=DriverManager.getConnection(url,user,"");
			 PreparedStatement st=con.prepareStatement("insert into cards values(?,?,?,?,?,?)");
			 st.setString(1,cardnumber);
			 st.setString(2, holdername);
			 st.setString(3, validity);
			 st.setInt(4, cvv);
			 st.setDouble(5,amount);
			 st.setString(6,username);
			 int i=st.executeUpdate();
			 st.close();
			 con.close();
			  return "Card Added Successfully!";
			  }
		 catch(Exception e){
			e.printStackTrace();
			return e.getMessage(); 
		 }	
	 } 
	
	public int getCardsNumber (String u)  {
		 username=u;
		 int i=0;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 Connection con=DriverManager.getConnection(url,user,pass);
			 PreparedStatement st=con.prepareStatement("Select count(*) from cards where username=?");
			 st.setString(1,username);
			 rs=st.executeQuery();
			 rs.next();
			 i=rs.getInt(1);
			 st.close();
			 con.close();
		 }
		 catch(Exception e){
			 e.getMessage(); 
		 }	
		 finally {
			return i;
		 }
	 }
	public String[] getCard (String u,int n)  {
		 username=u;
		 String card[]=new String[n];
		 int i=0;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 con=DriverManager.getConnection(url,user,pass);
			 st=con.prepareStatement("Select cardnumber from cards where username=?");
			 st.setString(1,username);
			 rs=st.executeQuery();
			 while(rs.next()) {
				 card[i++]=rs.getString(1);
			 }
			 return card;
		 }
		 catch(Exception e){
			 e.getMessage(); 
			 return card;
		 }	
		 finally {
			 try {
			
			 st.close();
			 con.close();
			 }
			 catch(Exception e) {
				 
			 }
		 }
	 }
	public String[] getHoldername (String u,int n)  {
		 username=u;
		 int i=0;
		 String holder[]=new String[n];
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 con=DriverManager.getConnection(url,user,pass);
			 st=con.prepareStatement("Select holdername from cards where username=?");
			 st.setString(1,username);
			 rs=st.executeQuery();
			 while(rs.next()) {
				 holder[i++]=rs.getString(1);
			 }
			 return holder;
		 }
		 catch(Exception e){
			 e.getMessage();
			 return holder;
		 }	
		 finally {
			 try {
			 st.close();
			 con.close();
			 }
			 catch(Exception e) {
				 
			 }
		 }
	 }
	public double getTotalAmount (String u)  {
		 username=u;
		 double i=0;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 con=DriverManager.getConnection(url,user,pass);
			 st=con.prepareStatement("Select amount from cards where username=?");
			 st.setString(1,username);
			 rs=st.executeQuery();
			 while(rs.next()) {
				 i+=Integer.parseInt(rs.getString(1));
			 }
			 return i;
		 }
		 catch(Exception e){
			 e.getMessage(); 
			 return i;
		 }	
		 finally {
			 try {
			
			 st.close();
			 con.close();
			 }
			 catch(Exception e) {
				 
			 }
		 }
	 }
	
	public double getCardAmount (String u,String cnum)  {
		 username=u;
		 double i=0;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 con=DriverManager.getConnection(url,user,pass);
			 st=con.prepareStatement("Select amount from cards where username=? and cardnumber=?");
			 st.setString(1,username);
			 st.setString(2, cnum);
			 rs=st.executeQuery();
			 rs.next();
			 i=rs.getDouble(1);
			 return i;
		 }
		 catch(Exception e){
			 e.getMessage(); 
			 return i;
		 }	
		 finally {
			 try {
			
			 st.close();
			 con.close();
			 }
			 catch(Exception e) {
				 
			 }
		 }
	 }
	public void updateCardAmount (String u,String cnum,int am,int operation)  {
		 username=u;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 con=DriverManager.getConnection(url,user,pass);
			 if(operation==1) st=con.prepareStatement("update cards set amount=amount-? where username=? and cardnumber=?");
			 else st=con.prepareStatement("update cards set amount=amount+? where username=? and cardnumber=?");
			 st.setInt(1,am);
			 st.setString(2,username);
			 st.setString(3, cnum);
			 st.executeUpdate();
		 }
		 catch(Exception e){
			 e.getMessage(); 
		 }	
		 finally {
			 try {
			
			 st.close();
			 con.close();
			 }
			 catch(Exception e) {
				 
			 }
		 }
	 }
	
	public String checkSendingCard(String u,int a) {
		this.username=u;
		this.amount=a;
		try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 con=DriverManager.getConnection(url,user,pass);
			 st=con.prepareStatement("select cardnumber from cards where amount=(select min(amount) from cards where username=? and amount>?);");
			 st.setString(1,username);
			 st.setDouble(2,amount);
			 rs=st.executeQuery();
			 rs.next();
			 String card=rs.getString(1);
			 st.close();
			 con.close();
			 return card;
		 }
		 catch(Exception e){
			 return e.getMessage(); 
		 }	
		 
	}
	
	public int deleteCard (String u,String cardnum)  {
		 username=u;
		 cardnumber=cardnum;
		 int i=0;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 Connection con=DriverManager.getConnection(url,user,pass);
			 PreparedStatement st=con.prepareStatement("delete from cards where username=? and cardnumber=?");
			 st.setString(1,username);
			 st.setString(2,cardnumber);
			 i=st.executeUpdate();
			 
			 st.close();
			 con.close();
		 }
		 catch(Exception e){
			 e.getMessage(); 
		 }	
		 finally {
			return i;
		 }
	 }
}
