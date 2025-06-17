package com.morrs.spi.output_ports;

import com.morrs.domain.entities.User;

import java.util.Optional;

@FunctionalInterface
public interface UpdateUserInfoSpi {

    Optional<User> updateUser(User user);

}
