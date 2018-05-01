import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.geom.*;
import java.awt.event.*;



public class ScorecardFrame1 extends JFrame implements ActionListener {
	private static final int defaultWidth = 1200;
    private static final int defaultHeight = 800;
    private static final int scoreLineHeight = defaultHeight/15;
    
    private JButton nextButton = new JButton("Next");
    private JPanel cardPanel = new JPanel(new CardLayout());
    
    public ScorecardFrame1(int[] upperCardScores, int smallStraight, int largeStraight, int triForce, int totalScore) {
    	setSize(defaultWidth, defaultHeight);
    	this.setLayout(new BorderLayout());
    	
    	formatNextButton();
    	cardPanel = createCardPanel(upperCardScores, smallStraight, largeStraight, triForce, totalScore);
    	
    	addButton();
    	add(cardPanel);
    	
    }
    
    private void addButton() {
    	JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new java.awt.Color(40,23,35));
        buttonPanel.add(nextButton);
        this.add(buttonPanel,BorderLayout.NORTH);
    }
    
    private void formatNextButton() {
    	nextButton.setOpaque(true);
        nextButton.setFont(new Font("Krungthep",Font.BOLD,30));
        nextButton.setBackground(new Color(67,39,59));
        nextButton.setForeground(Color.WHITE);
        nextButton.setFocusPainted(false);
        nextButton.setBorderPainted(false);
        nextButton.addActionListener(this);
    }
    
    public void paintComponent(Graphics g) {
    	Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2f));
        g2.setColor(Color.white);
        
        drawLines(g2);  
    }
    
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
        returnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
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
        JLabel mercury = new JLabel("Mercury"); JLabel mercuryScore = new JLabel(stringScores[0]);
        JLabel venus = new JLabel("Venus"); JLabel venusScore = new JLabel(stringScores[1]);
        JLabel mars = new JLabel("Mars"); JLabel marsScore = new JLabel(stringScores[2]);
        JLabel jupiter = new JLabel("Jupiter"); JLabel jupiterScore = new JLabel(stringScores[3]);
        JLabel saturn = new JLabel("Saturn"); JLabel saturnScore = new JLabel(stringScores[4]);
        JLabel uranus = new JLabel("Uranus"); JLabel uranusScore = new JLabel(stringScores[5]);
        JLabel neptune = new JLabel("Neptune"); JLabel neptuneScore = new JLabel(stringScores[6]);
        returnPanel.add(mercury); returnPanel.add(mercuryScore);
        returnPanel.add(venus); returnPanel.add(venusScore);
        returnPanel.add(mars); returnPanel.add(marsScore);
        returnPanel.add(jupiter); returnPanel.add(jupiterScore);
        returnPanel.add(saturn); returnPanel.add(saturnScore);
        returnPanel.add(uranus); returnPanel.add(uranusScore);
        returnPanel.add(neptune); returnPanel.add(neptuneScore);
        
        //add planet labels in between lines
        mercury.setLocation(200,scoreLineHeight-25); mercuryScore.setLocation(600,scoreLineHeight-25);
        venus.setLocation(200,scoreLineHeight*2-25); venusScore.setLocation(600,scoreLineHeight*2-25);
        mars.setLocation(200,scoreLineHeight*3-25); marsScore.setLocation(600,scoreLineHeight*3-25);
        jupiter.setLocation(200,scoreLineHeight*4-25); jupiterScore.setLocation(600,scoreLineHeight*4-25);
        saturn.setLocation(200,scoreLineHeight*5-25); saturnScore.setLocation(600,scoreLineHeight*5-25);
        uranus.setLocation(200,scoreLineHeight*6-25); uranusScore.setLocation(600,scoreLineHeight*6-25);
        neptune.setLocation(200,scoreLineHeight*7-25); neptuneScore.setLocation(600,scoreLineHeight*7-25);
        
        //bonus score labels
        JLabel smallStrght = new JLabel("Small Straight"); JLabel smallStrghtScore = new JLabel(String.valueOf(smallStraight));
        JLabel largeStrght = new JLabel("Large Straight"); JLabel largeStrghtScore = new JLabel(String.valueOf(largeStraight));
        JLabel triFrc = new JLabel("Tri Force"); JLabel triFrcScore = new JLabel(String.valueOf(triForce));
        JLabel total = new JLabel("TOTAL SCORE"); JLabel ttlScore = new JLabel(String.valueOf(totalScore));
        returnPanel.add(smallStrght);
        returnPanel.add(largeStrght);
        returnPanel.add(triFrc);
        returnPanel.add(total);
        
        //set locations of bonus scores between the lines. It might not be perfectly lined up. I kind of guessed on the math
        // and I still can't test anything so I can't see it....
        smallStrght.setLocation(200, scoreLineHeight*9-25); smallStrghtScore.setLocation(600, scoreLineHeight*9-25);
        largeStrght.setLocation(200, scoreLineHeight*10-25); largeStrghtScore.setLocation(600, scoreLineHeight*10-25);
        triFrc.setLocation(200, scoreLineHeight*11-25); triFrcScore.setLocation(600, scoreLineHeight*11-25);
        total.setLocation(200, scoreLineHeight*13-25); ttlScore.setLocation(600, scoreLineHeight*13-25);
        
        return returnPanel; 
    }
    
    private void drawLines(Graphics g2) {
        g2.drawLine(0,0, defaultWidth,0);
        g2.drawLine(0,scoreLineHeight*1, defaultWidth,scoreLineHeight*1);
        g2.drawLine(0,scoreLineHeight*2, defaultWidth,scoreLineHeight*2);
        g2.drawLine(0,scoreLineHeight*3, defaultWidth,scoreLineHeight*3);
        g2.drawLine(0,scoreLineHeight*4, defaultWidth,scoreLineHeight*4);
        g2.drawLine(0,scoreLineHeight*5, defaultWidth,scoreLineHeight*5);
        g2.drawLine(0,scoreLineHeight*6, defaultWidth,scoreLineHeight*6);
        g2.drawLine(0,scoreLineHeight*7, defaultWidth,scoreLineHeight*7);
        g2.drawLine(0,scoreLineHeight*8, defaultWidth,scoreLineHeight*8);
        g2.drawLine(0,scoreLineHeight*9, defaultWidth,scoreLineHeight*9);
        g2.drawLine(0,scoreLineHeight*10, defaultWidth,scoreLineHeight*10);
        g2.drawLine(0,scoreLineHeight*11, defaultWidth,scoreLineHeight*11);
        g2.drawLine(0,scoreLineHeight*12, defaultWidth,scoreLineHeight*12);
        g2.drawLine(0,scoreLineHeight*13, defaultWidth,scoreLineHeight*13);
        g2.drawLine(0,scoreLineHeight*14, defaultWidth,scoreLineHeight*14);
        g2.drawLine(0,scoreLineHeight*15, defaultWidth,scoreLineHeight*15);
        g2.drawLine(0,scoreLineHeight*16, defaultWidth,scoreLineHeight*16);
        
        
    }
    
    public void actionPerformed(ActionEvent e)
    { 
    	if(e.getSource() == nextButton) {
    		cardPanel.remove(cardPanel);
    		cardPanel.revalidate();
    		cardPanel.repaint();
    	}
    }
}
