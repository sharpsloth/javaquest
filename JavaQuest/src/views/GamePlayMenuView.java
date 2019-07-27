package views;

import java.util.ArrayList;

import model.Game;
import model.MultipleChoice;
import model.Question;
import model.TrueFalse;

/**
 * This is the GamePlayMenu - it extends the View
 */
public class GamePlayMenuView extends View {

/**
* GamePlayMenuView()
*/
public GamePlayMenuView() {
super(getGamePlayMenuString());// end GamePlayMenuView
}

/**
* doAction(String choice) typical switch/case
*/
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
case "R": // return to current game
this.returnToCurrentGame();
break;
default:
System.out.printf(this.getClass().getName() + "\n***Invalid selection. Try again.");// error
break;
}
return false;// end doAction
}

/**
* SaveGame() save the game
*/
private void SaveGame() {
String saveFileName;
String overwrite = "N";

if (!(JavaQuest.getCurrentFileLoaded().isEmpty())) {
overwrite = getInput("Over-write existing mane? (Y/N)");
}

if (overwrite.equalsIgnoreCase("Y")) {
saveFileName = JavaQuest.getCurrentFileLoaded();
} else {
String fileName = getInput("Enter filename?");
saveFileName = fileName;
}
if (JavaQuest.saveGame(saveFileName)) {
displayMessage = getGamePlayMenuString();
} // end SaveGame
}

/**
* AddTFQuestion() user added true false questions
*/
private void AddTFQuestion() {
System.out.printf("You selected Add True/False Question ");
int chapter = getInt("\nEnter the chapter number ");
int questionNumber = getInt("Enter the question numbe r");
String questionText = getInput("Enter the question text ");
int userAnswer = -1;
int wasUserAnswerCorrect = -1;
boolean correctAnswer = getBoolean("Is the answer true or false? ");
Question question = new TrueFalse(chapter, questionNumber, questionText, userAnswer, wasUserAnswerCorrect,
correctAnswer);
Game game = JavaQuest.getGame();
ArrayList<Question> questions = game.getQuestions();
questions.add(question);
}// end AddTFQuestion

/**
* AddMCQuestion() user added multiple choice questions
*/
private void AddMCQuestion() {
System.out.printf("You selected Add Multiple Choice Question ");
int chapter = getInt("\nEnter the chapter number ");
int questionNumber = getInt("\nEnter the question number ");
String questionText = getInput("\nEnter the question text ");
int userAnswer = -1;
int wasUserAnswerCorrect = -1;
int maxAnswers = getInt("\nHow many answer choices does this question have? ");
ArrayList<String> answerChoices = getArray("\nEnter an answer choice ", maxAnswers);
int correctAnswer = getInt("\nWhich answer is correct? \nEnter 0 for the first answer\n1 for the second\n2 for the third\nect.\r\n");
Question question = new MultipleChoice(chapter, questionNumber, questionText, userAnswer, wasUserAnswerCorrect,
answerChoices, correctAnswer);
Game game = JavaQuest.getGame();
ArrayList<Question> questions = game.getQuestions();
questions.add(question);
}// end AddMCQuestion

/**
* gotoChapterQuizMenu() navigates
*/
private void gotoChapterQuizMenu() {
ChapterQuizMenuView chapterQuizMenuView = new ChapterQuizMenuView();
chapterQuizMenuView.display();
displayMessage = getGamePlayMenuString();
}// end gotoChapterQuizMenu

/**
* returnToCurrentGame() returns to game
*/
private void returnToCurrentGame() {
if (JavaQuest.getGame() != null) {
GamePlayMenuView gamePlayMenuView = new GamePlayMenuView();
gamePlayMenuView.display();
}
}// end returnToCurrentGame

/**
* getContinueMenuString() needed for better functionality
*/
private static String getContinueMenuString() {
if (JavaQuest.getGame() != null) {
return "\nR - Return to current game ";
} else
return "";
}// end getContinueMenuString

/**
* getSaveMenu()
*/
private static String getSaveMenu() {
if ((JavaQuest.getGame() != null) && JavaQuest.getGame().hasChanged()) {
return "\nS - Save Changes";
} else
return "";
}// end getSaveMenu

/**
* getGamePlayMenuString() is the gamePlayMenu
*/
private static String getGamePlayMenuString() {
return ("\n---------------------------------------------------"
+ "\n|  Game Menu                                      |"
+ "\n---------------------------------------------------" + "\nC - Chapter Quiz"
+ "\nM - Add Multiple Choice Question" + "\nT - Add True/False Question" + getContinueMenuString()
+ getSaveMenu() + "\nQ - Quit" + "\n---------------------------------------------------" + "\n" + "\n"
+ "\nPlease enter your choice: ");
}// end getGamePlayMenuString

}
