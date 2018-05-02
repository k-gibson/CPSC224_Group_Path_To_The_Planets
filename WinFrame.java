import java.awt.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.Box.*;

public class WinFrame extends JFrame {
		private JLayeredPane finalPanel = getLayeredPane();
		private JPanel mainPanel = new JPanel();
		private JPanel spaceImage;
		
		 private static final int defaultWidth = 1200;
		 private static final int defaultHeight = 800;
		
		public WinFrame() {
			createWinScreen();
		}
		
		private void createWinScreen() {
			setSize(defaultWidth, defaultHeight);
			createBackgroundImage();
			createMainPanel();
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
	        
	        JLabel congratulations = new JLabel("Congratulations");
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
