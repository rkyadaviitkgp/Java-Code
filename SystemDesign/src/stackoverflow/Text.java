/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoverflow;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Text {
    
    String textContent;
    int likes;
    int votes;
    User author;
    LocalDateTime date;

    public Text(String textContent, User author) {
        this.textContent = textContent;
        this.author = author;
        this.votes = 0;
        this.likes = 0;
        date =  LocalDateTime.now();
    }

    
    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public int getLikes() {
        return likes;
    }

    public void doLikes() {
        this.likes++;
    }

    public int getVotes() {
        return votes;
    }

    public void doVotes() {
        this.votes++;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    
}
