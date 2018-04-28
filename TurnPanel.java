import javax.swing.*;
import javax.swing.Box.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


public class TurnPanel extends JFrame implements ActionListener{
	private JLayeredPane finalPanel = getLayeredPane();
	private JPanel mainPanel = new JPanel();
	private JPanel spaceImage;
	private JButton enterButton = new JButton("CONTINUE");
	
	 private static final int defaultWidth = 1200;
	 private static final int defaultHeight = 800;
	
	public TurnPanel(int numberOfTurns) {
		createTurnScreen(numberOfTurns);
	}
	
	public void actionPerformed(ActionEvent e) {
		// gets rid of the turn panel and returns to the takeTurn function in the Game class
      	finalPanel.remove(finalPanel.getIndexOf(mainPanel));
      	finalPanel.repaint();
        createBackgroundImage();
    }
	
	private void createTurnScreen(int numberOfTurns) {
		setSize(defaultWidth, defaultHeight);
		createBackgroundImage();
		createMainPanel(numberOfTurns);
	}
	
	private void createMainPanel(int numberOfTurns) {
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.setBackground(new java.awt.Color(40,23,35));
        mainPanel.setPreferredSize(new Dimension(defaultWidth,defaultHeight - 120));
        
     	//define a blank space for formatting purposes
        Filler space = new Filler(new Dimension(0, 80), new Dimension(0, 80), new Dimension(Short.MAX_VALUE, 80));
        //make the space 'see through'
  	    space.setOpaque(false);
  	    mainPanel.add(space);
  	    
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
        
        JLabel turnNum = new JLabel("TURN " + numberOfTurns);
        turnNum.setFont(new Font("Krungthep",1,35));
        turnNum.setForeground(Color.white);
        turnNum.setAlignmentX(Component.CENTER_ALIGNMENT);
  	  	mainPanel.add(turnNum, BorderLayout.NORTH);
	}
	
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
	
	private void createBackgroundImage() {
		try {
		final String currentWorkingDirectory = System.getProperty("stars.jpg");
    		spaceImage = new SpaceImage(currentWorkingDirectory);
    		spaceImage.setPreferredSize(new Dimension(defaultWidth,defaultHeight - 120));
    		spaceImage.setBackground(new java.awt.Color(40,23,35));
    		spaceImage.setBounds(0, 0, defaultWidth, defaultHeight); 
    	} catch (IOException e) {
    		JLabel oops = new JLabel("oops");
    		this.add(oops);
    	}
		
		finalPanel.add(spaceImage, JLayeredPane.DEFAULT_LAYER);
	}
}
