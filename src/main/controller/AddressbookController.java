package main.controller;

import main.view.AddressbookView;
import main.model.AddressbookItem;
import main.model.AddressbookModel;


public class AddressbookController {
	
	private AddressbookModel model;
	private AddressbookView view;
	
	public AddressbookController (AddressbookModel model) {
		this.model = model;
	}

	public void addItem(AddressbookItem item) {
		model.add(item);
		updateView();
	}

	public void removeItem(int id) {
		model.remove(id);
		updateView();
	}

	private void updateView() {
		view.updateAddressbook(model);
	}
	
	public void setView(AddressbookView view) {
		this.view = view;
		updateView();
	}
	
	public void fireFirstNameChanged(AddressbookItem contact, String newValue) {
		contact.setFirstname(newValue);
		updateView();
	}
	
	public void fireLastNameChanged(AddressbookItem contact, String newValue) {
		contact.setLastname(newValue);
		updateView();
	}

	public void firePhoneNumberChanged(AddressbookItem contact, String newValue) {
		contact.setPhonenumber(newValue);
		updateView();
	}
	
	public void fireAddressChanged(AddressbookItem contact, String newValue) {
		contact.setAddress(newValue);
		updateView();
	}
	
	public void fireEmailChanged(AddressbookItem contact, String newValue) {
		contact.setEmail(newValue);
		updateView();
	}
	
}
