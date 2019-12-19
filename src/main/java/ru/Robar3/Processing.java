package ru.Robar3;

public class Processing {
    public static String tenToTwo(long number) {
        return Long.toBinaryString(number);
    }

    public static String tenToSixteen(long number) {
        return Long.toHexString(number);
    }

    public static String twoToEight(String eightNumber) {
        return Long.toHexString(Long.parseLong(eightNumber, 2));
    }

    public static boolean correctIn(String validNumber) {
        try {
            Long.parseLong(validNumber, 16);
        } catch (NumberFormatException e) {
            try {
                Long.parseLong(validNumber, 8);
            } catch (NumberFormatException e1) {
                try {
                    Long.parseLong(validNumber, 2);
                } catch (NumberFormatException e2) {
                    return false;
                }
            }
        }
        return true;
    }
}