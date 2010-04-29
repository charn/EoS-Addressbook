package test;

import main.model.AddressbookItem;

public class TestDummies {

	public static final AddressbookItem JORMA = new AddressbookItem("Jorma",
			"Meikäläinen", "Joppe", "masa@gmail.com", "050 123456",
			"Mannerheimintie 10 A 4", "työ");
	
	public static final AddressbookItem ESA = new AddressbookItem("Esa",
			"Meikäläinen", "Esku", "maija@gmail.com", "050 445533",
			"Mannerheimintie 10 A 4", "työ");
	
	public static final AddressbookItem PETTERI = new AddressbookItem("Petteri",
			"Virtanen", "Petsku", "pvirtanen@gmail.com", "040 234234", 
			"Kitarakuja 7 A 5", "sukulainen");
	
	public static final AddressbookItem SEPPO = new AddressbookItem("Seppo",
			"Taalasmaa", "Sepi", "seppo@talotaikurit.com", "040 91928384", 
			"Kitarakuja 7 A 5", "sukulainen, työ kaveri");
	
	public static final AddressbookItem ISMO = new AddressbookItem("Ismo",
			"Laitela", "", "ismo@talotaikurit.com", "040 91928384", 
			"Kitarakuja 7 A 5", "");
}
