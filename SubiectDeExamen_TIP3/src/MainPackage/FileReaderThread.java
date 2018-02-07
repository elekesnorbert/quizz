/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Elekes Norbert
 */
public class FileReaderThread extends Thread
{

  private String filename;
  private boolean ready;
  private int currentValue;

  public FileReaderThread(String threadName, String filename)
  {
    super(threadName);

    this.filename = filename;
    this.ready = false;

    super.start();
  }

  @Override
  public void run()
  {
    try
    {
      Scanner sc = new Scanner(new File(filename));

      while (sc.hasNext())
      {
        currentValue = sc.nextInt();
        System.out.println(this.getName() + ": " + currentValue); //TODO: delete 
        ready = true;

        while (ready)
        {
          //waits until next number is required ("ready" will be changed from outside of the class)
          //if (!sc.hasNext())
         // {
          //  break;
         // }
          
        }
      }

      sc.close();
    }
    catch (FileNotFoundException ex)
    {
      System.out.println("Fisierul " + filename + " nu a fost gasit");
    }
  }

  public boolean isReady()
  {
    return ready;
  }

  public void backToWork()
  {
    this.ready = false;
  }

  public int getCurrentValue()
  {
    return currentValue;
  }

}
