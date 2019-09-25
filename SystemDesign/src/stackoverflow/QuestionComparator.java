/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoverflow;

import java.util.Comparator;

/**
 *
 * @author rajeshkumar.yadav
 */
public class QuestionComparator implements Comparator<Question>{
    
    public int compare(Question s1, Question s2) { 
                if (s1.getDate().compareTo(s2.getDate()) < 0) 
                    return 1; 
                else if (s1.getDate().compareTo(s2.getDate()) > 0) 
                    return -1; 
                                return 0; 
                } 
    
}
