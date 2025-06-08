package com.lakhan.user_service.service;

import com.techlakhan.common.dto.UserDTO;

public interface UserService {

    UserDTO getUserDtoByUsername(String username);

}
