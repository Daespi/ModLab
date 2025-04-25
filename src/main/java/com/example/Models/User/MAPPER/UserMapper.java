package com.example.Models.User.MAPPER;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.Exceptions.BuildException;
import com.example.Models.User.DTO.UserDTO;
import com.example.Models.User.Entity.User;

public class UserMapper {

    public static User userFromDTO(UserDTO dto) throws BuildException {
        return User.getInstance(
                dto.getUsername(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getPasswordHash(),
                dto.getEmail(),
                dto.getPhone(),
                dto.getRoleName()
        );
    }

    public static UserDTO dtoFromUser(User user) {
        // Parseamos el string de createdAt (viene en formato dd-MM-yyyy HH:mm:ss) a LocalDateTime
        LocalDateTime createdAt = LocalDateTime.parse(
                user.getCreatedAt(), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        );

        return new UserDTO(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getPasswordHash(),
                user.getEmail(),
                user.getPhone(),
                createdAt,
                user.getRoleName()
        );
    }
}

