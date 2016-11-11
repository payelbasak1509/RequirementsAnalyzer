package com.basak.payel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class NLPHelper {
	public static void printHeading(String text){
		System.out.println(text);
		for(int i = 0; i < text.length();i++)
			System.out.print("=");
		System.out.println();
	}
	public static void printText(String[] text, Set<Integer> indexes){
		for(int i = 0; i < text.length;i++) {
			if(text[i].equals(".") || text[i].equals(",") || i == 0)
				if(indexes.contains(i))
					System.out.print("[" + text[i] + "]");
				else
					System.out.print(text[i]);
			else
				if(indexes.contains(i))
					System.out.print(" [" + text[i] + "]");
				else
					System.out.print(" " + text[i]);
		}
		System.out.println();
	}
	public static String[] readFileToString(String filename) throws IOException {
		File dirs = new File(".");
		String filePath = dirs.getCanonicalPath() + File.separator + "dataset"
				+ File.separator + filename;

		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String eachString = new String();
		int count = 0;
		eachString = reader.readLine();
		while (eachString != null) {
			count++;
			eachString = reader.readLine();
		}
		String returnStr[] = new String[count];
		reader = new BufferedReader(new FileReader(filePath));
		count = 0;
		eachString = reader.readLine();
		while (eachString != null) {
			returnStr[count]  = eachString;
			eachString = reader.readLine();
			count++;
		}
		reader.close();
		return returnStr;
	}
}
