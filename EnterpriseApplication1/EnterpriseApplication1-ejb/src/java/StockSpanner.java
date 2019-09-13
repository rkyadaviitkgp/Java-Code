
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
public class StockSpanner {
    
    List<Integer> stock;
    List<Integer> span;

    public StockSpanner() {
        this.stock  = new ArrayList<Integer>();
        this.span  = new ArrayList<Integer>();
    }
    
    private int recursiveCalculate(int ind, int price)
    {
        if(ind < 0)
            return 0;
        if(stock.get(ind) <= price)
            return span.get(ind) + recursiveCalculate(ind - span.get(ind), price);
        return 0;
            
    }
    
    public int next(int price) {
        int count = 0;
        stock.add(price);
        count =  recursiveCalculate(stock.size()-2, price);
        span.add(count+1);
        return count + 1;
    }
    
}
