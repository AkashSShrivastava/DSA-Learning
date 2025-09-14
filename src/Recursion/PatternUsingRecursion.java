package Recursion;

public class PatternUsingRecursion {
    public static void main(String[] args) {
       topRightAngletrianglePattern(10);
       topRightAngletrianglePattern(10, 0);
       equilateralTrianglePattern(10,0);
    }

    /**
     * Pattern for n
     * ****
     * ***
     * **
     * *
     * @param n
     */
    static void topRightAngletrianglePattern(int n) {
        if(n==0) {
            return;
        }
        for(int i=1;i<=n;i++) {
            System.out.print("*");
        }
        System.out.println();
        topRightAngletrianglePattern(n-1);
    }


    static void topRightAngletrianglePattern(int row, int col) {
        if(row==0) {
            return;
        }
        if(col==row){
            col = 0;
            row--;
            System.out.println();
        } else {
            System.out.print("*");
            topRightAngletrianglePattern(row, col+1);
            return;
        }
        topRightAngletrianglePattern(row, col);
    }


    static void equilateralTrianglePattern(int row, int col) {
        if(row==0) {
            return;
        }
        if(col==row){
            col = 0;
            System.out.println();
        } else {
            System.out.print("* ");
            equilateralTrianglePattern(row, col+1);
            return;
        }
        equilateralTrianglePattern(--row, col);
    }
}
