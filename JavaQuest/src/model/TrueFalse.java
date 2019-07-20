package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * class TrueFalse extends Question implements Serializable
 */
public class TrueFalse extends Question implements Serializable{

	/**
	 * correctAnswer
	 */
	private boolean correctAnswer;
	

	/**
	 * TrueFalse()
	 */
	public TrueFalse() {
		this.correctAnswer = false;
	}

	/**
	 * TrueFalse(
	 * int chapter, 
	 * int questionNumber, 
	 * String questionText, 
	 * int userAnswer, 
	 * int wasUserAnswerCorrect, 
	 * boolean correctAnswer
	 * ) 
	 * super(
	 * chapter, 
	 * questionNumber, 
	 * questionText, 
	 * serAnswer,
	 * wasUserAnswerCorrect);
	 */
public TrueFalse(int chapter, int questionNumber, String questionText, int userAnswer, int wasUserAnswerCorrect, boolean correctAnswer) {
	super(chapter, questionNumber, questionText, userAnswer, wasUserAnswerCorrect);
	this.correctAnswer = correctAnswer;	
	}

/**
 * ArrayList<String> getAnswerChoices()
 */
public ArrayList<String> getAnswerChoices(){
	ArrayList<String> answers = new ArrayList<String>();
	answers.add("false");
	answers.add("true");
	return answers;
}

/**
 * getCorrectAnswer()
 * Overrides
 * return 1 or 0
 */
@Override
public int getCorrectAnswer() {
	if (this.correctAnswer == false) {
		return 0;
	}else return 1;
}

/**
 * checkAnswer(int userInput)
 * Overrides
 * return boolean
 */
@Override
public boolean checkAnswer(int userInput) {
	if(this.getUserAnswer() == this.getCorrectAnswer()) {
		return true;
	} else return false;
}

}
