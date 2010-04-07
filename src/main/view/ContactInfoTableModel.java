package main.view;

import javax.swing.table.AbstractTableModel;

import main.model.AddressbookModel;

/**
 * 
 * Käyttöliittymän yhteystietotaulun ja varsinaisen yhteystietodatan välissä oleva malli.
 * Tämän avulla taulu pääsee käsiksi varsinaiseen dataan.
 * 
 * http://java.sun.com/docs/books/tutorial/uiswing/components/table.html#data
 *
 */
public class ContactInfoTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private AddressbookModel addressbookModel;
	private String[] columnNames = {"First name",
									"Last name",
									"Email",
									"Phone number",
									"Address"};
	
	public ContactInfoTableModel(AddressbookModel model){
		this.addressbookModel = model; 
	}
	
	public int getRowCount() {
		return addressbookModel.itemAmount() + 1;
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}
	
	public Object getValueAt(int row, int column) {
		return null; //TODO
	}
	 
	public String getColumnName(int col) {
        return columnNames[col].toString();
    }

}
