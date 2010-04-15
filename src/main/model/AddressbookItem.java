package main.model;

public class AddressbookItem {

	private String firstname;
	private String lastname;
	private String nickname;
	private String email;
	private String phonenumber;
	private String address;
	
	public AddressbookItem(	 
							String firstname, 
							String lastname,
							String nickname,
							String email,
							String phonenumber,
							String address){

		this.firstname = firstname;
		this.lastname = lastname;
		this.nickname = nickname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
	}
	
	public AddressbookItem() {
		this("","","","","","");
	}
	
	public String getFirstName(){
		return this.firstname;
	}
	
	public String getLastName(){
		return this.lastname;
	}
	
	public String getNickname(){
		return this.nickname;
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

	public AddressbookItem withFirstName(String firstname) {
		return new AddressbookItem(firstname,lastname, nickname,email,phonenumber,address);
	}
	
	public AddressbookItem withLastName(String lastname) {
		return new AddressbookItem(firstname,lastname, nickname ,email,phonenumber,address);
	}
	
	public AddressbookItem withNickname(String nickname) {
		return new AddressbookItem(firstname,lastname, nickname ,email,phonenumber,address);
	}
	
	public AddressbookItem withEmail(String email) {
		return new AddressbookItem(firstname,lastname, nickname, email,phonenumber,address);
	}
	
	public AddressbookItem withPhoneNumber(String phonenumber) {
		return new AddressbookItem(firstname,lastname, nickname ,email,phonenumber,address);
	}
	
	public AddressbookItem withAddress(String address) {
		return new AddressbookItem(firstname,lastname, nickname ,email,phonenumber,address);
	}
	
}
