package Recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        towerOfHanoi(3,'A','C', 'B');
    }

    public static void towerOfHanoi(int n, char source, char auxiliary, char destination){
        if(n<=0)
            return;

        towerOfHanoi(n-1,source,destination, 'B');
        System.out.println("Move Bar "+n+" from "+source+" to "+ destination+ " via " + auxiliary+".");
        towerOfHanoi(n-1,'A','C', 'B');



    }

}
