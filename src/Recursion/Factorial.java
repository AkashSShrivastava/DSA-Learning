package Recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(fact(2));
        System.out.println(fact(3 ));
        System.out.println(fact(4));
    }

    /**
     * n x (n-1) x (n-2) x (n-3) .... n=1
     * @param n
     * @return
     */
    public static int fact(int n) {
        if(n==0)
            return 1;
        else {
            return n*fact(n-1);
        }
    }
}
