/**
* This class scores a game of Race Through Space
* This class contains methods to score the upper half and the bonus scores and find the straights.
* It calls functions to create panels to display the dice and the final scorecard.
* CPSC 224-01, Spring 2018
* Final Project
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
    scored = new boolean[numberOfSides];
  }

  /**
  * Scores the planet part of the scorecard and tracks what has been scored in the boolean array hasBeenScored
  */
  public void upperScoreCard(){
	// No GUI needed in this function... I think  
	  
    // reset boolean array to false to check what has been scored this turn
	int diceScored = 0;
    for (int i = 0; i < numberOfDice; i++){
      scored[i] = false;
    }
    if(dice[0].getValue()== Die.Planet.MERCURY){
      upperCardScores[0] = 7;
      scored[0] = true;
      hasNotScored = false;
      diceScored++;
    }
    if(dice[1].getValue()==Die.Planet.VENUS){
      upperCardScores[1] = 8;
      scored[0] = true;
      hasNotScored = false;
      diceScored++;
    }
    if(dice[2].getValue()==Die.Planet.MARS) {
      upperCardScores[2] = 9;
      scored[0] = true;
      hasNotScored = false;
      diceScored++;
    }
    if(dice[3].getValue()==Die.Planet.JUPITER) {
      upperCardScores[3] = 10;
      scored[0] = true;
      hasNotScored = false;
      diceScored++;
    }
    if(dice[4].getValue()==Die.Planet.SATURN) {
      upperCardScores[4] = 11;
      scored[0] = true;
      hasNotScored = false;
      diceScored++;
    }
    if(dice[5].getValue()==Die.Planet.URANUS) {
      upperCardScores[5] = 12;
      scored[0] = true;
      hasNotScored = false;
      diceScored++;
    }
    if(dice[6].getValue().equals(Die.Planet.NEPTUNE)) {
      upperCardScores[6] = 13;
      scored[0] = true;
      hasNotScored = false;
      diceScored++;
    }
    if(diceScored == 3) {
    	triForce = 33;
    }
  }

  /**
  * Score the bonus scores for each player
  * Scores the small straight and large straight
  */
  public void bonusScores(){
	boolean straightFound = false;
    if(smallStraight == 0){
      if(maxStraightFound() == 2){
        smallStraight = 30;
        straightFound = true;
      }
    }

    if(largeStraight == 0){
      if(maxStraightFound() == 3 && !straightFound){
        largeStraight = 50;
      }
    }
  }


  /**
   * Checks the array of dice to find the longest straight that has been rolled
   * @return int maxStraight
   */
    private int maxStraightFound(){
      int maxStraight = 0;
      for(int i = 0; i < numberOfDice; i++){
        if(scored[i]){
          maxStraight++;
        }
        else
          maxStraight = 0;
      }
     return maxStraight; //<--- not sure
    }

    /**
     * Checks the scorecard to see if anyone has visited all the plants and has won before all the turns are used up
     * @return boolean
     */
    public boolean checkForWinner(){
      // No GUI
      for(int i = 0; i < numberOfDice; i++){
        if(upperCardScores[i]==0)
          return false;
      }
      return true;
    }


  /**
    * This will become a call to the GUI for the scorecard panel
    */
  public void displayScorecard(Player player){
	// We can replace all of this with a call to a Scorecard panel
	// except the loop to count the total
	// Pass the array UpperCardScores, smallStraight, largeStraight, and totalScore to the Scorecard panel

    System.out.println("    FINAL SCORECARD " + player.playerName);
    System.out.println("--------------------------");
    // UPPER SCORECARD
    System.out.println("MERCURY: " + upperCardScores[0]);
    System.out.println("VENUS: " + upperCardScores[1]);
    System.out.println("MARS: " + upperCardScores[2]);
    System.out.println("JUPITER: " + upperCardScores[3]);
    System.out.println("SATURN: " + upperCardScores[4]);
    System.out.println("NEPTUNE: " + upperCardScores[5]);
    System.out.println("URANUS: " + upperCardScores[6]);

    for(int i = 0; i < numberOfDice; i++){
      totalScore += upperCardScores[i];
    }
    // LOWER SCORECARD

   // small straight line
   if(smallStraight > 0){
     System.out.println("Small Straight: " + smallStraight);
     totalScore += smallStraight;
   }else{
     System.out.println("Small Straight: 0");
   }

   // large straight line
   if(largeStraight > 0){
     System.out.println("Large Straight: " + largeStraight);
     totalScore += largeStraight;
   }else{
     System.out.println("Large Straight: 0");
   }

  // Display total score
  System.out.println("TOTAL SCORE: " + totalScore);
  }
}