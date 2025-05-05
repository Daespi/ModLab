package com.example.Models.User.Appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.Exceptions.BuildException;
import com.example.Exceptions.ServiceException;
import com.example.Models.User.DTO.UserDTO;
import com.example.Models.User.Entity.User;
import com.example.Models.User.MAPPER.UserMapper;
import com.example.Models.User.Persistence.UserRepository;
import com.example.sharedkernel.appservices.serializers.Serializer;
import com.example.sharedkernel.appservices.serializers.Serializers;
import com.example.sharedkernel.appservices.serializers.SerializersCatalog;

import java.time.LocalDateTime;

@Controller
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    private Serializer<UserDTO> serializer;

    protected UserDTO getDTO(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    protected UserDTO getById(String userId) throws ServiceException {
        UserDTO dto = this.getDTO(userId);
        if (dto == null) {
            throw new ServiceException("User " + userId + " not found");
        }
        return dto;
    }

    protected UserDTO checkInputData(String json) throws ServiceException {
        try {
            UserDTO dto = this.serializer.deserialize(json, UserDTO.class);
            UserMapper.userFromDTO(dto); // Validación de negocio
            return dto;
        } catch (BuildException e) {
            throw new ServiceException("Error in user input: " + e.getMessage());
        }
    }

    protected UserDTO newUser(String json) throws ServiceException {
        try {
            UserDTO dto = this.checkInputData(json); // ya deserializa
            User user = UserMapper.userFromDTO(dto); // puede lanzar BuildException
            UserDTO userDTO = UserMapper.dtoFromUser(user);
    
            // Si el ID no está presente, se trata de una creación
            if (userDTO.getUserId() == null || userDTO.getUserId().isBlank()) {
                if (userDTO.getCreatedAt() == null) {
                    userDTO.setCreatedAt(LocalDateTime.now());
                }
                return userRepository.save(userDTO);
            }
    
            // Si ya tiene ID, asegúrate de que no exista
            if (this.getDTO(userDTO.getUserId()) == null) {
                return userRepository.save(userDTO);
            }
    
            throw new ServiceException("User " + dto.getUserId() + " already exists");
    
        } catch (BuildException e) {
            throw new ServiceException("Error creating User: " + e.getMessage());
        }
    }
    
    

    protected UserDTO updateUser(String json) throws ServiceException {
        UserDTO dto = this.checkInputData(json);
        this.getById(dto.getUserId());
        return userRepository.save(dto);
    }

    @Override
    public String getByIdToJson(String userId) throws ServiceException {
        return SerializersCatalog.getInstance(Serializers.USER_JSON)
                .serialize(this.getById(userId));
    }

    @Override
    public String addFromJson(String userJson) throws ServiceException {
        this.serializer = SerializersCatalog.getInstance(Serializers.USER_JSON);
        return serializer.serialize(this.newUser(userJson));
    }

    @Override
    public String updateOneFromJson(String userJson) throws ServiceException {
        this.serializer = SerializersCatalog.getInstance(Serializers.USER_JSON);
        return serializer.serialize(this.updateUser(userJson));
    }

    @Override
    public void deleteById(String userId) throws ServiceException {
        this.getById(userId);
        userRepository.deleteById(userId);
    }
}



// package com.example.Models.User.Appservices;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;

// import com.example.Exceptions.BuildException;
// import com.example.Exceptions.ServiceException;
// import com.example.Models.User.DTO.UserDTO;
// import com.example.Models.User.MAPPER.UserMapper;
// import com.example.Models.User.Persistence.UserRepository;
// import com.example.sharedkernel.appservices.serializers.Serializer;
// import com.example.sharedkernel.appservices.serializers.Serializers;
// import com.example.sharedkernel.appservices.serializers.SerializersCatalog;

// @Controller
// public class UserServicesImpl implements UserServices {

//     @Autowired
//     private UserRepository userRepository;

//     private Serializer<UserDTO> serializer;

//     protected UserDTO getDTO(String userId) {
//         return userRepository.findById(userId).orElse(null);
//     }

//     protected UserDTO getById(String userId) throws ServiceException {
//         UserDTO dto = this.getDTO(userId);
//         if (dto == null) {
//             throw new ServiceException("User " + userId + " not found");
//         }
//         return dto;
//     }

//     protected UserDTO checkInputData(String json) throws ServiceException {
//         try {
//             UserDTO dto = this.serializer.deserialize(json, UserDTO.class);
//             UserMapper.userFromDTO(dto); // Validación de negocio
//             return dto;
//         } catch (BuildException e) {
//             throw new ServiceException("Error in user input: " + e.getMessage());
//         }
//     }

//     protected UserDTO newUser(String json) throws ServiceException {
//         UserDTO dto = this.checkInputData(json);
//         if (this.getDTO(dto.getUserId()) == null) {
//             return userRepository.save(dto);
//         }
//         throw new ServiceException("User " + dto.getUserId() + " already exists");
//     }

//     protected UserDTO updateUser(String json) throws ServiceException {
//         UserDTO dto = this.checkInputData(json);
//         this.getById(dto.getUserId());
//         return userRepository.save(dto);
//     }

//     @Override
//     public String getByIdToJson(String userId) throws ServiceException {
//         return SerializersCatalog.getInstance(Serializers.USER_JSON)
//                 .serialize(this.getById(userId));
//     }

//     @Override
//     public String addFromJson(String userJson) throws ServiceException {
//         this.serializer = SerializersCatalog.getInstance(Serializers.USER_JSON);
//         return serializer.serialize(this.newUser(userJson));
//     }

//     @Override
//     public String updateOneFromJson(String userJson) throws ServiceException {
//         this.serializer = SerializersCatalog.getInstance(Serializers.USER_JSON);
//         return serializer.serialize(this.updateUser(userJson));
//     }

//     @Override
//     public void deleteById(String userId) throws ServiceException {
//         this.getById(userId);
//         userRepository.deleteById(userId);
//     }

// }
