package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Write a recursive function to generate all binary strings of length n.
 * <p>
 * For example, if
 * n=3, the output should be:
 * 000, 001, 010, 011, 100, 101, 110, 111
 */
public class GenerateBinary {
    public static void main(String[] args) {
        generateBinaryStringsWithoutRecursion(3);
        generateBinaryStrings(3,"",new ArrayList<>());
    }

    public static void generateBinaryStrings(int n, String prefix, List<String> result){
        if(n==0){
            result.add(prefix);
            if(result.size() == (int)Math.pow(2, prefix.length()))
                System.out.println(result);
            return;
        }
        generateBinaryStrings(n-1, prefix+"0", result);
        generateBinaryStrings(n-1, prefix+"1", result);
    }



    public static void generateBinaryStringsWithoutRecursion(int n){
        List<String> finalList = new ArrayList<>();
        finalList.add("");
        while(n>0) {
            finalList = generateList(finalList);
            n--;
        }
        System.out.println(finalList);
    }

    private static List<String> generateList(List<String> S) {
        List<String> newList = new ArrayList<>();
        for(String s: S){
            newList.add(s+"0");
            newList.add(s+"1");
        }
        return newList;
    }
}
