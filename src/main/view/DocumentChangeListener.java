package main.view;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public abstract class DocumentChangeListener implements DocumentListener {
	public void changedUpdate(DocumentEvent e) {
		onDocumentChanged(e);
	}
	public void insertUpdate(DocumentEvent e) {
		onDocumentChanged(e);
	}
	public void removeUpdate(DocumentEvent e) {
		onDocumentChanged(e);
	}
	public abstract void onDocumentChanged(DocumentEvent e);
}
