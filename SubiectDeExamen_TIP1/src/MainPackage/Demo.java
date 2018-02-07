/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elekes Norbert
 */
public class Demo
{
  public static void main(String[] args) throws IOException
  {
    //contur 1
    Punct c1p1 = new Punct(-1, 1);
    Punct c1p2 = new Punct(2, 3);
    Punct c1p3 = new Punct(4, 5);
    
    ArrayList<Punct> c1puncte = new ArrayList<>();
    c1puncte.add(c1p1);
    c1puncte.add(c1p2);
    c1puncte.add(c1p3);
    
    Contur c1 = new Contur(c1puncte);
    
    
    //contur 2
    Punct c2p1 = new Punct(0, 0);
    Punct c2p2 = new Punct(-1, 2);
    Punct c2p3 = new Punct(3, 4);
    Punct c2p4 = new Punct(2, 5); 
    
    ArrayList<Punct> c2puncte = new ArrayList<>();
    c2puncte.add(c2p1);
    c2puncte.add(c2p2);
    c2puncte.add(c2p3);
    c2puncte.add(c2p4);
    
    Contur c2 = new Contur(c2puncte);
    
    //lista de contururi
    ArrayList<Contur> contururi = new ArrayList<>();
    contururi.add(c1);
    contururi.add(c2);
    
    //serializare
    try
    {
      FileOutputStream fout = new FileOutputStream("data.ser");
      ObjectOutputStream out = new ObjectOutputStream(fout);
      
      out.writeObject(contururi);
      
      out.close();
      fout.close();
    }
    catch( FileNotFoundException ex)
    {
      System.out.println("Crearea fisierului s-a esuat");
    }
    catch (IOException ex)
    {
      System.out.println("Scrierea in fisier s-a esuat");
    }
    
    //deserializare
    ArrayList<Contur> contururiDeserializate = new ArrayList<>();
    
    try
    {
      FileInputStream fin = new FileInputStream("data.ser");
      ObjectInputStream in = new ObjectInputStream(fin);
    
      contururiDeserializate = (ArrayList<Contur>) in.readObject();
    
      in.close();
      fin.close();
    }
    catch (ClassNotFoundException ex)
    {
      System.out.println("Clasa cu numele corespunzator celui salvat in fisier nu a fost gasita");
    }
    catch (FileNotFoundException ex)
    {
      System.out.println("Fisierul nu a fost gasit");
    }
    
    //afisare
    for (int i = 0; i < contururiDeserializate.size(); i++)
    {
      System.out.println("Contur" + (i + 1) + ": " + contururiDeserializate.get(i));
    }
  }
}
