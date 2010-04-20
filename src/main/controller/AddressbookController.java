package main.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.Addressbook;
import main.view.AddressbookView;
import main.model.AddressbookItem;
import main.model.AddressbookModel;


public class AddressbookController {
	
	private AddressbookModel model;
	private AddressbookView view;
	
	private String searchKeywords = "";
	private List<AddressbookItem> searchResult = new ArrayList<AddressbookItem>();
	
	public AddressbookController (AddressbookModel model) {
		this.model = model;
	}

	public void addItem(AddressbookItem item) {
		model.add(item);
		searchResult.add(item);
		updateView();
	}

	public void removeItem(int row) {
		if (row >= 0) {
			AddressbookItem item = this.searchResult.get(row);
			model.remove(item);
			searchResult.remove(searchResult.indexOf(item));
			updateView();
		}
	}

	private void updateView() {
		view.updateAddressbook(Collections.unmodifiableList(this.searchResult));
	}
	
	public void setView(AddressbookView view) {
		this.view = view;
		doSearch();
	}
	
	public void fireSearchKeywordsEntered(String keywords) {
		this.searchKeywords = keywords;
		doSearch();
	}
	
	private void doSearch() {
		this.searchResult = model.search(searchKeywords);
		updateView();
	}
	
	public void fireFirstNameChanged(AddressbookItem contact, String newValue) {
		updateItem(contact, contact.withFirstName(newValue));
	}
	
	public void fireLastNameChanged(AddressbookItem contact, String newValue) {
		updateItem(contact, contact.withLastName(newValue));
	}
	
	public void fireNicknameChanged(AddressbookItem contact, String newValue) {
		updateItem(contact, contact.withNickname(newValue));
	}

	public void firePhoneNumberChanged(AddressbookItem contact, String newValue) {
		updateItem(contact, contact.withPhoneNumber(newValue));
	}
	
	public void fireAddressChanged(AddressbookItem contact, String newValue) {
		updateItem(contact, contact.withAddress(newValue));
	}
	
	public void fireEmailChanged(AddressbookItem contact, String newValue) {
		updateItem(contact, contact.withEmail(newValue));
	}
	
	private void updateItem(AddressbookItem existing, AddressbookItem updated) {
		model.updateItem(existing, updated);
		searchResult.set(searchResult.indexOf(existing), updated);
		updateView();
	}
	
	public void saveModelToFile(){
		List<AddressbookItem> itemList = model.getItemsForSaving();
		String fileName = Addressbook.DEFAULT_FILE_FOR_SERIALIZED_ADDRESSBOOKITEMLIST;
		AddressbookSaver.saveAddressbookItemListToFile(itemList, fileName);
	}
}
