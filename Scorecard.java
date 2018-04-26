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

import java.util.*;

public class Scorecard implements Die {
  Scanner input = new Scanner(System.in);

  public int numberOfSides = 7;
  public int numberOfDice = 7;
  int totalScore;
  int smallStraight;
  int largeStraight;
  boolean hasNotScored;
  int[] upperCardScores;
  boolean[] hasBeenScored;
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
    hasBeenScored = new boolean[numberOfSides];
  }

  /**
  * Scores the upper half of the scorecard
  * The upper half contains counts of each separate number
  * Each line will only be displayed as an option if it has not yet been scored
  */
  public void upperScoreCard(){
    if(dice[0].getValue()==MERCURY){
      upperCardScores[0] = 7;
      hasNotScored = false;
    }
    if(dice[1].getValue()==VENUS){
      upperCardScores[1] = 8;
      hasNotScored = false;
    }
    if(dice[2].getValue()==MARS) {
      upperCardScores[2] = 9;
      hasNotScored = false;
    }
    if(dice[3].getValue()==JUPITER) {
      upperCardScores[3] = 10;
      hasNotScored = false;
    }
    if(dice[4].getValue()==SATURN) {
      upperCardScores[4] = 11;
      hasNotScored = false;
    }
    if(dice[5].getValue()==URANUS) {
      upperCardScores[5] = 12;
      hasNotScored = false;
    }
    if(dice[6].getValue().equals(NEPTUNE)) {
      upperCardScores[6] = 13;
      hasNotScored = false;
    }
  }

  /**
  * Score the lower half of the scorecard
  * The lower half contains points for straights, full houses, etc.
  * Each score will only be displayed if it has not yet been filled in on the scorecard
  */
  public void bonusScores(){
    if(smallStraight == 0){
      if(maxStraightFound() == 3){
        smallStraight = 30;
      }
    }

    if(largeStraight == 0){
      if(maxStraightFound() == 5){
        largeStraight = 30;
      }
    }
  }

    private int maxStraightFound(){
      int maxStraight = 0;
      for(int i = 0; i < numberOfDice; i++){
        if(upperCardScores[i] != 0){
          maxStraight++;
        }
        else
          maxStraight = 0;
      }
    }

    public boolean checkForWinner(){
      for(int i = 0; i < numberOfDice; i++){
        if(dice[i].equals(0))
          return false;
      }
      return true;
    }


  /**
    * Displays the final score card once the game has finished
    * Adds up all of the points on the card and displays the total at the bottom
    */
  public void displayScorecard(){

    System.out.println("    FINAL SCORECARD");
    System.out.println("--------------------------");
    // UPPER SCORECARD
    System.out.println("MERCURY: " + dice[0]);
    System.out.println("VENUS: " + dice[1]);
    System.out.println("MARS: " + dice[2]);
    System.out.println("JUPITER: " + dice[3]);
    System.out.println("SATURN: " + dice[4]);
    System.out.println("NEPTUNE: " + dice[5]);
    System.out.println("URANUS: " + dice[6]);

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
