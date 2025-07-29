package JavaPrimer;

import java.util.Scanner;

/**
 * R-1.1 Write a short Java method, inputAllBaseTypes, that inputs a different value of
 * each base type from the standard input device and prints it back to the standard
 * output device.
 */
public class ExercisesR11 {
    public static void main(String[] args) {
        inputAllBaseTypes();
    }

    private static void inputAllBaseTypes() {
        Scanner sc = new Scanner(System.in);
        //int
        System.out.println("Enter any number:");
        while (!sc.hasNextInt()) {
            sc.nextLine();
            System.out.println("ERROR:::: Enter a valid INTEGER!!!!!!!");
        }
        int number = sc.nextInt();
        System.out.println("Entered Number is:: "+ number);

        //Float
        System.out.println("Enter any number(Float):");
        while (!sc.hasNextFloat()) {
            sc.nextLine();
            System.out.println("ERROR:::: Enter a valid FLOAT!!!!!!!");
        }
        float floatValue = sc.nextFloat();
        System.out.println("Entered Float is:: "+ floatValue);

        //BYTE
        System.out.println("Enter any BYTE:");
        while (!sc.hasNextByte()) {
            sc.nextLine();
            System.out.println("ERROR:::: Enter a valid BYTE!!!!!!!");
        }
        byte byteValue = sc.nextByte();
        System.out.println("Entered Byte is:: "+ byteValue);

        //STRING
        System.out.println("Enter any String:");
        while (!sc.hasNextLine()) {
            sc.nextLine();
            System.out.println("ERROR:::: Enter a valid String!!!!!!!");
        }
        String stringValue = sc.nextLine();
        System.out.println("Entered String is:: "+ stringValue);
    }
}
