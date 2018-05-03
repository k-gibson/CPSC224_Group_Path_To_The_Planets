/**
* This is an abstract class that opens all of the image files needed for the game GUI
* CPSC 224-01, Spring 2018
* Final Project - Race Through Space
* class FileLoader.java
* @author Parker Mooseker
* @version v1.0 5/4/2018
*/

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

abstract public class FileLoader {
	
	private final String[] imageNames = new String[]{"components/mercury.jpg" , "components/venus.jpg" , "components/mars.jpg" , "components/jupiter.jpg" , "components/saturn.jpg" , "components/uranus.jpg", "components/neptune.jpg","components/stars.jpg" , "components/fancyStars.jpg"};
	
	/**
	* loads an image from a file path
	* @param int index at which the file name that needs to be opened is located
	* @return Image loadedImage is the image that was opened
	* @throws IOException if the image is not found
	*/
	public Image readImageFile(int index) throws IOException {	
		Image loadedImage = null;
		
		System.out.println(imageNames[index]);
		String path = new String(imageNames[index]);
		File imageFile = new File(path);
		loadedImage = ImageIO.read(imageFile);
		
		return loadedImage;
	}

	/**
	* find the path of an image given the index of the wanted image
	* @param int index at which the file name that needs to be opened is located
	* @return String convertedPath which is the path where the image needed is located
	*/
	public String findPath(int imageIndex) {
		for(String s : imageNames) {
			System.out.println(s);
		}
		
		Path pathLoader = Paths.get(imageNames[imageIndex]);
		String pathName = new String();
		String convertedPath = new String();
		pathName = pathLoader.toAbsolutePath().toString();
		System.out.println(pathName);
		convertedPath = pathName.trim();
		return convertedPath;
	}
	
	/**
	* loads the image at a specific index
	* @param int index at which the file name that needs to be opened is located
	* @return Image newImage is the image stored a the given index
	*/
	public Image loadImage(int index) throws IOException {
		Image newImage = null;
		newImage = readImageFile(index);
		return newImage;
	}
}