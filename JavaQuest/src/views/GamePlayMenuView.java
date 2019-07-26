package views;

import java.util.ArrayList;
import model.*;
public class GamePlayMenuView  extends View {

	public GamePlayMenuView() {
	    super("\n---------------------------------------------------"
	        +"\n|  Game Menu                                      |"
	        +"\n---------------------------------------------------"
	        +"\nC - Chapter Quiz"
	        +"\nM - Add Multiple Choice Question"
	        +"\nT - Add True/False Question"
	        +"\nS - Save the Game"
	        +"\nQ - Quit"
	        +"\n---------------------------------------------------"
	        +"\n"
	        +"\n"
	        +"\nPlease enter your choice: ");
	}

	@Override
	public boolean doAction(String choice) {
	    choice = choice.toUpperCase();
	    
	    switch (choice) {
	        case "C": //create and start a new game
			                this.ChapterQuiz();
	            break;
	        case "M": //get and start an existing game
		                this.AddMCQuestion();
	            break; 
	        case "T": //get and start an existing game
                this.AddTFQuestion();
        break; 
	        default:
	        	System.out.printf(this.getClass().getName() +
	                    "\n***Invalid selection. Try again.");
	            break;
	    }
	    return false;
	}
	
	 private void AddTFQuestion() {
			System.out.printf("You selected Add True/False Question");
			int chapter = getInt("Enter the chapter number");
			int questionNumber = getInt("Enter the question number");
			String questionText = getInput("Enter the question text");
			int userAnswer = -1;
			int wasUserAnswerCorrect = -1;
			boolean correctAnswer = getBoolean("Is the answer true or false?");
			Question question = new TrueFalse(chapter, questionNumber, questionText, userAnswer, wasUserAnswerCorrect, correctAnswer);	
	}

	private void AddMCQuestion() {
		System.out.printf("You selected Add Multiple Choice Question");
		int chapter = getInt("Enter the chapter number");
		int questionNumber = getInt("Enter the question number");
		String questionText = getInput("Enter the question text");
		int userAnswer = -1;
		int wasUserAnswerCorrect = -1;
		int maxAnswers = getInt("How many answer choices does this question have?");
		ArrayList<String> answerChoices = getArray("Enter an answer choice", maxAnswers);
		int correctAnswer = getInt("Which answer is correct? (0/1/2/etc)");
		Question question = new MultipleChoice(chapter, questionNumber, questionText, userAnswer, wasUserAnswerCorrect, answerChoices, correctAnswer);
		questions.add(question);
	}

	private void ChapterQuiz() {
		System.out.printf("You selected Chapter Quiz");
	}

	
}