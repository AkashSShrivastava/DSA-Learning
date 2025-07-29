package JavaPrimer;

import java.util.Arrays;

/**
 * Suppose that we create an array A of GameEntry objects, which has an integer
 * scores field, and we clone A and store the result in an array B. If we then immediately
 * set A[4].score equal to 550, what is the score value of the GameEntry
 * object referenced by B[4]?
 */
public class ExerciseR12 {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        int[] B = A.clone();

        //Set A[4] as 550
        A[4] = 550;

        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
    }
}
