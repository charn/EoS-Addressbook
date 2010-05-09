package test;

import test.model.AddressbookItemTest;
import test.model.ModelTest;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Tests for Addressbook");
		//$JUnit-BEGIN$
		suite.addTestSuite(FirstTest.class);
		suite.addTestSuite(AddressbookItemTest.class);
		suite.addTestSuite(ModelTest.class);
		suite.addTestSuite(test.controller.AddressbookControllerTest.class);
		suite.addTestSuite(test.controller.AddressbookSaverTest.class);
		suite.addTestSuite(test.model.AddressbookModelTest.class);

		//$JUnit-END$
		return suite;
	}

}
