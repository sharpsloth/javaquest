package model;

import java.io.Serializable;
import java.util.ArrayList;

public class TrueFalse extends Question implements Serializable{

	private boolean correctAnswer;
	
	
	public TrueFalse() {
		this.correctAnswer = false;
	}

public TrueFalse(int chapter, int questionNumber, String questionText, int userAnswer, int wasUserAnswerCorrect, boolean correctAnswer) {
	super(chapter, questionNumber, questionText, userAnswer, wasUserAnswerCorrect);
	this.correctAnswer = correctAnswer;	
	}

public ArrayList<String> getAnswerChoices(){
	ArrayList<String> answers = new ArrayList<String>();
	answers.add("false");
	answers.add("true");
	return answers;
}

@Override
public int getCorrectAnswer() {
	if (this.correctAnswer == false) {
		return 0;
	}else return 1;
}

@Override
public boolean checkAnswer(int userInput) {
	if(this.getUserAnswer() == this.getCorrectAnswer()) {
		return true;
	} else return false;
}

}
