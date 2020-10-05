
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshkumar.yadav
 */

class PushPopSequenece{
    
    List<Integer> pushSequence;
    List<Integer> popSequence;
    List<String> OperationList;

    public PushPopSequenece(List<Integer> pushSequence, List<Integer> popSequence) {
        this.pushSequence = pushSequence;
        this.popSequence = popSequence;
        OperationList = new ArrayList<>();
    }
    
    
    
    
    public void getPushPopOperation(){
        Stack<Integer> st = new Stack<>();
        int j = 0;
        for(int i=0; i<pushSequence.size(); i++){
            
            st.push(pushSequence.get(i));
            OperationList.add("push " + pushSequence.get(i));
            while(!st.isEmpty() && popSequence.get(j) == st.peek()){
                OperationList.add("pop " + popSequence.get(j));
                j++;
                st.pop();
            }
            
        }
        if(!st.isEmpty() || j != popSequence.size())
        {
            System.out.println("Not Possible");
        }else{
            System.out.println(OperationList.toString());
        }
        
    }
    
    
    
    
}

public class MyStackQuestion {
    
    public static void main(String[] args) {
        List<Integer> pushSeq = new ArrayList<>();
        List<Integer> popSeq = new ArrayList<>();
        pushSeq.add(1);
        pushSeq.add(2);
        pushSeq.add(3);
        pushSeq.add(4);
        pushSeq.add(5);
        popSeq.add(1);
        popSeq.add(5);
        popSeq.add(3);
        popSeq.add(2);
        popSeq.add(1);
        PushPopSequenece pp = new PushPopSequenece(pushSeq, popSeq);
        pp.getPushPopOperation();
    }
    
}
