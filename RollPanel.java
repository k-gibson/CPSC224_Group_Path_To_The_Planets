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
	
	public RollPanel(Player player) {
		createRollScreen(player);
	}
	
	public void actionPerformed(ActionEvent e) {
		// removes the roll panel and returns to the takeTurn function of the Game class
        finalPanel.remove(finalPanel.getIndexOf(mainPanel));
      	finalPanel.repaint();
      	createBackgroundImage();
    }
	
	private void createRollScreen(Player player) {
		setSize(defaultWidth, defaultHeight);
		createBackgroundImage();
		createMainPanel(player);
	}
	
	private void createMainPanel(Player player) {
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.setBackground(new java.awt.Color(40,23,35));
        mainPanel.setPreferredSize(new Dimension(defaultWidth,defaultHeight - 120));
        
     	//define a blank space for formatting purposes
        Filler space = new Filler(new Dimension(0, 80), new Dimension(0, 80), new Dimension(Short.MAX_VALUE, 80));
        //make the space 'see through'
  	    space.setOpaque(false);
  	    mainPanel.add(space);
  	    
  	    setUpRollButton();
	  	mainPanel.add(rollButton);
	    Filler blankSpace = new Filler(new Dimension(0, 80), new Dimension(0, 80), new Dimension(Short.MAX_VALUE, 80));
	    blankSpace.setOpaque(false);
	    mainPanel.add(blankSpace);
	  	//this is so the background image can been seen
	  	mainPanel.setOpaque(false);
	  	//this is for the JLayeredPane
	  	mainPanel.setBounds(0, 0, defaultWidth, defaultHeight);
	  	finalPanel.add(mainPanel, JLayeredPane.PALETTE_LAYER);
        
        JLabel playerName = new JLabel("PLAYER " + player.playerName);
        playerName.setFont(new Font("Krungthep",1,35));
        playerName.setForeground(Color.white);
        playerName.setAlignmentX(Component.CENTER_ALIGNMENT);
  	  	mainPanel.add(playerName, BorderLayout.NORTH);
	}
	
	private void setUpRollButton() {
		rollButton.setOpaque(true);
        rollButton.setFont(new Font("Krungthep",Font.BOLD,20));
        rollButton.setBackground(new Color(67,39,59));
        rollButton.setForeground(Color.WHITE);
        rollButton.setFocusPainted(false);
        rollButton.setBorderPainted(false);
        rollButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        rollButton.addActionListener(this); 
	}
	
	private void createBackgroundImage() {
		try {
    		spaceImage = new SpaceImage("/Users/kategibson/eclipse-workspace/gameGUI/components/stars.jpg");
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
