/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.floor;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Elekes Norbert
 */
public class Demo
{

  public static void main(String[] args)
  {
    ArrayList<Integer> input = readElements("in.txt");

    int secondHalfStartIndex = (int) floor(input.size() / 2);

    MyThread thread1 = new MyThread(input);
    MyThread thread2 = new MyThread(input);

    thread1.start();
    thread2.start();

    try
    {
      thread1.join();
      thread2.join();
    }
    catch (InterruptedException ex)
    {
      System.out.println("Asteptarea la firul de executie a fost intrerupta");
    }

    int productOfElements = MyThread.getResult();
    writeResult("out.txt", productOfElements);
    
    System.out.println("Product of elements: " + productOfElements);
  }

  public static ArrayList<Integer> readElements(String fileName)
  {
    ArrayList<Integer> result = new ArrayList<>();

    try
    {
      Scanner sc = new Scanner(new File(fileName));

      while (sc.hasNext())
      {
        result.add(sc.nextInt());
      }

      sc.close();
    }
    catch (FileNotFoundException ex)
    {
      System.out.println("Fisierul " + fileName + " nu a fost gasit");
    }
    catch (InputMismatchException ex)
    {
      System.out.println("Fisierul " + fileName + " contine date invalide (ne-numerice)");
      result = new ArrayList<>();
    }

    return result;
  }

  public static void writeResult(String fileName, int result)
  {
    try
    {
      FileWriter fw = new FileWriter(new File(fileName));

      fw.write(result + "\r\n");

      fw.flush();
      fw.close();
    }
    catch (IOException ex)
    {
      System.out.println("Crearea fisierului " + fileName + " a esuat");
    }
  }
}
