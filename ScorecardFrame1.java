import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.geom.*;
import java.awt.event.*;



public class ScorecardFrame1 extends JFrame implements ActionListener {
	private static final int defaultWidth = 1200;
    private static final int defaultHeight = 800;
    private static final int scoreLineHeight = defaultHeight/15;
    
    private JButton nextButton = new JButton("Done");
    private JPanel cardPanel = new JPanel();
    
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
        JPanel score = new JPanel();
        score.setBackground(new java.awt.Color(40,23,35));
        score.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel mercury = new JLabel("Mercury"); JLabel mercuryScore = new JLabel(stringScores[0]);
        mercury.setFont(new Font("Krungthep",1,24)); mercuryScore.setFont(new Font("Krungthep",1,24));
        mercury.setForeground(Color.white); mercuryScore.setForeground(Color.white);
        JLabel venus = new JLabel("Venus"); JLabel venusScore = new JLabel(stringScores[1]);
        venus.setFont(new Font("Krungthep",1,24)); venusScore.setFont(new Font("Krungthep",1,24));
        venus.setForeground(Color.white); venusScore.setForeground(Color.white);
        JLabel mars = new JLabel("Mars"); JLabel marsScore = new JLabel(stringScores[2]);
        mars.setFont(new Font("Krungthep",1,24)); marsScore.setFont(new Font("Krungthep",1,24));
        mars.setForeground(Color.white); marsScore.setForeground(Color.white);
        JLabel jupiter = new JLabel("Jupiter"); JLabel jupiterScore = new JLabel(stringScores[3]);
        jupiter.setFont(new Font("Krungthep",1,24)); jupiterScore.setFont(new Font("Krungthep",1,24));
        jupiter.setForeground(Color.white); jupiterScore.setForeground(Color.white);
        JLabel saturn = new JLabel("Saturn"); JLabel saturnScore = new JLabel(stringScores[4]);
        saturn.setFont(new Font("Krungthep",1,24)); saturnScore.setFont(new Font("Krungthep",1,24));
        saturn.setForeground(Color.white); saturnScore.setForeground(Color.white);
        JLabel uranus = new JLabel("Uranus"); JLabel uranusScore = new JLabel(stringScores[5]);
        uranus.setFont(new Font("Krungthep",1,24)); uranusScore.setFont(new Font("Krungthep",1,24));
        uranus.setForeground(Color.white); uranusScore.setForeground(Color.white);
        JLabel neptune = new JLabel("Neptune"); JLabel neptuneScore = new JLabel(stringScores[6]);
        neptune.setFont(new Font("Krungthep",1,24)); neptuneScore.setFont(new Font("Krungthep",1,24));
        neptune.setForeground(Color.white); neptuneScore.setForeground(Color.white);
        
        score.add(mercury); score.add(mercuryScore);
        score.add(venus); score.add(venusScore);
        score.add(mars); score.add(marsScore);
        score.add(jupiter); score.add(jupiterScore);
        score.add(saturn); score.add(saturnScore);
        score.add(uranus); score.add(uranusScore);
        score.add(neptune); score.add(neptuneScore);

        //add planet labels in between lines
        mercury.setLocation(20,scoreLineHeight-25); mercuryScore.setLocation(60,scoreLineHeight-25);
        venus.setLocation(20,scoreLineHeight*2-25); venusScore.setLocation(60,scoreLineHeight*2-25);
        mars.setLocation(20,scoreLineHeight*3-25); marsScore.setLocation(60,scoreLineHeight*3-25);
        jupiter.setLocation(20,scoreLineHeight*4-25); jupiterScore.setLocation(60,scoreLineHeight*4-25);
        saturn.setLocation(20,scoreLineHeight*5-25); saturnScore.setLocation(60,scoreLineHeight*5-25);
        uranus.setLocation(20,scoreLineHeight*6-25); uranusScore.setLocation(60,scoreLineHeight*6-25);
        neptune.setLocation(20,scoreLineHeight*7-25); neptuneScore.setLocation(60,scoreLineHeight*7-25);
        
        //bonus score labels
        JLabel smallStrght = new JLabel("Small Straight"); JLabel smallStrghtScore = new JLabel(String.valueOf(smallStraight));
        smallStrght.setFont(new Font("Krungthep",1,24)); smallStrghtScore.setFont(new Font("Krungthep",1,24));
        smallStrght.setForeground(Color.white); smallStrghtScore.setForeground(Color.white);
        JLabel largeStrght = new JLabel("Large Straight"); JLabel largeStrghtScore = new JLabel(String.valueOf(largeStraight));
        largeStrght.setFont(new Font("Krungthep",1,24)); largeStrghtScore.setFont(new Font("Krungthep",1,24));
        largeStrght.setForeground(Color.white); largeStrghtScore.setForeground(Color.white);
        JLabel triFrc = new JLabel("Tri Force"); JLabel triFrcScore = new JLabel(String.valueOf(triForce));
        triFrc.setFont(new Font("Krungthep",1,24)); triFrcScore.setFont(new Font("Krungthep",1,24));
        triFrc.setForeground(Color.white); triFrcScore.setForeground(Color.white);
        JLabel total = new JLabel("TOTAL SCORE"); JLabel ttlScore = new JLabel(String.valueOf(totalScore));
        total.setFont(new Font("Krungthep",1,24)); ttlScore.setFont(new Font("Krungthep",1,24));
        total.setForeground(Color.white); ttlScore.setForeground(Color.white);
        
        
        score.add(smallStrght); score.add(smallStrghtScore);
        score.add(largeStrght); score.add(largeStrghtScore);
        score.add(triFrc); score.add(triFrcScore);
        score.add(total); score.add(ttlScore);
        score.setOpaque(true);
        
        //set locations of bonus scores between the lines. It might not be perfectly lined up. I kind of guessed on the math
        // and I still can't test anything so I can't see it....
        smallStrght.setLocation(200, scoreLineHeight*9-25); smallStrghtScore.setLocation(600, scoreLineHeight*9-25);
        largeStrght.setLocation(200, scoreLineHeight*10-25); largeStrghtScore.setLocation(600, scoreLineHeight*10-25);
        triFrc.setLocation(200, scoreLineHeight*11-25); triFrcScore.setLocation(600, scoreLineHeight*11-25);
        total.setLocation(200, scoreLineHeight*13-25); ttlScore.setLocation(600, scoreLineHeight*13-25);
        
        returnPanel.add(score, BorderLayout.NORTH);
        returnPanel.setOpaque(true);
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
