/**
* This class extends the Game class and uses and array of dice to simulate the game Yahtzee
* This class contains methods to set up the game, play the game, take a turn, or score the game
* Users are allowed to alter the configurations of the original version of Yahtzee.
* Default game configurations are loaded from a "yahtzeeConfig.txt" file.
* CPSC 224-01, Spring 2018
* Programming Assignment #6
* class Yahtzee.java

* @author Alana Dillinger

* @version v1.0 3/23/2018
*/

import java.util.*;
import java.io.*;

public class Game extends Space{
  Scanner input = new Scanner(System.in);
  public Player[] players;
  public int numberOfSides = 7;
  public int numberOfDice = 7;
  public int numberOfRolls = 7;
  public int numberOfPlayers;


  /**
  * Yahtzee constructor stores an array of dice used to play the game
  */
  public Game(){
    System.out.println("How many player are there? ");
    numberOfPlayers = input.next();
    for(int i = 0; i < numberOfPlayers; i++){
      System.out.print("Player Name: ");
      String name = input.next();
      players[i] = new Player(name);
    }
  }

  /**
    * Begins a game of Yahtzee and at the end asks the user if they would like to play again
    */
  public void playGame(){
    int numberOfTurns = 0;
    boolean winnerFound = false;
    while (numberOfTurns <= 7 && !winnerFound)
    {
      for(int i = 0; i < numberOfPlayers; i++){
        players[i].takeTurn();
        winnerFound = players[i].score();
      }
      numberOfTurns++;
    }
    endGame();
  }

  /**
    * Simulates a turn of the game Yahtzee
    * Rolls the dice three times allowing users to select which dice they would
    * like to keep and which they would like to reroll and scores the game
    */
  private void takeTurn(){
    for(int i = 0; i < numberOfPlayers; i++){
      players[i].takeTurn();
    }
  }

    /**
      * Creates a new scoreboard which is used to score the game that was just played
      */
  private void endGame(){
    //hand need to be sorted to check for straights
    for(int i = 0; i < numberOfPlayers; i++){
      players[i].finalScore();
  }
}
