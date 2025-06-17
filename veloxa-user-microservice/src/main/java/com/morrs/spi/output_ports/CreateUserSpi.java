package com.morrs.spi.output_ports;

import com.morrs.domain.entities.User;

@FunctionalInterface
public interface CreateUserSpi {

    User createUser(User user);

}
