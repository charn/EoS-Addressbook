package test;


import java.util.Iterator;
import java.util.List;

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
		assertTrue(model.isEmpty());
	}
	
	@Test
	public void testRemoveAddressbookItems() {
		model.add(ESA);
		model.add(JORMA);
		assertEquals(model.remove(ESA), ESA);
		assertEquals(model.remove(JORMA), JORMA);
		
		try {
			model.remove(PETTERI);
			fail("Should throw exception");
		}
		catch(IndexOutOfBoundsException e) {
			//Exception thrown as expected
		}
		
		assertTrue(model.isEmpty());
	}
	
	@Test
	public void testGetItemsList() {
		model.add(ESA);
		model.add(JORMA);
		model.add(PETTERI);
		
		List<AddressbookItem> lista = model.getItemsList();
		
		assertTrue(lista.contains(ESA));
		assertTrue(lista.contains(JORMA));
		assertTrue(lista.contains(PETTERI));
		assertEquals(lista.size(),3);
	}

	public void testListIsUnmodifiable() {
		model.add(ESA);
		
		List<AddressbookItem> lista = model.getItemsList();
		
		try {
			lista.add(JORMA);
			lista.remove(lista.indexOf(ESA));
		
			fail("Should throw Exception");
		}
		catch (UnsupportedOperationException e) {
			//Exception thrown as expected
		}
		
	}
}
