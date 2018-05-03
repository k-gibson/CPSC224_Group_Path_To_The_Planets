/**
* Displays the players current scorecard with all of their scores after each time they roll the dice
* CPSC 224-01, Spring 2018
* Final Project - Race Through Space
* class ScorecardFrame.java
* @author Alana Dillinger
* @version v1.0 5/4/2018
*/

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.*;

public class ScorecardFrame extends JFrame implements ActionListener {
	private static final int defaultWidth = 1200;
    private static final int defaultHeight = 800;
    private static final int scoreLineHeight = defaultHeight/15;
    
    private JButton nextButton = new JButton("Done");
    private JPanel cardPanel = new JPanel();
    
    /**
	  * Scorecard constructor calls methods to format all components and adds the components to the screen
	  * @param int[] upperCardScores are the planets they have visited corresponding scores
	  * @param int smallStraight is the players smallStraight score
	  * @param int largeStraight is the players largeStraight score
	  * @param int triForce is the players triForce score
	  * @param int totalScore is the players total score
	  */
    public ScorecardFrame(int[] upperCardScores, int smallStraight, int largeStraight, int triForce, int totalScore) {
    	setSize(defaultWidth, defaultHeight);
    	this.setLayout(new BorderLayout());
    	
    	formatNextButton();
    	cardPanel = createCardPanel(upperCardScores, smallStraight, largeStraight, triForce, totalScore);
    	
    	addButton();
    	add(cardPanel);
    }
    
    /**
	  * Adds the 'continue button to the top of the panel
	  */
    private void addButton() {
    	JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new java.awt.Color(40,23,35));
        buttonPanel.add(nextButton);
        this.add(buttonPanel,BorderLayout.NORTH);
    }
    
    /**
	  * Formats the 'continue' button
	  */
    private void formatNextButton() {
    	nextButton.setOpaque(true);
        nextButton.setFont(new Font("Krungthep",Font.BOLD,20));
        nextButton.setBackground(new Color(67,39,59));
        nextButton.setForeground(Color.WHITE);
        nextButton.setFocusPainted(false);
        nextButton.setBorderPainted(false);
        nextButton.addActionListener(this);
    }
    
    /**
	  * Formats the card panel that is going to be displayed with all of the players scores in a JTable after they have rolled the dice on their current turn
	  * @param int[] upperCardScores are the planets they have visited corresponding scores
	  * @param int smallStraight is the players smallStraight score
	  * @param int largeStraight is the players largeStraight score
	  * @param int triForce is the players triForce score
	  * @param int totalScore is the players total score
	  */
    private JPanel createCardPanel(int[] upperCardScores, int smallStraight, int largeStraight, int triForce, int totalScore) {
    	JPanel returnPanel = new JPanel();
    	returnPanel.setLayout(new BoxLayout(returnPanel, BoxLayout.PAGE_AXIS));
    	returnPanel.setBackground(new java.awt.Color(40,23,35));
        returnPanel.setPreferredSize(new Dimension(defaultWidth,defaultHeight - 120));
        
        JPanel title = new JPanel();
        JLabel cardTitle = new JLabel("Your Scorecard");
        cardTitle.setFont(new Font("Krungthep",1,65));
        cardTitle.setForeground(Color.white);
        title.setBackground(new java.awt.Color(40,23,35));
        title.add(cardTitle);
        returnPanel.add(title, BorderLayout.NORTH);
        
        //add lines to display the score on the screen
        //Graphics g;
        //paint(g); //************************************I know I need this, but idk how to initialize it.... Kate?
              
        //convert integers in score array to strings to add them to labels
        String[] stringScores = new String[upperCardScores.length];
        for(int i=0; i < upperCardScores.length; i++) {
        	stringScores[i] = String.valueOf(upperCardScores[i]);
        	System.out.println(upperCardScores.length);
        }
        //planet labels
        JPanel scoresPanel = new JPanel();
        scoresPanel.setBackground(new java.awt.Color(40,23,35));
        scoresPanel.setPreferredSize(new Dimension(defaultWidth,defaultHeight - 120));
        
        String[] columnNames = {"What is being Scored",
                                "Points Scored"
                               };
        
        Object[][] scores = {
        	    {"Mercury", stringScores[0],},
        	    {"Venus", stringScores[1],},
        	    {"Mars", stringScores[2],},
        	    {"Jupiter", stringScores[3],},
        	    {"Saturn", stringScores[4],},
        	    {"Uranus", stringScores[5],},
        	    {"Neptune", stringScores[6],},
        	    {"Small Straight", String.valueOf(smallStraight),},
        	    {"Large Straight", String.valueOf(largeStraight),},
        	    {"Tri Force", String.valueOf(triForce),},
        	    {"Total Score", String.valueOf(totalScore),}
        	};
        
        JTable table = new JTable(scores, columnNames);
        table.setPreferredSize(new Dimension(defaultWidth - 500, defaultHeight));
        table.setBackground(new java.awt.Color(40,23,35));
        table.setFont(new Font("Krungthep",1,24));
        table.setForeground(Color.white);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        
        int rowHeight = 50;
        table.setRowHeight(0,rowHeight);
        table.setRowHeight(1,rowHeight);
        table.setRowHeight(2,rowHeight);
        table.setRowHeight(3,rowHeight);
        table.setRowHeight(4,rowHeight);
        table.setRowHeight(5,rowHeight);
        table.setRowHeight(6,rowHeight);
        table.setRowHeight(7,rowHeight);
        table.setRowHeight(8,rowHeight);
        table.setRowHeight(9,rowHeight);
        table.setRowHeight(10,rowHeight);
        table.setRowHeight(11,rowHeight);
        
        
        scoresPanel.add(table);
        returnPanel.add(scoresPanel,BorderLayout.NORTH);
        returnPanel.setOpaque(true);
        return returnPanel; 
    }
    
    /**
	  * When the done button is pressed, the scorecard goes away
	  */
    public void actionPerformed(ActionEvent e)
    { 
    	this.setVisible(false);
    }
}