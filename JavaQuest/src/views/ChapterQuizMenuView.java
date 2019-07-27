package views;

import java.util.ArrayList;

/**
 * ChapterQuizMenu
 */

import model.*;

public class ChapterQuizMenuView extends View {

	/**
	 * ChapterQuizMenu
	 */
	public ChapterQuizMenuView() {
		super(getChapterQuizMenuString());
	}

	@Override
	public boolean doAction(String choice) {
		choice = choice.toUpperCase();

		switch (choice) {
		case "1": // get and start a chapter quiz
		case "2": // get and start a chapter quiz
		case "3": // get and start a chapter quiz
			this.getChapterQuiz(choice);
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

	private void getChapterQuiz(String choice) {
		int chapter = Integer.parseInt(choice);
		Game game = JavaQuest.getGame();
		ArrayList<Question> questions = game.getQuestions();
		int count = 0;
		int total = 0;
		for (Question i : questions) {
			if (i.getChapter() == chapter) {
					System.out.println(i.getQuestionText());
					total ++;
					if (i.getQuestionType() == "MC") {
						
						for (String answerChoices : i.getAnswerChoices())
						System.out.println("\n" + answerChoices);
						i.setUserAnswer(getInt("Select the best answer: "));
						boolean wasUserCorrect = i.checkAnswer(i.getUserAnswer());
						if (wasUserCorrect == true) {
							i.setUserAnswerStatus(1);
							count ++;
							
						} else {
							i.setUserAnswerStatus(0);
						}
						
						
					} else if (i.getQuestionType() == "TF") {
						i.setUserAnswer(getInt("True (1) or False (0): "));		
						boolean wasUserCorrect = i.checkAnswer(i.getUserAnswer());
						if (wasUserCorrect == true) {
							i.setUserAnswerStatus(1);
							count ++;
							
						} else {
							i.setUserAnswerStatus(0);
						}
					} else {
						continue;
					};
				
			}
			
		}
		
		System.out.println("You got " + count + "/" + total + " answers correct");
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
		} else
			return "";
	}

	private static String getSaveMenu() {
		if ((JavaQuest.getGame() != null) && JavaQuest.getGame().hasChanged()) {
			return "\nS - Save Changes";
		} else
			return "";
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
		 displayMessage = getChapterQuizMenuString();
		 }
}


	private static String getChapterQuizMenuString() {
		return ("\n---------------------------------------------------"
				+ "\n|  Chapter Quiz Menu                                      |"
				+ "\n---------------------------------------------------" + "\n	Select a Chapter Quiz to Complete:"
				+ "\n	1	2	3" + getContinueMenuString() + getSaveMenu() + "\nQ - Quit"
				+ "\n---------------------------------------------------" + "\n" + "\n"
				+ "\nPlease enter your choice: ");
	}

}
