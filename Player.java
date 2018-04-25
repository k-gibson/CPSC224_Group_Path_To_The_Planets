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
	private ScoreCard playerCard;
	private Die[] playerHand;
	private static int numRolls = 7;
	private ArrayList<Integer> travelList = new ArrayList<Integer>();
	
	/**
	 * 
	 * @param name
	 * @param card
	 */
	public void Player(String name) {
		playerHand = new Die[7];
		playerName = name;
		playerCard = new ScoreCard();
		
	}
	
	public void roll(int numRolls) {
	     int dieVal = 0;
		 for (int i = 0 ; i < numRolls ; i++) {
			 playerHand[i].rollDie(dieVal);
			 dieVal = 0;
		 }
	 }

	/**
	 * 
	 */
	private void takeTurn() {
		
		roll(numRolls);
		
	}
	
	public void planetTravel() {
		for (int i = 1 ; i <= 7 ; i++) {
			if (i == playerHand[i].getValueOfDie()) {
				travelList.add(i , playerHand[i].getValueOfDie());
			}
			else
				travelList.add(i, 0);
		}
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
		
	}
}
