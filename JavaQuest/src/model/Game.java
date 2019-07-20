package model;
import java.io.Serializable;
import java.util.*;

public class Game implements Serializable{
	private String name;
	private ArrayList<Question> questions;
	private boolean changed = false;

	public Game() {
		this.name = "";
		this.quesitons = newArrayList<Question>();
	}
	
	public Game(String name) {
		this.name = name;
		this.quesitons = newArrayList<Question>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Question> getQuestions() {
		return this.questions;
	}
	
	public boolean hasChanged() {
		return this.changed;
	}
	
	public void hasChanged(boolean changed) {
		this.changed = changed;
	}

}
