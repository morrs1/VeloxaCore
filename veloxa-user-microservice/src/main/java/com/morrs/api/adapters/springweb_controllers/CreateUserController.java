package com.morrs.api.adapters.springweb_controllers;

import com.morrs.api.input_ports.CreateUserApi;
import com.morrs.api.mappers.UserMapper;
import com.morrs.api.presentation.UserPresentation;
import com.morrs.api.presentation.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateUserController {

    private final CreateUserApi createUserApi;
    private final UserMapper userMapper;

    public CreateUserController(CreateUserApi createUserApi, UserMapper userMapper) {
        this.createUserApi = createUserApi;
        this.userMapper = userMapper;
    }

    @PostMapping("/api/user")
    public ResponseEntity<UserPresentation> createUser(@RequestBody UserRequest user) {
        return ResponseEntity.ok(userMapper.toUserPresentation(createUserApi.createUser(userMapper.toUserFromUserRequest(user))));
    }
}
