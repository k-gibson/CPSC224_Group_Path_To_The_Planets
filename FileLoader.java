import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

abstract public class FileLoader {
	
	private final String[] imageNames = new String[]{"components/mercury.jpg" , "components/venus.jpg" , "components/mars.jpg" , "components/jupiter.jpg" , "components/saturn.jpg" , "components/uranus.jpg", "components/neptune.jpg","components/stars.jpg" , "components/fancyStars.jpg"};
	
	
	
	public Image readImageFile(int index) throws IOException {	
		Image loadedImage = null;
		
		System.out.println(imageNames[index]);
		String path = new String(imageNames[index]);
		File imageFile = new File(path);
		loadedImage = ImageIO.read(imageFile);
		
		return loadedImage;
	}

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
	
	public Image loadImage(int index) throws IOException {
		Image newImage = null;
		newImage = readImageFile(index);
		return newImage;
	}
}