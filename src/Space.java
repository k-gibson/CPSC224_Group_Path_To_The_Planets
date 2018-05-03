/**
* Space.java is the main class that begins the entire game.
* It creates a new instance of the game GUI which opens a window for the users to begin a game of Race Through Space.
* CPSC 224-01, Spring 2018
* Final Project - Race Through Space
* class Space.java
* @author Alana Dillinger
* @version v1.0 5/4/2018
*/

import java.util.*;

import javax.swing.JPanel;

import java.io.*;

public class Space{
  /**
  * Opens the first window of Race Through Space so users can begin a game
  */
  public static void main(String[] args) throws FileNotFoundException{
	gameGUI newGame = new gameGUI();
	newGame.setTitle("Race Through Space");
    newGame.setDefaultCloseOperation(gameGUI.EXIT_ON_CLOSE);
    newGame.setVisible(true);
  }

}