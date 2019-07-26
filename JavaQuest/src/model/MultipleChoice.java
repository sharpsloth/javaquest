package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * class MultipleChoice extends Question implements Serializable
 */
public class MultipleChoice extends Question implements Serializable{

	private ArrayList<String> answerChoices;
	private int correctAnswer;
	private int maxAnswers;
	

	/**
	 * MultipleChoice()
	 * no-arg constructor
	 */
	public MultipleChoice() {
		this.answerChoices = new ArrayList<String>();
		this.correctAnswer = -1;
		this.maxAnswers = 4;
	}

	/**
	 * MultipleChoice(
	 * int chapter, 
	 * int questionNumber, 
	 * String questionText, 
	 * int userAnswer, 
	 * int wasUserAnswerCorrect, 
	 * ArrayList<String> answerChoices, 
	 * int correctAnswer)
	 */
public MultipleChoice(int chapter, int questionNumber, String questionText, int userAnswer, int wasUserAnswerCorrect, ArrayList<String> answerChoices, int correctAnswer) {
	super(chapter, questionNumber, questionText, userAnswer, wasUserAnswerCorrect);
	this.answerChoices = answerChoices;
	this.correctAnswer = correctAnswer;		
	this.maxAnswers = 4;
	}

/**
 * ArrayList<String> getAnswerChoices()
 * returns answer options
 */
public ArrayList<String> getAnswerChoices(){
	return this.answerChoices;
}

/**
 * getCorrectAnswer()
 * returns correctAnswer
 */
@Override
public int getCorrectAnswer() {
	return this.correctAnswer;
}

/**
 * checkAnswer(int userInput)
 * returns true or false
 */
@Override
public boolean checkAnswer(int userInput) {
	if(this.getUserAnswer() == this.getCorrectAnswer()) {
		return true;
	} else return false;
}

}
