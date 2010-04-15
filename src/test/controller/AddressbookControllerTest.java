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
	public void test_ViewIsToldToUpdateWhenViewIsSet() {
		view = new FakeGUI();
		assertEquals(view.numberOfUpdates, 0);
		
		controller.setView(view);
		assertEquals(view.numberOfUpdates, 1);
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
		// 1. päivitys viewin asettamisessa ja 2. lisäämisessä.
		assertEquals(view.numberOfUpdates, 2);
	}
	
	@Test
	public void test_PersonIsDeleted2() {
				
		int deletedRow = 0;
		
		AddressbookItem deletedItem = view.itemsList.get(deletedRow);
		controller.removeItem(deletedRow);
		
		boolean itemGetsDeletedFromTheModel = true;
	
		for (Iterator<AddressbookItem> i = model.iterator(); i.hasNext(); )
			if (i.next() == deletedItem)
				itemGetsDeletedFromTheModel = false;

		assertTrue(itemGetsDeletedFromTheModel);
	}
	
	@Test
	public void test_ViewIsToldToUpdateWhenRemoving() {
		controller.removeItem(0);
		assertEquals(view.numberOfUpdates, 2);
	}
	
	@Test
	public void test_ContactFirstNameIsChanged() {
		
		String newName = "Keijo";
		int editedItemRow = 0;
		
		controller.fireFirstNameChanged(JORMA, newName);
		
		assertEquals(view.itemsList.get(editedItemRow).getFirstName(), newName);
		assertEquals(view.numberOfUpdates, 2);
	}
	
	@Test
	public void test_ContactLastNameIsChanged() {
		
		String newValue = "Keijo";
		int editedItemRow = 0;
		
		controller.fireLastNameChanged(JORMA, newValue);
		
		assertEquals(view.itemsList.get(editedItemRow).getLastName(), newValue);
		assertEquals(view.numberOfUpdates, 2);
	}

	@Test
	public void test_ContactPhoneNumberIsChanged() {
		
		String newValue = "";
		int editedItemRow = 0;
		
		controller.firePhoneNumberChanged(JORMA, newValue);

		assertEquals(view.itemsList.get(editedItemRow).getPhoneNumber(), newValue);
		assertEquals(view.numberOfUpdates, 2);
	}
	
	@Test
	public void test_ContactAddressIsChanged() {
		
		String newValue = "Katu 321";
		int editedItemRow = 0;
		
		controller.fireAddressChanged(JORMA, newValue);

		assertEquals(view.itemsList.get(editedItemRow).getAddress(), newValue);
		assertEquals(view.numberOfUpdates, 2);
	}

	@Test
	public void test_ContactEmailIsChanged() {
		
		String newValue = "asdf@asdf.com";
		int editedItemRow = 0;
		
		controller.fireEmailChanged(JORMA, newValue);

		assertEquals(view.itemsList.get(editedItemRow).getEmail(), newValue);
		assertEquals(view.numberOfUpdates, 2);
	}
	
	@Test
	public void test_ContactNicknameIsChanged() {
		
		String newValue = "Jortsu";
		int editedItemRow = 0;
		
		controller.fireNicknameChanged(JORMA, newValue);

		assertEquals(view.itemsList.get(editedItemRow).getNickname(), newValue);
		assertEquals(view.numberOfUpdates, 2);
	}
}
