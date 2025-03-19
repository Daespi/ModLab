package com.example.Models.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import com.example.Operations.Checker;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
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
    protected ArrayList<Address> address;

    public static Client getInstance(String user_id, String username, String firstName, String lastName,
            String passwordHash, String email, String phone, String createdAt, String roleName) throws BuildException {
        String message = "";

        Client client = new Client();

        if (message.length() > 0) {
            client = null;
            throw new BuildException(message);
        }
        return client;
    }

    public String getUserId() {
        return userId;
    }

    public int setUserId(String userId) throws BuildException {
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
        if ((Checker.isNull(username)) != 0)
            return -1;
        if ((Checker.minLength(3, username)) != 0)
            return -2;
        if ((Checker.maxLenght(30, username)) != 0)
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
        if ((Checker.minLength(8, phone)) != 0)
            return -5;
        if ((Checker.maxLenght(13, phone)) != 0)
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

    public ArrayList<Address> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<Address> address) {
        this.address = address;
    }

    public boolean isRoleName() {
        return roleName;
    }

    public int setRoleName(boolean roleName) {
        if ((Checker.isNull(roleName)) != 0)
            return -1;
        this.roleName = roleName;
        return 0;
    }

}
