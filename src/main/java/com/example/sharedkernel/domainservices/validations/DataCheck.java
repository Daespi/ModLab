package com.example.sharedkernel.domainservices.validations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.example.Exceptions.GeneralDateTimeException;
public class DataCheck {

    /**
     * Verifica que el DNI no sea nulo y tenga 9 caracteres.
     */

    public static int checkDNI(String dni) {
        if (dni == null || dni.trim().length() != 9) {
            return -1;
        }
        return 0;
    }

    /**
     * Verifica que el email no sea nulo y tenga más de 20 caracteres.
     */
    public static int checkEmail(String email) {
        if (email == null || email.trim().length() <= 20) {

            return -1;
        }
        return 0;
    }

    /**
     * Verifica que una cadena no sea nula y tenga longitud mínima.
     */
    public static int checkString(String s, int min) {
        if (s == null || s.trim().length() < min) {
            return -1;
        }
        return 0;
    }

    /**
     * Verifica que un número entero sea igual o mayor al mínimo.
     */
    public static int checkNumber(int value, int min) {

        if (value < min) {
            return -1;
        }
        return 0;
    }
    /**
     * Verifica que un número decimal sea igual o mayor al mínimo.
     */
    public static int checkNumber(double value, double min) {
        if (value < min) {
            return -1;
        }
        return 0;
    }

    /**
     * Convierte un String a LocalDateTime usando el patrón indicado.
     * 
     * @throws GeneralDateTimeException si hay error en el formato
     */
    public static LocalDateTime convertStringToDateTime(String dateStr, DateTimeFormatter formatter) throws GeneralDateTimeException {
        try {
            return LocalDateTime.parse(dateStr, formatter);
        } catch (NullPointerException e) {
            throw new GeneralDateTimeException("Hemos recibido un valor nulo en lugar de una fecha y hora.");
        } catch (DateTimeParseException e) {
            throw new GeneralDateTimeException("Error al parsear la fecha y hora: " + e.getMessage());
        } catch (Exception e) {
            throw new GeneralDateTimeException("Error inesperado al procesar la fecha y hora: " + e);
        }
    }

    /**
     * Convierte un String a LocalDate usando el patrón indicado.
     * 
     * @throws GeneralDateTimeException si hay error en el formato
     */
    public static LocalDate convertStringToDate(String dateStr, DateTimeFormatter formatter) throws GeneralDateTimeException {
        try {
            return LocalDate.parse(dateStr, formatter);
        } catch (NullPointerException e) {
            throw new GeneralDateTimeException("Hemos recibido un valor nulo en lugar de una fecha.");
        } catch (DateTimeParseException e) {
            throw new GeneralDateTimeException("Error al parsear la fecha: " + e.getMessage());
        } catch (Exception e) {
            throw new GeneralDateTimeException("Error inesperado al procesar la fecha: " + e);
        }
    }
}
