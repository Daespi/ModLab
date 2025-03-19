package com.example.Operations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {
    public static int isNull(String s) {
        String sTrimed = s.trim();
        if (sTrimed == null || sTrimed == " " || sTrimed == "")
            return -1;
        return 0;
    }

    public static int isNull(boolean s) {
        if (s != false || s != true)
            return -1;
        return 0;
    }

    public static int minLength(int numeral, String s) {
        if (s.trim().length() < numeral)
            return -2;
        return 0;
    }

    public static int maxLenght(int numeral, String s) {
        if ((s.trim().length()) > numeral)
            return -10;
        return 0;
    }

    public static int nonZero(int numeral) {
        if (numeral == 0)
            return -3;
        return 0;
    }

    public static int nonZero(double numeral) {
        if (numeral == 0)
            return -3;
        return 0;
    }

    public static int nonNegative(int numeral) {
        if (numeral < 0)
            return -4;
        return 0;
    }

    public static int nonNegative(double numeral) {
        if (numeral < 0)
            return -4;
        return 0;
    }

    public static int maxValue(int numeral, int numeralMax) {
        if (numeral > numeralMax)
            return -5;
        return 0;
    }

    public static int maxValue(double numeral, double numeralMax) {
        if (numeral > numeralMax)
            return -5;
        return 0;
    }

    public static int minValue(int numeral, int numeralMin) {
        if (numeral < numeralMin)
            return -7;
        return 0;
    }

    public static int minValue(double numeral, double numeralMin) {
        if (numeral < numeralMin)
            return -7;
        return 0;
    }

    public static int minValueCount(int numeral, int numeralMin) {
        String numeralToString = Integer.toString(numeral);
        if ((numeralToString.trim().length()) < numeralMin)
            return -11;
        return 0;
    }

    public static int maxValueCount(int numeral, int numeralMin) {
        String numeralToString = Integer.toString(numeral);
        if ((numeralToString.trim().length()) > numeralMin)
            return -12;
        return 0;
    }

    public static int verifyPassword(String password) {
        String patron = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.* )(?!^[^a-zA-Z0-9]).{8,25}$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            return -13;
        } else {
            return 0;
        }
    }

    public static int verifyMail(String correo) {
        String expresionRegular = "^[a-zA-Z0-9._%+-]{5,64}@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

        Pattern pattern = Pattern.compile(expresionRegular);
        Matcher matcher = pattern.matcher(correo);

        if (!matcher.matches()) {
            return -14;
        } else {
            return 0;
        }
    }

    public static int verifyPhone(String phoneNumber) {
        String regex = "^(\\+\\d{1,3}\\s?)?(\\(\\d{3}\\)|\\d{3})[-\\s]?\\d{3}[-\\s]?\\d{4}$";
        if (!phoneNumber.matches(regex)) {
            return -15;
        } else {
            return 0;
        }
    }

}
