package main.model;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AddressbookModel {
	
	private List<AddressbookItem> items;
	
	public AddressbookModel(){
		items = new LinkedList<AddressbookItem>();
	}

	public Iterator<AddressbookItem> iterator(){
		return items.iterator();
	}
	
	public void add(AddressbookItem item){
		items.add(item);
	}
	
	/**
	 * Olettaa, että id:t ovat yksikäsitteisiä, eli poistaa vain yhden itemin
	 * @deprecated
	 */
	public boolean remove(int id){
		int indexOfItemToBeRemoved = -1;
		for (int i = 0; i < items.size(); i++){
			if (items.get(i).getId() == id)
				indexOfItemToBeRemoved = i;
		}
		
		if (indexOfItemToBeRemoved > -1){
			items.remove(indexOfItemToBeRemoved);
			return true;
		} else {
			return false;
		}
		
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
}
