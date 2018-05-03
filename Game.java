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

import javax.swing.JPanel;

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
  public Game(int numberOfPlayers){
    // Call get number of players panel class which returns numberOfPlayers
	  
	  this.numberOfPlayers = numberOfPlayers;
    players = new Player[numberOfPlayers];
    for(int i = 0; i < numberOfPlayers; i++){
      players[i] = new Player(i + 1);
    }   
  }

  /**
    * Begins a game of Yahtzee and at the end asks the user if they would like to play again
    */
  public void playGame(){
	  final int ROUNDS = 6;
	  CompletedListener completedListener = new CompletedListener() {
  			@Override
  			public void completed(Object data) {
  				Object[] datas = (Object[]) data;
  				Integer index = (Integer)datas[0];
  				Integer currentTurn = (Integer)datas[1];
  				players[index].takeTurn(players[index]);
  				if(players[index].score(players[index])) {
  				    endGame();
  					return;
  				}
  				if(!players[index].score(players[index]) && index + 1 < players.length){
  					new RollPanel(players[index + 1], index + 1, currentTurn, this);
  				} else if (currentTurn < ROUNDS) {
  			  		new RollPanel(players[0], 0, currentTurn+1, this);
  				} else {
  					endGame();
  				}
  			}
  		};
  		new RollPanel(players[0], 0, 0, completedListener);
  }

    /**
      * Creates a new scoreboard which is used to score the game that was just played
      */
  private void endGame(){
    //hand need to be sorted to check for straights
	Player currentLeader = players[0];
    for(int i = 0; i < players.length; i++){
      if(players[i].score(players[i])) {
  		currentLeader = players[i];
  		break;
  	  } 
      else if(players[i].playerCard.totalScore > currentLeader.playerCard.totalScore) {
    	  currentLeader = players[i];
      }
    }
    WinFrame winFrame = new WinFrame(currentLeader);
	winFrame.setVisible(true);
  }
}