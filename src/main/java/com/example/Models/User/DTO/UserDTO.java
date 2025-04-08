package com.example.Models.User.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user", schema = "modlab")
public class UserDTO {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "role", nullable = false)
    private boolean role;

    // 👇 Constructor vacío requerido por JPA
    public UserDTO() {}

    // 👇 Constructor completo para instanciación manual
    public UserDTO(String userId, String firstName, String lastName, String username,
                   String passwordHash, String email, String phone,
                   LocalDateTime createdAt, boolean role) {
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

    public String getUserId() { return userId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getUsername() { return username; }
    public String getPasswordHash() { return passwordHash; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    public String getCreatedAt() {
        return createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public boolean getRoleName() { return role; }

    @Override
    public String toString() {
        return "UserDTO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName +
                ", username=" + username + ", passwordHash=" + passwordHash + ", email=" + email +
                ", phone=" + phone + ", createdAt=" + getCreatedAt() + ", role=" + role + "]";
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> dev_alex
