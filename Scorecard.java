/**
* This class scores a game of Yahtzee
* This class contains methods to sort the array, score the upper half and the lower half of the upperScoreCard
* and display the different lines of the scorecard and the score you would receive,
* find the maximum of a kind, the maximum straight, find a full house, total all the dice,
* display the dice, and display the final scorecard at the end of the game.
* CPSC 224-01, Spring 2018
* Programming Assignment #6
* class Scorecard.java
* @author Alana Dillinger
* @version v1.0 3/23/2018
*/

import java.util.Scanner;



public class Scorecard {
  Scanner input = new Scanner(System.in);

  public int numberOfSides = 7;
  public int numberOfDice = 7;
  int totalScore;
  int smallStraight;
  int largeStraight;
  boolean hasNotScored;
  int[] upperCardScores;
  boolean[] scored;
  Die[] dice;


  /**
  * Scorecard constructor stores an array of dice that contains the same dice
  * that are stored in the dice array in the Yahtzee class
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
  * Scores the upper half of the scorecard
  * The upper half contains counts of each separate number
  * Each line will only be displayed as an option if it has not yet been scored
  */
  public void upperScoreCard(){
	// No GUI needed in this function... I think  
	  
    // reset boolean array to false to check what has been scored this turn
    for (int i = 0; i < numberOfDice; i++){
      scored[i] = false;
    }
    if(dice[0].getValue()== Die.Planet.MERCURY){
      upperCardScores[0] = 7;
      scored[0] = true;
      hasNotScored = false;
    }
    if(dice[1].getValue()==Die.Planet.VENUS){
      upperCardScores[1] = 8;
      scored[0] = true;
      hasNotScored = false;
    }
    if(dice[2].getValue()==Die.Planet.MARS) {
      upperCardScores[2] = 9;
      scored[0] = true;
      hasNotScored = false;
    }
    if(dice[3].getValue()==Die.Planet.JUPITER) {
      upperCardScores[3] = 10;
      scored[0] = true;
      hasNotScored = false;
    }
    if(dice[4].getValue()==Die.Planet.SATURN) {
      upperCardScores[4] = 11;
      scored[0] = true;
      hasNotScored = false;
    }
    if(dice[5].getValue()==Die.Planet.URANUS) {
      upperCardScores[5] = 12;
      scored[0] = true;
      hasNotScored = false;
    }
    if(dice[6].getValue().equals(Die.Planet.NEPTUNE)) {
      upperCardScores[6] = 13;
      scored[0] = true;
      hasNotScored = false;
    }
  }

  /**
  * Score the lower half of the scorecard
  * The lower half contains points for straights, full houses, etc.
  * Each score will only be displayed if it has not yet been filled in on the scorecard
  */
  public void bonusScores(){
	// No GUI
    if(smallStraight == 0){
      if(maxStraightFound() == 2){
        smallStraight = 30;
      }
    }

    if(largeStraight == 0){
      if(maxStraightFound() == 3){
        largeStraight = 30;
      }
    }
  }

    private int maxStraightFound(){
    	// No GUI
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

    public boolean checkForWinner(){
      // No GUI
      for(int i = 0; i < numberOfDice; i++){
        if(upperCardScores[i]==0)
          return false;
      }
      return true;
    }


  /**
    * Displays the final score card once the game has finished
    * Adds up all of the points on the card and displays the total at the bottom
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
