/**
* This class scores a game of Race Through Space
* This class contains methods to score the upper half and the bonus scores and find the straights.
* It calls functions to create panels to display the dice and the final scorecard.
* CPSC 224-01, Spring 2018
* Final Project - Race Through Space
* class Scorecard.java
* @author Alana Dillinger
* @version v1.0 5/4/2018
*/

import java.util.Scanner;

public class Scorecard {
  Scanner input = new Scanner(System.in);
  public int numberOfSides = 7;
  public int numberOfDice = 7;
  public int totalScore;
  public int smallStraight;
  public int largeStraight;
  public int triForce;
  boolean hasNotScored;
  public int[] upperCardScores;
  boolean[] scored;
  boolean[] scoredThisTurn;
  Die[] dice;

  /**
  * Scorecard constructor stores an array of dice that contains the same dice
  * that are stored in the dice array in the Player class and an array of booleans to keep track of what has already been scord.
  * It also stores the players bonus scores such as the total score, small straight, large straight, and a boolean if the user has not scored yet.
  * @param Die[] rolledDice
  */
  public Scorecard(Die[] rolledDice){
    dice = rolledDice;
    // set everything to zero since nothing has yet been scored
    totalScore = 0;
    smallStraight = 0;
    largeStraight = 0;
    hasNotScored = true;
    upperCardScores = new int[numberOfSides];
    scored = new boolean[10];
    scoredThisTurn= new boolean[numberOfDice];
    
    for(int i = 0; i < scored.length; i++){
    	scored[i] = false;
    }
  }

  /**
  * Scores the planet part of the scorecard and tracks what has been scored in the boolean array scored
  * and a boolean array scoredThisTurn which is used to count straights
  */
  public void upperScoreCard(){	  
    // reset boolean array to false to check what has been scored this turn
	  for(int i = 0; i < scoredThisTurn.length; i++){
		  scoredThisTurn[i] = false;
	  }
	  
	int diceScored = 0;
    if(dice[0].getValue()== Die.Planet.MERCURY){
      upperCardScores[0] = 7;
      if(!scored[0]){
    	totalScore = totalScore + 7;
    	scored[0] = true;
    	scoredThisTurn[0] = true;
    	System.out.println("scoredThisTurn" + scoredThisTurn[0]);
      }
      hasNotScored = false;
      diceScored++;
    }
    if(dice[1].getValue()==Die.Planet.VENUS){
      upperCardScores[1] = 8;
      if(!scored[1]){
      	totalScore = totalScore + 8;
      	scored[1] = true;
      	scoredThisTurn[1] = true;
       }
      hasNotScored = false;
      diceScored++;
    }
    if(dice[2].getValue()==Die.Planet.MARS) {
      upperCardScores[2] = 9;
      if(!scored[2]){
      	totalScore = totalScore + 9;
      	scored[2] = true;
      	scoredThisTurn[2] = true;
      }
      hasNotScored = false;
      diceScored++;
    }
    if(dice[3].getValue()==Die.Planet.JUPITER) {
      upperCardScores[3] = 10;
      if(!scored[3]){
      	totalScore = totalScore + 10;
      	scored[3] = true;
      	scoredThisTurn[3] = true;
      }
      hasNotScored = false;
      diceScored++;
    }
    if(dice[4].getValue()==Die.Planet.SATURN) {
      upperCardScores[4] = 11;
      if(!scored[4]){
      	totalScore = totalScore + 11;
      	scored[4] = true;
      	scoredThisTurn[4] = true;
      }
      hasNotScored = false;
      diceScored++;
    }
    if(dice[5].getValue()==Die.Planet.URANUS) {
      upperCardScores[5] = 12;
      if(!scored[5]){
      	totalScore = totalScore + 12;
      	scored[5] = true;
      	scoredThisTurn[5] = true;
      }
      hasNotScored = false;
      diceScored++;
    }
    if(dice[6].getValue().equals(Die.Planet.NEPTUNE)) {
      upperCardScores[6] = 13;
      if(!scored[6]){
      	totalScore = totalScore + 13;
      	scored[6] = true;
      	scoredThisTurn[6] = true;
      }
      hasNotScored = false;
      diceScored++;
    }
    if(diceScored == 3 && !scored[7]) {
    	scored[7] = true;
    	triForce = 33;
    	totalScore = totalScore + 33;
    }
  }

  /**
  * Score the bonus scores for each player
  * Scores the small straight and large straight after the maximum straight is counted
  */
  public void bonusScores(){	  
    if(smallStraight == 0){
    	if(maxStraightFound() == 2 && !scored[8]){
        smallStraight = 30;
        scored[8] = true;
        totalScore = totalScore + 30;
      }
    }

    if(largeStraight == 0){
    	if(maxStraightFound() == 3 && !scored[9]){
        largeStraight = 50;
        scored[9] = true;
        totalScore = totalScore + 50;
      }
    }
  }


  /**
   * Checks the array of dice to find the longest straight that has been rolled
   * @return int maxStraight
   */
    private int maxStraightFound(){
    	int maxStraight = 0;
  	  for(int i = 0; i < numberOfDice-2; i++){
      	if(scoredThisTurn[i]){
      		if(scoredThisTurn[i+1]){
      			if(scoredThisTurn[i+2]){
      				maxStraight = 3;
      				break;
      			}else{
      				maxStraight = 2;
      				break;
      			}
      		}else{
      			maxStraight = 0;
      		}
      	 }
        }
  	  // last case that isn't covered by the for loop so you don't leave the array bounds
  	  if(scoredThisTurn[5] && scoredThisTurn[6]){
  		  maxStraight = 2;
  	  }
     return maxStraight;
    }

    /**
     * Checks the scorecard to see if anyone has visited all the plants and has won before all the turns are used up
     * @return boolean
     */
    public boolean checkForWinner(){
      for(int i = 0; i < numberOfDice; i++){
        if(upperCardScores[i]==0)
          return false;
      }
      return true;
    }
}