/**
* Displays the final total scores on a panel to be displayed at the end of the game after a player has won
* CPSC 224-01, Spring 2018
* Final Project - Race Through Space
* class FinalScorecardPanel.java
* @author Alana Dillinger
* @version v1.0 5/4/2018
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FinalScorecardPanel extends JFrame implements ActionListener {
	private static final int defaultWidth = 1200;
    private static final int defaultHeight = 800;
    
    private JButton doneButton = new JButton("Done");
    private JPanel cardPanel = new JPanel();
    
    /**
	  * Sets up the panel with the default size and adds components to the panel to be displayed on the screen
	  * @param Player[] players the array of all the players in the game
	  */
    public FinalScorecardPanel(Player[] players) {
    	setSize(defaultWidth, defaultHeight);
    	this.setLayout(new BorderLayout());
    	
    	formatDoneButton();
    	cardPanel = createCardPanel(players);
    	
    	addButton();
    	add(cardPanel);
    }
    
    /**
	  * Adds the 'done' button to the button panel which is added to the cardPanel
	  */
    private void addButton() {
    	JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new java.awt.Color(40,23,35));
        buttonPanel.add(doneButton);
        this.add(buttonPanel,BorderLayout.NORTH);
    }
    
    /**
	  * Formats the done button and add an ActionListener so the game reacts when the button is pressed
	  */
    private void formatDoneButton() {
    	doneButton.setOpaque(true);
        doneButton.setFont(new Font("Krungthep",Font.BOLD,20));
        doneButton.setBackground(new Color(67,39,59));
        doneButton.setForeground(Color.WHITE);
        doneButton.setFocusPainted(false);
        doneButton.setBorderPainted(false);
        doneButton.addActionListener(this);
    }
    
    /**
	  * creates the card panel with the background color, font, text size, and text color
	  * adds the labels with the players numbers and total scores and the title label
	  * @return JPanel returnPanel is the completed panel which will be displayed on the screen
	  */
    private JPanel createCardPanel(Player[] players) {
    	JPanel returnPanel = new JPanel();
    	returnPanel.setLayout(new BoxLayout(returnPanel, BoxLayout.PAGE_AXIS));
    	returnPanel.setBackground(new java.awt.Color(40,23,35));
        returnPanel.setPreferredSize(new Dimension(defaultWidth,defaultHeight - 120));
        
        JPanel title = new JPanel();
        JLabel cardTitle = new JLabel("Final Game Scorecard");
        cardTitle.setFont(new Font("Krungthep",1,65));
        cardTitle.setForeground(Color.white);
        title.setBackground(new java.awt.Color(40,23,35));
        title.add(cardTitle);
        returnPanel.add(title, BorderLayout.NORTH);
        
        //player labels
        JPanel scoresPanel = new JPanel();
        scoresPanel.setLayout(new GridLayout(players.length,2,10,10));
        scoresPanel.setBackground(new java.awt.Color(40,23,35));
        scoresPanel.setPreferredSize(new Dimension(defaultWidth,defaultHeight - 120));
        JLabel[] playerLabels = new JLabel[players.length];
        JLabel[] playerScoreLabels = new JLabel[players.length];
        // convert players scores to strings
        String[] playerScores = new String[players.length];
        for(int i = 0; i < players.length; i++) {
        	playerScores[i] = String.valueOf(players[i].playerCard.totalScore);
        	System.out.println(playerScores[i]);
        }
        
        for(int i = 0; i < players.length; i++) {
        	playerLabels[i] = new JLabel("        Player " + (i+1));
        	playerScoreLabels[i] = new JLabel(playerScores[i]);
        	playerLabels[i].setFont(new Font("Krungthep",1,45));
            playerLabels[i].setForeground(Color.white);
            playerScoreLabels[i].setFont(new Font("Krungthep",1,45));
            playerScoreLabels[i].setForeground(Color.white);
        	
        	scoresPanel.add(playerLabels[i]);
        	scoresPanel.add(playerScoreLabels[i]);
        }
        
        returnPanel.add(scoresPanel,BorderLayout.NORTH);
        returnPanel.setOpaque(true);
        return returnPanel; 
    }
    
    /**
	  * When the done button is pressed, the scorecard goes away
	  */
    public void actionPerformed(ActionEvent e)
    { 
    	this.setVisible(false);
    }
}