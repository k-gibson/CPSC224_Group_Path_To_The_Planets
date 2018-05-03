/**
* Displays a panel telling the users which players turn it is and which round it is
* The panel that shows the dice that have been rolled is displayed on top of this panel
* CPSC 224-01, Spring 2018
* Final Project - Race Through Space
* class TurnPanel.java
* @author Kathrine Gibson
* @version v1.0 5/4/2018
*/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.Box.*;

public class WinFrame extends JFrame implements ActionListener{
		private JLayeredPane finalPanel = getLayeredPane();
		private JPanel mainPanel = new JPanel();
		private JPanel spaceImage;
		private JButton scoreCardButton = new JButton("SEE SCORECARD");
		private Player player;
		private Player[] players;
		
		 private static final int defaultWidth = 1200;
		 private static final int defaultHeight = 800;
		
		 /**
		  *Creates variables to store player information which is used to create the winner screen
		  *@param Player player is which player won
		  *@param Player[] players is the array of all the players
		  */
		public WinFrame(Player player, Player[] players) {
			this.player = player;
			this.players = players;
			createWinScreen();
		}
		
		/**
		  *Sets up the winner screen with the default size to load the star background image with the main panel displayed over the image
		  */
		private void createWinScreen() {
			setSize(defaultWidth, defaultHeight);
			createBackgroundImage();
			
			createMainPanel();
		}
		 
		/**
		  * Formats the scorecard button and add an ActionListener so the game reacts when the button is pressed
		  */
		 private void setUpScoreCardButton() {
			 scoreCardButton.setOpaque(true);
		     scoreCardButton.setFont(new Font("Krungthep",Font.BOLD,25));
		     scoreCardButton.setBackground(new Color(67,39,59));
		     scoreCardButton.setForeground(Color.WHITE);
		     scoreCardButton.setFocusPainted(false);
		     scoreCardButton.setBorderPainted(false);
		     scoreCardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		        
		     scoreCardButton.addActionListener(this); 
		 }
		 
		 /**
		  * When the scorecard button is clicked the ActionListener opens the finalScorecardPanel
		  * @param ActionEvent e is the action of the user clicking the scorecard button
		  */
		 public void actionPerformed(ActionEvent e) {
			FinalScorecardPanel finalScorecard = new FinalScorecardPanel(players);
			finalScorecard.setVisible(true);
		 }
		
		 /**
		  * Formats the main panel with the labels to tell the suer who won and the buttons needed to see the final scorecard
		  * sets the text font, size, and color
		  * Adds the drawn star to the main panel
		  */
		private void createMainPanel() {
			mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
			mainPanel.setBackground(new java.awt.Color(40,23,35));
	        mainPanel.setPreferredSize(new Dimension(defaultWidth,defaultHeight - 120));
	        
	     	//define a blank space for formatting purposes
	        Filler space = new Filler(new Dimension(0, 80), new Dimension(0, 80), new Dimension(Short.MAX_VALUE, 80));
	        //make the space 'see through'
	  	    space.setOpaque(false);
	  	    mainPanel.add(space);
	        
	        JLabel congratulations = new JLabel("Congratulations Player " + player.playerName);
	        congratulations.setFont(new Font("Krungthep",1,35));
	        congratulations.setForeground(Color.white);
	        congratulations.setAlignmentX(Component.CENTER_ALIGNMENT);
	  	  	mainPanel.add(congratulations, BorderLayout.NORTH);
	  	  	   
	        JLabel greeting = new JLabel("YOU WIN");
	        greeting.setFont(new Font("Krungthep",1,200));
	        greeting.setForeground(Color.white);
	        greeting.setAlignmentX(Component.CENTER_ALIGNMENT);
	        
	        JLabel greetingShadow = new JLabel("YOU WIN");
	        greetingShadow.setFont(new Font("Krungthep",1,203));
	        greetingShadow.setForeground(Color.blue);
	        greetingShadow.setAlignmentX(Component.CENTER_ALIGNMENT);
	  	  	greeting.add(greetingShadow, BorderLayout.NORTH);
	        
	  	  	mainPanel.add(greeting, BorderLayout.NORTH);
	  	  	setUpScoreCardButton();
	  	  	mainPanel.add(scoreCardButton);
	  	  	
	  	  	DrawStarShape star = new DrawStarShape();
	  	  	
	  	  	mainPanel.add(star);
	  	
		  	//this is so the background image can been seen
		  	mainPanel.setOpaque(false);
		  	
		  	//this is for the JLayeredPane
		  	mainPanel.setBounds(0, 0, defaultWidth, defaultHeight);
		  	
		  	finalPanel.add(mainPanel, JLayeredPane.PALETTE_LAYER);
		}
		
		/**
		  * Finds the space image in the component folder and sets this image as the main panels background
		  */
		private void createBackgroundImage() {
			try {
				spaceImage = new SpaceImage(7);
				spaceImage.setPreferredSize(new Dimension(defaultWidth, defaultHeight - 120));
				spaceImage.setBackground(new java.awt.Color(40, 23, 35));
				spaceImage.setBounds(0, 0, defaultWidth, defaultHeight);
			} catch (IOException e) {
				JLabel oops = new JLabel("oops");
				this.add(oops);
			}

			finalPanel.add(spaceImage, JLayeredPane.DEFAULT_LAYER);
		}
}