package JavaPrimer;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * P-1.29 The birthday paradox says that the probability that two people in a room will
 * have the same birthday is more than half, provided n, the number of people in the
 * room, is more than 23. This property is not really a paradox, but many people
 * find it surprising. Design a Java program that can test this paradox by a series
 * of experiments on randomly generated birthdays, which test this paradox for n =
 * 5,10,15,20, . . . ,100.
 */
public class ExerciseP129 {
    public static void main(String[] args) {
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the sample size (N) = ");
            int n = sc.nextInt();
            int duplicateBirthdayCount = 0;

            List<String> birthdayList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                birthdayList.add(generateBirthday());
            }

            //trimming the year part from each generated birthday
            birthdayList = birthdayList.stream().map(birthDay -> birthDay.substring(0, birthDay.length() - 4)).collect(Collectors.toList());
            System.out.println(birthdayList);

            //Checking if 2 persons have birthdays on same day
            Set<String> birthdaySet = new HashSet<>();
            for (String birthday : birthdayList) {
                if (!birthdaySet.add(birthday)) {
                    System.out.println("Duplicate birthday found for sample size of :: " + n + " :: " + birthday);
                    duplicateBirthdayCount++;
                }

            }

            System.out.println("Total Duplicate Birthday :: " + duplicateBirthdayCount);
            System.out.println("Duplicate Birthday Probability :: " + (float) duplicateBirthdayCount / n);
        }
    }

    public static String generateBirthday() {
        int day = getRandomNumber(1, 31);
        MONTHS randomMonth = getRandomMonth();
        int year = getRandomNumber(1950, 2025);

        if (day == 31 && (randomMonth == MONTHS.APR || randomMonth == MONTHS.JUN || randomMonth == MONTHS.SEP || randomMonth == MONTHS.NOV)) {
            return generateBirthday();
        }

        if (MONTHS.FEB == randomMonth && day > 30) {
            return generateBirthday();
        }

        if (MONTHS.FEB == randomMonth && day == 29 && year % 4 != 0) {
            return generateBirthday();
        }
        return day + randomMonth.toString() + year;
    }

    public static MONTHS getRandomMonth() {
        MONTHS[] months = MONTHS.values();
        Random rand = new Random();
        int index = rand.nextInt(months.length);
        return months[index];
    }

    public static int getRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    private enum MONTHS {JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC}
}
