package Recursion;

public class FactorialUsingRecrsion {
    public static void main(String[] args) {
        int fact = findFact(4);
        System.out.println(fact);
    }


    private static int findFact(int i) {
         if(i == 0)
            return 1;
         else {
             return i * findFact(i-1);
         }
    }
}