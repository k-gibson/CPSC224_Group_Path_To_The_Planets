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

	public static JPanel mainPanel;//PLACEHOLDER PANEL FIX!!!!!<------
	
  // Creates and then lets the user play a game of yahtzee
  public static void main(String args[]) throws FileNotFoundException{
    Game game = new Game(mainPanel);
    game.playGame();
  }

}
