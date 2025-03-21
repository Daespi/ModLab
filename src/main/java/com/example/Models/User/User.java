package com.example.Models.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;

import com.example.Operations.Checker;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.Exceptions.BuildException;

public class User {
    protected String userId;
    protected String username;
    protected String firstName;
    protected String lastName;
    protected String passwordHash;
    protected String email;
    protected String phone;
    protected LocalDateTime createdAt;
    protected boolean roleName;
    protected ArrayList<ShippingAddress> shippingAddresses;

    protected User(){
        this.shippingAddresses = new ArrayList<ShippingAddress>();
    }

    public static User getInstance(String userId, String username, String firstName, String lastName,
            String passwordHash, String email, String phone, String createdAt, boolean roleName) throws BuildException {
        String message = "";

        User user = new User();

        if ((user.setUserId(userId) != 0)) {
            message += "El user id no se ha creado correctamente, ";
        }

        if ((user.setUserId(username) != 0)) {
            message += "El username no es correcto, ";
        }

        if ((user.setFirstName(firstName) != 0)) {
            message += "El nombre no es correcto, ";
        }

        if ((user.setLastName(lastName) != 0)) {
            message += "El apellido no es correcto, ";
        }

        if ((user.setPasswordHash(passwordHash) != 0)) {
            message += "La contraseña no es correcta, ";
        }

        if ((user.setEmail(email) != 0)) {
            message += "El mail no es correcto, ";
        }

        if ((user.setPhone(phone) != 0)) {
            message += "El numero de telefono no es correcto, ";
        }

        if ((user.setCreatedAt(createdAt) != 0)) {
            message += "La fecha de creacion del usuario no es correcto, ";
        }

        if ((user.setRoleName(roleName) != 0)) {
            message += "El rol del usuario no es correcto, ";
        }

        if ((user.setShippingAddresses(shippingAddresses) != 0)){
            message += "El rol del usuario no es correcto, ";
        }

        if (message.length() > 0) {
            user = null;
            throw new BuildException(message);
        }
        return user;
    }

    public String getUserId() {
        return userId;
    }

    public int setUserId(String userId) {
        if ((Checker.needsToBeNull(username)) != 0)
            return -21;
        String result = "";
        result = java.util.UUID.randomUUID().toString();
        result.replace("-", "");
        result.substring(0, 32);
        this.userId = result;
        return 0;
    }

    public String getUsername() {
        return username;
    }

    public int setUsername(String username) {
        if ((Checker.isNull(username)) != 0)
            return -1;
        if ((Checker.minLength(3, username)) != 0)
            return -2;
        if ((Checker.maxLenght(30, username)) != 0)
            return -10;
        this.username = username;
        return 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public int setFirstName(String firstName) {
        if ((Checker.isNull(firstName)) != 0)
            return -1;
        if ((Checker.minLength(3, firstName)) != 0)
            return -2;
        if ((Checker.maxLenght(30, firstName)) != 0)
            return -10;
        this.firstName = firstName;
        return 0;
    }

    public String getLastName() {
        return lastName;
    }

    public int setLastName(String lastName) {
        if ((Checker.isNull(lastName)) != 0)
            return -1;
        if ((Checker.minLength(4, lastName)) != 0)
            return -2;
        if ((Checker.maxLenght(60, lastName)) != 0)
            return -10;
        this.lastName = lastName;
        return 0;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public int setPasswordHash(String passwordHash) throws BuildException {
        if ((Checker.isNull(passwordHash)) != 0)
            return -1;
        if ((Checker.verifyPassword(passwordHash)) != 0)
            return -12;
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(passwordHash);
        this.passwordHash = hashedPassword;
        return 0;
    }

    public String getEmail() {
        return email;
    }

    public int setEmail(String email) {
        if ((Checker.isNull(email)) != 0)
            return -1;
        if ((Checker.verifyMail(email) != 0))
            return -22;
        this.email = email;
        return 0;
    }

    public String getPhone() {
        return phone;
    }

    public int setPhone(String phone) {
        if ((Checker.isNull(phone)) != 0)
            return -3;
        if ((Checker.minLength(7, phone)) != 0)
            return -5;
        if ((Checker.maxLenght(10, phone)) != 0)
            return -6;
        if ((Checker.verifyPhone(phone) != 0))
            return -15;
        this.phone = phone;
        return 0;
    }

    public String getCreatedAt() {
        return createdAt.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    public int setCreatedAt(String createdAt) {
        try {
            this.createdAt = Checker.checkDateAndTime(createdAt);
        } catch (BuildException ex) {
            return -22;
        }
        return 0;
    }

    public int setShippingAddresses(ArrayList<ShippingAddress> newShippingAddresses) throws BuildException {
        for (ShippingAddress newAddress : newShippingAddresses) {

            for (ShippingAddress existingAddress : shippingAddresses) {
                if (existingAddress.getAddressId() == newAddress.getAddressId()) {
                    throw new BuildException("El ID de dirección " + newAddress.getAddressId() + " ya existe");
                }
            }

            try {
                shippingAddresses.add(newAddress);
            } catch (Exception ex) {
                throw new BuildException("Ha habido algún error al crear la dirección");
            }
        }
        return 0;
    }

    public int setShippingAddresses(int addressId, String address, String zipCode, 
        String city, String state, String country) throws BuildException{

        for (ShippingAddress input : shippingAddresses ){
            if (input.getAddressId() == addressId) {
                throw new BuildException ("Este id de adress ya existe");
            }
        }

        ShippingAddress newAdress = ShippingAddress.getInstance(addressId, address, zipCode, city, state, country);
        shippingAddresses.add(newAdress);
        return 0; 
        
    }

    public boolean isRoleName() {
        return roleName;
    }

    public int setRoleName(boolean roleName) {
        this.roleName = roleName;
        return 0;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", firstName=" + firstName + ", lastName="
                + lastName + ", passwordHash=" + passwordHash + ", email=" + email + ", phone=" + phone + ", createdAt="
                + createdAt + ", roleName=" + roleName + ", address=" + shippingAddresses + "]";
    }

}
