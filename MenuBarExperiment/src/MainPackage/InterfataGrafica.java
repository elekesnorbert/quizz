package MainPackage;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class InterfataGrafica extends JFrame implements ActionListener
{
  JLabel label;
  JCheckBoxMenuItem enableTextItem;
  JLabel controlLabel;
  
  public InterfataGrafica()
  {
    super();

    super.setSize(400, 400);
    super.setResizable(false);
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    super.setTitle("Menu Experiment");
    super.getContentPane().setBackground(Color.DARK_GRAY);
    super.setLayout(null);

    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    super.setLocation(dim.width / 2 - super.getSize().width / 2, dim.height / 2 - super.getSize().height / 2);

    JMenuItem copyItem = new JMenuItem("Copy");
    copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
    copyItem.setActionCommand("copy");
    copyItem.addActionListener(this);
    
    JMenuItem pasteItem = new JMenuItem("Paste");
    pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
    pasteItem.setActionCommand("paste");
    pasteItem.addActionListener(this);
    
    JMenuItem cutItem = new JMenuItem("Cut");
    cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
    cutItem.setActionCommand("cut");
    cutItem.addActionListener(this);
    
    JMenu subMenu = new JMenu("Edit");
    subMenu.setMnemonic(KeyEvent.VK_E);
    subMenu.add(copyItem);
    subMenu.add(pasteItem);
    subMenu.add(cutItem);

    JMenuItem undoItem = new JMenuItem("Undo");
    undoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
    undoItem.setActionCommand("undo");
    undoItem.addActionListener(this);
    
    JMenuItem exitItem = new JMenuItem("Exit");
    exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, ActionEvent.CTRL_MASK));
    exitItem.setActionCommand("exit");
    exitItem.addActionListener(this);
    
    JMenu menu = new JMenu("Main Menu");
    menu.setMnemonic(KeyEvent.VK_M);
    menu.add(subMenu);
    menu.add(undoItem);
    menu.addSeparator();
    menu.add(exitItem);
    
    JRadioButtonMenuItem orangeItem = new JRadioButtonMenuItem("Orange");
    orangeItem.setActionCommand("orange");
    orangeItem.setSelected(true);
    orangeItem.addActionListener(this);
    
    JRadioButtonMenuItem greenItem = new JRadioButtonMenuItem("Green");
    greenItem.setActionCommand("green");
    greenItem.addActionListener(this);
    
    ButtonGroup buttonGroup = new ButtonGroup();
    buttonGroup.add(orangeItem);
    buttonGroup.add(greenItem);
    
    JMenu textColorMenu = new JMenu("Text Color");
    textColorMenu.setMnemonic(KeyEvent.VK_T);
    textColorMenu.add(orangeItem);
    textColorMenu.add(greenItem);
    
    enableTextItem = new JCheckBoxMenuItem("Enable Text");
    enableTextItem.setSelected(true);
    enableTextItem.setActionCommand("enable text");
    enableTextItem.addActionListener(this);
    
    JMenuItem imageItem = new JMenuItem(new ImageIcon(getClass().getResource("image.png")));
    
    JMenu imageMenu = new JMenu("Image");
    imageMenu.setMnemonic(KeyEvent.VK_I);
    imageMenu.add(enableTextItem);
    imageMenu.addSeparator();
    imageMenu.add(imageItem);
    
    JMenuBar menuBar = new JMenuBar();
    menuBar.add(menu);
    menuBar.add(textColorMenu);
    menuBar.add(imageMenu);
    
    super.setJMenuBar(menuBar);
    
    label = new JLabel("Play with the menu-es and shortcuts");
    label.setFont(new Font("Times New Roman", Font.ITALIC, 20));
    label.setForeground(Color.ORANGE);
    label.setBounds(50, 150, 300, 20);
    super.add(label);
    
    controlLabel = new JLabel("");
    controlLabel.setFont(new Font("Times New Roman", Font.ITALIC, 15));
    controlLabel.setForeground(Color.ORANGE);
    controlLabel.setBounds(120, 250, 300, 20);
    super.add(controlLabel);
    
    super.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    String cmd = e.getActionCommand();
    if (cmd.equals("copy"))
    {
      controlLabel.setText("Copy command selected");
    }
    else if (cmd.equals("paste"))
    {
      controlLabel.setText("Paste command selected");
    }
    else if (cmd.equals("cut"))
    {
      controlLabel.setText("Cut command selected");
    }
    else if (cmd.equals("undo"))
    {
      controlLabel.setText("Undo command selected");
    }
    else if (cmd.equals("exit"))
    {
      super.setVisible(false);
      super.dispose();
    }
    else if (cmd.equals("orange"))
    {
      label.setForeground(Color.ORANGE);
      controlLabel.setForeground(Color.ORANGE);
    }
    else if (cmd.equals("green"))
    {
      label.setForeground(Color.GREEN);
      controlLabel.setForeground(Color.GREEN);
    }
    else if (cmd.equals("enable text"))
    {
      if (enableTextItem.isSelected())
      {
        label.setText("Play with the menu-es and shortcuts");
      }
      else
      {
        label.setText("");
      }
    }
  }

}
