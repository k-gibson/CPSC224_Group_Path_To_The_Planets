import javax.swing.*;
import javax.swing.Box.*;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class RolledDiePanel extends JPanel {

	private JPanel mainPanel = new JPanel();
	private JPanel wordsPanel = new JPanel();

	private int numRows = 2;
	private int numCols = 7;
	private Player thisPlayer;

	private JLabel[] rollOutcomes = new JLabel[(numRows * numCols)];
	private PlanetImage[] planetImages = new PlanetImage[7];
	private ImageIcon[] imageIcons = new ImageIcon[7];
	private JLabel[] dieLabels = new JLabel[7];
	private String[] dieNames = new String[]{ "MERCURY" , "VENUS", "MARS", "JUPITER", "SATURN", "URANUS", "NEPTUNE"};
	private ArrayList<String> travelLabel = new ArrayList<String>();
	private String dieName = "";


	public RolledDiePanel(Player player, int numberOfTurns) throws IOException {
		try {
			thisPlayer = player;
			setUpPanel();
			loadPlanetImages();
			
			this.setUpPanel();
			this.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setUpPanel() throws IOException {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(Color.black);
		mainPanel.setLayout(new GridLayout(numRows, numCols));
		mainPanel.setBackground(new Color(0,0,0));
		mainPanel.setVisible(true);
		
		wordsPanel.setBackground(Color.black);
		this.add(mainPanel);
		
		Filler newSpace = new Filler(new Dimension(0, 80), new Dimension(0, 80), new Dimension(Short.MAX_VALUE, 80));
		// make the space 'see through'
		newSpace.setOpaque(false);
		this.add(newSpace);
		
		this.add(wordsPanel);
	}


	private void loadPlanetImages() throws IOException {
		addDieLabels();
		
		for (int i = 0; i < 7; i++) {
			int playerHandVal = 0;	
			switch (thisPlayer.getHandValue(i)){
			case ("MERCURY") : { playerHandVal = 0;
				break;}
			case ("VENUS") : { playerHandVal = 1;
				break;}
			case ("MARS") : { playerHandVal = 2;
				break;}
			case ("JUPITER") : { playerHandVal = 3;
				break;}
			case ("SATURN") : { playerHandVal = 4;
				break;}
			case ("URANUS") : { playerHandVal = 5;
				break;}
			case ("NEPTUNE") : { playerHandVal = 6;
				break;}
			}
			
			setTravelValue(i);
			planetImages[i] = new PlanetImage(playerHandVal);
	
			rollOutcomes[i] = new JLabel(imageIcons[i]);
			rollOutcomes[i].setIcon(new ImageIcon(planetImages[i].getImage()));
			rollOutcomes[i].setVerticalAlignment(JLabel.NORTH);
			rollOutcomes[i].setHorizontalAlignment(JLabel.CENTER);
			
			mainPanel.add(rollOutcomes[i]);
		}
		addTravelLabel();
		mainPanel.setVisible(true);	
	}

	private void addDieLabels(){
			for(int i = 0; i <7 ; i++){
				dieLabels[i] = new JLabel(dieNames[i] + " DIE:");
				dieLabels[i].setVerticalAlignment(JLabel.NORTH);
				dieLabels[i].setHorizontalAlignment(JLabel.CENTER);
				dieLabels[i].setFont(new Font("Krungthep", 1, 18));
				dieLabels[i].setForeground(Color.white);
				dieLabels[i].setAlignmentX(Component.CENTER_ALIGNMENT);
				mainPanel.add(dieLabels[i]);
			}
		}
	
	public void setTravelValue(int index){
		if(thisPlayer.getHandValue(index)== dieNames[index]){
			dieName = dieNames[index];
			travelLabel.add(dieName);
		}
	}
	
	private void addTravelLabel(){	
		JLabel travelLabelx = new JLabel("You May Travel To: ");
		
		travelLabelx.setFont(new Font("Krungthep", 1, 25));
		travelLabelx.setForeground(Color.white);
		wordsPanel.add(travelLabelx);
		if(travelLabel.size() == 0) {
			JLabel none = new JLabel("0 planets");
			none.setFont(new Font("Krungthep", 1, 25));
			none.setForeground(Color.white);
			wordsPanel.add(none);	
		}
		else {
		for(String s : travelLabel){
			JLabel p = new JLabel(s);
			p.setFont(new Font("Krungthep", 1, 25));
			p.setForeground(Color.white);
			wordsPanel.add(p);
			wordsPanel.setVisible(true);
		}
		}
	}
		
}
