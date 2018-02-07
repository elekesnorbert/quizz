/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Elekes Norbert
 */
public class Demo
{
  
  public static void main(String[] args)
  {
    Punct p1 = new Punct(0, 0);
    Punct p2 = new Punct(0, 1);
    Punct p3 = new Punct(1, 2);
    Punct p4 = new Punct(2, 1);
    Punct p5 = new Punct(2, 0);
    
    ArrayList<Punct> puncte = new ArrayList<>();
    puncte.ensureCapacity(5);
    
    puncte.add(p1);
    puncte.add(p2);
    puncte.add(p3);
    puncte.add(p4);
    puncte.add(p5);
    
    Contur c1 = new Contur(new ArrayList<>(puncte));
    
    Collections.sort(puncte, new ComparatorDePuncte());
    
    Punct c2p1 = new Punct(0, 0);
    Punct c2p2 = new Punct(1, 1);
    Punct c2p3 = new Punct(2, 0);
    
    ArrayList<Punct> puncte2 = new ArrayList<>();
    puncte2.ensureCapacity(3);
    puncte2.add(c2p1);
    puncte2.add(c2p2);
    puncte2.add(c2p3);
    
    Contur c2 = new Contur(puncte2);
    
    ArrayList<Contur> contururi = new ArrayList<>();
    contururi.add(c1);
    contururi.add(c2);
    
    Collections.sort(contururi);
    
    System.out.println(puncte);
    System.out.println(contururi);
    
  }
}
