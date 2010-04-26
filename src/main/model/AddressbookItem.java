package main.model;

import java.io.Serializable;

public class AddressbookItem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String firstname;
	private String lastname;
	private String nickname;
	private String email;
	private String phonenumber;
	private String address;
	private String tags;
	
	public AddressbookItem(	 
							String firstname, 
							String lastname,
							String nickname,
							String email,
							String phonenumber,
							String address,
							String tags){

		this.firstname = firstname;
		this.lastname = lastname;
		this.nickname = nickname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
		this.tags = tags;
	}
	
	public AddressbookItem() {
		this("","","","","","","");
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
	
	public String getTags(){
		return this.tags;
	}

	public AddressbookItem withFirstName(String firstname) {
		return new AddressbookItem(firstname,lastname, nickname,email,phonenumber,address,tags);
	}
	
	public AddressbookItem withLastName(String lastname) {
		return new AddressbookItem(firstname,lastname, nickname ,email,phonenumber,address,tags);
	}
	
	public AddressbookItem withNickname(String nickname) {
		return new AddressbookItem(firstname,lastname, nickname ,email,phonenumber,address,tags);
	}
	
	public AddressbookItem withEmail(String email) {
		return new AddressbookItem(firstname,lastname, nickname, email,phonenumber,address,tags);
	}
	
	public AddressbookItem withPhoneNumber(String phonenumber) {
		return new AddressbookItem(firstname,lastname, nickname ,email,phonenumber,address,tags);
	}
	
	public AddressbookItem withAddress(String address) {
		return new AddressbookItem(firstname,lastname, nickname ,email,phonenumber,address,tags);
	}
	
	public AddressbookItem withTags(String tags) {
		return new AddressbookItem(firstname,lastname, nickname ,email,phonenumber,address,tags);
	}
	
	public String toString(){
		return firstname + ", " + lastname + ", " + nickname + ", " + email + ", " + 
		phonenumber + ", " + address + ", " + tags;
	}
	
}
