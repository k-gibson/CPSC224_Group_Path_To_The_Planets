/**
* Creates the main panel of the Race Through Space game buttons for the player to begin a game or read the rules
* Loads the star background image and places title labels and buttons on top.
* CPSC 224-01, Spring 2018
* Final Project - Race Through Space
* class gameGUI.java
* @author Kathrine Gibson
* @version v1.0 5/4/2018
*/

import javax.swing.*;
import javax.swing.Box.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class gameGUI extends JFrame{
	private JPanel mainPanel = new JPanel();
	private SpaceImage spaceImage;
	private JLayeredPane finalPanel = getLayeredPane();
	
    private JButton rulesButton = new JButton("Rules");
    private JButton playButton = new JButton("Play");
    
    private static final int defaultWidth = 1200;
    private static final int defaultHeight = 800;
	
    /**
	  * Sets up the main panel of the game with the default size
	  * Calls methods to add everything that's needed to the main panel
	  */
	public gameGUI() {
		setSize(defaultWidth, defaultHeight);
		finalPanel.setPreferredSize(new Dimension(defaultWidth,defaultHeight));
		formatRulesButton();
		formatPlayButton();
		createMainPanel();
		createBackgroundImage(); 
	}
	
	/**
	  * Formats the play button and add an ActionListener so the game reacts when the button is pressed
	  */
	private void formatPlayButton() {
		playButton.setOpaque(true);
        playButton.setFont(new Font("Krungthep",Font.BOLD,60));
        playButton.setBackground(new Color(67,39,59));
        playButton.setForeground(Color.WHITE);
        playButton.setFocusPainted(false);
        playButton.setBorderPainted(false);
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        playButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	    NumberOfPlayers playerPanel = new NumberOfPlayers(new CompletedListener() {
	        	    	@Override
	        	    	public void completed(Object numberOfPlayers) {
	        	    		Game raceThroughSpace = new Game((int)numberOfPlayers);
	       	        	 	raceThroughSpace.playGame();
	        	    	}
	        	    });
	        	    playerPanel.setVisible(true);
	         }
	      });
	}
	
	/**
	  * Formats the rules button and add an ActionListener so the game reacts when the button is pressed
	  */
	private void formatRulesButton() {
		
		rulesButton.setOpaque(true);
        rulesButton.setFont(new Font("Krungthep",Font.BOLD,60));
        rulesButton.setBackground(new Color(67,39,59));
        rulesButton.setForeground(Color.WHITE);
        rulesButton.setFocusPainted(false);
        rulesButton.setBorderPainted(false);
        rulesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        rulesButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 RulesFrame rules = new RulesFrame();
	        	 rules.setTitle("Race Through Space Rules");
	        	 rules.setVisible(true);
	         }
	      });
	}
	
	/**
	  * Creates the main panel that is going to be displayed.
	  * Added the buttons, labels, and background image to display on the screen to the user
	  * Sets the font, text size, and text color for the labels
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
        
        JLabel welcome = new JLabel("Welcome To");
        welcome.setFont(new Font("Krungthep",1,35));
        welcome.setForeground(Color.white);
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
  	  	mainPanel.add(welcome, BorderLayout.NORTH);
  	  	   
        JLabel greeting = new JLabel("RACE THROUGH SPACE");
        greeting.setFont(new Font("Krungthep",1,85));
        greeting.setForeground(Color.white);
        greeting.setAlignmentX(Component.CENTER_ALIGNMENT);
  	  	mainPanel.add(greeting, BorderLayout.NORTH);
  	  	
  	    Filler blankSpace = new Filler(new Dimension(0, 80), new Dimension(0, 80), new Dimension(Short.MAX_VALUE, 80));
  	    blankSpace.setOpaque(false);
  	    mainPanel.add(blankSpace);
  	    
  	  	Filler newSpace = new Filler(new Dimension(0, 40), new Dimension(0, 40), new Dimension(Short.MAX_VALUE, 40));
  	    newSpace.setOpaque(false);
  	    
  	  	mainPanel.add(rulesButton);
  	  	mainPanel.add(newSpace);
	  	mainPanel.add(playButton);
	  	
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
			spaceImage = new SpaceImage(8);
			spaceImage.setPreferredSize(new Dimension(defaultWidth, defaultHeight));
			spaceImage.setBackground(new java.awt.Color(40, 23, 35));
			spaceImage.setBounds(0, 0, defaultWidth, defaultHeight);
		} catch (IOException e) {
			JLabel oops = new JLabel("oops");
			this.add(oops);
		}

		finalPanel.add(spaceImage, JLayeredPane.DEFAULT_LAYER);
	}
}