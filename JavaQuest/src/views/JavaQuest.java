package views;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.util.*;

import model.Game;

/**
 * JavaQuest
 */
public class JavaQuest {
	private static Game game;
	private static String fileLoaded;

	/**
	 * main
	 */
	public static void main(String[] args) {
		game = null;
		fileLoaded = "";
		// TODO Auto-generated method stub
		MainMenuView mainMenu = new MainMenuView();
		mainMenu.display();
		System.out.printf("Game Over.");
	}

	/**
	 * setGame(Game thisGame) 
	 */
	public static void setGame(Game thisGame) {
		game = thisGame;
	}

	/**
	 * Game getGame()
	 */
	public static Game getGame() {
		return game;
	}

	/**
	 * getSavedGame(String filePath)
	 */
	public static boolean getSavedGame(String filePath) {
		game = null;
		fileLoaded = filePath;
		try(FileInputStream fips = new FileInputStream(filePath)) {
			ObjectInputStream input = new ObjectInputStream(fips);
			
			game = (Game) input.readObject(); //read the game object on file
			System.out.printf("Successfully loaded the game");
		}
	catch(Exception e)	{
		System.out.printf("Failed to load the game. Error:" + e.getMessage());
		return false;
		}return true;
}

	/**
	 * saveGame(String filePath)
	 */
	public static boolean saveGame(String filePath) {
		if (game.getName().isBlank())
			game.setName(filePath);
		try(FileOutputStream fops = new FileOutputStream(filePath)) {
		ObjectOutputStream output = new ObjectOutputStream(fops);
		output.writeObject(game); //write the game object out to file
		System.out.printf("Sucessfully saved the game");
		game.hasChanged(false);
		return true;
		}
		catch(Exception e) {
			System.out.printf("Failed to save the game. Error:" + e.getMessage());
		}
		return false;
	}
	
	/**
	 * getCurrentFileLoaded()
	 */
	public static String getCurrentFileLoaded() {
		return fileLoaded;
	}
}
