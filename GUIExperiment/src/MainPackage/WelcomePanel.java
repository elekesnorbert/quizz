/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Elekes Norbert
 */
public class WelcomePanel extends JPanel
{
  JLabel label;
  JLabel text;
  JButton button;
  
  public WelcomePanel(ActionListener actionListener)
  {
    super();
    
    super.setSize(400, 400);
    super.setLayout(null);
    super.setBackground(Color.GREEN);
    
    label = new JLabel("HelloWorld");
    label.setFont(new Font("Times New Roman", Font.PLAIN, 30));
    label.setBounds(120, 50, 200, 50);
    
    text = new JLabel("This is my GUI experiment");
    text.setFont(new Font("Calibri", Font.ITALIC, 20));
    text.setBounds(80, 150, 400, 50);
    
    button = new JButton("Next");
    button.setActionCommand("NextWelcomePanel");
    button.setBounds(280, 300, 70, 20);
    button.addActionListener(actionListener);
    button.setBackground(Color.ORANGE);
    
    this.add(label);
    this.add(text);
    this.add(button);
  }
}
