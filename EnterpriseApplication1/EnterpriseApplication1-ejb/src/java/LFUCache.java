
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rajeshkumar.yadav
 */
class Data {

    int val;
    int usedFrequency;
    int lastUsedTimeStamp;

    public Data(int v, int u, int tm) {
        this.val = v;
        this.usedFrequency = u;
        this.lastUsedTimeStamp = tm;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getUsedFrequency() {
        return usedFrequency;
    }

    public void setUsedFrequency(int usedFrequency) {
        this.usedFrequency = usedFrequency;
    }

    public int getLastUsedTimeStamp() {
        return lastUsedTimeStamp;
    }

    public void setLastUsedTimeStamp(int lastUsedTimeStamp) {
        this.lastUsedTimeStamp = lastUsedTimeStamp;
    }

}

class LFUCache {

    static int timeStamp = 0;
    int capacity;
    HashMap<Integer, Data> hm;

    public LFUCache(int capacity) {

        this.capacity = capacity;
        hm = new HashMap<Integer, Data>(capacity);

    }

    public int get(int key) {
        if (hm.get(key) != null && capacity != 0) {
            timeStamp++;
            hm.get(key).setUsedFrequency(hm.get(key).getUsedFrequency() + 1);
            hm.get(key).setLastUsedTimeStamp(timeStamp);
            return hm.get(key).getVal();
        }
        return -1;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }
        timeStamp++;
        Data d = new Data(value, 0, timeStamp);
        if (hm.size() < capacity || hm.get(key) != null) {
            if(hm.get(key).getVal() != value)
            hm.put(key, d);
            return;
        }

        int invalidateKey = -1;
        Data invalidateData = null;
        for (HashMap.Entry<Integer, Data> entry : hm.entrySet()) {
            if (invalidateData == null) {
                invalidateData = entry.getValue();
                invalidateKey = entry.getKey();
            } else {
                if (invalidateData.getUsedFrequency() > entry.getValue().getUsedFrequency()) {
                    invalidateData = entry.getValue();
                    invalidateKey = entry.getKey();
                } else if ((invalidateData.getUsedFrequency() == entry.getValue().getUsedFrequency())
                        && invalidateData.getLastUsedTimeStamp() > entry.getValue().getLastUsedTimeStamp()) {
                    invalidateData = entry.getValue();
                    invalidateKey = entry.getKey();
                }
            }
        }
        System.out.println("Inside put function, key invalidated is  " + invalidateKey);
        hm.remove(invalidateKey);
        hm.put(key, d);

    }

    public static void main(String args[]) {
        int capacity = 2;
        LFUCache cache = new LFUCache(capacity);
//        System.out.println("Size of hashMap " + cache.hm.size());
//        cache.put(1, 1);
//        System.out.println("Size of hashMap " + cache.hm.size());
//        cache.put(2, 2);
//        System.out.println("Size of hashMap " + cache.hm.size());
//        int ans = cache.get(1);       // returns 1
//        System.out.println("Value of get " + ans);
//        cache.put(3, 3);    // evicts key 2
//        System.out.println("Size of hashMap " + cache.hm.size());
//        ans = cache.get(2);       // returns -1 (not found)
//        System.out.println("Value of get " + ans);
//        ans = cache.get(3);       // returns 3.
//        System.out.println("Value of get " + ans);
//        System.out.println(cache.hm.get(1).getLastUsedTimeStamp() + " " + cache.hm.get(3).getLastUsedTimeStamp());
//        System.out.println(cache.hm.get(1).getUsedFrequency() + " " + cache.hm.get(3).getUsedFrequency());
//        cache.put(4, 4);    // evicts key 1.
//        ans = cache.get(1);       // returns -1 (not found)
//        System.out.println("Value of get " + ans);
//        ans = cache.get(3);       // returns 3
//        System.out.println("Value of get " + ans);
//        ans = cache.get(4);       // returns 4
//        System.out.println("Value of get " + ans);
//        System.out.println("Size of hashMap " + cache.hm.size());

        int ans = cache.get(2);
        System.out.println("Value of get " + ans);
        cache.put(2, 6);
        ans = cache.get(1);
        System.out.println("Value of get " + ans);
        cache.put(1, 5);
        cache.put(1, 2);
        ans = cache.get(1);
        System.out.println("Value of get " + ans);
        System.out.println("Size of hashMap " + cache.hm.size());
        ans = cache.get(2);
        System.out.println("Value of get " + ans);

    }
}


/*
["LFUCache","get","put","get","put","put","get","get"]
[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]

 */
 /*
["LFUCache","put","put","get","put","get","get","put","get","get","get"]
[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
 */
/**
 * Your LFUCache object will be instantiated and called as such: LFUCache obj =
 * new LFUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
