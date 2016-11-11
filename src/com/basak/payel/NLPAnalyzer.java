package com.basak.payel;

import java.util.HashSet;
import java.util.Set;

public class NLPAnalyzer {
	public boolean found;
	public Set<Integer> indexes;
	public NLPAnalyzer() {
		indexes = new HashSet<Integer>();
	}
	public boolean analyze(String[] tags, String[] tokens) {
		found = false;
		checkAdjectives(tags, tokens);
		checkKeywords(tags, tokens);
		if(found)
			NLPHelper.printText(tokens, indexes);
		return found;
	}
	public void checkAdjectives(String[] tags, String[] tokens) {
		boolean foundJJ = false;
		boolean foundJJR = false;
		boolean foundJJS = false;
		for(int i = 0; i < tags.length; i++) {
			if(tags[i].equals("JJ") && !tokens[i].equalsIgnoreCase("able")) {
				if(!foundJJ)
					System.out.println("Adjective found. Please check for completeness.");
				indexes.add(i);
				found = true;
				foundJJ = true;
			}
			if(tags[i].equals("JJR")) {
				if(!foundJJR)
					System.out.println("Comparitive Adjective found. Please check for completeness.");
				indexes.add(i);
				found = true;
				foundJJR = true;
			}
			if(tags[i].equals("JJS")) {
				if(!foundJJS)
					System.out.println("Superlative Adjective found. Please check for completeness.");
				indexes.add(i);
				found = true;
				foundJJS = true;
			}
		}
	}
	public void checkKeywords(String[] tags, String[] tokens) {
		boolean foundKey1 = false;
		boolean foundKey2 = false;
		for(int i = 0; i < tags.length; i++) {
			if(tokens[i].equalsIgnoreCase("it")) {
				if(!foundKey1)
					System.out.println("suspective keyword found. Please check for referential ambiguity.");
				indexes.add(i);
				found = true;
				foundKey1 = true;
			}
			if(tokens[i].equalsIgnoreCase("but")) {
				if(!foundKey2)
					System.out.println("suspective keyword found. Please check for completeness.");
				indexes.add(i);
				found = true;
				foundKey2 = true;
			}
		}
	}
}
