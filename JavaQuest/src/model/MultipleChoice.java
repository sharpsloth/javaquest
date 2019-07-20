package model;

import java.io.Serializable;
import java.util.ArrayList;

public class MultipleChoice extends Question implements Serializable{

	private ArrayList<String> answerChoices;
	private int correctAnswer;
	
	
	public MultipleChoice() {
		this.answerChoices = new ArrayList<String>();
		this.correctAnswer = -1;
	}

public MultipleChoice(int chapter, int questionNumber, String questionText, int userAnswer, int wasUserAnswerCorrect, ArrayList<String> answerChoices, int correctAnswer) {
	super(chapter, questionNumber, questionText, userAnswer, wasUserAnswerCorrect);
	this.answerChoices = answerChoices;
	this.correctAnswer = correctAnswer;		
	}

public ArrayList<String> getAnswerChoices(){
	return this.answerChoices;
}

@Override
public int getCorrectAnswer() {
	return this.correctAnswer;
}

@Override
public boolean checkAnswer(int userInput) {
	if(this.getUserAnswer() == this.getCorrectAnswer()) {
		return true;
	} else return false;
}

}
