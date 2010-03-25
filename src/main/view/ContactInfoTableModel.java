package main.view;

import javax.swing.table.AbstractTableModel;

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
	
	private String[] columnNames = {"First name",
									"Last name",
									"Email",
									"Phone number",
									"Address"};
	
	public int getRowCount() {
		return 1; //TODO
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
