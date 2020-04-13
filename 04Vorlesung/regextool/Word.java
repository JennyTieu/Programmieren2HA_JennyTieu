package regextool;

import java.io.Serializable;

public class Word implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String word;
	private boolean [] isMatched;
	
	public Word(String word) {
		super();
		this.word = word;
		init();
	}

	public void init() {
		isMatched = new boolean[word.length()];
		for(int i = 0; i < isMatched.length; i++) {
			isMatched[i] = false;
		}
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
		init();
	}

	public boolean[] getIsMatched() {
		return isMatched;
	}

	public void setIsMatched(boolean[] isMatched) {
		this.isMatched = isMatched;
	} 
	
}
