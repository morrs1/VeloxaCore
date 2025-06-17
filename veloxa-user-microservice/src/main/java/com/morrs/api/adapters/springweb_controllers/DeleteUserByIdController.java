package com.morrs.api.adapters.springweb_controllers;

import com.morrs.api.input_ports.DeleteUserByIdApi;
import com.morrs.api.mappers.UserMapper;
import com.morrs.api.presentation.UserPresentation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DeleteUserByIdController {

    private final DeleteUserByIdApi deleteUserByIdApi;
    private final UserMapper userMapper;

    public DeleteUserByIdController(DeleteUserByIdApi deleteUserByIdApi, UserMapper userMapper) {
        this.deleteUserByIdApi = deleteUserByIdApi;
        this.userMapper = userMapper;
    }

    @DeleteMapping("api/user/{id}")
    public ResponseEntity<UserPresentation> deleteUserById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(userMapper.toUserPresentation(deleteUserByIdApi.deleteUserById(id)));
    }
}
