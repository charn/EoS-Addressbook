package main.controller;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import main.model.AddressbookItem;

public class AddressbookSaver {

	public static void saveAddressbookItemListToFile(List<AddressbookItem> itemList, String fileName){
	    
		//serialize the list
		try {
			OutputStream file = new FileOutputStream( fileName );
			OutputStream buffer = new BufferedOutputStream( file );
			ObjectOutput output = new ObjectOutputStream( buffer );
			try {
				output.writeObject(itemList);
			}
			finally {
				output.close();
			}
	    }  
	    catch (IOException ex){
	    	System.err.println("Cannot perform output. " + ex);
	    }
	}
	
	/**
	 * return null if something went wrong
	 */
	public static List<AddressbookItem> openAddressbookItemListFromFile(String fileName){
	   
		//deserialize the list
		try{
			InputStream file = new FileInputStream( fileName );
			InputStream buffer = new BufferedInputStream( file );
			ObjectInput input = new ObjectInputStream ( buffer );
			try{
				List<AddressbookItem> recoveredItemList = (List<AddressbookItem>)input.readObject();
				return recoveredItemList;
			}
			finally{
				input.close();
			}
	    }
	    catch(ClassNotFoundException ex){
	    	System.err.println("Cannot perform input. Class not found. " + ex);
	    }
	    catch(IOException ex){
	    	System.err.println("Cannot perform input. " + ex);
	    }
	    
	    return null;
	}

}
