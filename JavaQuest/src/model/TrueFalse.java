package model;

import java.io.Serializable;
import java.util.ArrayList;

public class TrueFalse extends Question implements Serializable{

	private ArrayList<String> answerChoices;
	private boolean correctAnswer;
	
	
	public TrueFalse() {
		this.correctAnswer = false;
	}

public TrueFalse(int chapter, int questionNumber, String questionText, int userAnswer, int wasUserAnswerCorrect, boolean correctAnswer) {
	super(chapter, questionNumber, questionText, userAnswer, wasUserAnswerCorrect);
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
