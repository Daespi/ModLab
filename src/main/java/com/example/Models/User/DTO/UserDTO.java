package com.example.Models.User.DTO;

public class UserDTO {

    private final String userId;
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String passwordHash;
    private final String email;
    private final String phone;
    private final String createdAt;
    private final boolean role;

    public UserDTO(String userId, String firstName, String lastName, String username,
                   String passwordHash, String email, String phone,
                   String createdAt, boolean role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public boolean getRoleName() {
        return role;
    }
}
