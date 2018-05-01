import java.awt.*;

import javax.swing.*;


public class Test1 {
	public static void main(String args[])
    {
		int[] upperCardScores = new int[7];
		for(int i = 0; i < upperCardScores.length; i++) {
			upperCardScores[i] = i +1;
		}
		
		int totalScore = 1;
		  int smallStraight = 30;
		  int largeStraight = 50;
		  int triForce = 33;
 
            JFrame frame = new ScorecardFrame1(upperCardScores, smallStraight, largeStraight, triForce, totalScore);
            //frame.setTitle("Space Balls Rules");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

    }
}
