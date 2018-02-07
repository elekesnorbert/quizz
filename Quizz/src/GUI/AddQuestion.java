/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Frame.DataBase;
import Frame.Question;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Elekes Norbert
 */
public class AddQuestion extends JFrame implements ActionListener, WindowListener
{

  private JLabel titleLabel;
  private JLabel questionLabel;
  private JTextField questionTextField;
  private ArrayList<AnswerPanel> answerPanels;
  private JButton saveButton;
  private JButton cancelButton;
  private Question question;

  public AddQuestion(int numberOfAnswers)
  {
    super();
    titleLabel = new JLabel("Add Question");

    questionLabel = new JLabel("Question: ");
    questionTextField = new JTextField(30);

    answerPanels = new ArrayList<>();

    for (int i = 0; i < numberOfAnswers; i++)
    {
      answerPanels.add(new AnswerPanel());
    }

    saveButton = new JButton("Save");
    saveButton.addActionListener(this);
    cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(this);

    JPanel questionPanel = new JPanel(new BorderLayout());
    questionPanel.add(questionLabel, BorderLayout.WEST);
    questionPanel.add(questionTextField, BorderLayout.CENTER);

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(saveButton);
    buttonPanel.add(cancelButton);

    int numberOfRows = 3 + numberOfAnswers;
    super.setLayout(new GridLayout(numberOfRows, 0));

    super.add(titleLabel);
    super.add(questionPanel);

    for (AnswerPanel ap : answerPanels)
    {
      super.add(ap);
    }

    super.add(buttonPanel);

    super.addWindowListener(this);

    super.setVisible(true);
    super.pack();
  }

  public Question getQuestion()
  {
    return question;
  }
  
  @Override
  public void windowClosing(WindowEvent e)
  {
    super.setVisible(false);
    super.dispose();
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    if (e.getActionCommand().equals("Save"))
    {
      String tempQuestion = questionTextField.getText();
      ArrayList<String> correctAnswers = new ArrayList<>();
      ArrayList<String> wrongAnswers = new ArrayList<>();

      for (AnswerPanel ap : answerPanels)
      {
        if (ap.isCorrectAnswer())
        {
          correctAnswers.add(ap.getText());
        }
        else
        {
          wrongAnswers.add(ap.getText());
        }
      }
      question = new Question(tempQuestion, correctAnswers, wrongAnswers);
      
      super.setVisible(false);
    }
    else if (e.getActionCommand().equals("Cancel"))
    {
      super.setVisible(false);
      super.dispose();
    }
  }

  @Override
  public void windowOpened(WindowEvent e)
  {
    //not needed in the moment
  }

  @Override
  public void windowClosed(WindowEvent e)
  {
    //not needed in the moment
  }

  @Override
  public void windowIconified(WindowEvent e)
  {
    //not needed in the moment
  }

  @Override
  public void windowDeiconified(WindowEvent e)
  {
    //not needed in the moment 
  }

  @Override
  public void windowActivated(WindowEvent e)
  {
    //not needed in the moment
  }

  @Override
  public void windowDeactivated(WindowEvent e)
  {
    //not needed in the moment  
  }
}
