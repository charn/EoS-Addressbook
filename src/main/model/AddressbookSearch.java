package main.model;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class AddressbookSearch {

	// Pilkut ja välilyönnit erottimina
	private static final Pattern STRINGSPLITPATTERN = Pattern.compile("[,\\s]+");
	
	/**
	 * Etsii annetusta listasta hakuehtoja vastaavat alkiot.
	 * @param items Lista josta etsitään hakuehtoja vastaavia alkioita.
	 * @param query Hakuehdot erotellaan tästä pilkun ja välilyönnin mukaan.
	 * @return Palauttaa listan, joka sisältää hakuehtoja vastaavat alkiot.
	 */
	public static List<AddressbookItem> searchWithKeywords(List<AddressbookItem> items, String query) {
		String queryStrings[] = splitStringWithPattern(query);
		List<AddressbookItem> searchResult = new LinkedList<AddressbookItem>();

		for (AddressbookItem item : items) {
			if (matchesKeywords(item, queryStrings)) {
				searchResult.add(item);
			}
		}

		return searchResult;
	}
	
	public static List<AddressbookItem> searchWithTags(List<AddressbookItem> items, String[] tags) {
		List<AddressbookItem> tagSearchResult = new LinkedList<AddressbookItem>();
		
		for (AddressbookItem item : items) {
			if(matchesTags(item, tags)) {
				tagSearchResult.add(item);
			}
		}
		return tagSearchResult;
	}
	
	private static String[] splitStringWithPattern(String query) {
		return STRINGSPLITPATTERN.split(query);
	}
	
	private static boolean matchesKeywords(AddressbookItem item, String[] keywords) {
		String[] needles = stringArrayToLowerCase(keywords);
		
		String[] haystack = new String[] {
				item.getFirstName(),
				item.getLastName(),
				item.getEmail(),
				item.getNickname(),
				item.getPhoneNumber(),
				item.getAddress(),
				item.getTags()
		};
		
		haystack = stringArrayToLowerCase(haystack);
	
		for (String needle : needles) {
			if (contains(haystack,needle) == false) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean matchesTags(AddressbookItem item, String[] tags) {
		String[] needles = stringArrayToLowerCase(tags);
		
		String[] haystack = splitStringWithPattern(item.getTags());
		haystack = stringArrayToLowerCase(haystack);
	
		for (String needle : needles) {
			if (equals(haystack,needle) == false) {
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
	
	private static boolean equals(String[] haystack, String needle) {
		for (String s : haystack) {
			if (s.equals(needle)) {
				return true;
			}
		}
		return false;
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
