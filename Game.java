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
    //System.out.println("How many player are there? ");
    // Call get number of players panel class which returns numberOfPlayers
	  
	  this.numberOfPlayers = numberOfPlayers;
	  // set the numbers of players later
 //input.nextInt(); //input.nextInt becomes call to getPlayer panel class
    players = new Player[numberOfPlayers];
    for(int i = 0; i < numberOfPlayers; i++){
      //create new panel to input the users name panel returns user name
      //System.out.print("Player Name: ");
    	//*************** need function in NumberOfPlayers to get player names
    	// return the array of players? Or just one player
      players[i] = new Player(i + 1);
    }
    
    
    
    
  }

  /**
    * Begins a game of Yahtzee and at the end asks the user if they would like to play again
    */
  public void playGame(){
	  CompletedListener completedListener = new CompletedListener() {
  			@Override
  			public void completed(Object data) {
  				Integer index = (Integer)data;
  					
  				// after the roll panel we need a panel to display the dice.
  				// this should be in the takeTurn function in the Player class
  				players[index].takeTurn(players[index]);
  				if(!players[index].score(players[index]) && index + 1 < players.length){
  					new RollPanel(players[index + 1], index + 1, this);
  				}
  			}
  		};
  	
  	new RollPanel(players[0], 0, completedListener);
//    int numberOfTurns = 0;
//    while (numberOfTurns <= 7 && !winnerFound)
//    {
//
//      if(winnerFound) break;
//      // call panel to display the turn number.
//      TurnPanel turnPanel = new TurnPanel(numberOfTurns);
//      turnPanel.setVisible(true);
//      //System.out.println("-------------------------TURN " + numberOfTurns + "------------------------");
//      numberOfTurns++;
//    }
//    endGame();
  }

    /**
      * Creates a new scoreboard which is used to score the game that was just played
      */
  private void endGame(){
    //hand need to be sorted to check for straights
    for(int i = 0; i < numberOfPlayers; i++){
      players[i].finalScore(players[i]);
      
    }
  }
}