
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
    Queue<Pair<Integer, Integer>> queue;

    public NearesBlockedCell(int arr[][]) {

        this.matrix = new ArrayList<>();
        this.resultMatrix = new ArrayList<>();
        queue = new LinkedList<Pair<Integer, Integer>>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> l = new ArrayList<>();
            List<Integer> r = new ArrayList<>();
            
            for (int j = 0; j < arr[0].length; j++) {
                l.add(arr[i][j]);
                r.add(j);
                if (arr[i][j] == 0) {
                    r.set(j, 0);
                    Pair<Integer, Integer> p = new Pair<>(i, j);
                    queue.add(p);
                } else {
                    r.set(j, Integer.MAX_VALUE);
                }
            }
            this.resultMatrix.add(r);
            this.matrix.add(l);
        }
    }

    public void isValidPosition(int x, int y, int n, int m, int val) {
        if (x < n && x >= 0 && y < m && y >= 0) {
            if (resultMatrix.get(x).get(y) > val + 1) {
                resultMatrix.get(x).set(y, val + 1);
                Pair<Integer, Integer> p = new Pair<>(x, y);
                queue.add(p);
            }
            return;
        }
        return;
    }

    public void calculateNearestDistrance() {

        int n = matrix.size();
        int m = matrix.get(0).size();
        while (!queue.isEmpty()) {

            Pair<Integer, Integer> p = queue.poll();
            int x = p.getKey();
            int y = p.getValue();
            int val = resultMatrix.get(x).get(y);
            isValidPosition(x + 1, y, n, m, val);
            isValidPosition(x, y + 1, n, m, val);
            isValidPosition(x - 1, y, n, m, val);
            isValidPosition(x, y - 1, n, m, val);
        }

    }

    public void printResultMatrix() {
        
        for(int i=0; i<resultMatrix.size(); i++){
            for(int j=0; j<resultMatrix.get(0).size(); j++){
                System.out.print(resultMatrix.get(i).get(j) + " ");
            }
            System.out.println("");
        }

    }

    public static void main(String args[]) {

        int[][] a = {
            {1,1,1,0,0},
            {1,1,1,1,1},
            {0,1,1,1,1},
            {1,1,1,1,1},
            {0,1,1,1,1}
        };
        
        NearesBlockedCell nb = new NearesBlockedCell(a);
        nb.calculateNearestDistrance();
        nb.printResultMatrix();
        
    }

}
