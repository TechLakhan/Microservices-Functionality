package com.lakhan.user_service.service.impl;

import com.lakhan.user_service.model.User;
import com.lakhan.user_service.repository.UserRepository;
import com.lakhan.user_service.service.UserService;
import com.techlakhan.common.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDTO getUserDtoByUsername(String username) {
        User user = userRepository.findByUsername(username);
        System.out.println("Checking username in DB " + username);
        if (user == null) {
            return null; // or throw a custom exception
        }
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        // map other fields as needed
        return dto;
    }
}
