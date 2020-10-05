
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshkumar.yadav
 */
public class OpeningClosing {
    
    int len;
    List<String> strList;

    public OpeningClosing(int len) {
        this.len = len;
        strList = new ArrayList<>();
    }
    
    public void printList(){
        System.out.println(strList.toString());
    }
    
    public void generateAllValidParenthesis(){
        generateAllValidParenethesisUtil(0, 0, "", 0);
    }
    
    private void generateAllValidParenethesisUtil(int OpenLen, int closeLen, String str, int index){
        
       
        
        if(index > 2*len)
            return;
        if(OpenLen < closeLen)
            return;
         if(index == 2*len)
        {
            strList.add(str);
            return;
        }
        if(OpenLen < len){
            generateAllValidParenethesisUtil(OpenLen+1, closeLen, str + "(", index+1);
            if(OpenLen > closeLen)
                generateAllValidParenethesisUtil(OpenLen, closeLen+1, str + ")", index+1);
        }else{
            generateAllValidParenethesisUtil(OpenLen, closeLen+1, str + ")", index+1);
        }
        
    }
    
    public static void main(String[] args) {
        OpeningClosing oc = new OpeningClosing(4);
        oc.generateAllValidParenthesis();
        oc.printList();
    }
    
    
    
}
