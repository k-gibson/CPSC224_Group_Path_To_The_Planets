import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gameGUI extends JFrame implements ActionListener{
	private JPanel mainPanel = new JPanel(); 
	
    private JButton rulesButton = new JButton("Rules");
    private JButton playButton = new JButton("Play");
    
    private static final int defaultWidth = 1200;
    private static final int defaultHeight = 800;
	
	public gameGUI() {
       setSize(defaultWidth, defaultHeight);

       formatRulesButton();
       formatPlayButton();
       mainPanel = createMainPanel();
            
       add(mainPanel);     
	}
	
	private void formatPlayButton() {
		playButton.setOpaque(true);
        playButton.setFont(new Font("Serif",Font.BOLD,30));
        playButton.setBackground(new Color(67,39,59));
        playButton.setForeground(Color.WHITE);
        playButton.setFocusPainted(false);
        playButton.setBorderPainted(false);
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        playButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 mainPanel.setBackground(Color.green);
	        	 Game pathToThePlanets = new Game(mainPanel);
	         }
	      });
	}
	
	private void formatRulesButton() {
		rulesButton.setOpaque(true);
        rulesButton.setFont(new Font("Serif",Font.BOLD,30));
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
	
	
	private JPanel createMainPanel() {
		JPanel returnPanel = new JPanel();
		returnPanel.setLayout(new BoxLayout(returnPanel, BoxLayout.PAGE_AXIS));
		returnPanel.setBackground(new java.awt.Color(40,23,35));
        returnPanel.setPreferredSize(new Dimension(defaultWidth,defaultHeight - 120));
        
        JLabel welcome = new JLabel("Welcome To");
        welcome.setFont(new Font("Verdana",1,35));
        welcome.setForeground(Color.white);
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
  	  	returnPanel.add(welcome, BorderLayout.NORTH);
        
        JLabel greeting = new JLabel("PATH TO THE PLANETS");
        greeting.setFont(new Font("Verdana",1,65));
        greeting.setForeground(Color.white);
        greeting.setAlignmentX(Component.CENTER_ALIGNMENT);
  	  	returnPanel.add(greeting, BorderLayout.NORTH);
  	  	
  	  	returnPanel.add(rulesButton);
	  	returnPanel.add(playButton);
	  	
  	  
		return returnPanel;
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
