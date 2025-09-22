package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Write a recursive function to generate all subsets (the power set) of a given array of integers.
 * Example:
 * Input: [1, 2, 3]
 * Output: [[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]
 */
public class GenerateSubset {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        generateSubsets(arr,0,new ArrayList<>(),new ArrayList<>());
        generateSubsetsWithoutRecursion(arr);
    }

    private static void generateSubsetsWithoutRecursion(int[] arr) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        // Start with the empty subset
        allSubsets.add(new ArrayList<>());

        for (int num : arr) {
            int size = allSubsets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSubset = new ArrayList<>(allSubsets.get(i));
                newSubset.add(num);
                allSubsets.add(newSubset);
            }
        }
        //System.out.println(allSubsets);
    }

    public static void generateSubsets(int[] arr, int index, List<Integer> currentSubset, List<List<Integer>> allSubsets){
        if(allSubsets.size()>=Math.pow(2, arr.length)) {
            System.out.println(allSubsets);
            return;
        }
        if(index<3)
            currentSubset.add(arr[index++]);

        allSubsets.add(currentSubset);
        generateSubsets(arr,index,currentSubset,allSubsets);
        generateSubsets(arr,index+1,currentSubset,allSubsets);
    }
}
