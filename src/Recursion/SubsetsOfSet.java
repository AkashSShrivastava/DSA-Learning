package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, generate all possible subsets (the power set).
 *
 * Example: Input: [1, 2]
 * Output: [[], [1], [2], [1, 2]]
 */
public class SubsetsOfSet {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);
        System.out.println("Subset of List "+list+ " is: ");
        generateSubsets(list,0,0, new ArrayList<>());
    }


    private static void generateSubsets(List<Integer> initial, int startIndex, int endIndex,  List<List<Integer>> result) {
        if(startIndex >= initial.size()-1 && endIndex >= initial.size()-1) {
            System.out.println("Result is:: "+result);
            return;
        }
        if(endIndex==initial.size()+1) {
            startIndex++;
            endIndex = startIndex;
            endIndex++;
        }
        List<Integer> current = new ArrayList<>();
        try {
            current = initial.subList(startIndex, endIndex++);
        } catch (Exception e) {
            System.out.println("ERROR for:: startIndex="+startIndex+"endIndex="+endIndex);
        }
        result.add(current);
        generateSubsets(initial,startIndex,endIndex,result);
    }

    private void printN(int n) {
        if(n==0)
            return;
        printN(--n);
        System.out.print(n+" ");
    }

    public int fact(int n) {
        if(n<=1)
            return 1;

        return n*fact(n-1);
    }


}
