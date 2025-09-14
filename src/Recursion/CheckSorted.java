package Recursion;

import java.util.Arrays;

public class CheckSorted {
    public static void main(String[] args) {
        System.out.println(checkSorted(new int[]{0,1,2,3,4,5,6,7,8,9,10}, Integer.MAX_VALUE));
    }

    static boolean checkSorted(int[] arr, int prev) {
        if (arr.length < 1) {
            return true;
        }

        int last = arr[arr.length - 1];

        if(last > prev) {
            return false;
        } else {
            int[] newArr = Arrays.copyOfRange(arr, 0, arr.length - 1);
            return checkSorted(newArr,  last);
        }

    }
}
