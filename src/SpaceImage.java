/**
* Displays the players current scorecard with all of their scores after each time they roll the dice
* CPSC 224-01, Spring 2018
* Final Project - Race Through Space
* class SpaceImage.java
* @author Parker Mooseker
* @version v1.0 5/4/2018
*/

import javax.swing.*;

import java.awt.*;

import java.io.IOException;

public class SpaceImage extends JPanel {

	private Image backgroundImage;
	private SpaceImageObject imageObject;

	/**
	  * Creates a new image object of the stars image
	  * @throws IOException if the sapce image is not found
	  */
	public SpaceImage(int fileIndex) throws IOException {
		imageObject = new SpaceImageObject(fileIndex);
	}
	
	public class SpaceImageObject extends FileLoader{
			
			private SpaceImageObject(int imageIndex) throws IOException{
				backgroundImage = loadImage(imageIndex);
				spaceImageFormatting();
			}
			
			/**
			  * AFormats the space image to fit the default dimensions
			  */
			public void spaceImageFormatting(){
				Dimension size = new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
				setPreferredSize(size);
				setMinimumSize(size);
				setMaximumSize(size);
				setSize(size);
				setLayout(null);
			}
	}

	/**
	  * Retrieves the background image that is supposed to be displayed
	  */
	public Image getImage() {
		Image returnImg;
		returnImg = backgroundImage;
		return returnImg;
	} 
	
	/**
	  * Draws the background image to be displayed
	  */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Draw the background image.
		g.drawImage(backgroundImage, 0, 0, this);
	}
}