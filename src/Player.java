/**
* This class stores the player objects which store the players hand, their number, and their scorecard
* Players can take turns, score their turn, see their turn number, and see the dice in their current hand
* CPSC 224-01, Spring 2018
* Final Project - Race Through Space
* class Player.java
* @author Parker Mooseker
* @version v1.0 5/4/2018
*/

public class Player{

	public String playerName = "";
	private static int numDice = 7;
	public Scorecard playerCard;
	private Die[] playerHand;
	private int turn = 1;

	/**
	* The Player constructor stores a players hand, their number, and their scorecard
	*/
	public Player(int playerNumber) {
		playerHand = new Die[numDice];
		playerName = Integer.toString(playerNumber);
		playerCard = new Scorecard(playerHand);
	}

	/**
	* When a player takes a turn they get a hand of new dice and then roll all seven dice
	*/
	public void takeTurn(Player player){
		for(int i = 0; i < numDice; i++){
			this.playerHand[i] = new Die();
		}
		for(int i = 0; i < numDice; i++){
			this.playerHand[i].roll(7);
		}
		turn++;
	}
	
	/**
	* @return the turn number the player is on
	*/
	public int getTurnNumber() {
		return turn;
	}

	/**
	* Scores the players turn on their card, playerCard
	* Checks to see if the player has visited all seven planets and if the game should end
	* @return boolean winnerFound to Game to check if the game should end or not
	*/
    public boolean score(Player player){
        boolean winnerFound = false;
        player.playerCard.upperScoreCard();
        player.playerCard.bonusScores();
        if(player.playerCard.checkForWinner()){
          winnerFound = true;
        }
        return winnerFound;
    }
  
    /**
	* Reads a requested die in the players hand
	* @param int index of which die value is needed
	* @return String handValAsString which is the String of the face value of the die
	*/
    public String getHandValue(int index) {
		String handValAsString = "";

		handValAsString = playerHand[index].getValue().toString();

		return handValAsString;
	}
}