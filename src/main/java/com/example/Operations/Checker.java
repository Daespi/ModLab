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
        if (s == null) return -1;
        String sTrimed = s.trim();
        if (sTrimed == " " || sTrimed == "")
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
        if (numeral < 0 || numeral < 0.00)
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
        String patron = "^(?=.*[!@#$%^&*(),.?\":{}|<>])(?=(.*[a-z]){4,})(?=(.*[A-Z]){1,})(?=(.*\\d){3,})[a-zA-Z0-9!@#$%^&*(),.?\":{}|<>]{8,25}$";
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
        String regex = "^\\d{9}$"; 
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

    public static int verifyAddress(String address) {
        if( isNull(address) != 0){
            return -1;
        }
        String patron = "^(Calle|Av\\.?|Avenida|Paseo|C/|Plaza|Camino|Carretera|Ronda)\\s+[A-Za-zÀ-ÿ0-9'\\-\\.\\s]+(,\\s*\\d+[A-Za-z0-9ºª\\s]*)?$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(address);
        if (!matcher.matches()) {
            return -16;
        }
        return 0;
    }

    public static int verifyZipCode(String zipCode) {
        if( isNull(zipCode) != 0){
            return -1;
        }
        String patron =  "^(0[1-9]|[1-4][0-9]|5[0-2])[0-9]{3}$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(zipCode);
        if (!matcher.matches()) {
            return -17;
        }
        return 0;
    }

    public static int verifyCity(String city) {
        if( isNull(city) != 0){
            return -1;
        }
        String regex = "^[\\p{L}]+(?:[ '\\-][\\p{L}]+)*$";
        Pattern pattern = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(city.trim());
        if (matcher.matches()) {
            return 0;
        }
        return -18;
    }


    public static int verifyState(String state) {
        if( isNull(state) != 0){
            return -1;
        }
        String regex = "^[\\p{L}]+(?:[ '\\-][\\p{L}]+)*$";
        Pattern pattern = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(state.trim());
        if (matcher.matches()) {
            return 0;
        }
        return -19;
    }

    public static int verifyCountry(String country) {
        if( isNull(country) != 0){
            return -1;
        }       
        if (country == "España" || country == "españa") {
            return 0;
        }
        return -20;
    } 

    public static int verifyUuid (String uuid){
        String patron = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(uuid);
        if (!matcher.matches()) {
            return -21;
        }
        return 0;
    }


    public static String getErrorMessage(int errorCode, int minLength, int maxLenght ) {
        switch (errorCode) {
            case -1:
                return " no puede dejarse en blanco.";
            case -2:
                return " tiene que tener al menos " + minLength + " caracteres.";
            case -10:
                return " no puede tener más de " + maxLenght +" caracteres.";
            case -13:
                return " tiene que contener al menos 4 minusculas, 3 numeros, 1 mayúscula y 1 carácter especial.";
            case -14:
                return " el formato no es correcto (ejemplo@ejemplo.com).";
            case -15: 
                return " el formato no es correcto, deberían de ser 9 digitos.";
            case -16: 
                return " debe de empezar con Calle/Avenida/etc, luego el nombre, un numero de edificio como mínimo.";
            case -17:
                return " no cumple con el formato estándar de 5 dígitos numéricos.";
            case -18, -19, -20:
                return " el formato no es correcto, solo acepta letras y la primera tiene que ser mayúscula.";
            case -21:
                return " el formato no es correcto, deberian de ser 36 caracteres incluyendo los guiones.";
            default:
                return " Error desconocido.";
        }
    }

    public static String getErrorMessage(int errorCode, double minLength, double maxLenght ) {
        switch (errorCode) {
            case -3:
                return " no puede ser 0.";
            case -4:
                return " no pueden ser numeros negativos";
            case -5:
                return " lo máximo permitido es " + maxLenght + ".";
            case -7:
                return " lo minimo permitido es " + minLength + ".";
            default:
                return " Error desconocido."; 
        
            }  
        }
}

