/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

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
public class Quiz
{

  private final static Logger logger = Logger.getLogger(Quiz.class.getName());
  private String name;
  private ArrayList<Question> questions;

  public Quiz()
  {
    questions = new ArrayList<>();
    this.name = "";
  }

  public Quiz(String name, ArrayList<Question> questions)
  {
    this.name = name;
    this.questions = questions;
  }
  
  public void save(FileWriter fw) throws IOException
  {
    String temp = new String();
    fw.write(name + ";");
    
    fw.write(questions.size() + ";");
    for (Question question : questions)
    {
      question.save(fw);
    }
  }
  
  public void load(Scanner sc) throws NumberFormatException
  {
    String tempName = sc.next();
    
    ArrayList<Question> tempArray = new ArrayList<>(); // for safty reasons - if exception is occured, not the entire file will be loaded, thus the data will be corrupted, which in combination with a save can lead to data loss
    Question tempQuestion;
    int numberOfQuestions = sc.nextInt();
    for (int i = 0; i < numberOfQuestions; i++)
    {
      tempQuestion = new Question();
      tempQuestion.load(sc);
      
      tempArray.add(tempQuestion);
    }
    
    name = tempName;
    questions = tempArray;
  }
  
  public void addQuestion(String question, ArrayList<String> correctAnswers, ArrayList<String> wrongAnswers)
  {
    questions.add(new Question(question, correctAnswers, wrongAnswers));
  }

  public void editQuestion(int index, String question, ArrayList<String> correctAnswers, ArrayList<String> wrongAnswers)
  {
    try
    {
      questions.get(index).setQuestion(question);
      questions.get(index).setCorrectAnswers(correctAnswers);
      questions.get(index).setWrongAnswers(wrongAnswers);
    }
    catch (IndexOutOfBoundsException e)
    {
      logger.log(Level.INFO, "removeQuestion(int index) ArrayOutOfBoundsException");
    }
  }

  public void removeQuestion(Question question)
  {
    questions.remove(question);
  }

  public void removeQuestion(int index)
  {
    try
    {
      questions.remove(index);
    }
    catch (IndexOutOfBoundsException e)
    {
      logger.log(Level.INFO, "removeQuestion(int index) ArrayOutOfBoundsException");
    }
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public ArrayList<Question> getQuestions()
  {
    return questions;
  }

  public void setQuestions(ArrayList<Question> questions)
  {
    this.questions = questions;
  }

}
