package test.controller;

//import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

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
	public void test_viewAndModelAreInSyncAfterRemovingItem() {
		controller.removeItem(0);
		
		assertTrue(model.getItemsList().containsAll(view.itemsList));
		assertTrue(view.itemsList.containsAll(model.getItemsList()));
	}

	@Test
	public void test_viewAndModelAreInSyncAfterAddingItem() {
		controller.addItem(new AddressbookItem());

		assertTrue(model.getItemsList().containsAll(view.itemsList));
		assertTrue(view.itemsList.containsAll(model.getItemsList()));

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
		
		controller.fireFirstNameChanged(view.itemsList.get(editedItemRow), newName);
		
		assertEquals(view.itemsList.get(editedItemRow).getFirstName(), newName);
		assertEquals(view.numberOfUpdates, 2);
	}
	
	@Test
	public void test_ContactLastNameIsChanged() {
		
		String newValue = "Keijo";
		int editedItemRow = 0;
		
		controller.fireLastNameChanged(view.itemsList.get(editedItemRow), newValue);
		
		assertEquals(view.itemsList.get(editedItemRow).getLastName(), newValue);
		assertEquals(view.numberOfUpdates, 2);
	}

	@Test
	public void test_ContactPhoneNumberIsChanged() {
		
		String newValue = "";
		int editedItemRow = 0;
		
		controller.firePhoneNumberChanged(view.itemsList.get(editedItemRow), newValue);

		assertEquals(view.itemsList.get(editedItemRow).getPhoneNumber(), newValue);
		assertEquals(view.numberOfUpdates, 2);
	}
	
	@Test
	public void test_ContactAddressIsChanged() {
		
		String newValue = "Katu 321";
		int editedItemRow = 0;
		
		controller.fireAddressChanged(view.itemsList.get(editedItemRow), newValue);

		assertEquals(view.itemsList.get(editedItemRow).getAddress(), newValue);
		assertEquals(view.numberOfUpdates, 2);
	}

	@Test
	public void test_ContactEmailIsChanged() {
		
		String newValue = "asdf@asdf.com";
		int editedItemRow = 0;
		
		controller.fireEmailChanged(view.itemsList.get(editedItemRow), newValue);

		assertEquals(view.itemsList.get(editedItemRow).getEmail(), newValue);
		assertEquals(view.numberOfUpdates, 2);
	}
	
	@Test
	public void test_ContactNicknameIsChanged() {
		
		String newValue = "Jortsu";
		int editedItemRow = 0;
		
		controller.fireNicknameChanged(view.itemsList.get(editedItemRow), newValue);

		assertEquals(view.itemsList.get(editedItemRow).getNickname(), newValue);
		assertEquals(view.numberOfUpdates, 2);
	}
	
	@Test
	public void test_ContactTagsIsChanged() {
		
		String newValue = "duuni";
		int editedItemRow = 0;
		
		controller.fireTagsChanged(view.itemsList.get(editedItemRow), newValue);

		assertEquals(view.itemsList.get(editedItemRow).getTags(), newValue);
		assertEquals(view.numberOfUpdates, 2);
	}
	
	@Test
	public void test_viewAndModelAreInSyncAfterEditingFields() {
		int editedItemRow = 0;
		String newValue = "AsDf12345";
		
		// Firstname
		controller.fireFirstNameChanged(view.itemsList.get(editedItemRow), newValue);
		
		assertTrue(model.getItemsList().containsAll(view.itemsList));
		assertTrue(view.itemsList.containsAll(model.getItemsList()));

		// Lastname
		controller.fireLastNameChanged(view.itemsList.get(editedItemRow), newValue);

		assertTrue(model.getItemsList().containsAll(view.itemsList));
		assertTrue(view.itemsList.containsAll(model.getItemsList()));

		// Nickname
		controller.fireNicknameChanged(view.itemsList.get(editedItemRow), newValue);

		assertTrue(model.getItemsList().containsAll(view.itemsList));
		assertTrue(view.itemsList.containsAll(model.getItemsList()));

		// Email
		controller.fireEmailChanged(view.itemsList.get(editedItemRow), newValue);

		assertTrue(model.getItemsList().containsAll(view.itemsList));
		assertTrue(view.itemsList.containsAll(model.getItemsList()));

		// Phone number
		controller.firePhoneNumberChanged(view.itemsList.get(editedItemRow), newValue);

		assertTrue(model.getItemsList().containsAll(view.itemsList));
		assertTrue(view.itemsList.containsAll(model.getItemsList()));

		// Address
		controller.fireAddressChanged(view.itemsList.get(editedItemRow), newValue);

		assertTrue(model.getItemsList().containsAll(view.itemsList));
		assertTrue(view.itemsList.containsAll(model.getItemsList()));
		
		// Address
		controller.fireTagsChanged(view.itemsList.get(editedItemRow), newValue);

		assertTrue(model.getItemsList().containsAll(view.itemsList));
		assertTrue(view.itemsList.containsAll(model.getItemsList()));

	}
	
	@Test
	public void test_rightPersonGetsDeletedAfterSearch() {
		
		String query = "PETTERI";
		
		controller.fireSearchKeywordsEntered(query);

		//Esiehdot
		assertEquals(model.get(0), JORMA);
		assertEquals(model.get(1), PETTERI);

		assertEquals(model.search(query).size(),1);
		assertTrue(model.search(query).contains(PETTERI));
		
		//Petterin pitäisi poistua
		controller.removeItem(0);

		List<AddressbookItem> lista = model.getItemsList();
		
		assertTrue(lista.contains(JORMA));
	}
	
	@Test
	public void test_NoTagsSelectedReturnsSearchWholeResult() {
		controller.fireSearchKeywordsEntered("");
		controller.fireSelectedTagsChanged(new String[]{});
		
		assertTrue(model.search("").containsAll(view.itemsList));
		assertTrue(view.itemsList.containsAll(model.search("")));
	}
	
	@Test
	public void test_OneTagIsSelectedSearchResultContainsOnlyThisTag() {
		controller.fireSelectedTagsChanged(new String[]{JORMA.getTags()});
		
		assertTrue(view.itemsList.contains(JORMA));
		assertFalse(view.itemsList.contains(PETTERI));
	}
	
	@Test
	public void test_TwoTagsAreSelectedSearchResultContainsOnlyItemsThatHaveBothTags() {
		model.add(SEPPO);
		model.add(ESA);
		model.add(ISMO);
		
		controller.fireSelectedTagsChanged(new String[]{"sukulainen","työ"});
		
		assertTrue(view.itemsList.contains(SEPPO));
		assertFalse(view.itemsList.contains(ISMO));
		assertFalse(view.itemsList.contains(JORMA));
		assertFalse(view.itemsList.contains(PETTERI));
		assertFalse(view.itemsList.contains(ESA));
	}
	
	@Test
	public void test_TagsGetUpdatedWhenTagsOnItemGetEdited() {
		AddressbookItem item = view.itemsList.get(0);
		controller.fireTagsChanged(item, "newtag");
		
		assertTrue(view.tags.contains("newtag"));
	}
	
	@Test
	public void test_TagsGetUpdatedWhenAddingItem() {
		
		controller.addItem(SEPPO);
		
		assertTrue(view.tags.contains("sukulainen"));
		assertTrue(view.tags.contains("työ"));
		assertTrue(view.tags.contains("kaveri"));
		
	}
	
	@Test
	public void test_TagsGetUpdatedWhedRemovingItem() {
		controller.removeItem(0); //JORMA
		
		assertTrue(view.tags.contains("sukulainen"));
		assertFalse(view.tags.contains("työ"));
	}
}
