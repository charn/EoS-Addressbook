/**
 *  @author toittine
 */
package main.controller;

import javax.swing.JFrame;

import java.awt.FileDialog;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ListIterator;
import main.model.AddressbookItem;

/**
 * @author toittine
 * 
 */
public class CSVFileHandler {
	JFrame jframe = null;
	String cmd = null;
	AddressbookController controller = null;

	/**
	 * @author toittine
	 */
	public CSVFileHandler(JFrame pf, String cmd,
			AddressbookController controller) {
		jframe = pf;
		this.cmd = cmd;
		this.controller = controller;

		int purpose = 0;
		if (cmd.equals("Import"))
			purpose = FileDialog.LOAD;
		else if (cmd.equals("Export"))
			purpose = FileDialog.SAVE;
		else
			return;

		FileDialog fd = new FileDialog(jframe, "EoS Addressbook " + cmd,
				purpose);
		fd.setVisible(true);
		String filename = fd.getFile();
		String directory = fd.getDirectory();
		String realname = directory + filename;

		System.out.println("filename =[" + filename + "]");
		System.out.println("directory=[" + directory + "]");
		System.out.println("realname =[" + realname + "]");

		if (cmd.equals("Import"))
			importAddressbookItems(realname);
		else if (cmd.equals("Export"))
			exportAddressbookItems(realname);
		else
			return;

	}

	/**
	 * @author toittine
	 */
	private void importAddressbookItems(String filename) {
		String[] sitems;
		String firstname = null;
		String lastname = null;
		String nickname = null;
		String email = null;
		String phonenumber = null;
		String address = null;
		String tags = null;
		String s = "";

		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));

			String line = null;
			while ((line = in.readLine()) != null) {
				System.out.println("line=[" + line + "]");
				sitems = line.split("\"");

				for (int i = 0; i < sitems.length; i++) {
					s = sitems[i];
					System.out.println(Integer.toString(i) + ":" + s);
					switch (i) {
					case 1:
						firstname = s;
						break;
					case 3:
						lastname = s;
						break;
					case 5:
						nickname = s;
						break;
					case 7:
						email = s;
						break;
					case 9:
						phonenumber = s;
						break;
					case 11:
						address = s;
						break;
					case 13:
						tags = s;
						break;
					default:
						break;
					}
				}// for
				AddressbookItem ai = new AddressbookItem(firstname, lastname,
						nickname, email, phonenumber, address, tags, "");
				controller.addItem(ai);
			}// while

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author toittine
	 */
	private void exportAddressbookItems(String filename) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filename));

			for (ListIterator<AddressbookItem> it = controller.getItems()
					.listIterator(); it.hasNext();) {
				AddressbookItem item = it.next();

				out.write("\"" + item.getFirstName() + "\",");
				out.write("\"" + item.getLastName() + "\",");
				out.write("\"" + item.getNickname() + "\",");
				out.write("\"" + item.getEmail() + "\",");
				out.write("\"" + item.getPhoneNumber() + "\",");
				out.write("\"" + item.getAddress() + "\",");
				out.write("\"" + item.getTags() + "\"");
				out.write('\n');
			}// for

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
	}

}
