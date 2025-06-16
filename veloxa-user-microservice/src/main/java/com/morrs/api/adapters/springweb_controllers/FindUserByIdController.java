package com.morrs.api.adapters.springweb_controllers;

import com.morrs.api.input_ports.FindUserByIdApi;
import com.morrs.api.mappers.UserMapper;
import com.morrs.api.presentation.UserPresentation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class FindUserByIdController {

    private final FindUserByIdApi findUserByIdApi;
    private final UserMapper userMapper;


    public FindUserByIdController(FindUserByIdApi findUserByIdApi, UserMapper userMapper) {
        this.findUserByIdApi = findUserByIdApi;
        this.userMapper = userMapper;
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<UserPresentation> findUserById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(userMapper.toUserPresentation(findUserByIdApi.findUserById(id)));
    }

}
