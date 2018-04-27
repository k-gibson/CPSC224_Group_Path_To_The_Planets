import java.awt.*;
import java.awt.geom.*;

import javax.swing.JPanel;
public class DrawStarShape extends JPanel {
	
	public DrawStarShape() {
	    //setMinimumSize(new Dimension(500,500));
		Dimension size = new Dimension(220, 290);
	    setMaximumSize(size);
	    setLayout(null);
	    setOpaque(false);
	}
	    public void paintComponent(Graphics graphic)
	    {
	        Graphics2D drawing = (Graphics2D) graphic;

	        drawing.setPaint(Color.yellow);
	        drawing.fill(star(90, 150, 40));
	        Graphics finalGraphic = (Graphics) drawing;
	        super.paintComponent(finalGraphic);
	    }

	    private Shape star(double centerX, double centerY,double radius)
	    {
	    	
	        Path2D path = new Path2D.Double();
	        //How many 'points' for each half of the star
	        double deltaAngleRad = Math.PI / 5;
	        for (int i = 0; i < 10; i++)
	        {
	            double angleRad = Math.toRadians(-18) + i * deltaAngleRad;
	            double cosine = Math.cos(angleRad);
	            double sin = Math.sin(angleRad);
	            double relativeX = cosine;
	            double relativeY = sin;
	            if ((i & 1) == 0)
	            {
	                relativeX *= radius * 2.63;
	                relativeY *= radius * 2.63;
	            }
	            else
	            {
	                relativeX *= radius;
	                relativeY *= radius;
	            }
	            if (i == 0)
	            {
	                path.moveTo(centerX + relativeX, centerY + relativeY);
	            }
	            else
	            {
	                path.lineTo(centerX + relativeX, centerY + relativeY);
	            }
	        }
	        path.closePath();
	        return path;
	    }
}