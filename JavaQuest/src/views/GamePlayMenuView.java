package views;

import java.util.ArrayList;
import model.*;

public class GamePlayMenuView extends View {

	public GamePlayMenuView() {
		super(getGamePlayMenuString());
	}

	@Override
	public boolean doAction(String choice) {
		choice = choice.toUpperCase();

		switch (choice) {
		case "C": // create and start a new game
			this.gotoChapterQuizMenu();
			break;
		case "M": // get and start an existing game
			this.AddMCQuestion();
			break;
		case "T": // get and start an existing game
			this.AddTFQuestion();
			break;
		case "S": // save the game
			this.SaveGame();
			break;
		case "R": //return to current game
			this.returnToCurrentGame();
			break;
		default:
			System.out.printf(this.getClass().getName() + "\n***Invalid selection. Try again.");
			break;
		}
		return false;
	}

	private void SaveGame() {
			 String saveFileName;
			 String overwrite = "N";

			 if (!(JavaQuest.getCurrentFileLoaded().isEmpty())) {
			 overwrite = getInput("Over-write existing mane? (Y/N)");
			 }

			 if (overwrite.equalsIgnoreCase("Y")){
			 saveFileName = JavaQuest.getCurrentFileLoaded();
			 } else {
			 String fileName = getInput("Enter filename?");
			 saveFileName = fileName;
			 }
			 if (JavaQuest.saveGame(saveFileName)) {
			 displayMessage = getGamePlayMenuString();
			 }
	}

	private void AddTFQuestion() {
		System.out.printf("You selected Add True/False Question");
		int chapter = getInt("Enter the chapter number");
		int questionNumber = getInt("Enter the question number");
		String questionText = getInput("Enter the question text");
		int userAnswer = -1;
		int wasUserAnswerCorrect = -1;
		boolean correctAnswer = getBoolean("Is the answer true or false?");
		Question question = new TrueFalse(chapter, questionNumber, questionText, userAnswer, wasUserAnswerCorrect,
				correctAnswer);
		Game game = JavaQuest.getGame();
		ArrayList<Question> questions = game.getQuestions();
		questions.add(question);
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
		Question question = new MultipleChoice(chapter, questionNumber, questionText, userAnswer, wasUserAnswerCorrect,
				answerChoices, correctAnswer);
		Game game = JavaQuest.getGame();
		ArrayList<Question> questions = game.getQuestions();
		questions.add(question);
	}

	private void gotoChapterQuizMenu() {
		ChapterQuizMenuView chapterQuizMenuView = new ChapterQuizMenuView();
		chapterQuizMenuView.display();
		displayMessage = getGamePlayMenuString();
	}
	
	private void returnToCurrentGame() {
		if (JavaQuest.getGame() != null) {
		GamePlayMenuView gamePlayMenuView = new GamePlayMenuView();
		gamePlayMenuView.display();
		}
		}
		private static String getContinueMenuString() {
		if (JavaQuest.getGame() != null) {
		return "\nR - Return to current game: ";
		} else return "";
		}

		private static String getSaveMenu() {
		if ((JavaQuest.getGame() != null) && JavaQuest.getGame().hasChanged()) {
		return "\nS - Save Changes";
		} else return "";
		}

	private static String getGamePlayMenuString() {
		return ("" + "\n---------------------------------------------------"
				+ "\n|  Game Menu                                      |"
				+ "\n---------------------------------------------------" 
				+ "\nC - Chapter Quiz"
				+ "\nM - Add Multiple Choice Question" 
				+ "\nT - Add True/False Question" 
				+ getContinueMenuString()
				+ getSaveMenu()
				+ "\nQ - Quit" 
				+ "\n---------------------------------------------------" + "\n" + "\n"
				+ "\nPlease enter your choice: ");
	}

}