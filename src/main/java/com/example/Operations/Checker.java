package com.example.Operations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.Exceptions.BuildException;

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

    public static LocalDate checkDate(String data) throws BuildException {

        if (data == null) {
            throw new BuildException("La fecha no puede ser nula");
        }

        String patron = "^(?:\\d{2}-\\d{2}-\\d{4}|\\d{4}-\\d{2}-\\d{2})$";

        if (!data.matches(patron)) {
            throw new BuildException("La fecha no tiene las separaciones correctas o no sigue el formato");
        }

        if (data.charAt(4) == '-') {
            data = data.substring(8, 10) + "-" + data.substring(5, 7) + "-" + data.substring(0, 4);
        }

        int day = Integer.parseInt(data.substring(0, 2));
        int month = Integer.parseInt(data.substring(3, 5));
        int year = Integer.parseInt(data.substring(6));

        if (day < 1 || day > 31) {
            throw new BuildException("El día de la fecha no es válido");
        }
        if (month < 1 || month > 12) {
            throw new BuildException("El mes de la fecha no es válido");
        }
        if (year < 1800 || year > 2200) {
            throw new BuildException("El año de la fecha no es válido");
        }

        if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 31) {
            throw new BuildException("El día 31 no es válido para el mes especificado");
        }

        if (month == 2) {
            if (day > 29) {
                throw new BuildException("Febrero no puede tener más de 29 días");
            }
            if (day == 29 && !(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))) {
                throw new BuildException("El año no es bisiesto, febrero no puede tener 29 días");
            }
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return LocalDate.parse(data, formatter);
        } catch (DateTimeParseException e) {
            throw new BuildException("La fecha es inválida");
        }
    }

    public static LocalDateTime checkDateAndTime(String data) throws BuildException {
        if (data == null) {
            throw new BuildException("La fecha no puede ser nula");
        }

        String patron = "^(?:\\d{2}[-/]\\d{2}[-/]\\d{4} \\d{2}:\\d{2}:\\d{2}|\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2})$";

        if (!data.matches(patron)) {
            throw new BuildException("La fecha y hora no tienen el formato adecuado");
        }

        if (data.charAt(4) == '-') {
            data = data.substring(8, 10) + "-" + data.substring(5, 7) + "-" + data.substring(0, 4) + data.substring(10);
        }
        if (data.charAt(4) == '/') {
            data = data.substring(8, 10) + "/" + data.substring(5, 7) + "/" + data.substring(0, 4) + data.substring(10);
        }

        String day = data.substring(0, 2);
        String month = data.substring(3, 5);
        String year = data.substring(6, 10);
        String hour = data.substring(11, 13);
        String minute = data.substring(14, 16);
        String second = data.substring(17, 19);

        checkDate(day + "-" + month + "-" + year);

        int h = Integer.parseInt(hour);
        int m = Integer.parseInt(minute);
        int s = Integer.parseInt(second);

        if (h < 0 || h > 23) {
            throw new BuildException("La hora no es válida");
        }
        if (m < 0 || m > 59) {
            throw new BuildException("Los minutos no son válidos");
        }
        if (s < 0 || s > 59) {
            throw new BuildException("Los segundos no son válidos");
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            return LocalDateTime.parse(data, formatter);
        } catch (DateTimeParseException e) {
            throw new BuildException("La fecha y hora son inválidas");
        }
    }

}
