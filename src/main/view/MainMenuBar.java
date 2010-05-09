/**
 * 
 */
package main.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import main.controller.AddressbookController;
import main.controller.CSVFileHandler;

/**
 * @author toittine
 * 
 */

public class MainMenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private AddressbookController controller;

	JFrame parent = null;
	String[] fileItems = new String[] { "Save", "Exit" };
	String[] editItems = new String[] { "Import", "Export" };
	char[] fileShortcuts = { 'N', 'O', 'S', 'X' };
	char[] editShortcuts = { 'I', 'E' };

	/**
	 * 
	 */
	public MainMenuBar(JFrame pf, final AddressbookController controller) {
		this.controller = controller;

		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Items");

		parent = pf;

		// Assemble the File menus with mnemonics
		ActionListener printListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String cmd = event.getActionCommand();

				System.out.println("Menu item [" + cmd + "] was pressed.");

				if (cmd.equals("Save"))
					controller.saveModelToFile();
				else if (cmd.equals("Exit"))
					System.exit(0);
				else if (cmd.equals("Import"))
					new CSVFileHandler(parent, cmd, controller);
				else if (cmd.equals("Export"))
					new CSVFileHandler(parent, cmd, controller);
			}
		};
		for (int i = 0; i < fileItems.length; i++) {
			JMenuItem item = new JMenuItem(fileItems[i], fileShortcuts[i]);
			item.addActionListener(printListener);
			fileMenu.add(item);
		}// for
		for (int i = 0; i < editItems.length; i++) {
			JMenuItem item = new JMenuItem(editItems[i], editShortcuts[i]);
			item.addActionListener(printListener);
			editMenu.add(item);
		}// for
		// Insert a separator in the File Menu in Position 1 after "Save"
		fileMenu.insertSeparator(1);
		// Finally, add all the menus to the menu bar
		add(fileMenu);
		add(editMenu);

	}// MainMenuBar

}
