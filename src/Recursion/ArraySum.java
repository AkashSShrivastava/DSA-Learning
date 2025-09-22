package Recursion;

import java.util.Arrays;

public class ArraySum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        sum(arr,0,0);
    }

    /**
     * 1+2+3+4+5
     * @param arr
     * @return
     */
    private static void sum(int[] arr, int sum, int index) {
        if(index==arr.length){
            System.out.println("Sum is: "+sum);
            return;
        }
        int current = arr[index];
        index++;
        sum +=current;
        sum(arr,sum,index);
    }
}
