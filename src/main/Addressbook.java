package main;

import java.io.File;
import java.util.List;

import main.controller.AddressbookController;
import main.controller.AddressbookSaver;
import main.model.AddressbookItem;
import main.model.AddressbookModel;
import main.view.GUI;

/**
 * Main class.
 *
 */
public class Addressbook {
	
	public static final String DEFAULT_FILE_FOR_SERIALIZED_ADDRESSBOOKITEMLIST = 
											"data" + File.separator + "Addressbook.ser";

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				AddressbookModel model;
				
				//Haetaan yhteystietolista modelille tiedostosta
				List<AddressbookItem> startItemList =
					AddressbookSaver.openAddressbookItemListFromFile(DEFAULT_FILE_FOR_SERIALIZED_ADDRESSBOOKITEMLIST);
				
				//Jos listaa ei löydy tiedostosta niin tarkoitus on luoda tyhjä osoitekirja
				if (startItemList == null)
					model = new AddressbookModel();
				else
					model = new AddressbookModel(startItemList);

				AddressbookController controller = new AddressbookController(model);
				
				GUI gui = new GUI(controller);
				controller.setView(gui);
				
				gui.pack();
				gui.setVisible(true);
	            }
	        });
	    }

}
