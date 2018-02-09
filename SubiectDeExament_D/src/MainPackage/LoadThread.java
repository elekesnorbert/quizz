/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Elekes Norbert
 */
public class LoadThread extends Thread
{

  private String fileName;
  private ArrayList<Persoana> persoane;
  private String header;

  public LoadThread(String fileName)
  {
    super();

    this.fileName = fileName;
    this.persoane = new ArrayList<>();
  }

  @Override
  public void run()
  {
    try
    {
      Scanner sc = new Scanner(new File(fileName));

      if (sc.hasNextLine())
      {
        header = sc.nextLine();
      }

      String[] temp;
      String tempNume;
      String tempPrenume;
      int tempVarsta;

      while (sc.hasNextLine())
      {
        temp = sc.nextLine().split(",");

        tempNume = temp[0];
        tempPrenume = temp[1];
        tempVarsta = Integer.parseInt(temp[2]);

        persoane.add(new Persoana(tempNume, tempPrenume, tempVarsta));
      }

      sc.close();
    }
    catch (FileNotFoundException ex)
    {
      System.out.println("Deschiderea fisierului " + fileName + " a esuat");
    }
    catch (ArrayIndexOutOfBoundsException | NumberFormatException e)
    {
      System.out.println("Fisierul " + fileName + " contine date invalide");
    }
  }

  public ArrayList<Persoana> getPersoane()
  {
    return persoane;
  }

  public String getPersoaneText()
  {
    StringBuilder sb = new StringBuilder();

    for (Persoana pers : persoane)
    {
      sb.append(pers.getNume());
      sb.append(", ");
      sb.append(pers.getPrenume());
      sb.append(", ");
      sb.append(pers.getVarsta());
      sb.append("\r\n");
    }

    return sb.toString();
  }

  public String getHeader()
  {
    return header;
  }

}
