import javax.swing.*;

import java.awt.*;

import java.io.IOException;

public class SpaceImage extends JPanel {

	private Image backgroundImage;
	private SpaceImageObject imageObject;

	public SpaceImage(int fileIndex) throws IOException {
		imageObject = new SpaceImageObject(fileIndex);
	}
	
	public class SpaceImageObject extends FileLoader{
			
			private SpaceImageObject(int imageIndex) throws IOException{
				backgroundImage = loadImage(imageIndex);
				spaceImageFormatting();
			}
			
			
			public void spaceImageFormatting(){
				Dimension size = new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
				setPreferredSize(size);
				setMinimumSize(size);
				setMaximumSize(size);
				setSize(size);
				setLayout(null);
			}
	}

	public Image getImage() {
		
		Image returnImg;
		returnImg = backgroundImage;

		return returnImg;
	} 
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Draw the background image.
		g.drawImage(backgroundImage, 0, 0, this);
	}
}