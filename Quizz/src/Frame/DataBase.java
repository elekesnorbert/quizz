/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elekes Norbert
 */
public class DataBase
{

  private static DataBase instance;

  private static final Logger logger = Logger.getLogger(DataBase.class.getName());
  private ArrayList<Quiz> quizes;
  private static final String FILENAME = "quizes.dat";

  private DataBase()
  {
    quizes = new ArrayList<>();
  }

  public static DataBase getInstance()
  {
    if (instance == null)
    {
      instance = new DataBase();
    }
    return instance;
  }

  public void save() //TODO: clean string before saving (eliminate ; from strings)
  {
    try
    {
      FileWriter fw = new FileWriter(new File(FILENAME));

      fw.write(quizes.size() + ";");
      for (Quiz quiz : quizes)
      {
        quiz.save(fw);
      }

      fw.write("\r\n");

      fw.flush();
      fw.close();
    }
    catch (IOException ex)
    {
      logger.log(Level.WARNING, "Saving DataBase file (quizes.dat) failed!");
    }
  }

  public void load() throws NumberFormatException
  {
    try
    {
      Scanner sc = new Scanner(new File(FILENAME));
      sc.useDelimiter(";");

      ArrayList<Quiz> tempArray = new ArrayList<>();// for safty reasons - if exception is occured, not the entire file will be loaded, thus the data will be corrupted, which in combination with a save can lead to data loss
      Quiz tempQuiz = new Quiz();
      int numberOfQuizes = sc.nextInt();
      for (int i = 0; i < numberOfQuizes; i++)
      {
        tempQuiz.load(sc);
        tempArray.add(tempQuiz);
      }

      quizes = tempArray;

      sc.close();
    }
    catch (FileNotFoundException ex)
    {
      logger.log(Level.WARNING, "Loading DataBase file (quizes.dat) failed!");
    }
  }
}
