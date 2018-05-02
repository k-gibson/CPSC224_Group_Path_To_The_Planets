/**
 * This Class holds player information as well
 *  as runs a player's turn for rolling for planets
 *
 *  @author Parker Mooseker
 *  @version v1.0
 *
 */
import java.util.ArrayList;


public class Player{

	public String playerName = "";
	private static int numDice = 7;
	public Scorecard playerCard;
	private Die[] playerHand;
	private int turn = 1;


	public Player(int playerNumber) {
		playerHand = new Die[numDice];
		playerName = Integer.toString(playerNumber);
		playerCard = new Scorecard(playerHand);

	}
	

	public void takeTurn(Player player){
		for(int i = 0; i < numDice; i++){
			this.playerHand[i] = new Die();
		}
		for(int i = 0; i < numDice; i++){
			this.playerHand[i].roll(7);
		}
		// instead of calling displayHand, we can call new panel to display roll
			displayHand(player); //DISPLAYROLL PANEL HERE
			turn++;
			System.out.println("");
	}
	
	public int getTurnNumber() {
		return turn;
	}

	private void displayHand(Player player){
		// This will all be GUI
		// We can get rid of this function and call a DisplayRoll panel which shows 7 dice with the planet rolled on each
		System.out.println(player.playerName + " rolled:");

		System.out.println("Mercury die: " + this.playerHand[0].getValue());
		System.out.println("Venus die: " + this.playerHand[1].getValue());
		System.out.println("Mars die: " + this.playerHand[2].getValue());
		System.out.println("Jupiter die: " + this.playerHand[3].getValue());
		System.out.println("Saturn die: " + this.playerHand[4].getValue());
		System.out.println("Uranus die: " + this.playerHand[5].getValue());
		System.out.println("Neptune die: " + this.playerHand[6].getValue());
	}

  public boolean score(Player player){
    boolean winnerFound = false;
    player.playerCard.upperScoreCard();
    player.playerCard.bonusScores();
    if(player.playerCard.checkForWinner()){
    	// Create a new panel that prints out "Congrats, you won."
    	WinFrame winnerPanel = new WinFrame();
      winnerFound = true;
    }
    return winnerFound;
  }

  public void finalScore(Player player){
	  // No GUI needed for this function, it will be called in the displayScorecard function in Scorecard class
    player.playerCard.displayScorecard(player);
  }
}