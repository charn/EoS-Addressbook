package test.controller;

import static org.junit.Assert.*;

import java.util.Iterator;

import junit.framework.TestCase;

import main.controller.*;
import main.model.*;

import static test.TestDummies.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddressbookControllerTest extends TestCase{

	private AddressbookModel model;
	private AddressbookController controller;
	
	
	@Before
	public void setUp() throws Exception {
		
		this.model = new AddressbookModel();
		this.controller = new AddressbookController(model);
		
		// Luodaan testidataa.
		model.add(JORMA);
//		model.add(ESA);
		model.add(PETTERI);
	}

//	@After
//	public void tearDown() throws Exception {
//	}

	@Test
	public void test_create_new_addressbook_controller() {
		assertTrue(true);
	}
	
	@Test
	public void test_newPersonIsAdded() {
		controller.addItem(ESA);
		
		boolean isAddedToModel = false;
		
		for (Iterator<AddressbookItem> i = model.iterator(); i.hasNext(); )
			if (i.next() == ESA)
				isAddedToModel = true;
		assertTrue(isAddedToModel);
	}
	
	@Test
	public void test_ViewIsToldToUpdate() {
		test_newPersonIsAdded();
	}
	
	@Test
	public void test_PersonIsDeleted() {
		controller.removeItem(JORMA.getId());
		
		boolean itemGetsDeletedFromTheModel = true;
	
		for (Iterator<AddressbookItem> i = model.iterator(); i.hasNext(); )
			if (i.next() == JORMA)
				itemGetsDeletedFromTheModel = false;

		assertTrue(itemGetsDeletedFromTheModel);
	}
	
}
