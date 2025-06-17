package com.morrs.api.input_ports;

import com.morrs.domain.entities.User;

import java.util.List;

@FunctionalInterface
public interface FindAllUsersApi {

    List<User> findAllUsers();

}
