import javax.swing.*;
import javax.swing.Box.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	public RollPanel(Player player, Integer index, CompletedListener completedListener) { //, CompletedListener completedListener) {
		this.completedListener = completedListener;
		this.index = index;
		thisPlayer = player;
		createRollScreen(player);
		this.setVisible(true);
		this.setTitle("Race Through Space");
	}
	
	public void actionPerformed(ActionEvent e) {
		completedListener.completed(index);

		TurnPanel thisTurn = new TurnPanel(index, thisPlayer);
		thisTurn.setVisible(true);
		this.setVisible(false);
    }
	
	private void createRollScreen(Player player) {
		setSize(defaultWidth, defaultHeight);
		createBackgroundImage();
		createMainPanel(player);
	}
	
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
