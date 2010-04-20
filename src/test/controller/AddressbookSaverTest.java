package test.controller;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import main.controller.*;
import main.model.AddressbookItem;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddressbookSaverTest extends TestCase{

	private List<AddressbookItem> itemList;
	
	@Before
	public void setUp() throws Exception {
		 itemList = new LinkedList<AddressbookItem>();
		 itemList.add(test.TestDummies.ESA);
		 itemList.add(test.TestDummies.JORMA);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSavingItemListToFile(){
		assertEquals(itemList.size(), 2);
		assertSame(itemList.get(0), test.TestDummies.ESA);
		assertSame(itemList.get(1), test.TestDummies.JORMA);
		
		AddressbookSaver.saveAddressbookItemListToFile(itemList, "testdata" + File.separator + "esajorma.ser");
		
		List<AddressbookItem> itemListFromFile =
				AddressbookSaver.openAddressbookItemListFromFile("testdata" + File.separator + "esajorma.ser");
		
		//Verrataan että tiedostosta haettujen itemien String-esitykset ovat samat
		//kuin tiedostoon talletettujen
		assertEquals(itemListFromFile.size(), 2);
		assertEquals(itemListFromFile.get(0).toString(), test.TestDummies.ESA.toString());
		assertEquals(itemListFromFile.get(1).toString(), test.TestDummies.JORMA.toString());
	}
	
	@Test
	public void testOpeningFileThatDoesNotExist(){
		List<AddressbookItem> itemListFromFile =
			AddressbookSaver.openAddressbookItemListFromFile("testdata" + File.separator + "shouldNotExist.ser");
		assertNull(itemListFromFile);
	}
}
