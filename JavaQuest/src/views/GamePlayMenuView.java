package views;

public class GamePlayMenuView  extends View {

	public GamePlayMenuView() {
	    super("\n---------------------------------------------------"
	        +"\n|  Help Menu                                      |"
	        +"\n---------------------------------------------------"
	        +"\nC - Class Help"
	        +"\nO - Other Help"    
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
			                this.ClassHelp();
	            break;
	        case "O": //get and start an existing game
		                this.OtherHelp();
	            break;   
	        default:
	        	System.out.printf(this.getClass().getName() +
	                    "\n***Invalid selection. Try again.");
	            break;
	    }
	    return false;
	}

	private void OtherHelp() {
		System.out.printf("You selected OtherHelp");
		
	}

	private void ClassHelp() {
		// TODO Auto-generated method stub
		System.out.printf("You selected ClassHelp");
	}

	
}