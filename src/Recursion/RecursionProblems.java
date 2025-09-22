package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursionProblems {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        generatePermutations( arr,0, "");
        System.out.println(ifPalindrome(10001));
        noOfSteps(14);
    }

    static void noOfSteps(int num){
        if(num==0){
            return;
        }
        if(num%2==0) {
            System.out.print(num+" is even; divide by 2 ");
            num= num/2;
            System.out.println("and obtain "+num);
        } else {
            System.out.print(num+" is odd; subtract 1 ");
            --num;
            System.out.println("and obtain "+num);
        }
        noOfSteps(num);
    }

    private static boolean ifPalindrome(int n) {
        if(n%10==n) {
            return true;
        }
        //1234%10 = 4
        int lastDigit = n%10;
        System.out.println("lastDigit is:  "+lastDigit);
        int firstDigit = (int) (n/(Math.pow(10,(int)Math.log10(n))));
        System.out.println("firstDigit is:  "+firstDigit);
        if(firstDigit!=lastDigit) {
            return false;
        }
        n=n/10; //removing last digit
        System.out.println("After removing last digit: "+n);

        int x = (int) Math.pow(10,(int) Math.log10(n));
        x = x*firstDigit;
        n = (n- x);
        System.out.println("After removing first digit: "+n);
        return ifPalindrome(n);
    }

    /**
     *  Place n queens on an n×n chessboard so no two queens attack each other. For now, just count how many solutions exist for n=4.
     */
    public static int countNQueens(int n) {
        return 0;
    }

    /**
     * for input [1,2,3]
     * Expected output: [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]
     * @param nums
     * @param index
     */
    public static void generatePermutations(int[] nums, int index, String curr) {

    }
}
