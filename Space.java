/**
* This program creates a new game of yahtzee and allows the user to play it.
* CPSC 224-01, Spring 2018
* Programming Assignment #6
* Game.java
* @author Alana Dillinger
* @version v1.0 3/23/2018
*/

import java.util.*;

import javax.swing.JPanel;

import java.io.*;

public class Space{
// We can replace this class with the main GUI welcome screen with the rules and start game buttons.

  // Creates and then lets the user play a game of yahtzee
  public static void main(String[] args) throws FileNotFoundException{
	gameGUI newGame = new gameGUI();
	newGame.setTitle("Race Through Space");
    newGame.setDefaultCloseOperation(gameGUI.EXIT_ON_CLOSE);
    newGame.setVisible(true);
  }

}
