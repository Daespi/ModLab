package com.example.Models.User.Entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.Exceptions.BuildException;
import com.example.Models.ShippingAddress.Entity.ShippingAddress;
import com.example.Operations.Checker;

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
        shippingAddresses = new ArrayList<>();
    }

    public static User getInstance( String username, String firstName, String lastName,
            String passwordHash, String email, String phone, boolean roleName) throws BuildException {
        String message = "";

        User user = new User();

        String uuid = java.util.UUID.randomUUID().toString();
        uuid.replace("-", "");
        uuid.substring(0, 32);
        user.userId = uuid;


        int resultUsername = user.setUsername(username);
        if (resultUsername != 0) {
            message += "El username no es correcto porque" + Checker.getErrorMessage(resultUsername, 3, 30);
        }

        int result = user.setFirstName(firstName);
        if (result != 0) {
            message += "El nombre no es correcto porque" + Checker.getErrorMessage(result, 3, 15);
        }


        int resultLastName = user.setLastName(lastName);
        if (resultLastName != 0) {
            message += "El apellido es correcto porque" + Checker.getErrorMessage(resultLastName, 4, 60);
        }

        int resultPassword = user.setPasswordHash(passwordHash);
        if (resultPassword != 0) {
            message += "La contraseña no es correcta porque" + Checker.getErrorMessage(resultPassword, 0, 0);
        }

        int resultPhone = user.setPhone(phone);
        if (resultPhone != 0) {
            message += "El teléfono no es correcto porque" + Checker.getErrorMessage(resultPhone, 0, 0);
        }

        int resultEmail = user.setEmail(email);
        if (resultEmail != 0) {
            message += "El mail no es correcto porque" + Checker.getErrorMessage(resultEmail, 0, 0);
        }


        user.createdAt = LocalDateTime.now();
        

        if ((user.setRoleName(roleName) != 0)) {
            message += "El rol del usuario no es correcto.";
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
        if ((Checker.maxLenght(15, firstName)) != 0)
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

    public int setPasswordHash(String passwordHash) {
        if ((Checker.isNull(passwordHash)) != 0)
            return -1;
        if ((Checker.verifyPassword(passwordHash)) != 0)
            return -13;
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
            return -14;
        this.email = email;
        return 0;
    }

    public String getPhone() {
        return phone;
    }

    public int setPhone(String phone) {
        if ((Checker.isNull(phone)) != 0)
            return -3;
        if ((Checker.verifyPhone(phone) != 0))
            return -15;
        this.phone = phone;
        return 0;
    }

    public String getCreatedAt() {
        return createdAt.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    public ArrayList<ShippingAddress> getShippingAddresses() {
        return shippingAddresses;
    }

    public String setShippingAddresses(String address, String zipCode, 
        String city, String state, String country) throws BuildException{

        try{
            shippingAddresses.add(ShippingAddress.getInstance(address, zipCode, city, state, country));
        } catch (BuildException ex){
            return ex.getMessage();
        }
        
        return ""; 
        
    }

    public boolean getRoleName() {
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
                + createdAt + ", roleName=" + roleName + ", shippingAddresses=" + shippingAddresses + "]";
    }

    

}
