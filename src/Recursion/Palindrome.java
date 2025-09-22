package Recursion;

public class Palindrome {
    public static void main(String[] args) {
        String s = "naan";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s){
        if(s.length()<=1)
            return true;
        if(s.charAt(s.length()-1)!=s.charAt(0)) {
            return false;
        }
        return isPalindrome(s.substring(1,s.length()-1));
    }
}
