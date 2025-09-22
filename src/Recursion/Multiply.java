package Recursion;

/**
 * In grade school, you learned to multiply long numbers on a digit-by-digit basis,
 * e.g., 127 × 211 = 127 × 1 + 127 × 10 + 127 × 200 = 26, 397.
 * Derive the time complexity of multiplying two n-digit numbers with this method as a function of n (assume constant base size). Assume that single-digit by single-digit addition or multiplication takes O(1) time. Use of the given hint may be awarded full mark.
 * (Hint: Consider polynomial representation of both the numbers to derive the time complexity).
 */
public class Multiply {

    public static void main(String[] args) {
        int num1 = 127;
        int num2 = 211;
        System.out.println("The product is: "+multiply(num1, num2));
    }

    static int multiply(int base, int multiplier){
        int power = (int) Math.log10(multiplier);
        System.out.println("Power is: "+power);
        System.out.println("Multiplier is: "+multiplier);
        if(multiplier < 10) {
            return multiplier;
        }

        return (int) (base*( (int)multiplier%10*Math.pow(10,power)) + multiply(base, multiplier/10));
    }
}
