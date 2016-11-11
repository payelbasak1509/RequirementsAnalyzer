package com.basak.payel;

public class NLPExecutive {

	public static void main(String[] args) {
		NLPHelper.printHeading("Analyzing requirements for Collection Manager");
		NLPProcessor.processFile("Collection Manager.txt");
		NLPHelper.printHeading("Analyzing requirements for Depositor");
		NLPProcessor.processFile("Depositor.txt");
		/*NLPHelper.printHeading("Analyzing requirements for Digital Archivist");
		NLPProcessor.processFile("Digital Archivist.txt");
		NLPHelper.printHeading("Analyzing requirements for Metadata Specialist");
		NLPProcessor.processFile("Metadata Specialist.txt");
		NLPHelper.printHeading("Analyzing requirements for Repository Manager");
		NLPProcessor.processFile("Repository Manager.txt");
		NLPHelper.printHeading("Analyzing requirements for Repository User");
		NLPProcessor.processFile("Repository User.txt");
		NLPHelper.printHeading("Analyzing requirements for Visual Resource Librarian");
		NLPProcessor.processFile("Visual Resource Librarian.txt");*/

	}

}