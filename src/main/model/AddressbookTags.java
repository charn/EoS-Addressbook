package main.model;

import java.util.TreeSet;
import java.util.regex.Pattern;

public class AddressbookTags {

	private TreeSet tags;
	
	// Pilkut ja välilyönnit erottimina
	private static final Pattern STRINGSPLITPATTERN = Pattern.compile("[,\\s]+");

	public AddressbookTags() {
		this.tags = new TreeSet<String>();
	}
}
