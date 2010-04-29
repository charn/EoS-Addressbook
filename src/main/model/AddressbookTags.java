package main.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class AddressbookTags {

	private TreeSet<String> tags;
	
	// Pilkut ja välilyönnit erottimina
	private static final Pattern STRINGSPLITPATTERN = Pattern.compile("[,\\s]+");

	public AddressbookTags() {
		this.tags = new TreeSet<String>();
	}
	
	public int size() {
		return this.tags.size();
	}
	
	public void updateTagsFromItems(List<AddressbookItem> items) {
		
		tags.clear();
		
		for(AddressbookItem item : items) {
			updateTagsFromItem(item);
		}
	}
	
	public void updateTagsFromItem(AddressbookItem item) {
		String[] tags = splitStringWithPattern(item.getTags());
		for (String tag : tags) {
			if (tag != null && !tag.equals("")) {
				this.tags.add(tag);
			}
		}
	}
	
	private static String[] splitStringWithPattern(String s) {
		return STRINGSPLITPATTERN.split(s);
	}
	
	public boolean contains(String tag) {
		return tags.contains(tag);
	}
	
	public List<String> getTagsList() {
		
		List<String> tagsList = new LinkedList<String>();
		
		for (Iterator<String> i = this.tags.iterator(); i.hasNext();) {
			tagsList.add(i.next());
		}
		return tagsList;
	}
}
