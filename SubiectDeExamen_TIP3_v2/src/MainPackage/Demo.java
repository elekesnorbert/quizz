/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

/**
 *
 * @author Elekes Norbert
 */
public class Demo
{

  public static void main(String[] args)
  {
    Consumer consumer = new Consumer("f1.txt", "f2.txt");
    System.out.println(consumer.getResults());
  }
}
