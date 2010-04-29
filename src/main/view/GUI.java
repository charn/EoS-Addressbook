package main.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.event.DocumentEvent;
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
	private JButton addPictureButton;
	
	private JTextField searchField;

	private AddressbookController controller;
	
	private JPanel tagPanel;

	private HashSet<String> selectedTags;
	private TreeMap<String, JCheckBox> checkboxes;
	
	public GUI(AddressbookController controller) {

		selectedTags = new HashSet<String>();
		checkboxes = new TreeMap<String, JCheckBox>();
		
		this.controller = controller;

		setTitle("Addressbook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Luodaan sisältö paneeli johon voidaan lisätä tavaraa
		contentPane = new JPanel(new BorderLayout());

		// Luodaan työkalupalkki ja nappulat siihen
		toolBar = new JToolBar("Still draggable");

		addButton = new JButton("Add");
		removeButton = new JButton("Remove");
		addPictureButton = new JButton("Add pic");
		searchField = new JTextField();
		
		toolBar.add(addButton);
		toolBar.add(removeButton);
		toolBar.add(addPictureButton);
		
		toolBar.add(new JLabel("Search"));
		toolBar.add(searchField);
		
		setListeners();
		
		//Lisätään työkalupalkki sisältöpaneeliin
		contentPane.add(toolBar, BorderLayout.PAGE_START);
 
		//Lisätään tägeille oma paneeli
		this.tagPanel = new JPanel(new GridLayout(0, 1));
		JScrollPane tagJScrollPane = new JScrollPane(tagPanel);

		JPanel rightside = new JPanel(new BorderLayout());

		rightside.add(new JLabel("Tags:"),BorderLayout.PAGE_START);
		rightside.add(tagJScrollPane,BorderLayout.CENTER);
		
		// Sisältöpaneeliin skrollattava ruutu, johon yhteystietotaulu
		JScrollPane leftside = new JScrollPane(initContactInfoTable());

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				leftside, rightside);
		
		splitPane.setDividerLocation(500);
		
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		setResizable(true);
		setMinimumSize(new Dimension(300, 300));
		setContentPane(contentPane);
		//
		// Set our main menu
		// 
		setJMenuBar(new MainMenuBar(this, controller));

	}
	
//	private static void addAButton(String text, Container container) {
//        JButton button = new JButton(text);
//        button.setAlignmentX(Component.CENTER_ALIGNMENT);
//        container.add(button);
//    }

	public JTable initContactInfoTable() {
		tableModel = new ContactInfoTableModel(this.controller);

		contactInfoTable = new AddressbookJTable(tableModel);
		
		contactInfoTable.setAutoCreateRowSorter(true);
		return contactInfoTable;
	}

	
	/**
	 * Asettaa kuuntelijat kaikille objekteille, joita tulee kuunnella.
	 */
	private void setListeners() {
		addButton.addActionListener(this);
		removeButton.addActionListener(this);
		addPictureButton.addActionListener(this);
		
		searchField.getDocument().addDocumentListener(new DocumentChangeListener(){
			public void onDocumentChanged(DocumentEvent e) {
				controller.fireSearchKeywordsEntered(searchField.getText());
			}
		});
	}
	
	public void updateAddressbook(List<AddressbookItem> model) {
		tableModel.updateAddressbook(model);

	}

  public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addButton) {
            controller.addItem(new AddressbookItem());
            contactInfoTable.requestFocusInWindow();
  }

		else if (e.getSource() == removeButton) {
			int selectedRow = contactInfoTable.getSelectedRow();

			int nextToBeSelected = -1;

			if (selectedRow >= 0
					&& selectedRow != contactInfoTable.getEditingRow()) {

				// Selected row is the last on the list
				if (selectedRow + 1 == contactInfoTable.getRowCount())
					nextToBeSelected = selectedRow - 1;
				else
					nextToBeSelected = selectedRow;

				int delete = contactInfoTable
						.convertRowIndexToModel(selectedRow);
				controller.removeItem(delete);

			}
			
			else if (e.getSource() == addPictureButton) {
				System.out.println("ASDF");
			}

			if (nextToBeSelected != -1)
				contactInfoTable.changeSelection(nextToBeSelected, 0, false,
						false);
		}

	}

	public void updateTags(List<String> tags) {
		tagPanel.removeAll();
		
		TreeMap<String, JCheckBox> updatedCB = new TreeMap<String, JCheckBox>();
		
		for (String tag : tags) {
			if (checkboxes.containsKey(tag)) {
				updatedCB.put(tag, checkboxes.remove(tag));
			}
			else {
				JCheckBox newCB = new JCheckBox(tag);
				
				newCB.addItemListener(new ItemListener() {

					public void itemStateChanged(ItemEvent arg0) {
						selectedCheckBoxesChanged();
					}});
				
				updatedCB.put(tag, newCB);
			}
		}
		
		for (JCheckBox cb : checkboxes.values()) {
			if (cb.isSelected()) {
				cb.doClick();
			}
		}
		
		this.checkboxes = updatedCB;

		for (JCheckBox cb : updatedCB.values()) {
			tagPanel.add(cb);
		}
		
		tagPanel.updateUI();
		
	}
	
	private void selectedCheckBoxesChanged() {
		String[] st = makeSelectedArray(); 
		controller.fireSelectedTagsChanged(st);
	}
	
	private String[] makeSelectedArray() {
		List<String> selectedList = new LinkedList<String>();
		
		for (JCheckBox cb : checkboxes.values()) {
			if (cb.isSelected()) {
				selectedList.add(cb.getText());
			}
		}
		
		String[] selectedListStrings = new String[selectedList.size()];
		
		for (int i = 0; i < selectedListStrings.length; ++i) {
			selectedListStrings[i] = selectedList.get(i);
		}
		
		return selectedListStrings;
	}

}
