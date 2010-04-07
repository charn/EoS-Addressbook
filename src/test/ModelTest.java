package test;


import java.util.Iterator;

import junit.framework.TestCase;
import main.model.AddressbookItem;
import main.model.AddressbookModel;

import org.junit.Before;
import org.junit.Test;

public class ModelTest extends TestCase{
	
	AddressbookModel model;

	@Before
	public void setUp() throws Exception {
		model = new AddressbookModel();
	}

	@Test
	public void testIteratorFromEmptyModel(){
		Iterator<AddressbookItem> iterator = model.iterator();
		assertEquals(iterator.hasNext(), false);
	}
	
	@Test
	public void testAddItems(){
		AddressbookItem item1 = new AddressbookItem("Matti",
													"Meikäläinen",
													"masa@gmail.com",
													"050 123456",
													"Mannerheimintie 10 A 4");
		AddressbookItem item2 = new AddressbookItem("Maija",
													"Meikäläinen",
													"maija@gmail.com",
													"050 445533",
													"Mannerheimintie 10 A 4");
		AddressbookItem item3 = new AddressbookItem("Pekka",
													"Virtanen",
													"pvirtanen@gmail.com",
													"040 234234",
													"Kitarakuja 7 A 5");
		model.add(item1);
		model.add(item2);
		model.add(item3);
		Iterator<AddressbookItem> iterator = model.iterator();
		assertEquals(iterator.next(), item1);
		assertEquals(iterator.next(), item2);
		assertEquals(iterator.next(), item3);
		/*assertEquals(model.get(0), item1);
		assertEquals(model.get(1), item2);
		assertEquals(model.get(2), item3);*/
	}
	
	@Test
	public void testRemoveItems(){
		AddressbookItem item1 = new AddressbookItem("Matti",
													"Meikäläinen",
													"masa@gmail.com",
													"050 123456",
													"Mannerheimintie 10 A 4");
		AddressbookItem item2 = new AddressbookItem("Maija",
													"Meikäläinen",
													"maija@gmail.com",
													"050 445533",
													"Mannerheimintie 10 A 4");
		AddressbookItem item3 = new AddressbookItem("Pekka",
													"Virtanen",
													"pvirtanen@gmail.com",
													"040 234234",
													"Kitarakuja 7 A 5");
		model.add(item1);
		model.add(item2);
		model.add(item3);
		assertEquals(model.get(0), item1);
		assertEquals(model.get(1), item2);
		assertEquals(model.get(2), item3);
		
		model.remove(item2.getId());
		assertEquals(model.get(0), item1);
		assertEquals(model.get(1), item3);
		
		model.remove(item1.getId());
		assertEquals(model.get(0), item3);
		
		model.remove(item3.getId());
		assertEquals(model.isEmpty(), true);
	}

}
