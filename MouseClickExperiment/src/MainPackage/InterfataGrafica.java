
package MainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import java.awt.event.MouseListener;

public class InterfataGrafica extends JFrame implements MouseListener
{
  JLabel label;
  JLabel mouseCoordinates;
  
  int mouseCoordinateX;
  int mouseCoordinateY;
 
  public InterfataGrafica() 
  {
    super();

    super.setSize(400, 400);
    super.setResizable(false);
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    super.setTitle("Window Title");
    super.getContentPane().setBackground(Color.DARK_GRAY);
    super.setLayout(null);

    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    super.setLocation(dim.width / 2 - super.getSize().width / 2, dim.height / 2 - super.getSize().height / 2);

    label = new JLabel("Click with your mouse, anywhere in this window");
    label.setFont(new Font("Times New Roman", Font.ITALIC, 14));
    label.setForeground(Color.ORANGE);
    label.setBounds(50, 160, 300, 20);
    
    mouseCoordinates = new JLabel("");
    mouseCoordinates.setFont(new Font("Times New Roman", Font.ITALIC, 20));
    mouseCoordinates.setForeground(Color.ORANGE);
    mouseCoordinates.setBounds(75, 210, 300, 20);
    
    super.addMouseListener(this);
    
    super.add(label);
    super.add(mouseCoordinates);
    
    super.setVisible(true);
  }

  @Override
  public void mouseClicked(MouseEvent e)
  {
    mouseCoordinates.setText("Mouse coordinates: (" + e.getX() + ", " + e.getY() + ")");
  }

  @Override
  public void mousePressed(MouseEvent e)
  {
  }

  @Override
  public void mouseReleased(MouseEvent e)
  {
  }

  @Override
  public void mouseEntered(MouseEvent e)
  {
  }

  @Override
  public void mouseExited(MouseEvent e)
  {
  }

}

