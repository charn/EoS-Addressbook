package main.model;

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
	
	public AddressbookItem get(int index){
		return items.get(index);
	}
	
	public boolean isEmpty(){
		return items.isEmpty();
	}
	
	public int itemAmount(){
		return items.size();
	}
}
