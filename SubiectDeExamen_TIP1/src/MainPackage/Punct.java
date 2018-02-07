/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.io.Serializable;

/**
 *
 * @author Elekes Norbert
 */
public class Punct implements Serializable
{

  private int x;
  private int y;

  public Punct()
  {
    this(0, 0);
  }

  public Punct(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString()
  {
    return x + " " + y;
  }

  
  
  public int getX()
  {
    return x;
  }

  public void setX(int x)
  {
    this.x = x;
  }

  public int getY()
  {
    return y;
  }

  public void setY(int y)
  {
    this.y = y;
  }

}
