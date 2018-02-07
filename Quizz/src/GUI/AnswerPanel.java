/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Elekes Norbert
 */
public class AnswerPanel extends JPanel
{

  private JLabel label;
  private JTextField textField;
  private JCheckBox checkBox;

  public AnswerPanel()
  {
    super();

    label = new JLabel("Answer:");
    textField = new JTextField(30);
    checkBox = new JCheckBox();

    super.add(label);
    super.add(textField);
    super.add(checkBox);
  }

  public boolean isCorrectAnswer()
  {
    return checkBox.isSelected();
  }
  
  public String getText()
  {
    return textField.getText();
  }

}
