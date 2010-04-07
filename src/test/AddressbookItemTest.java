package test;

import junit.framework.TestCase;

import main.model.AddressbookItem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddressbookItemTest extends TestCase{

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testAscendingIdSequenceToNewItems(){
		AddressbookItem itemA = new AddressbookItem("a", "a", "a", "a", "a");
		int itemAId = itemA.getId();
		
		assertEquals(new AddressbookItem("b", "b", "b", "b", "b").getId(), itemAId + 1);
		assertEquals(new AddressbookItem("c", "c", "c", "c", "c").getId(), itemAId + 2);
	}

}
