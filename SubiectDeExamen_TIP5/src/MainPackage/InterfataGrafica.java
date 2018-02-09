/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author Elekes Norbert
 */
public class InterfataGrafica extends JFrame implements ActionListener
{

  private JTextArea textArea;
  private JButton loadButton;
  private JButton saveButton;

  private String filePath;

  public InterfataGrafica()
  {
    super();

    super.setSize(800, 500);
    super.setLayout(null);
    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    filePath = "";
    
    textArea = new JTextArea();
    textArea.setBounds(250, 50, 300, 280);

    loadButton = new JButton("Load");
    loadButton.setBounds(300, 350, 75, 30);
    loadButton.addActionListener(this);

    saveButton = new JButton("Save");
    saveButton.setBounds(400, 350, 75, 30);
    saveButton.addActionListener(this);
    
    super.add(textArea);
    super.add(loadButton);
    super.add(saveButton);

    super.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    if (e.getActionCommand().equals("Load"))
    {
      FileDialog fd = new FileDialog(this, "Loading File...", FileDialog.LOAD);
      //fd.setDirectory("C://");
      fd.setVisible(true);

      filePath = fd.getDirectory() + fd.getFile();     
      
      if (filePath != null)
      {
        FileThread ft = new FileThread("Loading Thread", filePath, FileDialog.LOAD, textArea);
      }
    }
    else if (e.getActionCommand().equals("Save"))
    {
      FileDialog fd = new FileDialog(this, "Saving File...", FileDialog.SAVE);
      fd.setVisible(true);

      filePath = fd.getDirectory() + fd.getFile();
      if (filePath != null)
      {
        FileThread ft = new FileThread("Saving Thread", filePath, FileDialog.SAVE, textArea);
      }
    }
  }

}
