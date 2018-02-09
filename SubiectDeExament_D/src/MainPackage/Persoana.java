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
public class Persoana
{

  private String nume;
  private String prenume;
  private int varsta;

  public Persoana(String nume, String prenume, int varsta)
  {
    this.nume = nume;
    this.prenume = prenume;
    this.varsta = varsta;
  }

  public String getNume()
  {
    return nume;
  }

  public void setNume(String nume)
  {
    this.nume = nume;
  }

  public String getPrenume()
  {
    return prenume;
  }

  public void setPrenume(String prenume)
  {
    this.prenume = prenume;
  }

  public int getVarsta()
  {
    return varsta;
  }

  public void setVarsta(int varsta)
  {
    this.varsta = varsta;
  }

}
