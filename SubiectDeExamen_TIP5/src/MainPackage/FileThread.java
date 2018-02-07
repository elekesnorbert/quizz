/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JTextArea;

/**
 *
 * @author Elekes Norbert
 */
public class FileThread extends Thread
{

  private String filePath;
  private int purpose;
  private JTextArea textArea;
  // purpose: FileDialog.SAVE or FileDialog.LOAD

  public FileThread(String threadName, String filePath, int purpose, JTextArea textArea)
  {
    super(threadName);

    this.filePath = filePath;
    this.purpose = purpose;
    this.textArea = textArea;

    if (purpose != FileDialog.SAVE && purpose != FileDialog.LOAD)
    {
      throw new IllegalArgumentException();
    }

    super.start();
  }

  @Override
  synchronized public void run()
  {
    if (purpose == FileDialog.LOAD) 
    {
      load();
    }
    else 
    {
      save();
    }
  }

  synchronized private void load()
  {
    String temp = "";

    try
    {
      Scanner sc = new Scanner(new File(filePath));

      while (sc.hasNextLine())
      {
        temp += sc.nextLine() + "\r\n";
      }

      textArea.setText(temp);

      sc.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found: " + filePath);
    }
  }

  synchronized private void save()
  {
    try
    {
      FileWriter fw = new FileWriter(new File(filePath));

      String temp = textArea.getText();
      
      String[] tempArray = temp.split("\n");
      if (tempArray.length > 2)
      {
        temp = tempArray[0] + "\n" + tempArray[1];
      }
      
      fw.write(temp);

      fw.flush();
      fw.close();
    }
    catch (IOException e)
    {
      System.out.println("File can't be created: " + filePath);
    }
  }
}
