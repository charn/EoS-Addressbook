package main.view;

import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class AddressbookJTable extends JTable {

	public AddressbookJTable(TableModel model) {
		super(model);
	}
	
	private static final long serialVersionUID = 1L;
	
	// Implement table cell tool tips.
	public String getToolTipText(MouseEvent e) {
		String tip = null;
		java.awt.Point p = e.getPoint();
		int rowIndex = rowAtPoint(p);

		tip = getValueAt(rowIndex, 0) + ", " + getValueAt(rowIndex, 1)
				+ ", " + getValueAt(rowIndex, 2) + ", "
				+ getValueAt(rowIndex, 3) + ", "
				+ getValueAt(rowIndex, 4) + ", "
				+ getValueAt(rowIndex, 5) + ", "
				+ getValueAt(rowIndex, 6);

		return tip;
	}

}
