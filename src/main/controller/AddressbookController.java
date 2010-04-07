package main.controller;

import main.model.AddressbookItem;
import main.model.AddressbookModel;


public class AddressbookController {
	
	private AddressbookModel model;
	
	public AddressbookController (AddressbookModel model) {
		this.model = model;
	}

	public void itemAdded(AddressbookItem item) {
		model.add(item);
		
	}

	public void itemDeleted(int id) {
		model.remove(id);
		
	}
	
}
