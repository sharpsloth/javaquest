package model;

import java.io.Serializable;

public abstract class Question implements Serializable {

	private int chapter;
	private int questionNumber;
	private String questionText;
	private int userAnswer; //-1 not answered	
	private int wasUserAnswerCorrect; // -1 not answered, 0 wrong, 1 correct
	
	public Question() {
		this.chapter = 0;
		this.questionNumber = 0;
		this.questionText = "";
		this.userAnswer = -1;
		this.wasUserAnswerCorrect = -1;
	}
	
	public Question(int chapter, int questionNumber, String questionText, int userAnswer, int wasUserAnswerCorrect) {
		this.chapter = chapter;
		this.questionNumber = questionNumber;
		this.questionText = questionText;
		this.userAnswer = userAnswer;
		this.wasUserAnswerCorrect = wasUserAnswerCorrect;
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
	
	public abstract int getCorrectAnswer();
	
	public abstract boolean checkAnswer(int userInput);
	
	public String correctAnswer() {
		return "Correct answer is: " + this.getCorrectAnswer();
	}


}
