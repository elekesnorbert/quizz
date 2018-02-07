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
public class Utils
{
  public static double distantaEuclidiana(Punct p1, Punct p2) //fata de O(0,0)
  {
    return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
  }
  
  public static double getPerimeter(Contur c)
  {
    ArrayList<Punct> puncte = c.getPuncte();
    
    double perimeter = 0;
    for (int i = 0; i < puncte.size() - 1; i++)
    {
      perimeter += distantaEuclidiana(puncte.get(i), puncte.get(i+1));
    }
    
    return perimeter;
  }
}
