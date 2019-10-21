
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import javafx.util.Pair;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshkumar.yadav
 */


public class NearesBlockedCell {
    
    List<List<Integer>> matrix;
    List<List<Integer>> resultMatrix;
    PriorityQueue<Pair<Integer,Integer>> queue = new PriorityQueue<>();

    public NearesBlockedCell(int arr[][]) {
        
        this.matrix = new ArrayList<>();
        this.resultMatrix = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            List<Integer> l = new ArrayList<>();
            List<Integer> r = new ArrayList<>(arr[0].length);
            for(int j=0; j<arr[0].length; j++)
            {
                l.add(arr[i][j]);
                if(arr[i][j] == 0)
                {
                    r.set(j, 0);
                    Pair<Integer, Integer> p  = new Pair<>(i,j);
                    queue.add(p);
                }else{
                    r.set(j, Integer.MAX_VALUE);
                }
            }
            this.resultMatrix.add(r);
            this.matrix.add(l);
        }
    }
    
    
    
    
    
    
}
