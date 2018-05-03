/**
* Loads the images that are used on the dice
* CPSC 224-01, Spring 2018
* Final Project - Race Through Space
* class PlanetImage.java
* @author Parker Mooseker
* @version v1.0 5/4/2018
*/

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PlanetImage extends JPanel {

	private Image newImage;
	private ImageObject imgObj;
	
	/**
	  * Creates a new image object
	  * @throws IOException if the planet images are not found
	  */
	public PlanetImage(int index) throws IOException {
		imgObj = new ImageObject(index);
	}
	
	/**
	  * loads the image into a newImage object
	  */
	public class ImageObject extends FileLoader{
		
			private ImageObject(int imageIndex) throws IOException {
				newImage = null;
				newImage = loadImage(imageIndex);
			}
	}
	
	/**
	  * returns the newImage
	  * @return returnImg that is going to be displayed
	  */
	public Image getImage() {
			Image returnImg;
			returnImg = newImage;
			return returnImg;
		}
}