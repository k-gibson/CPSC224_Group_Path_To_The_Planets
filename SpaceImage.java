import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SpaceImage extends JPanel {

  private Image backgroundImage;

  public SpaceImage(String fileName) throws IOException {
    backgroundImage = ImageIO.read(new File(fileName));
    Dimension size = new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
  }

  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);

    // Draw the background image.
    graphics.drawImage(backgroundImage, 0, 0, this);
  }
}