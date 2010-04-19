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
		model.add(ESA);
		model.add(JORMA);
		model.add(PETTERI);
		Iterator<AddressbookItem> iterator = model.iterator();
		assertEquals(iterator.next(), ESA);
		assertEquals(iterator.next(), JORMA);
		assertEquals(iterator.next(), PETTERI);
	}
	
	@Test 
	public void testGettingItems() {
		model.add(ESA);
		assertEquals(model.get(0), ESA);
	}
	
	@Test
	public void testSizeWorks() {
		assertEquals(model.itemAmount(), 0);
		model.add(ESA);
		assertEquals(model.itemAmount(), 1);
		model.add(JORMA);
		assertEquals(model.itemAmount(), 2);
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

	@Test
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
	
	@Test
	public void testUpdatingAnItem() {
		model.add(ESA);
		AddressbookItem newESA = ESA.withLastName("Keijola");
		
		model.updateItem(ESA, newESA);
		
		List<AddressbookItem> lista = model.getItemsList();
		
		assertFalse(lista.contains(ESA));
		assertTrue(lista.contains(newESA));
	}
	
	@Test
	public void test_searchOnEmptyAddressbook() {
		List<AddressbookItem> result = model.search("");
		assertEquals(result.size(), 0);
	}
	
	@Test
	public void test_searchOnNotEmptyAddressbook() {
		model.add(ESA);
		model.add(JORMA);
		model.add(PETTERI);
		
		List<AddressbookItem> result = model.search("gmail.com, 050");
		assertTrue(result.contains(ESA));
		assertTrue(result.contains(JORMA));
		assertFalse(result.contains(PETTERI));
	}
}
