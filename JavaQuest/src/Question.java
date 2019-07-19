
public class Question {

	int chapter;
	int questionNumber;
	String questionText;
	String correctAnswerText;
	int wasUserAnswerCorrect; // -1 not answered, 0 wrong, 1 correct
	
	public Question() {
		// TODO Auto-generated constructor stub
	}
	
	public Question(int chapter, int questionNumber, String questionText, String correctAnswerText) {
		this.questionText = questionText;
		this.correctAnswerText = correctAnswerText;
		this.chapter = chapter;
		this.questionNumber = questionNumber;
	}
	
	public boolean checkAnswer(String input) {
		
	}
	
	public correctAnswer() {
		
	}

}
