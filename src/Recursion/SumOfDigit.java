package Recursion;

public class SumOfDigit {
    public static void main(String[] args) {
        System.out.println("Sum of digit is::" +sum(0));
    }

    private static int sum(int i) {
        int lst = i%10;
        int remaining = i/10;
        if(remaining == 0)
            return lst;
        return lst + sum(remaining);
    }
}
