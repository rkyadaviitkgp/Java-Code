
import com.sun.xml.internal.ws.util.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /* input will be 

<Key: value >
<Key: Value1; Value2; Value3; >

 */
/**
 *
 * @author rajeshkumar.yadav
 */
public class KeyValueParser {
    
    
     public static char slowestKey(List<List<Integer>> keyTimes) {
    // Write your code here

    int len = keyTimes.size();
        List<Pair<Integer, Integer>> listp = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < keyTimes.size(); i++) {
            Pair<Integer, Integer> p = new Pair(keyTimes.get(i).get(0), keyTimes.get(i).get(1));
            //System.out.println(p.getKey() + " " + p.getValue());
            listp.add(p);
        }
    //System.out.println();
        Collections.sort(listp, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(final Pair<Integer, Integer> o1, final Pair<Integer, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return 1;
                } else if (o1.getValue().equals(o2.getValue())) {
                    return 0; // You can change this to make it then look at the
                    //words alphabetical order
                } else {
                    return -1;
                }
            }

        });
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int no = 0, maxval = 0;
        for(int i=0; i<listp.size()-1; i++)
        {
            if(listp.get(i+1).getValue() - listp.get(i).getValue() > maxval)
            {
                no = listp.get(i).getKey();
                maxval = listp.get(i+1).getValue() - listp.get(i).getValue();
            }
            System.out.println(listp.get(i).getKey() + " "+ listp.get(i).getValue());
        }

        return alpha.charAt(no);

    }


    public static int maxEventUtil() {

        return 0;
    }

    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        // Write your code here
        int len = arrival.size();
        List<Pair<Integer, Integer>> listp = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < arrival.size(); i++) {
            Pair<Integer, Integer> p = new Pair(arrival.get(i), duration.get(i));
            listp.add(p);
        }

        Collections.sort(listp, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(final Pair<Integer, Integer> o1, final Pair<Integer, Integer> o2) {
                if (o1.getKey() > o2.getKey()) {
                    return 1;
                } else if (o1.getKey().equals(o2.getKey())) {
                    return 0; // You can change this to make it then look at the
                    //words alphabetical order
                } else {
                    return -1;
                }
            }

        });
        arrival.clear();
        duration.clear();
        for(int i=0; i<listp.size(); i++)
        {
            arrival.add(listp.get(i).getKey());
            duration.add(listp.get(i).getValue());
            System.out.println(arrival.get(i) + " "+ duration.get(i));
        }
        return 0;
    }

    Map<String, Integer> m1;
    Map<String, String> m2;
    String[] str;
    int noOfLines;

    public KeyValueParser(String[] inp) {
        int n = inp.length;
        str = new String[inp.length];
        for (int i = 0; i < n; i++) {
            str[i] = inp[i];
        }
        m1 = new HashMap<String, Integer>();
        m2 = new HashMap<String, String>();
    }

    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int calculateValue(String key) {
        System.out.println("KeyValueParser.calculateValue() called for key " + key);
        String str[];
        if (m1.containsKey(key)) {
            return m1.get(key);
        }

        if (!m2.containsKey(key)) {
            return -1;
        }

        str = m2.get(key).split(";");
        System.out.println("KeyValueParser.calculateValue() str.length " + str.length);
        int ans = 0;

        for (int i = 0; i < str.length; i++) {
            if (isNumeric(str[i])) {
                ans = ans + Integer.parseInt(str[i]);
            } else {
                int temp = calculateValue(str[i]);
                System.out.println("KeyValueParser.calculateValue() temp " + temp);
                if (temp == -1) {
                    return -1;
                } else {
                    ans = ans + temp;
                }
            }
        }
        m1.put(key, ans);
        return ans;
    }

    public int getResult() {
        int res = 0;
        for (String key : m2.keySet()) {
            System.out.println("KeyValueParser.getResult() key " + key);
            if (calculateValue(key) == -1) {
                noOfLines = -1;
                return -1;
            }
        }
        for (Integer key : m1.values()) {
            res = res + key;
        }
        noOfLines = res;
        return res;
    }

    public void parseString() {
        String keyval[] = new String[2];
        String val[];
        for (int i = 0; i < str.length; i++) {
            str[i] = str[i].substring(1, str[i].length() - 1);
            //System.out.println("KeyValueParser.parseString() str[i] " + str[i]);
            keyval = str[i].split(":");
            keyval[0] = keyval[0].trim();
            keyval[1] = keyval[1].trim();
            //System.out.println("KeyValueParser.parseString() " + keyval[0] + " " + keyval[1]);
            val = keyval[1].split(";");
            if (val.length == 1) {
                System.out.println("KeyValueParser.parseString() val = 1 " + keyval[0] + " " + keyval[1]);
                m1.put(keyval[0], Integer.parseInt(keyval[1]));
            } else {
                System.out.println("KeyValueParser.parseString() val = 2 " + keyval[0] + " " + keyval[1]);
                m2.put(keyval[0], keyval[1]);
            }
        }

    }

    public static void main(String[] args) {

//        String arr[] = {"<Key1: Key2;Key3;Key4>", "<Key2:2>", "<Key3:4>", "<Key4:5>"};
//        KeyValueParser kvp = new KeyValueParser(arr);
//        kvp.parseString();
//        kvp.getResult();
//        System.out.println("KeyValueParser.main() " + kvp.noOfLines);
List<Integer> a1 = new ArrayList<>();
List<Integer> a2 = new ArrayList<>();
List<Integer> a3 = new ArrayList<>();
List<Integer> a4 = new ArrayList<>();
a1.add(3);
a1.add(7);
a1.add(2);
a1.add(6);
a1.add(1);
a1.add(5);
a1.add(0);
a1.add(1);

            
    }
}
