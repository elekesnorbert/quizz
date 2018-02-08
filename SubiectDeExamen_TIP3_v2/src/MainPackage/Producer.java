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
public class Producer extends Thread
{

  private String fileName;
  private int currentValue;

  public Producer(String fileName)
  {
    super();

    this.fileName = fileName;
  }

  @Override
  synchronized public void run()
  {
    try
    {
      Scanner sc = new Scanner(new File(fileName));

      while (sc.hasNext())
      {
        synchronized (this)
        {
          notify();
          currentValue = sc.nextInt();
          wait();
        }
      }

      sc.close();
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }

  public int getCurrentValue()
  {
    return currentValue;
  }

}
