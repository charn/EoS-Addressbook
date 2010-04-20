package main.model;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class AddressbookSearch {

	// Pilkut ja välilyönnit erottimina
	private static final Pattern QUERYSPLITPATTERN = Pattern.compile("[,\\s]+");
	
	
	public static List<AddressbookItem> search(List<AddressbookItem> items, String query) {
		String queryStrings[] = splitQuery(query);
		List<AddressbookItem> searchResult = new LinkedList<AddressbookItem>();
		
		for (AddressbookItem item : items) {
			if (matchesKeywords(item,queryStrings)) {
				searchResult.add(item);
			}
		}
		
		return searchResult;
	}
	
	private static String[] splitQuery(String query) {
		return QUERYSPLITPATTERN.split(query);
	}
	
	private static boolean matchesKeywords(AddressbookItem item, String[] keywords) {
		String[] needles = stringArrayToLowerCase(keywords);
		String[] haystack = new String[] {
				item.getFirstName(),
				item.getLastName(),
				item.getEmail(),
				item.getNickname(),
				item.getPhoneNumber(),
				item.getAddress()
		};
		haystack = stringArrayToLowerCase(haystack);
	
		for (String needle : needles) {
			if (contains(haystack,needle) == false) {
				return false;
			}
		}
		return true;
	}
	
	private static String[] stringArrayToLowerCase(String[] array) {
		String[] newArray = new String[array.length];
		for (int i = 0; i < array.length; ++i)
			newArray[i] = array[i].toLowerCase();
		return newArray;
	}
	
	private static boolean contains(String[] haystack, String needle) {
		for (String s : haystack) {
			if (s.contains(needle)) {
				return true;
			}
		}
		return false;
	}
}
