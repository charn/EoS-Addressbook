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
	
	public AddressbookItem() {
		this("","","","","");
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

	public AddressbookItem withFirstName(String firstname) {
		return new AddressbookItem(firstname,lastname,email,phonenumber,address);
	}
	
	public AddressbookItem withLastName(String lastname) {
		return new AddressbookItem(firstname,lastname,email,phonenumber,address);
	}
	
	public AddressbookItem withEmail(String email) {
		return new AddressbookItem(firstname,lastname,email,phonenumber,address);
	}
	
	public AddressbookItem withPhoneNumber(String phonenumber) {
		return new AddressbookItem(firstname,lastname,email,phonenumber,address);
	}
	
	public AddressbookItem withAddress(String address) {
		return new AddressbookItem(firstname,lastname,email,phonenumber,address);
	}
	
	/**
	 * @param maxId the maxId to set
	 * @deprecated
	 */
	public static void setMaxId(int maxId)
	{
		AddressbookItem.maxId = maxId;
	}

	/**
	 * @param id the id to set
	 * @deprecated
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @param firstname the firstname to set
	 * @deprecated
	 */
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	/**
	 * @param lastname the lastname to set
	 * @deprecated
	 */
	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	/**
	 * @param email the email to set
	 * @deprecated
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * @param phonenumber the phonenumber to set
	 * @deprecated
	 */
	public void setPhonenumber(String phonenumber)
	{
		this.phonenumber = phonenumber;
	}

	/**
	 * @param address the address to set
	 * @deprecated
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}
}
