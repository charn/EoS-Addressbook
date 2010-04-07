package test;


import java.util.Iterator;

import junit.framework.TestCase;
import main.model.AddressbookItem;
import main.model.AddressbookModel;

import static test.TestDummies.*;

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
		AddressbookItem item1 = ESA;
		AddressbookItem item2 = JORMA;
		AddressbookItem item3 = PETTERI;
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
		AddressbookItem item1 = ESA;
		AddressbookItem item2 = JORMA;
		AddressbookItem item3 = PETTERI;
		
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
