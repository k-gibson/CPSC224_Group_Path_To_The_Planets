import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PlanetImage extends JPanel {

	private Image newImage;
	
	public PlanetImage(int index) throws IOException {
		 new ImageObject(index);
	}
	
	public class ImageObject extends FileLoader{
			
			private ImageObject(int imageIndex) throws IOException {
				newImage = null;
				newImage = loadImage(imageIndex);
			}	
	}
	
	public Image getImage() {
			Image returnImg;
			returnImg = newImage;
			return returnImg;
		}
}