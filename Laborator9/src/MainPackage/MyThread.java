/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.util.ArrayList;

/**
 *
 * @author Elekes Norbert
 */
public class MyThread extends Thread
{

  private ArrayList<Integer> input;
  private int startIndex;
  private int endIndex;
  private int result;

  public MyThread(ArrayList<Integer> input, int startIndex, int endIndex)
  {
    super();

    this.input = input;
    this.startIndex = startIndex;
    this.endIndex = endIndex;
    this.result = 1;
  }

  @Override
  public void run()
  {
    try
    {
      for (int i = startIndex; i < endIndex; i++)
      {
        result *= input.get(i);
      }
    }
    catch (ArrayIndexOutOfBoundsException ex)
    {
      System.out.println("Intervalul [startIndex, endIndex) nu a fost corecta");
      result = 0;
    }
  }

  public int getResult()
  {
    return result;
  }

}
