package main.view;

import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JTextField;

import main.controller.AddressbookController;
import main.model.AddressbookItem;

import java.beans.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")

/*
 * HUOM! Tästä luokasta puuttuu nickname-kenttään liittyvät jutut. Jos tämä luokka otetaan
 * taas käyttöön niin ne pitäisi lisätä. 
 */
class AddDialog extends JDialog implements ActionListener,
		PropertyChangeListener {

	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JTextField phoneNumberTextField;
	private JTextField addressTextField;

	private JOptionPane optionPane;

	private String buttonEnter = "Enter";
	private String buttonCancel = "Cancel";
	
	private AddressbookController controller;


	/** Creates the reusable dialog. */
	public AddDialog(Frame aFrame, AddressbookController controller) {
		super(aFrame, true);
		
		this.controller = controller;

		setTitle("Add new address item");

		firstNameTextField = new JTextField(15);
		lastNameTextField = new JTextField(15);
		emailTextField = new JTextField(15);
		phoneNumberTextField = new JTextField(15);
		addressTextField = new JTextField(15);

		// Create an array of the text and components to be displayed.
		String msgString1 = "First name";
		String msgString2 = "Last name";
		String msgString3 = "E-mail";
		String msgString4 = "Phonenumber";
		String msgString5 = "Address";

		Object[] array = { msgString1, firstNameTextField, msgString2,
				lastNameTextField, msgString3, emailTextField, msgString4,
				phoneNumberTextField, msgString5, addressTextField };

		// Create an array specifying the number of dialog buttons
		// and their text.
		Object[] options = { buttonEnter, buttonCancel };

		// Create the JOptionPane.
		optionPane = new JOptionPane(array, JOptionPane.QUESTION_MESSAGE,
				JOptionPane.YES_NO_OPTION, null, options, options[0]);

		// Make this dialog display it.
		setContentPane(optionPane);

		// Handle window closing correctly.
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				/*
				 * Instead of directly closing the window, we're going to change
				 * the JOptionPane's value property.
				 */
				optionPane.setValue(new Integer(JOptionPane.CLOSED_OPTION));
			}
		});

		// Ensure the text field always gets the first focus.
		addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent ce) {
				firstNameTextField.requestFocusInWindow();
			}
		});

		// Register an event handler that puts the text into the option pane.
		firstNameTextField.addActionListener(this);

		// Register an event handler that reacts to option pane state changes.
		optionPane.addPropertyChangeListener(this);
	}

	/** This method handles events for the text field. */
	public void actionPerformed(ActionEvent e) {
		optionPane.setValue(buttonEnter);
	}

	/** This method reacts to state changes in the option pane. */
	public void propertyChange(PropertyChangeEvent e) {
		String prop = e.getPropertyName();

		if (isVisible()
				&& (e.getSource() == optionPane)
				&& (JOptionPane.VALUE_PROPERTY.equals(prop) || JOptionPane.INPUT_VALUE_PROPERTY
						.equals(prop))) {
			Object value = optionPane.getValue();

			if (value == JOptionPane.UNINITIALIZED_VALUE) {
				// ignore reset
				return;
			}

			// Reset the JOptionPane's value.
			// If you don't do this, then if the user
			// presses the same button next time, no
			// property change event will be fired.
			optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);

			if (buttonEnter.equals(value)) {
				controller.addItem(new AddressbookItem(firstNameTextField
						.getText(), lastNameTextField.getText(), "", emailTextField.getText(), phoneNumberTextField.getText(),
						addressTextField.getText()));
				
				clearAndHide();

			} else { // user closed dialog or clicked cancel
				clearAndHide();
			}
		}
	}

	/** This method clears the dialog and hides it. */
	public void clearAndHide() {
		firstNameTextField.setText(null);
		lastNameTextField.setText(null);
		emailTextField.setText(null);
		phoneNumberTextField.setText(null);
		addressTextField.setText(null);
		
		setVisible(false);
	}
}
