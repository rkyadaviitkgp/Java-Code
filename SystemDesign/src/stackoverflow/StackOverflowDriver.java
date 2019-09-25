/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoverflow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rajeshkumar.yadav
 */
public class StackOverflowDriver {
    
    Map<Integer, User> systemUsers;
    StackOverflowServer server;

    public StackOverflowDriver() {
        systemUsers = new HashMap<Integer, User>();
        server = new StackOverflowServer();
    }
    
    public boolean loginWithUserId(int id){
        if(isValidUser(id)){
            System.err.println("invalid user ");
            return false;
        }
        else 
        {
            System.out.println("login Succesful ");
            return true;
        }
    }
    
    public boolean isValidUser(int id){
        if(systemUsers.get(id) == null){
            return false;
        }
        else 
        {
            return true;
        }
    }
    
    public void checkFeed(int userId){
        if(isValidUser(userId))
                server.displayFeedToUser(systemUsers.get(userId));
    }
    
    public void postQuestion(String question, int id){
        if(isValidUser(id)){
            User u = systemUsers.get(id);
            Question q = new Question(question, systemUsers.get(id), "CAT A");
            u.AskQuestion(q);
            server.addQuestion(q);
        }
    }
    
    public void postAnswer(String answer, int id, int questionId){
        User u  = systemUsers.get(id);
        Question q = server.getSetOfQuestion().get(questionId);
        if(u == null){
            System.err.println("invalid user ");
        }else if(q == null){
            System.err.println("invalid Question");
        }
        
        Answer a = new Answer(answer, u);
        q.setAnswer(a);
           
    }
    
    public void doLike(Text t, int userId){
        if(isValidUser(userId)){
            t.doLikes();
        }
    }
    
    public void doVoting(Text t, int userId){
        if(isValidUser(userId)){
            t.doVotes();
        }
    }
    
    public void registerUser(User u){
        systemUsers.put(u.getId(), u);
    }
    
    public static void main(String[] args) {
        
        
        
        User u0 = new User("Rajesh", 0);
        User u1 = new User("Rajesh1", 1);
        User u2 = new User("Rajesh2", 2);
        User u3 = new User("Rajesh3", 3);
        User u4 = new User("Rajesh4", 4);
        
        StackOverflowDriver driver = new StackOverflowDriver();
        driver.registerUser(u0);
        driver.registerUser(u1);
        driver.registerUser(u2);
        driver.registerUser(u3);
        driver.registerUser(u4);
        
        driver.postQuestion("which is best city in india", 0);
        driver.postQuestion("When was ramayana written", 1);
        driver.postQuestion("which is best city in africa", 3);
        driver.postQuestion("Who wrote ramayana", 4);
        driver.postQuestion("which is best city in Indonesia", 2);
        driver.postQuestion("Which is biggest hill in india", 1);
        driver.postQuestion("How to solve compiler issue on matlab", 0);
        driver.postQuestion("When windows was released for the first time", 2);
        driver.postQuestion("which is best city in South Africa", 3);
        driver.postQuestion("Just have fun !!! ", 4);
        
        
        driver.checkFeed(0);
        
        
        
    }
    
    
}
