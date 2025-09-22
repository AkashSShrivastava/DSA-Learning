package Recursion;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(rec(1234));
    }

    static int base;
    static int rec(int n){
        if(n<10)
            return n;
        base = (int) (Math.log10(n));
        base = (int) Math.pow(10,base);
        return n%10*(base)+rec(n/10);
    }
}
