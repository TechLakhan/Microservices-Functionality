package com.lakhan.expense_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.techlakhan.common.dto.*;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping(value = "/user/username/{username}")
    UserDTO getUserByUsername(@PathVariable String username);
}
