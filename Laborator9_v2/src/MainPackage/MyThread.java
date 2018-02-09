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
  private static int index;
  private static int result = 1;

  public MyThread(ArrayList<Integer> input)
  {
    super();

    this.input = input;
  }

  @Override
  public void run()
  {
    doProduct(input);
  }

  private synchronized static void doProduct(ArrayList<Integer> input)
  {
    while (index < input.size())
    {
      result *= input.get(index);
      index++;
    }
  }
  
  public static int getResult()
  {
    return result;
  }

}
