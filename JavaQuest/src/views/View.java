package views;

import java.util.*;


public abstract class View implements ViewInterface {
	    protected String displayMessage;
	    private Scanner input;
	    
	    
	    public View() {
	    }
	   
	    public View(String message){
	        this.displayMessage = message;
	    }
	   
	    @Override
	    public void display(){
	        boolean done = false; //set flag to not done
	        
	        do { //prompt for and get selected menu option
	        	System.out.println("\n" + this.displayMessage);
	            String value = this.getInput();
	            if (value.toUpperCase().equals("Q"))  //user wants to quit
	              return; //exit the game
	            
	           
	        
	        //this will do the requested action and display the next view
	        
	         done = this.doAction(value);
	         
	         
	        } while(!done);
	    }
	    
	    @Override
	    public String getInput(String prompt) {
	    	System.out.println("/n" + prompt);
	    	String value = this.getInput();
	    	return value;
	    }
	 
	    @Override
	    public String getInput() {
	    	input = new Scanner(System.in);
	        String value = ""; //value to be returned
	        boolean valid = false; //initialize to not valid
	        try {
	        while (!valid) { //loop while an invalid value is entered
	                       
	            
	            value = input.nextLine(); //get next line typed on keyboard
	            value = value.trim(); //trim off leading and trailing blanks
	            
	            if (value.length() < 1) { //value is blank
	            	System.out.printf(this.getClass().getName(),"\nInvalid value: value cannot be blank");
	                continue;
	            }
	            break; //end the loop
	        }
	        } catch (Exception e) {
	        	System.out.printf(this.getClass().getName(),"Error reading input: " + e.getMessage());
	        }
	        return value; //return the value entered
	    }
	    
	    public Integer getInt (String message) {
	    	try {
	    		System.out.print(message);
	    		String teString = getInput();
	    		Integer test2 = Integer.parseInt(teString);
	    		return test2;
	    	}
	    	catch (Exception ex) {
	    		System.out.println("Invalid value. Error: " +ex.getMessage());
	    	}
	    	return -1;
	    }
	    
	    public boolean getBoolean(String response) {
	    	boolean b = Boolean.parseBoolean(response);
	    	
	    	return b;
	    	
	    }
	    
	    public ArrayList<String> getArray (String message, int maxAnswers) {
	    	try {
	    		System.out.print(message);
	    		ArrayList<String> teString = new ArrayList<String>();
	    		for (int i = 0; i < maxAnswers; i++) {
	    		teString.add(getInput("Enter a question answer choice"));
	    		}
	    		return teString;
	    	}
	    	catch (Exception ex) {
	    		System.out.println("Invalid value. Error: " +ex.getMessage());
	    	}
			return null;
	    }
}