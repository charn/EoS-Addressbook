package main.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

import main.controller.AddressbookController;
import main.model.AddressbookItem;

/**
 * 
 * Luokka graafisen käyttöliittymän(GUI) luomiseen.
 * 
 * http://java.sun.com/docs/books/tutorial/uiswing/components/toplevel.html
 * 
 * @author mtnauha
 *
 */

public class GUI extends JFrame implements AddressbookView, ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JTable contactInfoTable;
	private ContactInfoTableModel tableModel;
	
	private JToolBar toolBar;
	
	private JPanel contentPane;
	
	private JButton addButton;
	private JButton removeButton;

	
	private AddressbookController controller;
	
	public GUI(AddressbookController controller) {
		
		this.controller = controller;
		
		setTitle("Addressbook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Luodaan sisältö paneeli johon voidaan lisätä tavaraa
		contentPane = new JPanel(new BorderLayout());
		
		//Luodaan työkalupalkki ja nappulat siihen
		toolBar = new JToolBar("Still draggable");
		
		addButton = new JButton("Add");
		removeButton = new JButton("Remove");
		
		addButton.addActionListener(this);
		removeButton.addActionListener(this);

		
		toolBar.add(addButton);
		toolBar.add(removeButton);
		
		//Lisätään työkalupalkki sisältöpaneeliin
		contentPane.add(toolBar, BorderLayout.PAGE_START);
		
		//Sisältöpaneeliin skrollattava ruutu, johon yhteystietotaulu
		JScrollPane scrollPane = new JScrollPane(initContactInfoTable());
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		setResizable(true);
		setMinimumSize(new Dimension(300,300));
		setContentPane(contentPane);
		//
		// Set our main menu
		// 
	    setJMenuBar(new MainMenuBar(this));
		
	}
	
	public JTable initContactInfoTable(){
		tableModel = new ContactInfoTableModel(this.controller);
		contactInfoTable = new JTable(tableModel);
		return contactInfoTable;
	}
	
	public void updateAddressbook(List<AddressbookItem> model) {
		tableModel.updateAddressbook(model);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == addButton) {
			AddDialog dialog = new AddDialog(this, controller);
			dialog.pack();
			
			dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
		}
		
		else if(e.getSource() == removeButton) {
			int selectedRow = contactInfoTable.getSelectedRow();
			
			if(selectedRow >= 0)
				controller.removeItem(selectedRow);
		}
		
	}

}
