/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hitcounter;
/**
 *
 * @author rajeshkumar.yadav
 */
public class HitCounter {
    
    int arr[];
    int index,count,len;
    
    public HitCounter(int len)
    {
        arr = new int[len];
        index = 0;
        count = 0;
        this.len = len;
    }
    
    public void hit(int timeStamp) /* hit(t) denotes hit requset at timestamp t */
    {
        int temp = 0;
        for(;index<=timeStamp;index++)
        {
            if(index%len == timeStamp%len)
            {
                temp = temp + arr[index%len];
                arr[index%len] = 1;
                count = count - temp + 1;
                index = index + 1;
                return;
            }
            else{
                temp = temp + arr[index%len];
                arr[index%len] = 0;
            }
        }
    }
    
    public int getHitCount()
    {
        return count;
    }
    
    public static void main(String[] args) {
        
        HitCounter ht = new HitCounter(300);
        ht.hit(1);
        ht.hit(2);
        ht.hit(3);
        System.out.println(" ht.getHitCount() " + ht.getHitCount());
        ht.hit(300);
        System.out.println(" ht.getHitCount() " + ht.getHitCount());
        ht.hit(301);
        System.out.println(" ht.getHitCount() " + ht.getHitCount());
    }
    
}
