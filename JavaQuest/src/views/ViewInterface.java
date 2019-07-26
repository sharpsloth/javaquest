package views;

public interface ViewInterface {
    
    public void display();
    
    public String getInput();
    
    public boolean doAction(String value);

	String getInput(String prompt);
}