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

		// Luodaan data -kansio tarvittaessa.
		File dirs = new File("data/img");
		boolean dirsCreated = dirs.mkdirs();

		// Jos kansiot on luotu jo aiemmin.
		if(dirs.exists()) {
			dirsCreated = true;
		}
		
		if(!dirsCreated) {
			System.err.println("Tarvittavien hakemistojen luominen ei onnistu.");
			System.exit(0);	
		}
		
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
