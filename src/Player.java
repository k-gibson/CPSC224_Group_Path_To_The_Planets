/**
 * This Class holds player information as well
 *  as runs a player's turn for rolling for planets
 *
 *  @author Parker Mooseker
 *  @version v1.0
 *
 */

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
			turn++;
			System.out.println("");
	}
	
	public int getTurnNumber() {
		return turn;
	}

  public boolean score(Player player){
    boolean winnerFound = false;
    player.playerCard.upperScoreCard();
    player.playerCard.bonusScores();
    if(player.playerCard.checkForWinner()){
      winnerFound = true;
    }
    return winnerFound;
  }
  
  public String getHandValue(int index) {
		String handValAsString = "";

		handValAsString = playerHand[index].getValue().toString();

		return handValAsString;
	}
}