package programming;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Arishtha {

    /*
     * Complete the 'editDistance' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING source
     *  2. STRING target
     */

    

    public static void shiftByOne(char[] array){
        for(int i=0; i<array.length; i++){
            array[i] = (char) ((int)array[i] + 1 > 122 ? (97 + (int)array[i] -122) : (int)array[i] + 1 );
        }
    }

    public static int matchArray(char[] array1, char[] array2){
        int count = 0;
        for(int i=0; i<array1.length; i++){
            if(array1[i] == array2[i])
            {
                count++;
            }
        }
        return count;
    }

    public static void copyArray(char[] src, char[] trg){
        for(int i=0; i<src.length; i++)
            trg[i] = src[i];
    }

    public static void printArray(char[] array){
        for(int i=0; i<array.length; i++)
            System.out.print(" " + array[i]);
        System.out.println();
    }

    public static int editDistance(String source, String target) {
    // Write your code here

    char[] src = source.toCharArray();
    char[] trg = target.toCharArray();
    int count = matchArray(src, trg);
    char[] out = source.toCharArray();
System.out.println(count);
    for(int i = 0; i<26; i++){
        shiftByOne(src);
        printArray(src);
        int matchScore = matchArray(src, trg);
        if(matchScore > count){
            count = matchScore;
            copyArray(src, out);
        }
    }

    printArray(out);

    int i = 0;
    int j = 0;
    while(i<out.length){
        if(out[i] == trg[j]){
            j++;
        }
        i++;
    }

    return (trg.length - j) * 2; 
    
    }
    
    public static void main(String args[]) {
		System.out.println(editDistance("ab", "cd"));
	}

}
