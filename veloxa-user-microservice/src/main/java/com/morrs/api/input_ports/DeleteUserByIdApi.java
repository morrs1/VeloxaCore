package com.morrs.api.input_ports;

import com.morrs.domain.entities.User;

import java.util.UUID;

@FunctionalInterface
public interface DeleteUserByIdApi {

    User deleteUserById(UUID id);

}
