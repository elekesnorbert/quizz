/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Elekes Norbert
 */
public class Contur implements Serializable, Comparable<Contur>
{

  private ArrayList<Punct> puncte;

  public Contur()
  {
    this.puncte = new ArrayList<>();
  }

  public Contur(ArrayList<Punct> puncte)
  {
    this.puncte = puncte;
  }

  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder(2 * puncte.size());

    for (Punct punct : puncte)
    {
      sb.append(punct);
      sb.append(" | ");
    }

    return sb.toString();
  }

  public ArrayList<Punct> getPuncte()
  {
    return puncte;
  }

  public void setPuncte(ArrayList<Punct> puncte)
  {
    this.puncte = puncte;
  }

  @Override
  public int compareTo(Contur c)
  {
    double perimetruC1 = Utils.getPerimeter(this);
    double perimetruC2 = Utils.getPerimeter(c);

    if (perimetruC1 == perimetruC2)
    {
      return 0;
    }
    else
    {
      return (perimetruC1 < perimetruC2 ? -1 : 1);
    }
  }

}
