package main.model;

public class AddressbookItem {

	private static int maxId = 0;
	
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String phonenumber;
	private String address;
	
	public AddressbookItem(	 
							String firstname, 
							String lastname, 
							String email,
							String phonenumber,
							String address){
		maxId++;
		this.id = maxId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getFirstName(){
		return this.firstname;
	}
	
	public String getLastName(){
		return this.lastname;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getPhoneNumber(){
		return this.phonenumber;
	}
	
	public String getAddress(){
		return this.address;
	}
}
