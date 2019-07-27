package model;
import java.io.Serializable;
import views.*;
import java.util.*;

/**
 * class Game implements Serializable
 */
public class Game implements Serializable{
	private String name;
	private ArrayList<Question> questions;
	private boolean changed = false;

	/**
	 * Game()
	 */
	public Game() {
		this.name = "";
		this.questions = new ArrayList<Question>();
	}

	/**
	 * Game(String name)
	 */
	public Game(String name) {
		this.name = name;
		this.questions = new ArrayList<Question>();
	}

	/**
	 * String getName()
	 * return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * setName(String name)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ArrayList<Question> getQuestions()
	 * return this.questions;
	 */
	public ArrayList<Question> getQuestions() {
		return this.questions;
	}
	
	public void addQuestion(Question question) {
		this.questions.add(question);
	}

	/**
	 * hasChanged()
	 * return this.changed;
	 */
	public boolean hasChanged() {
		return this.changed;
	}
	
	/**
	 * hasChanged(boolean changed)
	 */
	public void hasChanged(boolean changed) {
		this.changed = changed;
	}

}
