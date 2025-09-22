package Recursion;

import java.util.List;

public class PrintNumber {
    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber();
        int count = 1;
        printNumber.printNumbersFromNto1(100,0);
        System.out.println("Series of Binaries::: ");
        generateBinaryStrings(3,"");
        System.out.println("Series of Binaries::: (Skipping 1) ->");
        generateBinaryStringsWithNoConsecutive1s(4,"");

    }

    private void printNumbersFromNto1(int n, int counter) {
        if(n==0) {
            System.out.println("Recursive function called for:: "+counter);
            return;
        }
        System.out.println(n);
        printNumbersFromNto1(--n, ++counter);
    }

    public static void countDown(int n) {
        if(n<=0)
            return;
        System.out.println(n);
        countDown(n-1);
    }

    public static int factorial(int n) {
        if(n<=1) {
            return 1;
        }

        return n*factorial(n-1);
    }

    public static void generateBinaryStrings(int n, String prefix) {
        if(n<=0) {
            System.out.print(prefix+" ");
            return;
        }

        generateBinaryStrings(n-1,prefix+"0");
        generateBinaryStrings(n-1,prefix+"1");
    }

    // Add constraint: no consecutive 1s allowed
    // Example: for n=3, generate: 000, 001, 010, 100, 101
    // DON'T generate: 011, 110, 111 (these have consecutive 1s)
    public static void generateBinaryStringsWithNoConsecutive1s(int n, String prefix) {
        if(n<=0) {
            System.out.print(prefix+" ");
            return;
        }

        generateBinaryStringsWithNoConsecutive1s(n-1,prefix+"0");
        if(!prefix.isEmpty())
            if('1'==prefix.charAt(prefix.length()-1)){
                return;
            }
        generateBinaryStringsWithNoConsecutive1s(n-1,prefix+"1");
    }
    /**
     * DryRUN
     * 01
     */

}

