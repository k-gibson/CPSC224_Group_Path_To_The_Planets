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

public class Scorecard {
  Scanner input = new Scanner(System.in);

  public int numberOfSides = 7;
  public int numberOfDice = 7;


  /**
  * Scorecard constructor stores an array of dice that contains the same dice
  * that are stored in the dice array in the Yahtzee class
  */
  public Scorecard(Die[] dice){
    Die[] finalDice = dice;
    // set everything to zero since nothing has yet been scored
    public int totalScore = 0;
    int smallStraight = 0;
    int largeStraight = 0;
    boolean hasNotScored = true;

    int[] upperCardScores = new int[numberOfSides];
    boolean[] hasBeenScored = new boolean[numberOfSides];
  }

  /**
  * Scores the upper half of the scorecard
  * The upper half contains counts of each separate number
  * Each line will only be displayed as an option if it has not yet been scored
  */
  public void upperScoreCard(){
    if(this.finalDice[0].getValue()==MERCURY){
      this.upperScoreCard[0] = 7;
      this.hasNotScored = false;
    }
    if(this.finalDice[1.getValue()VENUS){
      this.upperScoreCard[1] = 8;
      this.hasNotScored = false;
    }
    if(this.finalDice[2].getValue()==MARS) {
      this.upperScoreCard[2] = 9;
      this.hasNotScored = false;
    }
    if(this.finalDice[3].getValue()==JUPITER) {
      this.upperScoreCard[3] = 10;
      this.hasNotScored = false;
    }
    if(this.finalDice[4].getValue()==SATURN) {
      this.upperScoreCard[4] = 11;
      this.hasNotScored = false;
    }
    if(this.finalDice[5].getValue()==URANUS) {
      this.upperScoreCard[5] = 12;
      this.hasNotScored = false;
    }
    if(this.finalDice[6].getValue()==NEPTUNE) {
      this.upperScoreCard[6] = 13;
      this.hasNotScored = false;
    }
  }

  /**
  * Score the lower half of the scorecard
  * The lower half contains points for straights, full houses, etc.
  * Each score will only be displayed if it has not yet been filled in on the scorecard
  */
  private void bonusScores(){
    if(this.smallStraight == 0){
      if(maxStraightFound() == 3){
        this.smallStraight = 30;
      }
    }

    if(this.largeStraight == 0){
      if(maxSraightFound() == 5){
        this.largeStraight = 30;
      }
    }
  }

    private int maxStrightFound(){
      int maxStraight = 0;
      for(int i = 0; i < numberOfDice; i++){
        if(this.upperScoreCard[i] != 0){
          maxStraight++;
        }
        else
          maxStraight = 0;
      }
    }

    public boolean checkForWinner(){
      for(int i = 0; i < numberOfDice; i++){
        if(this.finalDice[i] == 0)
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
    System.out.println("MERCURY: " + this.finalDice[0]);
    System.out.println("VENUS: " + this.finalDice[1]);
    System.out.println("MARS: " + this.finalDice[2]);
    System.out.println("JUPITER: " + this.finalDice[3]);
    System.out.println("SATURN: " + this.finalDice[4]);
    System.out.println("NEPTUNE: " + this.finalDice[5]);
    System.out.println("URANUS: " + this.finalDice[6]);

    for(int i = 0; i < numberOfDice; i++){
      this.totalScore += this.upperScoreCard[i];
    }
    // LOWER SCORECARD

   // small straight line
   if(this.smallStraight > 0){
     System.out.println("Small Straight: " + this.smallStraight);
     this.totalScore += this.smallStraight;
   }else{
     System.out.println("Small Straight: 0");
   }

   // large straight line
   if(this.largeStraight > 0){
     System.out.println("Large Straight: " + this.largeStraight);
     this.totalScore += this.largeStraight;
   }else{
     System.out.println("Large Straight: 0");
   }

  // Display total score
  System.out.println("TOTAL SCORE: " + this.totalScore);
  }
}
