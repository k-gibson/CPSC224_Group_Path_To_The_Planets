import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RulesFrame extends JFrame implements ActionListener{
	
	private JPanel rulesPanel = new JPanel(new CardLayout()); 
	private JPanel[] rulesArray = new JPanel[5];
	private int rulesIndex = 0;
	private static final int defaultWidth = 1200;
    private static final int defaultHeight = 800;
    
    private JButton mainButton = new JButton("Main");
    private JButton nextButton = new JButton("Next");
    private JButton previousButton = new JButton("Previous");
    
    private JPanel rulesPanel0 = createFirstRulesPanel();
    private JPanel rulesPanel1 = createSecondRulesPanel();
    private JPanel rulesPanel2 = createThirdRulesPanel();
    private JPanel rulesPanel3 = createFourthRulesPanel();
    private JPanel rulesPanel4 = createFifthRulesPanel();

    public RulesFrame() {
    	//define settings used for every rules panel
        setSize(defaultWidth, defaultHeight);
        this.setLayout(new BorderLayout());
        
        formatMainButton();
        formatNextButton();
        formatPreviousButton();
        initializeRulesArray();
        
        rulesPanel = createRulesPanel();
        addButtonPanels();
        // add panels to frame
        rulesPanel.add(rulesPanel0);
        add(rulesPanel); 
    }
    
    private JPanel getCurrentPanel() {
    	JPanel currentPanel = rulesArray[rulesIndex];
    	return currentPanel;
    }
    
    private JPanel getNextPanel() {
    	JPanel nextPanel = rulesArray[rulesIndex+1];
    	return nextPanel;
    }
    
    private JPanel getPreviousPanel() {
    	JPanel previousPanel = rulesArray[rulesIndex - 1];
    	return previousPanel;
    }
    
    private void addButtonPanels() {
    	JPanel mainButtonPanel = new JPanel();
        mainButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        mainButtonPanel.setBackground(new java.awt.Color(40,23,35));
        mainButtonPanel.add(mainButton);
        this.add(mainButtonPanel,BorderLayout.NORTH);
     
        
        JPanel lowerButtonsPanel = new JPanel();
        lowerButtonsPanel.setLayout(new BoxLayout(lowerButtonsPanel, BoxLayout.LINE_AXIS));

        lowerButtonsPanel.add(previousButton);
        lowerButtonsPanel.add(Box.createHorizontalGlue());
        lowerButtonsPanel.add(nextButton);
        lowerButtonsPanel.setBackground(new java.awt.Color(40,23,35));
        this.add(lowerButtonsPanel, BorderLayout.SOUTH);
        previousButton.setVisible(false);
    }
    
    private void formatMainButton() {
    	mainButton.setOpaque(true);
        mainButton.setFont(new Font("Krungthep",Font.BOLD,25));
        mainButton.setBackground(new Color(67,39,59));
        mainButton.setForeground(Color.WHITE);
        mainButton.setFocusPainted(false);
        mainButton.setBorderPainted(false);
        mainButton.addActionListener(this);
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
    
    private void formatPreviousButton() {
    	previousButton.setOpaque(true);
        previousButton.setFont(new Font("Krungthep",Font.BOLD,30));
        previousButton.setBackground(new Color(67,39,59));
        previousButton.setForeground(Color.WHITE);
        previousButton.setFocusPainted(false);
        previousButton.setBorderPainted(false);
        previousButton.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
    	if(e.getSource() == nextButton) {
    		rulesPanel.remove(getCurrentPanel());
    		rulesPanel.revalidate();
    		rulesPanel.repaint();
    		rulesPanel.add(getNextPanel());
    		rulesIndex++;
    		Component otherSource = previousButton;
			otherSource.setVisible(true);
    		if (rulesIndex > 3) {
    			Component source = nextButton;
    			source.setVisible(false); 
    		}
    	}
    	else if(e.getSource() == previousButton)  {
    		rulesPanel.remove(getCurrentPanel());
    		rulesPanel.revalidate();
    		rulesPanel.repaint();
    		rulesPanel.add(getPreviousPanel());
    		rulesIndex--; 
			Component otherSource = nextButton;
			otherSource.setVisible(true);
    		if (rulesIndex <= 1) {
    			Component source = previousButton;
    			source.setVisible(false); 
    		}
    	}
    	else {
    		this.setVisible(false);
    	}
    }

    private JPanel createRulesPanel() {
    	JPanel returnPanel = new JPanel();
    	returnPanel.setLayout(new BoxLayout(returnPanel, BoxLayout.PAGE_AXIS));
    	returnPanel.setBackground(new java.awt.Color(40,23,35));
        returnPanel.setPreferredSize(new Dimension(defaultWidth,defaultHeight - 120));
        
        JPanel title = new JPanel();
        JLabel rulesTitle = new JLabel("Rules");
        rulesTitle.setFont(new Font("Krungthep",1,65));
        rulesTitle.setForeground(Color.white);
        title.setBackground(new java.awt.Color(40,23,35));
        title.add(rulesTitle);
        returnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnPanel.add(title, BorderLayout.NORTH);
        
        return returnPanel; 
    }
    
    private void initializeRulesArray() {
    	rulesArray[0] = rulesPanel0;
        rulesArray[1] = rulesPanel1;
        rulesArray[2] = rulesPanel2;
        rulesArray[3] = rulesPanel3;
        rulesArray[4] = rulesPanel4;
    }
    
    
    private JPanel createFirstRulesPanel() {
    	JPanel rulesPanel0 = new JPanel();
    	rulesPanel0.setBackground(new java.awt.Color(40,23,35));
    	JLabel howToWin = new JLabel("How to Win:");
        howToWin.setFont(new Font("Krungthep",1,40));
        howToWin.setForeground(Color.white);
        
        JLabel description = new JLabel("Visit all of the planets first, or have the greatest number of points.");
        description.setFont(new Font("Verdana",1,20));
        description.setForeground(Color.white);
        rulesPanel0.add(howToWin);
        rulesPanel0.add(description);
        
        JLabel howToPlay = new JLabel("How to Play:");
        howToPlay.setFont(new Font("Krungthep",1,40));
        howToPlay.setForeground(Color.white);
        
        JLabel description2 = new JLabel("<html>All players start on Earth and try to get to every planet in our solar system by rolling die </html>");
        description2.setFont(new Font("Verdana",1,20));
        description2.setForeground(Color.white);
        rulesPanel0.add(howToPlay);
        rulesPanel0.add(description2);
        rulesPanel0.setLayout(new GridLayout(8,1));
        
        return rulesPanel0;
    }

    private JPanel createSecondRulesPanel() {
    	JPanel rulesPanel1 = new JPanel();
    	rulesPanel1.setBackground(new java.awt.Color(40,23,35));
    	JLabel continued = new JLabel("(Continued)");
        continued.setFont(new Font("Krungthep",1,25));
        continued.setForeground(Color.white);
        rulesPanel1.add(continued);
        
        JLabel description = new JLabel("<html>Each player rolls seven 7-sided die. Each die represents a planet. Each side of each die correlates with a certain planet.</html>");
        description.setFont(new Font("Verdana",1,18));
        description.setForeground(Color.white);
        rulesPanel1.add(description);
        
        JLabel description2 = new JLabel("<html>To reach a planet, you must roll that planet with that planet’s die </html>");
        description2.setFont(new Font("Verdana",1,18));
        description2.setForeground(Color.white);
        rulesPanel1.add(description2);
        
        JLabel list1 = new JLabel("• To get to Mercury, you must roll Mercury on the Mercury die.");
        list1.setFont(new Font("Verdana",1,18));
        list1.setForeground(Color.white);
        rulesPanel1.add(list1);
        
        JLabel list2 = new JLabel("• To get to Venus, you must roll Venus on the Venus die.");
        list2.setFont(new Font("Verdana",1,18));
        list2.setForeground(Color.white);
        rulesPanel1.add(list2);
        
        JLabel list3 = new JLabel("• To get to Mars, you must roll Mars on the Mars die.");
        list3.setFont(new Font("Verdana",1,18));
        list3.setForeground(Color.white);
        rulesPanel1.add(list3);
        
        JLabel list4 = new JLabel("• To get to Jupiter, you must roll Jupiter on the Jupiter die.");
        list4.setFont(new Font("Verdana",1,18));
        list4.setForeground(Color.white);
        rulesPanel1.add(list4);
        
        JLabel list5 = new JLabel("• To get to Saturn, you must roll Saturn on the Saturn die.");
        list5.setFont(new Font("Verdana",1,18));
        list5.setForeground(Color.white);
        rulesPanel1.add(list5);
        
        JLabel list6 = new JLabel("• To get to Uranus, you must roll Uranus on the Uranus die.");
        list6.setFont(new Font("Verdana",1,18));
        list6.setForeground(Color.white);
        rulesPanel1.add(list6); 
        
        JLabel list7 = new JLabel("• To get to Neptune, you must roll Neptune on the Neptune die.");
        list7.setFont(new Font("Verdana",1,18));
        list7.setForeground(Color.white);
        rulesPanel1.add(list7);
        
        JLabel description3 = new JLabel("<html>So rolling Mercury on any other die besides the Mercury die would not earn any points. </html>");
        description3.setFont(new Font("Verdana",1,18));
        description3.setForeground(Color.white);
        rulesPanel1.add(description3);
        
        
        rulesPanel1.setLayout(new GridLayout(22,1));
        
        return rulesPanel1;
    }
    
    private JPanel createThirdRulesPanel() {
    	JPanel rulesPanel2 = new JPanel();
    	rulesPanel2.setBackground(new java.awt.Color(40,23,35));
    	JLabel continued = new JLabel("(Continued)");
        continued.setFont(new Font("Krungthep",1,25));
        continued.setForeground(Color.white);
        rulesPanel2.add(continued);
        
        JLabel description = new JLabel("<html>• The order of each turn is randomized each time in order to prevent any unfair advantage.</html>");
        description.setFont(new Font("Verdana",1,18));
        description.setForeground(Color.white);
        rulesPanel2.add(description);
        
        JLabel description2 = new JLabel("<html>• Each player rolls every die each turn, unless they have already reached that die’s planet.</html>");
        description2.setFont(new Font("Verdana",1,18));
        description2.setForeground(Color.white);
        rulesPanel2.add(description2);
        
        JLabel description3 = new JLabel("<html>• The first player to reach every planet wins, but each player only has 8 turns to do so.</html>");
        description3.setFont(new Font("Verdana",1,18));
        description3.setForeground(Color.white);
        rulesPanel2.add(description3);
        
        JLabel description4 = new JLabel("<html>• The game is over when a player visits all seven planets, or when every player is out of turns.</html>");
        description4.setFont(new Font("Verdana",1,18));
        description4.setForeground(Color.white);
        rulesPanel2.add(description4);
        
        JLabel description5 = new JLabel("<html>• There can be a maximum of seven total players and a minimum of one player.</html>");
        description5.setFont(new Font("Verdana",1,18));
        description5.setForeground(Color.white);
        rulesPanel2.add(description5);
        
        rulesPanel2.setLayout(new GridLayout(12,1));
        
        return rulesPanel2;
    }

    private JPanel createFourthRulesPanel() {
    	JPanel rulesPanel3 = new JPanel();
    	rulesPanel3.setBackground(new java.awt.Color(40,23,35));
    	JLabel scoring = new JLabel("Scoring:");
        scoring.setFont(new Font("Krungthep",1,25));
        scoring.setForeground(Color.white);
        rulesPanel3.add(scoring);
        
        JLabel description = new JLabel("<html>Each planet earns a player points based on its position in the solar system.</html>");
        description.setFont(new Font("Verdana",1,18));
        description.setForeground(Color.white);
        rulesPanel3.add(description);
        
        JLabel description2 = new JLabel("<html>If a player is the first in that game to visit a planet, they earn bonus points.</html>");
        description2.setFont(new Font("Verdana",1,18));
        description2.setForeground(Color.white);
        rulesPanel3.add(description2);
        
        JLabel list = new JLabel("• Visiting Mercury earns a player 1 point, visiting it first is an extra 7 points");
        list.setFont(new Font("Verdana",1,18));
        list.setForeground(Color.white);
        rulesPanel3.add(list);
        
        JLabel list2 = new JLabel("• Visiting Venus earns a player 2 points, visiting it first is an extra 8 points");
        list2.setFont(new Font("Verdana",1,18));
        list2.setForeground(Color.white);
        rulesPanel3.add(list2);
        
        JLabel list3 = new JLabel("• Visiting Mars earns a player 3 points, visiting it first is an extra 9 points");
        list3.setFont(new Font("Verdana",1,18));
        list3.setForeground(Color.white);
        rulesPanel3.add(list3);
        
        JLabel list4 = new JLabel("• Visiting Jupiter earns a player 4 points, visiting it first is an extra 10 points");
        list4.setFont(new Font("Verdana",1,18));
        list4.setForeground(Color.white);
        rulesPanel3.add(list4);
        
        JLabel list5 = new JLabel("• Visiting Saturn earns a player 5 points, visiting it first is an extra 11 points");
        list5.setFont(new Font("Verdana",1,18));
        list5.setForeground(Color.white);
        rulesPanel3.add(list5);
        
        JLabel list6 = new JLabel("• Visiting Uranus earns a player 6 points, visiting it first is an extra 12 points");
        list6.setFont(new Font("Verdana",1,18));
        list6.setForeground(Color.white);
        rulesPanel3.add(list6);
        
        JLabel list7 = new JLabel("• Visiting Neptune earns a player 7 points, visiting it first is an extra 13 points");
        list7.setFont(new Font("Verdana",1,18));
        list7.setForeground(Color.white);
        rulesPanel3.add(list7);
        
        rulesPanel3.setLayout(new GridLayout(20,1));
        
        return rulesPanel3;
    }

    private JPanel createFifthRulesPanel() {
    	JPanel rulesPanel4 = new JPanel();
    	rulesPanel4.setBackground(new java.awt.Color(40,23,35));
    	JLabel specialBonuses = new JLabel("Special Bonuses:");
        specialBonuses.setFont(new Font("Krungthep",1,25));
        specialBonuses.setForeground(Color.white);
        rulesPanel4.add(specialBonuses);
        
        JLabel description = new JLabel("<html>• Visiting all seven planets in one turn results in an automatic win of the game.</html>");
        description.setFont(new Font("Verdana",1,20));
        description.setForeground(Color.white);
        rulesPanel4.add(description);
        
        JLabel description2 = new JLabel("<html>•If you visit exactly 3 planets in a turn, it is a Tri-Force into a super nebula. You earn 33 points.</html>");
        description2.setFont(new Font("Verdana",1,20));
        description2.setForeground(Color.white);
        rulesPanel4.add(description2);
        
        JLabel description3 = new JLabel("<html>•If you visit 2 adjacent planets in a turn, it is a small straight. You earn 30 points.</html>");
        description3.setFont(new Font("Verdana",1,20));
        description3.setForeground(Color.white);
        rulesPanel4.add(description3);
        
        JLabel description4 = new JLabel("<html>•If you visit 3 adjacent planets in a turn, it is a large straight. You earn 50 points.</html>");
        description4.setFont(new Font("Verdana",1,20));
        description4.setForeground(Color.white);
        rulesPanel4.add(description4);
        
        JLabel description5 = new JLabel("<html>•If you run out of turns without making it to a single planet, you earn the NASA award. If you earn the NASA award, you automatically win.</html>");
        description5.setFont(new Font("Verdana",1,20));
        description5.setForeground(Color.white);
        rulesPanel4.add(description5);
        
        rulesPanel4.setLayout(new GridLayout(12,4));
        
        return rulesPanel4;
    }
}