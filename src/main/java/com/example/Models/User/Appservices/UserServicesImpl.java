package com.example.Models.User.Appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.Exceptions.BuildException;
import com.example.Exceptions.ServiceException;
import com.example.Models.User.DTO.UserDTO;
import com.example.Models.User.MAPPER.UserMapper;
import com.example.Models.User.Persistence.UserRepository;
import com.example.sharedkernel.appservices.serializers.Serializer;
import com.example.sharedkernel.appservices.serializers.Serializers;
import com.example.sharedkernel.appservices.serializers.SerializersCatalog;

@Controller
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;
    private Serializer<UserDTO> serializer;

    protected UserDTO getDTO(String user_id)  {
        return userRepository.findById(user_id).orElse(null );
    }

    protected UserDTO getById(String user_id) throws ServiceException {
        UserDTO bdto = this.getDTO(user_id);

        if ( bdto == null ) {
            throw new ServiceException("user " + user_id + " not found");
        }
        return bdto;
    }
    
    protected UserDTO checkInputData(String user) throws ServiceException {
        try {
            UserDTO bdto = (UserDTO) this.serializer.deserialize(user, UserDTO.class);
            UserMapper.userFromDTO(bdto);
            return bdto;
        } catch (BuildException e) {
            throw new ServiceException("error in the input user data: " + e.getMessage());
        }
    }

    protected UserDTO newUser(String user) throws ServiceException {
        UserDTO bdto = this.checkInputData(user);
          
        if (this.getDTO(bdto.getUserId()) == null) {
            return userRepository.save(bdto);
        } 
        throw new ServiceException("user " + bdto.getUserId() + " already exists");
    }

    protected UserDTO updateUser(String user) throws ServiceException {
        try {
            UserDTO bdto = this.checkInputData(user);
            this.getById(bdto.getUserId());
            return userRepository.save(bdto);
        } catch (ServiceException e) {
            throw e;
        }
    }

    @Override
    public String getByIdToJson(String userId) throws ServiceException {
        return SerializersCatalog.getInstance(Serializers.USER_JSON)
                .serialize(this.getById(userId));
    }

    @Override
    public String addFromJson(String user) throws ServiceException {
        this.serializer = SerializersCatalog.getInstance(Serializers.USER_JSON);
        return serializer.serialize(this.newUser(user));
    }

    @Override
    public String updateOneFromJson(String user) throws ServiceException {
        this.serializer = SerializersCatalog.getInstance(Serializers.USER_JSON);
        return serializer.serialize(this.updateUser(user));
    }

    @Override
    public void deleteById(String userId) throws ServiceException {
        try {
            this.getById(userId);
            userRepository.deleteById(userId);
        } catch (ServiceException e) {
            throw e;
        }
    }
}
