/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Elekes Norbert
 */
public class InterfataGrafica extends JFrame implements ActionListener, WindowListener
{

  JTextArea textArea;
  JButton upButton;
  JButton downButton;
  JButton leftButton;
  JButton rightButton;
  
  int textAreaPositionX;
  int textAreaPositionY;

  public InterfataGrafica()
  {
    super();

    super.setSize(800, 400);
    super.setLayout(null);
    super.addWindowListener(this);

    textAreaPositionX = 300;
    textAreaPositionY = 50;
    
    textArea = new JTextArea();
    textArea.setBounds(textAreaPositionX, textAreaPositionY, 200, 150);

    upButton = new JButton("Up");
    upButton.addActionListener(this);
    downButton = new JButton("Down");
    downButton.addActionListener(this);
    leftButton = new JButton("Left");
    leftButton.addActionListener(this);
    rightButton = new JButton("Right");
    rightButton.addActionListener(this);

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(upButton);
    buttonPanel.add(downButton);
    buttonPanel.add(leftButton);
    buttonPanel.add(rightButton);

    buttonPanel.setBounds(200, 230, 400, 50);

    super.add(textArea);
    super.add(buttonPanel);

    super.setVisible(true);
  }

  @Override
  public void windowClosing(WindowEvent e)
  {
    super.setVisible(false);
    super.dispose();
    //System.exit(0);
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    if (e.getActionCommand().equals("Up"))
    {
      textAreaPositionY -= 10;
    }
    else if (e.getActionCommand().equals("Down"))
    {
      textAreaPositionY += 10;
    }
    else if (e.getActionCommand().equals("Left"))
    {
      textAreaPositionX -= 10;
    }
    else if (e.getActionCommand().equals("Right"))
    {
      textAreaPositionX += 10;
    }
    
    textArea.setBounds(textAreaPositionX, textAreaPositionY, 200, 150);
    
    //update(getGraphics());
    repaint();
    //revalidate();
  }

  @Override
  public void windowOpened(WindowEvent e)
  {
  }

  @Override
  public void windowClosed(WindowEvent e)
  {
  }

  @Override
  public void windowIconified(WindowEvent e)
  {
  }

  @Override
  public void windowDeiconified(WindowEvent e)
  {
  }

  @Override
  public void windowActivated(WindowEvent e)
  {
  }

  @Override
  public void windowDeactivated(WindowEvent e)
  {
  }

}
