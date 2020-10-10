package mainpage;

import java.awt.Graphics;

public class Cards {
	private String accountnumber;
	private String name;
	private String validity;
	private int cvv;
	private double amount;
	private String username;
	public Cards(String accountnum,String name,String validity,int cv,double amount,String username) {
		this.accountnumber=accountnum;
		this.name=name;
		this.validity=validity;
		this.cvv=cv;
		this.amount=amount;
		this.username=username;
	}
	public void surplus(Graphics g) {
		
	}
	
}
