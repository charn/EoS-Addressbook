package main.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.model.AddressbookModel;

/**
 * 
 * Luokka graafisen käyttöliittymän(GUI) luomiseen.
 * 
 * http://java.sun.com/docs/books/tutorial/uiswing/components/toplevel.html
 * 
 * @author mtnauha
 *
 */

public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JTable contactInfoTable;
	private ContactInfoTableModel tableModel;
	
	public GUI() {
		setTitle("Addressbook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Luodaan sisältö paneeli johon voidaan lisätä tavaraa
		JPanel contentPane = new JPanel(new BorderLayout());
		
		//Sisältöpaneeliin skrollattava ruutu, johon yhteystietotaulu
		JScrollPane scrollPane = new JScrollPane(initContactInfoTable());
		contentPane.add(scrollPane);
		
		setResizable(true);
		setMinimumSize(new Dimension(300,300));
		setContentPane(contentPane);
		//
		// Set our main menu
		// 
	    setJMenuBar(new MainMenuBar(this));
	    
		pack();
		setVisible(true);
		
	}
	
	public JTable initContactInfoTable(){
		tableModel = new ContactInfoTableModel(new AddressbookModel()); //new AddressbookModel() pitää korvata varsinaisella modelilla 
		contactInfoTable = new JTable(tableModel);
		return contactInfoTable;
	}

}
