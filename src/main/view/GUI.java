package main.view;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * 
 * Luokka graafisen käyttöliittymän(GUI) luomiseen.
 * 
 * http://java.sun.com/docs/books/tutorial/uiswing/components/toplevel.html
 * 
 * @author mtnauha
 *
 */
@SuppressWarnings("serial")
public class GUI extends JFrame{
	
	public GUI() {
		setTitle("Addressbook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Luodaan sisältö paneeli johon voidaan lisätä tavaraa
		Container contentPane = new Container();
		
		setResizable(false);
		setMinimumSize(new Dimension(300,300));
		setContentPane(contentPane);
		
		pack();
		setVisible(true);
		
	}

}
