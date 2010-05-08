package main.view;

import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JTable;

public class AddressbookJTable extends JTable {

	ContactInfoTableModel model;

	public AddressbookJTable(ContactInfoTableModel model) {
		super(model);

		this.model = model;
	}

	private static final long serialVersionUID = 1L;

	// Implement table cell tool tips.
	public String getToolTipText(MouseEvent e) {
		String tip = null;
		java.awt.Point p = e.getPoint();
		int rowIndex = rowAtPoint(p);
		File imageFile = null;

		try {
			imageFile = new File("data/img/" + model.getImageAt(rowIndex));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (imageFile.exists()) {

			tip = "<html><img src=" + imageFile.toURI()
					+ " border=1 width=45 height=45><br/>"
					+ getValueAt(rowIndex, 0) + "<br/>"
					+ getValueAt(rowIndex, 1) + "<br/>"
					+ getValueAt(rowIndex, 2) + "<br/>"
					+ getValueAt(rowIndex, 3) + "<br/>"
					+ getValueAt(rowIndex, 4) + "<br/>"
					+ getValueAt(rowIndex, 5) + "<br/>"
					+ getValueAt(rowIndex, 6) + "</html>";

		}

		else {

			tip = "<html>" + getValueAt(rowIndex, 0) + "<br/>"
					+ getValueAt(rowIndex, 1) + "<br/>"
					+ getValueAt(rowIndex, 2) + "<br/>"
					+ getValueAt(rowIndex, 3) + "<br/>"
					+ getValueAt(rowIndex, 4) + "<br/>"
					+ getValueAt(rowIndex, 5) + "<br/>"
					+ getValueAt(rowIndex, 6) + "</html>";

		}

		return tip;
	}

}
