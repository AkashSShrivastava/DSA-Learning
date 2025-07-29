package JavaPrimer;

/**
 * Write a short Java method that uses a StringBuilder instance to remove all the
 * punctuation from a string s storing a sentence, for example, transforming the
 * string "Let’s try, Mike!" to "Lets try Mike".
 */

public class ExercisesR19 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Let's try, Mike!");
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='\''){
                sb.deleteCharAt(i);
            }
        }
        System.out.println(sb);
    }
}
