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
	
	public TurnPanel(int numberOfTurns, Player player) {
		thisPlayer = player;
		numbaOfTurns = numberOfTurns;
		
		setSize(defaultWidth, defaultHeight);
		createMainPanel(numberOfTurns);
		this.setTitle("Race Through Space");
		this.setVisible(true);
	}
	
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
	
	private void createMainPanel(int numberOfTurns) {
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
	
	private void addRolledDicePanel() {
		
		RolledDiePanel rolledDiePanel = new RolledDiePanel(thisPlayer, numbaOfTurns);
		
		mainPanel.add(rolledDiePanel);
	}
	
	private void setUpEnterButton() {
		enterButton.setOpaque(true);
        enterButton.setFont(new Font("Krungthep",Font.BOLD,20));
        enterButton.setBackground(new Color(67,39,59));
        enterButton.setForeground(Color.WHITE);
        enterButton.setFocusPainted(false);
        enterButton.setBorderPainted(false);
        
        enterButton.addActionListener(this); 
	}
	
	private void setUpScorecardButton() {
		seeScorecardButton.setOpaque(true);
        seeScorecardButton.setFont(new Font("Krungthep",Font.BOLD,20));
        seeScorecardButton.setBackground(new Color(67,39,59));
        seeScorecardButton.setForeground(Color.WHITE);
        seeScorecardButton.setFocusPainted(false);
        seeScorecardButton.setBorderPainted(false);
        
        seeScorecardButton.addActionListener(this); 
	}
	
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