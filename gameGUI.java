import javax.swing.*;
import javax.swing.Box.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class gameGUI extends JFrame implements ActionListener{
	private JPanel mainPanel = new JPanel();
	private SpaceImage spaceImage;
	JLayeredPane finalPanel = getLayeredPane();
	
    private JButton rulesButton = new JButton("Rules");
    private JButton playButton = new JButton("Play");
    
    private static final int defaultWidth = 1200;
    private static final int defaultHeight = 800;
	
	public gameGUI() {
		setSize(defaultWidth, defaultHeight);
		finalPanel.setPreferredSize(new Dimension(defaultWidth,defaultHeight));
		formatRulesButton();
		formatPlayButton();
		createMainPanel();
		createBackgroundImage(); 
	}
	
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
	        	 Game pathToThePlanets = new Game(mainPanel);
	         }
	      });
	}
	
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
	        	 rules.setTitle("Path To The Planets Rules");
	        	 rules.setVisible(true);
	         }
	      });
	}
	
	private void createMainPanel() {
		JPanel mainPanel = new JPanel();
		
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
  	  	   
        JLabel greeting = new JLabel("PATH TO THE PLANETS");
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == rulesButton) {
			 RulesFrame rules = new RulesFrame();
        	 rules.setTitle("Path To The Planets Rules");
        	 rules.setVisible(true);
    	}
    	else {
    		mainPanel.setBackground(Color.green);
       	 	Game pathToThePlanets = new Game(mainPanel);
    	}
		
	}
}
