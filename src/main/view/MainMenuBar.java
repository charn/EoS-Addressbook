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

/**
 * @author toittine
 *
 */

public class MainMenuBar extends JMenuBar
{
	
	private static final long serialVersionUID = 1L;
	private AddressbookController controller;
	
	JFrame parent = null;
 	  String[] fileItems = new String[] { "New", "Open", "Save", "Exit" };
	  String[] editItems = new String[] { "Undo", "Cut", "Copy", "Paste" };
	  char[] fileShortcuts = { 'N', 'O', 'S', 'X' };
	  char[] editShortcuts = { 'Z', 'X', 'C', 'V' };

	/**
	 * 
	 */
	public MainMenuBar(JFrame pf, final AddressbookController controller)
	{
		this.controller = controller;
		
	    JMenu fileMenu = new JMenu("File");
	    JMenu editMenu = new JMenu("Edit");

	    parent = pf;
	    
	    //  Assemble the File menus with mnemonics
	    ActionListener printListener = new ActionListener() 
	    {
	      public void actionPerformed(ActionEvent event) 
	      {
	    	String cmd = event.getActionCommand();
	    	if (cmd.equals("Save"))
	    		controller.saveModelToFile();
	        System.out.println("Menu item [" + cmd + "] was pressed.");
	        if (cmd.equals ("Exit")) 
	        	System.exit(0);
	      }
	    };
	    for (int i = 0; i < fileItems.length; i++) 
	    {
	      JMenuItem item = new JMenuItem(fileItems[i], fileShortcuts[i]);
	      item.addActionListener(printListener);
	      fileMenu.add(item);
	    }//for
	    //  Insert a separator in the Edit Menu in Position 1 after "Undo"
	    editMenu.insertSeparator(1);
	    //  Finally, add all the menus to the menu bar
	    add(fileMenu);
	    add(editMenu);
	}//MainMenuBar

}
