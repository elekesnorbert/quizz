/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.lang.Thread.State;
import java.util.ArrayList;

/**
 *
 * @author Elekes Norbert
 */
public class Consumer
{

  private Producer p1;
  private Producer p2;
  private ArrayList<Integer> results;
  private boolean p1ReadyToGo;
  private boolean p2ReadyToGo;
  
  public Consumer(String fileName1, String fileName2)
  {
    p1 = new Producer(fileName1);
    p2 = new Producer(fileName2);
    results = new ArrayList<>();
    p1ReadyToGo = false;
    p2ReadyToGo = false;
    
    int value1 = 0;
    int value2 = 0;

    p1.start();
    p2.start();

    while (p1.isAlive() && p2.isAlive())
    {
      synchronized (p1)
      {
        if (p1.getState() == State.WAITING);
        {
          value1 = p1.getCurrentValue();
          p1.notify();
          p1ReadyToGo = true;
        }
      }
      synchronized (p2)
      {
        if (p2.getState() == State.WAITING)
        {
          value2 = p2.getCurrentValue();
          p2.notify();
          p2ReadyToGo = true;
        }
      }
      if (p1ReadyToGo && p2ReadyToGo)
      {
        results.add(value1 + value2);
        p1ReadyToGo = false;
        p2ReadyToGo = false;
      }
    }
  }

  public ArrayList<Integer> getResults()
  {
    return results;
  }

}
