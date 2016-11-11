package com.basak.payel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang.ArrayUtils;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class NLPProcessor {
	public static void processTags(String[] tags, String[] tokens) {
		NLPAnalyzer analyzer = new NLPAnalyzer();
		analyzer.analyze(tags, tokens);
		if(!analyzer.found)
			System.out.println("No inconsistencies detected.");
		System.out.println();
	}
	public static void processFile(String fileName) {
		InputStream modelIn = null;
		String sentences[] = null;
		String tokens[] = null;
		String tags[] = null;
		try {
			String fileStrings[] = NLPHelper.readFileToString(fileName);
			for(int i = 0; i < fileStrings.length;i++) {
				System.out.println("Analyzing Requirement "+ (i + 1) + ":");
				sentences = NLPProcessor.getSentences(fileStrings[i]);
				String tempTokens[];
				tokens = null;
				for (int j = 0; j < sentences.length; j++) {
					tempTokens =NLPProcessor.getTokens(sentences[j]);
					tokens = (String[]) ArrayUtils.addAll(tokens, tempTokens);
				}
				tags = NLPProcessor.getPOS(tokens);
				processTags(tags, tokens);
			}
			System.out.println("Analyzing Completed.");
		} catch (IOException e) {
			// Model loading failed, handle the error
			e.printStackTrace();
		} finally {
			if (modelIn != null) {
				try {
					modelIn.close();
				} catch (IOException e) {
				}
			}
		}

	}
	public static String[] getSentences(String fileString) throws IOException {
		InputStream modelIn = null;
		String sentences[] = null;
		SentenceModel modelSM = null;
		
		modelIn = new FileInputStream("models" + File.separator + "en-sent.bin");
		modelSM = new SentenceModel(modelIn);
		SentenceDetectorME sentenceDetector = new SentenceDetectorME(modelSM);
		sentences = sentenceDetector.sentDetect(fileString);
		/*
		for (int i = 0; i < sentences.length; i++)
			System.out.print(sentences[i] + "\t");
		System.out.println();
		*/
		return sentences;
	}
	public static String[] getTokens(String sentence) throws IOException {
		InputStream modelIn = null;
		String tokens[] = null;
		TokenizerModel modelTM = null;
		modelIn = new FileInputStream("models" + File.separator + "en-token.bin");
		modelTM = new TokenizerModel(modelIn);
		Tokenizer tokenizer = new TokenizerME(modelTM);
		tokens = tokenizer.tokenize(sentence);
		/*
		for (int j = 0; j < tokens.length; j++)
			System.out.print(tokens[j] + "\t");
		System.out.println();
		*/
		return tokens;
	}
	public static String[] getPOS(String[] tokens) throws IOException {
		InputStream modelIn = null;
		POSModel modelPM = null;
		String tags[] = null;
		modelIn = new FileInputStream("models" + File.separator + "en-pos-maxent.bin");
		modelPM = new POSModel(modelIn);
		POSTaggerME tagger = new POSTaggerME(modelPM);
		tags = tagger.tag(tokens);
		/*
		for (int i = 0; i < tags.length; i++)
			System.out.print(tags[i] + "\t");
		System.out.println();
		*/
		return tags;
	}
}
