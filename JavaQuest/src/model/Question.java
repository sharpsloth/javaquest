package model;

import java.io.Serializable;

/**
 * abstract class Question implements Serializable
 */
public abstract class Question implements Serializable {

	private int chapter;
	private int questionNumber;
	private String questionText;
	private int userAnswer; //-1 not answered	
	private int wasUserAnswerCorrect; // -1 not answered, 0 wrong, 1 correct

	/**
	 * Question()
	 * Constructor
	 */
	public Question() {
		this.chapter = 0;
		this.questionNumber = 0;
		this.questionText = "";
		this.userAnswer = -1;
		this.wasUserAnswerCorrect = -1;
	}

	/**
	 * Question(
	 * int chapter, 
	 * int questionNumber, 
	 * String questionText, 
	 * int userAnswer, 
	 * int wasUserAnswerCorrect
	 * )
	 */
	public Question(int chapter, int questionNumber, String questionText, int userAnswer, int wasUserAnswerCorrect) {
		this.chapter = chapter;
		this.questionNumber = questionNumber;
		this.questionText = questionText;
		this.userAnswer = userAnswer;
		this.wasUserAnswerCorrect = wasUserAnswerCorrect;
	}

	/**
	 * getChapter() 
	 * return this.chapter;
	 */
	public int getChapter() {
		return this.chapter;
	}

	/**
	 * getQuestionNumber()
	 */
	public int getQuestionNumber() {
		return this.questionNumber;
	}

	/**
	 * String getQuestionText() 
	 * return this.questionText;
	 */
	public String getQuestionText() {
		return this.questionText;
	}

	/**
	 * getUserAnswer() 
	 * return this.userAnswer;
	 */
	public int getUserAnswer() {
		return this.userAnswer;
	}

	/**
	 * setUserAnswer(int userAnswer)
	 */
	public void setUserAnswer(int userAnswer) {
		this.userAnswer = userAnswer;
	}

	/**
	 * getUserAnswerStatus() 
	 * return this.wasUserAnswerCorrect;
	 */
	public int getUserAnswerStatus() {
		return this.wasUserAnswerCorrect;
	}

	/**
	 * setUserAnswerStatus(int wasUserAnswerCorrect)
	 */
	public void setUserAnswerStatus(int wasUserAnswerCorrect) {
		this.wasUserAnswerCorrect = wasUserAnswerCorrect;
	}

	/**
	 * getCorrectAnswer()
	 */
	public abstract int getCorrectAnswer();

	/**
	 * checkAnswer(int userInput);
	 */
	public abstract boolean checkAnswer(int userInput);

	/**
	 * correctAnswer() 
	 * return "Correct answer is: " + this.getCorrectAnswer()
	 */
	public String correctAnswer() {
		return "Correct answer is: " + this.getCorrectAnswer();
	}


}
