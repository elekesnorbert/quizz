/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Elekes Norbert
 */
public class GUI extends JFrame implements KeyListener
{

  JLabel title;
  JLabel imageLabel;

  int imageLabelPositionX;
  int imageLabelPositionY;

  public GUI()
  {
    super();

    super.setSize(400, 400);
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    super.setLayout(null);
    super.addKeyListener(this);

    title = new JLabel("Press the arrow keys and watch what happens!");
    title.setBounds(50, 10, 300, 20);
    super.add(title);

    ImageIcon image = new ImageIcon(getClass().getResource("image.png"));
    image = resizeImage(image.getImage(), 100, 100);

    imageLabelPositionX = 150;
    imageLabelPositionY = 150;

    imageLabel = new JLabel(image);
    imageLabel.setBounds(imageLabelPositionX, imageLabelPositionY, 100, 100);
    super.add(imageLabel);

    super.setVisible(true);
  }

  private ImageIcon resizeImage(Image image, int width, int height)
  {
    BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    Graphics2D g2 = resizedImage.createGraphics();
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(image, 0, 0, width, height, null);
    g2.dispose();

    return new ImageIcon(resizedImage);
  }

  @Override
  public void keyPressed(KeyEvent e)
  {
    int keyCode = e.getKeyCode();

    if (keyCode == KeyEvent.VK_UP && (imageLabelPositionY - 10) >= 60)
    {
      imageLabelPositionY -= 10;
      imageLabel.setBounds(imageLabelPositionX, imageLabelPositionY, 100, 100);
    }
    else if (keyCode == KeyEvent.VK_DOWN && (imageLabelPositionY + 10) <= 250)
    {
      imageLabelPositionY += 10;
      imageLabel.setBounds(imageLabelPositionX, imageLabelPositionY, 100, 100);
    }
    else if (keyCode == KeyEvent.VK_LEFT && (imageLabelPositionX - 10) >= 50)
    {
      imageLabelPositionX -= 10;
      imageLabel.setBounds(imageLabelPositionX, imageLabelPositionY, 100, 100);
    }
    else if (keyCode == KeyEvent.VK_RIGHT && (imageLabelPositionX + 10) <= 230)
    {
      imageLabelPositionX += 10;
      imageLabel.setBounds(imageLabelPositionX, imageLabelPositionY, 100, 100);
    }
  }

  @Override
  public void keyTyped(KeyEvent e)
  {
  }

  @Override
  public void keyReleased(KeyEvent e)
  {
  }
}
