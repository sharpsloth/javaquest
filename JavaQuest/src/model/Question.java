package model;

import java.io.Serializable;

public abstract class Question implements Serializable {

	private int chapter;
	private int questionNumber;
	private String questionText;
	private String correctAnswerText;
	private int userAnswer; //-1 not answered
	private int correctAnswer;
	private int wasUserAnswerCorrect; // -1 not answered, 0 wrong, 1 correct
	
	public Question() {
		this.chapter = 0;
		this.questionNumber = 0;
		this.questionText = "";
		this.correctAnswerText = "";
		this.userAnswer = -1;
		this.correctAnswer = -1;
		this.wasUserAnswerCorrect = -1;
	}
	
	public Question(int chapter, int questionNumber, String questionText, String correctAnswerText, int correctAnswer) {
		this.questionText = questionText;
		this.correctAnswerText = correctAnswerText;
		this.correctAnswer = correctAnswer;
		this.chapter = chapter;
		this.questionNumber = questionNumber;
		this.wasUserAnswerCorrect = -1;
	}
	
	public int getChapter() {
		return this.chapter;
	}
	
	public int getQuestionNumber() {
		return this.questionNumber;
	}
	
	public String getQuestionText() {
		return this.questionText;
	}
	
	public String getCorrectAnswer() {
		return this.correctAnswerText;
	}
	
	public int getUserAnswer() {
		return this.userAnswer;
	}
	
	public void setUserAnswer(int userAnswer) {
		this.userAnswer = userAnswer;
	}
	
	public int getUserAnswerStatus() {
		return this.wasUserAnswerCorrect;
	}
	
	public void setUserAnswerStatus(int wasUserAnswerCorrect) {
		this.wasUserAnswerCorrect = wasUserAnswerCorrect;
	}
	
	
	public boolean checkAnswer() {
		if(this.userAnswer == this.correctAnswer) {
			return true;
		} else return false;
		
	}


}
