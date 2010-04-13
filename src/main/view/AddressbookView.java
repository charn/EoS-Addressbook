package main.view;

import java.util.List;

import main.model.AddressbookItem;

public interface AddressbookView {

	void updateAddressbook(List<AddressbookItem> items);
}
