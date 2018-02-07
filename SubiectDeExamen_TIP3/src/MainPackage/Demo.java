/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elekes Norbert
 */
public class Demo
{

  public static void main(String[] args)
  {
    ArrayList<Integer> summ = new ArrayList<>();

    FileReaderThread thread1 = new FileReaderThread("Thread ptr. f1", "f1.txt");
    FileReaderThread thread2 = new FileReaderThread("Thread ptr. f2", "f2.txt");

    while (thread1.isAlive() && thread2.isAlive())
    {
      if (thread1.isReady() && thread2.isReady())
      {
        summ.add(thread1.getCurrentValue() + thread2.getCurrentValue());
        thread1.backToWork();
        thread2.backToWork();
      }
    }
    
    System.out.println(summ);
  }
}
