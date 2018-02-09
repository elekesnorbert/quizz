/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author Elekes Norbert
 */
public class InterfataGrafica extends JFrame implements ActionListener
{

  JTextArea textArea;
  JButton loadButton;

  public InterfataGrafica()
  {
    super();

    super.setSize(500, 500);
    super.setLayout(null);
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    super.getContentPane().setBackground(Color.DARK_GRAY);
    super.setTitle("Load .csv files");

    textArea = new JTextArea();
    textArea.setBounds(43, 10, 400, 400);
    textArea.setBackground(Color.BLACK);
    textArea.setForeground(Color.ORANGE);
    textArea.setFont(new Font("Times New Roman", Font.ITALIC, 20));
    super.add(textArea);

    loadButton = new JButton("Load");
    loadButton.setActionCommand("Load Button");
    loadButton.setBounds(210, 420, 80, 30);
    loadButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
    loadButton.setBackground(Color.ORANGE);
    loadButton.setForeground(Color.BLACK);
    loadButton.addActionListener(this);
    super.add(loadButton);

    super.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    if (e.getActionCommand().equals("Load Button"))
    {
      FileDialog fd = new FileDialog(this, "Please select a .csv file", FileDialog.LOAD);
      fd.setVisible(true);

      String filePath = fd.getDirectory() + fd.getFile();

      fd.dispose();

      LoadThread thread = new LoadThread(filePath);
      thread.start();

      try
      {
        thread.join();
      }
      catch (InterruptedException ex)
      {
        System.out.println("Asteptarea la terminarea threadului a esuat");
      }

      textArea.setText(thread.getPersoaneText());
      super.repaint();
    }
  }

}
