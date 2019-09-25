/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoverflow;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Answer extends Text{
    
    private Question question;
    
    public Answer(String textContent, User author) {
        super(textContent, author);
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
    
    public void displayAnswer(){
        System.out.println("                " + this.getTextContent());
        System.out.println("Like : " + getLikes() + " Votes : " + getVotes());
    }
}
