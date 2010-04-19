package main.model;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class AddressbookModel {
	
	private List<AddressbookItem> items;

	// Pilkut ja välilyönnit erottimina
	private static final Pattern QUERYSPLITPATTERN = Pattern.compile("[,\\s]+");
	
	public AddressbookModel(){
		items = new LinkedList<AddressbookItem>();
	}
	
	public AddressbookModel(List<AddressbookItem> itemList){
		items = new LinkedList<AddressbookItem>(itemList);
	}

	public Iterator<AddressbookItem> iterator(){
		return items.iterator();
	}
	
	public void add(AddressbookItem item){
		items.add(item);
	}
		
	/**
	 * Poistaa tietorakenteesta halutun tietueen.
	 * @param item
	 * @return Poistettu tietue.
	 */
	public AddressbookItem remove(AddressbookItem item) {
		int index = items.indexOf(item);
		return items.remove(index);
	}
	
	/**
	 * Palauttaa listan, jota ei voi muokata. Listaa muokataan ainoastaan tämän
	 * luokan tarjoamien muoden metodien kautta.
	 * @return Collections.unmodifiableList
	 */
	public List<AddressbookItem> getItemsList() {
		return Collections.unmodifiableList(this.items);
	}
	
	public AddressbookItem get(int index){
		return items.get(index);
	}
	
	public boolean isEmpty(){
		return items.isEmpty();
	}
	
	public int itemAmount(){
		return items.size();
	}

	public void updateItem(AddressbookItem oldItem, AddressbookItem newItem) {
		this.items.set(this.items.indexOf(oldItem), newItem);
	}
	
	public List<AddressbookItem> getItemsForSaving() {
		return this.items;
	}
	
	public List<AddressbookItem> search(String query) {
		String queryStrings[] = splitQuery(query);
		List<AddressbookItem> searchResult = new LinkedList<AddressbookItem>();
		
		for (AddressbookItem item : this.items) {
			if (matchesKeywords(item,queryStrings)) {
				searchResult.add(item);
			}
		}
		
		return searchResult;
	}
	
	private static String[] splitQuery(String query) {
		return QUERYSPLITPATTERN.split(query);
	}
	
	private static boolean matchesKeywords(AddressbookItem item, String[] keywords) {
		String[] needles = stringArrayToLowerCase(keywords);
		String[] haystack = new String[] {
				item.getFirstName(),
				item.getLastName(),
				item.getEmail(),
				item.getNickname(),
				item.getPhoneNumber(),
				item.getAddress()
		};
		haystack = stringArrayToLowerCase(haystack);
	
		for (String needle : needles) {
			if (contains(haystack,needle) == false) {
				return false;
			}
		}
		return true;
	}
	
	private static String[] stringArrayToLowerCase(String[] array) {
		String[] newArray = new String[array.length];
		for (int i = 0; i < array.length; ++i)
			newArray[i] = array[i].toLowerCase();
		return newArray;
	}
	
	private static boolean contains(String[] haystack, String needle) {
		for (String s : haystack) {
			if (s.contains(needle)) {
				return true;
			}
		}
		return false;
	}
}
