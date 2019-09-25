/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoverflow;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author rajeshkumar.yadav
 */
public class StackOverflowServer {
    
    private Queue<Question> topTenQuestion; 
    private Map<Integer, Question> setOfQuestion;

    public StackOverflowServer() {
        
        this.topTenQuestion  = new PriorityQueue<Question>(10, new QuestionComparator());
        setOfQuestion = new HashMap<Integer, Question>();
        
    }
    
    public void displayFeedToUser(User u) {
        
        Iterator<Question> iterator= topTenQuestion.iterator();
        int count = 0;
        while(iterator.hasNext() && count < 10){
            count++;
            Question q = iterator.next();
            q.displayQuestion();
//            List<Answer> list = q.getListOfAnswer();
//            for(Answer a : list){
//                a.displayAnswer();
//            }
        }
        
    }
    
    public void addQuestion(Question q){
        topTenQuestion.add(q);
        setOfQuestion.put(q.getQuestionId(), q);
    }

    public Queue<Question> getTopTenQuestion() {
        return topTenQuestion;
    }

    public Map<Integer, Question> getSetOfQuestion() {
        return setOfQuestion;
    }
    
    
    
}
