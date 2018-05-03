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
		
		public WinFrame(Player player, Player[] players) {
			this.player = player;
			this.players = players;
			createWinScreen();
		}
		
		private void createWinScreen() {
			setSize(defaultWidth, defaultHeight);
			createBackgroundImage();
			
			createMainPanel();
		}
		 
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
		 
		 public void actionPerformed(ActionEvent e) {
			FinalScorecardPanel finalScorecard = new FinalScorecardPanel(players);
			finalScorecard.setVisible(true);
		 }
		
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