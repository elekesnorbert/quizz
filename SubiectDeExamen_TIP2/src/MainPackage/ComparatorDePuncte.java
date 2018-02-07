/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.util.Comparator;

/**
 *
 * @author Elekes Norbert
 */
public class ComparatorDePuncte implements Comparator<Punct>
{

  @Override
  public int compare(Punct p1, Punct p2)
  {
    Punct o = new Punct(0, 0);
    double distEuclP1 = Utils.distantaEuclidiana(p1, o);
    double distEuclP2 = Utils.distantaEuclidiana(p2, o);

    if (distEuclP1 == distEuclP2)
    {
      return 0;
    }
    else
    {
      return (distEuclP1 < distEuclP2 ? -1 : 1);
    }
  }

}
