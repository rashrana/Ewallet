package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class transactionRelated {
	private String url="jdbc:mysql://localhost:3325/ewallet";
	private String user="root";
	private String pass="";
	private ResultSet rs;
	private Connection con;
	private PreparedStatement st;
	
	private String detail;
	private String type;
	private Double amount;
	private String username;
	private String cardnumber;
	private String nextaccount;
	
	public String addTransaction (String detail,String next,String type,int amount,String cardnumber,String username)  {
		 this.username=username;
		 this.cardnumber=cardnumber;
		 this.type=type;
		 this.amount=(double)amount;
		 this.detail=detail;
		 this.nextaccount=next;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 Connection con=DriverManager.getConnection(url,user,"");
			 PreparedStatement st=con.prepareStatement("insert into transactions values(?,?,?,?,?,?)");
			 st.setString(1,this.detail);
			 st.setString(2, this.type);
			 st.setString(3, this.nextaccount);
			 st.setDouble(4, this.amount);
			 st.setString(5, this.cardnumber);
			 st.setString(6,this.username);
			 int i=st.executeUpdate();
			 st.close();
			 con.close();
			  return "Transaction Added Successfully!";
			  }
		 catch(Exception e){
			e.printStackTrace();
			return e.getMessage(); 
		 }	
	 } 
	
	public String[] getTransaction(String u)  {
		 username=u;
		 String trans[];
		 int i=0;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 con=DriverManager.getConnection(url,user,pass);
			 st=con.prepareStatement("Select count(*) from transactions where username=?");
			 st.setString(1,username);
			 rs=st.executeQuery();
			 
			 rs.next();
			 i=rs.getInt(1);
			 trans=new String[i];
			 
			 i=0;
			 st=con.prepareStatement("Select * from transactions where username=?");
			 st.setString(1,username);
			 rs=st.executeQuery();
			 while(rs.next()) {
				 trans[i++]=rs.getString(1)+"\t"+rs.getString(3)+"\t"+rs.getString(5)+"\t"+rs.getString(2)+"\t"+rs.getDouble(4)+"\n";
			 }
			 return trans;
		 }
		 catch(Exception e){
			 e.getMessage();
			 trans=new String[0];
			 return trans;
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
	public String[] getIncomingTransaction(String u,int operation)  {
		 username=u;
		 String trans[];
		 int i=0;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 con=DriverManager.getConnection(url,user,pass);
			 st=con.prepareStatement("Select count(*) from transactions where username=?");
			 st.setString(1,username);
			 rs=st.executeQuery();
			 
			 rs.next();
			 i=rs.getInt(1);
			 trans=new String[i];
			 
			 i=0;
			 if(operation==0 ) st=con.prepareStatement("Select * from transactions where username=? and type='Received'");
			 else st=con.prepareStatement("Select * from transactions where username=? and type='Payment'");
			 st.setString(1,username);
			 rs=st.executeQuery();
			 while(rs.next()) {
				 trans[i++]=rs.getString(1)+"\t"+rs.getString(3)+"\t"+rs.getString(5)+"\t"+rs.getString(4)+"\n";
			 }
			 return trans;
		 }
		 catch(Exception e){
			 e.getMessage();
			 trans=new String[0];
			 return trans;
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
	
}
