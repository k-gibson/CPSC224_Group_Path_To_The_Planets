/**
* Displays a panel telling the users which players turn it is and which round it is
* The panel that shows the dice that have been rolled is displayed on top of this panel
* CPSC 224-01, Spring 2018
* Final Project - Race Through Space
* class TurnPanel.java
* @author Alana Dillinger
* @version v1.0 5/4/2018
*/

import javax.swing.*;
import javax.swing.Box.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class TurnPanel extends JFrame implements ActionListener{
	private JPanel mainPanel = new JPanel();
	private JButton enterButton = new JButton("CONTINUE");
	private JButton seeScorecardButton = new JButton("SEE YOUR SCORECARD");
	
	private Player thisPlayer;
	private int numbaOfTurns;
	
	private static final int defaultWidth = 1200;
	private static final int defaultHeight = 800;
	
	/**
	  *Sets up the panel to display which player is taking a turn and what turn they are on
	  *@param int index which turn it is
	  *@param Player player is the player who is taking the turn
	  *@throws IOException if the images are not found
	  */
	public TurnPanel(int index, Player player) throws IOException{
		thisPlayer = player;
		numbaOfTurns = player.getTurnNumber();
		
		setSize(defaultWidth, defaultHeight);
		createMainPanel();
		this.setTitle("Race Through Space");
		this.setVisible(true);
	}
	
	/**
	  * When the user clicks the continue button, the ActionListener reacts by displaying the new roll panel
	  * @param ActionEvent e is the action of the button the user clicks
	  */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == seeScorecardButton) {
			ScorecardFrame scorecardFrame = new ScorecardFrame(thisPlayer.playerCard.upperCardScores, thisPlayer.playerCard.smallStraight, thisPlayer.playerCard.largeStraight,
					thisPlayer.playerCard.triForce, thisPlayer.playerCard.totalScore);
			scorecardFrame.setVisible(true);
		}
		else {
			// gets rid of the turn panel and returns to the takeTurn function in the Game class
	      	this.setVisible(false);
		}
    }
	
	/**
	  * Formats the main panel with Fillers, labels, and the continue buttons
	  * @throws IOException if the planet pictures are not found
	  */
	private void createMainPanel() throws IOException{
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.setBackground(new java.awt.Color(40,23,35));
        mainPanel.setPreferredSize(new Dimension(defaultWidth,defaultHeight - 120));
        
        addButtonPanels();
        
        JLabel yourRoll = new JLabel("Your Roll:");
        yourRoll.setFont(new Font("Krungthep",1,35));
        yourRoll.setForeground(Color.white);
        yourRoll.setAlignmentX(Component.CENTER_ALIGNMENT);
        yourRoll.setBackground(new java.awt.Color(40,23,35));
  	  	mainPanel.add(yourRoll, BorderLayout.NORTH);
  	    
	    Filler blankSpace = new Filler(new Dimension(0, 80), new Dimension(0, 80), new Dimension(Short.MAX_VALUE, 80));
	    blankSpace.setOpaque(false);
	    mainPanel.add(blankSpace);
	    
	    addRolledDicePanel();
	    
	  	//this is for the JLayeredPane
	  	mainPanel.setBounds(0, 0, defaultWidth, defaultHeight);
        
  	  	add(mainPanel);
	}
	
	/**
	  * Adds the rolledDicePanel on top of this panel
	  * @throws IOException if the planet pictures are not found
	  */
	private void addRolledDicePanel() throws IOException {
		RolledDiePanel rolledDiePanel = new RolledDiePanel(thisPlayer , numbaOfTurns);
		mainPanel.add(rolledDiePanel);
	}
	
	/**
	  * Formats the enter button and add an ActionListener so the game reacts when the button is pressed
	  */
	private void setUpEnterButton() {
		enterButton.setOpaque(true);
        enterButton.setFont(new Font("Krungthep",Font.BOLD,20));
        enterButton.setBackground(new Color(67,39,59));
        enterButton.setForeground(Color.WHITE);
        enterButton.setFocusPainted(false);
        enterButton.setBorderPainted(false);
        
        enterButton.addActionListener(this); 
	}
	
	/**
	  * Formats the scorecard button and add an ActionListener so the game reacts when the button is pressed
	  */
	private void setUpScorecardButton() {
		seeScorecardButton.setOpaque(true);
        seeScorecardButton.setFont(new Font("Krungthep",Font.BOLD,20));
        seeScorecardButton.setBackground(new Color(67,39,59));
        seeScorecardButton.setForeground(Color.WHITE);
        seeScorecardButton.setFocusPainted(false);
        seeScorecardButton.setBorderPainted(false);
        
        seeScorecardButton.addActionListener(this); 
	}
	
	/**
	  * Adds the buttons to the panel in the correct locations
	  */
	private void addButtonPanels() {
		setUpEnterButton(); 
		setUpScorecardButton();
		
    	JPanel mainButtonPanel = new JPanel();
        mainButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        mainButtonPanel.setBackground(new java.awt.Color(40,23,35));
        mainButtonPanel.add(seeScorecardButton);
        this.add(mainButtonPanel,BorderLayout.NORTH);
     
        
        JPanel lowerButtonsPanel = new JPanel();
        lowerButtonsPanel.setLayout(new BoxLayout(lowerButtonsPanel, BoxLayout.LINE_AXIS));
        lowerButtonsPanel.add(Box.createHorizontalGlue());
        lowerButtonsPanel.add(enterButton);
        lowerButtonsPanel.setBackground(new java.awt.Color(40,23,35));
        this.add(lowerButtonsPanel, BorderLayout.SOUTH);
    }
}