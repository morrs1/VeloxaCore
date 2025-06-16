package com.morrs.api.input_ports;

import com.morrs.domain.entities.User;

import java.util.UUID;

@FunctionalInterface
public interface FindUserByIdApi {

    User findUserById(UUID id);
}
