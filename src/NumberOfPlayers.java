/**
* Panel that appears on the screen that asks the users how many people are playing the game
* Stores the number that the user inputs to create the correct amount of players
* CPSC 224-01, Spring 2018
* Final Project - Race Through Space
* class NumberOfPlayers.java
* @author Kathrine Gibson
* @version v1.0 5/4/2018
*/

import javax.swing.*;
import javax.swing.Box.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.io.IOException;
import java.util.Map;

public class NumberOfPlayers extends JFrame implements ActionListener{
	private SpaceImage spaceImage;
	private JLayeredPane finalPanel = getLayeredPane();
	private JPanel mainPanel = new JPanel();
	private JTextField input = new JTextField (2);
	private JButton enterButton = new JButton("ENTER");
	private boolean hasUserInput = false;
	private CompletedListener completedListener;
	
	static Integer numberOfPlayers;
	
	private static final int defaultWidth = 1200;
    private static final int defaultHeight = 800;
	
    /**
	  * Sets up the background image to be the stars with the default size
	  * adds a listener to the panel so it waits for user input
	  * @param CompletedListener completedListener so the game waits for user input
	  */
	public NumberOfPlayers(CompletedListener completedListener) {
		this.completedListener = completedListener;
		setSize(defaultWidth, defaultHeight);
		createBackgroundImage(); 
		createMainPanel();
	}
	
	/**
	  * Tells the program when the user has entered input into the text field
	  * @return boolean hasUserInput if the user has entered the number of players yet or not
	  */
	public boolean getHasUserInput() {
		return hasUserInput;
	}
	
	/**
	  * Tells the program how many players the user wants to have
	  * @return int numberOfPlayers
	  */
	public int getPlayerNumber() {
		return numberOfPlayers;
	}
	
	/**
	  * creates the card panel with the background color, font, text size, and text color
	  * adds the labels with the players numbers and total scores and the title label
	  * add the mainPanel to the screen so the user can see it and interact with it
	  */
	private void createMainPanel() {
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setPreferredSize(new Dimension(defaultWidth,defaultHeight - 120));
        
     	//define a blank space for formatting purposes
        Filler space = new Filler(new Dimension(0, 80), new Dimension(0, 80), new Dimension(Short.MAX_VALUE, 180));
        //make the space 'see through'
  	    space.setOpaque(false);
  	    mainPanel.add(space);
        
        JLabel getNumber = new JLabel("Please Enter Number of Players:");
        getNumber.setFont(new Font("Krungthep",1,35));
  	  	Font font = getNumber.getFont();
  	  	Map attributes = font.getAttributes();
  	  	attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
  	  	getNumber.setFont(font.deriveFont(attributes));
        getNumber.setForeground(Color.white);
        getNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
  	  	mainPanel.add(getNumber);
  	  	
  	  	Filler newSpace = new Filler(new Dimension(0, 80), new Dimension(0, 80), new Dimension(Short.MAX_VALUE, 20));
	    newSpace.setOpaque(false);
	    mainPanel.add(newSpace);
  	  	
  	  	input.setMaximumSize(new Dimension(50, 30));
  	  	mainPanel.add(input);
  	  	
  	  	setUpEnterButton();
  	  	mainPanel.add(enterButton);
  	  
  	    Filler blankSpace = new Filler(new Dimension(0, 80), new Dimension(0, 80), new Dimension(Short.MAX_VALUE, 80));
  	    blankSpace.setOpaque(false);
  	    mainPanel.add(blankSpace);
  	    
	  	//this is so the background image can been seen
	  	mainPanel.setOpaque(false);
	  	//this is for the JLayeredPane
	  	mainPanel.setBounds(0, 0, defaultWidth, defaultHeight);
	  	finalPanel.add(mainPanel, JLayeredPane.PALETTE_LAYER);
	}
	
	/**
	  * Formats the done button and add an ActionListener so the game reacts when the button is pressed
	  */
	private void setUpEnterButton() {
		enterButton.setOpaque(true);
        enterButton.setFont(new Font("Krungthep",Font.BOLD,20));
        enterButton.setBackground(new Color(67,39,59));
        enterButton.setForeground(Color.WHITE);
        enterButton.setFocusPainted(false);
        enterButton.setBorderPainted(false);
        enterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        enterButton.addActionListener(this); 
	}
	
	/**
	  * When the user enter the number of players, it is stored in userInput and is converted to an integer
	  * If the user inputs an invalid number, an error appears and the users are allowed to re-enter their number
	  */
	 public void actionPerformed(ActionEvent e) {
       	 String userInput = input.getText();
       	 numberOfPlayers = Integer.parseInt(userInput);
       	
       	hasUserInput = true;
       	 if(numberOfPlayers > 7 || numberOfPlayers < 1) {
       		 JLabel error = new JLabel("<html>Sorry, you can only have up to 7 players, please close the window and try again<html>");
       		 error.setFont(new Font("Krungthep",1,35));
       		 error.setForeground(Color.white);
       		 error.setBounds(0, 0, defaultWidth, defaultHeight);
       		 input.setText("");
       		 finalPanel.add(error, JLayeredPane.POPUP_LAYER);
       		 finalPanel.repaint();
       		 hasUserInput = false;
       	 }
       	this.completedListener.completed(numberOfPlayers);
       	 
       	 System.out.println(numberOfPlayers);
       	 if (hasUserInput) {
       		 this.setVisible(false);
       	}
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