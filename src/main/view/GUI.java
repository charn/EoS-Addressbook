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
	    setJMenuBar(new MainMenuBar(this, controller));
		
	}
	
	public JTable initContactInfoTable(){
		tableModel = new ContactInfoTableModel(this.controller);	
		
		contactInfoTable = new JTable(tableModel);
		
		contactInfoTable.setAutoCreateRowSorter(true);
		
		return contactInfoTable;
	}
	
	public void updateAddressbook(List<AddressbookItem> model) {
		tableModel.updateAddressbook(model);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == addButton) {
			//AddDialog dialog = new AddDialog(this, controller);
			//dialog.pack();
			//                     
			//dialog.setLocationRelativeTo(this);
			//dialog.setVisible(true);

            controller.addItem(new AddressbookItem());
//            int addedRow = contactInfoTable.convertRowIndexToModel(tableModel.getRowCount() - 1);

//            System.out.println(addedRow);
            
//            contactInfoTable.changeSelection(addedRow, 0, true, false);	
//            contactInfoTable.editCellAt(addedRow, 0);
            contactInfoTable.requestFocusInWindow();
		}
		
		else if(e.getSource() == removeButton) {
			int selectedRow = contactInfoTable.getSelectedRow();
			
			int nextToBeSelected = -1;
			
			if(selectedRow >= 0 && selectedRow != contactInfoTable.getEditingRow()) {
				
				// Selected row is the last on the list
				if(selectedRow + 1 == contactInfoTable.getRowCount())
					nextToBeSelected = selectedRow - 1;
				else
					nextToBeSelected = selectedRow;
				
				int delete = contactInfoTable.convertRowIndexToModel(selectedRow);
				controller.removeItem(delete);
				
			}

			if(nextToBeSelected != -1)
				contactInfoTable.changeSelection(nextToBeSelected, 0, false, false);	
		}
		
	}

}
