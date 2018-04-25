/**
* This class stores the face value of a dice to use playing Yahtzee.
* It contains the methods to roll the dice, get the value of the die
* and set a new value to the die for sorting the array of dice
* CPSC 224-01, Spring 2018
* Programming Assignment #6
* class Dice.java

* @author Alana Dillinger

* @version v1.0 3/23/2018
*/

import java.util.*;

public class Die{

  public enum planet{MERCURY, VENUS, MARS, JUPITER, SATURN, URANUS, NEPTUNE};
  private Random rand;

  /**
  * Die constructor stores an integer value and a variable rand to generate random numbers
  * Die is used and called by Yahtzee
  */
  public Die() {
    planet = NULL;
    rand = new Random();
  }

  /**
  * "Rolls the die" or assigns a random integer between 1 and 6 to the die's value
  */
  public void roll(int numberOfSides) {
    int value = rand.nextInt(numberOfSides);
    if(value ==0) planet = MERCURY;
    if(value ==1) planet = VENUS;
    if(value ==2) planet = MARS;
    if(value ==3) planet = JUPITER;
    if(value ==4) planet = SATURN;
    if(value ==5) planet = URANUS;
    if(value ==6) planet = NEPTUNE;
  }

  /**
    * Retrieves the value of a certain die
    * @return and integer of the value stored in that die
    */
  public int getValue() {
    return (planet);
  }

  /**
    * Changes a value of a specific die
    * Used for sorting the dice in the array
    */
  public void set(int newPlanet){
    this.planet = newPlanet;
  }
}
