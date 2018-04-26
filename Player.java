/**
 * This Class holds player information as well
 *  as runs a player's turn for rolling for planets
 *
 *  @author Parker Mooseker
 *  @version v1.0
 *
 */
import java.util.ArrayList;


public class Player {

	private String playerName = "";
	private Scorecard playerCard;
	private Die[] playerHand;
	private static int numRolls = 7;
	private static int numDice = 7;
	private ArrayList<Integer> travelList = new ArrayList<Integer>();


	public Player(String name) {
		playerHand = new Die[7];
		int turn = 1;
		playerName = name;
		playerCard = new Scorecard(playerHand);

	}

   public void displayHand(){
     for(int i = 0; i < numDice; i++){
       System.out.println(this.playerHand[i] + " ");
     }
   }

	public void takeTurn() {
    for(int i = 0; i < numDice; i++)
		  playerHand[i].roll(numDice);
	}

  public boolean score(){
    boolean winnerFound = false;
    this.playerCard.upperScoreCard();
    this.playerCard.bonusScores();
    if(this.playerCard.checkForWinner()){
      System.out.println("YOU'VE WON!");
      System.out.println("Congratulations " + this.playerName);
      winnerFound = true;
    }
    return winnerFound;
  }

  public void finalScore(){
    this.playerCard.displayScorecard();
  }

	/*
  public void planetTravel() {
		for (int i = 1 ; i <= 7 ; i++) {
			if (i == playerHand[i].getValueOfDie()) {
				travelList.add(i , playerHand[i].getValueOfDie());
			}
			else
				travelList.add(i, 0);
		}
    this.turn++;
	}


  public void travelChoice(int travelOption) {
		switch (travelOption) {
			case 1 :
				System.out.println("you may travel to Mercury");
				break;
			case 2 :
				System.out.println("you may travel to Venus");
				break;
			case 3 :
				System.out.println("you may travel to Earth");
				break;
			case 4 :
				System.out.println("you may travel to Mars");
				break;
			case 5 :
				System.out.println("you may travel to Jupiter");
				break;
			case 6 :
				System.out.println("you may travel to Saturn");
				break;
			case 7 :
				System.out.println("you may travel to Neptune");
				break;
		}
	}*/

}
