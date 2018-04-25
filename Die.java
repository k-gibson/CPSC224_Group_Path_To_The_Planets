/*
 * This program creates an object die with a certain face value
 * CPSC 224-02, Spring 2018
 * Final Project
 *
 * @author Kathrine Gibson
 *
 * @version 
 */

import java.util.*;

public class Die implements Comparable<Die> {

  private int valueOfDie;

  /*
  * Die constructor sets a default value to the die
  *
  * @param none
  * @returns none
  * @throw none
  */
  public Die() {
    valueOfDie = 0;
  }

  /*
  * Assigns an integer in the range of the user's
  *  defined sides on each die
  *
  * @param int sidesOnDie represents the number of sides on each die
  * @returns void
  * @throw none
  */
  public void rollDie(int dieVal) {
	  
	  dieVal = (int) (Math.random() * 7) + 1;
	  changeFaceValue(dieVal);
  }

  /*
  * Manually changes the face value of a die
  *
  * @param int newValue is the value to be changed to
  * @returns void
  * @throw none
  */
  public void changeFaceValue(int newValue) {
    valueOfDie = newValue;
  }

  /*
  * Gives the face value of a die
  *
  * @param none
  * @returns valueOfDie is the face value of the die
  * @throw none
  */
  public int getValueOfDie() {
    return valueOfDie;
  }

  /*
  * Overrides Array.sot and compares the face value of two die
  *
  * @param a- a die to compare  to
  * @returns the difference of to values of die
  * @throw none
  */
  @Override
  public int compareTo(Die a) {
    return this.valueOfDie - a.valueOfDie;
  }
}
