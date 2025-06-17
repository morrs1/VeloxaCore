package com.morrs.api.adapters.springweb_controllers;

import com.morrs.api.input_ports.FindAllUsersApi;
import com.morrs.api.mappers.UserMapper;
import com.morrs.api.presentation.UserPresentation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindAllUsersController {

    private final FindAllUsersApi findAllUsersApi;
    private final UserMapper userMapper;


    public FindAllUsersController(FindAllUsersApi findAllUsersApi, UserMapper userMapper) {
        this.findAllUsersApi = findAllUsersApi;
        this.userMapper = userMapper;
    }


    @GetMapping("api/user")
    public ResponseEntity<List<UserPresentation>> findAllUsers() {
        return ResponseEntity.ok(findAllUsersApi.findAllUsers().stream().map(userMapper::toUserPresentation).toList());
    }
}
