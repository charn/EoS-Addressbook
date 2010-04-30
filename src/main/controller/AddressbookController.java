package main.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.Addressbook;
import main.view.AddressbookView;
import main.model.AddressbookItem;
import main.model.AddressbookModel;
import main.model.AddressbookSearch;
import main.model.AddressbookTags;


public class AddressbookController {
	
	private AddressbookModel model;
	private AddressbookView view;
	
	private AddressbookSearch search;
	
	private String searchKeywords = "";
	private List<AddressbookItem> searchResult;
	private List<AddressbookItem> tagSearchResult;
	
	private String selectedTags[];
	private AddressbookTags tags;
	
	
	public AddressbookController (AddressbookModel model) {
		this.model = model;
		
		search = new AddressbookSearch(AddressbookSearch.TAG_SEARCH_STYLE_AND);
		
		searchResult = new ArrayList<AddressbookItem>();
		tagSearchResult = new ArrayList<AddressbookItem>();
		selectedTags = new String[0];
		
		tags = new AddressbookTags();
		tags.updateTagsFromItems(model.getItemsList());
	}

	public void addItem(AddressbookItem item) {
		model.add(item);
		searchResult.add(item);
		tagSearchResult.add(item);
		
		tags.updateTagsFromItem(item);
		
		updateViewTags();
		updateViewAddressbook();
		
	}

	public void removeItem(int row) {
		if (row >= 0) {
			AddressbookItem item = this.tagSearchResult.get(row);
			model.remove(item);
			
			searchResult.remove(searchResult.indexOf(item));
			tagSearchResult.remove(tagSearchResult.indexOf(item));
			
			tags.updateTagsFromItems(model.getItemsList());
			
			updateViewTags();
			updateViewAddressbook();
			
		}
	}

	private void updateViewAddressbook() {
		view.updateAddressbook(Collections.unmodifiableList(this.tagSearchResult));
	}
	
	private void updateViewTags() {
		view.updateTags(tags.getTagsList());
	}
	
	public void setView(AddressbookView view) {
		this.view = view;
		doSearch();
		updateViewTags();
	}
	
	public void fireSearchKeywordsEntered(String keywords) {
		this.searchKeywords = keywords;
		doSearch();
	}
	
	private void doSearch() {
		this.searchResult = model.search(searchKeywords);
		doTagsSearch();
		updateViewAddressbook();
	}
	
	private void doTagsSearch() {
		if (this.selectedTags.length > 0) {
			this.tagSearchResult = search.searchWithTags(this.searchResult, this.selectedTags);
		}
		else {
			this.tagSearchResult.clear();
			this.tagSearchResult.addAll(this.searchResult);
		}
			
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
	
	public void fireTagsChanged(AddressbookItem contact, String newValue) {
		updateItem(contact, contact.withTags(newValue));
		this.tags.updateTagsFromItems(model.getItemsList());
		updateViewTags();
	}
	
	public void fireSelectedTagsChanged(String[] selectedTags) {
		this.selectedTags = selectedTags;
		doSearch();
	}
	
	private void updateItem(AddressbookItem existing, AddressbookItem updated) {
		model.updateItem(existing, updated);
		searchResult.set(searchResult.indexOf(existing), updated);
		tagSearchResult.set(tagSearchResult.indexOf(existing), updated);
		updateViewAddressbook();
	}
	
	public void saveModelToFile(){
		List<AddressbookItem> itemList = model.getItemsForSaving();
		String fileName = Addressbook.DEFAULT_FILE_FOR_SERIALIZED_ADDRESSBOOKITEMLIST;
		AddressbookSaver.saveAddressbookItemListToFile(itemList, fileName);
	}

	public List<AddressbookItem> getItems()
	{
		return searchResult;
	}

	public void fireTagsSearchStyleIsAND() {
		search.setTagSearchStyle(AddressbookSearch.TAG_SEARCH_STYLE_AND);
		doSearch();
	}

	public void fireTagsSearchStyleIsOR() {
		search.setTagSearchStyle(AddressbookSearch.TAG_SEARCH_STYLE_OR);
		doSearch();
	}

}
