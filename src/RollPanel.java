/**
* Creates the panel that tells the users whose turn it is
* The users interact by clicking the roll dice button to take a turn
* CPSC 224-01, Spring 2018
* Final Project - Race Through Space
* class RollPanel.java
* @author Alana Dillinger and Kathrine Gibson
* @version v1.0 5/4/2018
*/

import javax.swing.*;
import javax.swing.Box.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class RollPanel extends JFrame implements ActionListener {
	private JLayeredPane finalPanel = getLayeredPane();
	private JPanel mainPanel = new JPanel();
	private JPanel spaceImage;
	private JButton rollButton = new JButton("ROLL DICE");
	
	private static final int defaultWidth = 1200;
	private static final int defaultHeight = 800;
	private CompletedListener completedListener;
	
	private Player thisPlayer;
	
	private Integer index = 0;
	private Integer currentRound = 0;
	
	/**
	  * Creates the roll panel with different methods and displays the panel on the screen
	  * @param Player player is the player who is taking a turn
	  * @param Integer currentRound is the round the game is on
	  * @param CompletedListener completedListener tells the game when to continue
	  */
	public RollPanel(Player player, Integer index, Integer currentRound, CompletedListener completedListener) {
		this.completedListener = completedListener;
		this.index = index;
		this.currentRound = currentRound;
		thisPlayer = player;
		createRollScreen(player);
		this.setVisible(true);
		this.setTitle("Race Through Space");
	}
	
	/**
	  * When the user clicks the 'ROLL DICE' button, a new panel is displayed to show the dice that have been rolled
	  */
	public void actionPerformed(ActionEvent e) {
		Object[] datas = new Object[] {index, currentRound};
		completedListener.completed(datas);

		try {
		TurnPanel thisTurn = new TurnPanel(index, thisPlayer);
		thisTurn.setVisible(true);
		this.setVisible(false);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
	
	/**
	  *Loads the background image and creates the panel to be displayed on top
	  *@param Player player the player whose turn it is
	  */
	private void createRollScreen(Player player) {
		setSize(defaultWidth, defaultHeight);
		createBackgroundImage();
		createMainPanel(player);
	}
	
	/**
	  * Creates the panel that is going to be displayed with the buttons and titles
	  * @param Player player is the player whose turn it is
	  */
	private void createMainPanel(Player player) {
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setPreferredSize(new Dimension(defaultWidth,defaultHeight));
        
     	//define a blank space for formatting purposes
        Filler space = new Filler(new Dimension(0, 80), new Dimension(0, 80), new Dimension(Short.MAX_VALUE, 80));
        //make the space 'see through'
  	    space.setOpaque(false);
  	    mainPanel.add(space);
  	    
        JLabel playerName = new JLabel("Player " + player.playerName + "'s Turn #" + player.getTurnNumber());
        playerName.setFont(new Font("Krungthep",1,50));
        playerName.setForeground(Color.white);
        playerName.setAlignmentX(Component.CENTER_ALIGNMENT);
  	  	mainPanel.add(playerName, BorderLayout.NORTH);

  	  	Filler newSpace = new Filler(new Dimension(0, 80), new Dimension(0, 80), new Dimension(Short.MAX_VALUE, 80));
  	  	//make the space 'see through'
	    newSpace.setOpaque(false);
	    mainPanel.add(newSpace);
  	  	
  	  	setUpRollButton();
  	  	mainPanel.add(rollButton);
  	  	
	  	//this is so the background image can been seen
	  	mainPanel.setOpaque(false);
	  	//this is for the JLayeredPane
	  	mainPanel.setBounds(0, 0, defaultWidth, defaultHeight);
	  	finalPanel.add(mainPanel, JLayeredPane.PALETTE_LAYER); 
	}
	
	/**
	  * Formats the roll button and add an ActionListener so the game reacts when the button is pressed
	  */
	private void setUpRollButton() {
		rollButton.setOpaque(true);
        rollButton.setFont(new Font("Krungthep",Font.BOLD,100));
        rollButton.setBackground(new Color(176,4,28));
        rollButton.setForeground(Color.WHITE);
        rollButton.setFocusPainted(false);
        rollButton.setBorderPainted(false);
        rollButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        rollButton.addActionListener(this); 
	}
	
	/**
	  * Finds the space image in the component folder and sets this image as the main panels background
	  */
	private void createBackgroundImage() {
		try {
		 spaceImage = new SpaceImage(7);
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