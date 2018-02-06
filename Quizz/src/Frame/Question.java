/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Elekes Norbert
 */
public class Question
{

  private String question;
  private ArrayList<String> correctAnswers;
  private ArrayList<String> wrongAnswers;

  public Question()
  {
    question = "";
    wrongAnswers = new ArrayList<>();
    correctAnswers = new ArrayList<>();
  }

  public Question(String question, ArrayList<String> correctAnswers, ArrayList<String> wrongAnswers)
  {
    this.question = question;
    this.correctAnswers = correctAnswers;
    this.wrongAnswers = wrongAnswers;
  }

  public void save(FileWriter fw) throws IOException
  {
    fw.write(question + ";");

    fw.write(correctAnswers.size() + ";");
    for (String answer : correctAnswers)
    {
      fw.write(answer + ";");
    }

    fw.write(wrongAnswers.size() + ";");
    for (String answer : wrongAnswers)
    {
      fw.write(answer + ";");
    }
  }

  public void load(Scanner sc)
  {
    String tempQuestion = sc.next();

    ArrayList<String> tempArrayCA = new ArrayList<>();// for safty reasons - if exception is occured, not the entire file will be loaded, thus the data will be corrupted, which in combination with a save can lead to data loss
    int numberOfAnswers = sc.nextInt();
    for (int i = 0; i < numberOfAnswers; i++)
    {
      tempArrayCA.add(sc.next());
    }
    
    ArrayList<String> tempArrayWA = new ArrayList();
    numberOfAnswers = sc.nextInt();
    for (int i = 0; i < numberOfAnswers; i++)
    {
      tempArrayWA.add(sc.next());
    }
    
    question = tempQuestion;
    correctAnswers = tempArrayCA;
    wrongAnswers = tempArrayWA;
  }

  public String getQuestion()
  {
    return question;
  }

  public void setQuestion(String question)
  {
    this.question = question;
  }

  public ArrayList<String> getCorrectAnswers()
  {
    return correctAnswers;
  }

  public void setCorrectAnswers(ArrayList<String> correctAnswers)
  {
    this.correctAnswers = correctAnswers;
  }

  public ArrayList<String> getWrongAnswers()
  {
    return wrongAnswers;
  }

  public void setWrongAnswers(ArrayList<String> wrongAnswers)
  {
    this.wrongAnswers = wrongAnswers;
  }

}
