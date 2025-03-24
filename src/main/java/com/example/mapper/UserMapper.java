package com.example.mapper;

import com.example.dto.UserDTO;
import com.example.Models.User.User;
import com.example.Exceptions.BuildException;

public class UserMapper {

    public static User userFromDTO(UserDTO dto) throws BuildException {
        return User.getInstance(
                dto.getUserId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getUsername(),
                dto.getPasswordHash(),
                dto.getEmail(),
                dto.getPhone(),
                dto.getCreatedAt(),
                dto.getRoleName()
        );
    }

    public static UserDTO dtoFromUser(User user) {
        return new UserDTO(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getPasswordHash(),
                user.getEmail(),
                user.getPhone(),
                user.getCreatedAt(),
                user.getRoleName()
        );
    }
}
