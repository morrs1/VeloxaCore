package com.morrs.api.adapters.springweb_controllers;

import com.morrs.api.FindUserByIdApi;
import com.morrs.domain.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class FindUserByIdController {

    private final FindUserByIdApi findUserByIdApi;


    public FindUserByIdController(FindUserByIdApi findUserByIdApi) {
        this.findUserByIdApi = findUserByIdApi;
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(findUserByIdApi.findUserById(id));
    }

}
