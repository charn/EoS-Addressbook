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

	public void removeItem(int row) {
		if (row >= 0) {
			AddressbookItem item = model.getItemsList().get(row);
			model.remove(item);
			updateView();
		}
	}

	private void updateView() {
		view.updateAddressbook(model.getItemsList());
	}
	
	public void setView(AddressbookView view) {
		this.view = view;
		updateView();
	}
	
	public void fireFirstNameChanged(AddressbookItem contact, String newValue) {
		model.updateItem(contact, contact.withFirstName(newValue));
		updateView();
	}
	
	public void fireLastNameChanged(AddressbookItem contact, String newValue) {
		model.updateItem(contact, contact.withLastName(newValue));
		updateView();
	}
	
	public void fireNicknameChanged(AddressbookItem contact, String newValue) {
		model.updateItem(contact, contact.withNickname(newValue));
		updateView();
	}

	public void firePhoneNumberChanged(AddressbookItem contact, String newValue) {
		model.updateItem(contact, contact.withPhoneNumber(newValue));
		updateView();
	}
	
	public void fireAddressChanged(AddressbookItem contact, String newValue) {
		model.updateItem(contact, contact.withAddress(newValue));
		updateView();
	}
	
	public void fireEmailChanged(AddressbookItem contact, String newValue) {
		model.updateItem(contact, contact.withEmail(newValue));
		updateView();
	}
	
}
