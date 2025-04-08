package com.example.sharedkernel.domainservices.validations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.example.Exceptions.GeneralDateTimeException;

<<<<<<< HEAD
public class DataCheck {

    /**
     * Verifica que el DNI no sea nulo y tenga 9 caracteres.
     */
=======

public class DataCheck {
>>>>>>> dev_alex
    public static int checkDNI(String dni) {
        if (dni == null || dni.trim().length() != 9) {
            return -1;
        }
        return 0;
    }
<<<<<<< HEAD

    /**
     * Verifica que el email no sea nulo y tenga más de 20 caracteres.
     */
    public static int checkEmail(String email) {
        if (email == null || email.trim().length() <= 20) {
=======
    
    public static int checkEmail (String em){
        if (em == null || em.trim().length() <= 20) {
>>>>>>> dev_alex
            return -1;
        }
        return 0;
    }
<<<<<<< HEAD

    /**
     * Verifica que una cadena no sea nula y tenga longitud mínima.
     */
    public static int checkString(String s, int min) {
=======
    
    public static int checkString(String s, int min){
>>>>>>> dev_alex
        if (s == null || s.trim().length() < min) {
            return -1;
        }
        return 0;
    }
<<<<<<< HEAD

    /**
     * Verifica que un número entero sea igual o mayor al mínimo.
     */
    public static int checkNumber(int value, int min) {
=======
    
    public static int checkNumber(int value, int min){
        if (value < min) {
            return -1;
        }
        return 0;
    }
    
    public static int checkNumber(double value, double min){
>>>>>>> dev_alex
        if (value < min) {
            return -1;
        }
        return 0;
    }

<<<<<<< HEAD
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
=======
    public static LocalDateTime convertStringToDateTime(String s, DateTimeFormatter formatter) throws GeneralDateTimeException {        
        try {
            return LocalDateTime.parse(s, formatter);
        } catch (NullPointerException e ) {
            throw new GeneralDateTimeException ("HEMOS RECIBIDO UN NULL EN LUGAR DE UNA FECHA");
        } catch (DateTimeParseException e) {
            throw new GeneralDateTimeException ("ERROR AL PARSEAR FECHA: " + e.getMessage());
        } catch (Exception e) {
            throw new GeneralDateTimeException ("ERROR INESPERADO: " + e);
        } 
    }
    
    public static LocalDate convertStringToDate(String s, DateTimeFormatter formatter) throws GeneralDateTimeException {        
        try {
            return LocalDate.parse(s, formatter);
        } catch (NullPointerException e ) {
            throw new GeneralDateTimeException ("HEMOS RECIBIDO UN NULL EN LUGAR DE UNA FECHA");
        } catch (DateTimeParseException e) {
            throw new GeneralDateTimeException ("ERROR AL PARSEAR FECHA: " + e.getMessage());
        } catch (Exception e) {
            throw new GeneralDateTimeException ("ERROR INESPERADO: " + e);
        } 
>>>>>>> dev_alex
    }
}
