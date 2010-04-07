package test.controller;

//import static org.junit.Assert.*;

import java.util.Iterator;

import junit.framework.TestCase;

import main.controller.*;
import main.model.*;

import static test.TestDummies.*;

import org.junit.Before;
import org.junit.Test;

public class AddressbookControllerTest extends TestCase{

	private AddressbookModel model;
	private AddressbookController controller;
	private FakeGUI view;
	
	@Before
	public void setUp() throws Exception {
		
		this.model = new AddressbookModel();
		
		// Luodaan testidataa.
		model.add(JORMA);
		model.add(PETTERI);
		
		this.controller = new AddressbookController(model);
		this.view = new FakeGUI();
		controller.setView(view);
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
	public void test_ViewIsToldToUpdateWhenAdding() {
		controller.addItem(ESA);
		assertTrue(view.gotUpdated);
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
	
	@Test
	public void test_ViewIsToldToUpdateWhenRemoving() {
		controller.removeItem(JORMA.getId());
		assertTrue(view.gotUpdated);
	}
	
	@Test
	public void test_ViewIsToldToUpdateWhenViewIsSet() {
		view = new FakeGUI();
		assertFalse(view.gotUpdated);
		
		controller.setView(view);
		assertTrue(view.gotUpdated);
	}
	
}
