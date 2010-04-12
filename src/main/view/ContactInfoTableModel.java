package main.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import main.controller.AddressbookController;
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
	AddressbookController controller;
	
	private String[] columnNames = {"First name",
									"Last name",
									"Email",
									"Phone number",
									"Address"};
	
	public ContactInfoTableModel(AddressbookController controller) {
		this.addressbookModel = new AddressbookModel();
		this.controller = controller;
	}
	
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
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		String newValue = (String) aValue;
		AddressbookItem item = addressbookModel.get(rowIndex);
		
		switch (columnIndex) {
			case 0:
				controller.fireFirstNameChanged(item, newValue);
				break;
			case 1:
				controller.fireLastNameChanged(item, newValue);
				break;
			case 2:
				controller.fireEmailChanged(item, newValue);
				break;
			case 3:
				controller.firePhoneNumberChanged(item, newValue);
				break;
			case 4:
				controller.fireAddressChanged(item, newValue);
				break;
			default:
				System.out.println("Not implemented.");
				break;
		}
	}
	
	public boolean isCellEditable(int row, int column) {
		return true;
	}
	
	public String getColumnName(int col) {
        return columnNames[col].toString();
    }

	public int getContactId(int row) {
		return addressbookModel.get(row).getId();
	}
}
