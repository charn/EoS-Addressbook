package main.view;

import javax.swing.table.AbstractTableModel;

import main.model.AddressbookItem;
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
	
	
	public ContactInfoTableModel() {
		this.addressbookModel = new AddressbookModel();
	}
	
//	public ContactInfoTableModel(AddressbookModel model){
//		this.addressbookModel = model; 
//	}
	
	public void updateAddressbook(AddressbookModel model) {
		this.addressbookModel = model;
		this.fireTableDataChanged();
	}
	
	public int getRowCount() {
		return addressbookModel.itemAmount();
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}
	
	public Object getValueAt(int row, int column) {
		AddressbookItem item = addressbookModel.get(row);
		String[] columns = new String[]{
				item.getFirstName(),
				item.getLastName(),
				item.getEmail(),
				item.getPhoneNumber(),
				item.getAddress(),
				
        };
        return columns[column];
	}
	 
	public String getColumnName(int col) {
        return columnNames[col].toString();
    }

	public int getContactId(int row) {
		return addressbookModel.get(row).getId();
	}
}
