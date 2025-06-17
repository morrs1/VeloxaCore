package com.morrs.api.input_ports;

import com.morrs.domain.entities.User;

@FunctionalInterface
public interface CreateUserApi {

    User createUser(User user);

}
