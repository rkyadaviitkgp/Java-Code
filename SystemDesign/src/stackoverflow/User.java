/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoverflow;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */
public class User {
    
    String name;
    int id;
    List<Question> listOfQuestion;
    List<Answer> listOfAnswer;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
        listOfQuestion = new ArrayList<>();
        listOfAnswer = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Question> getListOfQuestion() {
        return listOfQuestion;
    }

    public void AskQuestion(Question question) {
        this.listOfQuestion.add(question);
    }

    public List<Answer> getListOfAnswer() {
        return listOfAnswer;
    }

    public void provideAnswer(Question question, Answer answer) {
        this.listOfAnswer.add(answer);
        question.setAnswer(answer);
        answer.setQuestion(question);
    }
    
}
