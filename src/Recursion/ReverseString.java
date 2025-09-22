package Recursion;

public class ReverseString {
    public static void main(String[] args) {
        String s = "Hello";
        reverse(s,0);
    }

    private static void reverse(String s, int index) {
        if(index == s.length()){
            return;
        }
        reverse(s,index+1);
        System.out.print(s.charAt(index));
    }
}
