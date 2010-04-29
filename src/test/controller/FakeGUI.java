package test.controller;

import java.util.List;

import main.model.AddressbookItem;
import main.model.AddressbookModel;
import main.view.AddressbookView;

public class FakeGUI implements AddressbookView {

	public AddressbookModel model;
	public List<AddressbookItem> itemsList;
	public List<String> tags;
	public int numberOfUpdates = 0;

	public void updateAddressbook(List<AddressbookItem> items) {
		this.itemsList = items;
		++this.numberOfUpdates;
	}

	@Override
	public void updateTags(List<String> tags) {
		this.tags = tags;
//		++this.numberOfUpdates;
		
	}


}
