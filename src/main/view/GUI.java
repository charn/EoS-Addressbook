package main.view;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
	
	private JTable contactInfoTable;
	private ContactInfoTableModel tableModel;
	
	public GUI() {
		setTitle("Addressbook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Luodaan sisältö paneeli johon voidaan lisätä tavaraa
		JPanel contentPane = new JPanel();
		
		//Sisältöpaneeliin skrollattava ruutu, johon yhteystietotaulu
		JScrollPane scrollPane = new JScrollPane(initContactInfoTable());
		contentPane.add(scrollPane);
		
		setResizable(true);
		setMinimumSize(new Dimension(300,300));
		setContentPane(contentPane);
		
		pack();
		setVisible(true);
		
	}
	
	public JTable initContactInfoTable(){
		tableModel = new ContactInfoTableModel();
		contactInfoTable = new JTable(tableModel);
		return contactInfoTable;
	}

}
