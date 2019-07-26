package views;

import java.util.ArrayList;

import model.*;

public class MainMenuView extends View {

	public MainMenuView() {
		super(getMainMenuString());
	}

	@Override
	public boolean doAction(String choice) {
		choice = choice.toUpperCase();

		switch (choice) {
		case "N": // create and start a new game
			this.startNewGame();
			break;
		case "G": // get and start an existing game
			this.startExistingGame();
			break;
		case "Q": // quit the game

		default:
			System.out.printf(this.getClass().getName() + "\n***Invalid selection. Try again.");
			break;
		}
		return false;
	}

	private void startNewGame() {
		// System.out.printf("You selected startNewGame");
		createNewGame();
		gotoGamePlayMenu();
	}

	private void startExistingGame() {
		// System.out.printf("You selected startExistingGame");
		String gameName = getInput("Enter filename for game to load: ");
		if (JavaQuest.getSavedGame(gameName))
			gotoGamePlayMenu();
	}

	private Game createNewGame() {
		String gameName = getInput("Please enter your new Game name: ");
		Game game = new Game(gameName);
		ArrayList<Question> questions = game.getQuestions();
		ArrayList<String> answerChoices = new ArrayList<String>();
		answerChoices.add("Yes");
		answerChoices.add("No");
		answerChoices.add("Maybe?");

		Question question = new MultipleChoice(1, 1, "Is this a multiple choice example?", -1, -1, answerChoices, 0);
		questions.add(question);
		questions.add(new TrueFalse(1, 2, "Java is awesome!", -1, -1, true));
		JavaQuest.setGame(game);
		return game;

	}

	private void gotoGamePlayMenu() {
		GamePlayMenuView gamePlayMenuView = new GamePlayMenuView();
		gamePlayMenuView.display();
		displayMessage = getMainMenuString();
	}

	private static String getMainMenuString() {
		return ("" + "  .--------------------.\r\n"
//				+ "  |    Welcome         |\r\n"
//				+ "  |      To            |        .--.--.\r\n" 
//				+ "  |        JAVAQUEST   |      .; .;|;. ;.\r\n"
//				+ "  `-------------.  ,---'     .;_;'   `;_;.\r\n" 
//				+ "                 \\|         ; ;'       `; ;\r\n"
//				+ "                  \\        ;;'.--.___.--.`;;\r\n"
//				+ "                           ;-(  o )=( o  )-;\r\n"
//				+ "                          (   `--' | `--'   )\r\n"
//				+ "                           \\|     . .     |/\r\n"
//				+ "             ...........    .   .:::::.   .     .______\r\n"
//				+ "            /                .   '---`   .             '\\\r\n"
//				+ "           .'                 `.       .'                \\\r\n"
//				+ "           |        ____,.- . | `.....' |   _______      |\r\n"
//				+ "            |    ,-'          \\        /|\\''       \\.--  |\r\n"
//				+ "            |   /            \\.'\\     /,'.          \\. - |\r\n"
//				+ "            |  /|             `  `\\ /                 \\  |\r\n"
//				+ "           |  ,/      _           '/                  '\\ |\r\n"
//				+ "            ,-'     ,-.           |o                    '\r\n"
//				+ "           /         '|           |            | |       \\\r\n"
//				+ "          /         ,/|           |o           |  \\       `\r\n"
//				+ "         |        .'  |           |.'          |. \\        \\\r\n"
//				+ "________/       .'____|________________________||__`.       `__________\r\n"
//				+ "       (         \\                        )        /         )\r\n"
//				+ "        '-.       '-.                    (      .-`       .-`\r\n"
//				+ "           '-.    .-'--.__.             .-.__.--`-.    .-`\r\n"
//				+ "             '-..'     \\--'            : ~`:=,`-   `..-`\r\n"
//				+ "                 \\ ..  \\\\              |`-'|`-,    /\r\n"
//				+ "                  \\\\\\\\\\\\\\)             |   |`-'/.'/\r\n"
//				+ "                   \\)\\)\\\\               `-' `-'");
				+ "\n---------------------------------------------------"
				+ "\n|  Main Menu                                      |"
				+ "\n---------------------------------------------------" + "\nN - Start New Game"
				+ "\nG - Sart Existing Game" + "\nQ - Quit" + "\n---------------------------------------------------"
				+ "\n" + "\n" + "\nPlease enter your choice: ");
	}

	/**
	 * 
	 */
	
}
