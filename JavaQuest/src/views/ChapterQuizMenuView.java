package views;

/**
 * ChapterQuizMenu
 */

import model.*;
public class ChapterQuizMenuView extends View{

	/**
	 * ChapterQuizMenu
	 */
	public ChapterQuizMenuView() {
		super("\n---------------------------------------------------"
		        +"\n|  Chapter Quiz Menu                                      |"
		        +"\n---------------------------------------------------"
		        +"\n	Select a Chapter Quiz to Complete:"
		        +"\n	1	2	3"
		        +"\nS - Save the Game"
		        +"\nQ - Quit"
		        +"\n---------------------------------------------------"
		        +"\n"
		        +"\n"
		        +"\nPlease enter your choice: ");
		}

	
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean doAction(String value) {
		// TODO Auto-generated method stub
		return false;
	}

}
