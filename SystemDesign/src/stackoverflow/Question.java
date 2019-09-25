/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoverflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Question extends Text{
    
    public static int quetionCount = 0;
    private  List<Answer> listOfAnswer;
    private int questionId;
    private String category;
    
    public Question(String textContent, User author, String category) {
        super(textContent, author);
        listOfAnswer = new ArrayList<>();
        this.category = category;
        questionId = quetionCount++;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Answer> getListOfAnswer() {
        return listOfAnswer;
    }
    
    public void setAnswer(Answer a){
        this.listOfAnswer.add(a);
    }
    
    public void displayQuestion(){
        System.out.println(this.getTextContent());
        System.out.println("Like : " + getLikes() + " Votes : " + getVotes());
    }
    
}
