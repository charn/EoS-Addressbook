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
		view.updateAddressbook(model);
	}
	
}
