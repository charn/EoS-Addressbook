package test.model;

import junit.framework.TestCase;

import main.model.AddressbookItem;

import static test.TestDummies.*;

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
	public void testnewEmptyItem() {
		AddressbookItem item = new AddressbookItem();
		assertEquals(item.getFirstName(), "");
		assertEquals(item.getLastName(), "");
		assertEquals(item.getNickname(), "");
		assertEquals(item.getEmail(), "");
		assertEquals(item.getPhoneNumber(), "");
		assertEquals(item.getAddress(), "");
		assertEquals(item.getTags(), "");
		assertEquals(item.getImageURL(), "");
	}
	
	@Test
	public void testWithMethodsReturnNewAddressbookItem() {
		AddressbookItem seppo = ESA.withFirstName("Seppo");
		assertNotSame(ESA, seppo);
		
		seppo = ESA.withLastName("Seppola");
		assertNotSame(ESA, seppo);
		
		seppo = ESA.withNickname("Sepi");
		assertNotSame(ESA, seppo);
		
		seppo = ESA.withEmail("asdf@asdf.fi");
		assertNotSame(ESA, seppo);
		
		seppo = ESA.withPhoneNumber("12345");
		assertNotSame(ESA, seppo);
		
		seppo = ESA.withAddress("Katu 123");
		assertNotSame(ESA, seppo);
		
		seppo = ESA.withTags("työ");
		assertNotSame(ESA, seppo);
	}
	
	@Test
	public void testWithMethodsReturnNewItemWithChangedParameter() {
		// Firstname
		AddressbookItem seppo = ESA.withFirstName("Seppo");
		
		assertEquals(seppo.getFirstName(), "Seppo");
		
		assertTrue(seppo.getLastName().equals(ESA.getLastName()));
		assertTrue(seppo.getNickname().equals(ESA.getNickname()));
		assertTrue(seppo.getEmail().equals(ESA.getEmail()));
		assertTrue(seppo.getPhoneNumber().equals(ESA.getPhoneNumber()));
		assertTrue(seppo.getAddress().equals(ESA.getAddress()));
		assertTrue(seppo.getTags().equals(ESA.getTags()));
		assertTrue(seppo.getImageURL().equals(ESA.getImageURL()));
		
		// Lastname
		seppo = ESA.withLastName("Seppola");
		
		assertEquals(seppo.getLastName(), "Seppola");
		
		assertTrue(seppo.getFirstName().equals(ESA.getFirstName()));
		assertTrue(seppo.getNickname().equals(ESA.getNickname()));
		assertTrue(seppo.getEmail().equals(ESA.getEmail()));
		assertTrue(seppo.getPhoneNumber().equals(ESA.getPhoneNumber()));
		assertTrue(seppo.getAddress().equals(ESA.getAddress()));
		assertTrue(seppo.getTags().equals(ESA.getTags()));
		assertTrue(seppo.getImageURL().equals(ESA.getImageURL()));
		
		// Nickname
		seppo = ESA.withNickname("Sepi");
		
		assertEquals(seppo.getNickname(), "Sepi");
		
		assertTrue(seppo.getFirstName().equals(ESA.getFirstName()));
		assertTrue(seppo.getLastName().equals(ESA.getLastName()));
		assertTrue(seppo.getPhoneNumber().equals(ESA.getPhoneNumber()));
		assertTrue(seppo.getAddress().equals(ESA.getAddress()));
		assertTrue(seppo.getTags().equals(ESA.getTags()));
		assertTrue(seppo.getImageURL().equals(ESA.getImageURL()));
		
		// Email
		seppo = ESA.withEmail("asdf@asdf.fi");
		
		assertEquals(seppo.getEmail(), "asdf@asdf.fi");
		
		assertTrue(seppo.getFirstName().equals(ESA.getFirstName()));
		assertTrue(seppo.getLastName().equals(ESA.getLastName()));
		assertTrue(seppo.getNickname().equals(ESA.getNickname()));
		assertTrue(seppo.getPhoneNumber().equals(ESA.getPhoneNumber()));
		assertTrue(seppo.getAddress().equals(ESA.getAddress()));
		assertTrue(seppo.getTags().equals(ESA.getTags()));
		assertTrue(seppo.getImageURL().equals(ESA.getImageURL()));
		
		// PhoneNumber
		seppo = ESA.withPhoneNumber("12345");
		
		assertEquals(seppo.getPhoneNumber(), "12345");
		
		assertTrue(seppo.getFirstName().equals(ESA.getFirstName()));
		assertTrue(seppo.getLastName().equals(ESA.getLastName()));
		assertTrue(seppo.getNickname().equals(ESA.getNickname()));
		assertTrue(seppo.getEmail().equals(ESA.getEmail()));
		assertTrue(seppo.getAddress().equals(ESA.getAddress()));
		assertTrue(seppo.getTags().equals(ESA.getTags()));
		assertTrue(seppo.getImageURL().equals(ESA.getImageURL()));
		
		// Address
		seppo = ESA.withAddress("Katu 123");
		
		assertEquals(seppo.getAddress(), "Katu 123");
		
		assertTrue(seppo.getFirstName().equals(ESA.getFirstName()));
		assertTrue(seppo.getLastName().equals(ESA.getLastName()));
		assertTrue(seppo.getNickname().equals(ESA.getNickname()));
		assertTrue(seppo.getEmail().equals(ESA.getEmail()));
		assertTrue(seppo.getPhoneNumber().equals(ESA.getPhoneNumber()));
		assertTrue(seppo.getTags().equals(ESA.getTags()));
		assertTrue(seppo.getImageURL().equals(ESA.getImageURL()));
		
		// Tags
		seppo = ESA.withTags("joku_uusi_tag");
		
		assertEquals(seppo.getTags(), "joku_uusi_tag");
		
		assertTrue(seppo.getFirstName().equals(ESA.getFirstName()));
		assertTrue(seppo.getLastName().equals(ESA.getLastName()));
		assertTrue(seppo.getNickname().equals(ESA.getNickname()));
		assertTrue(seppo.getEmail().equals(ESA.getEmail()));
		assertTrue(seppo.getPhoneNumber().equals(ESA.getPhoneNumber()));
		assertTrue(seppo.getImageURL().equals(ESA.getImageURL()));

		// imageURL
		seppo = ESA.withImageURL("uuden_kuvan_uusi_osoite.png");
		
		assertEquals(seppo.getImageURL(), "uuden_kuvan_uusi_osoite.png");
		
		assertTrue(seppo.getFirstName().equals(ESA.getFirstName()));
		assertTrue(seppo.getLastName().equals(ESA.getLastName()));
		assertTrue(seppo.getNickname().equals(ESA.getNickname()));
		assertTrue(seppo.getEmail().equals(ESA.getEmail()));
		assertTrue(seppo.getPhoneNumber().equals(ESA.getPhoneNumber()));
		assertTrue(seppo.getTags().equals(ESA.getTags()));

	}
	
	@Test
	public void testToString() {
		assertTrue(ESA.toString().equals(
				"Esa, Meikäläinen, Esku, maija@gmail.com, 050 445533, Mannerheimintie 10 A 4, työ"));
	}

}
