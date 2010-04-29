package test.model;


import java.util.List;

import junit.framework.TestCase;
import main.model.AddressbookModel;
import main.model.AddressbookTags;

import static test.TestDummies.*;

import org.junit.Before;
import org.junit.Test;

public class AddressbookTagsTest extends TestCase {

	private AddressbookTags tags;
	private AddressbookModel model;
	
	@Before
	public void setUp() throws Exception {
		this.tags = new AddressbookTags();
	
		model = new AddressbookModel();
		model.add(ESA);
		model.add(JORMA);
		model.add(PETTERI);
		model.add(SEPPO);
		model.add(ISMO);
	}
	
	@Test
	public void test_newClassHasNoTags() {
		assertEquals(tags.size(),0);
	}
	
	@Test 
	public void test_updateTagsFromModelNoDuplicates() {
		//tags in testdummies: työ, sukulainen, kaveri
		tags.updateTagsFromItems(model.getItemsList());
		
		assertTrue(tags.contains("työ"));
		assertTrue(tags.contains("sukulainen"));
		assertTrue(tags.contains("kaveri"));
		
		assertEquals(tags.size(),3);
	}
	
	@Test
	public void test_getAllTagsAsList() {
		//tags in testdummies: työ, sukulainen, kaveri
		tags.updateTagsFromItems(model.getItemsList());
		
		List<String> tagsList = tags.getTagsList();
		
		// Alkiot aakkosjärjestyksessä listassa
		assertEquals(tagsList.get(0),"kaveri");
		assertEquals(tagsList.get(1),"sukulainen");
		assertEquals(tagsList.get(2),"työ");
	}
}
