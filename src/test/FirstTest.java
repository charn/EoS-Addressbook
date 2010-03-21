package test;


import junit.framework.TestCase;

import main.Addressbook;
import org.junit.Test;

public class FirstTest extends TestCase{
	
	@Test
	public void testNewAddressbook(){
		new Addressbook();
	}

}
