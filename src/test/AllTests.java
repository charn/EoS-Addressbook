package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Tests for Addressbook");
		//$JUnit-BEGIN$
		suite.addTestSuite(FirstTest.class);
		suite.addTestSuite(AddressbookItemTest.class);
		suite.addTestSuite(ModelTest.class);
		//$JUnit-END$
		return suite;
	}

}
