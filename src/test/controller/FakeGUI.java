package test.controller;

import main.model.AddressbookModel;
import main.view.AddressbookView;

public class FakeGUI implements AddressbookView {

	public AddressbookModel model;
	public int numberOfUpdates = 0;
	
	public void updateAddressbook(AddressbookModel model) {
		this.model = model;
		++this.numberOfUpdates;
	}


}
