package test.model;


import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

import main.model.AddressbookModel;
import main.model.AddressbookItem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.TestDummies;

public class AddressbookModelTest extends TestCase{

	AddressbookModel model;
	List<AddressbookItem> itemList;
	
	@Before
	public void setUp() throws Exception {
		itemList = new LinkedList<AddressbookItem>();
		itemList.add(TestDummies.ESA);
		itemList.add(TestDummies.JORMA);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetItemsForSaving(){
		assertEquals(itemList.size(), 2);
		assertSame(itemList.get(0), test.TestDummies.ESA);
		assertSame(itemList.get(1), test.TestDummies.JORMA);
		
		model = new AddressbookModel(itemList);
		
		List<AddressbookItem> itemsForSaving = model.getItemsForSaving();
		
		assertEquals(itemsForSaving, itemList);
	}

}
