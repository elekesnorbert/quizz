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
public class GoodbyePanel extends JPanel
{

  JLabel labelOne;
  JLabel labelTwo;
  JLabel labelThree;
  JButton exitButton;

  public GoodbyePanel(ActionListener actionListener, String name, String choice)
  {
    super();

    this.setSize(400, 400);
    this.setLayout(null);
    this.setBackground(Color.GREEN);

    labelOne = new JLabel("Good Choice, " + name + "!");
    labelOne.setFont(new Font("Times New Roman", Font.PLAIN, 25));
    labelOne.setBounds(75, 90, 300, 30);
    this.add(labelOne);

    labelTwo = new JLabel("I like " + choice + " too!");
    labelTwo.setFont(new Font("Arial", Font.PLAIN, 17));
    labelTwo.setBounds(130, 140, 300, 20);
    this.add(labelTwo);

    labelThree = new JLabel("Have a nice day!");
    labelThree.setFont(new Font("Times New Roman", Font.ITALIC, 30));
    labelThree.setBounds(90, 220, 300, 30);
    this.add(labelThree);

    exitButton = new JButton("Exit");
    exitButton.setBackground(Color.ORANGE);
    exitButton.setBounds(280, 300, 70, 20);
    exitButton.addActionListener(actionListener);
    this.add(exitButton);
  }
}
