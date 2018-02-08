/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Elekes Norbert
 */
public class ImagePanel extends JPanel
{

  ImageIcon image;
  JButton nextButton;
  JButton prevButton;

  public ImagePanel(ActionListener actionListener)
  {
    super();

    this.setSize(400, 400);
    this.setLayout(null);
    this.setBackground(Color.GREEN);

    image = new ImageIcon(getClass().getResource("programmingJoke.jpg"));
    image = resizeImage(image.getImage(), 270, 270);

    JLabel imageLabel = new JLabel(image);
    imageLabel.setBounds(65, 10, 270, 270);

    this.add(imageLabel);

    nextButton = new JButton("Next");
    nextButton.setActionCommand("NextImagePanel");
    nextButton.setBounds(280, 300, 70, 20);
    nextButton.addActionListener(actionListener);
    nextButton.setBackground(Color.ORANGE);
    this.add(nextButton);

    prevButton = new JButton("Prev");
    prevButton.setActionCommand("PrevImagePanel");
    prevButton.setBounds(200, 300, 70, 20);
    prevButton.addActionListener(actionListener);
    prevButton.setBackground(Color.ORANGE);
    this.add(prevButton);
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
}
