package regextool;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChecker {

	
	public boolean checkWords(String pattern, List<Word> goodWords, List<Word> badWords) {
		Pattern p = Pattern.compile(pattern);
		
		boolean retVal = true;
		if(checkList(goodWords, p) < goodWords.size()) {
			retVal = false;
		}
		if(checkList(badWords, p) > 0) {
			retVal = false;
		}
		
		return retVal;
	}

	private int checkList(List<Word> list, Pattern p) {
		int numberFind = 0;
		for(Word word : list) {
			Matcher matcher = p.matcher(word.getWord());
			try {
				if(matcher.find()) {
					int start = matcher.start();
					int end = matcher.end();

					//set words array in class Word
					boolean [] words = word.getIsMatched();
					for(int i = start; i < end; i++) {
						words[i] = true;
					}
					word.setIsMatched(words);
					if(start == 0 && end == word.getWord().length()) {
						numberFind++;
					}
				}
				
			} catch (Exception e) {
				System.out.println("There was no match for word " + word.getWord() + " with the pattern " + p);
			}
		}
		return numberFind;
	}
	
}
