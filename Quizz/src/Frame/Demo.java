/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import java.util.ArrayList;

/**
 *
 * @author Elekes Norbert
 */
public class Demo
{
  public static void main(String[] args)
  {
    String q = "Which of the following has 4 angles?";
    
    ArrayList<String> ca = new ArrayList<>();
    ca.add("Diamond");
    ca.add("Square");
    
    ArrayList<String> wa = new ArrayList<>();
    wa.add("Elipse");
    wa.add("Circle");
    
    Question question = new Question(q, ca, wa);
   
    ArrayList<Question> questions = new ArrayList<>();
    questions.add(question);
    questions.add(question);
    
    Quiz quiz = new Quiz("First Quiz", questions);
    ArrayList<Quiz> quizes = new ArrayList<>();
    quizes.add(quiz);
    quizes.add(quiz);
    quizes.add(quiz);
    
    DataBase db = DataBase.getInstance();
    db.load();
  }
}
