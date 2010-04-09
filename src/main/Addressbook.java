package main;

import main.controller.AddressbookController;
import main.model.AddressbookItem;
import main.model.AddressbookModel;
import main.view.GUI;

import static test.TestDummies.*;

/**
 * Main class.
 *
 */
public class Addressbook {

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				AddressbookModel model;
				
				//Jouduin laittamaan tähän rumasti testidataa /////////
				model = new AddressbookModel();
				model.add(ESA);
				model.add(JORMA);
				model.add(PETTERI);
				/////////// testidata loppuu //////////////////

				AddressbookController controller = new AddressbookController(model);
				
				GUI gui = new GUI(controller);
				controller.setView(gui);
				
				gui.pack();
				gui.setVisible(true);
	            }
	        });
	    }

}
