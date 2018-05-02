import javax.swing.JPanel;

public class RolledDiePanel extends JPanel{
	private JPanel mainPanel = new JPanel();
	
	private Player thisPlayer;
	
	public RolledDiePanel(Player player, int numberOfTurns){
		thisPlayer = player;
		setUpPanel();
	}
	
	private void setUpPanel() {
		mainPanel.setBackground(new java.awt.Color(0,0,0));
		//creates a JPanel with Gridlayout that displays the dice and what they rolled
		
				/*
				 * add mercury die image
				 * if playHand == which ever planets
				 * 		display that planets name over the die
				 * ^^^ for every die in every 
				 * 
				 */
	}
}