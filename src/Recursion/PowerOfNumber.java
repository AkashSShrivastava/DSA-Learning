package Recursion;

public class PowerOfNumber {

    public static void main(String[] args) {
        System.out.println("Power of Number n^m is: "+ power(2,2));
    }

    public static int power(int base, int power) {
        if(power<1) {
            return 1;
        }
        else {
            power --;
            return base*power(base,power);
        }
    }
}
