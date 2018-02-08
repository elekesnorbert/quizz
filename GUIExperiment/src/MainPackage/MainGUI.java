/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Elekes Norbert
 */
public class MainGUI extends JFrame implements ActionListener
{

  WelcomePanel wp;
  ImagePanel ip;
  FormPanel fp;
  GoodbyePanel gp;
  BadbyePanel bp;
  
  public MainGUI()
  {
    super();
    this.setSize(400, 400);
    this.setResizable(false);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setTitle("GUI Experiment");

    //place window to the center of the screen
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

    ip = new ImagePanel(this);
    wp = new WelcomePanel(this);
    fp = new FormPanel(this);
    
    this.add(wp);

    super.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    //order of panels WelcomePanel > ImagePanel > FormPanel > GoodbyePanel/BadbyePanel
    if (e.getActionCommand().equals("NextWelcomePanel")
      || e.getActionCommand().equals("PrevFormPanel"))  
    {
      this.getContentPane().removeAll();
      this.add(ip);
      this.repaint();
    }
    else if (e.getActionCommand().equals("PrevImagePanel")) //switch back to Welcome Panel
    {
      this.getContentPane().removeAll();
      this.add(wp);
      repaint();
    }
    else if (e.getActionCommand().equals("NextImagePanel")) //switch to Form Panel
    {
      this.getContentPane().removeAll();
      this.add(fp);
      repaint();
    }
    else if (e.getActionCommand().equals("FinishFormPanel"))
    {
      if (fp.didHeLikeIt())
      {
        gp = new GoodbyePanel(this, fp.getTypedName(), fp.getChoice());
        this.getContentPane().removeAll();
        this.add(gp);
      }
      else //TODO: fix bug, choice is null
      {
        bp = new BadbyePanel(this, fp.getTypedName(), fp.getChoice());
        this.getContentPane().removeAll();
        this.add(bp);
      }
      repaint();
    }
    else if (e.getActionCommand().equals("Exit")) //both for Goodbye and Badbye Panels
    {
      this.setVisible(false);
      this.dispose();
    }
  }
}
