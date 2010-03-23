package main;

import main.view.GUI;

/**
 * Main class.
 *
 */
public class Addressbook {

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GUI();
	            }
	        });
	    }

}
