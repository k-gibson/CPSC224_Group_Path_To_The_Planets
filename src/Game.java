/**
* This class runs a game of Race Through Space with multiple players who all take multiple turns.
* In a game, users play the game and score the game
* CPSC 224-01, Spring 2018
* Final Project - Race Through Space
* class Game.java
* @author Alana Dillinger
* @version v1.0 5/4/2018
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
  * Game constructor creates an array of players and the number of players is defined by the user
  * @param int numberOfPlayers inputted by the user
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
    * Begins a game of Race Through Space.
    * The game runs through seven rounds in which each player takes a turn and rolls the dice
    * In a players turn, a roll panel is displayed that allows the player to interact with and roll the dice
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
      * When either the players have run out of turns or someone has visited all the planets, the game ends.
      * endGame finds the player who one and creates a winner screen to congratulate them.
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
    WinFrame winFrame = new WinFrame(currentLeader, players);
	winFrame.setVisible(true);
  }
}