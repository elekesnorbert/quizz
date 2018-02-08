/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Elekes Norbert
 */
public class FormPanel extends JPanel
{

  JLabel nameLabel;
  JTextField nameTextField;
  JLabel questionLabel;
  JRadioButton javaRadioButton;
  JRadioButton cppRadioButton;
  JRadioButton csharpRadioButton;
  JCheckBox likeCheckBox;
  JButton prevButton;
  JButton finishButton;
  ButtonGroup buttonGroup;

  public FormPanel(ActionListener actionListener)
  {
    super();

    this.setSize(400, 400);
    this.setLayout(null);
    this.setBackground(Color.GREEN);

    nameLabel = new JLabel("Name: ");
    nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
    nameLabel.setBounds(10, 40, 50, 20);
    this.add(nameLabel);

    nameTextField = new JTextField(10);

    //limit the number of characters (max 10) which can be written in nameTextField
    nameTextField.setDocument(new PlainDocument()
    {
      @Override
      public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException
      {
        if (str == null)
        {
          return;
        }

        if ((getLength() + str.length()) <= 10)
        {
          super.insertString(offset, str, attr);
        }
      }
    });

    nameTextField.setBounds(70, 40, 320, 20);
    this.add(nameTextField);

    questionLabel = new JLabel("Which programming language do you prefer?");
    questionLabel.setBounds(10, 80, 380, 20);
    this.add(questionLabel);

    javaRadioButton = new JRadioButton("Java");
    javaRadioButton.setActionCommand("Java");
    javaRadioButton.setSelected(true);  
    javaRadioButton.setBounds(10, 110, 380, 20);
    this.add(javaRadioButton);

    cppRadioButton = new JRadioButton("C++");
    cppRadioButton.setActionCommand("C++");
    cppRadioButton.setBounds(10, 140, 380, 20);
    this.add(cppRadioButton);

    csharpRadioButton = new JRadioButton("C#");
    csharpRadioButton.setActionCommand("C#");
    csharpRadioButton.setBounds(10, 170, 380, 20);
    this.add(csharpRadioButton);

    buttonGroup = new ButtonGroup();
    buttonGroup.add(javaRadioButton);
    buttonGroup.add(cppRadioButton);
    buttonGroup.add(csharpRadioButton);

    likeCheckBox = new JCheckBox("Did you like this program?");
    likeCheckBox.setFont(new Font("Arial", Font.ITALIC, 13));
    likeCheckBox.setBounds(10, 210, 380, 20);
    this.add(likeCheckBox);

    prevButton = new JButton("Prev");
    prevButton.setActionCommand("PrevFormPanel");
    prevButton.setBackground(Color.ORANGE);
    prevButton.setBounds(200, 300, 70, 20);
    prevButton.addActionListener(actionListener);
    this.add(prevButton);

    finishButton = new JButton("Finish");
    finishButton.setActionCommand("FinishFormPanel");
    finishButton.setBackground(Color.ORANGE);
    finishButton.setBounds(280, 300, 70, 20);
    finishButton.addActionListener(actionListener);
    this.add(finishButton);
  }

  public String getTypedName()
  {
    String text = nameTextField.getText();
    return (text.equals("") ? "stranger" : text);
  }

  public String getChoice()
  {
    return buttonGroup.getSelection().getActionCommand();
  }

  public boolean didHeLikeIt()
  {
    return likeCheckBox.isSelected();
  }
}
