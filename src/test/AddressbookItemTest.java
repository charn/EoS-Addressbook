package test;

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
		
		// Lastname
		seppo = ESA.withLastName("Seppola");
		
		assertEquals(seppo.getLastName(), "Seppola");
		
		assertTrue(seppo.getFirstName().equals(ESA.getFirstName()));
		assertTrue(seppo.getNickname().equals(ESA.getNickname()));
		assertTrue(seppo.getEmail().equals(ESA.getEmail()));
		assertTrue(seppo.getPhoneNumber().equals(ESA.getPhoneNumber()));
		assertTrue(seppo.getAddress().equals(ESA.getAddress()));
		
		// Nickname
		seppo = ESA.withNickname("Sepi");
		
		assertEquals(seppo.getNickname(), "Sepi");
		
		assertTrue(seppo.getFirstName().equals(ESA.getFirstName()));
		assertTrue(seppo.getLastName().equals(ESA.getLastName()));
		assertTrue(seppo.getPhoneNumber().equals(ESA.getPhoneNumber()));
		assertTrue(seppo.getAddress().equals(ESA.getAddress()));
		
		// Email
		seppo = ESA.withEmail("asdf@asdf.fi");
		
		assertEquals(seppo.getEmail(), "asdf@asdf.fi");
		
		assertTrue(seppo.getFirstName().equals(ESA.getFirstName()));
		assertTrue(seppo.getLastName().equals(ESA.getLastName()));
		assertTrue(seppo.getNickname().equals(ESA.getNickname()));
		assertTrue(seppo.getPhoneNumber().equals(ESA.getPhoneNumber()));
		assertTrue(seppo.getAddress().equals(ESA.getAddress()));
		
		// PhoneNumber
		seppo = ESA.withPhoneNumber("12345");
		
		assertEquals(seppo.getPhoneNumber(), "12345");
		
		assertTrue(seppo.getFirstName().equals(ESA.getFirstName()));
		assertTrue(seppo.getLastName().equals(ESA.getLastName()));
		assertTrue(seppo.getNickname().equals(ESA.getNickname()));
		assertTrue(seppo.getEmail().equals(ESA.getEmail()));
		assertTrue(seppo.getAddress().equals(ESA.getAddress()));
		
		// Address
		seppo = ESA.withAddress("Katu 123");
		
		assertEquals(seppo.getAddress(), "Katu 123");
		
		assertTrue(seppo.getFirstName().equals(ESA.getFirstName()));
		assertTrue(seppo.getLastName().equals(ESA.getLastName()));
		assertTrue(seppo.getNickname().equals(ESA.getNickname()));
		assertTrue(seppo.getEmail().equals(ESA.getEmail()));
		assertTrue(seppo.getPhoneNumber().equals(ESA.getPhoneNumber()));
	}

}
