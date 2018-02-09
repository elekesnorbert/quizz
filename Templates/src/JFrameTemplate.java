
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class JFrameTemplate extends JFrame
{
  
  //TODO: add components
  public JFrameTemplate()
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

    //TODO: add components
    super.setVisible(true);
  }

}
